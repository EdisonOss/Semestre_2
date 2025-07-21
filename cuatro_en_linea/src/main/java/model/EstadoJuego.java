package model;

public interface EstadoJuego {
    EstadoJuego procesarJugada(EmpezarJugada jugadaStrategy, Jugador jugador, int columna);
    Jugador getGanador();
    boolean juegoTerminado();
}
