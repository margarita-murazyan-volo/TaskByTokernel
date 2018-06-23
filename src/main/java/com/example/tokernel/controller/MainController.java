package com.example.tokernel.controller;

import com.example.tokernel.model.Number;
import com.example.tokernel.model.User;
import com.example.tokernel.model.UserType;
import com.example.tokernel.repository.NumberRepository;
import com.example.tokernel.repository.UserRepository;
import com.example.tokernel.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private NumberRepository numberRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/loginSuccess")
    public String loginSuccess(@AuthenticationPrincipal UserDetails userDetails) {
        CurrentUser currentUser = (CurrentUser) userDetails;
        if (currentUser != null) {
            return "redirect:/user-page";
        } else return "redirect:/";
    }

    @GetMapping("/")
    public String getIndex(ModelMap map) {
        map.addAttribute("allUsers", new User());
        map.addAttribute("allNumber", numberRepository.findAll());
        return "index";
    }

    @GetMapping("/user-page")
    public String userPage(ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser) {
        modelMap.addAttribute("currentUser", currentUser.getUser());
        modelMap.addAttribute("number", new Number());
        return "user-page";
    }

    @GetMapping("/register")
    public String pageRegister(ModelMap modelMap) {
        modelMap.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/even_number")
    public String evenNumber(ModelMap modelMap) {
        List<Number> all = numberRepository.findAll();
        List<Number> all1 = new ArrayList<>();
        for (Number number : all) {
            if (number.getOddNumber() == 0) {
                all1.add(number);
            }
        }
        modelMap.addAttribute("evenNumbers",all1);
        return "odd_even_number";
    }

    @GetMapping("/odd_number")
    public String oddNumber(ModelMap modelMap) {
        List<Number> all = numberRepository.findAll();
        List<Number> all1 = new ArrayList<>();
        for (Number number : all) {
            if (number.getEvenNumber() == 0 && number.getOddNumber()!=0) {
                all1.add(number);
            }
        }
        modelMap.addAttribute("oddNumbers",all1);
        return "odd_even_number";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute User user) {
        user.setUserType(UserType.USER);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "redirect:/";
    }

    @PostMapping("/addNumber")
    public String addNumber(@AuthenticationPrincipal CurrentUser currentUser,
                            @ModelAttribute Number number) {
        User user = currentUser.getUser();
        int x = number.getOddNumber();
        if (x % 2 == 0) {
            number.setEvenNumber(x);
            number.setOddNumber(0);
        } else
            number.setOddNumber(x);
        number.setUser(user);
        numberRepository.save(number);
        return "redirect:/user-page";
    }
}
