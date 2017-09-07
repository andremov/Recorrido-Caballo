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
	this.chosen = -1;
	this.choices = new Position[VARIATION.length];
	generateChoices();
    }

    @Override
    public String toString() {
	return "FROM "+this.current+" TO "+this.choices[chosen];
    }

    /**
     * @return the choices
     */
    public Position[] getChoices() {
	return choices;
    }
    
    public boolean hasChosen() {
	return getChosenIndex() != -1;
    }

    /**
     * @return the chosen
     */
    public int getChosenIndex() {
	return chosen;
    }
    
    public Position getChosenPosition() {
	return choices[chosen];
    }
    
    public boolean choose(int choice) {
	try {
	    this.chosen = choice;
	    getChoices()[choice].choose();
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

    public void generateChoices() {
	for (int i = 0; i < VARIATION.length; i++) {
	    int x = this.current.getX();
	    int y = this.current.getY();
	    x += VARIATION[i][0];
	    y += VARIATION[i][1];
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
