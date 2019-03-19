package com.bowan.addressbook.business.service;

import com.bowan.addressbook.model.Address;
import com.bowan.addressbook.model.AddressBook;
import com.bowan.addressbook.model.Customer;
import com.bowan.addressbook.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;


@Service
public class AddressBookInitialiser {

    @Autowired
    private AddressBookService addressBookService;

    // Initiate test data
    @PostConstruct
    public void init() {
        // Initialise tags
        Tag inContactTag = addressBookService.saveTag(new Tag("In Contact",
                "We are currently in contact with this customer to discuss potential deals"));
        Tag potentialCustomerTag = addressBookService.saveTag(new Tag("Potential Customer",
                "This is a potential customer"));
        Tag currentCustomerTag = addressBookService.saveTag(new Tag("Current Customer",
                "This is a current customer with us"));
        Tag inactiveCustomerTag = addressBookService.saveTag(new Tag("Inactive Customer",
                "This is a customer nolonger has active business with us"));

        // Initialise Address Book 1
        AddressBook addressBook1 = new AddressBook("Existing Customers");
        addressBook1 = addressBookService.saveAddressBook(addressBook1);

        // Initialise Address Book 1 - Customer 1
        Customer customer1 = new Customer.Builder()
                .addressBook(addressBook1)
                .firstName("Bo")
                .lastName("Wan")
                .phoneNumber("+61411111111")
                .address(new Address.Builder()
                        .addressLine1("111 Some Street")
                        .addressLine2("")
                        .suburb("Suburb One")
                        .postCode("1000")
                        .state(Address.State.VIC).build())
                .build();
        customer1 = addressBookService.saveCustomer(customer1);
        addressBookService.addCustomerTags(customer1, new LinkedHashSet<Tag>(Arrays.asList(inContactTag, potentialCustomerTag)));

        // Initialise Address Book 1 - Customer 2
        Customer customer2 = new Customer.Builder()
                .addressBook(addressBook1)
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("+61422222222")
                .address(new Address.Builder()
                        .addressLine1("222 Some Other Street")
                        .addressLine2("")
                        .suburb("Suburb Two")
                        .postCode("2000")
                        .state(Address.State.VIC).build())
                .build();
        customer2 = addressBookService.saveCustomer(customer2);
        addressBookService.addCustomerTags(customer2, new LinkedHashSet<Tag>(Arrays.asList(potentialCustomerTag)));
        addressBookService.saveAddressBook(addressBook1);

        // Initialise Customers and Address Book 2
        AddressBook addressBook2 = new AddressBook("Potential Customers");
        addressBook2 = addressBookService.saveAddressBook(addressBook2);

        // Initialise Customers and Address Book 2 - Customer 3
        Customer customer3 = new Customer.Builder()
                .addressBook(addressBook2)
                .firstName("Jane")
                .lastName("Doe")
                .phoneNumber("+61433333333")
                .address(new Address.Builder()
                        .addressLine1("333 Yet Another Street")
                        .addressLine2("")
                        .suburb("Suburb Three")
                        .postCode("3000")
                        .state(Address.State.VIC).build())
                .build();
        customer3 = addressBookService.saveCustomer(customer3);
        addressBookService.addCustomerTags(customer3, new HashSet<Tag>(Arrays.asList(inContactTag, inactiveCustomerTag)));
        addressBookService.saveAddressBook(addressBook2);

    }
}
