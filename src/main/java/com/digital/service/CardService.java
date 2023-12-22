package com.digital.service;

import com.digital.entity.Card;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CardService {
    void addCard(Card card);
    List<Card> list();
    void DeleteCard(int id);
    Card findCardById(int id);
    void UpdateCard(Card card);
    Card findCardByUsername(String username);
}
