package com.example;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Persona {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;
    private static List<Persona> personas;
    private Sexo sexo;

    private double salario;

    public enum Sexo {
        MASCULINO,
        FEMENINO,
        OTRO
    }

    public static List<Persona> personas() {

        personas = new ArrayList<Persona>();

        personas.add(Persona.builder().nombre("Santiago")
                .apellidos("Tamariz-Martel Marco")
                .fechaNacimiento(LocalDate.of(2000, Month.SEPTEMBER, 25))
                .sexo(Persona.Sexo.MASCULINO).salario(100).build());

        personas.add(Persona.builder().nombre("Victor")
                .apellidos("Rmachado")
                .fechaNacimiento(LocalDate.of(1970, Month.JULY, 12))
                .sexo(Persona.Sexo.MASCULINO).salario(100).build());

        personas.add(Persona.builder().nombre("Andy")
                .apellidos("Diaz")
                .fechaNacimiento(LocalDate.of(1996, Month.OCTOBER, 31))
                .sexo(Persona.Sexo.MASCULINO).salario(200).build());

        personas.add(Persona.builder().nombre("Kevin")
                .apellidos("Gonzalez")
                .fechaNacimiento(LocalDate.of(1996, Month.NOVEMBER, 20))
                .sexo(Persona.Sexo.MASCULINO).salario(400).build());

        personas.add(Persona.builder().nombre("Ruben")
                .apellidos("Pozo")
                .fechaNacimiento(LocalDate.of(1991, Month.APRIL, 18))
                .sexo(Persona.Sexo.MASCULINO).salario(400).build());

        personas.add(Persona.builder().nombre("Anibal")
                .apellidos("Gomez")
                .fechaNacimiento(LocalDate.of(2001, Month.APRIL, 4))
                .sexo(Persona.Sexo.MASCULINO).salario(400).build());

        personas.add(Persona.builder().nombre("Diana")
                .apellidos("Fernandez")
                .fechaNacimiento(LocalDate.of(1991, Month.MARCH, 11))
                .sexo(Persona.Sexo.FEMENINO).salario(400).build());

        return personas;
    }

}
