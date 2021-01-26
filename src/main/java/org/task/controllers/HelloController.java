package org.task.controllers;

import org.json.JSONException;
import org.json.simple.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.task.Parser;

import java.io.IOException;


@Controller
public class HelloController {

    @GetMapping("/index")
    public String hello(){return "index";}
}
