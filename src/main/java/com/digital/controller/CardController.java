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
    public String list(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        List<Card> cards = cardService.list();
        model.addAttribute("cards", cards);
        return "index";
    }


    //跳转到添加
    @RequestMapping("/toAddCard")
    public String toAddCard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
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
            return "redirect:/card/list?username=" + user.getUsername();
        } else {
            model.addAttribute("message2", "用户名片已经注册");
            return "addCard";
        }
    }


    @RequestMapping("/deleteCard")
    public String deleteCard(int id, HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        cardService.DeleteCard(id);
        return "redirect:/card/list?username=" + user.getUsername();
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
        List<Card> searchResults = new ArrayList<>();
        int flag = 0;
        try {
            searchResults.addAll(cardService.findCardLikePhone(Long.valueOf(query)));
            searchResults.addAll(cardService.findCardLikeUsername(query));
        } catch (NumberFormatException e) {
            flag = 1;
        }
        // 根据用户名查询名片
        if (flag == 1) {
            searchResults.addAll(cardService.findCardLikeUsername(query));
            searchResults.addAll(cardService.findCardLikeName(query));
            searchResults.addAll(cardService.findCardLikeE_mail(query));
            searchResults.addAll(cardService.findCardLikeTitle(query));
            searchResults.addAll(cardService.findCardLikeWorkplace(query));
            searchResults.addAll(cardService.findCardLikeAddress(query));
        }


        model.addAttribute("searchResults", searchResults);
        if (searchResults.isEmpty()) {
            model.addAttribute("error", "没有查询到用户");
            return "query";
        }
        return "query";
    }


    @RequestMapping("/showDetails")
    public String showDetails(HttpSession session, Model model, @RequestParam int id) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        Card cardDetail = cardService.findCardById(id);
        model.addAttribute("cardDetail", cardDetail);
        return "details";
    }

    @RequestMapping("/personShow")
    public String personShow(HttpSession session, Model model, @RequestParam String username) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        Card person = cardService.findCardByUsername(username);
        model.addAttribute("cardPerson", person);
        return "personCenter";
    }

    @RequestMapping("/toEnter")
    public String toEnter(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        return "toUpdate";
    }

    @RequestMapping("/toUpdate")
    public String toUpdate(HttpSession session, Model model, User oldUser) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        User enterUser = userService.selectUserByUsername(user.getUsername());
        if (oldUser.getPassword() != null && oldUser.getPassword().equals(enterUser.getPassword())) {
            return "redirect:/card/toUpdateCard";
        } else {
            model.addAttribute("error", "密码错误");
            return "toUpdate";
        }
    }

    int flag = 0;

    @RequestMapping("/toUpdateCard")
    public String toUpdateCard(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        String username = user.getUsername();
        Card oldCard = cardService.findCardByUsername(username);
        model.addAttribute("card1", oldCard);

        return "updateCard";
    }


    @RequestMapping("/updateNewCard")
    public String updateNewCard(HttpSession session, Model model, Card newCard, User newUser) {
        flag = 0;
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        String username = user.getUsername();
        Card oldCard = cardService.findCardByUsername(username);
        model.addAttribute("card1", oldCard);
        if ((newUser.getPassword() == null || newUser.getPassword().isEmpty()) &&
                (newUser.getEnterPassword() == null || newUser.getEnterPassword().isEmpty())) {
            newUser.setPassword(user.getPassword());
            newUser.setEnterPassword(user.getPassword());
            userService.updateUser(newUser);
            cardService.UpdateCard(newCard);
            System.out.println(1);
            flag = 1;
            model.addAttribute("succeed", "保存成功");
            return "updateCard";
        } else if (newUser.getPassword() == null || newUser.getEnterPassword() == null || !newUser.getPassword().equals(newUser.getEnterPassword())) {
            model.addAttribute("error1", "前后密码不一致");
            System.out.println(2);
            flag = 2;
            return "updateCard";
        } else if (newUser.getPassword() != null && newUser.getEnterPassword() != null && newUser.getEnterPassword().equals(newUser.getPassword())) {
            userService.updateUser(newUser);
            cardService.UpdateCard(newCard);
            model.addAttribute("succeed", "保存成功");
            System.out.println(3);
            flag = 1;
            return "updateCard";
        } else {
            model.addAttribute("error2", "保存失败");
            System.out.println(4);
            flag = 4;
            return "updateCard";
        }
    }


}
