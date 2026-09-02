package clases;

public class Personaje {

    private String genero;
    private boolean calvicie;
    private boolean lentes;
    private String colorPelo;

    public Personaje(String genero, boolean calvicie, boolean lentes, String colorPelo) {
        this.genero = genero;
        this.calvicie = calvicie;
        this.lentes = lentes;
        this.colorPelo = colorPelo;
    }

    public String getGenero() {
        return genero;
    }

    public boolean isCalvicie() {
        return calvicie;
    }

    public boolean isLentes() {
        return lentes;
    }

    public String getColorPelo() {
        return colorPelo;
    }
}
