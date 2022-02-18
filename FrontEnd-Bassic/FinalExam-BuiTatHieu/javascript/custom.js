// const
const tableHeader = "<table><tr><th style='width: 5%'></th><th style='width: 5%'>STT</th><th style='width: 25%'>Group Name</th><th style='width: 20%'>Member</th><th style='width: 25%'>Creator</th><th style='width: 20%'>Create Date</th></tr>";
const apiUrl = "https://61f2bc592219930017f5088c.mockapi.io/api/v1/Group";
const sysErrMsg = "Đã xảy ra lỗi, vui lòng kiểm tra lại!";
const duplicateErrMsg = "Tên Group đã tồn tại!";

// set tên nội dung
$("#contentName").text("List Group");

// ẩn phần chi tiết
$("#detail").hide();

// lấy dữ liệu
getList();

// hàm lấy dữ liệu
function getList(){    
    $("#list").show();
    $("#detail").hide();
    $("#search").val("");
    $("#list-table").html("");
    $.ajax({
        url: apiUrl,
        type: "GET",
        success:function(result){
            var str = "";
            str = str.concat(tableHeader);
            cnt = 0;
            result.forEach(element => {
                cnt++;
                str = str.concat("<tr><td style='text-align: center'><input type='checkbox' name='checkRow' id='", element.id ,"'></td>"
                            ,"<td style='text-align: center'>", cnt ,"</td>"
                            ,"<td><a href='#' class='groupName' onclick='showDetail(", element.id ,")'>", element.GroupName ,"</a></td>"
                            ,"<td style='text-align: center'>", element.Member ,"</td>"
                            ,"<td>", element.Creator.Name == undefined ? '' : element.Creator.Name ,"</td>"
                            ,"<td style='text-align: center'>", element.CreateDate.substring(0, 10) ,"</td>"                        
                            ,"</tr>");
            });
            str.concat("</table>")
            $("#list-table").html(str);
        }
    })
}

// show modal thêm group
function showCreateGroupModal(){
    $("#group-edit-modal").show("slow");
    $("#input-group-name").focus();
    $("#modal-name").text("Create Group");
    $("#group-id").text("");
}

// đóng modal thêm/sửa group
function closeGroupModal(){
    $("#group-edit-modal").hide("slow");
    $("#input-group-name").val("");
    $("#group-id").text("");
    $("#err-info").text("");

}

// show modal sửa group
function showEditGroupModal(id){    
    $("#group-id").text(id);
    $("#modal-name").text("Edit Group");
    $("#group-edit-modal").show("slow");
    $("#input-group-name").focus();
}

// hàm lấy dữ liệu theo id
function searchById(){
    var id = $("#search").val();
    if(id != ""){
        $("#list-table").html("");
        $.ajax({
            url: apiUrl + '/' + id,
            type: 'GET',
            success:function(result){
                var str = "";
                str = str.concat(tableHeader);
                cnt = 1;
                str = str.concat("<tr><td style='text-align: center'><input type='checkbox' name='checkRow' id='", result.id ,"'></td>"
                                ,"<td style='text-align: center'>", cnt ,"</td>"
                                ,"<td><a class='groupName' onclick='showDetail(", result.id ,")'>", result.GroupName ,"</a></td>"
                                ,"<td style='text-align: center'>", result.Member ,"</td>"
                                ,"<td>", result.Creator.Name == undefined ? '' : result.Creator.Name ,"</td>"
                                ,"<td style='text-align: center'>", result.CreateDate.substring(0, 10) ,"</td>"                        
                                ,"</tr>");
                str.concat("</table>")
                $("#list-table").html(str);
            }
        })
    }else{
        getList();
    }
}

// show detail
function showDetail(id){
    $.ajax({
        url: apiUrl + "/" + id, 
        type: 'GET',
        success:function(result){
            $("#groupDetailHeader").html(
                "<h3 id='groupName'>" + result.GroupName + "<i class='far fa-pencil-alt pencil' onclick='showEditGroupModal(" + id + ")'></i>" + "</h3>"
            );
            $("#creatorName").text(result.Creator.Name == undefined ? '' : result.Creator.Name);
            $("#createDate").text(result.CreateDate.substring(0, 10));
            $("#member").text(result.Member);
        }
    })

    $("#list").hide();
    $("#detail").show();
}

// kiểm tra trùng tên group khi thêm/sửa
function checkGroupNameDuplication(groupName){
    var check = true;
    $.ajax({
        async: false,
        url: apiUrl,
        type: 'GET',
        success:function(result){
            result.forEach(element => {
                if(element.GroupName == groupName){
                    check = false;
                }
            });
        }
    })

    return check;
}

// event của btton save
$("#btn-save").click(function(){
    var groupName = $("#input-group-name").val();
    var check = checkGroupNameDuplication(groupName);
    if(check == false){
        $("#err-info").text(duplicateErrMsg);
    }else{
        var id = document.getElementById("group-id").textContent;
        if(id != ""){
            // Update
            editGroup(id, groupName);
        }else{
            // Create
            createGroup(groupName);
        }
    }
});

function saveGroup(){
    var groupName = $("#input-group-name").val();
    var check = checkGroupNameDuplication(groupName);
    if(check == false){
        $("#err-info").text(duplicateErrMsg);
    }else{
        var id = document.getElementById("group-id").textContent;
        if(id != ""){
            // Update
            editGroup(id, groupName);
        }else{
            // Create
            createGroup(groupName);
        }
    }
}

// Thêm group
function createGroup(groupName){
    var now = new Date();
    // khai báo đối tượng
    var group = {
        GroupName: groupName,
        Member: 0,
        Creator: {
            "Name": "Nguyen A",
            "id": "1"
        },
        CreateDate: now.toISOString()
    }

    $.ajax({
        //async: bất đồng bộ
        //sync: đồng bộ/ theo thứ tự
        async: false,
        url: apiUrl,
        type: 'POST',
        contentType:"application/json;charset=utf-8",
        data: JSON.stringify(group),
        success:function(result){
            if(result == undefined || result == null){
                //thất bại
                showInfomation(true, sysErrMsg)
                return;
            }else{
                // thành công
                showInfomation(false, "Thêm Group thành công")
            }
        }
    })
    closeGroupModal();
    getList();
}

// Sửa group
function editGroup(id, groupName){
    // khai báo đối tượng
    var group = {
        GroupName: groupName
    }

    $.ajax({
        async: false,
        url: apiUrl + "/" + id,
        type: 'PUT',
        data: group,
        success:function(result){
            if(result == undefined || result == null){
                showInfomation(true, sysErrMsg)
                return;
            }else{
                showInfomation(false, "Cập nhật Group thành công")
            }
        }
    })

    closeGroupModal();
    $("#list").show();
    $("#detail").hide();
    getList();
}

// show Infomation
function showInfomation(isErr, infoMsg){
    if(isErr){
        $("#info-name").html(
            "<h3 id='ErrorNameInner'><i class='fas fa-times-circle errInfoIcon'></i>Lỗi</h3>"
        );
    }else{
        $("#info-name").html(
            "<h3 id='infoNameInner'><i class='fas fa-check-circle infoIcon'></i>Thông Tin</h3>"
        );
    }
    
    $("#info-content").text(infoMsg);

    $("#info-msg").show();
}

// hide Infomation
function closeInfoMsg(){
    $("#info-name").html(
        "<h3 id='info-name'></h3>"
    );    
    $("#info-content").text("");

    $("#info-msg").hide();
}

// xóa group
function showDelConfirm(){
    if($('input[name="checkRow"]:checked').length == 0){
        showInfomation(true, "Hãy chọn group!")
        return;
    }
    $("#delete-group-modal").show("slow");
}

function closeDeleteGroupModal(){
    $("#delete-group-modal").hide("slow");
}

function deleteGroup(){
    var checkDel = true;
    $('input[name="checkRow"]:checked').each(function() {
        $.ajax({
            async: false,
            url: apiUrl + "/" + this.id,
            type: 'DELETE',
            data: null,
            success:function(result){
                if(result==undefined||result==null){
                    checkDel = false;
                }
            }
        })
    });

    if(checkDel == false){
        showInfomation(true, sysErrMsg)
    }else{
        showInfomation(false, "Xoá group thành công")
    }

    closeDeleteGroupModal();
    getList();
}