package com.example.fportal.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.fportal.modals.Item;
import com.example.fportal.modals.User;
import com.example.fportal.services.ItemService;

@Controller
public class HomeController {

    @Autowired
    private ItemService itemService;

    List<Item> kart=new ArrayList<>();

    @RequestMapping("/")
    public String index(Model model, HttpSession session){
        
        model.addAttribute("listOfItems",itemService.listOfItems());
        //User user=new User("pratik","pratik@gmail.com","12345","9890080586","pune");
        User u=(User)session.getAttribute("user");
        User u1=(User)session.getAttribute("loggedinuser");
        model.addAttribute("user",u);
        model.addAttribute("loggedinuser",u1);
        return "index";
    }

    @RequestMapping(value="/viewKart/{id}")
    public String addtoKart(@PathVariable int id, HttpSession session, Model model, RedirectAttributes redirectAttributes){
        int totalPrice=0;
        Item item=itemService.findItemById(id);

        if(item.getQuantity()>0)
            kart.add(item);
        else
            redirectAttributes.addFlashAttribute("itemOutOfStock","Item is out of Stock");

        for (Item sample:
                kart) {
            totalPrice += sample.getPrice();
        }
        kart.forEach(System.out::println);
        session.setAttribute("kart",kart);
        session.setAttribute("price",totalPrice);
        model.addAttribute("loggedinuser",(User)session.getAttribute("loggedinuser"));
        model.addAttribute("user",(User)session.getAttribute("user"));
        return "kart";
    }
    @RequestMapping(value = "/removeItem/{id}")
    public String removeItem(@PathVariable int id,HttpSession session){
        int i=0;
        int totalPrice=0;
        Item remove=new Item();

        for (Item item:kart) {
            if(item.getId()==id){
                remove=item;
                break;
            }
        }
        kart=(List<Item>) session.getAttribute("kart");
        kart.remove(remove);
        for (Item sample:
                kart) {
            totalPrice += sample.getPrice();
        }
        session.setAttribute("kart",kart);
        session.setAttribute("price",totalPrice);
        kart.forEach(System.out::println);

        return "kart";
    }

    @RequestMapping(value = "/viewKart")
    public String viewKart(Model model,HttpSession session){
        kart.forEach(System.out::println);
        model.addAttribute("loggedinuser",(User)session.getAttribute("loggedinuser"));
        model.addAttribute("user",(User)session.getAttribute("user"));
        return "kart";
    }
    
    @RequestMapping("/newItem")
    public String newItem(Map map){
        Item item=new Item();
        map.put("newItem",item);
        return "newItem";
    }

    @RequestMapping(value = "/addItem",method = RequestMethod.POST)
    public String addItem(Item item, RedirectAttributes redirectAttributes){
        itemService.addItem(item);
        redirectAttributes.addFlashAttribute("addSuccess","Items added successfully");
        return "redirect:/admin";
    }

    @RequestMapping("/admin")
    public String showItemsToAdmin(Map map){
        map.put("listOfItems",itemService.listOfItems());
        return "admin";
    }

    @RequestMapping("/deleteItem/{id}")
    public String deleteItem(@PathVariable int id,RedirectAttributes redirectAttributes){

        Item item=itemService.findItemById(id);
        itemService.deleteItem(item);
        redirectAttributes.addFlashAttribute("deleteSuccess","Deleted item with id: "+id);
        return "redirect:/admin";
    }

    @RequestMapping("/updatePage/{id}")
    public String updatePage(Map map,@PathVariable int id){
        map.put("itemToBeUpdated",itemService.findItemById(id));
        return "updateItem";
    }

    @RequestMapping(value = "/updateItem",method = RequestMethod.POST)
    public String updateItem(@RequestParam("id")int id,@RequestParam("name")String name,@RequestParam("price")double price,@RequestParam("quantity")int quantity, RedirectAttributes redirectAttributes){

        Item item=itemService.findItemById(id);
       // item.setId(id);
        item.setName(name);
        item.setPrice(price);
        item.setQuantity(quantity);
        itemService.updateItem(item);
        redirectAttributes.addFlashAttribute("updateSuccess","Updated item with id: "+id);
        return "redirect:/admin";
    }
}
