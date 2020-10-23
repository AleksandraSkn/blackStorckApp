package com.sda.blackStorck.service;

import com.sda.blackStorck.dto.LoanDto;
import com.sda.blackStorck.model.Loan;
import com.sda.blackStorck.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final LoanRepository repository;

    @Autowired
    public LoanService(LoanRepository repository) {
        this.repository = repository;
    }

    public Loan applyForLoan (LoanDto loanDto){
        Loan loan = Loan.builder()
                .amount(loanDto.getAmount())
                .date(loanDto.getDate())
                .length(loanDto.getLength())
                .build();

        repository.save(loan);
        return loan;
    }

    public Loan updateLoan (Loan loan){
        repository.save(loan);
        return loan;
    }

    public Loan findById (Long id){
       return repository.findById(id).get();

    }
}
