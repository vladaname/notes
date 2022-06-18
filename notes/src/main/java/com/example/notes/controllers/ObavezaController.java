package com.example.notes.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.example.notes.dto.ObavezaDto;
import com.example.notes.model.Note;
import com.example.notes.service.ObavezaService;


@RestController
public class ObavezaController {
	
	@Autowired
	ObavezaService obavezaService;
	
	
	@PostMapping(value = "/obaveza")
	public ResponseEntity<Note> createObaveza(@RequestBody ObavezaDto obavezaDto, 
			@RequestHeader(value = "Authorization", required = true) String idOsoba) {
		if(idOsoba==null || idOsoba.isEmpty()) {
			return new ResponseEntity<Note>(HttpStatus.UNAUTHORIZED);
		}
	
		Note ob = obavezaService.createObaveza(obavezaDto, idOsoba);
//		k.getUloga().setKorisniks(null); //@JsonIgnore
		return new ResponseEntity<Note>(ob, HttpStatus.OK);
	}
	
	
	@GetMapping(value = "test")
	public String test() {
		return "Radi";
	}
	

}
