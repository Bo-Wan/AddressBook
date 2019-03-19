package com.bowan.addressbook;

import com.bowan.addressbook.business.repository.AddressBookRepository;
import com.bowan.addressbook.model.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressbookApplication {

	@Autowired
	private AddressBookRepository addressBookRepository;

	public static void main(String[] args) {
		SpringApplication.run(AddressbookApplication.class, args);
	}

}
