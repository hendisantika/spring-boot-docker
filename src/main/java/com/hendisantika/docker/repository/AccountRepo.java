package com.hendisantika.docker.repository;

import com.hendisantika.docker.model.Account;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by hendisantika on 6/14/17.
 */
public interface AccountRepo extends CrudRepository<Account, String> {
    Account findByCustomerId(String customerId);
}
