package org.example.Hello;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@RestController
@Api
public class Hello {

    @GetMapping("/name")
    public String getPeopleMessage(@RequestParam(value = "a") String age) {
        System.out.println("这个变量的值：" + age);
        return age;
    }

    @PostMapping("/hello")
    @ApiOperation(value = "你好", notes = "12345")
    public String hello(@RequestBody @ApiParam("名称")String name) {
        return name + ", hello";
    }
}
