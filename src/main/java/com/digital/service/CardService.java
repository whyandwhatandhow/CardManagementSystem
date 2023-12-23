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
    List<Card> findCardLikeUsername(String username);
    List<Card> findCardLikePhone(Long number);
    List<Card> findCardLikeE_mail(String e_mail);
    List<Card> findCardLikeWorkplace(String workplace);
    List<Card> findCardLikeTitle(String Title);
    List<Card> findCardLikeAddress(String address);
    List<Card> findCardLikeName(String name);
}
