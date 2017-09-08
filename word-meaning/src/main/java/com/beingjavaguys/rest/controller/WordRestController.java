package com.beingjavaguys.rest.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.beingjavaguys.domain.Wordi;
import com.beingjavaguys.rest.dao.WordDAO;



@RestController
public class WordRestController {

	
	@Autowired
	private WordDAO wordDAOImpl;

	
	@GetMapping("/words")
	public List<Wordi> getWords() {
		return wordDAOImpl.list();
	}

	@GetMapping("/words/{id}")
	public ResponseEntity getWord(@PathVariable("id") String id) {

		Wordi word = wordDAOImpl.get(id);
		if (word == null) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(word, HttpStatus.OK);
	}

	@PostMapping(value = "/words")
	public ResponseEntity createWord(@RequestBody Wordi word) {

		wordDAOImpl.create(word);

		return new ResponseEntity(word, HttpStatus.OK);
	}

	@DeleteMapping("/words/{id}")
	public ResponseEntity deleteWord(@PathVariable String id) {

		if (0 == wordDAOImpl.delete(id)) {
			return new ResponseEntity("No Word found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/words/{id}")
	public ResponseEntity updateWord(@PathVariable String id, @RequestBody Wordi word) {

		word = wordDAOImpl.update(id, word);

		if (null == word) {
			return new ResponseEntity("No Customer found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(word, HttpStatus.OK);
	}

}