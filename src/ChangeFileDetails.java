import java.io.File;

public class ChangeFileDetails {

	public static void main(String[] args)
    {
        // Storing the name of files and directories
        // in an array of File type
        File[] files = new File("C:\\data\\CSSMySite").listFiles();
 
        // display files
        displayFiles(files);
    }
	
	public static void displayFiles(File[] files)
    {
        // Traversing through the files array
        for (File filename : files) {
            // If a sub directory is found,
            // print the name of the sub directory
            if (filename.isDirectory()) {
                System.out.println("Directory: " + filename.getName());
 
                // and call the displayFiles function
                // recursively to list files present
                // in sub directory
                displayFiles(filename.listFiles());
            }
            else {
            	// Printing the file name present in given path
                // Getting the file name
                System.out.println("File: " + filename.getName());
                File newFile = changeFileExtension(filename, "css", "txt");
                //System.out.println("File: " + newFile.getName());
                		
            }
       }
    }
        
	public static File changeFileExtension(File f, String oldExtension, String newExtension) {
			  int index = f.getName().lastIndexOf('.');
			  String name = f.getName().substring(0,index);
        	  String ext = f.getName().substring(index+1);
		      
        	  //System.out.println("File ext: " + ext);
              
        	  if(ext.equalsIgnoreCase(oldExtension)) {
        		  System.out.println("match found");
        		  f.renameTo(new File(f.getParent(), name + "." + newExtension));
        		     
        	  }
			  
        	  return f;
    }
 
}
