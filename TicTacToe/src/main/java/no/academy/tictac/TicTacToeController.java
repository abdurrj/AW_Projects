package no.academy.tictac;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class TicTacToeController {

    public static final Color PLAYER_1_COLOR = Color.RED;
    public static final Color PLAYER_2_COLOR = Color.BLUE;

    @FXML
    private GridPane gridPane;

    private int clicks = 0;

    public static final int BOARD_SIZE = 3;
    public static int[][] board = new int[BOARD_SIZE][BOARD_SIZE];

    Game game = new Game();

    @FXML
    protected void initialize() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                Rectangle square = new Rectangle(100, 100, Color.WHITE);
                int finalI = i;
                int finalJ = j;
                square.fillProperty().addListener((observable, oldValue, newValue) -> {
                    if (newValue == PLAYER_1_COLOR) {
                        board[finalI][finalJ] = 1;
                    } else if (newValue == PLAYER_2_COLOR) {
                        board[finalI][finalJ] = 2;
                    }
                });
                gridPane.add(square, j, i);
            }
        }
    }

    public void onMouseClick(MouseEvent mouseEvent) {
        if (!(mouseEvent.getTarget() instanceof Rectangle)) {
            return;
        }

        Rectangle target = (Rectangle) mouseEvent.getTarget();
        if (target.getFill() == PLAYER_1_COLOR || target.getFill() == PLAYER_2_COLOR) {
            return;
        }
        Color color = clicks++ % 2 == 0 ? PLAYER_1_COLOR : PLAYER_2_COLOR;
        target.setFill(color);

        int winner = game.determineWinner(board);
        if (winner == 0)
            return;

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game over!");
        alert.setHeaderText(null);
        String text = "It's a draw!";
        if (winner == 1) {
            text = "Player 1 (Red) wins!";
        } else if (winner == 2) {
            text = "Player 2 (Blue) wins!";
        }
        alert.setContentText(text);
        alert.setOnCloseRequest(d -> System.exit(0));
        alert.showAndWait();

    }

}