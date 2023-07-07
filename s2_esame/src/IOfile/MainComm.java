package IOfile;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainComm {

	private static File file = new File("doc/test.txt");
	private static Logger log = LoggerFactory.getLogger(MainComm.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			scriviSuFile("Ciao a tutti!!");
			System.out.println("Testo :" + leggidaFile());
			//cancellaFile();
		} catch (IOException e) {
			log.error(e.getMessage());
		}

	}
	public static void scriviSuFile(String testo) throws IOException {
		FileUtils.writeStringToFile(file, testo, "UTF-8", true); 
		log.info("Catalogo scritto su file" + file.getPath());
	}
	
	public static String leggidaFile() throws IOException {
		String textFile = FileUtils.readFileToString(file, "UTF-8");
		return textFile;
	}
}
