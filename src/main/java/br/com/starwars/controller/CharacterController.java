package br.com.starwars.controller;

import br.com.starwars.Model.Character;
import br.com.starwars.services.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/character")
public class CharacterController {

    CharacterService characterService;

    public CharacterController(CharacterService characterService){
        this.characterService = characterService;
    }

    @GetMapping
    public List<Character> getAll(@RequestParam(required = false) String name){
        if (name == null)
            return characterService.findAll();
        return characterService.findByName(name);
    }


}
