package com.application.repositories;

import com.application.model.Account;
import com.application.model.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface AccountRepository extends CrudRepository<Account, Long> {

}
