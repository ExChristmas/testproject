package tasks.rest.testproject.service.impl;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tasks.rest.testproject.db.dao.AddressDao;
import tasks.rest.testproject.db.dao.impl.AddressDaoImplMongoDb;
import tasks.rest.testproject.model.Address;
import tasks.rest.testproject.repos.AddressRepository;
import tasks.rest.testproject.service.AddressService;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public void create(Address address) {
        addressRepository.insert(address);
    }

    @Override
    public List<Address> readAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address read(ObjectId id) {
        Optional<Address> opt = addressRepository.findById(id);
        return opt.orElse(null);
    }

    @Override
    public List<Address> read(String region, String city, String street, String home) {
        return addressRepository.findByAddressWithoutId(region, city, street, home);
    }

//    @Override
//    public boolean update(Address address, int id) {
//        return false;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return false;
//    }
}