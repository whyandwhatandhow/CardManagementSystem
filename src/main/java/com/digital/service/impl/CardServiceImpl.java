package com.digital.service.impl;

import com.digital.dao.CardMapper;
import com.digital.entity.Card;
import com.digital.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class CardServiceImpl implements CardService {
    @Autowired
    @Qualifier("cardMapper")
    private CardMapper cardMapper;
    public void setCardMapper(CardMapper cardMapper) {
        this.cardMapper = cardMapper;
    }
    @Override
    public void addCard(Card card) {
        cardMapper.addCard(card);
    }

    @Override
    public List<Card> list() {
        List<Card> cards=cardMapper.list();
        return cards;
    }

    @Override
    public void DeleteCard(int id) {
        cardMapper.DeleteCard(id);
    }

    @Override
    public Card findCardById(int id) {
        return cardMapper.findCardById(id);
    }

    @Override
    public void UpdateCard(Card card) {
        cardMapper.UpdateCard(card);
    }


}
