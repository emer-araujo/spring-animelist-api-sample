package com.emer.araujo.animetier.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emer.araujo.animetier.entities.Anime;
import com.emer.araujo.animetier.repositories.AnimeRepository;

@RestController
@RequestMapping(value = "/animes")
public class AnimeController {
	
	@Autowired
	private AnimeRepository repository;
	
	@GetMapping
	public List<Anime> findAll(){
		List<Anime> result = repository.findAll();
		return result;
	}
	
	@GetMapping(value = "/{id}")
	public Anime findById(@PathVariable Long id) {
		Anime result = repository.findById(id).get();
		return result;
	}
	
	@PostMapping
	public Anime insert(@RequestBody Anime anime) {
		Anime result = repository.save(anime);
		return result;
	}
	
	@PutMapping(value = "/{id}")
	public Anime update(@PathVariable Long id, @RequestBody Anime res) {
		Anime upd = repository.findById(id).get();
		upd.setAnime(res.getAnime());
		upd.setClassification(res.getClassification());
		upd.setGenders(res.getGenders());
		upd.setRelease(res.getRelease());
		final Anime updAnime = repository.save(upd);
		return updAnime;
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable Long id) {
		Anime del = repository.findById(id).get();
		repository.delete(del);
	}
	
}
