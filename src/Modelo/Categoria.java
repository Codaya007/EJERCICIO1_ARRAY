/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.Utilidades.Utilidades;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class Categoria {

    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer id;
    private Integer minEdad;
    private Integer maxEdad;
    private String nombre;
    private String descripcion;
    private String medicinas;
    public static final String[] ALLOWED_NAMES = new String[]{
        "Niño",
        "Joven",
        "Adulto",
        "Tercera Edad"
    };

    public Categoria() {
        id = count.incrementAndGet();
    }

    public Integer getMinEdad() {
        return minEdad;
    }

    public void setMinEdad(Integer minEdad) {
        this.minEdad = minEdad;
    }

    public Integer getMaxEdad() {
        return maxEdad;
    }

    public void setMaxEdad(Integer maxEdad) {
        this.maxEdad = maxEdad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMedicinas(String medicinas) {
        this.medicinas = medicinas;
    }

    public String getMedicinas() {
        return medicinas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        System.out.println(nombre);
        if (!Utilidades.contains(ALLOWED_NAMES, nombre)) {
            throw new Error("Las categorías admitidas son " + Arrays.toString(ALLOWED_NAMES));
        }

        this.nombre = nombre;
    }

    public String getDescripcion() {
        // Si no tiene una descripción, le colocamos una por default
        if (descripcion == null) {
            this.descripcion
                    = "Categoría de personas de entre "
                    + String.valueOf(this.minEdad)
                    + " y "
                    + String.valueOf(this.maxEdad)
                    + " años de edad";
        }
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean perteneceACategoria(Persona p) {
        Integer edad = p.getEdad();

        return edad != null && edad >= minEdad && edad <= maxEdad;
    }
}
