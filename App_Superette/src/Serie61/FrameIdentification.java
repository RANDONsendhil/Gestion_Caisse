package Serie61;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import IPane.ES;
import javafx.scene.layout.GridPane;

public class FrameIdentification extends JFrame implements ActionListener {
	
		ES ES = new ES();
	
		JTextField user = new JTextField(10);
		JPasswordField pwd = new JPasswordField(10);
		JButton valider = new JButton();
		JButton fin = new JButton();
		JButton raz = new JButton();
		 
	public ImageIcon recup(String chemin){
		return new ImageIcon(ImageIcon.class.getResource(chemin));
	}
	
	public FrameIdentification(){
	
		
		
		// to add images //
		
         ImageIcon image = recup("/Image/logo.png");
		 JLabel lab1 = new JLabel(image);
		 JPanel  pan0 = new JPanel();
		 pan0.add(lab1);
		 this.add(pan0);
		  
		 
		 /// Adding user pane and text field for userName ////
		 
		 
		
		 JPanel pan1 = new JPanel();
		 JLabel username = new JLabel("USERNAME: ");
		 pan1.add(username);pan1.add(user);
		 this.add(pan1);
		 user.addActionListener(this);
		 
		 
		 JPanel pan2 = new JPanel();
		 JLabel motP = new JLabel("PASSWORD: ");
		 pan2.add(motP);pan2.add(pwd);
		 this.add(pan2);
		 pwd.addActionListener(this);
		 
		 
		 
		 
		 JPanel pan3 = new JPanel();
		 pan3.add(valider);
		 pan3.add(fin); 
		 pan3.add(raz);
		 this.add(pan3);
		
		 valider.setText("VALIDER");
		 fin.setText("FIN");
		 raz.setText("RESET");
		 
		 valider.addActionListener(this);
		 fin.addActionListener(this);
		 raz.addActionListener(this);
		
		 
		 

			this.setLayout(new GridLayout(5,5,1,1));
			this.setSize(400,370);
			this.setTitle("FRAME IDENTIFICATION");
			this.setVisible(true);
			this.setLocationRelativeTo(null);
		
	}

	 
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getSource()==valider  || evt.getSource() == pwd){
			ES.affiche("CONTROLLER LE MOT DE PASSE !");			
			String userS=  user.getText();
			char mdpS[] = pwd.getPassword();
			String mdpR = recup(mdpS);
			if(verif(userS, mdpR)){
				ES.affiche("MOT DE PASSE VALIDE !");
				
				new ClientSerie61();
				this.setVisible(false);
				}else{
					 ES.affiche("VEUILLEZ ENTRER UNE IDENTIFICATION ET LE MOT DE PASSE VALIDE");
					//raz();
					
				}
			
			
		}
		
		if(evt.getSource() == fin){
			ES.affiche("AUREVOIR ET A BIENTOT !"); System.exit(0);		}
		
		if(evt.getSource() == raz){
			
			raz();
		}
		 
	}


	private boolean verif(String userS, String pwd) {
		 
		return (userS.equals("")&&(pwd.equals("")));
	}


	public  void  raz() {
	 
		  pwd.setText("");user.setText("");
		  
		 		
	}


	public String recup(char[] tab) {
		 String mes ="";		
		 
		 for(int i = 0; i<tab.length; i++){
			 
			 mes = mes+tab[i];
		 }
		 
		 return mes;
	}
}
 