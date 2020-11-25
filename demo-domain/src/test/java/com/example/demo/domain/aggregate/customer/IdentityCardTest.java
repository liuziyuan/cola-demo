package com.example.demo.domain.aggregate.customer;

import com.example.demo.domain.aggregate.customer.valueobject.Address;
import com.example.demo.domain.aggregate.customer.valueobject.IdentityCard;
import org.junit.Assert;
import org.junit.Test;

public class IdentityCardTest {

    @Test
    public void testIdentityCardValueObjectShared(){
        IdentityCard idc1 = new IdentityCard();
        idc1.setBirthday(null);
        idc1.setIdNumber("test");
        idc1.setName("test");
        idc1.setNation("test");

        IdentityCard idc2 = new IdentityCard();
        idc2.setBirthday(null);
        idc2.setIdNumber("test");
        idc2.setName("test");
        idc2.setNation("test");

        Address a = new Address();
        a.setCity("test");
        a.setCountry("test");
        a.setState("test");
        a.setStreet("test");
        a.setZipcode("test");
        idc1.setAddress(a);

        Address b = new Address();
        b.setCity("test");
        b.setCountry("test");
        b.setState("test");
        b.setStreet("test");
        b.setZipcode("test");
        idc2.setAddress(b);

        Assert.assertTrue(idc1.equals(idc2));
    }
}
