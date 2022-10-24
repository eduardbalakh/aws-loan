package com.httpfunction.loan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocalDebugLoanProvider implements LoanDataProvider {

    private final Map<String, List<LoanDO>> ownerLoanMap = new HashMap<>();
    private final Map<String, List<LoanDO>> borrowerLoanMap = new HashMap<>();


    @Override
    public List<LoanDO> getLoansByBorrowerId(String borrowerId) {
        return borrowerLoanMap.get(borrowerId);
    }

    @Override
    public List<LoanDO> getLoansByOwnerId(String ownerId) {
        return ownerLoanMap.get(ownerId);
    }

    @Override
    public void saveLoan(LoanDO newLoan) {
        putInMap(newLoan.getLoanOwnerId(), newLoan, ownerLoanMap);
        putInMap(newLoan.getBorowerId(), newLoan, borrowerLoanMap);
    }

    private void putInMap(String key, LoanDO newLoan, Map<String, List<LoanDO>> map) {
        if (map.containsKey(key)) {
            map.get(newLoan.getLoanOwnerId()).add(newLoan);
        } else {
            map.put(newLoan.getLoanOwnerId(), List.of(newLoan));
        }
    }
}
