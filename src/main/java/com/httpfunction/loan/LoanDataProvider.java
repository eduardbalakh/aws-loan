package com.httpfunction.loan;

import java.util.List;

public interface LoanDataProvider {
    List<LoanDO> getLoansByBorrowerId(String borrowerId);
    List<LoanDO> getLoansByOwnerId(String ownerId);
    void saveLoan(LoanDO newLoan);
}
