package com.test3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by wanqi on 17-6-6.
 */


@RestController
@RequestMapping("/demo")
public class MainController {

    @Autowired
    private GirlRepository girlRepository;


    @PostMapping(path = "/add")
    public Girl addNewGirl(@RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Girl> getAllUsers() {
        return girlRepository.findAll();
    }
}
