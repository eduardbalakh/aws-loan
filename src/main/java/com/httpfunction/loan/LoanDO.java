package com.httpfunction.loan;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class LoanDO {

    private String id;

    private String loanOwnerId;

    private String borowerId;

    private BigDecimal value;

    private LocalDateTime dateTime;

    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoanOwnerId() {
        return loanOwnerId;
    }

    public void setLoanOwnerId(String loanOwnerId) {
        this.loanOwnerId = loanOwnerId;
    }

    public String getBorowerId() {
        return borowerId;
    }

    public void setBorowerId(String borowerId) {
        this.borowerId = borowerId;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
