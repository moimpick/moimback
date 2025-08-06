package org.jpetto.moimback.calender.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class CalenderController {
    @GetMapping
    public String getCalender() {
        return "Calender";
    }
}
