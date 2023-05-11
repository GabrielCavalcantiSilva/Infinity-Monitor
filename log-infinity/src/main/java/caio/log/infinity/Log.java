package caio.log.infinity;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Log {
	
	public static void generateLog(String message) throws IOException {
		
		          Path path = Paths.get("C:\\Logs");
		
		if(!Files.exists(path)) {
			
			Files.createDirectory(path);
			
		}
		
		File log = new File("C:\\Logs/logs.txt");
		
		if(!log.exists()) {
			
			log.createNewFile();
		
		}
		
		FileWriter fw = new FileWriter(log, true);
		          BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write(message);
		bw.newLine();

		bw.close();
		fw.close();
		
	}
}