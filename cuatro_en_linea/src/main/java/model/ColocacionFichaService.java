package model;

public class ColocacionFichaService implements EmpezarJugada {
    private final Tablero tablero;

    public ColocacionFichaService(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public int ejecutar(Ficha ficha, int columna) {
        if (columna < 0 || columna >= Tablero.COLUMNAS) {
            throw new IllegalArgumentException("Columna inválida");
        }
        
        for (int fila = Tablero.FILAS - 1; fila >= 0; fila--) {
            if (tablero.obtenerFicha(fila, columna) == Ficha.VACIO) {
                tablero.colocarFicha(fila, columna, ficha);
                return fila;
            }
        }
        throw new IllegalStateException("Columna llena");
    }

    @Override
    public Tablero getTablero() {
        return tablero;
    }
}
