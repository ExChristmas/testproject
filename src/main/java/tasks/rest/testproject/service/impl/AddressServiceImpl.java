package tasks.rest.testproject.service.impl;

import org.springframework.stereotype.Service;
import tasks.rest.testproject.db.dao.AddressDao;
import tasks.rest.testproject.db.dao.impl.AddressDaoImplMongoDb;
import tasks.rest.testproject.model.Address;
import tasks.rest.testproject.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressDao addressDao = new AddressDaoImplMongoDb();

    @Override
    public void create(Address address) {
        addressDao.create(address);
    }

    @Override
    public List<Address> readAll() {
        return addressDao.readAll();
    }

    @Override
    public Address read(String id) {
        return read(id);
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