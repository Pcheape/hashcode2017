/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2017;

import java.util.ArrayList;

/**
 *
 * @author pcheape
 */
public class Pizza {

    int rows;
    int columns;
    int ingredients;
    int maxSlice;
    int curRow;
    int curCol;
    char[][] pizzaArray;

    public Pizza(int rows, int columns, int ingredients, int maxSlice) {

        this.rows = rows;

        this.columns = columns;
        this.ingredients = ingredients;
        this.maxSlice = maxSlice;
        curRow = 0;
        curCol = 0;
        pizzaArray = new char[rows][columns];

    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getIngredients() {
        return ingredients;
    }

    public int getMaxSlice() {
        return maxSlice;
    }

    public char[][] getPizzaArray() {
        return pizzaArray;
    }

    public void addIng(char ing) {

        pizzaArray[curRow][curCol] = ing;
        if (columns == curCol + 1) {
            curCol = 0;
            curRow++;
        } else {
            curCol++;
        }
    }

    public void slicePizza() {
       
        int tomatoCount = 0;
        int mushroomCount = 0;
        int currentCount = 0;
        int currentCol = 0;
     
        boolean valid = false;

        ArrayList slices = new ArrayList();
        int totalSlices = 0;

        for(int j = 0; j < pizzaArray[0].length;j++){
            for(int i = 0 ; i < pizzaArray.length;i++){
                if(pizzaArray[i][j] == 'T'){
                    tomatoCount++;
                }
                if(pizzaArray[i][j]=='M'){
                    mushroomCount++;
                }
                if((mushroomCount == ingredients)&&(tomatoCount == ingredients)){
                    valid = true;
                }
                
                if(currentCount >= maxSlice){
                    currentCount = 0;
                    currentCol = j;
                }
                if(valid){
                    totalSlices++;
                    slices.add(currentCol +" " +j+" "+i+" "+j);
                    valid = false;
                    currentCol = j;
                }
                        
                currentCount++;
            }
            
            currentCount = 0;
            mushroomCount = 0 ; 
            tomatoCount = 0 ;
            valid = false;
            currentCol =0;
           
            
        }
        
        Fileout.printOut(slices, totalSlices);
    }

}
