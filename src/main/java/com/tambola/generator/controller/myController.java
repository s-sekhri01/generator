package com.tambola.generator.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class myController {
    @GetMapping(value = "/getCard")
    public int[][] getPage() {
        int [][] card = generateLogic.getCard();
        return card;
    }
}
