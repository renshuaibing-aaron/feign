package com.aaron.ren.feign;

import com.aaron.ren.feign.request.UserAddRequest;
import com.aaron.ren.feign.response.UserResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface UserServiceFeignClient02 {

    // 获得用户详情
    @GetMapping("/user/get")
    UserResponse get(@RequestParam("id") Integer id);

    @GetMapping("/user/list")
    List<UserResponse> list(@RequestParam("name") String name,
                            @RequestParam("gender") Integer gender);

//    @RequestLine("GET /user/list")
//    List<UserResponse> list(@QueryMap Map<String, Object> queryMap);

    @PostMapping(value = "/user/add", consumes = "application/json")
    Integer add(@RequestBody UserAddRequest request);

}
