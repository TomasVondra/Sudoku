/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Tom Vondra
 */
public class JedinecnostCtverce extends Pravidlo{

    @Override
    public void vymaz(int radek, int sloupec, boolean[] nastavovaniVyskytu, int[][] sudokuPole) {
        int pocatekRadek = (radek/3) *3;
        int pocatekSloupec = (sloupec/3) *3;
        for(int i = 0;i<3;i++){
            for(int j =0;j<3;j++){
                int cislo= sudokuPole[pocatekRadek+i][pocatekSloupec+j] -1;
           if(cislo!=-1){
             
             nastavovaniVyskytu[cislo]=false;
           }
            }
        }
    }
    
}
