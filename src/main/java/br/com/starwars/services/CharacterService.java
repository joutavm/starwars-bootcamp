package br.com.starwars.services;

import br.com.starwars.Model.Character;
import br.com.starwars.repository.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {


    CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> findAll(){
        return characterRepository.findAll();
    }

    public List<Character> findByName(String name) {
        return characterRepository.findByName(name);
    }
}
