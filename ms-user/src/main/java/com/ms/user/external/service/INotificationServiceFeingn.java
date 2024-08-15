package com.ms.user.external.service;

import com.ms.user.dto.EmailDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "NOTIFICATIONS/v1/notification")
public interface INotificationServiceFeingn {
    @PostMapping("/email")
     ResponseEntity<?> sendEmail(@RequestBody EmailDTO emailDTO);
}
