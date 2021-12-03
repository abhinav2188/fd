package com.example.fportal.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fportal.modals.Category;
import com.example.fportal.modals.User;
import com.example.fportal.services.CategoryService;

@Controller
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/list")
    public String getList(Model model, HttpSession session){
        List<Category> categoryList = categoryService.getCategories();
        model.addAttribute("fruits",categoryList.get(0));
        model.addAttribute("vegetables",categoryList.get(1));
        model.addAttribute("loggedinuser",(User)session.getAttribute("loggedinuser"));
        model.addAttribute("user",(User)session.getAttribute("user"));
        return "category";
    }
}
