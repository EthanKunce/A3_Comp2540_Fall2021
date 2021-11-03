import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.StringBuilder;
import java.util.*;

public class IvsDStackResize{


    
	static String [] readText(String PATH) throws Exception {
		BufferedReader br = new BufferedReader (new FileReader(PATH) ) ;
		
		StringBuilder test = new StringBuilder();
		
		// String text =" ";
		String line =" ";
		while ((line = br.readLine()) != null)
		{	
			test.append(" " + line.trim());
		}	
		br.close();

		// test.trimToSize();
		String tokens[] = test.toString().trim().split("[^a-zA-Z]+");
		// .split("[^a-zA-Z]+") ;
		
		return tokens;
	}


	//used in A3_Comp2540_Fall2021
	//uses doubling dynamic stack implemtation
	static String [] readLowCase(String PATH) throws Exception {

		// static String [] readText(String PATH) throws Exception {
		Scanner scanner = new Scanner(new File(PATH)).useDelimiter("[^a-zA-Z]+");
		// String[] ret = new String[];
		Stack2540Array stack = new Stack2540Array();
		while(scanner.hasNext()){
			stack.push(scanner.next().toLowerCase());
		}
		scanner.close();
		return stack.copyAsArray();

	}
	public static String [] reverse(String[] tokens) throws Exception{
		// Scanner scanner = new Scanner(new File(filename)).useDelimiter("[^a-zA-Z]+");
		Stack2540Array stack = new Stack2540Array();

		// String temp;
		for(String c : tokens){
			stack.push(c);
		}
		String [] rev = new String[stack.size()];

		// StringBuilder test = new StringBuilder();
		int i = 0;
		while(!stack.isEmpty())
		{
			rev[i] = stack.pop();
		}
		
		return rev;
		}

		public static String [] reverse(String filename) throws Exception{
			Scanner scanner = new Scanner(new File(filename)).useDelimiter("[^a-zA-Z]+");
			Stack2540Array stack = new Stack2540Array();
	
			// String temp;
			while (scanner.hasNext()){
				stack.push(scanner.next().toLowerCase());
			}
			String [] rev = new String[stack.size()];
	
			// StringBuilder test = new StringBuilder();
			int i = 0;
			while(!stack.isEmpty())
			{
				rev[i] = stack.pop();
			}
			
			
			scanner.close();
			return rev;
		}

		public static String [] reverseI(String filename) throws Exception{
			Scanner scannerI = new Scanner(new File(filename)).useDelimiter("[^a-zA-Z]+");
			Stack2540ArrayI stack = new Stack2540ArrayI();
	
			// String temp;
			while (scannerI.hasNext()){
				stack.push(scannerI.next().toLowerCase());
			}
			String [] rev = new String[stack.size()];
	
			// StringBuilder test = new StringBuilder();
			int i = 0;
			while(!stack.isEmpty())
			{
				rev[i] = stack.pop();
			}
			
			
			scannerI.close();
			return rev;
		}




    public static void main(String[] args) throws Exception{
        String PATH = "dblp";
		// String[] METHODS = { "MERGE", "" };
		String[] DATASETS = { "200", "400","800","1600","3200","6400", "10000","20000","40000", "80000","160000", "320000", "640000", "1280000", "2560000"};//, "10k","100k"}; //, "5k", "10k", "100k", "1m", "" };
		
		String[] tokens;
		long startTime = 1;
		long endTime = 1;

		PrintWriter writer = new PrintWriter("newFile.txt");
		String OUTPUT = "\tStackTokenization\tScanner";
		writer.println(OUTPUT);
		System.out.println(OUTPUT);

        for (int j = 0 ; j < 14; j++) {
			// run the experiments using different methods
			OUTPUT = DATASETS[j]+"\t";
			writer.print(OUTPUT);
			System.out.print(OUTPUT);

            for(int i = 0; i < 2; i++){
				// System.out.print("Data is:\t" + DATASETS[j]+"\t");


				if (i == 0) {
					// tokens = readLowCase(PATH+DATASETS[j]+".txt");
					startTime = System.currentTimeMillis();
					// tokens = readLowCase(PATH+DATASETS[j]+".txt");
					// reverse(PATH+DATASETS[j]+".txt");
					reverse(readLowCase(PATH+DATASETS[j]+".txt"));

					endTime = System.currentTimeMillis();
					OUTPUT = (endTime-startTime)+"\t";
					writer.print(OUTPUT);
					System.out.print(OUTPUT);
				}
				else{
					startTime = System.currentTimeMillis();

					// reverseI(PATH+DATASETS[j]+".txt");
					reverse(PATH+DATASETS[j]+".txt");

					endTime = System.currentTimeMillis();
					OUTPUT = (endTime-startTime)+"\t";
					writer.print(OUTPUT);
					System.out.print(OUTPUT);
				}

				

             
				// System.out.print("Data is:\t" + DATASETS[j] +" Time:\t"+  (endTime-startTime));
            }
			OUTPUT = "\n";
			writer.print(OUTPUT);
			System.out.print(OUTPUT);
				// String time = String.format("%12d", endTime - startTime);

			
		}
		writer.close();
    }
}