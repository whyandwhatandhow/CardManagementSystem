package com.digital.controller;

import com.digital.entity.Card;
import com.digital.entity.User;
import com.digital.service.UserService;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;
    int flag=0;

    @RequestMapping("/login")
    public String Login(HttpSession session, User user, Model model, RedirectAttributes redirectAttributes){
        String username=user.getUsername();
        String password=user.getPassword();
        User loginUser=userService.selectUserByUsername(username);
        if(flag==1){
            model.addAttribute("succeed","注册成功");
        }
        if (loginUser!=null&&loginUser.getPassword().equals(password)) {
            // 登录成功，将用户信息存储到session中
            session.setAttribute("loggedInUser", user);

            // 使用 RedirectAttributes 传递参数到重定向页面
            redirectAttributes.addAttribute("username", username);
            // 重定向到index.jsp页面
            return "redirect:/card/list";
        } else {
            if(flag!=1) {
                model.addAttribute("error", "用户名或密码错误");
            }
            return "Login";
        }
    }

    @RequestMapping("/register")
    public String Register(User user,Model model,HttpSession session){
        String username=user.getUsername();
        String password=user.getPassword();
        String enterPassword=user.getEnterPassword();
        System.out.println(user);
        User registerUser=userService.selectUserByUsername(username);
        if(registerUser==null){
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setPassword(password);
            newUser.setEnterPassword(enterPassword);
            if(password.equals(enterPassword)){
                userService.addUser(newUser);
                flag=1;
                session.setAttribute("registerUser",user);
                return "redirect:/user/login ";
            }else {
                model.addAttribute("message2","前后密码不一致");
                return "register";
            }
        }else {
            model.addAttribute("message3","用户信息存在");
            return "register";
        }
    }

}
