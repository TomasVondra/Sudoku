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
public class Starter {
    
    public static void main(String[] args) throws Exception {
        Sudoku sudoku = new Sudoku(3);
        sudoku.generuj(); 
        System.out.println(sudoku);
        sudoku.prohazuj();
        sudoku.deruj();
        sudoku.vypis();
    }
   
}