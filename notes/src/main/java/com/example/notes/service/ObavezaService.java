package com.example.notes.service;

import com.example.notes.dto.ObavezaDto;
import com.example.notes.model.Note;


public interface ObavezaService {

	Note createObaveza(ObavezaDto obavezaDto, String idOsoba);

}
