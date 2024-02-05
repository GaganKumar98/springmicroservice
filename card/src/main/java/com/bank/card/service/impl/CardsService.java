package com.bank.card.service.impl;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.card.constants.CardsConstants;
import com.bank.card.dto.CardsDto;
import com.bank.card.entity.Cards;
import com.bank.card.exception.CardNotFoundException;
import com.bank.card.exception.ResourceNotFoundException;
import com.bank.card.mapper.CardsMapper;
import com.bank.card.repository.CardsRepository;
import com.bank.card.service.ICardService;

@Service
public class CardsService implements ICardService {

	@Autowired
	private CardsRepository cardsRepository;

	@Override
	public void createCard(String mobileNumber) {
		Optional<Cards> cards = cardsRepository.findByMobileNumber(mobileNumber);
		if (cards.isPresent()) {
			throw new CardNotFoundException("Card is Already present  with the given number" + mobileNumber);
		}
		cardsRepository.save(createNewCard(mobileNumber));
	}

	private Cards createNewCard(String mobileNumber) {
		Cards newCard = new Cards();
		long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
		newCard.setCardNumber(Long.toString(randomCardNumber));
		newCard.setMobileNumber(mobileNumber);
		newCard.setCardType(CardsConstants.CREDIT_CARD);
		newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
		newCard.setAmountUsed(0);
		newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
		return newCard;
	}

	@Override
	public CardsDto fetchCard(String mobileNumber) {
		Cards cards = cardsRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Cards", "mobile Number", mobileNumber));
		return CardsMapper.mapToCardsDto(cards, new CardsDto());
	}

	@Override
	public boolean updateCard(CardsDto cardsDto) {
		Cards cards = cardsRepository.findByMobileNumber(cardsDto.getMobileNumber())
				.orElseThrow(() -> new ResourceNotFoundException("Cards", "mobile Number", cardsDto.getMobileNumber()));
		CardsMapper.mapToCards(cardsDto, cards);
		cardsRepository.save(cards);
		return true;
	}

	@Override
	public boolean deleteCard(String mobileNumber) {
		Cards cards = cardsRepository.findByMobileNumber(mobileNumber)
				.orElseThrow(() -> new ResourceNotFoundException("Cards", "mobile Number", mobileNumber));
		cardsRepository.deleteById(cards.getCardId());
		return true;
	}

}
