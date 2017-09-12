package me.moosecanswim.memegenerator.repository;

import me.moosecanswim.memegenerator.model.InputImage;
import org.springframework.data.repository.CrudRepository;

public interface InputImageRepository extends CrudRepository<InputImage,Long> {
    InputImage findByName(String x);
    InputImage findByStatus(Boolean x);
    Long countByName(String x);
}
