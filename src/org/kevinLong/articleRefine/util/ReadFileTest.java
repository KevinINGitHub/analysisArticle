package org.kevinLong.articleRefine.util;

import java.io.*;

public class ReadFileTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream is;
		OutputStream os;
		Reader r;
		BufferedReader br;
		Writer w;
		BufferedWriter bw;
		try {
			is = new FileInputStream("utf8_encoded_text.txt");
			r = new InputStreamReader(is, "utf-8");
			br = new BufferedReader(r);
			
			os = new FileOutputStream("gb2312_encoded.txt");
			w = new OutputStreamWriter(os, "gb2312");
			bw = new BufferedWriter(w);

			String s = null;
			while ((s = br.readLine()) != null) {
				bw.write(s);
			}
			br.close();
			bw.close();
			os.flush();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.print(e.getMessage());
		}
	       

	       
	}

}
