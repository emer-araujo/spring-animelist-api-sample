package com.emer.araujo.animetier.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emer.araujo.animetier.entities.Anime;

public interface AnimeRepository extends JpaRepository<Anime, Long>{

}
