package com.gt.training.dao;

import com.gt.training.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

/**
 * Created by WeiHang on 2020/02/22.
 */
@Component
public class TrainingDao {

	@Autowired
	private MongoTemplate template;

	public void save(Training training) {
		template.save(training);
	}

	public void update(Training training) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(training.getId()));

		Update update = new Update();
		update.set("name", training.getName());

		template.upsert(query, update, Training.class, "training");
	}
}
