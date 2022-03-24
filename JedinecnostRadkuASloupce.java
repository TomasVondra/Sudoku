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
public class JedinecnostRadkuASloupce extends Pravidlo{

    @Override
    public void vymaz(int radek, int sloupec, boolean[] nastavovaniVyskytu, int[][] sudokuPole) {
        for(int j=0;j<9;j++){
            int cislo= sudokuPole[radek][j] -1;
           if(cislo!=-1){
             
             nastavovaniVyskytu[cislo]=false;
           }
        }
    for(int j=0;j<9;j++){
           int cislo= sudokuPole[j][sloupec] -1;
           if(cislo!=-1){
             
             nastavovaniVyskytu[cislo]=false;
           }
           
        }
    }
    
}
