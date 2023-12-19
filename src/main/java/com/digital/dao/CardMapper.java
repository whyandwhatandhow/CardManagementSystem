package com.digital.dao;

import com.digital.entity.Card;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CardMapper {
    void addCard(Card card);
    List<Card> list();
    void DeleteCard(@Param("card_id") int id);
    Card findCardById(@Param("card_id") int id);
    void UpdateCard(Card card);

}
