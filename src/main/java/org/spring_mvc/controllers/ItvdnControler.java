package org.spring_mvc.controllers;

import org.spring_mvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.*;
import java.util.Scanner;

@Controller
public class ItvdnControler {
//    Counter counter = new Counter();
    int count = 0;
    File file = new File("D:\\java\\itvdn.sp.hw3\\src\\main\\resources\\1.txt");
    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
    FileReader fileReader = new FileReader(file);
    Scanner in = new Scanner(fileReader);

    public ItvdnControler() throws FileNotFoundException {
    }

    @GetMapping (value = "/input")
    public String doGet () {
        return "WEB-INF/jsps/add.jsp";
    }

//    @GetMapping ("/form")
//    public ModelAndView getForm (ModelAndView model) throws IOException {
//        StringBuilder text = new StringBuilder();
//
//        while (in.hasNextLine()) {
//            text.append(in.nextLine()).append("<br>");
//        }
//
//        model.addObject("text", text);
//        model.setViewName("forward:jsp/form.jsp");
//        return model;
//    }

    @GetMapping ("/form")
    public ModelAndView getForm (ModelAndView model) throws IOException {
        StringBuilder text = new StringBuilder();

        while (in.hasNextLine()) {
            text.append(in.nextLine()).append("<br>");
        }

        model.addObject("text", text);
        model.setViewName("WEB-INF/jsps/form.jsp");
        return model;
    }

    @PostMapping (value = "/input")
    public ModelAndView doPost (@ModelAttribute ("user") User user,
                                ModelAndView model) {

        return writeToFile(user, model);
    }

    private ModelAndView writeToFile(User user, ModelAndView model) {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("User name:").append(user.getName()).append("\n");
            stringBuilder.append("User surname:").append(user.getSurname()).append("\n");
            stringBuilder.append("User age:").append(user.getAge()).append("\n");
            stringBuilder.append("\n");

            bufferedOutputStream.write(stringBuilder.toString().getBytes());

            count += 1;

            bufferedOutputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        model.setViewName("WEB-INF/jsps/summary2.jsp");
        model.addObject("count", count);

        return model;
    }

}
