package com.acme.banking.dbo.spring.domain;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("C")
@ApiModel(parent = Account.class, discriminator = "type")
public class CheckingAccount extends Account {
    private double overdraft;

    public CheckingAccount() { }

    public CheckingAccount(double amount, double overdraft, String email) {
        super(amount, email);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    @Override
    @ApiModelProperty(allowableValues = "C")
    public String getType() {
        return "C";
    }

    @Override
    public String toString() {
        return super.toString() + " C " + overdraft;
    }
}
