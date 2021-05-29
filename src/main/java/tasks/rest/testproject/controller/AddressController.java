package tasks.rest.testproject.controller;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tasks.rest.testproject.model.Address;
import tasks.rest.testproject.service.AddressService;
import tasks.rest.testproject.model.exceptions.*;

import java.util.List;

@RestController
public class AddressController {

    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping(value = "/addresses")
    public ResponseEntity<?> create(@RequestBody Address address) {
        try {
            address.checkValidate();
        } catch (ValidationAddressException ex) {
            System.out.println(ex.getErrorCode());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        addressService.create(address);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(
            value = "/addresses",
            params = {"region", "city", "street", "house"}
    )
    public ResponseEntity<ObjectId> read(@RequestParam("region") String region, @RequestParam("city") String city,
                                         @RequestParam("street") String street, @RequestParam("house") String house) {
        List<Address> addressesFromQuery = addressService.read(region, city, street, house);

            if (addressesFromQuery.isEmpty())
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            else
                return addressesFromQuery.get(0).getId() != null
                        ? new ResponseEntity<>(addressesFromQuery.get(0).getId(), HttpStatus.OK)
                        : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/addresses/{id}")
    public ResponseEntity<Address> read(@PathVariable(name = "id") ObjectId id) {
        final Address address = addressService.read(id);

        return address != null
                ? new ResponseEntity<>(address, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}