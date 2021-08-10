package com.test.userdetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.test.model.Role;
import com.test.model.User;

public class MyUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	public MyUserDetails(User user) {
		super();
		this.user=user;
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
	List<Role>roles = user.getRoles();
	
	List<SimpleGrantedAuthority>authorities = new ArrayList<SimpleGrantedAuthority>();
	
	for(Role role:roles) {
		
		//ROLE_ADMIN IF ROLE_ NOT PUT IN VIEW PAGE 
		authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRole()));
		
		//VIEW PAGE ROLE_ADMIN PUT
//		 authorities.add(new SimpleGrantedAuthority(role.getRole()));
		 System.out.println(authorities);
	}
	
	return authorities;
	
		
		// if role in user entity 
//	SimpleGrantedAuthority authority = new SimpleGrantedAuthority(user.getRole());
//		return List.of(authority);
	}
	
	@Override
	public String getPassword() {

		return user.getPassword();
	}

	@Override
	public String getUsername() {
		
		return user.getEmail();
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
		
		return true;
	}

}
