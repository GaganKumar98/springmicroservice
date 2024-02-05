package com.bank.card.service;

import com.bank.card.dto.CardsDto;

public interface ICardService {

	void createCard(String mobileNumber);

	CardsDto fetchCard(String mobileNumber);

	boolean updateCard(CardsDto cardsDto);

	boolean deleteCard(String mobileNumber);
}
