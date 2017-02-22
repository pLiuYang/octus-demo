package com.octustest.repos;

import com.octustest.models.Person;;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by liuyang on 2/21/2017.
 */

public interface PersonRepository  extends MongoRepository<Person, String> {
}
