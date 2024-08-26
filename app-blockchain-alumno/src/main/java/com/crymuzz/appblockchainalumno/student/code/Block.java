package com.crymuzz.appblockchainalumno.student.code;

import com.crymuzz.appblockchainalumno.student.entity.Alumno;
import lombok.Getter;
import lombok.Setter;

import java.security.MessageDigest;
import java.util.Date;

@Getter
@Setter
public class Block {

    private int index;
    private long timestamp;
    private Alumno data;
    private String previousHash;
    private String hash;

    public Block(int index, Alumno data, String previousHash) {
        this.index = index;
        this.timestamp = new Date().getTime();
        this.data = data;
        this.previousHash = previousHash;
        this.hash = calculateHash();
    }

    // Método para calcular el hash del bloque
    public String calculateHash() {
        String input = index + Long.toString(timestamp) + data.toString() + previousHash;
        return applySha256(input);
    }

    // Función para aplicar el algoritmo SHA-256 al contenido del bloque
    public static String applySha256(String input) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getHash() {
        return hash;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    @Override
    public String toString() {
        return "Bloque #" + index + " [DNI Alumno: " + data.getDni() + ", Nombre: " + data.getNombre() +
                ", Hash Actual: " + hash + ", Hash Anterior: " + previousHash + "]";
    }
}