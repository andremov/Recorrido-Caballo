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
public class Position {
    private int x;
    private int y;
    private boolean chosen;

    public Position(int x, int y) {
	this.x = x;
	this.y = y;
	this.chosen = false;
    }

    /**
     * @return the x
     */
    public int getX() {
	return x;
    }

    /**
     * @return the y
     */
    public int getY() {
	return y;
    }

    /**
     * @return the chosen
     */
    public boolean isChosen() {
	return chosen;
    }
    
    public void choose() {
	chosen = true;
    }
    
    public void takeBack() {
	chosen = false;
    }
}
