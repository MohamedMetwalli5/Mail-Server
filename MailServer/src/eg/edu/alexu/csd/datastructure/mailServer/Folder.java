package eg.edu.alexu.csd.datastructure.mailServer;

public class Folder implements IFolder{
     private String destination;
     private String User;
     private String foldername;
     public void SetUser(String s1) {
    	 User=s1;
    }
     public void SetFoldername(String s1) {
    	 foldername=s1;
    }
     public String GetDestination() {
    	 destination="E:\\Users\\"+User+"\\"+foldername+"\\";
    	 return destination;
     }
     public String GetFolderName() {
    	
    	 return foldername;
     }
     
}
