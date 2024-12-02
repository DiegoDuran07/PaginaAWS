package com.example.UDGDD.services;

import com.example.UDGDD.Models.DoctorModel;
import com.example.UDGDD.repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;

    public ArrayList<DoctorModel> findAllDoctors() {
        return (ArrayList<DoctorModel>) doctorRepository.findAll();
    }

    public DoctorModel saveDoctor(DoctorModel doctor) {
        return doctorRepository.save(doctor);
    }

    public Optional<DoctorModel> findDoctorByCode(String code) {
        return doctorRepository.findByCode(code);
    }

    public Optional<DoctorModel> findDoctorByNombre(String nombre) {
        return doctorRepository.findByNombre(nombre);
    }

    public String deleteDoctorByCode(String code) {
        String response = "";
        Optional<DoctorModel> foundDoctor = findDoctorByCode(code);
        if (foundDoctor.isPresent()) {
            doctorRepository.delete(foundDoctor.get());
            response = "Doctor deleted successfully";
        } else {
            response = "Doctor not found";
        }
        return response;
    }

    public DoctorModel updateDoctorByCode(String code, DoctorModel doctor) {
        return findDoctorByCode(code).isPresent() ? doctorRepository.save(doctor) : new DoctorModel(0L,"Doctor not found","","","","","");
    }

}
