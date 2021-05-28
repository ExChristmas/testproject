package tasks.rest.testproject.model;

import org.bson.types.ObjectId;

import java.util.regex.Pattern;

import tasks.rest.testproject.model.exceptions.*;

import tasks.rest.testproject.model.exceptions.enums.ValidationErrorCode;

public class Address {

    private ObjectId id;
    private String region;
    private String city;
    private String street;
    private String house;

    public Address() {}

    public Address(String region, String city, String street, String house) throws ValidationAddressException {
        setRegion(region);
        setCity(city);
        setStreet(street);
        setHouse(house);
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getRegion() { return region; }

    public void setRegion(String region) throws ValidationAddressException {
        if(!Pattern.matches("([а-я-]{5,15}\\s[а-я]{5,15})" +
                "|([а-я-]{3,15}\\s[а-я]{3,15}\\s[а-я]{3,10})", region))
            throw new ValidationAddressException(ValidationErrorCode.WRONG_REGION);
        else if (region == null)
            throw new ValidationAddressException(ValidationErrorCode.NULL_REGION);
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws ValidationAddressException {
        if(!Pattern.matches("([а-я-]{3,15})([а-я-]{2,15}\\s[а-я]{3,15})" +
                "|([а-я-]{2,15}\\s[а-я]{3,15}\\s[а-я]{3,10})", city))
            throw new ValidationAddressException(ValidationErrorCode.WRONG_CITY);
        else if(city == null)
            throw new ValidationAddressException(ValidationErrorCode.NULL_CITY);
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws ValidationAddressException {
        if(!Pattern.matches("([а-я-]{3,15})|" +
                "([а-я-]{3,15}\\s[а-я]{3,15})|" +
                "([а-я-]{3,15}\\s[а-я]{3,15}\\s[а-я-]{3,10})", street))
            throw new ValidationAddressException(ValidationErrorCode.WRONG_STREET);
        else if(street == null)
            throw new ValidationAddressException(ValidationErrorCode.NULL_STREET);
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) throws ValidationAddressException {
        if(Pattern.matches("([0-9]{1,4})|" +
                "([0-9]{1,4}/?[0-9]{1,4})|" +
                "([0-9]{1,4}-?[0-9]{1,4})", house))
            throw new ValidationAddressException(ValidationErrorCode.WRONG_HOUSE);
        else if(house == null) {
            throw new ValidationAddressException(ValidationErrorCode.NULL_HOUSE);
        }
        this.house = house;
    }
}