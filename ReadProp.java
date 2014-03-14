/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package readfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author KVasin
 */
public class ReadProp {
    
    private static final Pattern pattern = Pattern.compile("^([^#=]+)=([^\\n\\r]+)");
    
    public static Map<String, String> readProp(String file) throws FileNotFoundException {
        Map<String, String> result = new HashMap<String, String>();
        String pname;
        String pvalue;
        File prop = new File(file);
        Scanner line = new Scanner(prop);

        while(line.hasNext()) {
            Matcher matcher = pattern.matcher(line.nextLine());
            while(matcher.find()) {
                pname = matcher.group(1).trim();
                pvalue = matcher.group(2).trim();
                result.put(pname, pvalue);
            }            
        }
        return result;
    }
}