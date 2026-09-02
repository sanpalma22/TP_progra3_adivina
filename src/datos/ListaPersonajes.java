package datos;

import clases.Personaje;

import java.util.ArrayList;
import java.util.List;

public class ListaPersonajes {
    private List<Personaje> personajes=new ArrayList<>();
    public ListaPersonajes(){
        personajes.add(new Personaje("Masculino", false, true, "Morocho"));
        personajes.add(new Personaje("Masculino", true, false, "Colorado"));
        personajes.add(new Personaje("Masculino", false, false, "Rubio"));
        personajes.add(new Personaje("Masculino", false, true, "Colorado"));
        personajes.add(new Personaje("Masculino", true, true, "Morocho"));
        personajes.add(new Personaje("Masculino", false, false, "Colorado"));
        personajes.add(new Personaje("Masculino", true, false, "Rubio"));
        personajes.add(new Personaje("Masculino", false, true, "Rubio"));
        personajes.add(new Personaje("Masculino", false, false, "Morocho"));
        personajes.add(new Personaje("Masculino", true, true, "Colorado"));
        personajes.add(new Personaje("Masculino", true, false, "Morocho"));
        personajes.add(new Personaje("Masculino", false, true, "Morocho"));
        personajes.add(new Personaje("Femenino", false, false, "Rubio"));
        personajes.add(new Personaje("Femenino", false, true, "Morocho"));
        personajes.add(new Personaje("Femenino", true, false, "Colorado"));
        personajes.add(new Personaje("Femenino", false, false, "Morocho"));
        personajes.add(new Personaje("Femenino", false, true, "Rubio"));
        personajes.add(new Personaje("Femenino", true, true, "Morocho"));
        personajes.add(new Personaje("Femenino", false, false, "Colorado"));
        personajes.add(new Personaje("Femenino", true, false, "Morocho"));
        personajes.add(new Personaje("Femenino", false, true, "Colorado"));
        personajes.add(new Personaje("Femenino", false, false, "Rubio"));
        personajes.add(new Personaje("Femenino", true, true, "Rubio"));
    }

    public List<Personaje> getPersonajes(){
        return personajes;
    }
}
