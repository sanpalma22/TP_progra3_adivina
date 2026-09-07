package funcionalidades;

import personaje.Personaje;
import buscador.BuscadorVirtual;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Funcionalidades {

    public List<Personaje> inicializarPersonajes() {
        List<Personaje> lista = new ArrayList<>();
        lista.add(new Personaje(0, "Ana", "Mujer", false, true, "negro"));
        lista.add(new Personaje(0, "Juan", "Hombre", true, false, "amarillo"));
        lista.add(new Personaje(0, "Maria", "Mujer", false, false, "colorado"));
        lista.add(new Personaje(0, "Pedro", "Hombre", false, true, "negro"));
        lista.add(new Personaje(0, "Lucia", "Mujer", false, true, "amarillo"));
        lista.add(new Personaje(0, "Carlos", "Hombre", true, true, "negro"));
        lista.add(new Personaje(0, "Sofia", "Mujer", false, false, "negro"));
        lista.add(new Personaje(0, "Luis", "Hombre", false, false, "colorado"));
        lista.add(new Personaje(0, "Marta", "Mujer", false, true, "colorado"));
        lista.add(new Personaje(0, "Diego", "Hombre", true, false, "negro"));
        lista.add(new Personaje(0, "Elena", "Mujer", false, false, "amarillo"));
        lista.add(new Personaje(0, "Jorge", "Hombre", false, true, "amarillo"));
        lista.add(new Personaje(0, "Clara", "Mujer", false, false, "colorado"));
        lista.add(new Personaje(0, "Raul", "Hombre", true, true, "amarillo"));
        lista.add(new Personaje(0, "Paula", "Mujer", false, true, "negro"));
        lista.add(new Personaje(0, "Mario", "Hombre", false, false, "negro"));
        lista.add(new Personaje(0, "Laura", "Mujer", false, false, "negro"));
        lista.add(new Personaje(0, "Pablo", "Hombre", true, false, "colorado"));
        lista.add(new Personaje(0, "Carmen", "Mujer", false, true, "colorado"));
        lista.add(new Personaje(0, "Andres", "Hombre", false, true, "colorado"));
        lista.add(new Personaje(0, "Silvia", "Mujer", false, false, "amarillo"));
        lista.add(new Personaje(0, "Fernando", "Hombre", true, true, "colorado"));
        lista.add(new Personaje(0, "Teresa", "Mujer", false, true, "amarillo"));
        return lista;
    }

    public void ordenarPorGeneroYAutoincrementar(List<Personaje> lista) {
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - i - 1; j++) {
                if (lista.get(j).getGenero().compareTo(lista.get(j + 1).getGenero()) > 0) {
                    Personaje temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }
        for (int i = 0; i < lista.size(); i++) {
            lista.get(i).setId(i + 1);
        }
    }

    public void prepararPartida() {
        Scanner scanner = new Scanner(System.in);
        BuscadorVirtual buscador = new BuscadorVirtual();

        List<Personaje> tableroBase = inicializarPersonajes();
        ordenarPorGeneroYAutoincrementar(tableroBase);

        Map<Integer, Personaje> diccionarioPersonajes = new HashMap<>();
        for (Personaje p : tableroBase) {
            diccionarioPersonajes.put(p.getId(), p);
        }

        Random random = new Random();

        System.out.println("=== Adivina Quién ===");
        System.out.println("1. Jugar contra máquina");
        System.out.println("2. Ver simulación");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        if (opcion == 1) {
            Personaje elegidoPorMaquina = tableroBase.get(random.nextInt(tableroBase.size()));
            for (Personaje p : tableroBase) {
                System.out.println(p.toString());
            }
            System.out.println("\nElegí el ID de tu personaje secreto (1-23):");
            int idElegido = scanner.nextInt();

            Personaje elegidoPorHumano = diccionarioPersonajes.get(idElegido);

            if (elegidoPorHumano != null) {
                List<Personaje> tableroHumano = new ArrayList<>(tableroBase);
                List<Personaje> tableroMaquina = new ArrayList<>(tableroBase);
                buscador.jugarHumanoVsMaquina(tableroHumano, tableroMaquina, elegidoPorMaquina, elegidoPorHumano);
            } else {
                System.out.println("ID inválido.");
            }
        } else if (opcion == 2) {
            Personaje objetivoMaquinaA = tableroBase.get(random.nextInt(tableroBase.size()));
            Personaje objetivoMaquinaB = tableroBase.get(random.nextInt(tableroBase.size()));

            List<Personaje> tableroMaquinaA = new ArrayList<>(tableroBase);
            List<Personaje> tableroMaquinaB = new ArrayList<>(tableroBase);

            buscador.jugarMaquinaVsMaquina(tableroMaquinaA, tableroMaquinaB, objetivoMaquinaA, objetivoMaquinaB);
        } else {
            System.out.println("Opción incorrecta.");
        }
    }
}