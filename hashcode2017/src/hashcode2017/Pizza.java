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
  
    public Pizza(int rowsin,int columns,int ingredients,int maxSlice){
        
        rows = rowsin;
       
        
        this.columns = columns;
        this.ingredients = ingredients;
        this.maxSlice = maxSlice;
        curRow =0;
        curCol =0;
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

    
    public void addIng(char ing){
        
        pizzaArray[curRow][curCol] = ing; 
        if(rows == curRow+1){
            curRow = 0 ; 
            curCol ++;
        }else{
            curRow++;
        }
    }
    
    public void slicePizza(){
        boolean mushroom = false;
        boolean tomato  = false ; 
        int tomatoCount = 0;
        int mushroomCount = 0;
        int currentCount = 0;
        int currentCol = 0 ;
        boolean valid = false;
        int startCol = 0;
        ArrayList slices = new ArrayList();
        int totalSlices = 0 ; 
        
        
        for(int j = 0 ;j  < columns; j++){
        startCol = j;
        
        for(int i = 0 ; i < rows;i++){
            
            if(pizzaArray[currentCol][i] == 'T'){
                tomatoCount ++;
            }
             if(pizzaArray[currentCol][i] == 'M'){
                mushroomCount ++;
            }
             
             
             currentCount ++;
             
             if((tomatoCount >= ingredients)&&(mushroomCount >= ingredients)){
                 valid = true;
             }
             
             if(valid){
  
                slices.add(j+" "+startCol +" "+startCol+" "+ i);
                tomatoCount = 0;
                mushroomCount = 0;
                valid = false;  
                totalSlices ++;
             }
             if(currentCount == maxSlice){
                 currentCount = 0; 
                 tomatoCount = 0;
                 mushroomCount = 0;
                 currentCol = i ; 
                
                 
             }
            
        }
        
            tomatoCount = 0;
            mushroomCount = 0;
            valid = false;        
         
    }
        Fileout.printOut(slices, totalSlices);
    }
    
}
