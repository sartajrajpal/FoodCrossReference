import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;

public class FileClear extends FoodCrossReferenceGUI{
	
	public void FileClearYes (String string) throws UnsupportedEncodingException, IOException {
		if (string.equals("Yes")||string.equals("yes")) {
			//Clearing the file
			Files.newBufferedWriter(Paths.get("FoodData.txt"), StandardOpenOption.TRUNCATE_EXISTING);
		}
	}
}
	/*
		//This code parses the HTML code from the website I designed. 
		File HTMLCode = new File("/Users/sartajrajpal/eclipse-workspace/FoodCrossReference - Revised/HTML and CSS/"+RecipeName+".html");
		try {
		Document HTMLParserMechanism = Jsoup.parse(HTMLCode, "UTF-8", "http://SartajCookbook.com/");
		//Reinstating original line breaks from HTML source code.
		HTMLParserMechanism.outputSettings(new Document.OutputSettings().prettyPrint(false));
		HTMLParserMechanism.select("li").append("\\n");
		//Adding the ingredients list to a string. 
		//CITE SOURCE
		String documentSelect = HTMLParserMechanism.select("ul#ulAlign").text().replaceAll("\\\\n", "\n");
		Jsoup.clean(documentSelect, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
		String[] documentSelectCompare = documentSelect.toLowerCase().split("\n");
			//This section compares Strings from documentSelectCompare and FoodDataFileList and tells the user if he/she has the food. 
		ArrayList<String> DSCList = new ArrayList<>(Arrays.asList(documentSelectCompare));
		ArrayList<String> Remove = new ArrayList();
		for (String FoodName : DSCList) {
			for (String FoodDataName : FoodDataFileList) {
					if (FoodName.contains(FoodDataName)) {
						System.out.println(FoodName + " - You have this food!");
						Remove.add(FoodName);
					}
				}
					}
		DSCList.removeAll(Remove);
		for (int i=0; i<DSCList.size(); i++) {
			System.out.println(DSCList.get(i) + " - You do not have this food.");
		}
		
				}
	catch (Error e) {
		e.printStackTrace();
		System.out.println("Oops! The program encountered an error.");
		}
	}
	//Possible extensibility: brute force search through recipe which recommends better recipe to user, MySQL connection
}	
*/


