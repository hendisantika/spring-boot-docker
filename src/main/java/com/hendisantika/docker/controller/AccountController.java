package com.hendisantika.docker.controller;

import com.hendisantika.docker.model.Account;
import com.hendisantika.docker.repository.AccountRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hendisantika on 6/14/17.
 */
@RestController
public class AccountController {

    static final Logger log = LogManager.getLogger(AccountController.class.getName());


    @Autowired
    private AccountRepo accRepo;

    @GetMapping("/account")
    @ResponseBody
    public ResponseEntity<Account> getAccountById(
            @RequestParam(value = "id", required = false) String id,
            @RequestParam(value = "customer", required = false) String customerId
    ) {

        Account res1 = accRepo.findById(id).get();
        Account res2 = accRepo.findByCustomerId(customerId);

        if (id != null) {
            log.info("Data : " + new ResponseEntity(accRepo.findById(id).get(), HttpStatus.OK));
            return new ResponseEntity(accRepo.findById(id).get(), HttpStatus.OK);
        } else if (customerId != null) {
            log.info("Data : " + new ResponseEntity(accRepo.findByCustomerId(customerId), HttpStatus.OK));
            return new ResponseEntity(accRepo.findByCustomerId(customerId), HttpStatus.OK);
        } else if (id == null && customerId == null) {
            log.info("Data : " + new ResponseEntity(accRepo.findAll(), HttpStatus.NOT_FOUND));
            return new ResponseEntity(accRepo.findAll(), HttpStatus.OK);
        } else if (res1 == null || res2 == null) {
            log.info("Data : " + new ResponseEntity("NO CUSTOMER FOUND ...!", HttpStatus.NOT_FOUND));
            return new ResponseEntity("NO CUSTOMER FOUND ...!", HttpStatus.NOT_FOUND);
        } else {
            log.info("Data : " + new ResponseEntity("NOT FOUND", HttpStatus.OK));
            return new ResponseEntity("NOT FOUND", HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/account/all")
    @ResponseBody
    public ResponseEntity<Account> getAllAccount() {
        Iterable<Account> res = accRepo.findAll();
        if (res != null) {
            log.info("Data : " + new ResponseEntity("Datanya adalah sbb : " + res, HttpStatus.OK));
            return new ResponseEntity(res, HttpStatus.OK);
        } else {
            log.info("Data : " + new ResponseEntity("NOT FOUND", HttpStatus.NOT_FOUND));
            return new ResponseEntity("NOT FOUND", HttpStatus.NOT_FOUND);
        }

    }
}
