package com.bowan.addressbook.business.service;

import com.bowan.addressbook.business.repository.AddressBookRepository;
import com.bowan.addressbook.business.repository.CustomerRepository;
import com.bowan.addressbook.business.repository.TagRepository;
import com.bowan.addressbook.model.AddressBook;
import com.bowan.addressbook.model.Customer;
import com.bowan.addressbook.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class AddressBookService {

    @Autowired
    private AddressBookRepository addressBookRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    private TagRepository tagRepository;

    // AddressBook CRUD
    public AddressBook saveAddressBook(AddressBook addressBook1) {
        return addressBookRepository.save(addressBook1);
    }

    public Iterable<AddressBook> findAllAddressBooks() {
        return addressBookRepository.findAll();
    }

    // Customer CRUD
    public Customer addCustomerTags(Customer customer, Set<Tag> tags) {
        customer.getTags().addAll(tags);

        for(Tag tag : tags) {
            tag.getCustomers().add(customer);
        }

        return saveCustomer(customer);
    }

    public Customer addCustomerTag(Customer customer, Tag tag) {
        customer.getTags().add(tag);
        tag.getCustomers().add(customer);
        return customerRepository.save(customer);
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findCustomerById(Long id) {
        return customerRepository.findById(id).get();
    }

    public Iterable<Customer> findAllCustomers() {
        return customerRepository.findAll();
    }

    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }

    // Tag CRUD
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }

    public void deleteTag(Tag tag) {
        tagRepository.delete(tag);
    }

}
