package com.httpfunction.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AggregatedLoanDO {

    private String ownerId;
    private String borrowerId;
    private BigDecimal value;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public AggregatedLoanDO() {
    }

    public AggregatedLoanDO(String ownerId, String borrowerId, BigDecimal value,
                            LocalDateTime startDate, LocalDateTime endDate) {
        this.ownerId = ownerId;
        this.borrowerId = borrowerId;
        this.value = value;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getBorrowerId() {
        return borrowerId;
    }

    public void setBorrowerId(String borrowerId) {
        this.borrowerId = borrowerId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }
}
