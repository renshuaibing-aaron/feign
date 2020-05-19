package com.aaron.ren.controller;

import com.aaron.ren.request.UserAddRequest;
import com.aaron.ren.response.UserResponse;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    public UserResponse get(@RequestParam("id") Integer id) {
        return new UserResponse().setId(id)
                .setName("昵称：" + id).setGender(id % 2 == 0 ? 1 : 2);
    }

    @GetMapping("/list")
    public List<UserResponse> list(@RequestParam(value = "name", required = false) String name,
                                   @RequestParam(value = "gender", required = false) Integer gender) {
        List<UserResponse> users = new ArrayList<>();
        for (int id = 1; id <= 3; id++) {
            users.add(new UserResponse().setId(id)
                .setName(name + "_" + id).setGender(gender));
        }
        return users;
    }

    @PostMapping("/add")
    public Integer add(@RequestBody UserAddRequest request) {
        System.out.println("昵称：" + request.getName());
        System.out.println("性别：" + request.getGender());
        return 1;
    }

}
