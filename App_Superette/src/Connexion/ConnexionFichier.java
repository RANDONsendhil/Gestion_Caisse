package Connexion;

import IPane.ES;
import java.io.*;
 	
public class ConnexionFichier<TypeTable>{

	private String nomPhysique;
	private ES ES = new ES();
	
	public ConnexionFichier(String nom){
		this.nomPhysique = nom;
	}
	
		public TypeTable lire(){
			
			TypeTable  tab= null;
			
			
			try{
			FileInputStream fil  = new FileInputStream(nomPhysique);
			ObjectInputStream ois = new ObjectInputStream (fil);
			tab = (TypeTable) ois.readObject();
			
			}catch(FileNotFoundException  fnfe){
				ES.affiche("*** FICHIER NOUVEAU ***");
				
			}
			catch(IOException io){
				
				ES.affiche("***  PB PHYSIQUE ***");
				
			}catch(ClassNotFoundException cnfe){
				ES.affiche(" *** TABLE NON CONFORME ***");
			}
			return tab;
			
		}
		
		
	public void ecrie (TypeTable tab){
		try {
			FileOutputStream fos  = new FileOutputStream(nomPhysique);
	
			ObjectOutputStream oos = new ObjectOutputStream (fos);
			oos.writeObject(tab);
			oos.close();
		}catch(FileNotFoundException fnfe){
			
			ES.affiche("*** PB OUVERTURE DU FICHIER ***");
			
		}catch (IOException e) {
		 	ES.affiche("*** PB D'ECRITURE (OBJECT NON-SERIALIZE ***)");
			
		}} }
	
	 


