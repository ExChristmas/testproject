package tasks.rest.testproject.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import tasks.rest.testproject.model.Address;

public interface AddressRepository extends MongoRepository<Address, ObjectId> {
}