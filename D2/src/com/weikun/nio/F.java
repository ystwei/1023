package com.weikun.nio;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class F {
	public static void main(String[] args) {
		Path startingDir=Paths.get("c:\\");//º¬×ÓÄ¿Â¼
		
		try {
			
			Files.walkFileTree(startingDir, new SimpleFileVisitor<Path>(){
				@Override
				public FileVisitResult visitFile(Path file,
						BasicFileAttributes attrs) throws IOException {
					// TODO Auto-generated method stub
					System.out.print(file.toString());
					if(file.toString().endsWith(".txt")){
						System.out.println(file.getFileName());
					}
					
					
					
					return FileVisitResult.CONTINUE;
				}
				
				
			});
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
