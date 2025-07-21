package model;

public class Jugador {
    private final String nombre;
    private final Ficha color;

    public Jugador(String nombre, Ficha color) {
        this.nombre = nombre;
        this.color = color;
    }

    public String getNombre() {
        return nombre;
    }

    public Ficha getColor() {
        return color;
    }
}
