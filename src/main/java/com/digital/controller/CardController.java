package com.digital.controller;

import com.digital.entity.Card;
import com.digital.entity.User;
import com.digital.service.CardService;
import com.digital.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {

    @Autowired
    @Qualifier("UserServiceImpl")
    UserService userService;

    @Autowired
    @Qualifier("CardServiceImpl")
    CardService cardService;


    //展示主页面
    @RequestMapping("/list")
    public String list(@RequestParam(value = "username",defaultValue = "defaultUsername") String user, Model model, HttpSession session){
        session.getAttribute("user");
        model.addAttribute("user",user);
        List<Card> cards=cardService.list();
        model.addAttribute("cards",cards);
        return "index";
    }


    //跳转到添加
    @RequestMapping("/toAddCard")
    public String toAddCard(HttpSession session,Model model){
        User user = (User) session.getAttribute("user");
        model.addAttribute("user",user);
        return "addCard";
    }

    @RequestMapping("/addCard")
    public String addCard(HttpSession session, Model model, Card card) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        Card newCard = cardService.findCardByUsername(card.getUsername());
        User allUser = userService.selectUserByUsername(card.getUsername());

        if (allUser == null) {
            model.addAttribute("message1", "没有此用户，请重新填写信息");
            return "addCard";
        }

        if (newCard == null) {
            cardService.addCard(card);
            return "redirect:/card/list";
        } else {
            model.addAttribute("message2", "用户名片已经注册");
            return "addCard";
        }
    }


    @RequestMapping("/deleteCard")
    public String deleteCard(int id){
        cardService.DeleteCard(id);
        return "redirect:/card/list";
    }


    @RequestMapping("/toQuery")
    public String toQuery(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "query";
    }

    @RequestMapping("/queryCard")
    public String queryByUsername(HttpSession session, Model model, @RequestParam String query) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        List<Card> searchResults =new ArrayList<>();
        int flag=0;
        try{
            searchResults.addAll(cardService.findCardLikePhone(Long.valueOf(query)));
            searchResults.addAll(cardService.findCardLikeUsername(query));
        }catch (NumberFormatException e){
            flag=1;
        }
        // 根据用户名查询名片
        if(flag==1){
            searchResults.addAll(cardService.findCardLikeUsername(query));
            searchResults.addAll(cardService.findCardLikeName(query));
            searchResults.addAll(cardService.findCardLikeE_mail(query));
            searchResults.addAll(cardService.findCardLikeTitle(query));
            searchResults.addAll(cardService.findCardLikeWorkplace(query));
            searchResults.addAll(cardService.findCardLikeAddress(query));
        }


        model.addAttribute("searchResults", searchResults);
        if(searchResults.isEmpty()){
            model.addAttribute("error","没有查询到用户");
            return "query";
        }
        return "query";
    }

}
