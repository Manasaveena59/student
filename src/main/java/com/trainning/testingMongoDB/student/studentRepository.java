package com.trainning.testingMongoDB.student;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.trainning.testingMongoDB.student.*;

public interface studentRepository extends MongoRepository <student, String> {
	

}
