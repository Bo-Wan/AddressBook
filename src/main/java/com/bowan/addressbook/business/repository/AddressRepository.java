package com.bowan.addressbook.business.repository;

import com.bowan.addressbook.model.Address;
import com.bowan.addressbook.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
