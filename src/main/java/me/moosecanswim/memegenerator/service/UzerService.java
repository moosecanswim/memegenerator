package me.moosecanswim.memegenerator.service;

import me.moosecanswim.memegenerator.model.Uzer;
import me.moosecanswim.memegenerator.repository.UzerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UzerService {
    @Autowired
    UzerRepository userRepository;

    public Uzer findByUsername(String input){
        return userRepository.findByUsername(input);
    }

}
