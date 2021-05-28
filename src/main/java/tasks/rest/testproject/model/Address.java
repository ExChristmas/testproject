package tasks.rest.testproject.model;

import java.util.regex.Pattern;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import tasks.rest.testproject.model.exceptions.*;

import tasks.rest.testproject.model.exceptions.enums.ValidationErrorCode;

@Document(collection = "address")
public class Address {

    @Id
    private ObjectId id;

    @Field(value = "region")
    private String region;

    @Field(value = "city")
    private String city;

    @Field(value = "street")
    private String street;

    @Field(value = "house")
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

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house){
        this.house = house;
    }

    private void checkValidateRegion() throws ValidationAddressException {
        if(!Pattern.matches("([а-я-]{5,15}\\s[а-я]{5,15})" +
                "|([а-я-]{3,15}\\s[а-я]{3,15}\\s[а-я]{3,10})", region))
            throw new ValidationAddressException(ValidationErrorCode.WRONG_REGION);
        else if (region == null)
            throw new ValidationAddressException(ValidationErrorCode.NULL_REGION);
    }

    private void checkValidateCity() throws ValidationAddressException {
        if(!Pattern.matches("([а-я-]{3,15})([а-я-]{2,15}\\s[а-я]{3,15})" +
                "|([а-я-]{2,15}\\s[а-я]{3,15}\\s[а-я]{3,10})", city))
            throw new ValidationAddressException(ValidationErrorCode.WRONG_CITY);
        else if(city == null)
            throw new ValidationAddressException(ValidationErrorCode.NULL_CITY);
    }

    private void checkValidateStreet() throws ValidationAddressException {
        if(!Pattern.matches("([а-я-]{3,15})|" +
                "([а-я-]{3,15}\\s[а-я]{3,15})|" +
                "([а-я-]{3,15}\\s[а-я]{3,15}\\s[а-я-]{3,10})", street))
            throw new ValidationAddressException(ValidationErrorCode.WRONG_STREET);
        else if(street == null)
            throw new ValidationAddressException(ValidationErrorCode.NULL_STREET);
    }

    private void checkValidateHouse() throws ValidationAddressException {
        if(Pattern.matches("([0-9]{1,4})|" +
                "([0-9]{1,4}/?[0-9]{1,4})|" +
                "([0-9]{1,4}-?[0-9]{1,4})", house))
            throw new ValidationAddressException(ValidationErrorCode.WRONG_HOUSE);
        else if(house == null)
            throw new ValidationAddressException(ValidationErrorCode.NULL_HOUSE);
    }

    public void checkValidate() throws ValidationAddressException {
        checkValidateRegion();
        checkValidateCity();
        checkValidateStreet();
        checkValidateHouse();
    }
}