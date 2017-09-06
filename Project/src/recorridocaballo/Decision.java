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
public class Decision {
    
    private static int[][] VARIATION = { {1,2}, {-1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,1}, {-2,-1} };
    private Position current;
    private Position[] choices;
    private int chosen;

    public Decision(Position current) {
	this.current = current;
	generateChoices();
    }

    /**
     * @return the choices
     */
    public Position[] getChoices() {
	return choices;
    }

    /**
     * @return the chosen
     */
    public int getChosen() {
	return chosen;
    }
    
    public void choose(int choice) {
	this.chosen = choice;
	getChoices()[choice].choose();
    }

    public void generateChoices() {
	for (int i = 0; i < VARIATION.length; i++) {
	    int x = this.current.getX();
	    int y = this.current.getY();
	    x += VARIATION[i][1];
	    y += VARIATION[i][2];
	    this.choices[i] = Handler.getPosition(x,y);
	}
    }

    /**
     * @return the current
     */
    public Position getCurrent() {
	return current;
    }
    
}
