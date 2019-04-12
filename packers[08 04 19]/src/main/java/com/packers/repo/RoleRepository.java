package com.packers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.packers.bo.RolesBO;
@Repository
public interface RoleRepository extends JpaRepository<RolesBO, String> {

}
