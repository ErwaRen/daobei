package com.daobei.controller;

import com.daobei.dto.SIPDto;
import com.daobei.service.SipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("common")
@RestController
public class CommonController {

    @Autowired
    private SipService sipService;

    @PostMapping("/sipSend")
    public String clickToDial(@RequestBody SIPDto sipDto) {
        sipService.sendSip(sipDto);
        return "SUCCESS";
    }
}
