package ar.edu.huergo.scaputo.sbigliardi.nextmatch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("titulo", "Next Match");
        return "index";
    }
}
