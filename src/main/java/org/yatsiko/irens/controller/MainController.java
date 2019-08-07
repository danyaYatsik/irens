package org.yatsiko.irens.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.yatsiko.irens.util.PalindromesHelper;

@Controller
public class MainController {

    @GetMapping()
    public String get() {
        return "main";
    }

    @PostMapping()
    public String post(@RequestParam String number, @RequestParam int range, Model model) {
        model.addAttribute("palindromes", PalindromesHelper.getPalindromes(number, range));
        return "main";
    }
}
