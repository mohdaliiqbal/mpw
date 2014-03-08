package pk.com.mypetworld.server.test;


import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import pk.com.mypetworld.server.users.model.User;

import com.mongodb.Mongo;

public class MongoAppA {

  private static final Log log = LogFactory.getLog(MongoAppA.class);

  @Test
  public static void main(String[] args) throws Exception {

    MongoOperations mongoOps = new MongoTemplate(new Mongo(), "database");

    mongoOps.insert(new User("Joe", "joe.barton@fa.com"));

    log.info(mongoOps.findOne(new Query(where("name").is("Joe")), User.class));

    mongoOps.dropCollection("user");
  }
}
