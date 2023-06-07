package com.example.example.controller;


import com.example.example.entity.User;
import com.example.example.entity.Role;
import com.example.example.security.CurrentUser;
//import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Controller
public class MainController {
//    @Value("${listam.upload.image.path}")
//    private String imageUploadPath;

    @GetMapping("/")
    public String main(/*ModelMap modelMap, @AuthenticationPrincipal CurrentUser currentUser*/){
        //login exac usery gtnvum e aystex -> SecurityContextHolder.getContext().getAuthentication().getPrincipal()
        //bajc ajs dzevov chenq anum vortev springy aveli lav dzev e asum
//        Object currentUserObj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        if(currentUserObj instanceof CurrentUser){
//            CurrentUser currentUser = (CurrentUser) currentUserObj;
//            modelMap.addAttribute("user",currentUser.getUser());
//        }


        //@AuthenticationPrincipal anotacian talis e et pahin login exac userin
//        if(currentUser != null){
//            modelMap.addAttribute("user",currentUser.getUser());
//        }
        return "index";
    }



    @GetMapping("/customLogin")
    public String customLogin() {
        return "customLoginPage";
    }

//    @GetMapping("/customSuccessLogin")
//    public String customSuccessLogin(@AuthenticationPrincipal CurrentUser currentUser) {
//        if (currentUser != null) {
//            User user = currentUser.getUser();
//            if(user.getRole() == Role.ADMIN){
//                return "redirect:/user/admin";
//            }else if(user.getRole() == Role.USER){
//                return "redirect:/";
//            }
//        }
//        return "redirect:/";
//    }

}
