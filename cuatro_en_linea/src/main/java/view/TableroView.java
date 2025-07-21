package view;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import model.Tablero;
import model.Ficha;
import model.ReglasCuatroEnRaya;

public class TableroView extends GridPane {
    private final Tablero tablero;
    private Ficha turno = Ficha.ROJO;
    private boolean juegoTerminado = false;
    private final ReglasCuatroEnRaya reglas = new ReglasCuatroEnRaya();
    private final Label turnoLabel = new Label();

    public TableroView(Tablero tablero) {
        this.tablero = tablero;
        setHgap(10);
        setVgap(10);
        setAlignment(Pos.CENTER);
        setStyle("-fx-background-color: #e0e0e0; -fx-padding: 30;");

        turnoLabel.setText("Turno: ROJO");
        turnoLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-padding: 0 0 20 0;");
        add(turnoLabel, 0, 0, Tablero.COLUMNAS, 1);
        GridPane.setHalignment(turnoLabel, HPos.CENTER);

        render();
    }

    private void render() {
        
        getChildren().removeIf(node -> node != turnoLabel);

        for (int fila = 0; fila < Tablero.FILAS; fila++) {
            for (int col = 0; col < Tablero.COLUMNAS; col++) {
                Circle circle = new Circle(35);
                circle.setStroke(Color.BLACK);
                circle.setStrokeWidth(3);

                Ficha ficha = tablero.obtenerFicha(fila, col);
                if (ficha == Ficha.ROJO) circle.setFill(Color.RED);
                else if (ficha == Ficha.AMARILLO) circle.setFill(Color.YELLOW);
                else circle.setFill(Color.WHITE);

                int finalCol = col;
                circle.setOnMouseClicked((MouseEvent e) -> colocarFicha(finalCol));

                StackPane cell = new StackPane(circle);
                cell.setPrefSize(80, 80);
                cell.setAlignment(Pos.CENTER);

                add(cell, col, fila + 1); 
            }
        }
    }

    private void colocarFicha(int columna) {
        if (juegoTerminado) return;
        try {
            boolean fichaColocada = false;
            for (int fila = Tablero.FILAS - 1; fila >= 0; fila--) {
                if (tablero.obtenerFicha(fila, columna) == Ficha.VACIO) {
                    tablero.colocarFicha(fila, columna, turno);

                    if (reglas.verificarGanador(tablero, fila, columna)) {
                        juegoTerminado = true;
                        mostrarGanador(turno);
                        turnoLabel.setText("Ganador: " + (turno == Ficha.ROJO ? "ROJO" : "AMARILLO") );
                    } else if (reglas.verificarEmpate(tablero)) {
                        juegoTerminado = true;
                        mostrarEmpate();
                        turnoLabel.setText("Empate");
                    } else {
                        turno = (turno == Ficha.ROJO) ? Ficha.AMARILLO : Ficha.ROJO;
                        turnoLabel.setText("Turno: " + (turno == Ficha.ROJO ? "ROJO" : "AMARILLO"));
                    }

                    render();
                    fichaColocada = true;
                    break;
                }
            }
            if (!fichaColocada) {
                throw new IllegalStateException("La columna está llena");
            }
        } catch (IllegalArgumentException e) {
            mostrarError("Columna inválida: " + e.getMessage());
        } catch (IllegalStateException e) {
            mostrarError("No se pudo colocar la ficha: " + e.getMessage());
        } catch (Exception e) {
            mostrarError("Error inesperado: " + e.getMessage());
        }
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarGanador(Ficha ganador) {
        Alert alert = new Alert(AlertType.INFORMATION);
        String color = (ganador == Ficha.ROJO) ? "ROJO" : "AMARILLO";
        alert.setTitle("El juego ha llegado a su fin");
        alert.setHeaderText(null);
        alert.setContentText("El ganador es el color " + color );
        alert.showAndWait();
    }

    private void mostrarEmpate() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("El juego ha terminado");
        alert.setHeaderText(null);
        alert.setContentText("Empate");
        alert.showAndWait();
    }
}