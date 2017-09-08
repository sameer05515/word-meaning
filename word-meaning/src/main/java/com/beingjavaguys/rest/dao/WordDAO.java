package com.beingjavaguys.rest.dao;

import java.util.List;

import com.beingjavaguys.domain.Wordi;

public interface WordDAO {

	/**
	 * Returns list of words from MongoDB database.
	 * 
	 * @return list of words
	 */
	public List<Wordi> list() ;

	/**
	 * Return word object for given id from MongoDB database. If word is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            word id
	 * @return word object for given id
	 */
	public Wordi get(String id);

	/**
	 * Create new word in MongoDB database. Updates the id and insert new
	 * word in list.
	 * 
	 * @param word
	 *            Customer object
	 * @return word object with updated id
	 */
	public Wordi create(Wordi word) ;

	/**
	 * Delete the word object from MongoDB database. If word not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the word id
	 * @return id of deleted word object
	 */
	public int delete(String id);

	/**
	 * Update the word object for given id in MongoDB database. If word
	 * not exists, returns null
	 * 
	 * @param id
	 * @param word
	 * @return word object with id
	 */
	public Wordi update(String id, Wordi word);


}
