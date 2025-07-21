package model;

public class EstadoEnCurso implements EstadoJuego {
    private final ReglasJuego reglas;

    public EstadoEnCurso(ReglasJuego reglas) {
        this.reglas = reglas;
    }

    @Override
    public EstadoJuego procesarJugada(EmpezarJugada jugadaStrategy, Jugador jugador, int columna) {
        int fila = jugadaStrategy.ejecutar(jugador.getColor(), columna);
        
        if (reglas.verificarGanador(jugadaStrategy.getTablero(), fila, columna)) {
            return new EstadoGanado(jugador);
        }
        
        if (reglas.verificarEmpate(jugadaStrategy.getTablero())) {
            return new EstadoEmpate();
        }
        
        return this;
    }

    @Override
    public Jugador getGanador() {
        return null;
    }

    @Override
    public boolean juegoTerminado() {
        return false;
    }
}
