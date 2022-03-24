/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Tom
 */
public abstract class Pravidlo {
    public abstract void vymaz(int radek, int sloupec, boolean[] nastavovaniVyskytu, int[][] sudokuPole);
    

}
