package Serie61;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import IPane.ES;
import MesInterfaces.InterfaceGestion;
import Serie53.Client;

public class FrameGestionClient extends JFrame implements InterfaceGestion<Client>,ActionListener {
	
	ES ES = new ES();
	JButton b1,b2,b3,b4,b5;
	
	public void menuGeneral(Client tab, Object... objects) throws Exception {
		
		
	}
	public   FrameGestionClient (){
		Container container  = getContentPane();
		 container.setLayout(new GridLayout(5,5,0,0));
			
		 
		 	b1 = new JButton("CREATION DES ClIENTS");
		  	b2 = new JButton("SUPPRESSION UN CLIENT");
			b3 = new JButton("MODIFIER UN CLIENT");
			b4 = new JButton("AFFICHER UN CLIENT");
			b5   = new JButton("RETOUR AU MENU");
			
		
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			 
			container.add(b1);container.add(b2);container.add(b3);container.add(b4);container.add(b5);
			this.setTitle("MENU GESTION DES CLIENTS");
			setSize(400,400);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
	}
   
	 
	public void actionPerformed(ActionEvent evt) {
		 if(evt.getSource() == b1){
			  ES.affiche("TABLES EN COURS DE CONSTRUCTIONS...");
			 	
			 
			
			 }  if(evt.getSource() == b2){
				 ES.affiche("TABLES EN COURS DE CONSTRUCTIONS...");
				 
				
				 
			 }  if(evt.getSource() == b3){
				 ES.affiche("TABLES EN COURS DE CONSTRUCTIONS...");
				  
				
			 }  if(evt.getSource() == b4){
				 ES.affiche("TABLES EN COURS DE CONSTRUCTIONS...");
				  
					 
			 }  if(evt.getSource() == b5){
			  					 
				 new ClientSerie61();
				  this.dispose();
				  
				 		 }
		
	}
 
	
	
	public void creer(Client tab, Object... objects) throws Exception {
		// En cours de construction ///
		
	}

 
	public void supprimer(Client tab, Object... objects) throws Exception {
		// En cours de construction ///
	}
 
	public void modifier(Client tab, Object... objects) throws Exception {
		// En cours de construction ///
	}

 
	public void afficher(Client tab) throws Exception {
		// En cours de construction ///
		
	}



 
	public int menuChoix(Object... objects) throws Exception {
		// En cours de construction ///
		return 0;
	}

}
