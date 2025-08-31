package org.veiculos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frota")
public class FrotaController {

    @GetMapping
    public String frota() {
        return "Hello World";
    }
}
