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
    
    private Position current;
    private Position[] choices;
    private int chosen;

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
    }

    public void generateChoices(int boundary) {
	
    }

    /**
     * @return the current
     */
    public Position getCurrent() {
	return current;
    }

    /**
     * @param current the current to set
     */
    public void setCurrent(Position current) {
	this.current = current;
    }
    
}
