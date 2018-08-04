package Serie61;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import Serie53.TablesDesArticles53;
public class ClientSerie61 extends JFrame implements ActionListener{
 
	
 FrameGestionTableArticles FGT = new  FrameGestionTableArticles ("TablesDesArticles.data");
TablesDesArticles53   tabArt = FGT.recupere();
  
	
  ES ES = new ES();
 
 
  
  JButton b1 = new JButton("GESTION DES ARTICLES");
  JButton b2 = new JButton("GESTION DES COMMANDES");
  JButton b3 = new JButton("GESTION DES FACTURES");
  JButton b4 = new JButton("GESTION DES CLIENT");
  JButton b5 = new JButton("FIN");
  
  
  
  
  
	public static void main(String[]args){
		
		
		new FrameIdentification();
		
		
		
	}
	
	public ImageIcon recup(String chemin){
		return new ImageIcon(ImageIcon.class.getResource(chemin));
	}
	
	
	public ClientSerie61(){
		
		
		 ImageIcon image = recup("/Image/logo.png");
		 JLabel lab1 = new JLabel(image);
		 JPanel  pan0 = new JPanel();
		 pan0.add(lab1);
		 this.add(pan0);
		 
		 
		 
		 
	 
		this.setLayout(new GridLayout(3,1,10,10));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		 
		this.add(b1);this.add(b2);this.add(b3);this.add(b4);this.add(b5);
		this.setTitle("MENU PRINCIPAL");
		setSize(600,550);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
		
	}
	
	public void actionPerformed(ActionEvent evt) {
		 FrameGestionTableArticles frg =	new FrameGestionTableArticles();
		 
			 if(evt.getSource() == b1){
			 		
				 try {
					frg.menuGeneral(tabArt);
				} catch (AbandonException e) {
					 
					e.printStackTrace();
				} catch (ErreurSaisie e) {
					 
					e.printStackTrace();
				}
			
				 
			 } 
			  
			 if(evt.getSource() == b2){
				 new FrameGestionTableDesCommandes();
				 this.setVisible(false);
			 }
			 
			 if(evt.getSource() == b3){
				 new FrameGestionFactures();
				 this.setVisible(false);
			 }
			 
			 if(evt.getSource() == b4){
				 new  FrameGestionClient();
				 this.setVisible(false);
			 }
			 
			 if(evt.getSource() == b5){
								
				 ES.affiche("Aurevoir et à Bientot");
				 FGT.sauvegarder(tabArt);
				 System.exit(0);
				 
				 		 }	 		
	}
}
	
	
	