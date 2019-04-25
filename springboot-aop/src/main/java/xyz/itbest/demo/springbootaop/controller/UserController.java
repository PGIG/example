package xyz.itbest.demo.springbootaop.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.itbest.demo.springbootaop.aspect.TrackTime;

/**
 * @author pgig
 * @date 2019/4/25
 */
@RestController
@Slf4j
public class UserController {

    @PostMapping("/register")
    public String register(@RequestParam String name){
        log.info("register user. "+name);
        System.out.println("register do something");
        log.info("register success");
        return HttpStatus.OK.name();
    }

}
