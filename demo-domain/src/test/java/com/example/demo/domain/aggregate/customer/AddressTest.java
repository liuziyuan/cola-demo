package com.example.demo.domain.aggregate.customer;

import com.example.demo.domain.aggregate.customer.valueobject.Address;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

public class AddressTest {

    @Test
    public void testAddressValueObjectShared(){
        Address a = new Address();
        a.setCity("test");
        a.setCountry("test");
        a.setState("test");
        a.setStreet("test");
        a.setZipcode("test");

        Address b = new Address();
        b.setCity("test");
        b.setCountry("test");
        b.setState("test");
        b.setStreet("test");
        b.setZipcode("test");

        Assert.assertTrue(a.equals(b));


    }
}
