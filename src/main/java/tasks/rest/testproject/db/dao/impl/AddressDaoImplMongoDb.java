package tasks.rest.testproject.db.dao.impl;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import tasks.rest.testproject.db.dao.AddressDao;
import tasks.rest.testproject.model.Address;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class AddressDaoImplMongoDb implements AddressDao {

    private final MongoCollection<Address> collection;

    public AddressDaoImplMongoDb() {
        CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                fromProviders(PojoCodecProvider.builder().automatic(true).build()));
        MongoClientSettings settings = MongoClientSettings.builder()
                .codecRegistry(pojoCodecRegistry)
                .build();
        collection = MongoClients.create(settings).getDatabase("addresses")
                .getCollection("address", Address.class);
    }

    @Override
    public void create(Address address) {
        collection.insertOne(address);
    }

    @Override
    public List<Address> readAll() {
        List<Address> res = new ArrayList<>();
        return collection.find().into(res);
    }

    @Override
    public Address read(String id) {
        return collection.find(eq("_id", new ObjectId(id))).first();
    }

    @Override
    public Address read(String region, String city, String street, String house) {
        Bson query = and(eq("region", region), eq("city",city),
                eq("street", street), eq("house", house));
        return collection.find(query).first();
    }

//    @Override
//    public boolean update(Address address, String id) {
//        return false;
//    }
//
//    @Override
//    public boolean delete(int id) {
//        return false;
//    }
}