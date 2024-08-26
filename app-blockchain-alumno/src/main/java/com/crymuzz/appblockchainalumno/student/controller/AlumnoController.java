package com.crymuzz.appblockchainalumno.student.controller;


import com.crymuzz.appblockchainalumno.student.code.Block;
import com.crymuzz.appblockchainalumno.student.entity.Alumno;
import com.crymuzz.appblockchainalumno.student.repository.AlumnoBlockRepository;
import com.crymuzz.appblockchainalumno.student.repository.IAlumnoRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blockchain")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoBlockRepository alumnoRepository;


    @PostMapping
    public ResponseEntity<Block> createBlock(@RequestBody @Valid Alumno alumno) {
        return new ResponseEntity<>(this.alumnoRepository.addAlumno(alumno), HttpStatus.CREATED);
    }


    @GetMapping("/blocks")
    public ResponseEntity<List<Block>> findAllBlocks() {
        return ResponseEntity.ok(this.alumnoRepository.findAllBlocks());
    }

    @GetMapping("/alumnos")
    public ResponseEntity<List<Alumno>> findAllAlumnos() {
        return ResponseEntity.ok(this.alumnoRepository.findAll());
    }

    @PutMapping("/update/{hash}")
    public ResponseEntity<?> updateAlumno(@PathVariable String hash, @RequestBody @Valid Alumno alumno) {
        boolean state = this.alumnoRepository.updateAlumno(hash, alumno);
        return new ResponseEntity<>(state ? "Modificado correctamente" : "Error", HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<String> countSizeBlockChain() {
        int elementos = this.alumnoRepository.count();
        return ResponseEntity.ok(elementos > 0 ? "Cantidad de bloques: " + elementos : "Sin elementos");
    }


}
