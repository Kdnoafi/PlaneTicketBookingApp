package com.raf.user_service.dto;

import javax.validation.constraints.NotBlank;

public class CreditCardCreateDto {

    @NotBlank
    private String holderFirstName;
    @NotBlank
    private String holderLastName;
    @NotBlank
    private String cardNumber;
    @NotBlank
    private Integer securityCode;

    public String getHolderFirstName() {
        return holderFirstName;
    }

    public void setHolderFirstName(String holderFirstName) {
        this.holderFirstName = holderFirstName;
    }

    public String getHolderLastName() {
        return holderLastName;
    }

    public void setHolderLastName(String holderLastName) {
        this.holderLastName = holderLastName;
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
