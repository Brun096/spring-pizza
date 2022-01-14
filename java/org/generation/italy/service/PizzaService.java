package org.generation.italy.service;



import java.util.List;


import org.generation.italy.model.Pizza;
import org.generation.italy.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class PizzaService {

	
	@Autowired
	private PizzaRepository repository;
	
	public List<Pizza> findAllSortedByRecent(){
		return repository.findAll(Sort.by("name"));
	}
	
	public Pizza save(Pizza book) {
		

		return repository.save(book);
	}
	//ritorna il book che è stato salvato. riceve l'oggetto Book in java
	//ricevere createDate e che sia now
	//lo abbiamo aggiunto nel service e lo chiamiamo nel nostro controller (formBook)
	public Pizza getById(Integer id) {
		return repository.getById(id);
	}
	
}
