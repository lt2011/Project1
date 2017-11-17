package com.file.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {

	public static void main(String[] args) {
		 String s="1234567890abcdefghijklmpq";
		    byte[] b=s.getBytes();
		    try{
		      File f=new File("E:\\B.txt");
		      FileOutputStream out=new FileOutputStream(f);
		      out.write(b,10,10);
		      out.write(b,0,5);
		    }catch (IOException e){
		      System.out.println(e.getMessage());
		    }
	}

}
