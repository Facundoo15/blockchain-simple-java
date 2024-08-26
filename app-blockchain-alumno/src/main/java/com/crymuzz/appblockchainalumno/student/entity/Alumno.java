package com.crymuzz.appblockchainalumno.student.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Alumno {


    @NotBlank(message = "El campo DNI, no puede ser nulo o estar vacio")
    @Size(min = 8, max = 8, message = "El campo DNI, solo debe tener 8 digitos")
    private String dni;
    @NotBlank(message = "El campo NOMBRE, no puede ser nulo o estar vacio")
    private String nombre;


}
