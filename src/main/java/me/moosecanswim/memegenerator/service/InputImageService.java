package me.moosecanswim.memegenerator.service;

import me.moosecanswim.memegenerator.model.InputImage;
import me.moosecanswim.memegenerator.repository.InputImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InputImageService {

    @Autowired
    InputImageRepository inputImageRepository;
    public InputImage findOne(long id){
       return inputImageRepository.findOne(id);
    }
    public Iterable<InputImage> findAll(){
        return inputImageRepository.findAll();
    }
    public Iterable<InputImage> findByStatus(Boolean x){
        return inputImageRepository.findAll();
    }
    public void save(InputImage ii){
        inputImageRepository.save(ii);
    }

}
