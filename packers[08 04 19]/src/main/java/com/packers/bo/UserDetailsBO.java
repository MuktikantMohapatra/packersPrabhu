package com.packers.bo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.packers.service.SecurityUser;

@Entity(name = "USER_DETAILS")
public class UserDetailsBO {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	private String id;
	@Column
	private String name;
	@Column
	private String email;
	@Column(name = "PHONE")
	private Long number;
	@Column
	private String password;
	private String role;
	/*@ManyToMany
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "ROLE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_ID") })
	private Set<RolesBO> user_role;*/

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*public Set<RolesBO> getRole() {
		return user_role;
	}

	public void setRole(Set<RolesBO> role) {
		this.user_role = role;
	}*/

	public UserDetails toSecurityUser() {
		return SecurityUser.create(this);
	}

	@Override
	public String toString() {
		return "UserDetailsBO [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + ", password="
				+ password + "]";
	}

	public Collection<? extends GrantedAuthority> getAuthoritites() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();

        list.add(new SimpleGrantedAuthority(role));

        return list;
        
	}

}
