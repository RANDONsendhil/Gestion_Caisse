package Serie61;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import IPane.ES;
import MesInterfaces.InterfaceGestion;
import Serie53.TablesDesFactures;

public class FrameGestionFactures extends JFrame implements ActionListener, InterfaceGestion<TablesDesFactures> {

	ES ES = new ES();
	JButton b1,b2,b3,b4,b5;
	
	public FrameGestionFactures(){
		
		 Container container  = getContentPane();
		 container.setLayout(new GridLayout(5,5,0,0));
			
		 
		 	b1 = new JButton("CREER UNE FACTURE");
		  	b2 = new JButton("EDITER UNE FACTURE");
			b3 = new JButton("SUPPRIMER UNE FACTURE ");
			b4 = new JButton("AFFICHER TOUTES LES FACTURES");
			b5   = new JButton("RETOUR AU MENU");
			
		
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			 
			container.add(b1);container.add(b2);container.add(b3);container.add(b4);container.add(b5);
			this.setTitle("MENU GESTION DES FACTURES");
			setSize(400,400);
			this.setLocationRelativeTo(null);
			this.setVisible(true);
	}
 
	public void menuGeneral(TablesDesFactures tab, Object... objects) throws Exception {
		// TODO Auto-generated method stub
		
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
	public int menuChoix(Object... objects) throws Exception {
		 //en cours de construction ////
		return 0;
	}

 
	public void creer(TablesDesFactures tab, Object... objects) throws Exception {
		 //en cours de construction ////
	}

 
	public void supprimer(TablesDesFactures tab, Object... objects) throws Exception {
		 //en cours de construction ////
	}

 
	public void modifier(TablesDesFactures tab, Object... objects) throws Exception {
		 //en cours de construction ////
	}

	 
	public void afficher(TablesDesFactures tab) throws Exception {
		 //en cours de construction ////
	}

  
}
