package com.example.notes.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notes.dto.LoginDto;
import com.example.notes.dto.OsobaDto;
import com.example.notes.model.Osoba;
import com.example.notes.repository.OsobaRepository;
import com.example.notes.service.OsobaService;

@Service
public class OsobaServiceImpl implements OsobaService{

	@Autowired
	OsobaRepository osobaRepository;
	@Override
	public Osoba createOsoba(OsobaDto osobaDto) {

		Osoba o = new Osoba();
		o.setIme(osobaDto.getIme());
		o.setEmail(osobaDto.getEmail());
		o.setPrezime(osobaDto.getPrezime());
		o.setUsername(osobaDto.getUsername());
		o.setPass(osobaDto.getPass());
	
		osobaRepository.saveAndFlush(o);
		
		return o;
	}
	@Override
	public Osoba login(LoginDto loginDto) {
		Osoba o = osobaRepository.findByUsername(loginDto.getUsername());
//		String getPass = getUsername.getPass();
		if(loginDto.getPass().equals(o.getPass())) {
			return o;
		}
		
		return null;
	}
	
}
