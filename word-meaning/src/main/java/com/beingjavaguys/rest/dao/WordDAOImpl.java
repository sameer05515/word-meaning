/**
 * 
 */
package com.beingjavaguys.rest.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.beingjavaguys.domain.Wordi;
import com.mongodb.WriteResult;

/**
 * @author rim jhim
 *
 */
@Component
public class WordDAOImpl implements WordDAO {
	
//	private MongoOperations mongoOps;
	@Autowired
	private MongoOperations mongoTemplate;
//	private MongoTemplate mongoTemplate;
	private static final String PERSON_COLLECTION = "wordscollection";

	/**
	 * Returns list of words from MongoDB database.
	 * 
	 * @return list of words
	 */
	@Override
	public List<Wordi> list() {
		
		return this.mongoTemplate.findAll(Wordi.class, PERSON_COLLECTION);
	}

	/**
	 * Return word object for given id from MongoDB database. If word is
	 * not found for id, returns null.
	 * 
	 * @param id
	 *            word id
	 * @return word object for given id
	 */
	@Override
	public Wordi get(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		return this.mongoTemplate.findOne(query, Wordi.class, PERSON_COLLECTION);
	}

	/**
	 * Create new word in MongoDB database. Updates the id and insert new
	 * word in list.
	 * 
	 * @param word
	 *            Customer object
	 * @return word object with updated id
	 */
	@Override
	public Wordi create(Wordi word) {
		this.mongoTemplate.insert(word, PERSON_COLLECTION);
		return word;
	}

	/**
	 * Delete the word object from MongoDB database. If word not found for
	 * given id, returns null.
	 * 
	 * @param id
	 *            the word id
	 * @return id of deleted word object
	 */
	@Override
	public int delete(String id) {
		Query query = new Query(Criteria.where("_id").is(id));
		WriteResult result = this.mongoTemplate.remove(query, Wordi.class, PERSON_COLLECTION);
		return result.getN();
	}

	/**
	 * Update the word object for given id in MongoDB database. If word
	 * not exists, returns null
	 * 
	 * @param id
	 * @param word
	 * @return word object with id
	 */
	@Override
	public Wordi update(String id, Wordi word) {
		this.mongoTemplate.save(word, PERSON_COLLECTION);
		return word;
		
		//Query query = new Query();
		//query.addCriteria(Criteria.where("_id").is(id));
		
//		Word userTest6 = mongoOps.findAndModify(
//				query6, word,
//				new FindAndModifyOptions().returnNew(true), User.class);
		
		//return this.mongoOps.findOne(query, Word.class, PERSON_COLLECTION);

	
	}

}
