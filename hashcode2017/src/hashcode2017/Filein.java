package hashcode2017;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Filein {

    public static Pizza readFile() throws FileNotFoundException, IOException {

        int rows = 0;
        int columns = 0;
        int ingredients;
        int maxSlice;
        char pizzaArray[][];
        int currentRow = 0;
        int currentColumn = 0;
        boolean firstLine = true;
        Pizza pizzaPie = null;

        String line, token, delimiter = " ";
        StringTokenizer tokenizer;
        BufferedReader input = null;

        String filename = "system";
        input = new BufferedReader(new FileReader(filename));
        line = input.readLine(); // when printed gives first line in file

        // outer while (process lines)
        while (line != null) { // doesn't seem to start from first line
            tokenizer = new StringTokenizer(line, delimiter);

           

            while (tokenizer.hasMoreTokens()) {// process tokens in line
                token = tokenizer.nextToken();
                if (firstLine) {
                    rows = Integer.parseInt(token);
                    token = tokenizer.nextToken();
                    columns = Integer.parseInt(token);
                    token = tokenizer.nextToken();
                    ingredients = Integer.parseInt(token);
                    token = tokenizer.nextToken();
                    maxSlice = Integer.parseInt(token);
                    pizzaPie = new Pizza(rows, columns, ingredients, maxSlice);
                    System.out.println("Pizza created with " +rows+ "rows");
                    firstLine = false;
                } else {
                    
                    for (int i = 0; i < token.length(); i++) {
                        
                        if (pizzaPie != null) {
                            pizzaPie.addIng(token.charAt(i));
                        }
                    }
                }// close inner while

                System.out.println();

                line = input.readLine(); // next line
            }// close outer while
            
        }
        return pizzaPie;
    }
}
