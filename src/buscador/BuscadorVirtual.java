package buscador;

import personaje.Personaje;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BuscadorVirtual {

    public List<Personaje> descartarPorGenero(List<Personaje> l, String g) {
        List<Personaje> nl = new ArrayList<>();
        for (Personaje p : l) {
            if (p.getGenero().equalsIgnoreCase(g)) nl.add(p);
        }
        return nl;
    }

    public List<Personaje> descartarPorLentes(List<Personaje> l, boolean len) {
        List<Personaje> nl = new ArrayList<>();
        for (Personaje p : l) {
            if (p.isTieneLentes() == len) nl.add(p);
        }
        return nl;
    }

    public List<Personaje> descartarPorCalvicie(List<Personaje> l, boolean c) {
        List<Personaje> nl = new ArrayList<>();
        for (Personaje p : l) {
            if (p.isEsCalvo() == c) nl.add(p);
        }
        return nl;
    }

    public List<Personaje> descartarPorPelo(List<Personaje> l, String pel) {
        List<Personaje> nl = new ArrayList<>();
        for (Personaje p : l) {
            if (p.getColorPelo().equalsIgnoreCase(pel)) nl.add(p);
        }
        return nl;
    }

    public void jugarHumanoVsMaquina(List<Personaje> th, List<Personaje> tm, Personaje om, Personaje oh) {
        Scanner sc = new Scanner(System.in);
        boolean fin = false;
        int t = 1;
        System.out.println("\nModo Jugador vs Máquina");

        while (!fin) {
            System.out.println("\n--- Turno " + t + " ---");
            System.out.println("Tu turno. Quedan " + th.size() + " sospechosos:");
            for (Personaje p : th) System.out.print("[" + p.getNombre() + "] ");
            System.out.println("\n");

            System.out.println("Elegir: 1 género, 2 lentes, 3 calvicie, 4 pelo, 5 arriesgar");
            int acc = sc.nextInt();
            sc.nextLine();

            if (acc == 1) {
                System.out.println("Género (Mujer/Hombre):");
                String gen = sc.nextLine();
                boolean r = om.getGenero().equalsIgnoreCase(gen);
                System.out.println("La máquina dice: " + (r ? "Sí" : "No"));
                if (!r) gen = gen.equalsIgnoreCase("Hombre") ? "Mujer" : "Hombre";
                th = descartarPorGenero(th, gen);
            } else if (acc == 2) {
                boolean r = om.isTieneLentes();
                System.out.println("La máquina dice: " + (r ? "Sí" : "No"));
                th = descartarPorLentes(th, r);
            } else if (acc == 3) {
                boolean r = om.isEsCalvo();
                System.out.println("La máquina dice: " + (r ? "Sí" : "No"));
                th = descartarPorCalvicie(th, r);
            } else if (acc == 4) {
                System.out.println("Color (colorado/negro/amarillo):");
                String pel = sc.nextLine();
                boolean r = om.getColorPelo().equalsIgnoreCase(pel);
                System.out.println("La máquina dice: " + (r ? "Sí" : "No"));
                if (r) {
                    th = descartarPorPelo(th, pel);
                } else {
                    List<Personaje> aux = new ArrayList<>();
                    for (Personaje p : th) {
                        if (!p.getColorPelo().equalsIgnoreCase(pel)) aux.add(p);
                    }
                    th = aux;
                }
            } else if (acc == 5) {
                System.out.println("Nombre:");
                String nom = sc.nextLine();
                if (nom.equalsIgnoreCase(om.getNombre())) {
                    System.out.println("¡Ganaste!");
                    fin = true;
                    break;
                } else {
                    System.out.println("Incorrecto");
                }
            }

            if (!fin) {
                System.out.println("\n- Turno de la máquina -");
                if (t == 1) {
                    System.out.println("Filtra género: " + oh.getGenero());
                    tm = descartarPorGenero(tm, oh.getGenero());
                } else if (t == 2) {
                    System.out.println("Filtra lentes: " + oh.isTieneLentes());
                    tm = descartarPorLentes(tm, oh.isTieneLentes());
                } else if (t == 3) {
                    System.out.println("Filtra calvicie: " + oh.isEsCalvo());
                    tm = descartarPorCalvicie(tm, oh.isEsCalvo());
                } else if (t >= 4) {
                    Personaje in = tm.get(0);
                    System.out.println("Arriesga: " + in.getNombre());
                    if (in.getNombre().equalsIgnoreCase(oh.getNombre())) {
                        System.out.println("Ganó la máquina");
                    } else {
                        System.out.println("La máquina perdió");
                    }
                    fin = true;
                }

                if(!fin) {
                    System.out.println("A la máquina le quedan " + tm.size() + " sospechosos");
                    t++;
                }
            }
        }
    }

    public void jugarMaquinaVsMaquina(List<Personaje> t1, List<Personaje> t2, Personaje o1, Personaje o2) {
        System.out.println("\nSimulación M1 vs M2");
        System.out.println("M1 es inteligente, M2 es ineficiente");

        int t = 1;
        boolean fin = false;

        while (!fin && t <= 4) {
            System.out.println("\n------------------------");
            System.out.println("      Turno " + t);
            System.out.println("------------------------");

            System.out.println("\nJuega M1");
            if (t == 1) {
                System.out.println("M1 filtra pelo: " + o2.getColorPelo());
                t1 = descartarPorPelo(t1, o2.getColorPelo());
            } else if (t == 2) {
                System.out.println("M1 filtra género: " + o2.getGenero());
                t1 = descartarPorGenero(t1, o2.getGenero());
            } else if (t == 3) {
                System.out.println("M1 filtra lentes: " + o2.isTieneLentes());
                t1 = descartarPorLentes(t1, o2.isTieneLentes());
            } else if (t == 4) {
                System.out.println("M1 filtra calvicie: " + o2.isEsCalvo());
                t1 = descartarPorCalvicie(t1, o2.isEsCalvo());
                Personaje i1 = t1.get(0);
                System.out.println("M1 arriesga: " + i1.getNombre());
                if (i1.getNombre().equalsIgnoreCase(o2.getNombre())) {
                    System.out.println("M1 ganó la partida");
                    fin = true;
                }
            }

            if (!fin && t < 4) {
                System.out.println("A M1 le quedan " + t1.size() + " sospechosos");
                for (Personaje p : t1) System.out.print("[" + p.getNombre() + "] ");
                System.out.println();
            }

            if (fin) break;

            System.out.println("\nJuega M2");
            if (t == 1) {
                System.out.println("M2 filtra género: " + o1.getGenero());
                t2 = descartarPorGenero(t2, o1.getGenero());
            } else if (t == 2) {
                System.out.println("M2 filtra lentes: " + o1.isTieneLentes());
                t2 = descartarPorLentes(t2, o1.isTieneLentes());
            } else if (t == 3) {
                System.out.println("M2 filtra calvicie: " + o1.isEsCalvo());
                t2 = descartarPorCalvicie(t2, o1.isEsCalvo());
            } else if (t == 4) {
                Personaje i2 = t2.get(0);
                System.out.println("M2 arriesga a ciegas: " + i2.getNombre());
                if (i2.getNombre().equalsIgnoreCase(o1.getNombre())) {
                    System.out.println("M2 ganó de casualidad");
                    fin = true;
                } else {
                    System.out.println("M2 falló");
                }
            }

            if (!fin && t < 4) {
                System.out.println("A M2 le quedan " + t2.size() + " sospechosos");
                for (Personaje p : t2) System.out.print("[" + p.getNombre() + "] ");
                System.out.println();
            }

            t++;
        }
    }
}