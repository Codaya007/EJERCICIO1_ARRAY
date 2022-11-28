/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vista;

import Modelo.Persona;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author vivi
 */
public class ModeloTabla extends AbstractTableModel {

    private Persona personas[] = new Persona[25];

    // [1, 2, 3, 4]
    public int ultimoElementoOcupado() {
        int ocupada = 0;

        for (Persona persona : personas) {
            if (persona == null) {
                return ocupada;
            }
            ocupada += 1;
        }

        return ocupada;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public void setPersonas(Persona[] personas) {
        this.personas = personas;
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public int getRowCount() {
        return ultimoElementoOcupado();
    }

    @Override
    public String getColumnName(int i) {

        switch (i) {
            case 0:
                return "ID";
            case 1:
                return "Nombres";
            case 2:
                return "Genero";
            case 3:
                return "Edad";
            case 4:
                return "Categoría";
            case 5:
                return "Medicinas";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Persona persona = null;

        try {
            persona = personas[i];
        } catch (Exception ex) {
            System.out.println("Error getValueAt, Modelo tabla" + ex);
        }

        switch (i1) {
            case 0:
                return (persona != null) ? persona.getId() : (i + 1);
            case 1:
                return (persona != null) ? persona.getNombres() : "NO DEFINIDO";
            case 2:
                return (persona != null) ? persona.getGenero() : "NO DEFINIDO";
            case 3:
                return (persona != null) ? persona.getEdad() : "NO DEFINIDO";
            case 4:
                return (persona != null && persona.getCategoria() != null)
                        ? persona.getCategoria().getNombre()
                        : "NO HAY CATEGORÍA";
            case 5:
                return (persona != null && persona.getCategoria() != null)
                        ? persona.getCategoria().getMedicinas()
                        : "NO HAY TRATAMIENTO DEFINIDO";
            default:
                return null;
        }
    }

}
