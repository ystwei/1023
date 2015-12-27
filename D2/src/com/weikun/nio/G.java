package com.weikun.nio;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.COPY_ATTRIBUTES;  
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;  
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;//auto

public class G {
	public static void main(String[] args) {
		try {
			//copy
			Files.move(Paths.get("c://1.txt"), Paths.get("c://4.txt"), REPLACE_EXISTING,ATOMIC_MOVE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
