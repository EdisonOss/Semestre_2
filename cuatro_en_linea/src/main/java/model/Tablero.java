package model;

	//Se crean las variables de las filas y coloumnas que seran tipo estaticas
	//ya que estan nunca cambiaran
	//Se crearan las variables como tipo final para evitar que sean alteradas 
	//por algun bug o error
	//Se sigue el formato private para crear una clase
public class Tablero {
    public static final int FILAS = 6;
    public static final int COLUMNAS = 7;
    private Ficha[][] grid;

    public Tablero() {
        grid = new Ficha[FILAS][COLUMNAS];
        for (int i = 0; i < FILAS; i++)
            for (int j = 0; j < COLUMNAS; j++)
                grid[i][j] = Ficha.VACIO;
    }

    public Ficha obtenerFicha(int fila, int columna) {
        return grid[fila][columna];
    }

    public void colocarFicha(int fila, int columna, Ficha ficha) {
        grid[fila][columna] = ficha;
    }
    
    public Ficha[][] getCeldas() {
    return grid;
    }

    public boolean columnaDisponible(int columna) {
    return grid[0][columna] == Ficha.VACIO;
    }
}