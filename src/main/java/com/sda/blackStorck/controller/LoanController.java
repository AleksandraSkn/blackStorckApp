package com.sda.blackStorck.controller;

import com.sda.blackStorck.dto.LoanDto;
import com.sda.blackStorck.model.Loan;
import com.sda.blackStorck.service.LoanService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.math.BigInteger;
import java.util.Calendar;

@Data
@RestController
@RequestMapping(value = "/loanApi")
public class LoanController {

    private final LoanService service;
    private final RestTemplate restTemplate;


    @Autowired
    public LoanController(LoanService service, RestTemplate restTemplate) {
        this.service = service;
        this.restTemplate = restTemplate;
    }

    @PostMapping
    public ResponseEntity<Loan> applyForLoan (@RequestBody LoanDto loanDto){

        //if(loanDto > milion or  loanDTo < 1000 or term >max term or term < min term ){
            return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
        //}else {
        //    Loan loan = service.applyForLoan(loanDto);
        //    return new ResponseEntity<>(loan, HttpStatus.CREATED);
       // }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> extendLoan(@PathVariable Long id){

        Loan loan = service.findById(id);
        //if(loan.getLength()+6 > max length) {return wypierdalać}
        loan.setLength(loan.getLength()+6);
        service.updateLoan(loan);

        return new ResponseEntity<>(service.findById(loan.getId()), HttpStatus.OK);


    }
}
