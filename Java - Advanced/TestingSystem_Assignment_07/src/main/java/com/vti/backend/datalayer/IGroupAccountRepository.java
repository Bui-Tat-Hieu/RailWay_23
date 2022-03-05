package com.vti.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.GroupAccount;
import com.vti.entity.GroupAccount.GroupAccountPK;

public interface IGroupAccountRepository extends JpaRepository<GroupAccount, GroupAccountPK> {

}
