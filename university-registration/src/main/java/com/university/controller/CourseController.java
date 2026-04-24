package com.university.controller;

import com.university.dao.CourseDAO;
import com.university.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import javax.servlet.http.HttpSession;


@Controller
public class CourseController {

    @Autowired
    private CourseDAO courseDAO;

    @GetMapping("/courses")
    public String showCourses(HttpSession session, Model model)
    {
        Student student = (Student) session.getAttribute("student");
        if (student == null)
        {
            return "redirect:/login";
        }
        model.addAttribute("courses", courseDAO.getAllCourses());
        model.addAttribute("student", student);
        return "courses";
    }
    
    @PostMapping("/courses/register/{courseId}")
    public String registerCourse(@PathVariable int courseId,HttpSession session,Model model)
    {
        Student student = (Student) session.getAttribute("student");

        if (student == null)
        {
            return "redirect:/login";
        }

        if (courseDAO.isAlreadyRegistered(student.getStudentId(), courseId))
        {
            model.addAttribute("message", "Already registered for this course!");
        }else
        {
            courseDAO.registerCourse(student.getStudentId(), courseId);
            model.addAttribute("message", "Successfully registered!");
        }
        return "success";
    }
}
