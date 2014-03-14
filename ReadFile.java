/*
 * This class tests class ReadProp
 */

package readfile;

import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Map.Entry;


/**
 *
 * @author azEsm
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
