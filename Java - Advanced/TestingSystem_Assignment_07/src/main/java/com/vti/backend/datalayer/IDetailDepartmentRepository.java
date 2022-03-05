package com.vti.backend.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.DetailDepartment;

public interface IDetailDepartmentRepository extends JpaRepository<DetailDepartment, Short> {

}
