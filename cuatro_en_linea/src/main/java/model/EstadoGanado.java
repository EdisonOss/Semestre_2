package model;

public class EstadoGanado implements EstadoJuego {
    private final Jugador ganador;

    public EstadoGanado(Jugador ganador) {
        this.ganador = ganador;
    }

    @Override
    public EstadoJuego procesarJugada(EmpezarJugada jugadaStrategy, Jugador jugador, int columna) {
        return this;
    }

    @Override
    public Jugador getGanador() {
        return ganador;
    }

    @Override
    public boolean juegoTerminado() {
        return true;
    }

    
}
