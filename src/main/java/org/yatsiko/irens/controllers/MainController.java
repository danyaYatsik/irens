package org.yatsiko.irens.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.yatsiko.irens.dto.NumbersDto;
import org.yatsiko.irens.models.Palindrome;
import org.yatsiko.irens.services.PalindromesService;

import javax.validation.Valid;

@Controller
public class MainController {

    private final PalindromesService service;

    public MainController(PalindromesService service) {
        this.service = service;
    }

    @GetMapping()
    public String get(Model model) {
        model.addAttribute("palindromes", service.getAll());
        return "main";
    }

    @PostMapping()
    public String post(@Valid @ModelAttribute NumbersDto numbersDto, BindingResult bindingResult, Model model) {
        if (!bindingResult.hasErrors()) {
            Palindrome palindrome = service.createPalindrome(numbersDto.getNumber(), numbersDto.getRange());
            service.savePalindrome(palindrome);
        }
        return "redirect:/main";
    }
}
