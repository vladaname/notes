package com.example.notes.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.notes.config.JwtTokenUtil;
import com.example.notes.dto.ObavezaDto;
import com.example.notes.model.Note;
import com.example.notes.model.Osoba;
import com.example.notes.repository.NoteRepository;
import com.example.notes.repository.OsobaRepository;
import com.example.notes.service.ObavezaService;

@Service
public class ObavezaServiceImpl implements ObavezaService {

	@Autowired
	NoteRepository noteRepository;

	@Autowired
	OsobaRepository osobaRepository;
	
	@Autowired
    private JwtTokenUtil jwtTokenUtil;

	@Override
	public Note createObaveza(ObavezaDto obavezaDto, String idOsoba) {
		Note ob = new Note();
		ob.setOpis(obavezaDto.getOpis());
		System.out.println(idOsoba.split("Bearer ")[1]);
		String username = jwtTokenUtil.getUsernameFromToken(idOsoba.split("Bearer ")[1]);
		System.out.println("username --- " + username);
		Osoba getIdOsoba = osobaRepository.findByUsername(username);
		
		if (getIdOsoba != null) {
			ob.setOsoba(getIdOsoba);
		} else {
			return null;
		}
		noteRepository.saveAndFlush(ob);

		return ob;
	}

}
