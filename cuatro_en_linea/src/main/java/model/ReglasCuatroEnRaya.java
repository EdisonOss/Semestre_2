package model;

public class ReglasCuatroEnRaya implements ReglasJuego {
    @Override
    public boolean verificarGanador(Tablero tablero, int fila, int columna) {
        Ficha[][] celdas = tablero.getCeldas();
        Ficha color = celdas[fila][columna];
        if (color == Ficha.VACIO) return false;

        return verificarDireccion(celdas, color, fila, columna, 0, 1) ||  // Horizontal
               verificarDireccion(celdas, color, fila, columna, 1, 0) ||  // Vertical
               verificarDireccion(celdas, color, fila, columna, 1, 1) ||  // Diagonal /
               verificarDireccion(celdas, color, fila, columna, 1, -1);   // Diagonal \
    }

    private boolean verificarDireccion(Ficha[][] celdas, Ficha color, int fila, int columna, int dirFila, int dirColumna) {
        int count = 1; // Incluye la ficha actual
        
        // Verificar en dirección positiva
        count += contarFichasEnDireccion(celdas, color, fila + dirFila, columna + dirColumna, dirFila, dirColumna);
        // Verificar en dirección negativa
        count += contarFichasEnDireccion(celdas, color, fila - dirFila, columna - dirColumna, -dirFila, -dirColumna);
        
        return count >= 4;
    }

    private int contarFichasEnDireccion(Ficha[][] celdas, Ficha color, int fila, int columna, int dirFila, int dirColumna) {
        int count = 0;
        int f = fila;
        int c = columna;
        
        while (f >= 0 && f < Tablero.FILAS && c >= 0 && c < Tablero.COLUMNAS && celdas[f][c] == color) {
            count++;
            f += dirFila;
            c += dirColumna;
        }
        return count;
    }

    @Override
    public boolean verificarEmpate(Tablero tablero) {
        for (int j = 0; j < Tablero.COLUMNAS; j++) {
            if (tablero.columnaDisponible(j)) return false;
        }
        return true;
    }
}
