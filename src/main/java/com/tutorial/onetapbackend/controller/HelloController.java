package com.tutorial.onetapbackend.controller;

import com.tutorial.onetapbackend.dto.MessageDto;
import com.tutorial.onetapbackend.model.UserModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class HelloController {

    @GetMapping("/hello")
    public ResponseEntity<MessageDto> hello() {
        UserModel userModel = (UserModel) SecurityContextHolder.getContext().getAuthentication();
        String message = "hello " + userModel.getName() + " from spring boot";
        String picture = userModel.getPicture();
        MessageDto dto = new MessageDto(message, picture);
        return ResponseEntity.ok(dto);
    }
}
