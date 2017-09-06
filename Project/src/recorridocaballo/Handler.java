/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorridocaballo;

import java.util.ArrayList;

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
    
    public static void printList(ArrayList<Decision> list) {
	for (int i = 0; i < list.size(); i++) {
	    System.out.println((i+1)+": "+list.get(i));
	}
    }
    
    public static Position getPosition(int x, int y) {
	try {
	    return board[y][x];
	} catch (Exception e) {
	    return null;
	}
    }
    
    public static ArrayList<Decision> horse() {
	ArrayList<Decision> path = new ArrayList<>();
	path.add(new Decision(getPosition(0,0)));
	
	while (path.size() < (board.length*board.length)) {
	    
	    int lastIndex = path.size()-1;
	    int i = 0;
	    if (path.get(lastIndex).hasChosen()) {
		i = path.get(lastIndex).getChosenIndex()+1;
	    }
	    
	    // MAKE A CHOICE
	    boolean success = false;
	    while (i < 8 && !success) {
		success = path.get(lastIndex).choose(i);
		i++;
	    }
	    if (i >= 8 && !success) {
		path.remove(lastIndex);
	    } else {
		path.add(new Decision(path.get(lastIndex).getChosenPosition()));
		System.out.println("Chose to move to "+path.get(lastIndex).getChosenPosition());
	    }
	}
	
	return path;
    }
    
}
