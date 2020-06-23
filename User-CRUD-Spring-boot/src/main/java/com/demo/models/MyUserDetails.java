package com.demo.models;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.Dto.UserDto;

@SuppressWarnings("serial")
public class MyUserDetails implements UserDetails {

	private String usrNm;
	private String pwd;
	private boolean actv;
	private List<GrantedAuthority> Authrty;

	public MyUserDetails() {

	}

	public MyUserDetails(UserDto userDto) {
		this.usrNm = userDto.getUsrNm();
		this.pwd = userDto.getPwd();
		this.actv = true;
		this.Authrty = Arrays.stream(userDto.getRole().toString().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Authrty;
	}

	@Override
	public String getPassword() {

		return pwd;
	}

	@Override
	public String getUsername() {

		return usrNm;
	}

	@Override
	public boolean isAccountNonExpired() {

		return true;
	}

	@Override
	public boolean isAccountNonLocked() {

		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return true;
	}

	@Override
	public boolean isEnabled() {

		return actv;
	}

}
