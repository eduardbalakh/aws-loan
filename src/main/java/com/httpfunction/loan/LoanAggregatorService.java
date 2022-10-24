package com.httpfunction.loan;

import java.util.List;
import java.util.stream.Collectors;

public class LoanAggregatorService {

    private final LoanDataProvider loanDataProvider;

    public LoanAggregatorService(LoanDataProvider loanDataProvider) {
        this.loanDataProvider = loanDataProvider;
    }

    public void saveLoan(LoanDO loanDO) {
        loanDataProvider.saveLoan(loanDO);
    }

    public List<LoanDO> getLoansForBorrower(String borrowerId) {
        return loanDataProvider.getLoansByBorrowerId(borrowerId);
    }

    public List<LoanDO> getLoansForOwner(String ownerId) {
        return loanDataProvider.getLoansByOwnerId(ownerId);
    }

    public List<LoanDO> getLoansForOwnerAndBorrower(String ownerId, String borrowerId) {
        return getLoansForOwner(ownerId).stream()
                .filter(loan -> loan.getBorowerId().equals(borrowerId))
                .collect(Collectors.toList());
    }
}
