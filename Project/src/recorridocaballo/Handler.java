/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorridocaballo;

/**
 *
 * @author Andrés Movilla
 */
public abstract class Handler {
    
    private static Position[][] board;
    
    public static void init(int boardSize) {
	board = new Position[boardSize][boardSize];
	for (int i = 0; i < boardSize; i++) {
	    for (int j = 0; j < boardSize; j++) {
		board[j][i] = new Position(i,j);
	    }
	}
    }
    
    public static Position getPosition(int x, int y) {
	try {
	    return board[y][x];
	} catch (Exception e) {
	    return null;
	}
    }
    
}
