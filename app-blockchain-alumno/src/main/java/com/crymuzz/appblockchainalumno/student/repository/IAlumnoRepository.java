package com.crymuzz.appblockchainalumno.student.repository;

import com.crymuzz.appblockchainalumno.student.code.Block;
import com.crymuzz.appblockchainalumno.student.entity.Alumno;

import java.util.List;


public interface IAlumnoRepository {

    Block addAlumno(Alumno alumno);
    boolean updateAlumno(String dni, Alumno alumno);
    int count();
    List<Alumno> findAll();



}
