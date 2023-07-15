package com.masai.problem1;

import java.io.*;
public class FileRecapDemo {
	public static void main(String[] args) throws IOException { //---- (i)
		File f = new File("myfolder");
		if(f.isFile()) { //---- (ii)
			System.out.println("No folder named myfolder");
			return;
		}
		if(f.isFile()) { //---- (iii)
			System.out.println("myfolder is a file not a folder");
			return;
		}
		String str[] = f.list(); //---- (iv)
		
		Reader r = new BufferedReader(new FileReader(f));// ---- (v)
		Writer w = new BufferedWriter(new FileWriter(f)); //---- (vi)
		
		while(true) {
			int c = r.read();
			if(c == -1)
				break;
			w.write(c);
		}
		
		w.flush();
		w.close();
		r.close();
	}
}

//(i) Write name of the suitable Exception class Here.
//(ii) Write Suitable method name to check if this file/folder named "myfolder" is already there or not.
//(iii) Write Suitable method name to check if "myfolder" is a file or not.
//(iv) Write Suitable method name to get all files that are in folder "myfolder".
//(v) Write Suitable statement to open file A.txt for reading.
//(vi) Write Suitable statement to open file B.txt for writing such that previous content should not be overwritten.
//(vii) Write Suitable method name to write all buffered content to file B.txt.
//(viii) The byte stream process data in the chunk of ____ bits but the character stream process data in the chunk of ____.
//(ix) What is buffer?
//(x) Which class is used to write primitive data type to file?

// 1. IOException;
// 2. f.isFile();
// 3. f.isFile();
// 4. f.list();
// 5. new FileReader(f);
// 6. new FileWriter(f);
// 7. flush;
// 8. 8-bit & 16-bit Unicode;
// 9. A buffer is a linear, finite sequence of elements of a specific primitive type;
// 10. DataOutputStream class;

