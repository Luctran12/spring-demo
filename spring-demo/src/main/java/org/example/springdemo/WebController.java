package org.example.springdemo;

import jakarta.servlet.http.HttpSession;
import model.Cart;
import model.Info;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

//    @GetMapping("/profile")
//    public String profile(Model model){
//        // Tạo ra thông tin
//        List<Info> profile = new ArrayList<>();
//        profile.add(new Info("fullname", "Nguyễn Hoàng Nam"));
//        profile.add(new Info("nickname", "lốddaf"));
//        profile.add(new Info("gmail", "loda.namnh@gmail.com"));
//        profile.add(new Info("facebook", "https://www.facebook.com/nam.tehee"));
//        profile.add(new Info("website", "https://loda.me"));
//        String day = "10-12-2004";
//        // Đưa thông tin vào Model
//        model.addAttribute("lodaProfile", profile);
//        model.addAttribute("today",day);
//        // TRả về template profile.html
//        return "profile";
//    }
    @PostMapping("/loginController")
    public String loginController(@RequestParam("user") String user, @RequestParam("pass") String pass, Model model, HttpSession session) {
        System.out.println("login process");
        Cart cart = (Cart)session.getAttribute("cart");
        if(cart == null) { cart = new Cart(); session.setAttribute("cart", cart); }
       System.out.println(user+" "+pass);
       if(user.equals("ad") && pass.equals("123")){
           return "profile.html";
       }
       model.addAttribute("mess","Wrong account");
       return "index.html";
    }

    @PostMapping("/cartController")
    public String cartController(Model model, @RequestParam("item") String item, HttpSession session){

        Cart cart = (Cart)session.getAttribute("cart");
        if(cart == null) { cart = new Cart(); session.setAttribute("cart", cart); }
        Info pc = new Info("PC",50,0);
        Info phone = new Info("phone",5,0);
        if(item.equals("PC")) {
            cart.addItem(pc);
        } else if (item.equals("phone")) {
            cart.addItem(phone);
        }
        Model model1 = model;
        model1.addAttribute("cart",cart.getItems());
        return "profile.html";
    }

    @PostMapping("/deleteItemController")
    public String deleteItemController(Model model, @RequestParam("deleteInfo") String deletInfo, HttpSession session){
        String itemName = deletInfo;
        Cart cart = (Cart)session.getAttribute("cart");
        for(Info item : cart.getItems()) {
            if(item.getName().equals(itemName)) {
                if(item.getQuantity() == 1) {
                    cart.getItems().remove(item);
                    model.addAttribute("cart", cart.getItems());
                    return "profile.html";
                } else if(item.getQuantity() > 1){
                    int index = cart.getItems().indexOf(item);
                    cart.getItems().get(index).setQuantity(item.getQuantity()-1);
                }
            }
        }
        model.addAttribute("cart", cart.getItems());
        return "profile.html";
    }
    @GetMapping("/viewItem")
    public String viewItem(Model model, HttpSession session){


        return "profile.html";
    }
}
