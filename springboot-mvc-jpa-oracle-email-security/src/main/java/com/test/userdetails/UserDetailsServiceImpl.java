package com.test.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.test.model.User;
import com.test.repository.UserRespositry;

public class UserDetailsServiceImpl implements UserDetailsService {


	@Autowired
	private UserRespositry respositry;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
 User user=	respositry.getUserByUserName(username);
		
 if(user==null) {
	 throw new UsernameNotFoundException("could not found user!!");
 }
 
   MyUserDetails details = new MyUserDetails(user);
        
 
		return details;
	}

}
