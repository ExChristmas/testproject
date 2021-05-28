package tasks.rest.testproject.db.dao;

import tasks.rest.testproject.model.Address;

import java.util.List;

public interface AddressDao {

    void create(Address address);

    List<Address> readAll();

    Address read(String id);

    Address read(String region, String city, String street, String house);

//    boolean update(Address address, String id);
//
//    boolean delete(int id);
}