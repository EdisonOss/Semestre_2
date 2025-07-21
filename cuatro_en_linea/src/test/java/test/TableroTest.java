package test;

import org.junit.jupiter.api.Test;

import model.Ficha;
import model.Tablero;

import static org.junit.jupiter.api.Assertions.*;

public class TableroTest {
    @Test
    public void testColocarFicha() {
        Tablero tablero = new Tablero();
        tablero.colocarFicha(5, 0, Ficha.ROJO);
        assertEquals(Ficha.ROJO, tablero.obtenerFicha(5, 0));
    }
}