package com.packers.dto;

import lombok.Data;

@Data
/*
 * provides getters & setters and constructors at runtime
 */
public class UserDetailsDTO {
	private String id;
	private String name;
	private String email;
	private Long number;
	private String password;
}
