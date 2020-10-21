package app.web.pavelk.note2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @GetMapping
    @ResponseBody
    public String main(){
        return "main";
    }

}
