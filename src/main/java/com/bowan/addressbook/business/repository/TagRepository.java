package com.bowan.addressbook.business.repository;

import com.bowan.addressbook.model.Customer;
import com.bowan.addressbook.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
}
