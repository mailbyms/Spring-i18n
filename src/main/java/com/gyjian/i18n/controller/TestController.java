package com.gyjian.i18n.controller;

import com.gyjian.i18n.utils.I18nMessage;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping(value = "/test")
    public ResponseEntity<String> getRoleInfo() {
        return ResponseEntity.ok(I18nMessage.getMessage("login"));
    }
}
