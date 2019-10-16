package com.sams.fileio;

import java.io.IOException;



public class App 
{
    public static void main( String[] args ) throws IOException
    {
    	GUI gui = new GUI();
    	gui.createGUI();
    	
//    	Path path = Paths.get("test.csv");
//    	
//    	BufferedWriter writer = Files.newBufferedWriter(path);
//    	
//    	if(!Files.exists(path))
//    		Files.createFile(path);
//    	
//    	writer.write("this,is,a,test2");
//    	writer.flush();
    }
}
