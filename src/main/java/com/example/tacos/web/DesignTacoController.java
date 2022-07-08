package com.example.tacos.web;

import com.example.tacos.Ingredient;
import com.example.tacos.Ingredient.Type;


import com.example.tacos.Taco;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
public class DesignTacoController {

    @GetMapping
    public String showDesignForm(Model model){
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLTO","pszenna", Ingredient.Type.WRAP),
                new Ingredient("COTO", "kukurydziana", Ingredient.Type.WRAP),
                new Ingredient("GRBF", "wołowina", Ingredient.Type.PROTEIN),
                new Ingredient("CARN", "mięso", Ingredient.Type.PROTEIN),
                new Ingredient("TMTO", "pomidory", Ingredient.Type.VEGGIES),
                new Ingredient("LETC", "sałata", Ingredient.Type.VEGGIES),
                new Ingredient("CHED", "chedar", Ingredient.Type.CHEESE),
                new Ingredient("JACK", "jack", Ingredient.Type.CHEESE),
                new Ingredient("SLSA", "pomidorowy", Ingredient.Type.SAUCE),
                new Ingredient("SRCR", "smietana", Ingredient.Type.SAUCE)
        );
        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        model.addAttribute("design",new Taco());
        return "design";
    }
    private List<Ingredient> filterByType(
            List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
    @PostMapping
    public String processDesign(@Valid Taco design, Errors errors){
        if (errors.hasErrors()){
            return "design";
        }
        log.info("Przetważanie projektu: ");
        return "redirect:/orders/current";
    }
}
