package eg.edu.alexu.csd.datastructure.mailServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

public class App implements IApp {
	
	
	private String CurrentUser;
	public void SetUser(String name) {
		CurrentUser=name;
	}
	public String GetUser( ) {
		return CurrentUser;
	}
	
	
	public static byte[] FileToArray(File f) throws FileNotFoundException,IOException{
		byte[] attachment = new byte[10240];
		ByteArrayOutputStream writer = new ByteArrayOutputStream();
		FileInputStream reader = new FileInputStream(f);
		int read;
		while ((read = reader.read(attachment)) != -1 ) {
			writer.write(attachment,0,read);
		}
		writer.close();
		reader.close();
		return writer.toByteArray();
	}
	
	public static void ArrayToFile(byte[] attachment, File f) {
		
		try(FileOutputStream writer = new FileOutputStream(f)){
			writer.write(attachment);
			writer.close();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
		}
		
	}
	
	
	
	public long timeDifference(String date, String now) {

		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date1 = null, date2 = null;

		try {
			date1 = (Date) format.parse(date);
			date2 = (Date) format.parse(now);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long difference = date2.getTime() - date1.getTime();
		difference /= (24 * 60 * 60 * 1000);

		return difference;
	}

	/**
	 * Checks for the Emails which have been in Trash for more than 30 Days and
	 * deletes them
	 */
	public void checkTrashTime(String currentUser) {

		DoublyLinkedList d = new DoublyLinkedList();
		
		
		FileReader mails = null;
		try {
			mails = new FileReader("E:\\Users\\"+currentUser+"\\Trash\\indexfile.txt");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
		}

		BufferedReader Reader = new BufferedReader(mails);
		// reading the Index mail text file
	       while (true) {
				try {
					String mail=Reader.readLine();
					if(mail==null) {
						Reader.close();
						break;
					}
					d.add(mail);
				} catch (Exception e) {
					
						JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
					}}

		for (int i = 0; i < d.size(); i++) {

			String temp = (String) d.get(i);
			String[] temp5 = temp.split("    ");

			String time = temp5[5];

			DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
			LocalDateTime nowdate = LocalDateTime.now();

			String now = nowdate.format(date).toString();

			long diff = timeDifference(time, now);

			if (diff >= 30) {
				d.remove(i);
				try {
					//deleteFolder(currentUser, name);
					delete(new File("Users/" + currentUser + "/Trash/" + temp5[5]));
				} catch (IOException e) {
					e.printStackTrace();
				}
				i--;
			}

		}
         /*********************/
		FileWriter f = null;
		try {
			f=new FileWriter("E:\\Users\\"+currentUser+"\\indexfile.txt");
		}catch (Exception e) {
			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
				}
		BufferedWriter writer = new BufferedWriter(f);
		
     //write the new index without the deleting mail
	   for(int i =0; i<d.size();i++) {
		   try {
			writer.write((String)d.get(i));
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
	   }
	   
	   try {
		writer.close();
    	} catch (IOException e1) {
		e1.printStackTrace();
    	}

	}
	
	
	
	
	public boolean singing_in(String email, String password) {

		// opens and read the all the emails existing and search for the entered
		// email and password
		
		FileReader names = null;
		try {
			names = new FileReader("E:\\Users\\mail Index.txt");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
		}

		BufferedReader Reader = new BufferedReader(names);
		// reading the Index mail text file
	       while (true) {
				try {
					String UserID = Reader.readLine();
					String[] userContent = UserID.split("    ");
					String User = userContent[0];
					//System.out.println(User);
					String Pass = userContent[1];
					if (User.equals(email)) {
						if (Pass.equals(password)) {
							Reader.close();
							return true;
						} else {
							Reader.close();
							return false;
						}
					}
				} catch (Exception e) {
					try {
						Reader.close();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
					}
					return false;
				}
			}
		

	}
	
	@Override
	public boolean signin(String email, String password) {
		// mails'folder which contains all user folders
				Path user = Paths.get("E:\\Users");
				// check if mail's folder of users not exists 
				if (!Files.exists(user)) {
					return false;
				}
				String adderess = "E:\\Users\\" + email;
				Path folder = Paths.get(adderess);
				if (Files.exists(folder)) {
					return singing_in(email, password);
				} else {
					return false;
				}
				}
	
	
	
	
	private boolean signing_up(IContact contact) {

		Contact mail = new Contact(null, null, null, null);
		mail = (Contact) contact;
		// mails'folder which contains all user folders
		Path user = Paths.get("E:\\Users");
		// check if the mail's folder of users not exists and if so creates it
		if (!Files.exists(user)) {
			try {
				Files.createDirectory(user);
			} catch (Exception e) {
				
			}
		}

		// data text file which contains mails'index of all users
		Path data = Paths.get("E:\\Users\\mail Index.txt");
		// check if the data text file not exist and if so creates it
		if (!Files.exists(data)) {
			try {
				Files.createFile(data);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");	
			}
		}

		FileWriter users = null;
		try {
			users = new FileWriter("E:\\Users\\mail Index.txt", true);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
		}

		BufferedWriter Writer = new BufferedWriter(users);

		/* checks if the email already exist by checking if there is a folder with
		 the same name*/
		String adderess = "E:\\Users\\" + mail.getEmail();
		Path folder = Paths.get(adderess);
		if (Files.exists(folder)) {
			return false;
		}

		// Here I append new user data to the existing data text file
		try {
			Writer.write(mail.getEmail() + "    ");
			Writer.write(mail.getPassword() + "    ");
			Writer.write(mail.getNickName() + "    ");
			Writer.write(mail.getPhone() + "    ");
			Writer.newLine();
			Writer.close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
		}
		// If the email is valid we create index folder for it 
		try {
			Files.createDirectory(folder);
			Files.createDirectory(Paths.get("E:\\Users\\" + mail.getEmail() + "\\Trash"));
			Files.createFile(Paths.get("E:\\Users\\" + mail.getEmail() + "\\Trash\\indexfile.txt"));
			Files.createDirectory(Paths.get("E:\\Users\\" + mail.getEmail() + "\\Inbox"));
			Files.createFile(Paths.get("E:\\Users\\" + mail.getEmail() + "\\Inbox\\indexfile.txt"));
			Files.createDirectory(Paths.get("E:\\Users\\" + mail.getEmail() + "\\Draft"));
			Files.createFile(Paths.get("E:\\Users\\" + mail.getEmail() + "\\Draft\\indexfile.txt"));
		} catch (Exception e) {
			return false;
		}
		
		
		return true;
	}

	@Override
	public boolean signup(IContact contact) {
		boolean log = signing_up(contact);

		return log;
		
	}
	
	
	
	public Mail LoadMail(String user,String name,String folder) {
		Mail m = new Mail();
		String index = "E:\\Users\\"+user+"\\"+folder+"\\indexfile.txt";
		String wanted = null;
		
		//searching for index of mail
		FileReader f = null;
		try {
			f = new FileReader(index);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
		}
		
		BufferedReader Reader = new BufferedReader(f);
		/********************/
		
	       while (true) {
				try {
					String line = Reader.readLine();
					if(line==null) {
						Reader.close();
						break;}
					String[] information = line.split("    ");
					String foldder = information[5];
					if (foldder.equals(name)) {
						 wanted =line;
						}
					}
				catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
					}}
	       
	       
	       /****************************/
	      // System.out.println(wanted);
	       String parts[]=wanted.split("    ");
	       m.setFrom(parts[0]);
	       m.setTo(parts[1]);
	       m.setSubject(parts[2]);
	       m.setPriority(Integer.parseInt(parts[3]));
	       m.setName(name);
	       /*****************************/
	       
	       StringBuilder body=new StringBuilder("");
	       String bodypath="E:\\Users\\"+user+"\\"+folder+"\\"+name+"\\body.txt";
	       
	     //reading the body
			FileReader f2 = null;
			try {
				f2 = new FileReader(bodypath);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
			}
			
			BufferedReader Reader2 = new BufferedReader(f2);
			/********************/
			
		       while (true) {
					try {
						String line = Reader2.readLine();
						if(line==null) {
							Reader2.close();
							break;}
						if(isSubstring("To: ", line)>=0) {}
						else if(isSubstring("Subject: ", line)>=0) {}
						else if(isSubstring("From: ", line)>=0) {}
						else if(isSubstring("Date: ", line)>=0) {}
						else if(isSubstring("********", line)>=0) {}
						else if(isSubstring("Body: ", line)>=0) {}
						else {body.append(line);}
						}
					catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
						}}
		       
		       
		       /****************************/
		       String massage[]=body.toString().split(" ");
		       m.setBody(massage);
		       /****************************/
		       StringBuilder attachments=new StringBuilder("");
		       String attachmentspath="E:\\Users\\"+user+"\\"+folder+"\\"+name+"\\attachments\\links.txt";
		       /**************************/
		     //reading the attachments links
				FileReader f3 = null;
				try {
					f3 = new FileReader(attachmentspath);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
				}
				BufferedReader Reader3 = new BufferedReader(f3);
				/********************/
				
			       while (true) {
						try {
							String line = Reader3.readLine();
							if(line==null) {
								Reader3.close();
								break;}
							    attachments.append(line);
							    attachments.append("    ");
							}
						catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
							}}
			       /****************************/
			       String attach[]=attachments.toString().split("    ");
			       m.setAttaclinks(attach);
			       /****************************/
			       
			       
		return m;
	}
	
	
	
	
	 // Returns true if s1 is substring of s2 
    static int isSubstring(String s1, String s2) 
    { 
        int M = s1.length(); 
        int N = s2.length(); 
      
        /* A loop to slide pat[] one by one */
        for (int i = 0; i <= N - M; i++) { 
            int j; 
      
            /* For current index i, check for 
            pattern match */
            for (j = 0; j < M; j++) 
                if (s2.charAt(i + j) != s1.charAt(j)) 
                    break; 
      
            if (j == M) 
                return i; 
        } 
      
        return -1; 
    } 
	
	
	
	
	
    public void sendEmail(Mail email) {
    	//saving the time
    	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime time = LocalDateTime.now();
		//Identify the directory of massage
    	String massage ="E:\\Users\\"+email.getTo()+"\\Inbox\\"+email.getName();
    	String reciever="E:\\Users\\"+email.getTo()+"\\Inbox";
    	String index = reciever + "\\Indexfile.txt";
    	
    	Path Massage = Paths.get(massage);
    	Path Reciever = Paths.get(reciever);
    	Path Index = Paths.get(index);
    	
    	// Checks if the inbox folder exists or not and if not creates it
    			if (!Files.exists(Reciever)) {
    				try {
    					Files.createDirectory(Reciever);
    				} catch (IOException e) {
    					JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    				}
    			}
    	// Checks if the index file of email in inbox exists or not and if not creates it
    		if (!Files.exists(Index)) {
    			try {
    			   Files.createFile(Index);
    				} catch (Exception e) {
    			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    				}
    			}
    	
      //if file exists  add numbers 
    		
    		int j = 1;
    		if(Files.exists(Massage)) {
    			massage+=j;
    			Massage = Paths.get(massage);
    			j++;
    		}
    		while(Files.exists(Massage)) {
    			massage=massage.substring(0, massage.length()-1)+j;
    			Massage = Paths.get(massage);
    		}
    		//saves the name of mail folder
    		String parts[]=massage.split("\\\\");
    		String name=parts[parts.length-1];
    		email.setName(name);
    		// creating folder for email
    		try {
				Files.createDirectory(Massage);
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
			}
    		
    		String body=massage+"\\body.txt";
    		Path Body = Paths.get(body);
    		
    	// write the data of send email 
    		FileWriter f1 = null;
    		try {
    			f1=new FileWriter(index,true);
    		}catch (Exception e) {
 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
 				}
    		BufferedWriter writer = new BufferedWriter(f1);
    		/*
    		 *creating the index file
    		 * from    to    subject    Priority    date  name
    		 */
    		try {
    			writer.write(email.getFrom()+"    "+email.getTo()+"    "+
    		                 email.getSubject()+"    "+email.getPriority()+"    "
    	                    	+timeFormat.format(time)+"    "+email.getName());
                writer.newLine();
    			writer.close();
    			
    		} catch (Exception e) {
  			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
  				}
    		
    		// creating file for body
    		try {
				Files.createFile(Body);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
			}
    		//making folder for attachments if there are
    		
    			try {
    				Files.createDirectory( Paths.get(massage+"\\attachments"));
    				Files.createFile(Paths.get(massage+"\\attachments\\links.txt"));
    			} catch (IOException e) {
    				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    			}	
    		
    		// writing the email body
    		FileWriter f2 = null;
    		try {
    			f2=new FileWriter(body,true);
    		}catch (Exception e) {
 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
 				}
    		BufferedWriter writer2 = new BufferedWriter(f2);
    		// the body (from  sub  date  body)
    		try {
    			writer2.write("From: "+email.getFrom());
    			writer2.newLine();
    			writer2.write("Subject: "+email.getSubject());
      			writer2.newLine();
      			writer2.write("Date: "+timeFormat.format(time));
    			writer2.newLine();
    			writer2.write("************************************** ");
    			writer2.newLine();
    			writer2.write("Body: ");
    			writer2.newLine();
    			for (int i = 0; i < email.getBody().length; i++) {
    				writer2.write(email.getBody()[i]);
    				writer2.append(' ');
    			}
    			writer2.close();
    		}
    		catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
			}
    		
    		// sending attachments
    		for (int i = 0; i < email.getAttachments().size(); i++) {
                  String Attachment = (String) email.getAttachments().get(i);
                  String attach []= Attachment.split("\\\\");
                  String NewPlace = massage+"\\attachments\\"+attach[attach.length-1];
                  File attachment = new File(Attachment);
                  File newPlace = new File (NewPlace);
                  try {
  					ArrayToFile(FileToArray(attachment), newPlace);
  				} catch (Exception e) {
  					e.printStackTrace();
  				}  
                  
    			}
    		
    		// writing the attachments links
    		FileWriter f3 = null;
    		try {
    			f3=new FileWriter(massage+"\\attachments\\links.txt",true);
    		}catch (Exception e) {
 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
 				}
    		BufferedWriter writer3 = new BufferedWriter(f3);
    		// the links
    		try {
    			
    			if(email.getAttaclinks()!=null) {
    			for (int i = 0; i < email.getAttaclinks().length; i++) {
    				writer3.write(email.getAttaclinks()[i]);
    				writer3.newLine();
    			}}
    			writer3.close();
    		}
    		catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
			}
    }
    		
    		
    		
    		
    		//draft massages	
    		public void draftEmail(Mail email) {
    	    	//saving the time
    	    	DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    			LocalDateTime time = LocalDateTime.now();
    			//Identify the directory of massage
    			String massage;
    			if(email.getSubject()!=null) {
    	    	massage ="E:\\Users\\"+email.getFrom()+"\\Draft\\"+email.getName();}
    			else {
    		    massage ="E:\\Users\\"+email.getFrom()+"\\Draft\\"+"unknown";	
    			}
    	    	String sender="E:\\Users\\"+email.getFrom()+"\\Draft";
    	    	String index = sender + "\\Indexfile.txt";
    	    	Path Massage = Paths.get(massage);
    	    	Path Sender = Paths.get(sender);
    	    	Path Index = Paths.get(index);
    	    	
    	    	// Checks if the inbox folder exists or not and if not creates it
    	    			if (!Files.exists(Sender)) {
    	    				try {
    	    					Files.createDirectory(Sender);
    	    				} catch (IOException e) {
    	    					JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    	    				}
    	    			}
    	    	// Checks if the index file of email in inbox exists or not and if not creates it
    	    		if (!Files.exists(Index)) {
    	    			try {
    	    			   Files.createFile(Index);
    	    				} catch (Exception e) {
    	    			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    	    				}
    	    			}
    	    		
    	    		
    	    		
    	    		//if file exists  add numbers 
    	    		
    	    		int j = 1;
    	    		if(Files.exists(Massage)) {
    	    			massage+=j;
    	    			Massage = Paths.get(massage);
    	    			j++;
    	    		}
    	    		while(Files.exists(Massage)) {
    	    			massage=massage.substring(0, massage.length()-1)+j;
    	    			Massage = Paths.get(massage);
    	    			j++;
    	    		}
    	    		
    	    		
    	    		//saves the name of mail folder
    	    		String parts[]=massage.split("\\\\");
    	    		String name=parts[parts.length-1];
    	    	    email.setName(name);
    	    		// creating folder for email
    	    		try {
    					Files.createDirectory(Massage);
    				} catch (IOException e) {
    					JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    				}
    	    		
    	    		String body=massage+"\\body.txt";
    	    		Path Body = Paths.get(body);
    	    		
    	    	// write the data of send email 
    	    		FileWriter f1 = null;
    	    		try {
    	    			f1=new FileWriter(index,true);
    	    		}catch (Exception e) {
    	 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    	 				}
    	    		BufferedWriter writer = new BufferedWriter(f1);
    	    		/*
    	    		 *creating the index file
    	    		 * from    to    subject    Priority    date  name
    	    		 */
    	    		try {
    	    			writer.write(email.getFrom()+"    "+email.getTo()+"    "+
    	    		                 email.getSubject()+"    "+email.getPriority()+"    "
    	    	                    	+timeFormat.format(time)+"    "+email.getName());
    	                writer.newLine();
    	    			writer.close();
    	    			
    	    		} catch (Exception e) {
    	  			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    	  				}
    	    		
    	    		// creating file for body
    	    		try {
    					Files.createFile(Body);
    				} catch (Exception e) {
    					JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    				}
    	    		//making folder for attachments if there are

        			try {
        				Files.createDirectory( Paths.get(massage+"\\attachments"));
        				Files.createFile(Paths.get(massage+"\\attachments\\links.txt"));
        			} catch (IOException e) {
        				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
        			}	
        		
    	    		// writing the email body
    	    		FileWriter f2 = null;
    	    		try {
    	    			f2=new FileWriter(body,true);
    	    		}catch (Exception e) {
    	 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    	 				}
    	    		BufferedWriter writer2 = new BufferedWriter(f2);
    	    		// the body (from  sub  date  body)
    	    		try {
    	    			if(email.getTo()!= null) {
    	    			writer2.write("To: "+email.getTo());}
    	    			else {writer2.write("To: ");}
    	    			writer2.newLine();
    	    			if(email.getSubject()!= null) {
        	    			writer2.write("Subject: "+email.getSubject());}
        	    			else {writer2.write("Subject: ");}
    	      			writer2.newLine();
    	      			writer2.write("Date: "+timeFormat.format(time));
    	    			writer2.newLine();
    	    			writer2.write("************************************** ");
    	    			writer2.newLine();
    	    			writer2.write("Body: ");
    	    			writer2.newLine();
    	    			if(email.getBody()!=null) {
    	    			for (int i = 0; i < email.getBody().length; i++) {
    	    				writer2.write(email.getBody()[i]);
    	    				writer2.append(' ');
    	    			}}
    	    			writer2.close();
    	    		}
    	    		catch (Exception e) {
    					JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    				}
    	    		
    	    		// sending attachments
    	    		for (int i = 0; i < email.getAttachments().size(); i++) {
    	                  String Attachment = (String) email.getAttachments().get(i);
    	                  String attach []= Attachment.split("\\\\");
    	                  String NewPlace = massage+"\\attachments\\"+attach[attach.length-1];
    	                  File attachment = new File(Attachment);
    	                  File newPlace = new File (NewPlace);
    	                  try {
    	  					ArrayToFile(FileToArray(attachment), newPlace);
    	  				} catch (Exception e) {
    	  					e.printStackTrace();
    	  				}  
    	                  
    	    			}
    		
    	    		// writing the attachments links
    	    		FileWriter f3 = null;
    	    		try {
    	    			f3=new FileWriter(massage+"\\attachments\\links.txt",true);
    	    		}catch (Exception e) {
    	 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    	 				}
    	    		BufferedWriter writer3 = new BufferedWriter(f3);
    	    		// the links
    	    		try {
    	    			
    	    			if(email.getAttaclinks()!=null) {
    	    			for (int i = 0; i < email.getAttaclinks().length; i++) {
    	    				writer3.write(email.getAttaclinks()[i]);
    	    				writer3.newLine();
    	    			}}
    	    			writer3.close();
    	    		}
    	    		catch (Exception e) {
    					JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
    				}
    		
    		
    }
	@Override
	public ILinkedList setViewingOptions(IFolder folder, IFilter filter, ISort sort) {
		Folder fold = (Folder) folder;
		filter fil = (filter) filter;
		sort ss=(sort)sort;
		String place = fold.GetDestination()+"\\indexfile.txt";
		
		//from folder
		FileReader mails = null;
		try {
			mails = new FileReader(place);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
		}
        BufferedReader Reader = new BufferedReader(mails);
		Singly_Linked_list s =new Singly_Linked_list();
		while (true) {
			try {
				String massage = Reader.readLine();
				if(massage==null) {
					Reader.close();
					break;}
				s.add(massage);
				} catch (Exception e) {
				try {
					Reader.close();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
				}
			}
		}
		//sorting
		int index = 25;
	if(ss.getSorting().equals("priority")) {
	index=3;
	}else if(ss.getSorting().equals("subject")) {index=2;}
	else if(ss.getSorting().equals("sender")) {index=0;}
	else if(ss.getSorting().equals("reciver")) {index=1;}
	
	
	if(ss.getSorting()==null) {}
	else if(index==3) {
		int array [][]=new int [2][s.size()];
		for(int i =0;i<s.size();i++) {
			String a=(String)s.get(i);
			String b []= a.split("    ");
			array[0][i]=Integer.parseInt(b[index]);
			array[1][i]=i;
			}
		
		
		ss.Quicksort(array);
		Singly_Linked_list temp = new Singly_Linked_list();
		for(int j =0;j<array[0].length;j++) {
			int index2 =array[1][j];
			temp.add(s.get(index2));
		}
		s=temp;
	}
	else if (index ==0 || index ==1 || index ==2) {
		String array1 [][]=new String [2][s.size()];
		for(int i =0;i<s.size();i++) {
			String a=(String)s.get(i);
			String b []= a.split("    ");
			array1[0][i]=b[index];
			array1[1][i]=String.valueOf(i);
			}

		ss.Quicksort(array1);
		
		Singly_Linked_list temp2 = new Singly_Linked_list();
		for(int j =0;j<array1[0].length;j++) {
			int index2 =Integer.parseInt(array1[1][j]);
			temp2.add(s.get(index2));
		}
		s=temp2;
	}
	//filtering
	String mean=fil.getkindfilter();
	String meann=fil.getnamefilter();
	int w=100;
	if(mean.equals("subject")) {w=2;}
	else if(mean.equals("Date")) {w=4;}
	else if(mean.equals("sender")) {w=0;}
	else if(mean.equals("reciver")) {w=1;}
	String filtering[]=new String[s.size()];
	for(int i =0;i<s.size();i++) {
		filtering[i]=(String)s.get(i);
		}
	if(w!=100) {
	Singly_Linked_list o = new Singly_Linked_list();
	for(int i =0;i<s.size();i++) {
		String parts[]=filtering[i].split("    ");
		if (isSubstring(meann, parts[w])>=0) {
			o.add(s.get(i));
		}
	}
	s=o;}
	return s;	
	}

	@Override
	public IMail[] listEmails(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
	
	public void deleteFolder(String User , String name) {
		String massage = "E:\\Users\\"+User+"\\Draft\\"+name;
		String attach = massage + "\\attachments";
		
		File fSource = new File(massage);
		File fAttach = new File(attach);
		try {
			delete(fAttach);
			fAttach.delete();
			delete(fSource);
			fSource.delete();
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		String index = "E:\\Users\\"+User+"\\Draft\\"+"indexfile.txt";
		DoublyLinkedList list = new DoublyLinkedList();
		
		
		//remove data from index file
		FileReader f = null;
		try {
			f = new FileReader(index);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
		}
		
		BufferedReader Reader = new BufferedReader(f);
		/********************/
		
		// reading the Index  file and removing data from index file
	       while (true) {
				try {
					String lines = Reader.readLine();
					if(lines==null) {
						Reader.close();
						break;}
					String[] mailContent = lines.split("    ");
					String line = mailContent[5];
					if (line.equals(name)) {
						}
					else {
						list.add(lines);
					}
					}
				catch (Exception e) {
						JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
					}}
	       
	       FileWriter f2 = null;
			String temp="E:\\Users\\"+User+"\\Draft\\"+"indexfile1.txt";
			Path Temp=Paths.get(temp);
			try {
				Files.createFile(Temp);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			
			/**********************/
			
    		try {
    			f2=new FileWriter(temp,true);
    		}catch (Exception e) {
 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
 				}
    		BufferedWriter writer = new BufferedWriter(f2);
    		
    //write the new index without the deleting mail
		   for(int i =0; i<list.size();i++) {
			   try {
				writer.write((String)list.get(i));
				writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		   }
		   
		   try {
			writer.close();
	    	} catch (IOException e1) {
			e1.printStackTrace();
	    	}
		   
	//replace indexfile1 by index file			
	       File old = new File(temp);
		   File newer = new File(index);
		   newer.delete();
       try {
			Files.move(Paths.get(temp), Paths.get(index));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
				if(Files.exists(Paths.get(temp))) {
					old.delete();
				}
		
	}
	
	
	
	
	public static void delete(File file)
            throws IOException {

        if (file.isDirectory()) {

            //directory is empty, then delete it
            if (file.list().length == 0) {

                file.delete();
//                System.out.println("Directory is deleted : "+ file.getAbsolutePath());

            } else {

                //list all the directory contents
                String files[] = file.list();

                for (String temp : files) {
                    //construct the file structure
                    File fileDelete = new File(file, temp);

                    //recursive delete
                    delete(fileDelete);
                }

                //check the directory again, if empty then delete it
                if (file.list().length == 0) {
                    file.delete();
//                    System.out.println("Directory is deleted : " + file.getAbsolutePath());
                }
            }

        } else {
            //if file, then delete it
            file.delete();
//            System.out.println("File is deleted : " + file.getAbsolutePath());
        }
    }
	
	
	
	
	
	@Override
	public void deleteEmails(ILinkedList mails) {
		String f = mails.get(mails.size()-1).toString();
		mails.remove(mails.size()-1);
		int size=mails.size();
		for(int i=0;i<size;i++) {
			Mail a=new Mail();
			a=(Mail) mails.get(i);
			deletingEmails(a,f);
		}
		
	} 
	
	
	
	//delete mails from Inbox and Draft 
	
	public void deletingEmails(Mail email,String folder) {
		String input="";
		String target="E:\\Users\\"+email.getTo()+"\\Trash\\";
		String possion="E:\\Users\\"+email.getTo()+"\\"+folder+"\\";
		if(folder.equals("Draft")) {
			 target="E:\\Users\\"+email.getFrom()+"\\Trash\\";
			possion="E:\\Users\\"+email.getFrom()+"\\"+folder+"\\";
		}
		String source=possion+email.getName();
		String index =possion+"indexfile.txt";
		String current =target+email.getName();
		Path Current = Paths.get(current);
	    DoublyLinkedList list=new DoublyLinkedList();
		//checking if the target exists and if not create it
		if (!Files.exists(Paths.get(target))) {
			try {
				Files.createDirectory(Paths.get(target));
				Files.createFile(Paths.get(target+"\\indexfile.txt"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
			}
		}
		//if file exists  add numbers 
		
		int j = 1;
		if(Files.exists(Current)) {
			current+=j;
			Current = Paths.get(current);
			j++;
		}
		while(Files.exists(Current)) {
			current=current.substring(0, current.length()-1)+j;
			Current = Paths.get(current);
			j++;
		}
		String parts[]=current.split("\\\\");
		String name=parts[parts.length-1];

		//deleting the mail
		File fSource = new File(source);
		File fCurrent = new File(current);
		try {
			Files.move(fSource.toPath(), fCurrent.toPath());
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
			if(Files.exists(Paths.get(source))) {
				fSource.delete();
			}
		//remove data from index file
			FileReader f = null;
			try {
				f = new FileReader(index);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
			}
			
			BufferedReader Reader = new BufferedReader(f);
			/********************/
			
			// reading the Index  file and removing data from index file
		       while (true) {
					try {
						String UserID = Reader.readLine();
						if(UserID==null) {
							Reader.close();
							break;}
						String[] userContent = UserID.split("    ");
						String User = userContent[5];
						if (User.equals(email.getName())) {
							 input =UserID;
							}
						else {
							list.add(UserID);
						}
						}
					catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
						}}
		       
		       FileWriter f2 = null;
				String temp=possion+"indexfile1.txt";
				Path Temp=Paths.get(temp);
				try {
					Files.createFile(Temp);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    		try {
	    			f2=new FileWriter(temp,true);
	    		}catch (Exception e) {
	 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
	 				}
	    		BufferedWriter writer = new BufferedWriter(f2);
	    		/**********************/
	    //write the new index without the deleting mail
			   for(int i =0; i<list.size();i++) {
				   try {
					writer.write((String)list.get(i));
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			   }
			   
			   try {
				writer.close();
		    	} catch (IOException e1) {
				e1.printStackTrace();
		    	}
			   
		//replace indexfile1 by index file			
		       File old = new File(temp);
			   File newer = new File(index);
			   newer.delete();
	       try {
				Files.move(Paths.get(temp), Paths.get(index));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
					if(Files.exists(Paths.get(temp))) {
						old.delete();
					}
			
					
					//change the name in the index
					String newIndex[]=input.split("    ");
					StringBuilder input2=new StringBuilder("");
					for(int w=0;w<=newIndex.length-2;w++) {
						input2.append(newIndex[w]);
						input2.append("    ");
					}
					input2.append(name);
					String adding=input2.toString();
			
			
			// write the data deleted email 
    		FileWriter f1 = null;
    		try {
    			f1=new FileWriter(target+"\\indexfile.txt",true);
    		}catch (Exception e) {
 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
 				}
    		BufferedWriter writer2 = new BufferedWriter(f1);
    		/*
    		 *creating the index file
    		 * from    to    subject    Priority    date  name
    		 */
    		try {
    			writer2.write(adding);
                writer2.newLine();
    			writer2.close();
    			
    		} catch (Exception e) {
  			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
  				}
    		
		
	}
	
	
	
	
	public void movingEmails(Mail email,String target,String folder) {
		String input="";
		String source="E:\\Users\\"+email.getTo()+"\\"+folder+"\\"+email.getName();
		String index ="E:\\Users\\"+email.getTo()+"\\"+folder+"\\"+"indexfile.txt";
		String current =target+email.getName();
		Path Current = Paths.get(current);
	    DoublyLinkedList list=new DoublyLinkedList();
		//checking if the target exists and if not create it
		if (!Files.exists(Paths.get(target))) {
			try {
				Files.createDirectory(Paths.get(target));
				Files.createFile(Paths.get(target+"\\indexfile.txt"));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
			}
		}
		//if file exists  add numbers 
		
				int j = 1;
				if(Files.exists(Current)) {
					current+=j;
					Current = Paths.get(current);
					j++;
				}
				while(Files.exists(Current)) {
					current=current.substring(0, current.length()-1)+j;
					Current = Paths.get(current);
					j++;
				}
				String parts[]=current.split("\\\\");
	    		String name=parts[parts.length-1];
	    	    	
				
		//moving the mail
		File fSource = new File(source);
		try {
			Files.move(Paths.get(source), Current);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
			if(Files.exists(Paths.get(source))) {
				fSource.delete();
			}
		//remove data from index file
			FileReader f = null;
			try {
				f = new FileReader(index);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
			}
			
			BufferedReader Reader = new BufferedReader(f);
			/********************/
			
			// reading the Index  file and removing data from index file
		       while (true) {
					try {
						String UserID = Reader.readLine();
						if(UserID==null) {
							Reader.close();
							break;}
						String[] userContent = UserID.split("    ");
						String User = userContent[5];
						if (User.equals(email.getName())) {
							 input =UserID;
							}
						else {
							list.add(UserID);
						}
						}
					catch (Exception e) {
							JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
						}}
		       
		       FileWriter f2 = null;
				String temp="E:\\Users\\"+email.getTo()+"\\"+folder+"\\"+"indexfile1.txt";
				Path Temp=Paths.get(temp);
				try {
					Files.createFile(Temp);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
	    		try {
	    			f2=new FileWriter(temp,true);
	    		}catch (Exception e) {
	 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
	 				}
	    		BufferedWriter writer = new BufferedWriter(f2);
	    		/**********************/
	    //write the new index without the moving mail
			   for(int i =0; i<list.size();i++) {
				   try {
					writer.write((String)list.get(i));
					writer.newLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			   }
			   
			   try {
				writer.close();
		    	} catch (IOException e1) {
				e1.printStackTrace();
		    	}
			   
		//replace indexfile1 by index file			
		       File old = new File(temp);
			   File newer = new File(index);
			   newer.delete();
	       try {
				Files.move(Paths.get(temp), Paths.get(index));
			} catch (IOException e1) {
				e1.printStackTrace();
			}
					if(Files.exists(Paths.get(temp))) {
						old.delete();
					}
			//change the name in the index
			String newIndex[]=input.split("    ");
			StringBuilder input2=new StringBuilder("");
			for(int w=0;w<=newIndex.length-2;w++) {
				input2.append(newIndex[w]);
				input2.append("    ");
			}
			input2.append(name);
			String adding=input2.toString();
			// write the data of moved email 
    		FileWriter f1 = null;
    		try {
    			f1=new FileWriter(target+"\\indexfile.txt",true);
    		}catch (Exception e) {
 			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
 				}
    		BufferedWriter writer2 = new BufferedWriter(f1);
    		/*
    		 *creating the index file
    		 * from    to    subject    Priority    date  name
    		 */
    		try {
    			writer2.write(adding);
                writer2.newLine();
    			writer2.close();
    			
    		} catch (Exception e) {
  			   JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
  				}
    		
    		
		}
		    
	
	
	
	
	
	
	@Override
	public void moveEmails(ILinkedList mails, IFolder des) {
		String ff = mails.get(mails.size()-1).toString();
		mails.remove(mails.size()-1);
		Folder f = (Folder) des;
		int size=mails.size();
		for(int i=0;i<size;i++) {
			Mail a=new Mail();
			a=(Mail) mails.get(i);
			movingEmails(a, f.GetDestination(),ff);
		}
	}

	@Override
	public boolean compose(IMail email) {
		
		Mail m = new Mail();
		m = (Mail) email;
		sendEmail(m);
		return true;
	}

	

}
