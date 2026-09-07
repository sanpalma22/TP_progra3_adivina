package personaje;

public class Personaje {
    private int id;
    private String nombre;
    private String genero;
    private boolean esCalvo;
    private boolean tieneLentes;
    private String colorPelo;
    private boolean esElegido;

    public Personaje(int id, String nombre, String genero, boolean esCalvo, boolean tieneLentes, String colorPelo) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.esCalvo = esCalvo;
        this.tieneLentes = tieneLentes;
        this.colorPelo = colorPelo;
        this.esElegido = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isEsCalvo() {
        return esCalvo;
    }

    public void setEsCalvo(boolean esCalvo) {
        this.esCalvo = esCalvo;
    }

    public boolean isTieneLentes() {
        return tieneLentes;
    }

    public void setTieneLentes(boolean tieneLentes) {
        this.tieneLentes = tieneLentes;
    }

    public String getColorPelo() {
        return colorPelo;
    }

    public void setColorPelo(String colorPelo) {
        this.colorPelo = colorPelo;
    }

    public boolean isEsElegido() {
        return esElegido;
    }

    public void setEsElegido(boolean esElegido) {
        this.esElegido = esElegido;
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", genero='" + genero + '\'' +
                ", esCalvo=" + esCalvo +
                ", tieneLentes=" + tieneLentes +
                ", colorPelo='" + colorPelo + '\'' +
                ", esElegido=" + esElegido +
                '}';
    }
}