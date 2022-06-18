package com.example.notes.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.notes.model.Osoba;

@Repository
@Transactional
public interface OsobaRepository extends JpaRepository<Osoba, Integer>{

	Osoba findByUsername(String username);

}
