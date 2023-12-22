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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String list(@RequestParam("username") String user, Model model, HttpSession session){
        session.getAttribute("user");
        model.addAttribute("user",user);
        List<Card> cards=cardService.list();
        System.out.println(cards);
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
    public String addCard(HttpSession session,Model model,Card card){
        User user=(User) session.getAttribute("user");
        model.addAttribute("user",user);
        cardService.addCard(card);
        return "redirect:/card/list";
    }


}
