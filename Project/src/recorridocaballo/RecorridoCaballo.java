/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorridocaballo;

import java.util.Scanner;

/**
 *
 * @author Andrés Movilla
 */
public class RecorridoCaballo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	Scanner s = new Scanner(System.in);
	int boardSize = -1;
	while (boardSize<=0){
	    try {
		System.out.print("Ingrese un valor para el tamaño del tablero: ");
		boardSize = s.nextInt();
	    } catch(Exception e) {
		System.out.println("Ingrese un valor valido.");
	    }
	}
		
    }
    
}
