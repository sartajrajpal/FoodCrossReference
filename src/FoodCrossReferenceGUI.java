import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FoodCrossReferenceGUI extends JFrame implements ActionListener {
	
	//Variables for the creation of the GUI
	private JPanel contentPane;
	protected JTextField YesOrNOGUI;
	private JLabel Question2;
	private JTextField txtMakeSureTo;
	private JLabel Question3;
	private JTextField YesOrNOGUI2;
	private JLabel RecipeNameGUI;
	private JTextField RecipeNameOutput;
	private JLabel Output;
	protected JTextArea OutputArea;

	private static FoodData FoodData;
	private static FileClear FileClear;
	

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FoodData = new FoodData();
		FileClear = new FileClear();
		SwingUtilities.invokeLater(new Runnable(){
		public void run() {
		FoodCrossReferenceGUI frame = new FoodCrossReferenceGUI();
		frame.setVisible(true);
			}
	});
	}

	//constructor
	public FoodCrossReferenceGUI() {
		//creation of GUI: JLabels, JTextFields, JTextArea, scrollPane
		setResizable(false);
		setFont(new Font("Times New Roman", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{440, 0};
		gbl_contentPane.rowHeights = new int[]{17, 15, 25, 15, 22, 15, 22, 15, 22, 15, 12, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel Title = new JLabel("FoodCrossReference");
		Title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		Title.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Title = new GridBagConstraints();
		gbc_Title.anchor = GridBagConstraints.NORTH;
		gbc_Title.fill = GridBagConstraints.HORIZONTAL;
		gbc_Title.insets = new Insets(0, 0, 5, 0);
		gbc_Title.gridx = 0;
		gbc_Title.gridy = 0;
		contentPane.add(Title, gbc_Title);
		
		JLabel Question1 = new JLabel("1. Do you have food you would like to enter?");
		Question1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_Question1 = new GridBagConstraints();
		gbc_Question1.anchor = GridBagConstraints.WEST;
		gbc_Question1.insets = new Insets(0, 0, 5, 0);
		gbc_Question1.gridx = 0;
		gbc_Question1.gridy = 1;
		contentPane.add(Question1, gbc_Question1);
		
		YesOrNOGUI = new JTextField(20);
		YesOrNOGUI.addActionListener(this);
		YesOrNOGUI.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_YesOrNOGUI = new GridBagConstraints();
		gbc_YesOrNOGUI.fill = GridBagConstraints.HORIZONTAL;
		gbc_YesOrNOGUI.insets = new Insets(0, 0, 5, 0);
		gbc_YesOrNOGUI.gridx = 0;
		gbc_YesOrNOGUI.gridy = 2;
		contentPane.add(YesOrNOGUI, gbc_YesOrNOGUI);
		YesOrNOGUI.setColumns(10);
		
		Question2 = new JLabel("2. Enter the name of your food exactly as it appears on the package.");
		Question2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		Question2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_Question2 = new GridBagConstraints();
		gbc_Question2.anchor = GridBagConstraints.WEST;
		gbc_Question2.insets = new Insets(0, 0, 5, 0);
		gbc_Question2.gridx = 0;
		gbc_Question2.gridy = 3;
		contentPane.add(Question2, gbc_Question2);
		
		txtMakeSureTo = new JTextField();
		txtMakeSureTo.addActionListener(this);
		txtMakeSureTo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_txtMakeSureTo = new GridBagConstraints();
		gbc_txtMakeSureTo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMakeSureTo.insets = new Insets(0, 0, 5, 0);
		gbc_txtMakeSureTo.gridx = 0;
		gbc_txtMakeSureTo.gridy = 4;
		contentPane.add(txtMakeSureTo, gbc_txtMakeSureTo);
		txtMakeSureTo.setColumns(10);
		
		RecipeNameGUI = new JLabel("3. What is the name of the recipe you are looking for?");
		RecipeNameGUI.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_RecipeNameGUI = new GridBagConstraints();
		gbc_RecipeNameGUI.anchor = GridBagConstraints.WEST;
		gbc_RecipeNameGUI.insets = new Insets(0, 0, 5, 0);
		gbc_RecipeNameGUI.gridx = 0;
		gbc_RecipeNameGUI.gridy = 5;
		contentPane.add(RecipeNameGUI, gbc_RecipeNameGUI);
		
		RecipeNameOutput = new JTextField();
		RecipeNameOutput.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		RecipeNameOutput.addActionListener(this);
		GridBagConstraints gbc_RecipeNameOutput = new GridBagConstraints();
		gbc_RecipeNameOutput.fill = GridBagConstraints.HORIZONTAL;
		gbc_RecipeNameOutput.insets = new Insets(0, 0, 5, 0);
		gbc_RecipeNameOutput.gridx = 0;
		gbc_RecipeNameOutput.gridy = 6;
		contentPane.add(RecipeNameOutput, gbc_RecipeNameOutput);
		RecipeNameOutput.setColumns(10);
		
		Question3 = new JLabel("4. Would you like to clear your digital food repository?");
		Question3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_Question3 = new GridBagConstraints();
		gbc_Question3.anchor = GridBagConstraints.WEST;
		gbc_Question3.insets = new Insets(0, 0, 5, 0);
		gbc_Question3.gridx = 0;
		gbc_Question3.gridy = 7;
		contentPane.add(Question3, gbc_Question3);
		
		YesOrNOGUI2 = new JTextField();
		YesOrNOGUI2.addActionListener(this);
		YesOrNOGUI2.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_YesOrNOGUI2 = new GridBagConstraints();
		gbc_YesOrNOGUI2.fill = GridBagConstraints.HORIZONTAL;
		gbc_YesOrNOGUI2.insets = new Insets(0, 0, 5, 0);
		gbc_YesOrNOGUI2.gridx = 0;
		gbc_YesOrNOGUI2.gridy = 8;
		contentPane.add(YesOrNOGUI2, gbc_YesOrNOGUI2);
		YesOrNOGUI2.setColumns(10);
		
		Output = new JLabel("Output:");
		Output.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_Output = new GridBagConstraints();
		gbc_Output.anchor = GridBagConstraints.WEST;
		gbc_Output.insets = new Insets(0, 0, 5, 0);
		gbc_Output.gridx = 0;
		gbc_Output.gridy = 9;
		contentPane.add(Output, gbc_Output);
		
		OutputArea = new JTextArea(5, 20);
		OutputArea.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_OutputArea = new GridBagConstraints();
		gbc_OutputArea.fill = GridBagConstraints.BOTH;
		gbc_OutputArea.gridx = 0;
		gbc_OutputArea.gridy = 10;
		contentPane.add(OutputArea, gbc_OutputArea);
		
		JScrollPane scrollPane = new JScrollPane(OutputArea);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 10;
		getContentPane().add(scrollPane, gbc_scrollPane);
	}

	
	
	
	//actionPerformed chain (method calls other methods, follows logical path)
	public void actionPerformed(ActionEvent e) {
		String YesOrNo2 = YesOrNOGUI.getText();
		if (YesOrNo2.equals("Yes")||YesOrNo2.equals("yes")) {
			try {
				actionPerformed2(e);
			} catch (IOException e1) {
				e1.printStackTrace();
				OutputArea.append("Oops! The program encountered an error.");
			}
		}
		if (YesOrNo2.equals("No")||YesOrNo2.equals("no")){
			try {
			actionPerformed3(e);
				}
			catch (IOException e2) {
				e2.printStackTrace();
				OutputArea.append("Oops! The program encountered an error.");
			}
		}	
	}
	
	public void actionPerformed2(ActionEvent e2) throws UnsupportedEncodingException, IOException {
		try {
			actionPerformed5(e2);
		}
		catch (IOException e5){
			e5.printStackTrace();
			OutputArea.append("Oops! The program encountered an error.");
		}
	}
		
		public void actionPerformed5(ActionEvent e2) throws UnsupportedEncodingException, IOException {
		String Food = txtMakeSureTo.getText();
		FoodData.FoodDataAddFileCreate(Food);
		OutputArea.append(Food + "\n");
		OutputArea.selectAll();
		if (Food.equals("No more food")){
        try {
        	actionPerformed4(e2);
        }
        catch (IOException e3) {
        	e3.printStackTrace();
			OutputArea.append("Oops! The program encountered an error.");
        }
        }
		}


	public void actionPerformed3(ActionEvent e3) throws UnsupportedEncodingException, IOException {
		OutputArea.setText("Go to Question 4. Enter \"Yes\" or \"No\"." + "\n");
		String YesOrNo3 = YesOrNOGUI2.getText();
		if (YesOrNo3.equals("Yes")||YesOrNo3.equals("yes")) {
			FileClear.FileClearYes(YesOrNo3);
			OutputArea.append("Your file has been cleared. Thank you for using FoodCrossReference." + "\n");
			
		}
		else if (YesOrNo3.equals("No")||YesOrNo3.equals("no")) {
			OutputArea.append("Thank you for using FoodCrossReference." + "\n");
		}
	}
	
	public void actionPerformed4(ActionEvent e4) throws UnsupportedEncodingException, IOException {
		OutputArea.setText("Go to Question 3." + "\n");
		String RecipeName = RecipeNameOutput.getText();
		if (!RecipeNameOutput.getText().equals("")) {
		OutputArea.setText("");
		File FileScanner = new File("/Users/sartajrajpal/eclipse-workspace/FoodCrossReference - Revised/FoodData.txt");
		ArrayList<String> FoodDataFileList = new ArrayList<String>();
		@SuppressWarnings("resource")
		BufferedReader reader = new BufferedReader(new FileReader(FileScanner));
		String readerString;
			while ((readerString = reader.readLine())!=null) {
					FoodDataFileList.add(readerString);	
					}
			//Here I get rid of the "No more food" String in FoodDataFileList.
			ArrayList<String> NoMoreFoodDelete = new ArrayList<String>();
			for (String NoMoreFoodRemover : FoodDataFileList) {
			if (NoMoreFoodRemover.equals("No more food")) {
				NoMoreFoodDelete.add(NoMoreFoodRemover);
			}
			}
			FoodDataFileList.removeAll(NoMoreFoodDelete);
			//Here I delete all duplicates from FoodDataFileList.
			Set<String> DuplicateRemover = new HashSet<>(FoodDataFileList);
			FoodDataFileList.clear();
			FoodDataFileList.addAll(DuplicateRemover);
				//This code parses the HTML code from the website I designed. 
				File HTMLCode = new File("/Users/sartajrajpal/eclipse-workspace/FoodCrossReference - Revised/HTML and CSS/"+RecipeName+".html");
				try {
				Document HTMLParserMechanism = Jsoup.parse(HTMLCode, "UTF-8", "http://SartajCookbook.com/");
				//Reinstating original line breaks from HTML source code.
				HTMLParserMechanism.outputSettings(new Document.OutputSettings().prettyPrint(false));
				HTMLParserMechanism.select("li").append("\\n");
				//Adding the ingredients list to a string. 
				String documentSelect = HTMLParserMechanism.select("ul#ulAlign").text().replaceAll("\\\\n", "\n");
				Jsoup.clean(documentSelect, "", Whitelist.none(), new Document.OutputSettings().prettyPrint(false));
				String[] documentSelectCompare = documentSelect.toLowerCase().split("\n");
				//This section compares Strings from documentSelectCompare and FoodDataFileList and tells the user if she has the food. 
				ArrayList<String> DSCList = new ArrayList<String>(Arrays.asList(documentSelectCompare));
				for (String s: DSCList) {
					System.out.println(s);
				}
				for (String s : FoodDataFileList) {
					System.out.println(s);
				}
				ArrayList<String> Remove = new ArrayList<String>();
				for (String FoodName : DSCList) {
					for (String FoodDataName : FoodDataFileList) {
							if (FoodName.contains(FoodDataName)) {
								OutputArea.append(FoodName + " - You have this food!" + "\n");
								Remove.add(FoodName);
							}
						}
					}		
				DSCList.removeAll(Remove);
				for (int i=0; i<DSCList.size(); i++) {
					OutputArea.append(DSCList.get(i) + " - You do not have this food."+ "\n");
				}
						}
				catch (Error e) {
				e.printStackTrace();
				OutputArea.append("Oops! The program encountered an error.");
				}
	}
	}	
	
}

