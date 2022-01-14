package org.generation.italy.service;

import java.util.List;

import org.generation.italy.model.Ingredienti;
import org.generation.italy.repository.IngredientiRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class IngredientiService {

	@Autowired
	private IngredientiRepo repo;
	
	public List<Ingredienti> findAllSortByCategory(){
		return repo.findAll(Sort.by("ingrediants"));
	}
}
