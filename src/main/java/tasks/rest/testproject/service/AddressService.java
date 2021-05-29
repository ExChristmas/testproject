package tasks.rest.testproject.service;

import org.bson.types.ObjectId;
import tasks.rest.testproject.model.Address;

import java.util.List;

public interface AddressService {

    void create(Address address);

    List<Address> readAll();

    Address read(ObjectId id);

    List<Address> read(String region, String city, String street, String home);

//    boolean update(Address address, int id);
//
//    boolean delete(int id);
}
