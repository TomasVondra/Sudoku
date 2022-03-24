/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Random;

/**
 *
 * @author Tom
 */
public class Sudoku {

    int[][] sudokuPole = new int[9][9];
Pravidlo[] pravidla;

    public Sudoku(int slozitost) throws Exception {
        switch(slozitost){
            case 1: 
                pravidla = new Pravidlo[1];
                pravidla[0]=new JedinecnostRadkuASloupce();
                break;
            case 2:
                pravidla = new Pravidlo[2];
                pravidla[0]=new JedinecnostRadkuASloupce();
                pravidla[1]=new JedinecnostCtverce();
                break;
            default:
               throw new Exception("Neznámá složitost");
        }
    }

    public void generuj() {
        for (int radek = 0; radek < 9; radek++) {
            int pocatecniCislo = (3 * radek) % 9 + radek / 3;

            for (int sloupec = 0; sloupec < 9; sloupec++) {
                sudokuPole[radek][sloupec] = (pocatecniCislo + sloupec) % 9 + 1;

            }
        }
    }

    public void prohazuj() {
        int opakovani = 0;
        Random generator = new Random();
        while (opakovani < 100) {
            boolean jeRadek = generator.nextBoolean();
            int trojice = generator.nextInt(3);
            int index1 = generator.nextInt(3);
            int index2 = (generator.nextInt(2) + 1 + index1) % 3;
            index1 += trojice * 3;
            index2 += trojice * 3;

            if (jeRadek) {

                prohodRadky(index1, index2);

            } else {

                prohodSloupce(index1, index2);

            }
            opakovani++;
        }
    }

 int[] nahodnaCisla = new int[81];
    public void deruj() {
        
       
         
            Random generator2 = new Random();
            int nahodneCislo;
            for (int i = 0; i < 81; i++) {
                nahodneCislo = generator2.nextInt(81);
                
                for(int j = 0; j<81;j++){
                    if( nahodnaCisla[j] == nahodneCislo){
                     nahodneCislo = generator2.nextInt(81);
                       j=0;
                   }
                
           }
                nahodnaCisla[i] = nahodneCislo;
                        
            }
for(int i = 0;i<nahodnaCisla.length;i++){
    res(nahodnaCisla[i], pravidla);
}
            
        }
    

    public void res(int index, Pravidlo[] pravidla) {
        int scitac = 0;
        
        boolean[] nastavovaniVyskytu = new boolean[9];
        for(int i=0;i<nastavovaniVyskytu.length;i++){
            nastavovaniVyskytu[i] = true;
        }
        int radek = index/9;
        int sloupec = index%9;
        int puvodniHodnota = sudokuPole[radek][sloupec];
        sudokuPole[radek][sloupec]= 0;
        
        for(int i=0; i<pravidla.length;i++){
           pravidla[i].vymaz(radek, sloupec, nastavovaniVyskytu, sudokuPole);
        }
        
         
        for(int x = 0;x<9;x++){
            if(nastavovaniVyskytu[x]){
                scitac++;
            }
        }
         if(scitac!=1){
            sudokuPole[radek][sloupec]= puvodniHodnota;
         }  
    }
    
   
   

    public void vypis() {
        for (int radek = 0; radek < 9; radek++) {
            if (radek % 3 == 0) {
                System.out.println("");
            }
            for (int sloupec = 0; sloupec < 9; sloupec++) {
                if (sloupec % 3 == 0) {
                    System.out.print(" ");
                }
                System.out.print(sudokuPole[radek][sloupec]);

            }
            System.out.println("");
        }
    }

    private void prohodRadky(int index1, int index2) {
        int[] radekPolete = new int[9];

        for (int j = 0; j < 9; j++) {
            radekPolete[j] = sudokuPole[index1][j];
            sudokuPole[index1][j] = sudokuPole[index2][j];
            sudokuPole[index2][j] = radekPolete[j];

        }

    }

    private void prohodSloupce(int index1, int index2) {
        int[] sloupecPolete = new int[9];

        for (int j = 0; j < 9; j++) {
            sloupecPolete[j] = sudokuPole[j][index1];
            sudokuPole[j][index1] = sudokuPole[j][index2];
            sudokuPole[j][index2] = sloupecPolete[j];

        }

    }

}
