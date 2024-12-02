package com.example.UDGDD.controlles;

import com.example.UDGDD.Models.DoctorModel;
import com.example.UDGDD.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/doctor")
@CrossOrigin(origins = "*")
public class DoctorController {
    @Autowired
    DoctorService doctorService;

    //get
    @GetMapping
    public ArrayList<DoctorModel> findAllDoctors() {
        return doctorService.findAllDoctors();
    }
    //post
    @PostMapping
    public DoctorModel saveDoctor(@RequestBody DoctorModel doctor) {
        return doctorService.saveDoctor(doctor);
    }

    @GetMapping("findByCode={code}")
    public Optional<DoctorModel> findDoctorByCode(@PathVariable String code) {
        return doctorService.findDoctorByCode(code);
    }

    @GetMapping("findByName={nombre}")
    public Optional<DoctorModel> findDoctorByNombre(@PathVariable String nombre) {
        return doctorService.findDoctorByNombre(nombre);
    }

    @DeleteMapping("/deleteByCode={code}")
    public String deleteDoctorByCode(@PathVariable String code) {
        return doctorService.deleteDoctorByCode(code);
    }

    @PutMapping("/updateByCode={code}")
    public DoctorModel updateDoctorByCode(@PathVariable String code, @RequestBody DoctorModel doctor) {
        return doctorService.updateDoctorByCode(code, doctor);
    }
}
