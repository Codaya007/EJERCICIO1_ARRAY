package Controlador;

import Modelo.Persona;
import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author vivi
 */
public class ctrlPersonas {

    Persona listaPersonas[] = new Persona[25];
    Integer ocupados = 0;

    public Persona[] getListaPersonas() {
        return listaPersonas;
    }

    public Integer getOcupados() {
        return ocupados;
    }

    public Persona[] getListaPersona() {
        return listaPersonas;
    }

    public Boolean setListaPersona(Persona persona) {
        if (listaPersonas.length == ocupados) {
            return false;
        }

        listaPersonas[ocupados] = persona;
        ocupados += 1;

        return true;
    }

    public int getSize() {
        return listaPersonas.length;
    }

    public void guardar() throws IOException {
        Gson json = new Gson();
        Persona[] personas = new Persona[ocupados];
        System.arraycopy(listaPersonas, 0, personas, 0, personas.length);
        String jsons = json.toJson(personas);
        FileWriter fw = new FileWriter("PersonasArray" + ".json");
        fw.write(jsons);
        fw.flush();
    }

    public void cargar() {
        try {
            System.out.println("Cargando data...");
            Gson json = new Gson();
            FileReader fr = new FileReader("PersonasArray" + ".json");
            StringBuilder jsons = new StringBuilder();
            int valor = fr.read();
            while (valor != -1) {
                jsons.append((char) valor);
                valor = fr.read();
            }
            Persona[] aux = json.fromJson(jsons.toString(), Persona[].class);
            for (int i = aux.length - 1; i >= 0; i--) {
                // insertarAlInicio estaba antes
                listaPersonas[i] = aux[i];
                ocupados += 1;
            }
        } catch (Exception e) {
            System.out.println("No se encontraron objetos guardados en el json!");
        }
    }

    // [ 1, 2, 3 ] -> posicion 1
    public void eliminarElemento(int posicion) {
        for (int i = posicion; i < getOcupados(); i++) {
            // System.out.println("Quiero eliminar posicion: " + posicion);
            listaPersonas[i] = listaPersonas[i + 1];
        }
        ocupados -= 1;
    }
}
