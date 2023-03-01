package org.spring_mvc.controllers;

import com.google.gson.Gson;
import org.spring_mvc.models.Currency;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


@Controller
public class Task4 {

    @GetMapping ("/uuid")
    public String getRandomNumber (Model model) {
        Random random = new Random();

        double id = random.nextDouble();

        model.addAttribute("id", id);
        return "WEB-INF/jsps/uuid.jsp";
    }

    @GetMapping ("/exchange/{cc}")
    public ModelAndView getRandomExchange (@PathVariable String cc, ModelAndView model){
        String str = getCurrencyJsonInfo();

        Gson gson = new Gson();
        Currency[] currencyList = gson.fromJson(str, Currency[].class);
        List<Currency> list = Arrays.asList(currencyList);

        Currency currency = new Currency();

        for (Currency cur: list) {
            if (cc.equals(cur.getCc())){
                currency = cur;
            }
        }
        model.addObject("obj", currency);
        model.setViewName("exchange.jsp");
        return model;
    }

    private String getCurrencyJsonInfo() {
        StringBuilder stringBuilder;

        try {
            URL url = new URL("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json");
            URLConnection urlConnection = url.openConnection();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            stringBuilder = new StringBuilder();
            String str = "";

            while ( (str = bufferedReader.readLine() ) != null) {
                stringBuilder.append(str);
            }

        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return stringBuilder.toString();
    }

    @GetMapping ("/random")
    public ModelAndView getRandomExchangeWithCurrency (ModelAndView model){
        Random random = new Random();

        String str = getCurrencyJsonInfo();
        Gson gson = new Gson();
        Currency [] currencyList = gson.fromJson(str, Currency[].class);
        List <Currency> list = Arrays.asList(currencyList);

        int index = random.nextInt(list.size());

        model.setViewName("WEB-INF/jsps/random.jsp");
        model.addObject("obj", list.get(index));

        return model;
    }
}
