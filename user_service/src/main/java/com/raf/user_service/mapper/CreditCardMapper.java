package com.raf.user_service.mapper;

import com.raf.user_service.domain.CreditCard;
import com.raf.user_service.dto.CreditCardCreateDto;
import com.raf.user_service.dto.CreditCardDto;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {

    public CreditCardMapper() {

    }

    public CreditCardDto creditCardToCreditCardDto(CreditCard creditCard) {
        CreditCardDto creditCardDto = new CreditCardDto();
        creditCardDto.setHolderFirstName(creditCard.getFirstName());
        creditCardDto.setHolderLastName(creditCard.getLastName());
        creditCardDto.setCardNumber(creditCard.getCardNumber());
        creditCardDto.setSecurityCode(creditCard.getSecurityCode());
        return creditCardDto;
    }

    public CreditCard creditCardCreateDtoToCreditCard(CreditCardCreateDto creditCardCreateDto) {
        CreditCard creditCard = new CreditCard();
        creditCard.setFirstName(creditCardCreateDto.getHolderFirstName());
        creditCard.setLastName(creditCardCreateDto.getHolderLastName());
        creditCard.setCardNumber(creditCardCreateDto.getCardNumber());
        creditCard.setSecurityCode(creditCardCreateDto.getSecurityCode());
        return creditCard;
    }

}
