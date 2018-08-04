package Serie61;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import Connexion.ConnexionFichier;
import IPane.ES;
import MesInterfaces.InterfaceGestion;
import MesInterfaces.InterfaceStructure;
import Serie53.Commande53;
import Serie53.TablesDesArticles53;
import Serie53.TablesDesCommandes53;

public class FrameGestionTableDesCommandes  extends JFrame implements ActionListener, InterfaceGestion<TablesDesCommandes53> {
	  ConnexionFichier<TablesDesCommandes53>  fichCde;
	  
	  
	  
public 	FrameGestionTableDesCommandes(String nomPhysique){
		
	fichCde = new ConnexionFichier<TablesDesCommandes53>(nomPhysique);
		
	}
	 
	
	///La methode qui recupere la tables des articles ///
	
	

	public TablesDesCommandes53 recupere(){
		
		TablesDesCommandes53 tabCde = fichCde.lire();
		if(tabCde == null){
			tabCde = new TablesDesCommandes53();
		}
		return tabCde;
	}
	
	public void sauvegarder(TablesDesCommandes53 tabCde){
		
		ES.affiche("**SAUVEGARDE DES COMMANDES EN COURS... *** ");
		fichCde.ecrie(tabCde);
	}
	
	 
	
	ES ES = new ES();
	JButton b1,b2,b3,b4,b5,b6;
	
	TablesDesCommandes53 tabCde;
	public void menuGeneral(TablesDesCommandes53 tabcde, Object... objects) throws Exception {
		 this.tabCde = tabcde;
		
	}

	public FrameGestionTableDesCommandes( ) {
		
		
		Container container  = getContentPane();
		 container.setLayout(new GridLayout(6,6,0,0));
			
		 
		 	b1 = new JButton("CREER DES COMMANDES");
		  	b2 = new JButton("SUPPRESSION D'UNE COMMANDE");
			b3 = new JButton("MODIFIER UNE COMMANDE");
			b4 = new JButton("AFFICHER UNE COMMANDE");
			b5   = new JButton("AFFICHER TOUTES LES COMMANDES");
			b6   = new JButton("RETOUR AU MENU");
		
			b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			b4.addActionListener(this);
			b5.addActionListener(this);
			b6.addActionListener(this);
			 
			container.add(b1);container.add(b2);container.add(b3);container.add(b4);container.add(b5);container.add(b6);
			this.setTitle("MENU GESTION DES COMMANDES");
			setSize(400,600);
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
				  					 
					 ES.affiche("TABLES EN COURS DE CONSTRUCTIONS...");
					  
					 		 }
				 if(evt.getSource() == b6){
						 
					  new ClientSerie61();
					this.dispose();
					  
					 		 }
			
		}

	public void creer(TablesDesCommandes53 tab, Object... objects) throws Exception {
		 
		
		 //en cours de construction ////

	}
 
  

 

	 
	public void supprimer(TablesDesCommandes53 tab, Object... objects) throws Exception {
		 //en cours de construction ////

	}


 
	public void modifier(TablesDesCommandes53 tab, Object... objects) throws Exception {
		 //en cours de construction ////

		
	}


	 
	public void afficher(TablesDesCommandes53 tab) throws Exception {
		 //en cours de construction ////

		
	}


 
 
	public int menuChoix(Object... objects) throws Exception {
		 //en cours de construction ////

		return 0;
	}


	 

}
