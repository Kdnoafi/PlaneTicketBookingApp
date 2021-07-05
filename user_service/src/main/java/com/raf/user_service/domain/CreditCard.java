package com.raf.user_service.domain;

import javax.persistence.*;

//@Embeddable
public class CreditCard {

    private String firstName;
    private String lastName;
    private String cardNumber;
    private Integer securityCode;

    public CreditCard() {

    }

    public CreditCard(String firstName, String lastName, String cardNumber, Integer securityCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.cardNumber = cardNumber;
        this.securityCode = securityCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(Integer securityCode) {
        this.securityCode = securityCode;
    }

}
