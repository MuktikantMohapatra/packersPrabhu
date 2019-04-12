package com.packers.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.packers.bo.UserDetailsBO;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetailsBO, String> {
	UserDetailsBO findByEmail(String email);
}
