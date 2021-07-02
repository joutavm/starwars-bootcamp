package br.com.starwars.repository;

import br.com.starwars.Model.Character;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Repository
public class CharacterRepository {

    private static final File FILE = new File("starwars.json");


    ObjectMapper mapper;

    public CharacterRepository(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public List<Character> findAll() {
        List<Character> characters = new ArrayList<>();
        try {
            FileInputStream is = new FileInputStream(FILE);
            TypeReference<List<Character>> typeReference = new TypeReference<List<Character>>() {};
            characters = mapper.readValue(is, typeReference);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return characters;
    }

    public List<Character> findByName(String name) {
        return findAll().stream()
                .filter(character -> character.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT)))
                .collect(Collectors.toList());
    }

}
