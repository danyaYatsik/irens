package org.yatsiko.irens.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.yatsiko.irens.dto.NumbersDto;
import org.yatsiko.irens.models.Palindrome;
import org.yatsiko.irens.services.PalindromesService;

import javax.validation.Valid;

@Controller
public class MainController {

    private final PalindromesService service;

    @Autowired
    public MainController(PalindromesService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String get(Model model) {
        model.addAttribute("palindromes", service.getAll());
        return "main";
    }

    @PostMapping("/")
    @ResponseBody
    public Palindrome post(@Valid @ModelAttribute NumbersDto numbersDto, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            Palindrome palindrome = service.createPalindrome(numbersDto.getNumber(), numbersDto.getRange());
            service.savePalindrome(palindrome);
            return palindrome;
        }
        return null;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Palindrome getOne(@PathVariable Integer id) {
        return service.getPalindrome(id);
    }
}
