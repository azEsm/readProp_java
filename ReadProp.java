/*
 * Class ReadProp contains method readProp() that reads file
 * in Java Properties format and returns data
 * as a collection Map<"name", "value">
 * It skips empty strings and commented by "#" symbol.
 */

package readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 *
 * @author azEsm
 */
public class ReadProp {
    
    enum Symbol
 
    {
        COMMENT("^#.*$"),
        PNAME("[^:=]+"),
        DELIMITER("[:=]"),
        PVALUE(".*$");

        final Pattern pattern;
        Symbol(String exp)
        {
            this.pattern = Pattern.compile(exp);
        }
    }
    
    public static Map<String, String> readProp(String file) throws FileNotFoundException {
        Map<String, String> result = new HashMap<>();
        String pname;
        String pvalue;
        File prop = new File(file);
        Scanner line = new Scanner(prop);

        while(line.hasNext()) {
            if (line.hasNext(Symbol.COMMENT.pattern)) {
                // Ignoring the comment
                line.next(Symbol.COMMENT.pattern);
            }
            else if (line.hasNext(Symbol.PNAME.pattern))
            {
                pname = line.next(Symbol.PNAME.pattern);
                // Pull the delimiter off the stream and ignore it.
                line.next(Symbol.DELIMITER.pattern);
                //No reading the property value
                pvalue = line.next(Symbol.PVALUE.pattern);
                result.put(pname, pvalue);
                line.nextLine();
            }        
        }
        return result;
    }
}