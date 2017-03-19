package org.kevinLong.articleRefine.util;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class FileToBytesTest {
 
    public static void main(String[] args) throws FileNotFoundException, IOException {
    	
    	String articPath="C:\\Users\\shimlong\\Desktop\\work-flow\\Self-Project\\TXT\\";
		String fileName="红楼梦：第二回.txt";
		String fileName1="java1.txt";
		
        File file = new File(articPath+fileName);
 
        FileInputStream fis = new FileInputStream(file);
        //System.out.println(file.exists() + "!!");
        //InputStream in = resource.openStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum); //no doubt here is 0
                //Writes len bytes from the specified byte array starting at offset off to this byte array output stream.
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
            Logger.getLogger(FileToBytesTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        byte[] bytes = bos.toByteArray();
        
        String test=new String(bytes,"GBK");
        System.out.print("红楼梦：第二回.txt contents:"+test);
 
    /*    //below is the different part
        File someFile = new File(articPath+fileName1);
        FileOutputStream fos = new FileOutputStream(someFile,true);
        fos.write(bytes);
        fos.flush();
        fos.close();*/
    }
}