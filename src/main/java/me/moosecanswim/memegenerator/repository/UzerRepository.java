package me.moosecanswim.memegenerator.repository;

import me.moosecanswim.memegenerator.model.Uzer;
import org.springframework.data.repository.CrudRepository;

public interface UzerRepository extends CrudRepository<Uzer,Long>{
    Uzer findByUsername(String x);
}
