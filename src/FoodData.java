import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class FoodData {
	
	static ArrayList<String> InitialFoodDataList = new ArrayList<String>();
	
	public FoodData() {
	}
	
	//Finding the file path
	File FoodDataFile = new File("/Users/sartajrajpal/eclipse-workspace/FoodCrossReference - Revised/FoodData.txt");
	
	public void FoodDataAddFileCreate (String string) throws UnsupportedEncodingException, IOException {
		InitialFoodDataList.add(string);
	if (string.equals("No more food")) {
		//Creating file
		for (int i=0; i<InitialFoodDataList.size()-1; i++) {
			String FoodDataNames = InitialFoodDataList.get(i) + "\n";
		boolean isFileCreated = FoodDataFile.exists();
		if (isFileCreated = true) {
		Files.write(Paths.get("FoodData.txt"), (FoodDataNames.getBytes("UTF-8")), 
			StandardOpenOption.CREATE, StandardOpenOption.APPEND);
		}
		else {
			Files.write(Paths.get("FoodData.txt"), (FoodDataNames.getBytes("UTF-8")), 
				StandardOpenOption.APPEND);
			}
		}
		}
	}
	
}
		
 /*
		public static int InitialFoodData() throws IOException {
				//Initializing the Scanner and ArrayList and asking the user if data entry is necessary.
				Scanner FirstScanner = new Scanner(System.in);
				String YesOrNo = FirstScanner.nextLine(); 
				//Contingent on the user's response, the program will run the food entry code.
				while (YesOrNo.equals("Yes")) {
				//Allowing the user to input the data and storing it in the ArrayList.
			//	System.out.println("Enter the name of your food exactly as it appears on the package. "
			//			+ "Once you are finished, type, \"No more food\"");
			//	System.out.println("Make sure to type food in single units (e.g. \"onion\" "
			//			+ "not \"onions\").");
				String FoodData = FirstScanner.nextLine();
				InitialFoodDataList.add(FoodData);
				
				//If the user has no more food to enter, the program runs this. 
				if (FoodData.equals("No more food")) {
				System.out.println("Thank you for using FoodCrossReference. Your food entries have been stored.");
				//Using the data inputted by the user, the program creates a file and appends the data to it. 
				//I used "append" so the user can write to the same file multiple times. 
				
				}
				return -1;

				}


				if (YesOrNo.equals("No")) {
					//The program gives the user the option to clear the FoodDataFile.
					System.out.println("Would you like to clear your digital food repository?");
					Scanner ClearFoodRespository = new Scanner(System.in);
					String ClearFoodRepository2 = ClearFoodRespository.nextLine();
					//throw an exception here using try catch
					if (ClearFoodRepository2.equals("Yes")) {
						Files.newBufferedWriter(Paths.get("FoodData.txt"), StandardOpenOption.TRUNCATE_EXISTING);
						FoodCrossReferenceGUI.setThankYou("Your file has been cleared. Thank you for using FoodCrossReference.");
					}
					else {
					String ThankYou = ("Thank you for using FoodCrossReference. Please close the window.");
					FoodCrossReferenceGUI.setThankYou(ThankYou);
					}
				}

		return -1;
		}
}
*/







