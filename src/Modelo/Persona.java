/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Persona {

    private static final AtomicInteger count = new AtomicInteger(0);
    private Integer id;
    private String nombres;
    private Integer dia_nacimiento;
    private Integer mes_nacimiento;
    private Integer anio_nacimiento;
    private String genero;
    private Integer edad;
    private Categoria categoria;

    public Persona() {
        id = count.incrementAndGet();
    }

    public Integer getId() {
        return id;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategory(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getDia_nacimiento() {
        return dia_nacimiento;
    }

    public void setDia_nacimiento(Integer dia_nacimiento) {
        this.dia_nacimiento = dia_nacimiento;
    }

    public Integer getMes_nacimiento() {
        return mes_nacimiento;
    }

    public void setMes_nacimiento(Integer mes_nacimiento) {
        this.mes_nacimiento = mes_nacimiento;
    }

    public Integer getAnio_nacimiento() {
        return anio_nacimiento;
    }

    public void setAnio_nacimiento(Integer anio_nacimiento) {
        this.anio_nacimiento = anio_nacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getEdad() {
        calcularEdad();
        return edad;
    }

    public Integer calcularEdad() {
        if (this.anio_nacimiento == null) {
            this.edad = null;
        } else {
            Integer anio_actual = new Date().getYear() + 1900;
            this.edad = anio_actual - this.anio_nacimiento;
        }

        return this.edad;
    }

}
