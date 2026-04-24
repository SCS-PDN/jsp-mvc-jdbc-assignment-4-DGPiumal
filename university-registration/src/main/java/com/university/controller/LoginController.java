package com.university.controller;

import com.university.dao.StudentDAO;
import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private StudentDAO studentDAO;

    @GetMapping("/login")
    public String showLoginPage()
    {
        return "login";
    }


    @PostMapping("/login")
    public String doLogin(@RequestParam String email,
                          @RequestParam String password,
                          HttpSession session,
                          org.springframework.ui.Model model){
                            Student student = studentDAO.findByEmailAndPassword(email, password);
                            if (student != null)
                            {
                                session.setAttribute("student", student);
                                return "redirect:/courses";
                            }else
                            {
                                model.addAttribute("error", "Invalid email or password!");
                                return "login";
                            }
                          }

    @GetMapping("/logout")
    public String doLogout(HttpSession session)
    {
        session.invalidate();
        return "redirect:/login";
    }                      
    
}
