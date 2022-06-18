package com.example.notes.service;

import com.example.notes.dto.LoginDto;
import com.example.notes.dto.OsobaDto;
import com.example.notes.model.Osoba;

public interface OsobaService {

	Osoba createOsoba(OsobaDto osobaDto);

	Osoba login(LoginDto loginDto);

}
