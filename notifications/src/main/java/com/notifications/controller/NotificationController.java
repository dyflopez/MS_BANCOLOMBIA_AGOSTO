package com.notifications.controller;


import com.notifications.dto.EmailDTO;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/v1/notification")
public class NotificationController {

    @PostMapping("/email")
    public ResponseEntity<?> sendEmail(@RequestBody EmailDTO emailDTO){
        return ResponseEntity.ok(emailDTO);
    }

}
