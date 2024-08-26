package com.crymuzz.appblockchainalumno.student.repository;

import com.crymuzz.appblockchainalumno.student.code.Block;
import com.crymuzz.appblockchainalumno.student.code.BlockChain;
import com.crymuzz.appblockchainalumno.student.entity.Alumno;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AlumnoBlockRepository implements IAlumnoRepository {

    private BlockChain blockChain;

    public AlumnoBlockRepository() {
        this.blockChain = new BlockChain();
    }

    @Override
    public Block addAlumno(Alumno alumno) {
        return this.blockChain.addBlock(alumno);
    }

    @Override
    public boolean updateAlumno(String hash, Alumno alumno) {
        return this.blockChain.updateChain(hash, alumno);
    }

    @Override
    public int count() {
        return blockChain.getSizeData();
    }

    @Override
    public List<Alumno> findAll() {
        return blockChain.getDataList();
    }

    public List<Block> findAllBlocks() {
        return blockChain.getChain();
    }
}
