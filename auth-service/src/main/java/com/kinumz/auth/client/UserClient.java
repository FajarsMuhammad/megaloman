package com.kinumz.auth.client;

import com.kinumz.auth.dto.request.SigninRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", url = "${application.config.user-url}")
public interface UserClient {

    @GetMapping("/{username}")
    UserResponse getUser(@PathVariable String username);

    @PostMapping("/signin")
    UserResponse getUser(@RequestBody SigninRequest signin);

}
