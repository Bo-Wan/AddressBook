package com.bowan.addressbook.business.repository;

        import com.bowan.addressbook.model.AddressBook;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepository extends CrudRepository<AddressBook, Long> {
}
