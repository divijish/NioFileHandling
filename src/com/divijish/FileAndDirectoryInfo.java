package com.divijish;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class FileAndDirectoryInfo {

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);

		System.out.println("Enter file or directory name:");

		String pathValue = (input.nextLine()).trim();
		// create Path object based on user input
		Path path = Paths.get(pathValue);

		if (Files.exists(path)) { // if path exists, output info about it.

			System.out.println(path.getFileName() + " exists");

			System.out.println((Files.isDirectory(path) ? "Is" : "Is not") + " a directory");

			System.out.println((path.isAbsolute() ? "Is" : "Is not") + " absolute path.");

			System.out.println("Last modified :" + Files.getLastModifiedTime(path));

			System.out.printf("Size: %s%n", Files.size(path));

			System.out.printf("Path %s%n", path);

			System.out.printf("Absolute Path : %s%n", path.toAbsolutePath());
			
			if(Files.isDirectory(path)) {
			
				//Object for iterating through a directory's content
				System.out.printf("Directory Contents: %n");
				
				DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
				
				for(Path eachPath: directoryStream) {
					
					System.out.println(eachPath);
					
				}
				
			}

		} else {

			System.out.println("File does not exist.");

		}
	}

}
