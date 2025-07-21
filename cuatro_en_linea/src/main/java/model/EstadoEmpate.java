package model;

public class EstadoEmpate implements EstadoJuego {
    @Override
    public EstadoJuego procesarJugada(EmpezarJugada jugadaStrategy, Jugador jugador, int columna) {
        return this;
    }

    @Override
    public Jugador getGanador() {
        return null;
    }

    @Override
    public boolean juegoTerminado() {
        return true;
    }
}
