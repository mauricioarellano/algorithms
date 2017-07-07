package com.hackerrank.kueski;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/*
 * 
 */
public class LastSubstring {
	
	static String compute(String s) {
		Set<String> chars = new TreeSet<String>();  
		for(int i=0; i<s.length(); i++){
			for (String string : chars) {
				String str = string.concat(String.valueOf(s.charAt(i)));
				if(chars.contains(str )){}
				chars.add(s);
			}
			chars.add(String.valueOf(s.charAt(i)));
			System.out.println("chars: " + chars);
		}
		//System.out.println("chars: " + chars);
		String[]results = chars.toArray(new String[chars.size()]);
		
		return results[results.length-1];
    }
	
	public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        final String fileName = System.getenv("OUTPUT_PATH");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
        String res;
        String _s;
        try {
            _s = in.nextLine();
        } catch (Exception e) {
            _s = null;
        }
        
        res = compute(_s);
        bw.write(res);
        bw.newLine();
        
        bw.close();
    }
}
