package tasks.rest.testproject.repos;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import tasks.rest.testproject.model.Address;

import java.util.List;

public interface AddressRepository extends MongoRepository<Address, ObjectId> {

    @Query("{ 'region' : ?0, 'city' : ?1, 'street' : ?2, 'house' : ?3 }")
    List<Address> findByAddressWithoutId(String region, String city, String street, String house);

}