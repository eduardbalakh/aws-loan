package com.httpfunction.loan;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.Mockito;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class LoanAggregatorServiceTest {

    LoanDataProvider loanProvider = mock(LocalDebugLoanProvider.class);
    private final LoanAggregatorService service = new LoanAggregatorService(loanProvider);

    @BeforeEach
    public void initTests() {
        initTestData();

    }

    @Test
    void saveLoan() {
        LoanDO loanDO = new LoanDO();
        loanDO.setId("10");
        loanDO.setBorowerId("bor2");
        loanDO.setLoanOwnerId("own1");
        loanDO.setValue(new BigDecimal(5000));
        loanDO.setDateTime(LocalDateTime.of(2022, 2, 1, 0, 0));
        service.saveLoan(loanDO);
        verify(loanProvider, times(1)).saveLoan(loanDO);
    }

    @Test
    void getAllLoansForBorrower() {


    }

    @Test
    void getAllLoansForOwner() {
    }

    @Test
    void getAllLoansForOwnerAndBorrower() {
    }

    @Test
    void getAggregatedLoanForBorrower() {
    }

    @Test
    void getAggregatedLoadForOwner() {
    }

    @Test
    void getAggregatedLoanForOwnerAndBorrower() {
    }


    private void initTestData() {
        LoanDO loanDO1 = new LoanDO();
        loanDO1.setId("1");
        loanDO1.setBorowerId("bor1");
        loanDO1.setLoanOwnerId("own1");
        loanDO1.setValue(new BigDecimal(10000));
        loanDO1.setDateTime(LocalDateTime.of(2022, 1, 1, 0, 0));
        LoanDO loanDO2 = new LoanDO();
        loanDO2.setId("2");
        loanDO2.setBorowerId("bor1");
        loanDO2.setLoanOwnerId("own1");
        loanDO2.setValue(new BigDecimal(20000));
        loanDO2.setDateTime(LocalDateTime.of(2022, 1, 1, 2, 0));
        loanProvider.saveLoan(loanDO1);
        loanProvider.saveLoan(loanDO2);
    }
}