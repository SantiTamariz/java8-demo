package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.Persona.Sexo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Listado de personas para recorrerlo
        List<Persona> personas = Persona.personas();

        // Salario promedio de todas las personas
        // Se utiliza :: y no un Lambda ya que solo llama el método 
        //getSalario por referencia
        // Lo convierte a un MapDouble que tendrá una key y un valor
        var salarioPromedio = personas.stream()
                .mapToDouble(Persona::getSalario)
                .average().getAsDouble();

        //System.out.println(salarioPromedio);




        // Obtener una nueva coleccion que contenga solo las personas de Sexo.FEMENINO
        List<Persona> mujeres = Persona.personas();

        // Se pone la condición con Lambda porque además de obtener de obtener el sexo
        // se comprueba que tipo es
        // Metodo Collect suministrar lo que se añade a la colección
        mujeres = personas.stream()
                .filter(p -> p.getSexo()
                        .equals(Persona.Sexo.FEMENINO))
                .collect(Collectors.toList());

        //System.out.println(mujeres);




        //Agrupar personas por Sexo
        Map<Persona.Sexo, List<Persona>> personasPorSexo = new HashMap<>();

        //Recorrer personas normales y convertirlo en un flujo con stream
        //Como no hace nada con el getSexo() simplemente se hace con :: y no con ->
        //se podría añadir Collectors.toList() al final como operacion terminal pero no es necesario
        personasPorSexo = personas.stream().collect(Collectors.groupingBy(Persona :: getSexo));

        //System.out.println(personasPorSexo);

        //Recorremos la coleccion si vamos a hacer algún procesamiento adicional de lo contrario sysout
        //Dame las claves y los valores del Map personasPorSexo
        //De cada iteracion sacamos un mapa con sexo y lista de personas
        for( Map.Entry<Persona.Sexo, List<Persona>> entry : personasPorSexo.entrySet()){
            Persona.Sexo key = entry.getKey();
            System.out.println("Las personas del sexo " + key + " son: ");

            List<Persona> personas2 = entry.getValue();

            personas2.stream().forEach(p->System.out.println(p.getNombre()));
        }


    }
}
