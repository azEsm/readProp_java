/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package readfile;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;


/**
 *
 * @author KVasin
 */
public class ReadFile {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException {
        Map<String, String> testProp = ReadProp.readProp("data.txt");
        
        System.out.println(testProp.get("def"));
        System.out.println();
        
        for( Entry<String, String> entry : testProp.entrySet() ){
	    System.out.println( entry.getKey() + " " + entry.getValue() );
        }
    }
}
