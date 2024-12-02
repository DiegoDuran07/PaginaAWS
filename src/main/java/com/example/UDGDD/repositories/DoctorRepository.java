package com.example.UDGDD.repositories;

import com.example.UDGDD.Models.DoctorModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository

public interface DoctorRepository extends CrudRepository<DoctorModel,Long> {
    public abstract  Optional<DoctorModel> findByCode(String code);
    public abstract Optional<DoctorModel> findByNombre(String nombre);
}
