package no.academy.tictac;
import static no.academy.tictac.TicTacToeController.BOARD_SIZE;

public class Game {

    /**
     * Return 0 if no winner is determined yet
     * Return 1 for player 1 (Red)
     * Return 2 for player 2 (Blue)
     * Return -1 if nobody wins (draw)
     *
     * @param board a grid reprenting game squares
     * @return -1, 0, 1 or 2
     */

    int clicks = 0;

    public int determineWinner(int[][]board) {

        // Horizontal check
        for (int i = 0; i < BOARD_SIZE; i++) {
            int sum = 0;
            int elements = 0;

            for (int j = 0; j < BOARD_SIZE; j++) {
                sum += board[i][j];
                if (board[i][j] != 0) {
                    elements++;
                }
            }
            if (sum == BOARD_SIZE && elements == BOARD_SIZE) {
                return 1;
            } else if (sum == (BOARD_SIZE * 2) && elements == BOARD_SIZE) {
                return 2;
            }
        }

        // Vertical
        for (int i = 0; i < BOARD_SIZE; i++) {
            int sum = 0;
            int elements = 0;
            for (int j = 0; j < BOARD_SIZE; j++) {
                sum += board[j][i];
                if (board[j][i] != 0) {
                    elements++;
                }
                if (sum == BOARD_SIZE && elements == BOARD_SIZE) {
                    return 1;
                } else if (sum == (BOARD_SIZE * 2) && elements == BOARD_SIZE) {
                    return 2;
                }
            }
        }

        // Diagonal check
        int[] diagZeroZero = new int[BOARD_SIZE];
        int[] diagZeroMax = new int[BOARD_SIZE];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                diagZeroZero[j] = board[j][j];
                diagZeroMax[j] = board[j][BOARD_SIZE - 1 - j];
            }
            int sumZeroZero = 0;
            int elementsZeroZero = 0;
            int sumZeroMax = 0;
            int elementsZeroMax = 0;

            for (int j = 0; j < BOARD_SIZE; j++) {
                sumZeroZero += diagZeroZero[j];
                sumZeroMax += diagZeroMax[j];
                if (diagZeroZero[j] != 0) {
                    elementsZeroZero++;
                }
                if (diagZeroMax[j] != 0) {
                    elementsZeroMax++;
                }
            }
            if ((sumZeroZero == BOARD_SIZE && elementsZeroZero == BOARD_SIZE) || (sumZeroMax == BOARD_SIZE && elementsZeroMax == BOARD_SIZE)) {
                return 1;
            } else if ((sumZeroZero == 2 * BOARD_SIZE && elementsZeroZero == BOARD_SIZE) || (sumZeroMax == 2 * BOARD_SIZE && elementsZeroMax == BOARD_SIZE)) {
                return 2;
            }
        }

        // Count clicks. If clicks == max board size and no winner detected above
        // It will return -1 and declare a draw.
        clicks++;
        if (clicks == BOARD_SIZE * BOARD_SIZE) {
            clicks = 0;
            return -1;
        }

        return 0;
    }




}
