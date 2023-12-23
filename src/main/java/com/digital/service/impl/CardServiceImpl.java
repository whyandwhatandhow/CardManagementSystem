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

    @Override
    public Card findCardByUsername(String username) {
        return cardMapper.findCardByUsername(username);
    }

    @Override
    public List<Card> findCardLikeUsername(String username) {
        return cardMapper.findCardLikeUsername(username);
    }

    @Override
    public List<Card> findCardLikePhone(Long number) {
        return cardMapper.findCardLikePhone(number);
    }

    @Override
    public List<Card> findCardLikeE_mail(String e_mail) {
        return cardMapper.findCardLikeE_mail(e_mail);
    }

    @Override
    public List<Card> findCardLikeWorkplace(String workplace) {
        return cardMapper.findCardLikeWorkplace(workplace);
    }

    @Override
    public List<Card> findCardLikeTitle(String Title) {
        return cardMapper.findCardLikeTitle(Title);
    }

    @Override
    public List<Card> findCardLikeAddress(String address) {
        return cardMapper.findCardLikeAddress(address);
    }

    @Override
    public List<Card> findCardLikeName(String name) {
        return cardMapper.findCardLikeName(name);
    }


}
