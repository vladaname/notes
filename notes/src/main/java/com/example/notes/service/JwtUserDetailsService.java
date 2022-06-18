package com.example.notes.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.notes.model.Osoba;
import com.example.notes.repository.OsobaRepository;
@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	OsobaRepository osobaRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       /* if ("javainuse".equals(username)) {
        	//ubaci username i pass iz baze... pogledaj tutorijal
            return new User("javainuse", "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6",
                    new ArrayList<>());
            //
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }*/
    	Osoba user = osobaRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPass(),
				new ArrayList<>());
	}
}