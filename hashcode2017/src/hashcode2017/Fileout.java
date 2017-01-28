/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashcode2017;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author pcheape
 */
public class Fileout {

    public static void printOut(ArrayList<String> slices, int total) {

        try {
            try (PrintWriter writer = new PrintWriter("output", "UTF-8")) {
                writer.println(total);
                for(String str: slices) {
                     writer.println(str);
                }
                
            }
        } catch (IOException e) {
            // do something
        }

    }
}
