package org.spring_mvc.controllers;

import org.spring_data.repos.UserRepoI;
import org.spring_data.task_2.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping ("/repo")
public class UserController {
    private UserRepoI repo;

    @Autowired
    public void setRepo (UserRepoI repo) {
        this.repo = repo;
    }

    @GetMapping ("/all")
    public ModelAndView getStart (ModelAndView model) {
        List<User> all = (List<User>) repo.findAll();
        model.addObject("users", all);
        model.setViewName("all.jsp");
        return model;
    }

    @GetMapping ("/add")
    public ModelAndView addUserGet (ModelAndView model) {
        model.setViewName("add.jsp");
        return model;
    }

    @PostMapping("/add")
    public ModelAndView addUSer (@ModelAttribute("user") User user,
                                ModelAndView model) {
        repo.save(user);
        model.addObject("users", user);
        model.setViewName("redirect: /repo/all");
        return model;
    }

    @GetMapping ("/delete/{id}")
    public ModelAndView deleteUserById (ModelAndView model, @PathVariable ("id") long id) {
        repo.deleteById(id);
        model.setViewName("redirect: /repo/all");
        return model;
    }

    @GetMapping ("/update")
    public ModelAndView updateUser (ModelAndView model) {
        model.setViewName("update.jsp");
        return model;
    }

//    @PostMapping ("/update")
//    public ModelAndView updateUserById (ModelAndView model, @ModelAttribute("user") User user) {
//        repo.updateUserById(user.getName(), user.getSurname(), user.getAge(), user.getTelephone(), user.getId());
//        model.setViewName("redirect: /repo/all");
//        return model;
//    }


    @GetMapping ("/find/{id}")
    public ModelAndView findUserById (ModelAndView model, @PathVariable ("id") long id) {
        Optional<User> byId = repo.findById(id);
        System.out.println(repo.getUserByID(id));
        model.addObject("user", byId.get());
        model.setViewName("forward:/repo/find.jsp");
        return model;
    }
}
