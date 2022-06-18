package com.example.notes.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.notes.dto.LoginDto;
import com.example.notes.dto.OsobaDto;
import com.example.notes.model.Osoba;
import com.example.notes.service.OsobaService;

@RestController
public class OsobaController {

	@Autowired
	OsobaService osobaService;

	@PostMapping(value = "/registration")
	public Map<String, Object> createKorisnik(@RequestBody OsobaDto osobaDto) {
		Map<String, Object> response = new HashMap<String, Object>();
		Osoba o = osobaService.createOsoba(osobaDto);
//			k.getUloga().setKorisniks(null); //@JsonIgnore
		response.put("status", "success");
		response.put("korisnik", o);
		return response;
	}

	/*
	 * @PostMapping(value = "/login") public Map<String, Object> login(@RequestBody
	 * LoginDto loginDto) { Map<String, Object> response = new HashMap<String,
	 * Object>(); Osoba login = osobaService.login(loginDto); if (login != null) {
	 * response.put("status", "success"); response.put("korisnik", login); return
	 * response; } else { response.put("status", "error"); return response; }
	 * 
	 * }
	 */
	
//	@GetMapping("/test")
//	public String test() {
//		return "radi";
//	}
}
