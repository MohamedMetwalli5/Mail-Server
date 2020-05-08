package eg.edu.alexu.csd.datastructure.mailServer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.awt.event.ActionEvent;
public class GUI {

		private JFrame frmMailServer;
		private JTextField textField;
		private JPasswordField passwordField;
		App a= new App();
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUI window = new GUI();
						window.frmMailServer.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

		/**
		 * Create the application.
		 */
		public GUI() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frmMailServer = new JFrame();
			frmMailServer.setTitle("Mail Server");
			frmMailServer.setResizable(false);
			frmMailServer.setFont(null);
			frmMailServer.setBounds(100, 100, 584, 405);
			frmMailServer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmMailServer.getContentPane().setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.DARK_GRAY);
			panel.setBounds(0, 0, 582, 373);
			frmMailServer.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("welcome to our Mail Server !!");
			lblNewLabel.setForeground(Color.WHITE);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tempus Sans ITC", Font.BOLD | Font.ITALIC, 22));
			lblNewLabel.setBackground(Color.WHITE);
			lblNewLabel.setBounds(97, 26, 381, 48);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("e-mail");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Stencil", Font.BOLD, 18));
			lblNewLabel_1.setForeground(Color.YELLOW);
			lblNewLabel_1.setBounds(12, 101, 104, 32);
			panel.add(lblNewLabel_1);
			
			JLabel lblPassword = new JLabel("password");
			lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblPassword.setForeground(Color.YELLOW);
			lblPassword.setFont(new Font("Stencil", Font.BOLD, 18));
			lblPassword.setBounds(12, 175, 104, 32);
			panel.add(lblPassword);
			
			textField = new JTextField();
			textField.setBounds(172, 101, 346, 46);
			panel.add(textField);
			textField.setColumns(10);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(172, 180, 346, 46);
			panel.add(passwordField);
			
			JButton btnNewButton = new JButton("Sign In");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					@SuppressWarnings("deprecation")
					boolean x=a.signin(textField.getText().toString(), passwordField.getText().toString());
					if(x) {
						a.SetUser(textField.getText().toString());
						enter m= new enter();
						m.setVisible(true);
						frmMailServer.dispose();
					}else {
						 
					}
				}
			});
			btnNewButton.setBackground(Color.WHITE);
			btnNewButton.setForeground(Color.BLUE);
			btnNewButton.setFont(new Font("Stencil", Font.ITALIC, 19));
			btnNewButton.setBounds(77, 286, 144, 37);
			panel.add(btnNewButton);
			
			JButton btnSignUp = new JButton("Sign UP");
			btnSignUp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SignUP s= new SignUP();
					s.setVisible(true);
					frmMailServer.dispose();
				}
			});
			btnSignUp.setForeground(Color.BLUE);
			btnSignUp.setFont(new Font("Stencil", Font.ITALIC, 19));
			btnSignUp.setBackground(Color.WHITE);
			btnSignUp.setBounds(352, 286, 144, 37);
			panel.add(btnSignUp);
		}

		public class send extends JFrame {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JPanel contentPane;
			private JTextField textField;
			private JTextField textField_1;
			private JRadioButton rdbtnNewRadioButton;
			private JRadioButton radioButton;
			private JRadioButton radioButton_1;
			private JRadioButton radioButton_2;

			

			/**
			 * Create the frame.
			 */
			public send(Mail m) {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 820, 770);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("writing Mail");
				lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 40));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(156, 13, 487, 44);
				contentPane.add(lblNewLabel);
				
				JLabel lblNewLabel_1 = new JLabel("to");
				lblNewLabel_1.setFont(new Font("Stencil", Font.PLAIN, 30));
				lblNewLabel_1.setForeground(Color.RED);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(34, 100, 124, 36);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblSubject = new JLabel("subject");
				lblSubject.setHorizontalAlignment(SwingConstants.CENTER);
				lblSubject.setForeground(Color.RED);
				lblSubject.setFont(new Font("Stencil", Font.PLAIN, 25));
				lblSubject.setBounds(34, 149, 124, 36);
				contentPane.add(lblSubject);
				
				JLabel lblPiri = new JLabel("priority");
				lblPiri.setHorizontalAlignment(SwingConstants.CENTER);
				lblPiri.setForeground(Color.RED);
				lblPiri.setFont(new Font("Stencil", Font.PLAIN, 25));
				lblPiri.setBounds(34, 198, 124, 36);
				contentPane.add(lblPiri);
				
				textField = new JTextField();
				textField.setBounds(181, 105, 543, 31);
				contentPane.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(181, 154, 543, 31);
				contentPane.add(textField_1);
				
				JLabel lblBody = new JLabel("body");
				lblBody.setHorizontalAlignment(SwingConstants.CENTER);
				lblBody.setForeground(Color.BLUE);
				lblBody.setFont(new Font("Stencil", Font.PLAIN, 25));
				lblBody.setBounds(308, 247, 124, 36);
				contentPane.add(lblBody);
				
				JLabel lblAttachments = new JLabel("attachments");
				lblAttachments.setHorizontalAlignment(SwingConstants.CENTER);
				lblAttachments.setForeground(Color.BLUE);
				lblAttachments.setFont(new Font("Stencil", Font.PLAIN, 20));
				lblAttachments.setBounds(34, 491, 167, 36);
				contentPane.add(lblAttachments);
				
			    JTextArea textArea = new JTextArea();
				textArea.setBounds(43, 298, 713, 180);
				contentPane.add(textArea);
				
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setBounds(469, 498, 287, 165);
				contentPane.add(textArea_1);
				
				
				
				JButton btnNewButton = new JButton("send");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Mail m = new Mail();
						m.setTo(textField.getText().toString());
						if (textField.getText().toString().length()==0)
						{
						JOptionPane.showMessageDialog(null, "you should enter receiver");	
						}else if(!Files.exists(Paths.get("E:\\Users\\"+m.getTo()))) {
						JOptionPane.showMessageDialog(null, "this reciver is illegal");	
						}
						else {
						
						m.setSubject(textField_1.getText().toString());
						if(textField_1.getText().toString().length()==0) {
							JOptionPane.showMessageDialog(null, "you should enter subject");	
						}
						else {
							if(rdbtnNewRadioButton.isSelected()) {
								m.setPriority(0);
							}else if(radioButton.isSelected()) { m.setPriority(1);}
							else if(radioButton_1.isSelected()) {m.setPriority(2);}
							else if(radioButton_2.isSelected()) {m.setPriority(3);}
							else {m.setPriority(0);}
						m.setName(m.getSubject());
						String massage = textArea.getText().toString();
						String r[]=massage.split(" ");
						m.setBody(r);
						Singly_Linked_list list = new Singly_Linked_list();
						String [] attach = textArea_1.getText().split("\n");
						m.setAttaclinks(attach);
						for(int j=1;j<attach.length;j++) {
							list.add(attach[j]);
						}
						m.setAttachments(list);
						m.setFrom(a.GetUser());
						a.compose(m);
						dispose();
						}}}
				});
				btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnNewButton.setBounds(72, 685, 97, 25);
				contentPane.add(btnNewButton);
				
				JButton btnDraft = new JButton("draft");
				btnDraft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Mail m = new Mail();
						if(textField.getText().toString().length()>0) {
						m.setTo(textField.getText().toString());}
						else {m.setTo("Unknown");}
						if(rdbtnNewRadioButton.isSelected()) {
							m.setPriority(0);
						}else if(radioButton.isSelected()) { m.setPriority(1);}
						else if(radioButton_1.isSelected()) {m.setPriority(2);}
						else if(radioButton_2.isSelected()) {m.setPriority(3);}
						else {m.setPriority(3);}
						if(textField_1.getText().toString().length()>0) {
						m.setSubject(textField_1.getText().toString());
						m.setName(m.getSubject());}
						else {
							m.setSubject("Unknown");
							m.setName(m.getSubject());
						}
						String massage = textArea.getText().toString();
						String r[]=massage.split(" ");
						m.setBody(r);
						Singly_Linked_list list = new Singly_Linked_list();
						if(textArea_1.getText().toString().length()>0) {
						String [] attach = textArea_1.getText().split("\n");
						m.setAttaclinks(attach);
						for(int j=0;j<attach.length;j++) {
							list.add(attach[j]);
						}
						m.setAttachments(list);}
						m.setFrom(a.GetUser());
						a.draftEmail(m);
						dispose();
					}
				});
				btnDraft.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnDraft.setBounds(260, 685, 97, 25);
				contentPane.add(btnDraft);
				
				JButton btnBack = new JButton("back");
				btnBack.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnBack.setFont(new Font("Times New Roman", Font.BOLD, 18));
				btnBack.setBounds(659, 685, 97, 25);
				contentPane.add(btnBack);
				
				
				
				JButton btnNewButton_1 = new JButton("file chosser");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						final JFileChooser fc = new JFileChooser();
						int reponse = fc.showOpenDialog(null);
						if(reponse == JFileChooser.APPROVE_OPTION ) {
							if(textArea_1.getText().length()==0) {
								textArea_1.setText(fc.getSelectedFile().toString());
							}
							else {
							textArea_1.setText(textArea_1.getText()+"\n"+fc.getSelectedFile().toString());
						}}
					}
				});
				btnNewButton_1.setFont(new Font("Sylfaen", Font.ITALIC, 24));
				btnNewButton_1.setBounds(225, 496, 232, 25);
				contentPane.add(btnNewButton_1);
				
				rdbtnNewRadioButton = new JRadioButton("0");
				rdbtnNewRadioButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(rdbtnNewRadioButton.isSelected()) {
							radioButton.setSelected(false);
							radioButton_1.setSelected(false);
							radioButton_2.setSelected(false);
						}
					}
				});
				rdbtnNewRadioButton.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
				rdbtnNewRadioButton.setBounds(205, 205, 61, 25);
				contentPane.add(rdbtnNewRadioButton);
				
				radioButton = new JRadioButton("1");
				radioButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(radioButton.isSelected()) {
							rdbtnNewRadioButton.setSelected(false);
							radioButton_1.setSelected(false);
							radioButton_2.setSelected(false);
						}
					}
				});
				radioButton.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
				radioButton.setBounds(340, 205, 61, 25);
				contentPane.add(radioButton);
				
				radioButton_1 = new JRadioButton("2");
				radioButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(radioButton_1.isSelected()) {
							rdbtnNewRadioButton.setSelected(false);
							radioButton.setSelected(false);
							radioButton_2.setSelected(false);
						}
					}
				});
				radioButton_1.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
				radioButton_1.setBounds(496, 205, 61, 25);
				contentPane.add(radioButton_1);
				
				radioButton_2 = new JRadioButton("3");
				radioButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(radioButton_2.isSelected()) {
							rdbtnNewRadioButton.setSelected(false);
							radioButton_1.setSelected(false);
							radioButton.setSelected(false);
						}
					}
				});
				radioButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
				radioButton_2.setBounds(663, 205, 61, 25);
				contentPane.add(radioButton_2);
				
				
				if(m.getSubject() != null) {
					  if(!m.getTo().equals("Unknown")) { textField.setText(m.getTo());}
					  if(!m.getSubject().equals("Unknown")) {textField_1.setText(m.getSubject());}
					  if(m.getPriority()==0) {rdbtnNewRadioButton.setSelected(true);}
					  else  if(m.getPriority()==1) {radioButton.setSelected(true);}
					  else  if(m.getPriority()==2) {radioButton_1.setSelected(true);}
					  else  if(m.getPriority()==3) {radioButton_2.setSelected(true);}
					  
					  if(m.getBody()!= null) {
						  for(int i=0;i<m.getBody().length;i++) {
							  textArea.setText(textArea.getText()+m.getBody()[i]+" ");  
						  }
					  }
					  
					  if(m.getAttaclinks()!= null) {
						  for(int i=0;i<m.getAttaclinks().length;i++) {
							  textArea_1.setText(textArea_1.getText()+m.getAttaclinks()[i]+" ");  
						  }
					  }
					}
				
				JButton btnNewButton_2 = new JButton("load from draft");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						sort ss = new sort();
						Folder f=new Folder();
						filter f1=new filter();
						f.SetUser(a.GetUser());
						f.SetFoldername("Draft");
						ss.setSorting("0");
						f1.Setkindfilter("null");
						Singly_Linked_list s = new Singly_Linked_list();
						s=(Singly_Linked_list)a.setViewingOptions(f, f1, ss);
						StringBuilder prev=new StringBuilder(f.GetFolderName()+"    ");
						if(ss.getSorting()!=null) {
							prev.append(ss.getSorting()+"    ");
						}else {
							prev.append("null    ");
						}
						if(f1.getkindfilter()!=null) {
							prev.append(f1.getkindfilter()+"    "+f1.getnamefilter());
						}else {
							prev.append("null    null");
						}
						String previous=prev.toString();
						s.add(previous);
						loadDraft l = new loadDraft(s);
						l.setVisible(true);
						dispose();
					}
				});
				btnNewButton_2.setFont(new Font("Sitka Subheading", Font.BOLD, 20));
				btnNewButton_2.setBounds(72, 638, 238, 25);
				contentPane.add(btnNewButton_2);
				
				
			}
		}


		
		public class SignUP extends JFrame {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JPanel contentPane;
			private JTextField textField;
			private JTextField textField_1;
			private JTextField textField_2;
			private JTextField textField_3;
			
			
			
			/**
			 * Create the frame.
			 */
			public SignUP() {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 700, 589);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("Sign Up");
				lblNewLabel.setForeground(Color.BLACK);
				lblNewLabel.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 35));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(183, 35, 250, 49);
				contentPane.add(lblNewLabel);
				
				textField = new JTextField();
				textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
				textField.setBounds(208, 119, 417, 54);
				contentPane.add(textField);
				textField.setColumns(10);
				
				textField_1 = new JTextField();
				textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
				textField_1.setColumns(10);
				textField_1.setBounds(208, 202, 417, 54);
				contentPane.add(textField_1);
				
				textField_2 = new JTextField();
				textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
				textField_2.setColumns(10);
				textField_2.setBounds(208, 293, 417, 54);
				contentPane.add(textField_2);
				
				JLabel lblNewLabel_1 = new JLabel("E-mail");
				lblNewLabel_1.setForeground(Color.BLUE);
				lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD, 25));
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setBounds(23, 119, 140, 42);
				contentPane.add(lblNewLabel_1);
				
				JLabel lblNickName = new JLabel("Nick Name");
				lblNickName.setHorizontalAlignment(SwingConstants.CENTER);
				lblNickName.setForeground(Color.BLUE);
				lblNickName.setFont(new Font("Sitka Text", Font.BOLD, 25));
				lblNickName.setBounds(23, 202, 140, 42);
				contentPane.add(lblNickName);
				
				JLabel lblPhone = new JLabel("Phone");
				lblPhone.setHorizontalAlignment(SwingConstants.CENTER);
				lblPhone.setForeground(Color.BLUE);
				lblPhone.setFont(new Font("Sitka Text", Font.BOLD, 25));
				lblPhone.setBounds(23, 293, 140, 42);
				contentPane.add(lblPhone);
				
				JLabel lblPassword = new JLabel("password\r\n");
				lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
				lblPassword.setForeground(Color.BLUE);
				lblPassword.setFont(new Font("Sitka Text", Font.BOLD, 25));
				lblPassword.setBounds(23, 375, 140, 42);
				contentPane.add(lblPassword);
				
				textField_3 = new JTextField();
				textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
				textField_3.setColumns(10);
				textField_3.setBounds(208, 375, 417, 54);
				contentPane.add(textField_3);
				
				JButton button = new JButton("Sign UP");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						Contact c = new Contact(textField.getText().toString(), textField_1.getText().toString() , textField_2.getText().toString() , textField_3.getText().toString() );
						boolean x=a.signup(c);
						if(x) {
							a.SetUser(textField.getText().toString());
							enter m= new enter();
							m.setVisible(true);
							dispose();
						}else {
							JOptionPane.showMessageDialog(null, "this e-mail is illegal");
						}
					}
				});
				button.setForeground(Color.DARK_GRAY);
				button.setFont(new Font("Stencil", Font.ITALIC, 19));
				button.setBackground(Color.WHITE);
				button.setBounds(104, 475, 144, 37);
				contentPane.add(button);
				
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GUI.main(null);
						dispose();
					}
				});
				btnBack.setForeground(Color.DARK_GRAY);
				btnBack.setFont(new Font("Stencil", Font.ITALIC, 19));
				btnBack.setBackground(Color.WHITE);
				btnBack.setBounds(420, 475, 144, 37);
				contentPane.add(btnBack);
			}

		}
		public class enter extends JFrame {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JPanel contentPane;
		    

			/**
			 * Create the frame.
			 */
			public enter() {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 700, 450);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(0, 0, 0));
				panel.setBounds(0, 0, 682, 403);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel label = new JLabel("choose the operation that you want !!");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setForeground(Color.RED);
				label.setFont(new Font("Sitka Text", Font.BOLD, 34));
				label.setBounds(12, 70, 654, 44);
				panel.add(label);
				
				JLabel lblNewLabel = new JLabel("Welcome");
				lblNewLabel.setForeground(new Color(255, 255, 0));
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Stencil", Font.PLAIN, 35));
				lblNewLabel.setBounds(12, 13, 654, 44);
				panel.add(lblNewLabel);
				
				JButton btnSend = new JButton("Send");
				btnSend.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Mail m = new Mail();
						m.setSubject(null);
						send s=new send(m);
						s.setVisible(true);
					}
				});
				btnSend.setBackground(new Color(255, 255, 0));
				btnSend.setForeground(Color.BLACK);
				btnSend.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
				btnSend.setBounds(101, 158, 125, 44);
				panel.add(btnSend);
				
				JButton btnMove = new JButton("Move");
				btnMove.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						move s = new move();
						s.setVisible(true);
					}
				});
				btnMove.setBackground(new Color(255, 255, 0));
				btnMove.setForeground(Color.BLACK);
				btnMove.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
				btnMove.setBounds(465, 158, 125, 44);
				panel.add(btnMove);
				
				JButton btnDelete = new JButton("Delete");
				btnDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sort ss = new sort();
						Folder f=new Folder();
						filter f1=new filter();
						f.SetUser(a.GetUser());
						f.SetFoldername("Inbox");
						ss.setSorting("1");
						f1.Setkindfilter("null");
						Singly_Linked_list s = new Singly_Linked_list();
						s=(Singly_Linked_list)a.setViewingOptions(f, f1, ss);
						StringBuilder prev=new StringBuilder(f.GetFolderName()+"    ");
						if(ss.getSorting()!=null) {
							prev.append(ss.getSorting()+"    ");
						}else {
							prev.append("null    ");
						}
						if(f1.getkindfilter()!=null && f1.getkindfilter()!="null") {
							prev.append(f1.getkindfilter()+"    "+f1.getnamefilter());
						}else {
							prev.append("null    null");
						}
						String previous=prev.toString();
						s.add(previous); 
						oparate v = new oparate(s,null);
						v.setVisible(true);
					}
				});
				btnDelete.setBackground(new Color(255, 255, 0));
				btnDelete.setForeground(Color.BLACK);
				btnDelete.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
				btnDelete.setBounds(101, 238, 125, 44);
				panel.add(btnDelete);
				
				JButton btnView = new JButton("View\r\n");
				btnView.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						sort ss = new sort();
						Folder f=new Folder();
						filter f1=new filter();
						f.SetUser(a.GetUser());
						f.SetFoldername("Inbox");
						ss.setSorting("1");
						f1.Setkindfilter("null");
						Singly_Linked_list s = new Singly_Linked_list();
						s=(Singly_Linked_list)a.setViewingOptions(f, f1, ss);
						StringBuilder prev=new StringBuilder(f.GetFolderName()+"    ");
						if(ss.getSorting()!=null) {
							prev.append(ss.getSorting()+"    ");
						}else {
							prev.append("null    ");
						}
						if(f1.getkindfilter()!=null && f1.getkindfilter()!="null") {
							prev.append(f1.getkindfilter()+"    "+f1.getnamefilter());
						}else {
							prev.append("null    null");
						}
						String previous=prev.toString();
						s.add(previous);
						view frame = new view(s);
						frame.setVisible(true);
					}
				});
				btnView.setBackground(new Color(255, 255, 0));
				btnView.setForeground(Color.BLACK);
				btnView.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
				btnView.setBounds(465, 238, 125, 44);
				panel.add(btnView);
				
				JButton btnNewButton = new JButton("LOG OUT");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						GUI.main(null);
						dispose();
					}
				});
				btnNewButton.setBackground(new Color(255, 255, 255));
				btnNewButton.setFont(new Font("Snap ITC", Font.BOLD, 40));
				btnNewButton.setBounds(161, 326, 353, 50);
				panel.add(btnNewButton);
			}
		}
		
		public class view extends JFrame {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JPanel contentPane;
		    private JLabel massage1,massage2,massage3,massage4,massage5;
		    private JLabel massage6,massage7,massage8,massage9,massage10;
		    private JLabel massage11,massage12,massage13,massage14,massage15;
		    private JLabel massage16,massage17,massage18,massage19,massage20;
		    private JLabel massage21,massage22,massage23,massage24,massage25;
		    private JLabel massage26,massage27,massage28,massage29,massage30;
		    private JLabel massage31,massage32,massage33,massage34,massage35;
		    private JLabel massage36,massage37,massage38,massage39,massage40;
		    private JLabel massage41,massage42,massage43,massage44,massage45;
		    private JLabel massage46,massage47,massage48,massage49,massage50;
		    private JRadioButton Inbox,Trash,Draft;
		    private JRadioButton Sender,Receiver,Subject,piriority;
		    private JTextField textField;
			private JRadioButton r1,r2,r3,r4,r5;
			JPanel panellll;
			private JRadioButton reciver2;
		    private JRadioButton sender2;
		    private JRadioButton date,sub2;
			/**
			 * Create the frame.
			 */
			public view(Singly_Linked_list s) {
				String pervious=(String)s.get(s.size()-1);
				String prev[]=pervious.split("    ");
				String prefolder=prev[0];
				String presorting=prev[1];
				String prefilter=prev[2];
				String prefilter2=prev[3];
				s.remove(s.size()-1);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 800, 700);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setForeground(Color.WHITE);
				panel.setBackground(Color.GRAY);
				panel.setBounds(0, 0, 782, 195);
				contentPane.add(panel);
				
				JLabel label = new JLabel("Folder");
				label.setOpaque(true);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setForeground(new Color(72, 61, 139));
				label.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				label.setBackground(new Color(245, 255, 250));
				label.setBounds(12, 13, 149, 22);
				panel.add(label);
				
				Inbox = new JRadioButton("Inbox");
				Inbox.setHorizontalAlignment(SwingConstants.CENTER);
				Inbox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(Inbox.isSelected()) {
							Trash.setSelected(false);
							Draft.setSelected(false);
						}
					}
				});
				Inbox.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Inbox.setBounds(202, 12, 126, 25);
				panel.add(Inbox);
				
				Draft = new JRadioButton("Draft");
				Draft.setHorizontalAlignment(SwingConstants.CENTER);
				Draft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Draft.isSelected()) {
							Inbox.setSelected(false);
							Trash.setSelected(false);
						}
					}
				});
				Draft.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Draft.setBounds(406, 12, 126, 25);
				panel.add(Draft);
				
				Trash = new JRadioButton("Trash");
				Trash.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Trash.isSelected()) {
							Inbox.setSelected(false);
							Draft.setSelected(false);
						}
					}
				});
				Trash.setHorizontalAlignment(SwingConstants.CENTER);
				Trash.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Trash.setBounds(604, 14, 126, 25);
				panel.add(Trash);
				
				JLabel lblSort = new JLabel("Sort");
				lblSort.setOpaque(true);
				lblSort.setHorizontalAlignment(SwingConstants.CENTER);
				lblSort.setForeground(new Color(72, 61, 139));
				lblSort.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				lblSort.setBackground(new Color(245, 255, 250));
				lblSort.setBounds(12, 57, 149, 22);
				panel.add(lblSort);
				
				 Sender = new JRadioButton("Sender");
				 Sender.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(Sender.isSelected()) {
				 			Receiver.setSelected(false);
				 			Subject.setSelected(false);
				 			piriority.setSelected(false);
				 		}
				 	}
				 });
				Sender.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Sender.setBounds(202, 58, 91, 25);
				panel.add(Sender);
				
				 Receiver = new JRadioButton("Receiver\r\n");
				 Receiver.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(Receiver.isSelected()) {
				 			Sender.setSelected(false);
				 			Subject.setSelected(false);
				 			piriority.setSelected(false);
				 		}
				 	}
				 });
				Receiver.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Receiver.setBounds(335, 58, 114, 25);
				panel.add(Receiver);
				
				 Subject = new JRadioButton("Subject");
				 Subject.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(Subject.isSelected()) {
				 			Sender.setSelected(false);
				 			Receiver.setSelected(false);
				 			piriority.setSelected(false);
				 		}
				 	}
				 });
				Subject.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Subject.setBounds(500, 56, 100, 25);
				panel.add(Subject);
				
				 piriority = new JRadioButton("Importance");
				 piriority.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(piriority.isSelected()) {
				 			Sender.setSelected(false);
				 			Receiver.setSelected(false);
				 			Subject.setSelected(false);
				 		}
				 	}
				 });
				piriority.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				piriority.setBounds(630, 56, 133, 25);
				panel.add(piriority);
				
				JLabel lblFilter = new JLabel("Filter");
				lblFilter.setOpaque(true);
				lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
				lblFilter.setForeground(new Color(72, 61, 139));
				lblFilter.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				lblFilter.setBackground(new Color(245, 255, 250));
				lblFilter.setBounds(12, 100, 149, 22);
				panel.add(lblFilter);
				
				textField = new JTextField();
				textField.setFont(new Font("Sitka Small", Font.BOLD, 20));
				textField.setBounds(202, 158, 347, 24);
				panel.add(textField);
				textField.setColumns(10);
				
				
				
				JButton btnNewButton = new JButton("Refresh");
				btnNewButton.setBounds(630, 156, 133, 26);
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean good=true;
						Singly_Linked_list s= new Singly_Linked_list();
						Folder f = new Folder();
						f.SetUser(a.GetUser());
						if(Inbox.isSelected()) {f.SetFoldername("Inbox");}
						else if (Trash.isSelected()) {f.SetFoldername("Trash");}
						else if (Draft.isSelected()) {f.SetFoldername("Draft");}
						else {
							f.SetFoldername(prefolder.toString());	
						}
						sort ss= new sort();
						if (Sender.isSelected()) {ss.setSorting("sender");}
						else if (Receiver.isSelected()) {ss.setSorting("receiver");}
						else if (Subject.isSelected()) {ss.setSorting("subject");}
						else if (piriority.isSelected()) {ss.setSorting("priority");}
						else if (!presorting.equals("null")) {ss.setSorting(presorting);}
						
						filter f1= new filter();
						if(sub2.isSelected()) {f1.Setkindfilter("subject");}
						else if(date.isSelected()) {f1.Setkindfilter("Date");}
						else if(sender2.isSelected()) {f1.Setkindfilter("sender");}
						else if(reciver2.isSelected()) {f1.Setkindfilter("reciver");}
						else {f1.Setkindfilter(prefilter);
						f1.Setnamefilter(prefilter2);}
						if(sub2.isSelected()  || date.isSelected() || sender2.isSelected() || reciver2.isSelected()) {
						if(textField.getText().toString().length()>0) {
						f1.Setnamefilter(textField.getText().toString());}
						else {
							JOptionPane.showMessageDialog(null, "You Should enter String in filter box");
							good=false;
						}
						
						}
						if(good) {
						s=(Singly_Linked_list)a.setViewingOptions(f, f1, ss);
						StringBuilder prevv=new StringBuilder(f.GetFolderName()+"    ");
						if(ss.getSorting()!=null) {
							prevv.append(ss.getSorting()+"    ");
						}else {
							prevv.append("null    ");
						}
						if(f1.getkindfilter()!=null && !f1.getkindfilter().equals("null") ) {
							prevv.append(f1.getkindfilter()+"    "+f1.getnamefilter());
						}else {
							prevv.append("null    null");
						}
						String previouss=prevv.toString();
						//System.out.println(previouss);
						s.add(previouss);
						view v=new view(s);
						v.setVisible(true);
						dispose();}
					}
				});
				btnNewButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 25));
				
				sub2 = new JRadioButton("Subject");
				sub2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(sub2.isSelected()) {
							reciver2.setSelected(false);
							sender2.setSelected(false);
							date.setSelected(false);
						}	
					}
				});
				sub2.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				sub2.setBounds(500, 101, 100, 25);
				panel.add(sub2);
				
				reciver2 = new JRadioButton("Receiver\r\n");
				reciver2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(reciver2.isSelected()) {
							sub2.setSelected(false);
							sender2.setSelected(false);
							date.setSelected(false);
						}	
					}
				});
				reciver2.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				reciver2.setBounds(335, 99, 114, 25);
				panel.add(reciver2);
				
				sender2 = new JRadioButton("Sender");
				sender2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(sender2.isSelected()) {
							sub2.setSelected(false);
							reciver2.setSelected(false);
							date.setSelected(false);
						}
					}
				});
				sender2.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				sender2.setBounds(202, 101, 91, 25);
				panel.add(sender2);
				
				date = new JRadioButton("Date");
				date.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(date.isSelected()) {
							sub2.setSelected(false);
							reciver2.setSelected(false);
							sender2.setSelected(false);
						}
					}
				});
				date.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				date.setBounds(630, 101, 100, 25);
				panel.add(date);
				
				
				
				
				panellll = new JPanel();
				panellll.setBounds(50, 280, 670, 309);
				contentPane.add(panellll);
				panellll.setLayout(new CardLayout(0, 0));
				
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(Color.BLUE);
				panellll.add(panel_1, "name_344929928447800");
				
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBackground(Color.BLUE);
				panellll.add(panel_2, "name_344962931110400");
				
				JPanel panel_3 = new JPanel();
				panel_3.setLayout(null);
				panel_3.setBackground(Color.BLUE);
				panellll.add(panel_3, "name_348895440977600");
				
				JPanel panel_4 = new JPanel();
				panel_4.setLayout(null);
				panel_4.setBackground(Color.BLUE);
				panellll.add(panel_4, "name_348905531528400");
				
				JPanel panel_5 = new JPanel();
				panel_5.setLayout(null);
				panel_5.setBackground(Color.BLUE);
				panellll.add(panel_5, "name_348954193306500");
				
				
				
				String array1[]=new String [10];
				for(int i =0;i<array1.length;i++) {
					if(i<s.size()) {
				array1[i]=(String)s.get(i);}
					else {array1[i]=null;}
				}
				for(int i =0;i<array1.length;i++) {
					if(i==0 ) {
						if( array1[i]!=null) {
					    String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage1=new JLabel(Temp[Temp.length-1]);
						massage1.setOpaque(true);
						massage1.setBackground(Color.WHITE);
						massage1.setBounds(15, 15, 550, 25);
						panel_1.add(massage1);}
						else {
							massage1 = new JLabel("");
							massage1.setOpaque(true);
							massage1.setBackground(Color.WHITE);
							massage1.setBounds(15, 15, 550, 25);
							panel_1.add(massage1);
						}
						
					}
					else if(i==1) {
						if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage2=new JLabel(Temp[Temp.length-1]);
						massage2.setOpaque(true);
						massage2.setBackground(Color.WHITE);
						massage2.setBounds(15, 43, 550, 25);
						panel_1.add(massage2);
						}else {
							massage2 = new JLabel("");
							massage2.setOpaque(true);
							massage2.setBackground(Color.WHITE);
							massage2.setBounds(15, 43, 550, 25);
							panel_1.add(massage2);
						}
					}
					else if(i==2) {
						if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage3=new JLabel(Temp[Temp.length-1]);
						massage3.setOpaque(true);
						massage3.setBackground(Color.WHITE);
						massage3.setBounds(15, 71, 550, 25);
						panel_1.add(massage3);}
						else {
							massage3 = new JLabel("");
							massage3.setOpaque(true);
							massage3.setBackground(Color.WHITE);
							massage3.setBounds(15, 71, 550, 25);
							panel_1.add(massage3);
						}
					}
					else if(i==3 ) {
						if (array1[i]!=null) {
					    String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage4=new JLabel(Temp[Temp.length-1]);
						massage4.setOpaque(true);
						massage4.setBackground(Color.WHITE);
						massage4.setBounds(15, 99, 550, 25);
						panel_1.add(massage4);}
						else {
							massage4 = new JLabel("");
							massage4.setOpaque(true);
							massage4.setBackground(Color.WHITE);
							massage4.setBounds(15, 99, 550, 25);
							panel_1.add(massage4);
						}
					}
					else if(i==4 ) {
					  if( array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage5=new JLabel(Temp[Temp.length-1]);
						massage5.setOpaque(true);
						massage5.setBackground(Color.WHITE);
						massage5.setBounds(15, 127, 550, 25);
						panel_1.add(massage5);}
					  else {
						  massage5 = new JLabel("");
							massage5.setOpaque(true);
							massage5.setBackground(Color.WHITE);
							massage5.setBounds(15, 127, 550, 25);
							panel_1.add(massage5);
					  }
					  
						
					}
					else if(i==5 ) {
						if( array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage6=new JLabel(Temp[Temp.length-1]);
						massage6.setOpaque(true);
						massage6.setBackground(Color.WHITE);
						massage6.setBounds(15, 155, 550, 25);
						panel_1.add(massage6);}
						else {
							massage6 = new JLabel("");
							massage6.setOpaque(true);
							massage6.setBackground(Color.WHITE);
							massage6.setBounds(15, 155, 550, 25);
							panel_1.add(massage6);
						}
					}
					else if(i==6) {
						if( array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage7=new JLabel(Temp[Temp.length-1]);
						massage7.setOpaque(true);
						massage7.setBackground(Color.WHITE);
						massage7.setBounds(15, 183, 550, 25);
						panel_1.add(massage7);}
						else {
							massage7 = new JLabel("");
							massage7.setOpaque(true);
							massage7.setBackground(Color.WHITE);
							massage7.setBounds(15, 183, 550, 25);
							panel_1.add(massage7);
						}
					}
					else if(i==7) {
						if (array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage8=new JLabel(Temp[Temp.length-1]);
						massage8.setOpaque(true);
						massage8.setBackground(Color.WHITE);
						massage8.setBounds(15, 211, 550, 25);
						panel_1.add(massage8);}
						else {
							massage8 = new JLabel("");
							massage8.setOpaque(true);
							massage8.setBackground(Color.WHITE);
							massage8.setBounds(15, 211, 550, 25);
							panel_1.add(massage8);
						}
					}
					else if(i==8 ) {
						if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage9=new JLabel(Temp[Temp.length-1]);
						massage9.setOpaque(true);
						massage9.setBackground(Color.WHITE);
						massage9.setBounds(15, 239, 550, 25);
						panel_1.add(massage9);}
						else {
							massage9 = new JLabel("");
							massage9.setOpaque(true);
							massage9.setBackground(Color.WHITE);
							massage9.setBounds(15, 239, 550, 25);
							panel_1.add(massage9);
						}
					}
					else if(i==9 ) {
							if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage10=new JLabel(Temp[Temp.length-1]);
						massage10.setOpaque(true);
						massage10.setBackground(Color.WHITE);
						massage10.setBounds(15, 267, 550, 25);
						panel_1.add(massage10);}
							else {
								massage10 = new JLabel("");
								massage10.setOpaque(true);
								massage10.setBackground(Color.WHITE);
								massage10.setBounds(15, 267, 550, 25);
								panel_1.add(massage10);
							}
					}
				}
				
				
				String array2[]=new String [10];
				for(int i =10;i<array2.length+10;i++) {
					if(i<s.size()) {
				array2[i%10]=(String)s.get(i);}
					else {array2[i%10]=null;}
				}
				for(int i =0;i<array2.length;i++) {
					if(i==0 ) {
						if( array2[i]!=null) {
					    String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage11=new JLabel(Temp[Temp.length-1]);
						massage11.setOpaque(true);
						massage11.setBackground(Color.WHITE);
						massage11.setBounds(15, 15, 550, 25);
						panel_2.add(massage11);}
						else {
							massage11 = new JLabel("");
							massage11.setOpaque(true);
							massage11.setBackground(Color.WHITE);
							massage11.setBounds(15, 15, 550, 25);
							panel_2.add(massage11);
						}
						
					}
					else if(i==1) {
						if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage12=new JLabel(Temp[Temp.length-1]);
						massage12.setOpaque(true);
						massage12.setBackground(Color.WHITE);
						massage12.setBounds(15, 43, 550, 25);
						panel_2.add(massage12);
						}else {
							massage12 = new JLabel("");
							massage12.setOpaque(true);
							massage12.setBackground(Color.WHITE);
							massage12.setBounds(15, 43, 550, 25);
							panel_2.add(massage12);
						}
					}
					else if(i==2) {
						if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage13=new JLabel(Temp[Temp.length-1]);
						massage13.setOpaque(true);
						massage13.setBackground(Color.WHITE);
						massage13.setBounds(15, 71, 550, 25);
						panel_2.add(massage13);}
						else {
							massage13 = new JLabel("");
							massage13.setOpaque(true);
							massage13.setBackground(Color.WHITE);
							massage13.setBounds(15, 71, 550, 25);
							panel_2.add(massage13);
						}
					}
					else if(i==3 ) {
						if (array2[i]!=null) {
					    String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage14=new JLabel(Temp[Temp.length-1]);
						massage14.setOpaque(true);
						massage14.setBackground(Color.WHITE);
						massage14.setBounds(15, 99, 550, 25);
						panel_2.add(massage14);}
						else {
							massage14 = new JLabel("");
							massage14.setOpaque(true);
							massage14.setBackground(Color.WHITE);
							massage14.setBounds(15, 99, 550, 25);
							panel_2.add(massage14);
						}
					}
					else if(i==4 ) {
					  if( array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage15=new JLabel(Temp[Temp.length-1]);
						massage15.setOpaque(true);
						massage15.setBackground(Color.WHITE);
						massage15.setBounds(15, 127, 550, 25);
						panel_2.add(massage15);}
					  else {
						  massage15 = new JLabel("");
							massage15.setOpaque(true);
							massage15.setBackground(Color.WHITE);
							massage15.setBounds(15, 127, 550, 25);
							panel_2.add(massage15);
					  }
						
					}
					else if(i==5 ) {
						if( array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage16=new JLabel(Temp[Temp.length-1]);
						massage16.setOpaque(true);
						massage16.setBackground(Color.WHITE);
						massage16.setBounds(15, 155, 550, 25);
						panel_2.add(massage16);}
						else {
							massage16 = new JLabel("");
							massage16.setOpaque(true);
							massage16.setBackground(Color.WHITE);
							massage16.setBounds(15, 155, 550, 25);
							panel_2.add(massage16);
						}
					}
					else if(i==6) {
						if( array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage17=new JLabel(Temp[Temp.length-1]);
						massage17.setOpaque(true);
						massage17.setBackground(Color.WHITE);
						massage17.setBounds(15, 183, 550, 25);
						panel_2.add(massage17);}
						else {
							massage17 = new JLabel("");
							massage17.setOpaque(true);
							massage17.setBackground(Color.WHITE);
							massage17.setBounds(15, 183, 550, 25);
							panel_2.add(massage17);
						}
					}
					else if(i==7) {
						if (array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage18=new JLabel(Temp[Temp.length-1]);
						massage18.setOpaque(true);
						massage18.setBackground(Color.WHITE);
						massage18.setBounds(15, 211, 550, 25);
						panel_2.add(massage18);}
						else {
							massage18 = new JLabel("");
							massage18.setOpaque(true);
							massage18.setBackground(Color.WHITE);
							massage18.setBounds(15, 211, 550, 25);
							panel_2.add(massage18);
						}
					}
					else if(i==8 ) {
						if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage19=new JLabel(Temp[Temp.length-1]);
						massage19.setOpaque(true);
						massage19.setBackground(Color.WHITE);
						massage19.setBounds(15, 239, 550, 25);
						panel_2.add(massage19);}
						else {
							massage19 = new JLabel("");
							massage19.setOpaque(true);
							massage19.setBackground(Color.WHITE);
							massage19.setBounds(15, 239, 550, 25);
							panel_2.add(massage19);
						}
					}
					else if(i==9 ) {
							if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage20=new JLabel(Temp[Temp.length-1]);
						massage20.setOpaque(true);
						massage20.setBackground(Color.WHITE);
						massage20.setBounds(15, 267, 550, 25);
						panel_2.add(massage20);}
							else {
								massage20 = new JLabel("");
								massage20.setOpaque(true);
								massage20.setBackground(Color.WHITE);
								massage20.setBounds(15, 267, 550, 25);
								panel_2.add(massage20);
							}
					}
				}
				
				
				
				String array3[]=new String [10];
				for(int i =20;i<array3.length+20;i++) {
					if(i<s.size()) {
				array3[i%20]=(String)s.get(i);}
					else {array3[i%20]=null;}
				}
				for(int i =0;i<array3.length;i++) {
					if(i==0 ) {
						if( array3[i]!=null) {
					    String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage21=new JLabel(Temp[Temp.length-1]);
						massage21.setOpaque(true);
						massage21.setBackground(Color.WHITE);
						massage21.setBounds(15, 15, 550, 25);
						panel_3.add(massage21);}
						else {
							massage21 = new JLabel("");
							massage21.setOpaque(true);
							massage21.setBackground(Color.WHITE);
							massage21.setBounds(15, 15, 550, 25);
							panel_3.add(massage21);
						}
						
					}
					else if(i==1) {
						if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage22=new JLabel(Temp[Temp.length-1]);
						massage22.setOpaque(true);
						massage22.setBackground(Color.WHITE);
						massage12.setBounds(15, 43, 550, 25);
						panel_3.add(massage22);
						}else {
							massage22 = new JLabel("");
							massage22.setOpaque(true);
							massage22.setBackground(Color.WHITE);
							massage22.setBounds(15, 43, 550, 25);
							panel_3.add(massage22);
						}
					}
					else if(i==2) {
						if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage23=new JLabel(Temp[Temp.length-1]);
						massage23.setOpaque(true);
						massage23.setBackground(Color.WHITE);
						massage13.setBounds(15, 71, 550, 25);
						panel_3.add(massage23);}
						else {
							massage23 = new JLabel("");
							massage23.setOpaque(true);
							massage23.setBackground(Color.WHITE);
							massage23.setBounds(15, 71, 550, 25);
							panel_3.add(massage23);
						}
					}
					else if(i==3 ) {
						if (array3[i]!=null) {
					    String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage24=new JLabel(Temp[Temp.length-1]);
						massage24.setOpaque(true);
						massage24.setBackground(Color.WHITE);
						massage14.setBounds(15, 99, 550, 25);
						panel_3.add(massage24);}
						else {
							massage24 = new JLabel("");
							massage24.setOpaque(true);
							massage24.setBackground(Color.WHITE);
							massage24.setBounds(15, 99, 550, 25);
							panel_3.add(massage24);
						}
					}
					else if(i==4 ) {
					  if( array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage25=new JLabel(Temp[Temp.length-1]);
						massage25.setOpaque(true);
						massage25.setBackground(Color.WHITE);
						massage25.setBounds(15, 127, 550, 25);
						panel_3.add(massage25);}
					  else {
						  massage25 = new JLabel("");
							massage25.setOpaque(true);
							massage25.setBackground(Color.WHITE);
							massage25.setBounds(15, 127, 550, 25);
							panel_3.add(massage25);
					  }
						
					}
					else if(i==5 ) {
						if( array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage26=new JLabel(Temp[Temp.length-1]);
						massage26.setOpaque(true);
						massage26.setBackground(Color.WHITE);
						massage26.setBounds(15, 155, 550, 25);
						panel_3.add(massage26);}
						else {
							massage26 = new JLabel("");
							massage26.setOpaque(true);
							massage26.setBackground(Color.WHITE);
							massage26.setBounds(15, 155, 550, 25);
							panel_3.add(massage26);
						}
					}
					else if(i==6) {
						if( array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage27=new JLabel(Temp[Temp.length-1]);
						massage27.setOpaque(true);
						massage27.setBackground(Color.WHITE);
						massage27.setBounds(15, 183, 550, 25);
						panel_3.add(massage27);}
						else {
							massage27 = new JLabel("");
							massage27.setOpaque(true);
							massage27.setBackground(Color.WHITE);
							massage27.setBounds(15, 183, 550, 25);
							panel_3.add(massage27);
						}
					}
					else if(i==7) {
						if (array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage28=new JLabel(Temp[Temp.length-1]);
						massage28.setOpaque(true);
						massage28.setBackground(Color.WHITE);
						massage28.setBounds(15, 211, 550, 25);
						panel_3.add(massage28);}
						else {
							massage28 = new JLabel("");
							massage28.setOpaque(true);
							massage28.setBackground(Color.WHITE);
							massage28.setBounds(15, 211, 550, 25);
							panel_3.add(massage28);
						}
					}
					else if(i==8 ) {
						if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage29=new JLabel(Temp[Temp.length-1]);
						massage29.setOpaque(true);
						massage29.setBackground(Color.WHITE);
						massage29.setBounds(15, 239, 550, 25);
						panel_3.add(massage29);}
						else {
							massage29 = new JLabel("");
							massage29.setOpaque(true);
							massage29.setBackground(Color.WHITE);
							massage29.setBounds(15, 239, 550, 25);
							panel_3.add(massage29);
						}
					}
					else if(i==9 ) {
							if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage30=new JLabel(Temp[Temp.length-1]);
						massage30.setOpaque(true);
						massage30.setBackground(Color.WHITE);
						massage30.setBounds(15, 267, 550, 25);
						panel_3.add(massage30);}
							else {
								massage30 = new JLabel("");
								massage30.setOpaque(true);
								massage30.setBackground(Color.WHITE);
								massage30.setBounds(15, 267, 550, 25);
								panel_3.add(massage30);
							}
					}
				}
				
				
				String array4[]=new String [10];
				for(int i =30;i<array4.length+30;i++) {
					if(i<s.size()) {
				array4[i%30]=(String)s.get(i);}
					else {array4[i%30]=null;}
				}
				for(int i =0;i<array4.length;i++) {
					if(i==0 ) {
						if( array4[i]!=null) {
					    String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage31=new JLabel(Temp[Temp.length-1]);
						massage31.setOpaque(true);
						massage31.setBackground(Color.WHITE);
						massage31.setBounds(15, 15, 550, 25);
						panel_4.add(massage31);}
						else {
							massage31 = new JLabel("");
							massage31.setOpaque(true);
							massage31.setBackground(Color.WHITE);
							massage31.setBounds(15, 15, 550, 25);
							panel_4.add(massage31);
						}
						
					}
					else if(i==1) {
						if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage32=new JLabel(Temp[Temp.length-1]);
						massage32.setOpaque(true);
						massage32.setBackground(Color.WHITE);
						massage32.setBounds(15, 43, 550, 25);
						panel_4.add(massage32);
						}else {
							massage32 = new JLabel("");
							massage32.setOpaque(true);
							massage32.setBackground(Color.WHITE);
							massage32.setBounds(15, 43, 550, 25);
							panel_4.add(massage32);
						}
					}
					else if(i==2) {
						if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage33=new JLabel(Temp[Temp.length-1]);
						massage33.setOpaque(true);
						massage33.setBackground(Color.WHITE);
						massage33.setBounds(15, 71, 550, 25);
						panel_4.add(massage33);}
						else {
							massage33 = new JLabel("");
							massage33.setOpaque(true);
							massage33.setBackground(Color.WHITE);
							massage33.setBounds(15, 71, 550, 25);
							panel_4.add(massage33);
						}
					}
					else if(i==3 ) {
						if (array4[i]!=null) {
					    String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage34=new JLabel(Temp[Temp.length-1]);
						massage34.setOpaque(true);
						massage34.setBackground(Color.WHITE);
						massage34.setBounds(15, 99, 550, 25);
						panel_4.add(massage34);}
						else {
							massage34 = new JLabel("");
							massage34.setOpaque(true);
							massage34.setBackground(Color.WHITE);
							massage34.setBounds(15, 99, 550, 25);
							panel_4.add(massage34);
						}
					}
					else if(i==4 ) {
					  if( array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage35=new JLabel(Temp[Temp.length-1]);
						massage35.setOpaque(true);
						massage35.setBackground(Color.WHITE);
						massage35.setBounds(15, 127, 550, 25);
						panel_4.add(massage35);}
					  else {
						  massage35 = new JLabel("");
							massage35.setOpaque(true);
							massage35.setBackground(Color.WHITE);
							massage35.setBounds(15, 127, 550, 25);
							panel_4.add(massage35);
					  }
						
					}
					else if(i==5 ) {
						if( array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage36=new JLabel(Temp[Temp.length-1]);
						massage36.setOpaque(true);
						massage36.setBackground(Color.WHITE);
						massage36.setBounds(15, 155, 550, 25);
						panel_4.add(massage36);}
						else {
							massage36 = new JLabel("");
							massage36.setOpaque(true);
							massage36.setBackground(Color.WHITE);
							massage36.setBounds(15, 155, 550, 25);
							panel_4.add(massage36);
						}
					}
					else if(i==6) {
						if( array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage37=new JLabel(Temp[Temp.length-1]);
						massage37.setOpaque(true);
						massage37.setBackground(Color.WHITE);
						massage37.setBounds(15, 183, 550, 25);
						panel_4.add(massage37);}
						else {
							massage37 = new JLabel("");
							massage37.setOpaque(true);
							massage37.setBackground(Color.WHITE);
							massage37.setBounds(15, 183, 550, 25);
							panel_4.add(massage37);
						}
					}
					else if(i==7) {
						if (array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage38=new JLabel(Temp[Temp.length-1]);
						massage38.setOpaque(true);
						massage38.setBackground(Color.WHITE);
						massage38.setBounds(15, 211, 550, 25);
						panel_4.add(massage38);}
						else {
							massage38 = new JLabel("");
							massage38.setOpaque(true);
							massage38.setBackground(Color.WHITE);
							massage38.setBounds(15, 211, 550, 25);
							panel_4.add(massage38);
						}
					}
					else if(i==8 ) {
						if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage39=new JLabel(Temp[Temp.length-1]);
						massage39.setOpaque(true);
						massage39.setBackground(Color.WHITE);
						massage39.setBounds(15, 239, 550, 25);
						panel_4.add(massage39);}
						else {
							massage39 = new JLabel("");
							massage39.setOpaque(true);
							massage39.setBackground(Color.WHITE);
							massage39.setBounds(15, 239, 550, 25);
							panel_4.add(massage39);
						}
					}
					else if(i==9 ) {
							if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage40=new JLabel(Temp[Temp.length-1]);
						massage40.setOpaque(true);
						massage40.setBackground(Color.WHITE);
						massage40.setBounds(15, 267, 550, 25);
						panel_4.add(massage40);}
							else {
								massage40 = new JLabel("");
								massage40.setOpaque(true);
								massage40.setBackground(Color.WHITE);
								massage40.setBounds(15, 267, 550, 25);
								panel_4.add(massage40);
							}
					}
				}
				
				
				String array5[]=new String [10];
				for(int i =40;i<array5.length+40;i++) {
					if(i<s.size()) {
				array5[i%40]=(String)s.get(i);}
					else {array5[i%40]=null;}
				}
				for(int i =0;i<array5.length;i++) {
					if(i==0 ) {
						if( array5[i]!=null) {
					    String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage41=new JLabel(Temp[Temp.length-1]);
						massage41.setOpaque(true);
						massage41.setBackground(Color.WHITE);
						massage41.setBounds(15, 15, 550, 25);
						panel_5.add(massage41);}
						else {
							massage41 = new JLabel("");
							massage41.setOpaque(true);
							massage41.setBackground(Color.WHITE);
							massage41.setBounds(15, 15, 550, 25);
							panel_5.add(massage41);
						}
						
					}
					else if(i==1) {
						if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage42=new JLabel(Temp[Temp.length-1]);
						massage42.setOpaque(true);
						massage42.setBackground(Color.WHITE);
						massage42.setBounds(15, 43, 550, 25);
						panel_5.add(massage42);
						}else {
							massage42 = new JLabel("");
							massage42.setOpaque(true);
							massage42.setBackground(Color.WHITE);
							massage42.setBounds(15, 43, 550, 25);
							panel_5.add(massage42);
						}
					}
					else if(i==2) {
						if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage43=new JLabel(Temp[Temp.length-1]);
						massage43.setOpaque(true);
						massage43.setBackground(Color.WHITE);
						massage43.setBounds(15, 71, 550, 25);
						panel_5.add(massage43);}
						else {
							massage43 = new JLabel("");
							massage43.setOpaque(true);
							massage43.setBackground(Color.WHITE);
							massage43.setBounds(15, 71, 550, 25);
							panel_5.add(massage43);
						}
					}
					else if(i==3 ) {
						if (array5[i]!=null) {
					    String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage44=new JLabel(Temp[Temp.length-1]);
						massage44.setOpaque(true);
						massage44.setBackground(Color.WHITE);
						massage44.setBounds(15, 99, 550, 25);
						panel_5.add(massage44);}
						else {
							massage44 = new JLabel("");
							massage44.setOpaque(true);
							massage44.setBackground(Color.WHITE);
							massage44.setBounds(15, 99, 550, 25);
							panel_5.add(massage44);
						}
					}
					else if(i==4 ) {
					  if( array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage45=new JLabel(Temp[Temp.length-1]);
						massage45.setOpaque(true);
						massage45.setBackground(Color.WHITE);
						massage45.setBounds(15, 127, 550, 25);
						panel_5.add(massage45);}
					  else {
						    massage45 = new JLabel("");
							massage45.setOpaque(true);
							massage45.setBackground(Color.WHITE);
							massage45.setBounds(15, 127, 550, 25);
							panel_5.add(massage45);
					  }
						
					}
					else if(i==5 ) {
						if( array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage46=new JLabel(Temp[Temp.length-1]);
						massage46.setOpaque(true);
						massage46.setBackground(Color.WHITE);
						massage46.setBounds(15, 155, 550, 25);
						panel_5.add(massage46);}
						else {
							massage46 = new JLabel("");
							massage46.setOpaque(true);
							massage46.setBackground(Color.WHITE);
							massage46.setBounds(15, 155, 550, 25);
							panel_5.add(massage46);
						}
					}
					else if(i==6) {
						if( array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage47=new JLabel(Temp[Temp.length-1]);
						massage47.setOpaque(true);
						massage47.setBackground(Color.WHITE);
						massage47.setBounds(15, 183, 550, 25);
						panel_5.add(massage47);}
						else {
							massage47 = new JLabel("");
							massage47.setOpaque(true);
							massage47.setBackground(Color.WHITE);
							massage47.setBounds(15, 183, 550, 25);
							panel_5.add(massage47);
						}
					}
					else if(i==7) {
						if (array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage48=new JLabel(Temp[Temp.length-1]);
						massage48.setOpaque(true);
						massage48.setBackground(Color.WHITE);
						massage48.setBounds(15, 211, 550, 25);
						panel_5.add(massage48);}
						else {
							massage48 = new JLabel("");
							massage48.setOpaque(true);
							massage48.setBackground(Color.WHITE);
							massage48.setBounds(15, 211, 550, 25);
							panel_5.add(massage48);
						}
					}
					else if(i==8 ) {
						if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage49=new JLabel(Temp[Temp.length-1]);
						massage49.setOpaque(true);
						massage49.setBackground(Color.WHITE);
						massage49.setBounds(15, 239, 550, 25);
						panel_5.add(massage49);}
						else {
							massage49 = new JLabel("");
							massage49.setOpaque(true);
							massage49.setBackground(Color.WHITE);
							massage49.setBounds(15, 239, 550, 25);
							panel_5.add(massage49);
						}
					}
					else if(i==9 ) {
							if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage50=new JLabel(Temp[Temp.length-1]);
						massage50.setOpaque(true);
						massage50.setBackground(Color.WHITE);
						massage50.setBounds(15, 267, 550, 25);
						panel_5.add(massage50);}
							else {
								massage50 = new JLabel("");
								massage50.setOpaque(true);
								massage50.setBackground(Color.WHITE);
								massage50.setBounds(15, 267, 550, 25);
								panel_5.add(massage50);
							}
					}
				}
				
				
				
				JLabel lblPage = new JLabel("Page");
				lblPage.setOpaque(true);
				lblPage.setHorizontalAlignment(SwingConstants.CENTER);
				lblPage.setForeground(Color.YELLOW);
				lblPage.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				lblPage.setBackground(Color.RED);
				lblPage.setBounds(95, 228, 149, 22);
				contentPane.add(lblPage);
				
				r1 = new JRadioButton("1");
				r1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(r1.isSelected()) {
						r2.setSelected(false);
						r3.setSelected(false);
						r4.setSelected(false);
						r5.setSelected(false);
						switchpanel(panel_1);
						}
					}
				});
				r1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r1.setBounds(279, 226, 51, 25);
				contentPane.add(r1);
				
				r2 = new JRadioButton("2");
				r2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r2.isSelected()) {
							r1.setSelected(false);
							r3.setSelected(false);
							r4.setSelected(false);
							r5.setSelected(false);
							switchpanel(panel_2);
							}
					}
				});
				r2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r2.setBounds(358, 226, 51, 25);
				contentPane.add(r2);
				
				r3 = new JRadioButton("3");
				r3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r3.isSelected()) {
							r2.setSelected(false);
							r1.setSelected(false);
							r4.setSelected(false);
							r5.setSelected(false);
							switchpanel(panel_3);
							}
					}
				});
				r3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r3.setBounds(430, 226, 51, 25);
				contentPane.add(r3);
				
				r4 = new JRadioButton("4");
				r4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r4.isSelected()) {
							r2.setSelected(false);
							r3.setSelected(false);
							r1.setSelected(false);
							r5.setSelected(false);
							switchpanel(panel_4);
							}
					}
				});
				r4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r4.setBounds(501, 226, 51, 25);
				contentPane.add(r4);
				
				r5 = new JRadioButton("5");
				r5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r5.isSelected()) {
							r2.setSelected(false);
							r3.setSelected(false);
							r4.setSelected(false);
							r1.setSelected(false);
							switchpanel(panel_5);
							}
					}
				});
				r5.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r5.setBounds(576, 226, 51, 25);
				contentPane.add(r5);
				
				
				
				JButton button = new JButton("view");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage1.getText()!="") {
							watch w = new watch(massage1.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button.setBounds(577, 15, 85, 25);
				panel_1.add(button);
				
				JButton button_1 = new JButton("view");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage2.getText()!="") {
							watch w = new watch(massage2.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_1.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_1.setBounds(577, 43, 85, 25);
				panel_1.add(button_1);
				
				JButton button_2 = new JButton("view");
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage3.getText()!="") {
							watch w = new watch(massage3.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_2.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_2.setBounds(577, 71, 85, 25);
				panel_1.add(button_2);
				
				JButton button_3 = new JButton("view");
				button_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage4.getText()!="") {
							watch w = new watch(massage4.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_3.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_3.setBounds(577, 99, 85, 25);
				panel_1.add(button_3);
				
				JButton button_4 = new JButton("view");
				button_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage5.getText()!="") {
							watch w = new watch(massage5.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_4.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_4.setBounds(577, 127, 85, 25);
				panel_1.add(button_4);
				
				JButton button_5 = new JButton("view");
				button_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage6.getText()!="") {
							watch w = new watch(massage6.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_5.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_5.setBounds(577, 155, 85, 25);
				panel_1.add(button_5);
				
				JButton button_6 = new JButton("view");
				button_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage7.getText()!="") {
							watch w = new watch(massage7.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_6.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_6.setBounds(577, 183, 85, 25);
				panel_1.add(button_6);
				
				JButton button_7 = new JButton("view");
				button_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage8.getText()!="") {
							watch w = new watch(massage8.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_7.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_7.setBounds(577, 211, 85, 25);
				panel_1.add(button_7);
				
				JButton button_8 = new JButton("view");
				button_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage9.getText()!="") {
							watch w = new watch(massage9.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_8.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_8.setBounds(577, 239, 85, 25);
				panel_1.add(button_8);
				
				JButton button_9 = new JButton("view");
				button_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage10.getText()!="") {
							watch w = new watch(massage10.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_9.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_9.setBounds(577, 267, 85, 25);
				panel_1.add(button_9);
				
				
				JButton button_10 = new JButton("view");
				button_10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage11.getText()!="") {
							watch w = new watch(massage11.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_10.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_10.setBounds(577, 15, 85, 25);
				panel_2.add(button_10);
				
				JButton button_11 = new JButton("view");
				button_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage12.getText()!="") {
							watch w = new watch(massage12.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_11.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_11.setBounds(577, 43, 85, 25);
				panel_2.add(button_11);
				
				JButton button_12 = new JButton("view");
				button_12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage13.getText()!="") {
							watch w = new watch(massage13.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_12.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_12.setBounds(577, 71, 85, 25);
				panel_2.add(button_12);
				
				JButton button_13 = new JButton("view");
				button_13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage14.getText()!="") {
							watch w = new watch(massage14.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_13.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_13.setBounds(577, 99, 85, 25);
				panel_2.add(button_13);
				
				JButton button_14 = new JButton("view");
				button_14.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage15.getText()!="") {
							watch w = new watch(massage15.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_14.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_14.setBounds(577, 127, 85, 25);
				panel_2.add(button_14);
				
				JButton button_15 = new JButton("view");
				button_15.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage16.getText()!="") {
							watch w = new watch(massage16.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_15.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_15.setBounds(577, 155, 85, 25);
				panel_2.add(button_15);
				
				JButton button_16 = new JButton("view");
				button_16.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage17.getText()!="") {
							watch w = new watch(massage17.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_16.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_16.setBounds(577, 183, 85, 25);
				panel_2.add(button_16);
				
				JButton button_17 = new JButton("view");
				button_17.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage18.getText()!="") {
							watch w = new watch(massage18.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_17.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_17.setBounds(577, 211, 85, 25);
				panel_2.add(button_17);
				
				JButton button_18 = new JButton("view");
				button_18.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage19.getText()!="") {
							watch w = new watch(massage19.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_18.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_18.setBounds(577, 239, 85, 25);
				panel_2.add(button_18);
				
				JButton button_19 = new JButton("view");
				button_19.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage20.getText()!="") {
							watch w = new watch(massage20.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_19.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_19.setBounds(577, 267, 85, 25);
				panel_2.add(button_19);
				
				
				
				JButton button_20 = new JButton("view");
				button_20.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage21.getText()!="") {
							watch w = new watch(massage21.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_20.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_20.setBounds(577, 15, 85, 25);
				panel_3.add(button_20);
				
				JButton button_21 = new JButton("view");
				button_21.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage22.getText()!="") {
							watch w = new watch(massage22.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_21.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_21.setBounds(577, 43, 85, 25);
				panel_3.add(button_21);
				
				JButton button_22 = new JButton("view");
				button_22.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage23.getText()!="") {
							watch w = new watch(massage23.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_22.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_22.setBounds(577, 71, 85, 25);
				panel_3.add(button_22);
				
				JButton button_23 = new JButton("view");
				button_23.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage24.getText()!="") {
							watch w = new watch(massage24.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_23.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_23.setBounds(577, 99, 85, 25);
				panel_3.add(button_23);
				
				JButton button_24 = new JButton("view");
				button_24.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage25.getText()!="") {
							watch w = new watch(massage25.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_24.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_24.setBounds(577, 127, 85, 25);
				panel_3.add(button_24);
				
				JButton button_25 = new JButton("view");
				button_25.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage26.getText()!="") {
							watch w = new watch(massage26.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_25.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_25.setBounds(577, 155, 85, 25);
				panel_3.add(button_25);
				
				JButton button_26 = new JButton("view");
				button_26.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage27.getText()!="") {
							watch w = new watch(massage27.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_26.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_26.setBounds(577, 183, 85, 25);
				panel_3.add(button_26);
				
				JButton button_27 = new JButton("view");
				button_27.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage28.getText()!="") {
							watch w = new watch(massage28.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_27.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_27.setBounds(577, 211, 85, 25);
				panel_3.add(button_27);
				
				JButton button_28 = new JButton("view");
				button_28.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage29.getText()!="") {
							watch w = new watch(massage29.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_28.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_28.setBounds(577, 239, 85, 25);
				panel_3.add(button_28);
				
				JButton button_29 = new JButton("view");
				button_29.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage30.getText()!="") {
							watch w = new watch(massage30.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_29.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_29.setBounds(577, 267, 85, 25);
				panel_3.add(button_29);
				
				
				
				JButton button_30 = new JButton("view");
				button_30.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage31.getText()!="") {
							watch w = new watch(massage31.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_30.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_30.setBounds(577, 15, 85, 25);
				panel_4.add(button_30);
				
				JButton button_31 = new JButton("view");
				button_31.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage32.getText()!="") {
							watch w = new watch(massage32.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_31.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_31.setBounds(577, 43, 85, 25);
				panel_4.add(button_31);
				
				JButton button_32 = new JButton("view");
				button_32.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage33.getText()!="") {
							watch w = new watch(massage33.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_32.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_32.setBounds(577, 71, 85, 25);
				panel_4.add(button_32);
				
				JButton button_33 = new JButton("view");
				button_33.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage34.getText()!="") {
							watch w = new watch(massage34.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_33.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_33.setBounds(577, 99, 85, 25);
				panel_4.add(button_33);
				
				JButton button_34 = new JButton("view");
				button_34.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage35.getText()!="") {
							watch w = new watch(massage35.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_34.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_34.setBounds(577, 127, 85, 25);
				panel_4.add(button_34);
				
				JButton button_35 = new JButton("view");
				button_35.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage36.getText()!="") {
							watch w = new watch(massage36.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_35.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_35.setBounds(577, 155, 85, 25);
				panel_4.add(button_35);
				
				JButton button_36 = new JButton("view");
				button_36.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage37.getText()!="") {
							watch w = new watch(massage37.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_36.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_36.setBounds(577, 183, 85, 25);
				panel_4.add(button_36);
				
				JButton button_37 = new JButton("view");
				button_37.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage38.getText()!="") {
							watch w = new watch(massage38.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_37.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_37.setBounds(577, 211, 85, 25);
				panel_4.add(button_37);
				
				JButton button_38 = new JButton("view");
				button_38.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage39.getText()!="") {
							watch w = new watch(massage39.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_38.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_38.setBounds(577, 239, 85, 25);
				panel_4.add(button_38);
				
				JButton button_39 = new JButton("view");
				button_39.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage40.getText()!="") {
							watch w = new watch(massage40.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_39.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_39.setBounds(577, 267, 85, 25);
				panel_4.add(button_39);
				
				
				
				JButton button_40 = new JButton("view");
				button_40.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage41.getText()!="") {
							watch w = new watch(massage41.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_40.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_40.setBounds(577, 15, 85, 25);
				panel_5.add(button_40);
				
				JButton button_41 = new JButton("view");
				button_41.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage42.getText()!="") {
							watch w = new watch(massage42.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_41.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_41.setBounds(577, 43, 85, 25);
				panel_5.add(button_41);
				
				JButton button_42 = new JButton("view");
				button_42.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage43.getText()!="") {
							watch w = new watch(massage43.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_42.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_42.setBounds(577, 71, 85, 25);
				panel_5.add(button_42);
				
				JButton button_43 = new JButton("view");
				button_43.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage44.getText()!="") {
							watch w = new watch(massage44.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_43.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_43.setBounds(577, 99, 85, 25);
				panel_5.add(button_43);
				
				JButton button_44 = new JButton("view");
				button_44.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage45.getText()!="") {
							watch w = new watch(massage45.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_44.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_44.setBounds(577, 127, 85, 25);
				panel_5.add(button_44);
				
				JButton button_45 = new JButton("view");
				button_45.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage46.getText()!="") {
							watch w = new watch(massage46.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_45.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_45.setBounds(577, 155, 85, 25);
				panel_5.add(button_45);
				
				JButton button_46 = new JButton("view");
				button_46.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage47.getText()!="") {
							watch w = new watch(massage47.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_46.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_46.setBounds(577, 183, 85, 25);
				panel_5.add(button_46);
				
				JButton button_47 = new JButton("view");
				button_47.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage48.getText()!="") {
							watch w = new watch(massage48.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_47.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_47.setBounds(577, 211, 85, 25);
				panel_5.add(button_47);
				
				JButton button_48 = new JButton("view");
				button_48.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage49.getText()!="") {
							watch w = new watch(massage49.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_48.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_48.setBounds(577, 239, 85, 25);
				panel_5.add(button_48);
				
				JButton button_49 = new JButton("view");
				button_49.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage50.getText()!="") {
							watch w = new watch(massage50.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_49.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_49.setBounds(577, 267, 85, 25);
				panel_5.add(button_49);
				
				JButton btnNewButton_1 = new JButton("Exit");
				btnNewButton_1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnNewButton_1.setForeground(Color.DARK_GRAY);
				btnNewButton_1.setBackground(Color.CYAN);
				btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 25));
				btnNewButton_1.setBounds(35, 602, 97, 25);
				contentPane.add(btnNewButton_1);
			}
			public void switchpanel( JPanel panel) {
				panellll.removeAll();
				panellll.add(panel);
				panellll.repaint();
				panellll.revalidate();
			}
		}

		public class watch extends JFrame {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JPanel contentPane;
		  
			

			/**
			 * Create the frame.
			 */
			public watch(String name,String folder) {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 700, 599);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(Color.DARK_GRAY);
				panel.setBounds(0, 0, 682, 552);
				contentPane.add(panel);
				panel.setLayout(null);
				
				Mail m = a.LoadMail(a.GetUser(), name,folder);
				JLabel lblNewLabel = new JLabel("Body");
				lblNewLabel.setBackground(Color.CYAN);
				lblNewLabel.setForeground(Color.BLUE);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setFont(new Font("Sitka Small", Font.BOLD, 30));
				lblNewLabel.setOpaque(true);
				lblNewLabel.setBounds(260, 13, 135, 35);
				panel.add(lblNewLabel);
				
				JTextArea textArea = new JTextArea();
				textArea.setFont(new Font("Mongolian Baiti", Font.PLAIN, 18));
				textArea.setBounds(12, 61, 647, 258);
				//reading the body
				FileReader f = null;
				try {
					f = new FileReader("E:\\Users\\"+a.GetUser()+"\\"+folder+"\\"+name+"\\body.txt");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
				}
				StringBuilder body=new StringBuilder();
				BufferedReader Reader = new BufferedReader(f);
				/********************/
				
			       while (true) {
						try {
							String line = Reader.readLine();
							if(line==null) {
								Reader.close();
								break;}
							    body.append(line);
							    body.append("\n");
							}
						catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Unfortunately  the opreation can't done");
							}}
			    /************************/
			    textArea.setText(body.toString());
				panel.add(textArea);
				
				JLabel lblAttachments = new JLabel("Attachments");
				lblAttachments.setOpaque(true);
				lblAttachments.setHorizontalAlignment(SwingConstants.CENTER);
				lblAttachments.setForeground(Color.BLUE);
				lblAttachments.setFont(new Font("Sitka Small", Font.BOLD, 25));
				lblAttachments.setBackground(Color.CYAN);
				lblAttachments.setBounds(249, 332, 178, 35);
				panel.add(lblAttachments);
				
				JTextArea textArea_1 = new JTextArea();
				textArea_1.setFont(new Font("Mongolian Baiti", Font.PLAIN, 20));
				textArea_1.setBounds(12, 380, 647, 121);
				for(int i =0;i<m.getAttaclinks().length;i++) {
					textArea_1.setText(textArea_1.getText()+m.getAttaclinks()[i]+"\n");
				}
				panel.add(textArea_1);
				
				JButton back = new JButton("Back");
				back.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				back.setFont(new Font("Snap ITC", Font.PLAIN, 17));
				back.setBounds(546, 514, 97, 25);
				panel.add(back);
			}
		}
		
		public class loadDraft extends JFrame {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JPanel contentPane;
		    private JLabel massage1,massage2,massage3,massage4,massage5;
		    private JLabel massage6,massage7,massage8,massage9,massage10;
		    private JLabel massage11,massage12,massage13,massage14,massage15;
		    private JLabel massage16,massage17,massage18,massage19,massage20;
		    private JLabel massage21,massage22,massage23,massage24,massage25;
		    private JLabel massage26,massage27,massage28,massage29,massage30;
		    private JLabel massage31,massage32,massage33,massage34,massage35;
		    private JLabel massage36,massage37,massage38,massage39,massage40;
		    private JLabel massage41,massage42,massage43,massage44,massage45;
		    private JLabel massage46,massage47,massage48,massage49,massage50;
			private JTextField textField;
			private JRadioButton Sender,Receiver,Subject,piriority;
			private JRadioButton r1,r2,r3,r4,r5;
			JPanel panellll;
			//static App a = new App();
			private JRadioButton d1,d2,d3,d4,d5,d6,d7,d8,d9,d10;
			private JRadioButton d11,d12,d13,d14,d15,d16,d17,d18,d19,d20;
			private JRadioButton d21,d22,d23,d24,d25,d26,d27,d28,d29,d30;
			private JRadioButton d31,d32,d33,d34,d35,d36,d37,d38,d39,d40;
			private JRadioButton d41,d42,d43,d44,d45,d46,d47,d48,d49,d50;
			private JRadioButton date,sub2,reciver2,sender2;
			
			/**
			 * Create the frame.
			 */
			public loadDraft(Singly_Linked_list s) {
				String pervious=(String)s.get(s.size()-1);
				String prev[]=pervious.split("    ");
				String prefolder=prev[0];
				String presorting=prev[1];
				String prefilter=prev[2];
				String prefilter2=prev[3];
				s.remove(s.size()-1);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 800, 700);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setForeground(Color.WHITE);
				panel.setBackground(Color.GRAY);
				panel.setBounds(0, 0, 782, 170);
				contentPane.add(panel);
				
				
				
				JLabel lblSort = new JLabel("Sort");
				lblSort.setOpaque(true);
				lblSort.setHorizontalAlignment(SwingConstants.CENTER);
				lblSort.setForeground(new Color(72, 61, 139));
				lblSort.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				lblSort.setBackground(new Color(245, 255, 250));
				lblSort.setBounds(12, 25, 149, 22);
				panel.add(lblSort);
				
				 Sender = new JRadioButton("Sender");
				 Sender.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(Sender.isSelected()) {
				 			Receiver.setSelected(false);
				 			Subject.setSelected(false);
				 			piriority.setSelected(false);
				 		}
				 	}
				 });
				Sender.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Sender.setBounds(202, 24, 91, 25);
				panel.add(Sender);
				
				 Receiver = new JRadioButton("Receiver\r\n");
				 Receiver.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(Receiver.isSelected()) {
				 			Sender.setSelected(false);
				 			Subject.setSelected(false);
				 			piriority.setSelected(false);
				 		}
				 	}
				 });
				Receiver.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Receiver.setBounds(335, 24, 114, 25);
				panel.add(Receiver);
				
				 Subject = new JRadioButton("Subject");
				 Subject.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(Subject.isSelected()) {
				 			Sender.setSelected(false);
				 			Receiver.setSelected(false);
				 			piriority.setSelected(false);
				 		}
				 	}
				 });
				Subject.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Subject.setBounds(500, 24, 100, 25);
				panel.add(Subject);
				
				 piriority = new JRadioButton("Importance");
				 piriority.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(piriority.isSelected()) {
				 			Sender.setSelected(false);
				 			Receiver.setSelected(false);
				 			Subject.setSelected(false);
				 		}
				 	}
				 });
				piriority.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				piriority.setBounds(630, 24, 133, 25);
				panel.add(piriority);
				
				JLabel lblFilter = new JLabel("Filter");
				lblFilter.setOpaque(true);
				lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
				lblFilter.setForeground(new Color(72, 61, 139));
				lblFilter.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				lblFilter.setBackground(new Color(245, 255, 250));
				lblFilter.setBounds(12, 74, 149, 22);
				panel.add(lblFilter);
				
				textField = new JTextField();
				textField.setFont(new Font("Sitka Small", Font.BOLD, 20));
				textField.setBounds(202, 124, 347, 24);
				panel.add(textField);
				textField.setColumns(10);
				
				//String ffff;
				
				JButton btnNewButton = new JButton("Refresh");
				btnNewButton.setBounds(630, 122, 133, 26);
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean good=true;
						Singly_Linked_list s= new Singly_Linked_list();
						Folder f = new Folder();
						f.SetUser(a.GetUser());
						f.SetFoldername("Draft");
						sort ss= new sort();
						if (Sender.isSelected()) {ss.setSorting("sender");}
						else if (Receiver.isSelected()) {ss.setSorting("receiver");}
						else if (Subject.isSelected()) {ss.setSorting("subject");}
						else if (piriority.isSelected()) {ss.setSorting("priority");}
						else if (!presorting.equals("null")) {ss.setSorting(presorting);}
						filter f1= new filter();
						if(sub2.isSelected()) {f1.Setkindfilter("subject");}
						else if(date.isSelected()) {f1.Setkindfilter("Date");}
						else if(sender2.isSelected()) {f1.Setkindfilter("sender");}
						else if(reciver2.isSelected()) {f1.Setkindfilter("reciver");}
						else {f1.Setkindfilter(prefilter);
						f1.Setnamefilter(prefilter2);}
						if(sub2.isSelected()  || date.isSelected() || sender2.isSelected() || reciver2.isSelected()) {
						if(textField.getText().toString().length()>0) {
						f1.Setnamefilter(textField.getText().toString());}
						else {
							JOptionPane.showMessageDialog(null, "You Should enter String in filter box");
							good=false;
						}
						}
						if(good) {
						s=(Singly_Linked_list)a.setViewingOptions(f, f1, ss);
						StringBuilder prevv=new StringBuilder(f.GetFolderName()+"    ");
						if(ss.getSorting()!=null) {
							prevv.append(ss.getSorting()+"    ");
						}else {
							prevv.append("null    ");
						}
						if(f1.getkindfilter()!=null && !f1.getkindfilter().equals("null") ) {
							prevv.append(f1.getkindfilter()+"    "+f1.getnamefilter());
						}else {
							prevv.append("null    null");
						}
						String previouss=prevv.toString();
						//System.out.println(previouss);
						s.add(previouss);
						loadDraft v=new loadDraft(s);
						v.setVisible(true);
						dispose();}
					}
				});
				btnNewButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 25));
				
				sub2 = new JRadioButton("Subject");
				sub2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(sub2.isSelected()) {
							reciver2.setSelected(false);
							sender2.setSelected(false);
							date.setSelected(false);
						}	
					}
				});
				sub2.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				sub2.setBounds(500, 73, 100, 25);
				panel.add(sub2);
				
				reciver2 = new JRadioButton("Receiver\r\n");
				reciver2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(reciver2.isSelected()) {
							sub2.setSelected(false);
							sender2.setSelected(false);
							date.setSelected(false);
						}	
					}
				});
				reciver2.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				reciver2.setBounds(335, 73, 114, 25);
				panel.add(reciver2);
				
				sender2 = new JRadioButton("Sender");
				sender2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(sender2.isSelected()) {
							sub2.setSelected(false);
							reciver2.setSelected(false);
							date.setSelected(false);
						}
					}
				});
				sender2.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				sender2.setBounds(202, 73, 91, 25);
				panel.add(sender2);
				
				date = new JRadioButton("Date");
				date.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(date.isSelected()) {
							sub2.setSelected(false);
							reciver2.setSelected(false);
							sender2.setSelected(false);
						}
					}
				});
				date.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				date.setBounds(630, 74, 100, 25);
				panel.add(date);
				
				
				panellll = new JPanel();
				panellll.setBounds(50, 270, 670, 309);
				contentPane.add(panellll);
				panellll.setLayout(new CardLayout(0, 0));
				
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(Color.BLUE);
				panellll.add(panel_1, "name_344929928447800");
				
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBackground(Color.BLUE);
				panellll.add(panel_2, "name_344962931110400");
				
				JPanel panel_3 = new JPanel();
				panel_3.setLayout(null);
				panel_3.setBackground(Color.BLUE);
				panellll.add(panel_3, "name_348895440977600");
				
				JPanel panel_4 = new JPanel();
				panel_4.setLayout(null);
				panel_4.setBackground(Color.BLUE);
				panellll.add(panel_4, "name_348905531528400");
				
				JPanel panel_5 = new JPanel();
				panel_5.setLayout(null);
				panel_5.setBackground(Color.BLUE);
				panellll.add(panel_5, "name_348954193306500");
				

				JLabel lblPage = new JLabel("Page");
				lblPage.setOpaque(true);
				lblPage.setHorizontalAlignment(SwingConstants.CENTER);
				lblPage.setForeground(Color.YELLOW);
				lblPage.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				lblPage.setBackground(Color.RED);
				lblPage.setBounds(95, 206, 149, 22);
				contentPane.add(lblPage);
				
				r1 = new JRadioButton("1");
				r1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(r1.isSelected()) {
						r2.setSelected(false);
						r3.setSelected(false);
						r4.setSelected(false);
						r5.setSelected(false);
						switchpanel(panel_1);
						}
					}
				});
				r1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r1.setBounds(279, 204, 51, 25);
				contentPane.add(r1);
				
				r2 = new JRadioButton("2");
				r2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r2.isSelected()) {
							r1.setSelected(false);
							r3.setSelected(false);
							r4.setSelected(false);
							r5.setSelected(false);
							switchpanel(panel_2);
							}
					}
				});
				r2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r2.setBounds(358, 204, 51, 25);
				contentPane.add(r2);
				
				r3 = new JRadioButton("3");
				r3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r3.isSelected()) {
							r2.setSelected(false);
							r1.setSelected(false);
							r4.setSelected(false);
							r5.setSelected(false);
							switchpanel(panel_3);
							}
					}
				});
				r3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r3.setBounds(428, 204, 51, 25);
				contentPane.add(r3);
				
				r4 = new JRadioButton("4");
				r4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r4.isSelected()) {
							r2.setSelected(false);
							r3.setSelected(false);
							r1.setSelected(false);
							r5.setSelected(false);
							switchpanel(panel_4);
							}
					}
				});
				r4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r4.setBounds(503, 204, 51, 25);
				contentPane.add(r4);
				
				r5 = new JRadioButton("5");
				r5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r5.isSelected()) {
							r2.setSelected(false);
							r3.setSelected(false);
							r4.setSelected(false);
							r1.setSelected(false);
							switchpanel(panel_5);
							}
					}
				});
				r5.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r5.setBounds(575, 204, 51, 25);
				contentPane.add(r5);
				
				
				String array1[]=new String [10];
				for(int i =0;i<array1.length;i++) {
					if(i<s.size()) {
				array1[i]=(String)s.get(i);}
					else {array1[i]=null;}
				}
				for(int i =0;i<array1.length;i++) {
					if(i==0 ) {
						if( array1[i]!=null) {
					    String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage1=new JLabel(Temp[Temp.length-1]);
						massage1.setOpaque(true);
						massage1.setBackground(Color.WHITE);
						massage1.setBounds(15+38, 15, 550-38, 25);
						panel_1.add(massage1);}
						else {
							massage1 = new JLabel("");
							massage1.setOpaque(true);
							massage1.setBackground(Color.WHITE);
							massage1.setBounds(15+38, 15, 550-38, 25);
							panel_1.add(massage1);
						}
						
					}
					else if(i==1) {
						if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage2=new JLabel(Temp[Temp.length-1]);
						massage2.setOpaque(true);
						massage2.setBackground(Color.WHITE);
						massage2.setBounds(15+38, 43, 550-38, 25);
						panel_1.add(massage2);
						}else {
							massage2 = new JLabel("");
							massage2.setOpaque(true);
							massage2.setBackground(Color.WHITE);
							massage2.setBounds(15+38, 43, 550-38, 25);
							panel_1.add(massage2);
						}
					}
					else if(i==2) {
						if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage3=new JLabel(Temp[Temp.length-1]);
						massage3.setOpaque(true);
						massage3.setBackground(Color.WHITE);
						massage3.setBounds(15+38, 71, 550-38, 25);
						panel_1.add(massage3);}
						else {
							massage3 = new JLabel("");
							massage3.setOpaque(true);
							massage3.setBackground(Color.WHITE);
							massage3.setBounds(15+38, 71, 550-38, 25);
							panel_1.add(massage3);
						}
					}
					else if(i==3 ) {
						if (array1[i]!=null) {
					    String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage4=new JLabel(Temp[Temp.length-1]);
						massage4.setOpaque(true);
						massage4.setBackground(Color.WHITE);
						massage4.setBounds(15+38, 99, 550-38, 25);
						panel_1.add(massage4);}
						else {
							massage4 = new JLabel("");
							massage4.setOpaque(true);
							massage4.setBackground(Color.WHITE);
							massage4.setBounds(15+38, 99, 550-38, 25);
							panel_1.add(massage4);
						}
					}
					else if(i==4 ) {
					  if( array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage5=new JLabel(Temp[Temp.length-1]);
						massage5.setOpaque(true);
						massage5.setBackground(Color.WHITE);
						massage5.setBounds(15+38, 127, 550-38, 25);
						panel_1.add(massage5);}
					  else {
						  massage5 = new JLabel("");
							massage5.setOpaque(true);
							massage5.setBackground(Color.WHITE);
							massage5.setBounds(15+38, 127, 550-38, 25);
							panel_1.add(massage5);
					  }
					  
						
					}
					else if(i==5 ) {
						if( array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage6=new JLabel(Temp[Temp.length-1]);
						massage6.setOpaque(true);
						massage6.setBackground(Color.WHITE);
						massage6.setBounds(15+38, 155, 550-38, 25);
						panel_1.add(massage6);}
						else {
							massage6 = new JLabel("");
							massage6.setOpaque(true);
							massage6.setBackground(Color.WHITE);
							massage6.setBounds(15+38, 155, 550-38, 25);
							panel_1.add(massage6);
						}
					}
					else if(i==6) {
						if( array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage7=new JLabel(Temp[Temp.length-1]);
						massage7.setOpaque(true);
						massage7.setBackground(Color.WHITE);
						massage7.setBounds(15+38, 183, 550-38, 25);
						panel_1.add(massage7);}
						else {
							massage7 = new JLabel("");
							massage7.setOpaque(true);
							massage7.setBackground(Color.WHITE);
							massage7.setBounds(15+38, 183, 550-38, 25);
							panel_1.add(massage7);
						}
					}
					else if(i==7) {
						if (array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage8=new JLabel(Temp[Temp.length-1]);
						massage8.setOpaque(true);
						massage8.setBackground(Color.WHITE);
						massage8.setBounds(15+38, 211, 550-38, 25);
						panel_1.add(massage8);}
						else {
							massage8 = new JLabel("");
							massage8.setOpaque(true);
							massage8.setBackground(Color.WHITE);
							massage8.setBounds(15+38, 211, 550-38, 25);
							panel_1.add(massage8);
						}
					}
					else if(i==8 ) {
						if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage9=new JLabel(Temp[Temp.length-1]);
						massage9.setOpaque(true);
						massage9.setBackground(Color.WHITE);
						massage9.setBounds(15+38, 239, 550-38, 25);
						panel_1.add(massage9);}
						else {
							massage9 = new JLabel("");
							massage9.setOpaque(true);
							massage9.setBackground(Color.WHITE);
							massage9.setBounds(15+38, 239, 550-38, 25);
							panel_1.add(massage9);
						}
					}
					else if(i==9 ) {
							if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage10=new JLabel(Temp[Temp.length-1]);
						massage10.setOpaque(true);
						massage10.setBackground(Color.WHITE);
						massage10.setBounds(15+38, 267, 550-38, 25);
						panel_1.add(massage10);}
							else {
								massage10 = new JLabel("");
								massage10.setOpaque(true);
								massage10.setBackground(Color.WHITE);
								massage10.setBounds(15+38, 267, 550-38, 25);
								panel_1.add(massage10);
							}
					}
				}
				
				
				String array2[]=new String [10];
				for(int i =10;i<array2.length+10;i++) {
					if(i<s.size()) {
				array2[i%10]=(String)s.get(i);}
					else {array2[i%10]=null;}
				}
				for(int i =0;i<array2.length;i++) {
					if(i==0 ) {
						if( array2[i]!=null) {
					    String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage11=new JLabel(Temp[Temp.length-1]);
						massage11.setOpaque(true);
						massage11.setBackground(Color.WHITE);
						massage11.setBounds(15+38, 15, 550-38, 25);
						panel_2.add(massage11);}
						else {
							massage11 = new JLabel("");
							massage11.setOpaque(true);
							massage11.setBackground(Color.WHITE);
							massage11.setBounds(15+38, 15, 550-38, 25);
							panel_2.add(massage11);
						}
						
					}
					else if(i==1) {
						if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage12=new JLabel(Temp[Temp.length-1]);
						massage12.setOpaque(true);
						massage12.setBackground(Color.WHITE);
						massage12.setBounds(15+38, 43, 550-38, 25);
						panel_2.add(massage12);
						}else {
							massage12 = new JLabel("");
							massage12.setOpaque(true);
							massage12.setBackground(Color.WHITE);
							massage12.setBounds(15+38, 43, 550-38, 25);
							panel_2.add(massage12);
						}
					}
					else if(i==2) {
						if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage13=new JLabel(Temp[Temp.length-1]);
						massage13.setOpaque(true);
						massage13.setBackground(Color.WHITE);
						massage13.setBounds(15+38, 71, 550-38, 25);
						panel_2.add(massage13);}
						else {
							massage13 = new JLabel("");
							massage13.setOpaque(true);
							massage13.setBackground(Color.WHITE);
							massage13.setBounds(15+38, 71, 550-38, 25);
							panel_2.add(massage13);
						}
					}
					else if(i==3 ) {
						if (array2[i]!=null) {
					    String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage14=new JLabel(Temp[Temp.length-1]);
						massage14.setOpaque(true);
						massage14.setBackground(Color.WHITE);
						massage14.setBounds(15+38, 99, 550-38, 25);
						panel_2.add(massage14);}
						else {
							massage14 = new JLabel("");
							massage14.setOpaque(true);
							massage14.setBackground(Color.WHITE);
							massage14.setBounds(15+38, 99, 550-38, 25);
							panel_2.add(massage14);
						}
					}
					else if(i==4 ) {
					  if( array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage15=new JLabel(Temp[Temp.length-1]);
						massage15.setOpaque(true);
						massage15.setBackground(Color.WHITE);
						massage15.setBounds(15+38, 127, 550-38, 25);
						panel_2.add(massage15);}
					  else {
						  massage15 = new JLabel("");
							massage15.setOpaque(true);
							massage15.setBackground(Color.WHITE);
							massage15.setBounds(15+38, 127, 550-38, 25);
							panel_2.add(massage15);
					  }
						
					}
					else if(i==5 ) {
						if( array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage16=new JLabel(Temp[Temp.length-1]);
						massage16.setOpaque(true);
						massage16.setBackground(Color.WHITE);
						massage16.setBounds(15+38, 155, 550-38, 25);
						panel_2.add(massage16);}
						else {
							massage16 = new JLabel("");
							massage16.setOpaque(true);
							massage16.setBackground(Color.WHITE);
							massage16.setBounds(15+38, 155, 550-38, 25);
							panel_2.add(massage16);
						}
					}
					else if(i==6) {
						if( array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage17=new JLabel(Temp[Temp.length-1]);
						massage17.setOpaque(true);
						massage17.setBackground(Color.WHITE);
						massage17.setBounds(15+38, 183, 550-38, 25);
						panel_2.add(massage17);}
						else {
							massage17 = new JLabel("");
							massage17.setOpaque(true);
							massage17.setBackground(Color.WHITE);
							massage17.setBounds(15+38, 183, 550-38, 25);
							panel_2.add(massage17);
						}
					}
					else if(i==7) {
						if (array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage18=new JLabel(Temp[Temp.length-1]);
						massage18.setOpaque(true);
						massage18.setBackground(Color.WHITE);
						massage18.setBounds(15+38, 211, 550-38, 25);
						panel_2.add(massage18);}
						else {
							massage18 = new JLabel("");
							massage18.setOpaque(true);
							massage18.setBackground(Color.WHITE);
							massage18.setBounds(15+38, 211, 550-38, 25);
							panel_2.add(massage18);
						}
					}
					else if(i==8 ) {
						if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage19=new JLabel(Temp[Temp.length-1]);
						massage19.setOpaque(true);
						massage19.setBackground(Color.WHITE);
						massage19.setBounds(15+38, 239, 550-38, 25);
						panel_2.add(massage19);}
						else {
							massage19 = new JLabel("");
							massage19.setOpaque(true);
							massage19.setBackground(Color.WHITE);
							massage19.setBounds(15+38, 239, 550-38, 25);
							panel_2.add(massage19);
						}
					}
					else if(i==9 ) {
							if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage20=new JLabel(Temp[Temp.length-1]);
						massage20.setOpaque(true);
						massage20.setBackground(Color.WHITE);
						massage20.setBounds(15+38, 267, 550-38, 25);
						panel_2.add(massage20);}
							else {
								massage20 = new JLabel("");
								massage20.setOpaque(true);
								massage20.setBackground(Color.WHITE);
								massage20.setBounds(15+38, 267, 550-38, 25);
								panel_2.add(massage20);
							}
					}
				}
				
				
				
				String array3[]=new String [10];
				for(int i =20;i<array3.length+20;i++) {
					if(i<s.size()) {
				array3[i%20]=(String)s.get(i);}
					else {array3[i%20]=null;}
				}
				for(int i =0;i<array3.length;i++) {
					if(i==0 ) {
						if( array3[i]!=null) {
					    String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage21=new JLabel(Temp[Temp.length-1]);
						massage21.setOpaque(true);
						massage21.setBackground(Color.WHITE);
						massage21.setBounds(15+38, 15, 550-38, 25);
						panel_3.add(massage21);}
						else {
							massage21 = new JLabel("");
							massage21.setOpaque(true);
							massage21.setBackground(Color.WHITE);
							massage21.setBounds(15+38, 15, 550-38, 25);
							panel_3.add(massage21);
						}
						
					}
					else if(i==1) {
						if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage22=new JLabel(Temp[Temp.length-1]);
						massage22.setOpaque(true);
						massage22.setBackground(Color.WHITE);
						massage12.setBounds(15+38, 43, 550-38, 25);
						panel_3.add(massage22);
						}else {
							massage22 = new JLabel("");
							massage22.setOpaque(true);
							massage22.setBackground(Color.WHITE);
							massage22.setBounds(15+38, 43, 550-38, 25);
							panel_3.add(massage22);
						}
					}
					else if(i==2) {
						if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage23=new JLabel(Temp[Temp.length-1]);
						massage23.setOpaque(true);
						massage23.setBackground(Color.WHITE);
						massage13.setBounds(15+38, 71, 550-38, 25);
						panel_3.add(massage23);}
						else {
							massage23 = new JLabel("");
							massage23.setOpaque(true);
							massage23.setBackground(Color.WHITE);
							massage23.setBounds(15+38, 71, 550-38, 25);
							panel_3.add(massage23);
						}
					}
					else if(i==3 ) {
						if (array3[i]!=null) {
					    String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage24=new JLabel(Temp[Temp.length-1]);
						massage24.setOpaque(true);
						massage24.setBackground(Color.WHITE);
						massage14.setBounds(15+38, 99, 550-38, 25);
						panel_3.add(massage24);}
						else {
							massage24 = new JLabel("");
							massage24.setOpaque(true);
							massage24.setBackground(Color.WHITE);
							massage24.setBounds(15+38, 99, 550-38, 25);
							panel_3.add(massage24);
						}
					}
					else if(i==4 ) {
					  if( array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage25=new JLabel(Temp[Temp.length-1]);
						massage25.setOpaque(true);
						massage25.setBackground(Color.WHITE);
						massage25.setBounds(15+38, 127, 550-38, 25);
						panel_3.add(massage25);}
					  else {
						  massage25 = new JLabel("");
							massage25.setOpaque(true);
							massage25.setBackground(Color.WHITE);
							massage25.setBounds(15+38, 127, 550-38, 25);
							panel_3.add(massage25);
					  }
						
					}
					else if(i==5 ) {
						if( array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage26=new JLabel(Temp[Temp.length-1]);
						massage26.setOpaque(true);
						massage26.setBackground(Color.WHITE);
						massage26.setBounds(15+38, 155, 550-38, 25);
						panel_3.add(massage26);}
						else {
							massage26 = new JLabel("");
							massage26.setOpaque(true);
							massage26.setBackground(Color.WHITE);
							massage26.setBounds(15+38, 155, 550-38, 25);
							panel_3.add(massage26);
						}
					}
					else if(i==6) {
						if( array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage27=new JLabel(Temp[Temp.length-1]);
						massage27.setOpaque(true);
						massage27.setBackground(Color.WHITE);
						massage27.setBounds(15+38, 183, 550-38, 25);
						panel_3.add(massage27);}
						else {
							massage27 = new JLabel("");
							massage27.setOpaque(true);
							massage27.setBackground(Color.WHITE);
							massage27.setBounds(15+38, 183, 550-38, 25);
							panel_3.add(massage27);
						}
					}
					else if(i==7) {
						if (array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage28=new JLabel(Temp[Temp.length-1]);
						massage28.setOpaque(true);
						massage28.setBackground(Color.WHITE);
						massage28.setBounds(15+38, 211, 550-38, 25);
						panel_3.add(massage28);}
						else {
							massage28 = new JLabel("");
							massage28.setOpaque(true);
							massage28.setBackground(Color.WHITE);
							massage28.setBounds(15+38, 211, 550-38, 25);
							panel_3.add(massage28);
						}
					}
					else if(i==8 ) {
						if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage29=new JLabel(Temp[Temp.length-1]);
						massage29.setOpaque(true);
						massage29.setBackground(Color.WHITE);
						massage29.setBounds(15+38, 239, 550-38, 25);
						panel_3.add(massage29);}
						else {
							massage29 = new JLabel("");
							massage29.setOpaque(true);
							massage29.setBackground(Color.WHITE);
							massage29.setBounds(15+38, 239, 550-38, 25);
							panel_3.add(massage29);
						}
					}
					else if(i==9 ) {
							if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage30=new JLabel(Temp[Temp.length-1]);
						massage30.setOpaque(true);
						massage30.setBackground(Color.WHITE);
						massage30.setBounds(15+38, 267, 550-38, 25);
						panel_3.add(massage30);}
							else {
								massage30 = new JLabel("");
								massage30.setOpaque(true);
								massage30.setBackground(Color.WHITE);
								massage30.setBounds(15+38, 267, 550-38, 25);
								panel_3.add(massage30);
							}
					}
				}
				
				
				String array4[]=new String [10];
				for(int i =30;i<array4.length+30;i++) {
					if(i<s.size()) {
				array4[i%30]=(String)s.get(i);}
					else {array4[i%30]=null;}
				}
				for(int i =0;i<array4.length;i++) {
					if(i==0 ) {
						if( array4[i]!=null) {
					    String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage31=new JLabel(Temp[Temp.length-1]);
						massage31.setOpaque(true);
						massage31.setBackground(Color.WHITE);
						massage31.setBounds(15+38, 15, 550-38, 25);
						panel_4.add(massage31);}
						else {
							massage31 = new JLabel("");
							massage31.setOpaque(true);
							massage31.setBackground(Color.WHITE);
							massage31.setBounds(15+38, 15, 550-38, 25);
							panel_4.add(massage31);
						}
						
					}
					else if(i==1) {
						if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage32=new JLabel(Temp[Temp.length-1]);
						massage32.setOpaque(true);
						massage32.setBackground(Color.WHITE);
						massage32.setBounds(15+38, 43, 550-38, 25);
						panel_4.add(massage32);
						}else {
							massage32 = new JLabel("");
							massage32.setOpaque(true);
							massage32.setBackground(Color.WHITE);
							massage32.setBounds(15+38, 43, 550-38, 25);
							panel_4.add(massage32);
						}
					}
					else if(i==2) {
						if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage33=new JLabel(Temp[Temp.length-1]);
						massage33.setOpaque(true);
						massage33.setBackground(Color.WHITE);
						massage33.setBounds(15+38, 71, 550-38, 25);
						panel_4.add(massage33);}
						else {
							massage33 = new JLabel("");
							massage33.setOpaque(true);
							massage33.setBackground(Color.WHITE);
							massage33.setBounds(15+38, 71, 550-38, 25);
							panel_4.add(massage33);
						}
					}
					else if(i==3 ) {
						if (array4[i]!=null) {
					    String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage34=new JLabel(Temp[Temp.length-1]);
						massage34.setOpaque(true);
						massage34.setBackground(Color.WHITE);
						massage34.setBounds(15+38, 99, 550-38, 25);
						panel_4.add(massage34);}
						else {
							massage34 = new JLabel("");
							massage34.setOpaque(true);
							massage34.setBackground(Color.WHITE);
							massage34.setBounds(15+38, 99, 550-38, 25);
							panel_4.add(massage34);
						}
					}
					else if(i==4 ) {
					  if( array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage35=new JLabel(Temp[Temp.length-1]);
						massage35.setOpaque(true);
						massage35.setBackground(Color.WHITE);
						massage35.setBounds(15+38, 127, 550-38, 25);
						panel_4.add(massage35);}
					  else {
						  massage35 = new JLabel("");
							massage35.setOpaque(true);
							massage35.setBackground(Color.WHITE);
							massage35.setBounds(15+38, 127, 550-38, 25);
							panel_4.add(massage35);
					  }
						
					}
					else if(i==5 ) {
						if( array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage36=new JLabel(Temp[Temp.length-1]);
						massage36.setOpaque(true);
						massage36.setBackground(Color.WHITE);
						massage36.setBounds(15+38, 155, 550-38, 25);
						panel_4.add(massage36);}
						else {
							massage36 = new JLabel("");
							massage36.setOpaque(true);
							massage36.setBackground(Color.WHITE);
							massage36.setBounds(15+38, 155, 550-38, 25);
							panel_4.add(massage36);
						}
					}
					else if(i==6) {
						if( array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage37=new JLabel(Temp[Temp.length-1]);
						massage37.setOpaque(true);
						massage37.setBackground(Color.WHITE);
						massage37.setBounds(15+38, 183, 550-38, 25);
						panel_4.add(massage37);}
						else {
							massage37 = new JLabel("");
							massage37.setOpaque(true);
							massage37.setBackground(Color.WHITE);
							massage37.setBounds(15+38, 183, 550-38, 25);
							panel_4.add(massage37);
						}
					}
					else if(i==7) {
						if (array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage38=new JLabel(Temp[Temp.length-1]);
						massage38.setOpaque(true);
						massage38.setBackground(Color.WHITE);
						massage38.setBounds(15+38, 211, 550-38, 25);
						panel_4.add(massage38);}
						else {
							massage38 = new JLabel("");
							massage38.setOpaque(true);
							massage38.setBackground(Color.WHITE);
							massage38.setBounds(15+38, 211, 550-38, 25);
							panel_4.add(massage38);
						}
					}
					else if(i==8 ) {
						if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage39=new JLabel(Temp[Temp.length-1]);
						massage39.setOpaque(true);
						massage39.setBackground(Color.WHITE);
						massage39.setBounds(15+38, 239, 550-38, 25);
						panel_4.add(massage39);}
						else {
							massage39 = new JLabel("");
							massage39.setOpaque(true);
							massage39.setBackground(Color.WHITE);
							massage39.setBounds(15+38, 239, 550-38, 25);
							panel_4.add(massage39);
						}
					}
					else if(i==9 ) {
							if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage40=new JLabel(Temp[Temp.length-1]);
						massage40.setOpaque(true);
						massage40.setBackground(Color.WHITE);
						massage40.setBounds(15+38, 267, 550-38, 25);
						panel_4.add(massage40);}
							else {
								massage40 = new JLabel("");
								massage40.setOpaque(true);
								massage40.setBackground(Color.WHITE);
								massage40.setBounds(15+38, 267, 550-38, 25);
								panel_4.add(massage40);
							}
					}
				}
				
				
				String array5[]=new String [10];
				for(int i =40;i<array5.length+40;i++) {
					if(i<s.size()) {
				array5[i%40]=(String)s.get(i);}
					else {array5[i%40]=null;}
				}
				for(int i =0;i<array5.length;i++) {
					if(i==0 ) {
						if( array5[i]!=null) {
					    String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage41=new JLabel(Temp[Temp.length-1]);
						massage41.setOpaque(true);
						massage41.setBackground(Color.WHITE);
						massage41.setBounds(15+38, 15, 550-38, 25);
						panel_5.add(massage41);}
						else {
							massage41 = new JLabel("");
							massage41.setOpaque(true);
							massage41.setBackground(Color.WHITE);
							massage41.setBounds(15+38, 15, 550-38, 25);
							panel_5.add(massage41);
						}
						
					}
					else if(i==1) {
						if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage42=new JLabel(Temp[Temp.length-1]);
						massage42.setOpaque(true);
						massage42.setBackground(Color.WHITE);
						massage42.setBounds(15+38, 43, 550-38, 25);
						panel_5.add(massage42);
						}else {
							massage42 = new JLabel("");
							massage42.setOpaque(true);
							massage42.setBackground(Color.WHITE);
							massage42.setBounds(15+38, 43, 550-38, 25);
							panel_5.add(massage42);
						}
					}
					else if(i==2) {
						if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage43=new JLabel(Temp[Temp.length-1]);
						massage43.setOpaque(true);
						massage43.setBackground(Color.WHITE);
						massage43.setBounds(15+38, 71, 550-38, 25);
						panel_5.add(massage43);}
						else {
							massage43 = new JLabel("");
							massage43.setOpaque(true);
							massage43.setBackground(Color.WHITE);
							massage43.setBounds(15+38, 71, 550-38, 25);
							panel_5.add(massage43);
						}
					}
					else if(i==3 ) {
						if (array5[i]!=null) {
					    String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage44=new JLabel(Temp[Temp.length-1]);
						massage44.setOpaque(true);
						massage44.setBackground(Color.WHITE);
						massage44.setBounds(15+38, 99, 550-38, 25);
						panel_5.add(massage44);}
						else {
							massage44 = new JLabel("");
							massage44.setOpaque(true);
							massage44.setBackground(Color.WHITE);
							massage44.setBounds(15+38, 99, 550-38, 25);
							panel_5.add(massage44);
						}
					}
					else if(i==4 ) {
					  if( array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage45=new JLabel(Temp[Temp.length-1]);
						massage45.setOpaque(true);
						massage45.setBackground(Color.WHITE);
						massage45.setBounds(15+38, 127, 550-38, 25);
						panel_5.add(massage45);}
					  else {
						    massage45 = new JLabel("");
							massage45.setOpaque(true);
							massage45.setBackground(Color.WHITE);
							massage45.setBounds(15+38, 127, 550-38, 25);
							panel_5.add(massage45);
					  }
						
					}
					else if(i==5 ) {
						if( array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage46=new JLabel(Temp[Temp.length-1]);
						massage46.setOpaque(true);
						massage46.setBackground(Color.WHITE);
						massage46.setBounds(15+38, 155, 550-38, 25);
						panel_5.add(massage46);}
						else {
							massage46 = new JLabel("");
							massage46.setOpaque(true);
							massage46.setBackground(Color.WHITE);
							massage46.setBounds(15+38, 155, 550-38, 25);
							panel_5.add(massage46);
						}
					}
					else if(i==6) {
						if( array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage47=new JLabel(Temp[Temp.length-1]);
						massage47.setOpaque(true);
						massage47.setBackground(Color.WHITE);
						massage47.setBounds(15+38, 183, 550-38, 25);
						panel_5.add(massage47);}
						else {
							massage47 = new JLabel("");
							massage47.setOpaque(true);
							massage47.setBackground(Color.WHITE);
							massage47.setBounds(15+38, 183, 550-38, 25);
							panel_5.add(massage47);
						}
					}
					else if(i==7) {
						if (array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage48=new JLabel(Temp[Temp.length-1]);
						massage48.setOpaque(true);
						massage48.setBackground(Color.WHITE);
						massage48.setBounds(15+38, 211, 550-38, 25);
						panel_5.add(massage48);}
						else {
							massage48 = new JLabel("");
							massage48.setOpaque(true);
							massage48.setBackground(Color.WHITE);
							massage48.setBounds(15+38, 211, 550-38, 25);
							panel_5.add(massage48);
						}
					}
					else if(i==8 ) {
						if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage49=new JLabel(Temp[Temp.length-1]);
						massage49.setOpaque(true);
						massage49.setBackground(Color.WHITE);
						massage49.setBounds(15+38, 239, 550-38, 25);
						panel_5.add(massage49);}
						else {
							massage49 = new JLabel("");
							massage49.setOpaque(true);
							massage49.setBackground(Color.WHITE);
							massage49.setBounds(15+38, 239, 550-38, 25);
							panel_5.add(massage49);
						}
					}
					else if(i==9 ) {
							if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage50=new JLabel(Temp[Temp.length-1]);
						massage50.setOpaque(true);
						massage50.setBackground(Color.WHITE);
						massage50.setBounds(15+38, 267, 550-38, 25);
						panel_5.add(massage50);}
							else {
								massage50 = new JLabel("");
								massage50.setOpaque(true);
								massage50.setBackground(Color.WHITE);
								massage50.setBounds(15+38, 267, 550-38, 25);
								panel_5.add(massage50);
							}
					}
				}
				
				
				
				
				
				JButton buttonn = new JButton("view");
				buttonn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage1.getText()!="") {
							watch w = new watch(massage1.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				buttonn.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				buttonn.setBounds(577, 15, 85, 25);
				panel_1.add(buttonn);
				
				JButton button_1 = new JButton("view");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage2.getText()!="") {
							watch w = new watch(massage2.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_1.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_1.setBounds(577, 43, 85, 25);
				panel_1.add(button_1);
				
				JButton button_2 = new JButton("view");
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage3.getText()!="") {
							watch w = new watch(massage3.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_2.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_2.setBounds(577, 71, 85, 25);
				panel_1.add(button_2);
				
				JButton button_3 = new JButton("view");
				button_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage4.getText()!="") {
							watch w = new watch(massage4.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_3.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_3.setBounds(577, 99, 85, 25);
				panel_1.add(button_3);
				
				JButton button_4 = new JButton("view");
				button_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage5.getText()!="") {
							watch w = new watch(massage5.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_4.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_4.setBounds(577, 127, 85, 25);
				panel_1.add(button_4);
				
				JButton button_5 = new JButton("view");
				button_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage6.getText()!="") {
							watch w = new watch(massage6.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_5.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_5.setBounds(577, 155, 85, 25);
				panel_1.add(button_5);
				
				JButton button_6 = new JButton("view");
				button_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage7.getText()!="") {
							watch w = new watch(massage7.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_6.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_6.setBounds(577, 183, 85, 25);
				panel_1.add(button_6);
				
				JButton button_7 = new JButton("view");
				button_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage8.getText()!="") {
							watch w = new watch(massage8.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_7.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_7.setBounds(577, 211, 85, 25);
				panel_1.add(button_7);
				
				JButton button_8 = new JButton("view");
				button_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage9.getText()!="") {
							watch w = new watch(massage9.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_8.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_8.setBounds(577, 239, 85, 25);
				panel_1.add(button_8);
				
				JButton button_9 = new JButton("view");
				button_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage10.getText()!="") {
							watch w = new watch(massage10.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_9.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_9.setBounds(577, 267, 85, 25);
				panel_1.add(button_9);
				
				d1 = new JRadioButton("1");
				d1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d1.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d10.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d1.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				d1.setBounds(8, 15, 43, 25);
				panel_1.add(d1);
				
				d2 = new JRadioButton("2");
				d2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d2.isSelected()) {
			d1.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d10.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d2.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				d2.setBounds(8, 43, 43, 25);
				panel_1.add(d2);
				
				d3 = new JRadioButton("3");
				d3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d3.isSelected()) {
			d2.setSelected(false);   d1.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d10.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d3.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				d3.setBounds(8, 71, 43, 25);
				panel_1.add(d3);
				
				d4 = new JRadioButton("4");
				d4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d4.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d1.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d10.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d4.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				d4.setBounds(8, 99, 43, 25);
				panel_1.add(d4);
				
				d5 = new JRadioButton("5");
				d5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d5.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d1.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d10.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d5.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				d5.setBounds(8, 127, 43, 25);
				panel_1.add(d5);
				
				d6 = new JRadioButton("6");
				d6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d6.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d1.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d10.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d6.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				d6.setBounds(8, 155, 43, 25);
				panel_1.add(d6);
				
				d7 = new JRadioButton("7");
				d7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d7.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d1.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d10.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d7.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				d7.setBounds(8, 183, 43, 25);
				panel_1.add(d7);
				
				d8 = new JRadioButton("8");
				d8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d8.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d1.setSelected(false);  d9.setSelected(false);  d10.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d8.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				d8.setBounds(8, 211, 43, 25);
				panel_1.add(d8);
				
				d9 = new JRadioButton("9");
				d9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d9.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d1.setSelected(false);  d10.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d9.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				d9.setBounds(8, 239, 43, 25);
				panel_1.add(d9);
				
				d10 = new JRadioButton("10");
				d10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d10.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d10.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d10.setBounds(8, 267, 43, 25);
				panel_1.add(d10);
				
				
				JButton button_10 = new JButton("view");
				button_10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage11.getText()!="") {
							watch w = new watch(massage11.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_10.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_10.setBounds(577, 15, 85, 25);
				panel_2.add(button_10);
				
				JButton button_11 = new JButton("view");
				button_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage12.getText()!="") {
							watch w = new watch(massage12.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_11.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_11.setBounds(577, 43, 85, 25);
				panel_2.add(button_11);
				
				JButton button_12 = new JButton("view");
				button_12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage13.getText()!="") {
							watch w = new watch(massage13.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_12.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_12.setBounds(577, 71, 85, 25);
				panel_2.add(button_12);
				
				JButton button_13 = new JButton("view");
				button_13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage14.getText()!="") {
							watch w = new watch(massage14.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_13.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_13.setBounds(577, 99, 85, 25);
				panel_2.add(button_13);
				
				JButton button_14 = new JButton("view");
				button_14.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage15.getText()!="") {
							watch w = new watch(massage15.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_14.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_14.setBounds(577, 127, 85, 25);
				panel_2.add(button_14);
				
				JButton button_15 = new JButton("view");
				button_15.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage16.getText()!="") {
							watch w = new watch(massage16.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_15.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_15.setBounds(577, 155, 85, 25);
				panel_2.add(button_15);
				
				JButton button_16 = new JButton("view");
				button_16.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage17.getText()!="") {
							watch w = new watch(massage17.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_16.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_16.setBounds(577, 183, 85, 25);
				panel_2.add(button_16);
				
				JButton button_17 = new JButton("view");
				button_17.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage18.getText()!="") {
							watch w = new watch(massage18.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_17.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_17.setBounds(577, 211, 85, 25);
				panel_2.add(button_17);
				
				JButton button_18 = new JButton("view");
				button_18.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage19.getText()!="") {
							watch w = new watch(massage19.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_18.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_18.setBounds(577, 239, 85, 25);
				panel_2.add(button_18);
				
				JButton button_19 = new JButton("view");
				button_19.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage20.getText()!="") {
							watch w = new watch(massage20.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_19.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_19.setBounds(577, 267, 85, 25);
				panel_2.add(button_19);
				
				d11 = new JRadioButton("11");
				d11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d11.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d10.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d11.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d11.setBounds(8, 15, 43, 25);
				panel_2.add(d11);
				
				d12 = new JRadioButton("12");
				d12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d12.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d10.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d12.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d12.setBounds(8, 43, 43, 25);
				panel_2.add(d12);
				
				d13 = new JRadioButton("13");
				d13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d13.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d10.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d13.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d13.setBounds(8, 71, 43, 25);
				panel_2.add(d13);
				
				d14 = new JRadioButton("14");
				d14.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d14.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d10.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d14.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d14.setBounds(8, 99, 43, 25);
				panel_2.add(d14);
				
				d15 = new JRadioButton("15");
				d15.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d15.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d10.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d15.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d15.setBounds(8, 127, 43, 25);
				panel_2.add(d15);
				
				d16 = new JRadioButton("16");
				d16.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d16.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d10.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d16.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d16.setBounds(8, 155, 43, 25);
				panel_2.add(d16);
				
				d17 = new JRadioButton("17");
				d17.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d17.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d10.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d17.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d17.setBounds(8, 183, 43, 25);
				panel_2.add(d17);
				
				d18 = new JRadioButton("18");
				d18.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d18.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d10.setSelected(false);  d19.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d18.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d18.setBounds(8, 211, 43, 25);
				panel_2.add(d18);
				
				d19 = new JRadioButton("19");
				d19.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d19.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d10.setSelected(false);  d20.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d19.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d19.setBounds(8, 239, 43, 25);
				panel_2.add(d19);
				
				d20 = new JRadioButton("20");
				d20.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d20.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d20.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d20.setBounds(8, 267, 43, 25);
				panel_2.add(d20);
				
				
				
				JButton button_20 = new JButton("view");
				button_20.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage21.getText()!="") {
							watch w = new watch(massage21.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_20.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_20.setBounds(577, 15, 85, 25);
				panel_3.add(button_20);
				
				JButton button_21 = new JButton("view");
				button_21.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage22.getText()!="") {
							watch w = new watch(massage22.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_21.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_21.setBounds(577, 43, 85, 25);
				panel_3.add(button_21);
				
				JButton button_22 = new JButton("view");
				button_22.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage23.getText()!="") {
							watch w = new watch(massage23.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_22.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_22.setBounds(577, 71, 85, 25);
				panel_3.add(button_22);
				
				JButton button_23 = new JButton("view");
				button_23.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage24.getText()!="") {
							watch w = new watch(massage24.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_23.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_23.setBounds(577, 99, 85, 25);
				panel_3.add(button_23);
				
				JButton button_24 = new JButton("view");
				button_24.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage25.getText()!="") {
							watch w = new watch(massage25.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_24.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_24.setBounds(577, 127, 85, 25);
				panel_3.add(button_24);
				
				JButton button_25 = new JButton("view");
				button_25.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage26.getText()!="") {
							watch w = new watch(massage26.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_25.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_25.setBounds(577, 155, 85, 25);
				panel_3.add(button_25);
				
				JButton button_26 = new JButton("view");
				button_26.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage27.getText()!="") {
							watch w = new watch(massage27.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_26.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_26.setBounds(577, 183, 85, 25);
				panel_3.add(button_26);
				
				JButton button_27 = new JButton("view");
				button_27.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage28.getText()!="") {
							watch w = new watch(massage28.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_27.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_27.setBounds(577, 211, 85, 25);
				panel_3.add(button_27);
				
				JButton button_28 = new JButton("view");
				button_28.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage29.getText()!="") {
							watch w = new watch(massage29.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_28.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_28.setBounds(577, 239, 85, 25);
				panel_3.add(button_28);
				
				JButton button_29 = new JButton("view");
				button_29.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage30.getText()!="") {
							watch w = new watch(massage30.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_29.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_29.setBounds(577, 267, 85, 25);
				panel_3.add(button_29);
				
				d21 = new JRadioButton("21");
				d21.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d21.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d20.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d21.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d21.setBounds(8, 15, 43, 25);
				panel_3.add(d21);
				
				d22 = new JRadioButton("22");
				d22.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d22.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d20.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d22.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d22.setBounds(8, 43, 43, 25);
				panel_3.add(d22);
				
				d23 = new JRadioButton("23");
				d23.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d23.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d20.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d23.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d23.setBounds(8, 71, 43, 25);
				panel_3.add(d23);
				
				d24 = new JRadioButton("24");
				d24.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d24.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d20.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d24.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d24.setBounds(8, 99, 43, 25);
				panel_3.add(d24);
				
				d25 = new JRadioButton("25");
				d25.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d25.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d20.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d25.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d25.setBounds(8, 127, 43, 25);
				panel_3.add(d25);
				
				d26 = new JRadioButton("26");
				d26.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d26.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d20.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d26.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d26.setBounds(8, 155, 43, 25);
				panel_3.add(d26);
				
				d27 = new JRadioButton("27");
				d27.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d27.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d20.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d27.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d27.setBounds(8, 183, 43, 25);
				panel_3.add(d27);
				
				d28 = new JRadioButton("28");
				d28.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d28.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d20.setSelected(false);  d29.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d28.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d28.setBounds(8, 211, 43, 25);
				panel_3.add(d28);
				
				d29 = new JRadioButton("29");
				d29.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d29.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d20.setSelected(false);  d30.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d29.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d29.setBounds(8, 239, 43, 25);
				panel_3.add(d29);
				
				d30 = new JRadioButton("30");
				d30.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d30.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d30.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d30.setBounds(8, 267, 43, 25);
				panel_3.add(d30);
				
				
				
				JButton button_30 = new JButton("view");
				button_30.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage31.getText()!="") {
							watch w = new watch(massage31.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_30.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_30.setBounds(577, 15, 85, 25);
				panel_4.add(button_30);
				
				JButton button_31 = new JButton("view");
				button_31.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage32.getText()!="") {
							watch w = new watch(massage32.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_31.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_31.setBounds(577, 43, 85, 25);
				panel_4.add(button_31);
				
				JButton button_32 = new JButton("view");
				button_32.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage33.getText()!="") {
							watch w = new watch(massage33.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_32.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_32.setBounds(577, 71, 85, 25);
				panel_4.add(button_32);
				
				JButton button_33 = new JButton("view");
				button_33.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage34.getText()!="") {
							watch w = new watch(massage34.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_33.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_33.setBounds(577, 99, 85, 25);
				panel_4.add(button_33);
				
				JButton button_34 = new JButton("view");
				button_34.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage35.getText()!="") {
							watch w = new watch(massage35.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_34.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_34.setBounds(577, 127, 85, 25);
				panel_4.add(button_34);
				
				JButton button_35 = new JButton("view");
				button_35.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage36.getText()!="") {
							watch w = new watch(massage36.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_35.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_35.setBounds(577, 155, 85, 25);
				panel_4.add(button_35);
				
				JButton button_36 = new JButton("view");
				button_36.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage37.getText()!="") {
							watch w = new watch(massage37.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_36.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_36.setBounds(577, 183, 85, 25);
				panel_4.add(button_36);
				
				JButton button_37 = new JButton("view");
				button_37.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage38.getText()!="") {
							watch w = new watch(massage38.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_37.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_37.setBounds(577, 211, 85, 25);
				panel_4.add(button_37);
				
				JButton button_38 = new JButton("view");
				button_38.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage39.getText()!="") {
							watch w = new watch(massage39.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_38.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_38.setBounds(577, 239, 85, 25);
				panel_4.add(button_38);
				
				JButton button_39 = new JButton("view");
				button_39.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage40.getText()!="") {
							watch w = new watch(massage40.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_39.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_39.setBounds(577, 267, 85, 25);
				panel_4.add(button_39);
				
				d31 = new JRadioButton("31");
				d31.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d31.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d30.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d31.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d31.setBounds(8, 15, 43, 25);
				panel_4.add(d31);
				
				d32 = new JRadioButton("32");
				d32.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d32.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d30.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d32.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d32.setBounds(8, 43, 43, 25);
				panel_4.add(d32);
				
				d33 = new JRadioButton("33");
				d33.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d33.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d30.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d33.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d33.setBounds(8, 71, 43, 25);
				panel_4.add(d33);
				
				d34 = new JRadioButton("34");
				d34.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d34.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d30.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d34.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d34.setBounds(8, 99, 43, 25);
				panel_4.add(d34);
				
				d35 = new JRadioButton("35");
				d35.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d35.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d30.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d35.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d35.setBounds(8, 127, 43, 25);
				panel_4.add(d35);
				
				d36 = new JRadioButton("36");
				d36.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d36.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d30.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d36.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d36.setBounds(8, 155, 43, 25);
				panel_4.add(d36);
				
				d37 = new JRadioButton("37");
				d37.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d37.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d30.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d37.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d37.setBounds(8, 183, 43, 25);
				panel_4.add(d37);
				
				d38 = new JRadioButton("38");
				d38.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d38.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d30.setSelected(false);  d39.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d38.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d38.setBounds(8, 211, 43, 25);
				panel_4.add(d38);
				
				d39 = new JRadioButton("39");
				d39.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d39.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d30.setSelected(false);  d40.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d39.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d39.setBounds(8, 239, 43, 25);
				panel_4.add(d39);
				
				d40 = new JRadioButton("40");
				d40.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d40.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d40.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d40.setBounds(8, 267, 43, 25);
				panel_4.add(d40);
				
				
				
				JButton button_40 = new JButton("view");
				button_40.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage41.getText()!="") {
							watch w = new watch(massage41.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_40.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_40.setBounds(577, 15, 85, 25);
				panel_5.add(button_40);
				
				JButton button_41 = new JButton("view");
				button_41.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage42.getText()!="") {
							watch w = new watch(massage42.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_41.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_41.setBounds(577, 43, 85, 25);
				panel_5.add(button_41);
				
				JButton button_42 = new JButton("view");
				button_42.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage43.getText()!="") {
							watch w = new watch(massage43.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_42.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_42.setBounds(577, 71, 85, 25);
				panel_5.add(button_42);
				
				JButton button_43 = new JButton("view");
				button_43.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage44.getText()!="") {
							watch w = new watch(massage44.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_43.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_43.setBounds(577, 99, 85, 25);
				panel_5.add(button_43);
				
				JButton button_44 = new JButton("view");
				button_44.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage45.getText()!="") {
							watch w = new watch(massage45.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_44.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_44.setBounds(577, 127, 85, 25);
				panel_5.add(button_44);
				
				JButton button_45 = new JButton("view");
				button_45.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage46.getText()!="") {
							watch w = new watch(massage46.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_45.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_45.setBounds(577, 155, 85, 25);
				panel_5.add(button_45);
				
				JButton button_46 = new JButton("view");
				button_46.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage47.getText()!="") {
							watch w = new watch(massage47.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_46.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_46.setBounds(577, 183, 85, 25);
				panel_5.add(button_46);
				
				JButton button_47 = new JButton("view");
				button_47.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage48.getText()!="") {
							watch w = new watch(massage48.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_47.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_47.setBounds(577, 211, 85, 25);
				panel_5.add(button_47);
				
				JButton button_48 = new JButton("view");
				button_48.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage49.getText()!="") {
							watch w = new watch(massage49.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_48.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_48.setBounds(577, 239, 85, 25);
				panel_5.add(button_48);
				
				JButton button_49 = new JButton("view");
				button_49.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage50.getText()!="") {
							watch w = new watch(massage50.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_49.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_49.setBounds(577, 267, 85, 25);
				panel_5.add(button_49);
				
				d41 = new JRadioButton("41");
				d41.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d41.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d40.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d41.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d41.setBounds(8, 15, 43, 25);
				panel_5.add(d41);
				
				d42 = new JRadioButton("42");
				d42.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d42.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d40.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d42.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d42.setBounds(8, 43, 43, 25);
				panel_5.add(d42);
				
				d43 = new JRadioButton("43");
				d43.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d43.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d40.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d43.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d43.setBounds(8, 71, 43, 25);
				panel_5.add(d43);
				
				d44 = new JRadioButton("44");
				d44.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d44.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d40.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d44.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d44.setBounds(8, 99, 43, 25);
				panel_5.add(d44);
				
				d45 = new JRadioButton("45");
				d45.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d45.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d40.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d45.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d45.setBounds(8, 127, 43, 25);
				panel_5.add(d45);
				
				d46 = new JRadioButton("46");
				d46.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d46.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d40.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d46.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d46.setBounds(8, 155, 43, 25);
				panel_5.add(d46);
				
				d47 = new JRadioButton("47");
				d47.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d47.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d40.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d47.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d47.setBounds(8, 183, 43, 25);
				panel_5.add(d47);
				
				d48 = new JRadioButton("48");
				d48.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d48.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d40.setSelected(false);  d49.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d48.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d48.setBounds(8, 211, 43, 25);
				panel_5.add(d48);
				
				d49 = new JRadioButton("49");
				d49.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d49.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d40.setSelected(false);  d50.setSelected(false);  
						}
					}
				});
				d49.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d49.setBounds(8, 239, 43, 25);
				panel_5.add(d49);
				
				d50 = new JRadioButton("50");
				d50.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d50.isSelected()) {
			d2.setSelected(false);   d3.setSelected(false);  d4.setSelected(false);  d5.setSelected(false);  d6.setSelected(false);
			d7.setSelected(false);   d8.setSelected(false);  d9.setSelected(false);  d1.setSelected(false);  d11.setSelected(false);
			d12.setSelected(false);   d13.setSelected(false);  d14.setSelected(false);  d15.setSelected(false);  d16.setSelected(false);
			d17.setSelected(false);   d18.setSelected(false);  d19.setSelected(false);  d10.setSelected(false);  d21.setSelected(false);
			d22.setSelected(false);   d23.setSelected(false);  d24.setSelected(false);  d25.setSelected(false);  d26.setSelected(false);
			d27.setSelected(false);   d28.setSelected(false);  d29.setSelected(false);  d20.setSelected(false);  d31.setSelected(false);
			d32.setSelected(false);   d33.setSelected(false);  d34.setSelected(false);  d35.setSelected(false);  d36.setSelected(false);
			d37.setSelected(false);   d38.setSelected(false);  d39.setSelected(false);  d30.setSelected(false);  d41.setSelected(false);
			d42.setSelected(false);   d43.setSelected(false);  d44.setSelected(false);  d45.setSelected(false);  d46.setSelected(false);
			d47.setSelected(false);   d48.setSelected(false);  d49.setSelected(false);  d40.setSelected(false);  
						}
					}
				});
				d50.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 17));
				d50.setBounds(8, 267, 43, 25);
				panel_5.add(d50);
				
				JButton load = new JButton("load");
				load.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(d1.isSelected()) {
						if(massage1.getText().toString() != "") {
							Mail m=a.LoadMail(a.GetUser(),massage1.getText().toString(), "Draft");
							a.deleteFolder(a.GetUser(),massage1.getText().toString() );
		                       send s = new send(m);    s.setVisible(true);    dispose();}
						else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }   
						else if(d2.isSelected()) {
							if(massage2.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage2.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage2.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d3.isSelected()) {
							if(massage3.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage3.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage3.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d4.isSelected()) {
							if(massage4.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage4.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage4.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d5.isSelected()) {
							if(massage5.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage5.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage5.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d6.isSelected()) {
							if(massage6.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage6.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage6.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d7.isSelected()) {
							if(massage7.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage7.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage7.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d8.isSelected()) {
							if(massage8.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage8.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage8.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d9.isSelected()) {
							if(massage9.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage9.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage9.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d10.isSelected()) {
							if(massage10.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage10.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage10.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d11.isSelected()) {
							if(massage11.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage11.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage11.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d12.isSelected()) {
							if(massage12.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage12.getText().toString(), "Draft");
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d13.isSelected()) {
							if(massage13.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage13.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage13.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d14.isSelected()) {
							if(massage14.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage14.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage14.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d15.isSelected()) {
							if(massage15.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage15.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage15.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d16.isSelected()) {
							if(massage16.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage16.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage16.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d17.isSelected()) {
							if(massage17.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage17.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage17.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d18.isSelected()) {
							if(massage18.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage18.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage18.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d19.isSelected()) {
							if(massage19.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage19.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage19.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d20.isSelected()) {
							if(massage20.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage20.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage20.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d21.isSelected()) {
							if(massage21.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage21.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage21.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d22.isSelected()) {
							if(massage22.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage22.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage22.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d23.isSelected()) {
							if(massage23.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage23.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage23.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d24.isSelected()) {
							if(massage24.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage24.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage24.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d25.isSelected()) {
							if(massage25.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage25.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage25.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d26.isSelected()) {
							if(massage26.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage26.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage26.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d27.isSelected()) {
							if(massage27.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage27.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage27.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d28.isSelected()) {
							if(massage28.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage28.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage28.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d29.isSelected()) {
							if(massage29.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage29.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage29.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d30.isSelected()) {
							if(massage30.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage30.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage30.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d31.isSelected()) {
							if(massage31.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage31.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage31.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d33.isSelected()) {
							if(massage33.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage33.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage33.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d32.isSelected()) {
							if(massage32.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage32.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage32.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d34.isSelected()) {
							if(massage34.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage34.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage34.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d35.isSelected()) {
							if(massage35.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage35.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage35.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d36.isSelected()) {
							if(massage36.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage36.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage36.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d37.isSelected()) {
							if(massage37.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage37.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage37.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d38.isSelected()) {
							if(massage38.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage38.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage38.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d39.isSelected()) {
							if(massage39.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage39.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage39.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d40.isSelected()) {
							if(massage40.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage40.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage40.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d41.isSelected()) {
							if(massage41.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage41.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage41.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d42.isSelected()) {
							if(massage42.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage42.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage42.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d43.isSelected()) {
							if(massage43.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage43.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage43.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d44.isSelected()) {
							if(massage44.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage44.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage44.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d45.isSelected()) {
							if(massage45.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage45.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage45.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d46.isSelected()) {
							if(massage46.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage46.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage46.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d47.isSelected()) {
							if(massage47.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage47.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage47.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d48.isSelected()) {
							if(massage48.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage48.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage48.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d49.isSelected()) {
							if(massage49.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage49.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage49.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else if(d50.isSelected()) {
							if(massage50.getText().toString() != "") {
								Mail m=a.LoadMail(a.GetUser(),massage50.getText().toString(), "Draft");
								a.deleteFolder(a.GetUser(),massage50.getText().toString() );
								send s = new send(m);    s.setVisible(true);    dispose();}
							else {JOptionPane.showMessageDialog(null, "The massage don't exist");} }
						else {JOptionPane.showMessageDialog(null, "you should choose massage");}
						
					}
				});
				load.setFont(new Font("Algerian", Font.ITALIC, 20));
				load.setBounds(662, 615, 97, 25);
				contentPane.add(load);
				
				JButton btnBack = new JButton("Back");
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Mail m = new Mail();
						send q= new send(m);
						q.setVisible(true);
						dispose();
					}
				});
				btnBack.setFont(new Font("Algerian", Font.ITALIC, 20));
				btnBack.setBounds(50, 615, 97, 25);
				contentPane.add(btnBack);
				
			}
			
			public void switchpanel( JPanel panel) {
				panellll.removeAll();
				panellll.add(panel);
				panellll.repaint();
				panellll.revalidate();
			}
		}
		public class oparate extends JFrame {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JPanel contentPane;
			private JTextField textField;
		    private JRadioButton Inbox,Draft;
		    private JRadioButton Sender,Receiver,Subject,piriority;
		    JPanel panellll;
		    private JRadioButton r1,r2,r3,r4,r5;
		    private JLabel massage1,massage2,massage3,massage4,massage5;
		    private JLabel massage6,massage7,massage8,massage9,massage10;
		    private JLabel massage11,massage12,massage13,massage14,massage15;
		    private JLabel massage16,massage17,massage18,massage19,massage20;
		    private JLabel massage21,massage22,massage23,massage24,massage25;
		    private JLabel massage26,massage27,massage28,massage29,massage30;
		    private JLabel massage31,massage32,massage33,massage34,massage35;
		    private JLabel massage36,massage37,massage38,massage39,massage40;
		    private JLabel massage41,massage42,massage43,massage44,massage45;
		    private JLabel massage46,massage47,massage48,massage49,massage50;
		    private JCheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
		    private JCheckBox c20,c19,c18,c17,c16,c15,c14,c13,c12,c11;
		    private JCheckBox c21,c22,c23,c24,c25,c26,c27,c28,c29,c30;
		    private JCheckBox c31,c34,c33,c32,c35,c36,c37,c38,c39,c40;
		    private JCheckBox c41,c42,c43,c44,c45,c46,c47,c48,c49,c50;
		    private JRadioButton reciver2;
		    private JRadioButton sender2;
		    private JRadioButton date,sub2;
			
			/**
			 * Create the frame.
			 */
			public oparate(Singly_Linked_list s,Folder ff) {
				String pervious=(String)s.get(s.size()-1);
				String prev[]=pervious.split("    ");
				String prefolder=prev[0];
				String presorting=prev[1];
				String prefilter=prev[2];
				String prefilter2=prev[3];
				s.remove(s.size()-1);
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 800, 700);
				contentPane = new JPanel();
				contentPane.setForeground(Color.BLACK);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setLayout(null);
				panel.setForeground(Color.WHITE);
				panel.setBackground(Color.GRAY);
				panel.setBounds(0, 0, 782, 195);
				contentPane.add(panel);
				
				JLabel label = new JLabel("Folder");
				label.setOpaque(true);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setForeground(new Color(72, 61, 139));
				label.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				label.setBackground(new Color(245, 255, 250));
				label.setBounds(12, 13, 149, 22);
				panel.add(label);
				
				Inbox = new JRadioButton("Inbox");
				Inbox.setHorizontalAlignment(SwingConstants.CENTER);
				Inbox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(Inbox.isSelected()) {
							//Trash.setSelected(false);
							Draft.setSelected(false);
						}
					}
				});
				Inbox.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Inbox.setBounds(202, 12, 180, 25);
				panel.add(Inbox);
				
				Draft = new JRadioButton("Draft");
				Draft.setHorizontalAlignment(SwingConstants.CENTER);
				Draft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Draft.isSelected()) {
							Inbox.setSelected(false);
							//Trash.setSelected(false);
						}
					}
				});
				Draft.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Draft.setBounds(548, 12, 180, 25);
				panel.add(Draft);
				
				JLabel lblSort = new JLabel("Sort");
				lblSort.setOpaque(true);
				lblSort.setHorizontalAlignment(SwingConstants.CENTER);
				lblSort.setForeground(new Color(72, 61, 139));
				lblSort.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				lblSort.setBackground(new Color(245, 255, 250));
				lblSort.setBounds(12, 57, 149, 22);
				panel.add(lblSort);
				
				 Sender = new JRadioButton("Sender");
				 Sender.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(Sender.isSelected()) {
				 			Receiver.setSelected(false);
				 			Subject.setSelected(false);
				 			piriority.setSelected(false);
				 		}
				 	}
				 });
				Sender.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Sender.setBounds(202, 58, 91, 25);
				panel.add(Sender);
				
				 Receiver = new JRadioButton("Receiver\r\n");
				 Receiver.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(Receiver.isSelected()) {
				 			Sender.setSelected(false);
				 			Subject.setSelected(false);
				 			piriority.setSelected(false);
				 		}
				 	}
				 });
				Receiver.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Receiver.setBounds(335, 58, 114, 25);
				panel.add(Receiver);
				
				 Subject = new JRadioButton("Subject");
				 Subject.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(Subject.isSelected()) {
				 			Sender.setSelected(false);
				 			Receiver.setSelected(false);
				 			piriority.setSelected(false);
				 		}
				 	}
				 });
				Subject.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				Subject.setBounds(500, 56, 100, 25);
				panel.add(Subject);
				
				 piriority = new JRadioButton("Importance");
				 piriority.addActionListener(new ActionListener() {
				 	public void actionPerformed(ActionEvent e) {
				 		if(piriority.isSelected()) {
				 			Sender.setSelected(false);
				 			Receiver.setSelected(false);
				 			Subject.setSelected(false);
				 		}
				 	}
				 });
				piriority.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				piriority.setBounds(630, 56, 133, 25);
				panel.add(piriority);
				
				JLabel lblFilter = new JLabel("Filter");
				lblFilter.setOpaque(true);
				lblFilter.setHorizontalAlignment(SwingConstants.CENTER);
				lblFilter.setForeground(new Color(72, 61, 139));
				lblFilter.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				lblFilter.setBackground(new Color(245, 255, 250));
				lblFilter.setBounds(12, 100, 149, 22);
				panel.add(lblFilter);
				
				textField = new JTextField();
				textField.setFont(new Font("Sitka Small", Font.BOLD, 20));
				textField.setBounds(202, 158, 347, 24);
				panel.add(textField);
				textField.setColumns(10);
				
				//String ffff;
				
				JButton btnNewButton = new JButton("Refresh");
				btnNewButton.setBounds(630, 156, 133, 26);
				panel.add(btnNewButton);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						boolean good=true;
						Singly_Linked_list s= new Singly_Linked_list();
						Folder f = new Folder();
						f.SetUser(a.GetUser());
						if(Inbox.isSelected()) {f.SetFoldername("Inbox");}
						//else if (Trash.isSelected()) {f.SetFoldername("Trash");}
						else if (Draft.isSelected()) {f.SetFoldername("Draft");}
						else {
							f.SetFoldername(prefolder.toString());	
						}
						sort ss= new sort();
						if (Sender.isSelected()) {ss.setSorting("sender");}
						else if (Receiver.isSelected()) {ss.setSorting("receiver");}
						else if (Subject.isSelected()) {ss.setSorting("subject");}
						else if (piriority.isSelected()) {ss.setSorting("priority");}
						else if (!presorting.equals("null")) {ss.setSorting(presorting);}
						
						filter f1= new filter();
						if(sub2.isSelected()) {f1.Setkindfilter("subject");}
						else if(date.isSelected()) {f1.Setkindfilter("Date");}
						else if(sender2.isSelected()) {f1.Setkindfilter("sender");}
						else if(reciver2.isSelected()) {f1.Setkindfilter("reciver");}
						else {f1.Setkindfilter(prefilter);
						f1.Setnamefilter(prefilter2);}
						if(sub2.isSelected()  || date.isSelected() || sender2.isSelected() || reciver2.isSelected()) {
						if(textField.getText().toString().length()>0) {
						f1.Setnamefilter(textField.getText().toString());}
						else {
							JOptionPane.showMessageDialog(null, "You Should enter String in filter box");
							good=false;
						}
						
						}
						if(good) {
						s=(Singly_Linked_list)a.setViewingOptions(f, f1, ss);
						StringBuilder prevv=new StringBuilder(f.GetFolderName()+"    ");
						if(ss.getSorting()!=null) {
							prevv.append(ss.getSorting()+"    ");
						}else {
							prevv.append("null    ");
						}
						if(f1.getkindfilter()!=null && !f1.getkindfilter().equals("null") ) {
							prevv.append(f1.getkindfilter()+"    "+f1.getnamefilter());
						}else {
							prevv.append("null    null");
						}
						String previouss=prevv.toString();
						//System.out.println(previouss);
						s.add(previouss);
						oparate v=new oparate(s,ff);
						v.setVisible(true);
						dispose();}
					}
				});
				btnNewButton.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 25));
				
				sub2 = new JRadioButton("Subject");
				sub2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(sub2.isSelected()) {
							reciver2.setSelected(false);
							sender2.setSelected(false);
							date.setSelected(false);
						}	
					}
				});
				sub2.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				sub2.setBounds(500, 101, 100, 25);
				panel.add(sub2);
				
				reciver2 = new JRadioButton("Receiver\r\n");
				reciver2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(reciver2.isSelected()) {
							sub2.setSelected(false);
							sender2.setSelected(false);
							date.setSelected(false);
						}	
					}
				});
				reciver2.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				reciver2.setBounds(335, 99, 114, 25);
				panel.add(reciver2);
				
				sender2 = new JRadioButton("Sender");
				sender2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(sender2.isSelected()) {
							sub2.setSelected(false);
							reciver2.setSelected(false);
							date.setSelected(false);
						}
					}
				});
				sender2.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				sender2.setBounds(202, 101, 91, 25);
				panel.add(sender2);
				
				date = new JRadioButton("Date");
				date.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(date.isSelected()) {
							sub2.setSelected(false);
							reciver2.setSelected(false);
							sender2.setSelected(false);
						}
					}
				});
				date.setFont(new Font("Tw Cen MT", Font.BOLD, 22));
				date.setBounds(630, 101, 100, 25);
				panel.add(date);
				
				
				panellll = new JPanel();
				panellll.setBounds(50, 280, 670, 309);
				contentPane.add(panellll);
				panellll.setLayout(new CardLayout(0, 0));
				
				JPanel panel_1 = new JPanel();
				panel_1.setLayout(null);
				panel_1.setBackground(Color.BLUE);
				panellll.add(panel_1, "name_344929928447800");
				
				JPanel panel_2 = new JPanel();
				panel_2.setLayout(null);
				panel_2.setBackground(Color.BLUE);
				panellll.add(panel_2, "name_344962931110400");
				
				JPanel panel_3 = new JPanel();
				panel_3.setLayout(null);
				panel_3.setBackground(Color.BLUE);
				panellll.add(panel_3, "name_348895440977600");
				
				JPanel panel_4 = new JPanel();
				panel_4.setLayout(null);
				panel_4.setBackground(Color.BLUE);
				panellll.add(panel_4, "name_348905531528400");
				
				JPanel panel_5 = new JPanel();
				panel_5.setLayout(null);
				panel_5.setBackground(Color.BLUE);
				panellll.add(panel_5, "name_348954193306500");
				
				JLabel lblPage = new JLabel("Page");
				lblPage.setOpaque(true);
				lblPage.setHorizontalAlignment(SwingConstants.CENTER);
				lblPage.setForeground(Color.YELLOW);
				lblPage.setFont(new Font("Yu Gothic", Font.BOLD, 22));
				lblPage.setBackground(Color.RED);
				lblPage.setBounds(95, 228, 149, 22);
				contentPane.add(lblPage);
				
				r1 = new JRadioButton("1");
				r1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(r1.isSelected()) {
						r2.setSelected(false);
						r3.setSelected(false);
						r4.setSelected(false);
						r5.setSelected(false);
						switchpanel(panel_1);
						}
					}
				});
				r1.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r1.setBounds(279, 226, 51, 25);
				contentPane.add(r1);
				
				r2 = new JRadioButton("2");
				r2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r2.isSelected()) {
							r1.setSelected(false);
							r3.setSelected(false);
							r4.setSelected(false);
							r5.setSelected(false);
							switchpanel(panel_2);
							}
					}
				});
				r2.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r2.setBounds(358, 226, 51, 25);
				contentPane.add(r2);
				
				r3 = new JRadioButton("3");
				r3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r3.isSelected()) {
							r2.setSelected(false);
							r1.setSelected(false);
							r4.setSelected(false);
							r5.setSelected(false);
							switchpanel(panel_3);
							}
					}
				});
				r3.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r3.setBounds(430, 226, 51, 25);
				contentPane.add(r3);
				
				r4 = new JRadioButton("4");
				r4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r4.isSelected()) {
							r2.setSelected(false);
							r3.setSelected(false);
							r1.setSelected(false);
							r5.setSelected(false);
							switchpanel(panel_4);
							}
					}
				});
				r4.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r4.setBounds(501, 226, 51, 25);
				contentPane.add(r4);
				
				r5 = new JRadioButton("5");
				r5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(r5.isSelected()) {
							r2.setSelected(false);
							r3.setSelected(false);
							r4.setSelected(false);
							r1.setSelected(false);
							switchpanel(panel_5);
							}
					}
				});
				r5.setFont(new Font("Tahoma", Font.PLAIN, 20));
				r5.setBounds(576, 226, 51, 25);
				contentPane.add(r5);
				
				
				String array1[]=new String [10];
				for(int i =0;i<array1.length;i++) {
					if(i<s.size()) {
				array1[i]=(String)s.get(i);}
					else {array1[i]=null;}
				}
				for(int i =0;i<array1.length;i++) {
					if(i==0 ) {
						if( array1[i]!=null) {
					    String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage1=new JLabel(Temp[Temp.length-1]);
						massage1.setOpaque(true);
						massage1.setBackground(Color.WHITE);
						massage1.setBounds(15+38, 15, 550-38, 25);
						panel_1.add(massage1);}
						else {
							massage1 = new JLabel("");
							massage1.setOpaque(true);
							massage1.setBackground(Color.WHITE);
							massage1.setBounds(15+38, 15, 550-38, 25);
							panel_1.add(massage1);
						}
						
					}
					else if(i==1) {
						if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage2=new JLabel(Temp[Temp.length-1]);
						massage2.setOpaque(true);
						massage2.setBackground(Color.WHITE);
						massage2.setBounds(15+38, 43, 550-38, 25);
						panel_1.add(massage2);
						}else {
							massage2 = new JLabel("");
							massage2.setOpaque(true);
							massage2.setBackground(Color.WHITE);
							massage2.setBounds(15+38, 43, 550-38, 25);
							panel_1.add(massage2);
						}
					}
					else if(i==2) {
						if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage3=new JLabel(Temp[Temp.length-1]);
						massage3.setOpaque(true);
						massage3.setBackground(Color.WHITE);
						massage3.setBounds(15+38, 71, 550-38, 25);
						panel_1.add(massage3);}
						else {
							massage3 = new JLabel("");
							massage3.setOpaque(true);
							massage3.setBackground(Color.WHITE);
							massage3.setBounds(15+38, 71, 550-38, 25);
							panel_1.add(massage3);
						}
					}
					else if(i==3 ) {
						if (array1[i]!=null) {
					    String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage4=new JLabel(Temp[Temp.length-1]);
						massage4.setOpaque(true);
						massage4.setBackground(Color.WHITE);
						massage4.setBounds(15+38, 99, 550-38, 25);
						panel_1.add(massage4);}
						else {
							massage4 = new JLabel("");
							massage4.setOpaque(true);
							massage4.setBackground(Color.WHITE);
							massage4.setBounds(15+38, 99, 550-38, 25);
							panel_1.add(massage4);
						}
					}
					else if(i==4 ) {
					  if( array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage5=new JLabel(Temp[Temp.length-1]);
						massage5.setOpaque(true);
						massage5.setBackground(Color.WHITE);
						massage5.setBounds(15+38, 127, 550-38, 25);
						panel_1.add(massage5);}
					  else {
						  massage5 = new JLabel("");
							massage5.setOpaque(true);
							massage5.setBackground(Color.WHITE);
							massage5.setBounds(15+38, 127, 550-38, 25);
							panel_1.add(massage5);
					  }
					  
						
					}
					else if(i==5 ) {
						if( array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage6=new JLabel(Temp[Temp.length-1]);
						massage6.setOpaque(true);
						massage6.setBackground(Color.WHITE);
						massage6.setBounds(15+38, 155, 550-38, 25);
						panel_1.add(massage6);}
						else {
							massage6 = new JLabel("");
							massage6.setOpaque(true);
							massage6.setBackground(Color.WHITE);
							massage6.setBounds(15+38, 155, 550-38, 25);
							panel_1.add(massage6);
						}
					}
					else if(i==6) {
						if( array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage7=new JLabel(Temp[Temp.length-1]);
						massage7.setOpaque(true);
						massage7.setBackground(Color.WHITE);
						massage7.setBounds(15+38, 183, 550-38, 25);
						panel_1.add(massage7);}
						else {
							massage7 = new JLabel("");
							massage7.setOpaque(true);
							massage7.setBackground(Color.WHITE);
							massage7.setBounds(15+38, 183, 550-38, 25);
							panel_1.add(massage7);
						}
					}
					else if(i==7) {
						if (array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage8=new JLabel(Temp[Temp.length-1]);
						massage8.setOpaque(true);
						massage8.setBackground(Color.WHITE);
						massage8.setBounds(15+38, 211, 550-38, 25);
						panel_1.add(massage8);}
						else {
							massage8 = new JLabel("");
							massage8.setOpaque(true);
							massage8.setBackground(Color.WHITE);
							massage8.setBounds(15+38, 211, 550-38, 25);
							panel_1.add(massage8);
						}
					}
					else if(i==8 ) {
						if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage9=new JLabel(Temp[Temp.length-1]);
						massage9.setOpaque(true);
						massage9.setBackground(Color.WHITE);
						massage9.setBounds(15+38, 239, 550-38, 25);
						panel_1.add(massage9);}
						else {
							massage9 = new JLabel("");
							massage9.setOpaque(true);
							massage9.setBackground(Color.WHITE);
							massage9.setBounds(15+38, 239, 550-38, 25);
							panel_1.add(massage9);
						}
					}
					else if(i==9 ) {
							if(array1[i]!=null) {
						String temp=(String)s.get(i);
						String Temp[]=temp.split("    ");
						massage10=new JLabel(Temp[Temp.length-1]);
						massage10.setOpaque(true);
						massage10.setBackground(Color.WHITE);
						massage10.setBounds(15+38, 267, 550-38, 25);
						panel_1.add(massage10);}
							else {
								massage10 = new JLabel("");
								massage10.setOpaque(true);
								massage10.setBackground(Color.WHITE);
								massage10.setBounds(15+38, 267, 550-38, 25);
								panel_1.add(massage10);
							}
					}
				}
				
				
				String array2[]=new String [10];
				for(int i =10;i<array2.length+10;i++) {
					if(i<s.size()) {
				array2[i%10]=(String)s.get(i);}
					else {array2[i%10]=null;}
				}
				for(int i =0;i<array2.length;i++) {
					if(i==0 ) {
						if( array2[i]!=null) {
					    String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage11=new JLabel(Temp[Temp.length-1]);
						massage11.setOpaque(true);
						massage11.setBackground(Color.WHITE);
						massage11.setBounds(15+38, 15, 550-38, 25);
						panel_2.add(massage11);}
						else {
							massage11 = new JLabel("");
							massage11.setOpaque(true);
							massage11.setBackground(Color.WHITE);
							massage11.setBounds(15+38, 15, 550-38, 25);
							panel_2.add(massage11);
						}
						
					}
					else if(i==1) {
						if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage12=new JLabel(Temp[Temp.length-1]);
						massage12.setOpaque(true);
						massage12.setBackground(Color.WHITE);
						massage12.setBounds(15+38, 43, 550-38, 25);
						panel_2.add(massage12);
						}else {
							massage12 = new JLabel("");
							massage12.setOpaque(true);
							massage12.setBackground(Color.WHITE);
							massage12.setBounds(15+38, 43, 550-38, 25);
							panel_2.add(massage12);
						}
					}
					else if(i==2) {
						if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage13=new JLabel(Temp[Temp.length-1]);
						massage13.setOpaque(true);
						massage13.setBackground(Color.WHITE);
						massage13.setBounds(15+38, 71, 550-38, 25);
						panel_2.add(massage13);}
						else {
							massage13 = new JLabel("");
							massage13.setOpaque(true);
							massage13.setBackground(Color.WHITE);
							massage13.setBounds(15+38, 71, 550-38, 25);
							panel_2.add(massage13);
						}
					}
					else if(i==3 ) {
						if (array2[i]!=null) {
					    String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage14=new JLabel(Temp[Temp.length-1]);
						massage14.setOpaque(true);
						massage14.setBackground(Color.WHITE);
						massage14.setBounds(15+38, 99, 550-38, 25);
						panel_2.add(massage14);}
						else {
							massage14 = new JLabel("");
							massage14.setOpaque(true);
							massage14.setBackground(Color.WHITE);
							massage14.setBounds(15+38, 99, 550-38, 25);
							panel_2.add(massage14);
						}
					}
					else if(i==4 ) {
					  if( array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage15=new JLabel(Temp[Temp.length-1]);
						massage15.setOpaque(true);
						massage15.setBackground(Color.WHITE);
						massage15.setBounds(15+38, 127, 550-38, 25);
						panel_2.add(massage15);}
					  else {
						  massage15 = new JLabel("");
							massage15.setOpaque(true);
							massage15.setBackground(Color.WHITE);
							massage15.setBounds(15+38, 127, 550-38, 25);
							panel_2.add(massage15);
					  }
						
					}
					else if(i==5 ) {
						if( array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage16=new JLabel(Temp[Temp.length-1]);
						massage16.setOpaque(true);
						massage16.setBackground(Color.WHITE);
						massage16.setBounds(15+38, 155, 550-38, 25);
						panel_2.add(massage16);}
						else {
							massage16 = new JLabel("");
							massage16.setOpaque(true);
							massage16.setBackground(Color.WHITE);
							massage16.setBounds(15+38, 155, 550-38, 25);
							panel_2.add(massage16);
						}
					}
					else if(i==6) {
						if( array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage17=new JLabel(Temp[Temp.length-1]);
						massage17.setOpaque(true);
						massage17.setBackground(Color.WHITE);
						massage17.setBounds(15+38, 183, 550-38, 25);
						panel_2.add(massage17);}
						else {
							massage17 = new JLabel("");
							massage17.setOpaque(true);
							massage17.setBackground(Color.WHITE);
							massage17.setBounds(15+38, 183, 550-38, 25);
							panel_2.add(massage17);
						}
					}
					else if(i==7) {
						if (array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage18=new JLabel(Temp[Temp.length-1]);
						massage18.setOpaque(true);
						massage18.setBackground(Color.WHITE);
						massage18.setBounds(15+38, 211, 550-38, 25);
						panel_2.add(massage18);}
						else {
							massage18 = new JLabel("");
							massage18.setOpaque(true);
							massage18.setBackground(Color.WHITE);
							massage18.setBounds(15+38, 211, 550-38, 25);
							panel_2.add(massage18);
						}
					}
					else if(i==8 ) {
						if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage19=new JLabel(Temp[Temp.length-1]);
						massage19.setOpaque(true);
						massage19.setBackground(Color.WHITE);
						massage19.setBounds(15+38, 239, 550-38, 25);
						panel_2.add(massage19);}
						else {
							massage19 = new JLabel("");
							massage19.setOpaque(true);
							massage19.setBackground(Color.WHITE);
							massage19.setBounds(15+38, 239, 550-38, 25);
							panel_2.add(massage19);
						}
					}
					else if(i==9 ) {
							if(array2[i]!=null) {
						String temp=array2[i];
						String Temp[]=temp.split("    ");
						massage20=new JLabel(Temp[Temp.length-1]);
						massage20.setOpaque(true);
						massage20.setBackground(Color.WHITE);
						massage20.setBounds(15+38, 267, 550-38, 25);
						panel_2.add(massage20);}
							else {
								massage20 = new JLabel("");
								massage20.setOpaque(true);
								massage20.setBackground(Color.WHITE);
								massage20.setBounds(15+38, 267, 550-38, 25);
								panel_2.add(massage20);
							}
					}
				}
				
				
				
				String array3[]=new String [10];
				for(int i =20;i<array3.length+20;i++) {
					if(i<s.size()) {
				array3[i%20]=(String)s.get(i);}
					else {array3[i%20]=null;}
				}
				for(int i =0;i<array3.length;i++) {
					if(i==0 ) {
						if( array3[i]!=null) {
					    String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage21=new JLabel(Temp[Temp.length-1]);
						massage21.setOpaque(true);
						massage21.setBackground(Color.WHITE);
						massage21.setBounds(15+38, 15, 550-38, 25);
						panel_3.add(massage21);}
						else {
							massage21 = new JLabel("");
							massage21.setOpaque(true);
							massage21.setBackground(Color.WHITE);
							massage21.setBounds(15+38, 15, 550-38, 25);
							panel_3.add(massage21);
						}
						
					}
					else if(i==1) {
						if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage22=new JLabel(Temp[Temp.length-1]);
						massage22.setOpaque(true);
						massage22.setBackground(Color.WHITE);
						massage12.setBounds(15+38, 43, 550-38, 25);
						panel_3.add(massage22);
						}else {
							massage22 = new JLabel("");
							massage22.setOpaque(true);
							massage22.setBackground(Color.WHITE);
							massage22.setBounds(15+38, 43, 550-38, 25);
							panel_3.add(massage22);
						}
					}
					else if(i==2) {
						if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage23=new JLabel(Temp[Temp.length-1]);
						massage23.setOpaque(true);
						massage23.setBackground(Color.WHITE);
						massage13.setBounds(15+38, 71, 550-38, 25);
						panel_3.add(massage23);}
						else {
							massage23 = new JLabel("");
							massage23.setOpaque(true);
							massage23.setBackground(Color.WHITE);
							massage23.setBounds(15+38, 71, 550-38, 25);
							panel_3.add(massage23);
						}
					}
					else if(i==3 ) {
						if (array3[i]!=null) {
					    String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage24=new JLabel(Temp[Temp.length-1]);
						massage24.setOpaque(true);
						massage24.setBackground(Color.WHITE);
						massage14.setBounds(15+38, 99, 550-38, 25);
						panel_3.add(massage24);}
						else {
							massage24 = new JLabel("");
							massage24.setOpaque(true);
							massage24.setBackground(Color.WHITE);
							massage24.setBounds(15+38, 99, 550-38, 25);
							panel_3.add(massage24);
						}
					}
					else if(i==4 ) {
					  if( array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage25=new JLabel(Temp[Temp.length-1]);
						massage25.setOpaque(true);
						massage25.setBackground(Color.WHITE);
						massage25.setBounds(15+38, 127, 550-38, 25);
						panel_3.add(massage25);}
					  else {
						  massage25 = new JLabel("");
							massage25.setOpaque(true);
							massage25.setBackground(Color.WHITE);
							massage25.setBounds(15+38, 127, 550-38, 25);
							panel_3.add(massage25);
					  }
						
					}
					else if(i==5 ) {
						if( array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage26=new JLabel(Temp[Temp.length-1]);
						massage26.setOpaque(true);
						massage26.setBackground(Color.WHITE);
						massage26.setBounds(15+38, 155, 550-38, 25);
						panel_3.add(massage26);}
						else {
							massage26 = new JLabel("");
							massage26.setOpaque(true);
							massage26.setBackground(Color.WHITE);
							massage26.setBounds(15+38, 155, 550-38, 25);
							panel_3.add(massage26);
						}
					}
					else if(i==6) {
						if( array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage27=new JLabel(Temp[Temp.length-1]);
						massage27.setOpaque(true);
						massage27.setBackground(Color.WHITE);
						massage27.setBounds(15+38, 183, 550-38, 25);
						panel_3.add(massage27);}
						else {
							massage27 = new JLabel("");
							massage27.setOpaque(true);
							massage27.setBackground(Color.WHITE);
							massage27.setBounds(15+38, 183, 550-38, 25);
							panel_3.add(massage27);
						}
					}
					else if(i==7) {
						if (array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage28=new JLabel(Temp[Temp.length-1]);
						massage28.setOpaque(true);
						massage28.setBackground(Color.WHITE);
						massage28.setBounds(15+38, 211, 550-38, 25);
						panel_3.add(massage28);}
						else {
							massage28 = new JLabel("");
							massage28.setOpaque(true);
							massage28.setBackground(Color.WHITE);
							massage28.setBounds(15+38, 211, 550-38, 25);
							panel_3.add(massage28);
						}
					}
					else if(i==8 ) {
						if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage29=new JLabel(Temp[Temp.length-1]);
						massage29.setOpaque(true);
						massage29.setBackground(Color.WHITE);
						massage29.setBounds(15+38, 239, 550-38, 25);
						panel_3.add(massage29);}
						else {
							massage29 = new JLabel("");
							massage29.setOpaque(true);
							massage29.setBackground(Color.WHITE);
							massage29.setBounds(15+38, 239, 550-38, 25);
							panel_3.add(massage29);
						}
					}
					else if(i==9 ) {
							if(array3[i]!=null) {
						String temp=array3[i];
						String Temp[]=temp.split("    ");
						massage30=new JLabel(Temp[Temp.length-1]);
						massage30.setOpaque(true);
						massage30.setBackground(Color.WHITE);
						massage30.setBounds(15+38, 267, 550-38, 25);
						panel_3.add(massage30);}
							else {
								massage30 = new JLabel("");
								massage30.setOpaque(true);
								massage30.setBackground(Color.WHITE);
								massage30.setBounds(15+38, 267, 550-38, 25);
								panel_3.add(massage30);
							}
					}
				}
				
				
				String array4[]=new String [10];
				for(int i =30;i<array4.length+30;i++) {
					if(i<s.size()) {
				array4[i%30]=(String)s.get(i);}
					else {array4[i%30]=null;}
				}
				for(int i =0;i<array4.length;i++) {
					if(i==0 ) {
						if( array4[i]!=null) {
					    String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage31=new JLabel(Temp[Temp.length-1]);
						massage31.setOpaque(true);
						massage31.setBackground(Color.WHITE);
						massage31.setBounds(15+38, 15, 550-38, 25);
						panel_4.add(massage31);}
						else {
							massage31 = new JLabel("");
							massage31.setOpaque(true);
							massage31.setBackground(Color.WHITE);
							massage31.setBounds(15+38, 15, 550-38, 25);
							panel_4.add(massage31);
						}
						
					}
					else if(i==1) {
						if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage32=new JLabel(Temp[Temp.length-1]);
						massage32.setOpaque(true);
						massage32.setBackground(Color.WHITE);
						massage32.setBounds(15+38, 43, 550-38, 25);
						panel_4.add(massage32);
						}else {
							massage32 = new JLabel("");
							massage32.setOpaque(true);
							massage32.setBackground(Color.WHITE);
							massage32.setBounds(15+38, 43, 550-38, 25);
							panel_4.add(massage32);
						}
					}
					else if(i==2) {
						if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage33=new JLabel(Temp[Temp.length-1]);
						massage33.setOpaque(true);
						massage33.setBackground(Color.WHITE);
						massage33.setBounds(15+38, 71, 550-38, 25);
						panel_4.add(massage33);}
						else {
							massage33 = new JLabel("");
							massage33.setOpaque(true);
							massage33.setBackground(Color.WHITE);
							massage33.setBounds(15+38, 71, 550-38, 25);
							panel_4.add(massage33);
						}
					}
					else if(i==3 ) {
						if (array4[i]!=null) {
					    String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage34=new JLabel(Temp[Temp.length-1]);
						massage34.setOpaque(true);
						massage34.setBackground(Color.WHITE);
						massage34.setBounds(15+38, 99, 550-38, 25);
						panel_4.add(massage34);}
						else {
							massage34 = new JLabel("");
							massage34.setOpaque(true);
							massage34.setBackground(Color.WHITE);
							massage34.setBounds(15+38, 99, 550-38, 25);
							panel_4.add(massage34);
						}
					}
					else if(i==4 ) {
					  if( array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage35=new JLabel(Temp[Temp.length-1]);
						massage35.setOpaque(true);
						massage35.setBackground(Color.WHITE);
						massage35.setBounds(15+38, 127, 550-38, 25);
						panel_4.add(massage35);}
					  else {
						  massage35 = new JLabel("");
							massage35.setOpaque(true);
							massage35.setBackground(Color.WHITE);
							massage35.setBounds(15+38, 127, 550-38, 25);
							panel_4.add(massage35);
					  }
						
					}
					else if(i==5 ) {
						if( array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage36=new JLabel(Temp[Temp.length-1]);
						massage36.setOpaque(true);
						massage36.setBackground(Color.WHITE);
						massage36.setBounds(15+38, 155, 550-38, 25);
						panel_4.add(massage36);}
						else {
							massage36 = new JLabel("");
							massage36.setOpaque(true);
							massage36.setBackground(Color.WHITE);
							massage36.setBounds(15+38, 155, 550-38, 25);
							panel_4.add(massage36);
						}
					}
					else if(i==6) {
						if( array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage37=new JLabel(Temp[Temp.length-1]);
						massage37.setOpaque(true);
						massage37.setBackground(Color.WHITE);
						massage37.setBounds(15+38, 183, 550-38, 25);
						panel_4.add(massage37);}
						else {
							massage37 = new JLabel("");
							massage37.setOpaque(true);
							massage37.setBackground(Color.WHITE);
							massage37.setBounds(15+38, 183, 550-38, 25);
							panel_4.add(massage37);
						}
					}
					else if(i==7) {
						if (array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage38=new JLabel(Temp[Temp.length-1]);
						massage38.setOpaque(true);
						massage38.setBackground(Color.WHITE);
						massage38.setBounds(15+38, 211, 550-38, 25);
						panel_4.add(massage38);}
						else {
							massage38 = new JLabel("");
							massage38.setOpaque(true);
							massage38.setBackground(Color.WHITE);
							massage38.setBounds(15+38, 211, 550-38, 25);
							panel_4.add(massage38);
						}
					}
					else if(i==8 ) {
						if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage39=new JLabel(Temp[Temp.length-1]);
						massage39.setOpaque(true);
						massage39.setBackground(Color.WHITE);
						massage39.setBounds(15+38, 239, 550-38, 25);
						panel_4.add(massage39);}
						else {
							massage39 = new JLabel("");
							massage39.setOpaque(true);
							massage39.setBackground(Color.WHITE);
							massage39.setBounds(15+38, 239, 550-38, 25);
							panel_4.add(massage39);
						}
					}
					else if(i==9 ) {
							if(array4[i]!=null) {
						String temp=array4[i];
						String Temp[]=temp.split("    ");
						massage40=new JLabel(Temp[Temp.length-1]);
						massage40.setOpaque(true);
						massage40.setBackground(Color.WHITE);
						massage40.setBounds(15+38, 267, 550-38, 25);
						panel_4.add(massage40);}
							else {
								massage40 = new JLabel("");
								massage40.setOpaque(true);
								massage40.setBackground(Color.WHITE);
								massage40.setBounds(15+38, 267, 550-38, 25);
								panel_4.add(massage40);
							}
					}
				}
				
				
				String array5[]=new String [10];
				for(int i =40;i<array5.length+40;i++) {
					if(i<s.size()) {
				array5[i%40]=(String)s.get(i);}
					else {array5[i%40]=null;}
				}
				for(int i =0;i<array5.length;i++) {
					if(i==0 ) {
						if( array5[i]!=null) {
					    String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage41=new JLabel(Temp[Temp.length-1]);
						massage41.setOpaque(true);
						massage41.setBackground(Color.WHITE);
						massage41.setBounds(15+38, 15, 550-38, 25);
						panel_5.add(massage41);}
						else {
							massage41 = new JLabel("");
							massage41.setOpaque(true);
							massage41.setBackground(Color.WHITE);
							massage41.setBounds(15+38, 15, 550-38, 25);
							panel_5.add(massage41);
						}
						
					}
					else if(i==1) {
						if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage42=new JLabel(Temp[Temp.length-1]);
						massage42.setOpaque(true);
						massage42.setBackground(Color.WHITE);
						massage42.setBounds(15+38, 43, 550-38, 25);
						panel_5.add(massage42);
						}else {
							massage42 = new JLabel("");
							massage42.setOpaque(true);
							massage42.setBackground(Color.WHITE);
							massage42.setBounds(15+38, 43, 550-38, 25);
							panel_5.add(massage42);
						}
					}
					else if(i==2) {
						if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage43=new JLabel(Temp[Temp.length-1]);
						massage43.setOpaque(true);
						massage43.setBackground(Color.WHITE);
						massage43.setBounds(15+38, 71, 550-38, 25);
						panel_5.add(massage43);}
						else {
							massage43 = new JLabel("");
							massage43.setOpaque(true);
							massage43.setBackground(Color.WHITE);
							massage43.setBounds(15+38, 71, 550-38, 25);
							panel_5.add(massage43);
						}
					}
					else if(i==3 ) {
						if (array5[i]!=null) {
					    String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage44=new JLabel(Temp[Temp.length-1]);
						massage44.setOpaque(true);
						massage44.setBackground(Color.WHITE);
						massage44.setBounds(15+38, 99, 550-38, 25);
						panel_5.add(massage44);}
						else {
							massage44 = new JLabel("");
							massage44.setOpaque(true);
							massage44.setBackground(Color.WHITE);
							massage44.setBounds(15+38, 99, 550-38, 25);
							panel_5.add(massage44);
						}
					}
					else if(i==4 ) {
					  if( array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage45=new JLabel(Temp[Temp.length-1]);
						massage45.setOpaque(true);
						massage45.setBackground(Color.WHITE);
						massage45.setBounds(15+38, 127, 550-38, 25);
						panel_5.add(massage45);}
					  else {
						    massage45 = new JLabel("");
							massage45.setOpaque(true);
							massage45.setBackground(Color.WHITE);
							massage45.setBounds(15+38, 127, 550-38, 25);
							panel_5.add(massage45);
					  }
						
					}
					else if(i==5 ) {
						if( array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage46=new JLabel(Temp[Temp.length-1]);
						massage46.setOpaque(true);
						massage46.setBackground(Color.WHITE);
						massage46.setBounds(15+38, 155, 550-38, 25);
						panel_5.add(massage46);}
						else {
							massage46 = new JLabel("");
							massage46.setOpaque(true);
							massage46.setBackground(Color.WHITE);
							massage46.setBounds(15+38, 155, 550-38, 25);
							panel_5.add(massage46);
						}
					}
					else if(i==6) {
						if( array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage47=new JLabel(Temp[Temp.length-1]);
						massage47.setOpaque(true);
						massage47.setBackground(Color.WHITE);
						massage47.setBounds(15+38, 183, 550-38, 25);
						panel_5.add(massage47);}
						else {
							massage47 = new JLabel("");
							massage47.setOpaque(true);
							massage47.setBackground(Color.WHITE);
							massage47.setBounds(15+38, 183, 550-38, 25);
							panel_5.add(massage47);
						}
					}
					else if(i==7) {
						if (array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage48=new JLabel(Temp[Temp.length-1]);
						massage48.setOpaque(true);
						massage48.setBackground(Color.WHITE);
						massage48.setBounds(15+38, 211, 550-38, 25);
						panel_5.add(massage48);}
						else {
							massage48 = new JLabel("");
							massage48.setOpaque(true);
							massage48.setBackground(Color.WHITE);
							massage48.setBounds(15+38, 211, 550-38, 25);
							panel_5.add(massage48);
						}
					}
					else if(i==8 ) {
						if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage49=new JLabel(Temp[Temp.length-1]);
						massage49.setOpaque(true);
						massage49.setBackground(Color.WHITE);
						massage49.setBounds(15+38, 239, 550-38, 25);
						panel_5.add(massage49);}
						else {
							massage49 = new JLabel("");
							massage49.setOpaque(true);
							massage49.setBackground(Color.WHITE);
							massage49.setBounds(15+38, 239, 550-38, 25);
							panel_5.add(massage49);
						}
					}
					else if(i==9 ) {
							if(array5[i]!=null) {
						String temp=array5[i];
						String Temp[]=temp.split("    ");
						massage50=new JLabel(Temp[Temp.length-1]);
						massage50.setOpaque(true);
						massage50.setBackground(Color.WHITE);
						massage50.setBounds(15+38, 267, 550-38, 25);
						panel_5.add(massage50);}
							else {
								massage50 = new JLabel("");
								massage50.setOpaque(true);
								massage50.setBackground(Color.WHITE);
								massage50.setBounds(15+38, 267, 550-38, 25);
								panel_5.add(massage50);
							}
					}
				}
				
				
				JButton button = new JButton("view");
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage1.getText()!="") {
							watch w = new watch(massage1.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button.setBounds(577, 15, 85, 25);
				panel_1.add(button);
				
				JButton button_1 = new JButton("view");
				button_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage2.getText()!="") {
							watch w = new watch(massage2.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_1.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_1.setBounds(577, 43, 85, 25);
				panel_1.add(button_1);
				
				JButton button_2 = new JButton("view");
				button_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage3.getText()!="") {
							watch w = new watch(massage3.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_2.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_2.setBounds(577, 71, 85, 25);
				panel_1.add(button_2);
				
				JButton button_3 = new JButton("view");
				button_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage4.getText()!="") {
							watch w = new watch(massage4.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_3.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_3.setBounds(577, 99, 85, 25);
				panel_1.add(button_3);
				
				JButton button_4 = new JButton("view");
				button_4.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage5.getText()!="") {
							watch w = new watch(massage5.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_4.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_4.setBounds(577, 127, 85, 25);
				panel_1.add(button_4);
				
				JButton button_5 = new JButton("view");
				button_5.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage6.getText()!="") {
							watch w = new watch(massage6.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_5.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_5.setBounds(577, 155, 85, 25);
				panel_1.add(button_5);
				
				JButton button_6 = new JButton("view");
				button_6.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage7.getText()!="") {
							watch w = new watch(massage7.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_6.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_6.setBounds(577, 183, 85, 25);
				panel_1.add(button_6);
				
				JButton button_7 = new JButton("view");
				button_7.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage8.getText()!="") {
							watch w = new watch(massage8.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_7.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_7.setBounds(577, 211, 85, 25);
				panel_1.add(button_7);
				
				JButton button_8 = new JButton("view");
				button_8.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage9.getText()!="") {
							watch w = new watch(massage9.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_8.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_8.setBounds(577, 239, 85, 25);
				panel_1.add(button_8);
				
				JButton button_9 = new JButton("view");
				button_9.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage10.getText()!="") {
							watch w = new watch(massage10.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_9.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_9.setBounds(577, 267, 85, 25);
				panel_1.add(button_9);
				
				c1 = new JCheckBox("1");
				c1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
				c1.setBounds(8, 15, 43, 25);
				panel_1.add(c1);
				
				c2 = new JCheckBox("2");
				c2.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
				c2.setBounds(8, 43, 43, 25);
				panel_1.add(c2);
				
				c3 = new JCheckBox("3");
				c3.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
				c3.setBounds(8, 71, 43, 25);
				panel_1.add(c3);
				
				c4 = new JCheckBox("4");
				c4.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
				c4.setBounds(8, 99, 43, 25);
				panel_1.add(c4);
				
				c5 = new JCheckBox("5");
				c5.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
				c5.setBounds(8, 127, 43, 25);
				panel_1.add(c5);
				
				c6 = new JCheckBox("6");
				c6.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
				c6.setBounds(8, 155, 43, 25);
				panel_1.add(c6);
				
				c7 = new JCheckBox("7");
				c7.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 20));
				c7.setBounds(8, 183, 43, 25);
				panel_1.add(c7);
				
				c8 = new JCheckBox("8");
				c8.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
				c8.setBounds(8, 211, 43, 25);
				panel_1.add(c8);
				
				c9 = new JCheckBox("9");
				c9.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
				c9.setBounds(8, 239, 43, 25);
				panel_1.add(c9);
				
				c10 = new JCheckBox("10");
				c10.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c10.setBounds(8, 267, 43, 25);
				panel_1.add(c10);
				
				
				JButton button_10 = new JButton("view");
				button_10.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage11.getText()!="") {
							watch w = new watch(massage11.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_10.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_10.setBounds(577, 15, 85, 25);
				panel_2.add(button_10);
				
				JButton button_11 = new JButton("view");
				button_11.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage12.getText()!="") {
							watch w = new watch(massage12.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_11.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_11.setBounds(577, 43, 85, 25);
				panel_2.add(button_11);
				
				JButton button_12 = new JButton("view");
				button_12.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage13.getText()!="") {
							watch w = new watch(massage13.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_12.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_12.setBounds(577, 71, 85, 25);
				panel_2.add(button_12);
				
				JButton button_13 = new JButton("view");
				button_13.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage14.getText()!="") {
							watch w = new watch(massage14.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_13.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_13.setBounds(577, 99, 85, 25);
				panel_2.add(button_13);
				
				JButton button_14 = new JButton("view");
				button_14.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage15.getText()!="") {
							watch w = new watch(massage15.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_14.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_14.setBounds(577, 127, 85, 25);
				panel_2.add(button_14);
				
				JButton button_15 = new JButton("view");
				button_15.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage16.getText()!="") {
							watch w = new watch(massage16.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_15.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_15.setBounds(577, 155, 85, 25);
				panel_2.add(button_15);
				
				JButton button_16 = new JButton("view");
				button_16.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage17.getText()!="") {
							watch w = new watch(massage17.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_16.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_16.setBounds(577, 183, 85, 25);
				panel_2.add(button_16);
				
				JButton button_17 = new JButton("view");
				button_17.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage18.getText()!="") {
							watch w = new watch(massage18.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_17.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_17.setBounds(577, 211, 85, 25);
				panel_2.add(button_17);
				
				JButton button_18 = new JButton("view");
				button_18.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage19.getText()!="") {
							watch w = new watch(massage19.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_18.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_18.setBounds(577, 239, 85, 25);
				panel_2.add(button_18);
				
				JButton button_19 = new JButton("view");
				button_19.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage20.getText()!="") {
							watch w = new watch(massage20.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_19.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_19.setBounds(577, 267, 85, 25);
				panel_2.add(button_19);
				
				c11 = new JCheckBox("11");
				c11.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c11.setBounds(8, 15, 43, 25);
				panel_2.add(c11);
				
				c12 = new JCheckBox("12");
				c12.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c12.setBounds(8, 43, 43, 25);
				panel_2.add(c12);
				
				c13 = new JCheckBox("13");
				c13.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c13.setBounds(8, 71, 43, 25);
				panel_2.add(c13);
				
				c14 = new JCheckBox("14");
				c14.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c14.setBounds(8, 99, 43, 25);
				panel_2.add(c14);
				
				c15 = new JCheckBox("15");
				c15.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c15.setBounds(8, 127, 43, 25);
				panel_2.add(c15);
				
				c16 = new JCheckBox("16");
				c16.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c16.setBounds(8, 155, 43, 25);
				panel_2.add(c16);
				
				c17 = new JCheckBox("17");
				c17.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c17.setBounds(8, 183, 43, 25);
				panel_2.add(c17);
				
				c18 = new JCheckBox("18");
				c18.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c18.setBounds(8, 211, 43, 25);
				panel_2.add(c18);
				
				c19 = new JCheckBox("19");
				c19.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c19.setBounds(8, 239, 43, 25);
				panel_2.add(c19);
				
				c20 = new JCheckBox("20");
				c20.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c20.setBounds(8, 267, 43, 25);
				panel_2.add(c20);
				
				
				
				JButton button_20 = new JButton("view");
				button_20.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage21.getText()!="") {
							watch w = new watch(massage21.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_20.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_20.setBounds(577, 15, 85, 25);
				panel_3.add(button_20);
				
				JButton button_21 = new JButton("view");
				button_21.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage22.getText()!="") {
							watch w = new watch(massage22.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_21.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_21.setBounds(577, 43, 85, 25);
				panel_3.add(button_21);
				
				JButton button_22 = new JButton("view");
				button_22.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage23.getText()!="") {
							watch w = new watch(massage23.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_22.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_22.setBounds(577, 71, 85, 25);
				panel_3.add(button_22);
				
				JButton button_23 = new JButton("view");
				button_23.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage24.getText()!="") {
							watch w = new watch(massage24.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_23.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_23.setBounds(577, 99, 85, 25);
				panel_3.add(button_23);
				
				JButton button_24 = new JButton("view");
				button_24.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage25.getText()!="") {
							watch w = new watch(massage25.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_24.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_24.setBounds(577, 127, 85, 25);
				panel_3.add(button_24);
				
				JButton button_25 = new JButton("view");
				button_25.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage26.getText()!="") {
							watch w = new watch(massage26.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_25.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_25.setBounds(577, 155, 85, 25);
				panel_3.add(button_25);
				
				JButton button_26 = new JButton("view");
				button_26.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage27.getText()!="") {
							watch w = new watch(massage27.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_26.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_26.setBounds(577, 183, 85, 25);
				panel_3.add(button_26);
				
				JButton button_27 = new JButton("view");
				button_27.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage28.getText()!="") {
							watch w = new watch(massage28.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_27.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_27.setBounds(577, 211, 85, 25);
				panel_3.add(button_27);
				
				JButton button_28 = new JButton("view");
				button_28.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage29.getText()!="") {
							watch w = new watch(massage29.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_28.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_28.setBounds(577, 239, 85, 25);
				panel_3.add(button_28);
				
				JButton button_29 = new JButton("view");
				button_29.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage30.getText()!="") {
							watch w = new watch(massage30.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_29.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_29.setBounds(577, 267, 85, 25);
				panel_3.add(button_29);
				
				c21 = new JCheckBox("21");
				c21.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c21.setBounds(8, 15, 43, 25);
				panel_3.add(c21);
				
				c22 = new JCheckBox("22");
				c22.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c22.setBounds(8, 43, 43, 25);
				panel_3.add(c22);
				
				c23 = new JCheckBox("23");
				c23.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c23.setBounds(8, 71, 43, 25);
				panel_3.add(c23);
				
				c24 = new JCheckBox("24");
				c24.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c24.setBounds(8, 99, 43, 25);
				panel_3.add(c24);
				
				c25 = new JCheckBox("25");
				c25.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c25.setBounds(8, 127, 43, 25);
				panel_3.add(c25);
				
				c26 = new JCheckBox("26");
				c26.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c26.setBounds(8, 155, 43, 25);
				panel_3.add(c26);
				
				c27 = new JCheckBox("27");
				c27.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c27.setBounds(8, 183, 43, 25);
				panel_3.add(c27);
				
				c28 = new JCheckBox("28");
				c28.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c28.setBounds(8, 211, 43, 25);
				panel_3.add(c28);
				
				c29 = new JCheckBox("29");
				c29.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c29.setBounds(8, 239, 43, 25);
				panel_3.add(c29);
				
				c30 = new JCheckBox("30");
				c30.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c30.setBounds(8, 267, 43, 25);
				panel_3.add(c30);
				
				JButton button_30 = new JButton("view");
				button_30.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage31.getText()!="") {
							watch w = new watch(massage31.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_30.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_30.setBounds(577, 15, 85, 25);
				panel_4.add(button_30);
				
				JButton button_31 = new JButton("view");
				button_31.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage32.getText()!="") {
							watch w = new watch(massage32.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_31.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_31.setBounds(577, 43, 85, 25);
				panel_4.add(button_31);
				
				JButton button_32 = new JButton("view");
				button_32.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage33.getText()!="") {
							watch w = new watch(massage33.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_32.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_32.setBounds(577, 71, 85, 25);
				panel_4.add(button_32);
				
				JButton button_33 = new JButton("view");
				button_33.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage34.getText()!="") {
							watch w = new watch(massage34.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_33.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_33.setBounds(577, 99, 85, 25);
				panel_4.add(button_33);
				
				JButton button_34 = new JButton("view");
				button_34.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage35.getText()!="") {
							watch w = new watch(massage35.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_34.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_34.setBounds(577, 127, 85, 25);
				panel_4.add(button_34);
				
				JButton button_35 = new JButton("view");
				button_35.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage36.getText()!="") {
							watch w = new watch(massage36.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_35.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_35.setBounds(577, 155, 85, 25);
				panel_4.add(button_35);
				
				JButton button_36 = new JButton("view");
				button_36.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage37.getText()!="") {
							watch w = new watch(massage37.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_36.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_36.setBounds(577, 183, 85, 25);
				panel_4.add(button_36);
				
				JButton button_37 = new JButton("view");
				button_37.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage38.getText()!="") {
							watch w = new watch(massage38.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_37.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_37.setBounds(577, 211, 85, 25);
				panel_4.add(button_37);
				
				JButton button_38 = new JButton("view");
				button_38.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage39.getText()!="") {
							watch w = new watch(massage39.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_38.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_38.setBounds(577, 239, 85, 25);
				panel_4.add(button_38);
				
				JButton button_39 = new JButton("view");
				button_39.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage40.getText()!="") {
							watch w = new watch(massage40.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_39.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_39.setBounds(577, 267, 85, 25);
				panel_4.add(button_39);
				
				c31 = new JCheckBox("31");
				c31.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c31.setBounds(8, 15, 43, 25);
				panel_4.add(c31);
				
				c32 = new JCheckBox("32");
				c32.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c32.setBounds(8, 43, 43, 25);
				panel_4.add(c32);
				
				c33 = new JCheckBox("33");
				c33.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c33.setBounds(8, 71, 43, 25);
				panel_4.add(c33);
				
				c34 = new JCheckBox("34");
				c34.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c34.setBounds(8, 99, 43, 25);
				panel_4.add(c34);
				
				c35 = new JCheckBox("35");
				c35.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c35.setBounds(8, 127, 43, 25);
				panel_4.add(c35);
				
				c36 = new JCheckBox("36");
				c36.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c36.setBounds(8, 155, 43, 25);
				panel_4.add(c36);
				
				c37 = new JCheckBox("37");
				c37.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c37.setBounds(8, 183, 43, 25);
				panel_4.add(c37);
				
				c38 = new JCheckBox("38");
				c38.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c38.setBounds(8, 211, 43, 25);
				panel_4.add(c38);
				
				c39 = new JCheckBox("39");
				c39.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c39.setBounds(8, 239, 43, 25);
				panel_4.add(c39);
				
				c40 = new JCheckBox("40");
				c40.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c40.setBounds(8, 267, 43, 25);
				panel_4.add(c40);
				
				
				
				JButton button_40 = new JButton("view");
				button_40.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage41.getText()!="") {
							watch w = new watch(massage41.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_40.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_40.setBounds(577, 15, 85, 25);
				panel_5.add(button_40);
				
				JButton button_41 = new JButton("view");
				button_41.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage42.getText()!="") {
							watch w = new watch(massage42.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_41.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_41.setBounds(577, 43, 85, 25);
				panel_5.add(button_41);
				
				JButton button_42 = new JButton("view");
				button_42.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage43.getText()!="") {
							watch w = new watch(massage43.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_42.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_42.setBounds(577, 71, 85, 25);
				panel_5.add(button_42);
				
				JButton button_43 = new JButton("view");
				button_43.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage44.getText()!="") {
							watch w = new watch(massage44.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_43.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_43.setBounds(577, 99, 85, 25);
				panel_5.add(button_43);
				
				JButton button_44 = new JButton("view");
				button_44.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage45.getText()!="") {
							watch w = new watch(massage45.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_44.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_44.setBounds(577, 127, 85, 25);
				panel_5.add(button_44);
				
				JButton button_45 = new JButton("view");
				button_45.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage46.getText()!="") {
							watch w = new watch(massage46.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_45.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_45.setBounds(577, 155, 85, 25);
				panel_5.add(button_45);
				
				JButton button_46 = new JButton("view");
				button_46.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage47.getText()!="") {
							watch w = new watch(massage47.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_46.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_46.setBounds(577, 183, 85, 25);
				panel_5.add(button_46);
				
				JButton button_47 = new JButton("view");
				button_47.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage48.getText()!="") {
							watch w = new watch(massage48.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_47.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_47.setBounds(577, 211, 85, 25);
				panel_5.add(button_47);
				
				JButton button_48 = new JButton("view");
				button_48.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage49.getText()!="") {
							watch w = new watch(massage49.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_48.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_48.setBounds(577, 239, 85, 25);
				panel_5.add(button_48);
				
				JButton button_49 = new JButton("view");
				button_49.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(massage50.getText()!="") {
							watch w = new watch(massage50.getText(),prefolder);
							w.setVisible(true);
						}
						else {
							JOptionPane.showMessageDialog(null, "The massage don't exist");
						}
					}
				});
				button_49.setFont(new Font("Snap ITC", Font.PLAIN, 16));
				button_49.setBounds(577, 267, 85, 25);
				panel_5.add(button_49);
				
				c41 = new JCheckBox("41");
				c41.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c41.setBounds(8, 15, 43, 25);
				panel_5.add(c41);
				
				c42 = new JCheckBox("42");
				c42.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c42.setBounds(8, 43, 43, 25);
				panel_5.add(c42);
				
				c43 = new JCheckBox("43");
				c43.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c43.setBounds(8, 71, 43, 25);
				panel_5.add(c43);
				
				c44 = new JCheckBox("44");
				c44.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c44.setBounds(8, 99, 43, 25);
				panel_5.add(c44);
				
				c45 = new JCheckBox("45");
				c45.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c45.setBounds(8, 127, 43, 25);
				panel_5.add(c45);
				
				c46 = new JCheckBox("46");
				c46.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c46.setBounds(8, 155, 43, 25);
				panel_5.add(c46);
				
				c47 = new JCheckBox("47");
				c47.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c47.setBounds(8, 183, 43, 25);
				panel_5.add(c47);
				
				c48 = new JCheckBox("48");
				c48.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c48.setBounds(8, 211, 43, 25);
				panel_5.add(c48);
				
				c49 = new JCheckBox("49");
				c49.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c49.setBounds(8, 239, 43, 25);
				panel_5.add(c49);
				
				c50 = new JCheckBox("50");
				c50.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 15));
				c50.setBounds(8, 267, 43, 25);
				panel_5.add(c50);
				
				JButton OK = new JButton("OK");
				OK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Singly_Linked_list t = new Singly_Linked_list();
						if(c1.isSelected() && massage1.getText().toString()!="") {t.add(s.get(0));}
						if(c2.isSelected() && massage2.getText().toString()!="") {t.add(s.get(1));}
						if(c3.isSelected() && massage3.getText().toString()!="") {t.add(s.get(2));}
						if(c4.isSelected() && massage4.getText().toString()!="") {t.add(s.get(3));}
						if(c5.isSelected() && massage5.getText().toString()!="") {t.add(s.get(4));}
						if(c6.isSelected() && massage6.getText().toString()!="") {t.add(s.get(5));}
						if(c7.isSelected() && massage7.getText().toString()!="") {t.add(s.get(6));}
						if(c8.isSelected() && massage8.getText().toString()!="") {t.add(s.get(7));}
						if(c9.isSelected() && massage9.getText().toString()!="") {t.add(s.get(8));}
						if(c10.isSelected() && massage10.getText().toString()!="") {t.add(s.get(9));}
						if(c11.isSelected() && massage11.getText().toString()!="") {t.add(s.get(10));}
						if(c12.isSelected() && massage12.getText().toString()!="") {t.add(s.get(11));}
						if(c13.isSelected() && massage13.getText().toString()!="") {t.add(s.get(12));}
						if(c14.isSelected() && massage14.getText().toString()!="") {t.add(s.get(13));}
						if(c15.isSelected() && massage15.getText().toString()!="") {t.add(s.get(14));}
						if(c16.isSelected() && massage16.getText().toString()!="") {t.add(s.get(15));}
						if(c17.isSelected() && massage17.getText().toString()!="") {t.add(s.get(16));}
						if(c18.isSelected() && massage18.getText().toString()!="") {t.add(s.get(17));}
						if(c19.isSelected() && massage19.getText().toString()!="") {t.add(s.get(18));}
						if(c20.isSelected() && massage20.getText().toString()!="") {t.add(s.get(19));}
						if(c21.isSelected() && massage21.getText().toString()!="") {t.add(s.get(20));}
						if(c22.isSelected() && massage22.getText().toString()!="") {t.add(s.get(21));}
						if(c23.isSelected() && massage23.getText().toString()!="") {t.add(s.get(22));}
						if(c24.isSelected() && massage24.getText().toString()!="") {t.add(s.get(23));}
						if(c25.isSelected() && massage25.getText().toString()!="") {t.add(s.get(24));}
						if(c26.isSelected() && massage26.getText().toString()!="") {t.add(s.get(25));}
						if(c27.isSelected() && massage27.getText().toString()!="") {t.add(s.get(26));}
						if(c28.isSelected() && massage28.getText().toString()!="") {t.add(s.get(27));}
						if(c29.isSelected() && massage29.getText().toString()!="") {t.add(s.get(28));}
						if(c30.isSelected() && massage30.getText().toString()!="") {t.add(s.get(29));}
						if(c31.isSelected() && massage31.getText().toString()!="") {t.add(s.get(30));}
						if(c32.isSelected() && massage32.getText().toString()!="") {t.add(s.get(31));}
						if(c33.isSelected() && massage33.getText().toString()!="") {t.add(s.get(32));}
						if(c34.isSelected() && massage34.getText().toString()!="") {t.add(s.get(33));}
						if(c35.isSelected() && massage35.getText().toString()!="") {t.add(s.get(34));}
						if(c36.isSelected() && massage36.getText().toString()!="") {t.add(s.get(35));}
						if(c37.isSelected() && massage37.getText().toString()!="") {t.add(s.get(36));}
						if(c38.isSelected() && massage38.getText().toString()!="") {t.add(s.get(37));}
						if(c39.isSelected() && massage39.getText().toString()!="") {t.add(s.get(38));}
						if(c40.isSelected() && massage40.getText().toString()!="") {t.add(s.get(39));}
						if(c41.isSelected() && massage41.getText().toString()!="") {t.add(s.get(40));}
						if(c42.isSelected() && massage42.getText().toString()!="") {t.add(s.get(41));}
						if(c43.isSelected() && massage43.getText().toString()!="") {t.add(s.get(42));}
						if(c44.isSelected() && massage44.getText().toString()!="") {t.add(s.get(43));}
						if(c45.isSelected() && massage45.getText().toString()!="") {t.add(s.get(44));}
						if(c46.isSelected() && massage46.getText().toString()!="") {t.add(s.get(45));}
						if(c47.isSelected() && massage47.getText().toString()!="") {t.add(s.get(46));}
						if(c48.isSelected() && massage48.getText().toString()!="") {t.add(s.get(47));}
						if(c49.isSelected() && massage49.getText().toString()!="") {t.add(s.get(48));}
						if(c50.isSelected() && massage50.getText().toString()!="") {t.add(s.get(49));}
						if(t.isEmpty()) {
							JOptionPane.showMessageDialog(null, "No massage Selected");
						}
						else {
							if(ff==null) {
							Singly_Linked_list m=new  Singly_Linked_list();
							for(int i = 0;i<t.size();i++) {
								String email[]=t.get(i).toString().split("    ");
								Mail newMail = a.LoadMail(a.GetUser(), email[5],prefolder );
								m.add(newMail);
							}
							m.add(prefolder);
							a.deleteEmails(m);
							dispose();}
							else {
								Singly_Linked_list m=new  Singly_Linked_list();
								for(int i = 0;i<t.size();i++) {
									String email[]=t.get(i).toString().split("    ");
									Mail newMail = a.LoadMail(a.GetUser(), email[5],prefolder );
									m.add(newMail);
								}
								m.add(prefolder);
								a.moveEmails(m, ff);
								dispose();}
							}
					}
				});
				OK.setBounds(new Rectangle(10, 10, 10, 10));
				OK.setSelected(true);
				OK.setFont(new Font("Snap ITC", Font.BOLD, 25));
				OK.setBounds(637, 602, 118, 28);
				contentPane.add(OK);
				
				
				JButton btnNewButton_1 = new JButton("Exit");
				btnNewButton_1.addActionListener(new ActionListener() {
					
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnNewButton_1.setForeground(Color.DARK_GRAY);
				btnNewButton_1.setBackground(Color.CYAN);
				btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.ITALIC, 25));
				btnNewButton_1.setBounds(35, 602, 97, 25);
				contentPane.add(btnNewButton_1);
			}
			public void switchpanel( JPanel panel) {
				panellll.removeAll();
				panellll.add(panel);
				panellll.repaint();
				panellll.revalidate();
			}
		}
		
		public class move extends JFrame {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			private JPanel contentPane;
			private JTextField textField;
			private JRadioButton inbox;
			private JRadioButton draft;
			private JRadioButton Trash;
		    

			/**
			 * Create the frame.
			 */
			public move() {
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setBounds(100, 100, 600, 300);
				contentPane = new JPanel();
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				
				JPanel panel = new JPanel();
				panel.setBackground(new Color(0, 0, 0));
				panel.setForeground(new Color(34, 139, 34));
				panel.setBounds(0, 0, 582, 253);
				contentPane.add(panel);
				panel.setLayout(null);
				
				JLabel lblNewLabel = new JLabel("TO");
				lblNewLabel.setBackground(new Color(255, 255, 0));
				lblNewLabel.setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
				lblNewLabel.setOpaque(true);
				lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel.setBounds(12, 26, 113, 40);
				panel.add(lblNewLabel);
				
				textField = new JTextField();
				textField.setFont(new Font("Tahoma", Font.PLAIN, 20));
				textField.setBounds(152, 26, 405, 40);
				panel.add(textField);
				textField.setColumns(10);
				
				JLabel lblFolder = new JLabel("Folder");
				lblFolder.setOpaque(true);
				lblFolder.setHorizontalAlignment(SwingConstants.CENTER);
				lblFolder.setFont(new Font("Viner Hand ITC", Font.PLAIN, 25));
				lblFolder.setBackground(Color.YELLOW);
				lblFolder.setBounds(12, 106, 113, 40);
				panel.add(lblFolder);
				
				inbox = new JRadioButton("Inbox");
				inbox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						if(inbox.isSelected()) {
							draft.setSelected(false);
							Trash.setSelected(false);
						}
					}
				});
				inbox.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				inbox.setHorizontalAlignment(SwingConstants.CENTER);
				inbox.setBackground(new Color(255, 0, 0));
				inbox.setBounds(152, 114, 107, 25);
				panel.add(inbox);
				
				draft = new JRadioButton("draft");
				draft.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(draft.isSelected()) {
							inbox.setSelected(false);
							Trash.setSelected(false);
						}
					}
				});
				draft.setHorizontalAlignment(SwingConstants.CENTER);
				draft.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				draft.setBackground(Color.RED);
				draft.setBounds(309, 114, 107, 25);
				panel.add(draft);
				
				Trash = new JRadioButton("Trash");
				Trash.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(Trash.isSelected()) {
							inbox.setSelected(false);
							draft.setSelected(false);
						}
					}
				});
				Trash.setHorizontalAlignment(SwingConstants.CENTER);
				Trash.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 20));
				Trash.setBackground(Color.RED);
				Trash.setBounds(450, 114, 107, 25);
				panel.add(Trash);
				
				JButton btnNewButton = new JButton("OK");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String temp=textField.getText().toString();
						if(textField.getText().toString().length()<=0) {
							JOptionPane.showMessageDialog(null, "You Should Enter E-mail");
						}else if (!Files.exists(Paths.get("E:\\Users\\"+temp+"\\"))) {
							JOptionPane.showMessageDialog(null, "The E-mail is illegal");
						}else if(!draft.isSelected() &&!Trash.isSelected() && !inbox.isSelected()) {
							JOptionPane.showMessageDialog(null, "You Should Choose Folder");
						}else {
							sort ss = new sort();
							Folder f=new Folder();
							filter f1=new filter();
							f.SetUser(a.GetUser());
							f.SetFoldername("Inbox");
							ss.setSorting("1");
							f1.Setkindfilter("null");
							Singly_Linked_list s = new Singly_Linked_list();
							s=(Singly_Linked_list)a.setViewingOptions(f, f1, ss);
							StringBuilder prev=new StringBuilder(f.GetFolderName()+"    ");
							if(ss.getSorting()!=null) {
								prev.append(ss.getSorting()+"    ");
							}else {
								prev.append("null    ");
							}
							if(f1.getkindfilter()!=null && f1.getkindfilter()!="null") {
								prev.append(f1.getkindfilter()+"    "+f1.getnamefilter());
							}else {
								prev.append("null    null");
							}
							String previous=prev.toString();
							s.add(previous); 
							Folder ff = new Folder();
							ff.SetUser(temp);
							if(inbox.isSelected()) {
							ff.SetFoldername("Inbox");}
							else if(draft.isSelected()) {
								ff.SetFoldername("Draft");}
							else if(Trash.isSelected()) {
								ff.SetFoldername("Trash");}
							oparate v = new oparate(s,ff);
							v.setVisible(true);
							dispose();
						}
					}
				});
				btnNewButton.setForeground(new Color(0, 0, 0));
				btnNewButton.setBackground(new Color(0, 255, 0));
				btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
				btnNewButton.setBounds(152, 178, 275, 50);
				panel.add(btnNewButton);
			}
		}
}

