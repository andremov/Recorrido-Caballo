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
	horse();
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
	String rep = "";
	try {
	    path.add(new Decision(getPosition(0,0)));
	    getPosition(0, 0).choose();
	    rep += "0";
	} catch(Exception e) {
	    System.out.println("Start up fail.");
	}
	
	while (path.size() < (board.length*board.length)) {
	    
//	    System.out.println("Doing step.");
//	    new java.util.Scanner(System.in).nextLine();
	    
	    int lastIndex = path.size()-1;
	    int i = 0;
	    if (path.get(lastIndex).hasChosen()) {
		i = path.get(lastIndex).getChosenIndex()+1;
//		System.out.println("Last choice failed, now trying from "+i+"...");
	    }
	    
	    boolean success = false;
	    while (i < 8 && !success) {
//		System.out.println("Trying choice "+i+": "+path.get(lastIndex).getChoices()[i]);
		success = path.get(lastIndex).choose(i);
		i++;
	    }
	    
	    if (i >= 8 && !success) {
		try {
		    try {
			path.get(lastIndex-1).getChosenPosition().takeBack();
		    } catch (Exception e) { }
		    rep = rep.substring(0, rep.length()-2);
		    path.remove(lastIndex);
//		    System.out.println((lastIndex-1)+": Going back to "+path.get(lastIndex-1).getCurrent());
		    System.out.println(rep);
		} catch (Exception e) {
		    break;
		}
	    } else {
		rep += " "+path.get(lastIndex).getChosenIndex();
		path.add(new Decision(path.get(lastIndex).getChosenPosition()));
//		System.out.println((lastIndex+1)+": Chose to move to "+path.get(lastIndex).getChosenPosition());
		System.out.println(rep);
	    }
	}
	
	return path;
    }
    
}
