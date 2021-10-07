package com.example.oppgaveset8;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;


// Må være en Controller
@Controller
@SpringBootApplication
public class OppgaveSet8Application {

    public static void main(String[] args) {
        SpringApplication.run(OppgaveSet8Application.class, args);
    }

    // Hvis noen går på localhost:8080/handleliste så laster vi in form.html
    // som ligger under resources/templates
    @GetMapping("/handleliste")
    public String handleliste(
/*
            HttpSession session, // Hent parameter HttpSession
            Model model          // Hent parameter Model
            */
    ){

        // GetMapping trenger ikke gjøre noe annet enn å returnere "form"
/*
         // Fra den kjørende HttpSession (session), hent Attributtet "handlekurv"
         // Dette er en List<String>.
         // session er en Map<String,Object>. I Map heter det normalt .get(), men
         // session bruker .getAttribute().

        @SuppressWarnings("unchecked") // Så den ikke gir warning om at linja under
        List<String> produkter = (List<String>) session.getAttribute("handlekurv");

        // Første gang vi kjører, finnes ikke "HANDLELISTE" i Map, og List<String> produkter = null
        // Vi lager derfor Lista
        if (produkter == null) {
            produkter = new ArrayList<>();
        }
        // Vi legger List<String> products som en Attributt til
        model.addAttribute("sessionProducts", produkter);

        // returner string som er navn på html fila vi ønsker
*/
        return "form";
    }

    // fra html fila. action="/handleliste" method="post"
    // --> html spør session--> Har du post metode "/handleliste"?
    // Session svarer, jepp, jeg kjører metoden.
    @PostMapping("/writeToList")
    public String persistMessage(@RequestParam("product") String msg, HttpSession session) {


        // Fra den kjørende HttpSession (session), hent Attributtet "handlekurv"
        // Dette er en List<String>.
        // session er en Map<String,Object>. I Map heter det normalt .get(), men
        // session bruker .getAttribute().
        @SuppressWarnings("unchecked") // Så den ikke gir warning om at linja under
        List<String> kurv = (List<String>) session.getAttribute("handlekurv");

        // Første gang vi kjører, finnes ikke "HANDLELISTE" i Map, og List<String> produkter = null
        // Vi lager derfor Lista
        if (kurv == null) {
            kurv = new ArrayList<>();
            session.setAttribute("handlekurv", kurv);
        }

        kurv.add(msg);
//        session.setAttribute("handlekurv", kurv);
        return "redirect:/handleliste";
    }

    @PostMapping("/destroy")
    public String destroySession(HttpSession session) {
        session.invalidate();
        return "redirect:/handleliste";
    }


    @GetMapping("/loginOppg2")
    public String loginWebsite(HttpSession session){
        String correctUserInfo = (String) session.getAttribute("correctLogin");
        if (correctUserInfo!=null && correctUserInfo.equals("true")){
            return "loggedin";
        }
        return "loginOppg2";
    }

    @PostMapping("/loginOppg2")
    public String checkUserNamePassword(
            HttpSession session,
            @RequestParam String username,
            @RequestParam String password,
            HttpServletResponse response,
            Model model
        ) throws InvalidUsernamePassword, IOException {
        session.setAttribute("username", username.toLowerCase());

        @SuppressWarnings("unchecked")
        List<User> userList = (List<User>) session.getAttribute("users");
        if (userList==null){
            return "loginOppg2";
        }


        User user = null;
        for (User u : userList){
            if (username.equals(u.getUsername())){
                user = u;
                break;
            }
        }
        if (user == null){
            return "loginOppg2";
        }
        String userPassword = user.getPassword();


        if (userPassword.equals(password)){
            session.setAttribute("correctLogin", "true");
            model.addAttribute("username", username);
            return "loggedin";
        }

        response.sendError(123, "booo");
//        throw new InvalidUsernamePassword();
        return "/loginOppg2";
    }

    @PostMapping("/logout")
    public String logOutButton(HttpSession session){
        session.setAttribute("correctLogin", "false");
        return "redirect:/loginOppg2";
    }

    @GetMapping("registrationform")
    public String registrationForm(){
        return "registerUser";
    }

    @PostMapping("loginOppg3")
    public String registerUser(
            HttpSession session,
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String passwordRetype
    ){
        @SuppressWarnings("unchecked")
        List<User> userList = (List<User>) session.getAttribute("users");
        if (userList==null){
            userList = new ArrayList<>();
        }
        String un = username.toLowerCase();

        for (User u : userList) {
            if (un.equals(u.getUsername())) {
                return "redirect:/registrationform";
            }
        }

        if (password.equals(passwordRetype)) {
            User user = new User(un, password);
            userList.add(user);
            session.setAttribute("users", userList);
            System.out.println(userList.size());
            return "loginOppg2";
        }

        return "redirect:/registrationform";
    }

    @PostMapping("/deleteuser")
    public String deleteUser(HttpSession session){
        String loggedInUser = (String)session.getAttribute("username");
        @SuppressWarnings("unchecked")
        List<User> userList = (List<User>)session.getAttribute("users");
        User user = null;
        for (User u : userList){
            if (u.getUsername().equals(loggedInUser)){
                user = u;
                break;
            }
        }
        userList.remove(user);
        session.setAttribute("users", userList);
        return "loginOppg2";
    }

    @GetMapping("/sessionMethods")
    public String sessionMethods(HttpSession session){
        System.out.println("Creation time");
        System.out.println(session.getCreationTime() +"\n");

        System.out.println("AttributeNames");
        for (Enumeration<String> e = session.getAttributeNames(); e.hasMoreElements();)
            System.out.println(e.nextElement());

        System.out.println();

        System.out.println(session.getMaxInactiveInterval());

        session.setMaxInactiveInterval(30);

        System.out.println(session.getMaxInactiveInterval());

        return "loginOppg2";
    }

}
