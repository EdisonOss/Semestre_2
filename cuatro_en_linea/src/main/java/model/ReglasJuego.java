package model;

public interface ReglasJuego {
    boolean verificarGanador(Tablero tablero, int fila, int columna);
    boolean verificarEmpate(Tablero tablero);
}
