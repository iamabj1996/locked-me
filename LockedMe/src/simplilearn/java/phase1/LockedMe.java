package simplilearn.java.phase1;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class LockedMe {
	static String fullfile;
	static String filepath="C:\\abraham\\";
	static File file;
	Scanner inputd= new Scanner( System.in );

	public LockedMe() {
		System.out.println("*************************** Locked Me *******************************");
		System.out.println("******************************************************************\n");
		System.out.println("Developer Name:Abraham Joseph Kannampuzha\n\n");
		System.out.println("\t\t\tMenu");
		System.out.println("\t\t===================");
		System.out.println(" 1. return the current file names in ascending order");
		System.out.println(" 2. return the details of the user interface ");

		System.out.println(" a add a user specified file to the application\n");
	System.out.println(" b delete a user specified file from the application\n");
	System.out.println(" c Search a user specified file from the main directory\n");
		System.out.println(" 5. Return to main menu\n");	
	System.out.println(" 4. Close the application\n");	


	}
	
	public static void ReturnFileName() throws IOException{
		File dir = new File("C:\\abraham\\");
		File[] files = dir.listFiles();
		Arrays.sort(files, (f1, f2) -> f1.compareTo(f2));
		for (File file : files) {
	         if (!file.isHidden()) {
	            if (file.isDirectory()) {
	               System.out.println("DIR \t" + file.getName());
	            } else {
	               System.out.println("FILE\t" + file.getName());
	            }
	         }}
	}
	
	//check if directory exist if not exist create directory.
	public static void CreateFiles() throws IOException  {
		boolean result;
		try {	
			@SuppressWarnings("resource")
			Scanner inputf= new Scanner( System.in );
		System.out.println(" Please Enter the  file name with extenssion you want to add it in location "+filepath);
	         String s = inputf.nextLine().toLowerCase(); // Takes the filename with extension as the user input
	         fullfile=filepath.concat(s);
	          file=new File(fullfile);
        	 result=file.createNewFile();
 					if(result==true) {
 					System.out.print("File "+s+" was created in location: "+filepath);
 					}//end if
 					else
 					{ file.exists();
 						System.out.print("File "+s+" already exist in location "+file.getAbsolutePath());}
			}//end try
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void DeleteFiles() throws IOException  {
		
		try {
			System.out.println("Please Enter the  file you want to delete from location "+filepath);
		@SuppressWarnings("resource")
		Scanner inputf= new Scanner( System.in );
	    String s =inputf.nextLine(); // Takes the filename with extension as the user input
	    fullfile=(filepath.concat(s)).toLowerCase();
       file=new File(fullfile);
       if(file.exists()) {
    	   if(file.delete()) {
			System.out.print("successful to delete File "+s+" from "+filepath);
    	   }
    	   else
    	   {System.out.print("Failed to delete the file "+s+" from "+filepath);}
       }//end inner if
       
       else {
			System.out.print("File "+s+" Not Found in "+filepath);
       }
       	
		}//end try
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/////////////here
	public static void SearchFile() throws IOException{
		try {
			
			System.out.println("Please Enter the  file you want to search in location "+filepath);
		@SuppressWarnings("resource")
		Scanner inputd= new Scanner( System.in );
		 String s =inputd.next(); // Takes the filename with extension as the user input
		fullfile=(filepath.concat(s)).toLowerCase();
			File directory = new File("C:\\abraham\\");
			
			MyFilenameFilter filter= new MyFilenameFilter("aa.txt");
			
			String[]flist=directory.list(filter);
			
			if(flist==null) {
				System.out.println("The directory is empty or directory does not exist");
			}
			else {
				for(int i=0; i<flist.length; i++) {
					System.out.println(flist[i]+"found");
				}
			}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
    public static void operations(String x) throws IOException  {
    	switch(x) {
    	
    	case "1":{
    		ReturnFileName();
    		break;	
    	}
    		
    	
    	case "2":{
			
			
    		break;	
    		}
    	
    	case "3":{
    			SearchFile();
    		break;	
    	}
    	
    	case "A","a":{
    		CreateFiles();
    		break;
    	}
    	case "B","b":{
    		DeleteFiles();
    		break;
    	}
    	case "C","c":{
    		SearchFile();
    		break;
    	}
    	}
    	
    }
	public static void main(String[] args) throws IOException {
		new LockedMe();
		
		System.out.println("\n Please give your choice from the menu: ");
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		String Choice=scan.next();
		operations(Choice);
		
	/*System.out.println("Do you want to exit from program? ");
		String ex=scan.nextLine();
		if(ex.equalsIgnoreCase("Y")) {
			System.out.println("yes ");}*/

		}


	}




