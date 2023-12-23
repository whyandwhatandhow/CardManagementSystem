package com.digital.dao;

import com.digital.entity.Card;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CardMapper {
    void addCard(Card card);
    List<Card> list();
    void DeleteCard(@Param("card_id") int id);
    Card findCardById(@Param("card_id") int id);
    Card findCardByUsername(@Param("username") String username);
    List<Card> findCardLikeUsername(@Param("username") String username);
    List<Card> findCardLikePhone(@Param("phone_num") Long number);
    List<Card> findCardLikeE_mail(@Param("e_mail") String e_mail);
    List<Card> findCardLikeWorkplace(@Param("workplace") String workplace);
    List<Card> findCardLikeTitle(@Param("title") String Title);
    List<Card> findCardLikeAddress(@Param("address") String address);
    List<Card> findCardLikeName(@Param("name") String name);
    void UpdateCard(Card card);

}
