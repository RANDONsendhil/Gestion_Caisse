package Serie23;

import java.util.Scanner;

import Utils.ClientJava;

public class GestionTablesDesArticles {
	
	public 	GestionTablesDesArticles(){}
	
	public void menuGeneral(TablesDesArticles22 Tabart,Commande22<Integer> Cde, TablesDesCommandes22 tabcde){
 		int choix; 
 		  		
 	 do{
 		 choix = menuChoix();

	switch (choix){
	case 1 : Creer(Tabart) ; break;
	case 2 : Supprimer(Tabart, Cde, tabcde);break;
	case 3 : Modifier(Tabart);break;
	case 4 : Afficher(Tabart); break;
	case 0 : break; 
		}
 	 }
 	 while(choix!=0); 
	}

	public  int menuChoix(){
		String menu = "\t\t\t\tGESTION des ARTICLES \n" +
					  "\t\t\tCREER un nouvel Article.............1\n" +
					  "\t\t\tSUPPRIMER un Article................2\n" +
					  "\t\t\tMODIFIER un Article.................3\n" +
					  "\t\t\tAFFICHER le Stock...................4\n" +
					  "\t\t\tFIN.................................0\n\n" +
				  
				  "\t\t\t";
	ClientJava.affiche(menu);
	return ClientJava.saisieEntier("Choix: ", 0, 4);
		
	}
	
	 //Creation d'un nouvel article///
	private  void Creer(TablesDesArticles22 Tabart) {
		
		  String designation="";
		  double prix;
		  int code;
		  
		  ClientJava.affiche("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+Tabart.AfficherKEYtabart());
		  ClientJava.affiche("*****CREATION d'un NOUVEL ARTICLE");
		  code = ClientJava.saisieEntier("\nCode: ",1, Integer.MAX_VALUE);
		  
		  if(Tabart.Retourner(code)==null){
				designation	  = Saisie("Designation: ",  designation);
				prix            = ClientJava.saisieDouble("Prix: ", Double.MIN_VALUE, Double.MAX_VALUE);
				Article Art = new Article(code,designation,prix);
				Tabart.Ajouter(code,Art);
			 
		} else {
			ClientJava.affiche("**LE Code Saisi Se Correspond à Un autre Produit***\n");
		}}	
	
	
	//Supprimer un article dans le tableau de l'article///
	private void Supprimer(TablesDesArticles22 tabart, Commande22<Integer> cde, TablesDesCommandes22 tabcde) {
		 
		ClientJava.affiche("**********SUPPRESSION d'un ARTICLE\n");
		ClientJava.affiche("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabart.AfficherKEYtabart());
		tabart.AfficherKEYtabart();
		
		
		 
		 int code = ClientJava.saisieEntier("\nLE CODE de l'ARTICLE que vous voulez supprimer?  ",1, Integer.MAX_VALUE);
		 if(tabart.Retourner(code)==null){ 
			 ClientJava.affiche("**LE Code Saisi est INCONNU***");
		 }
		 else if(tabart.Retourner(code)!=null){ 
		 ClientJava.affiche(""+tabart.Retourner(code));
		 tabart.Supprimer(code);
		 ClientJava.affiche("\n********Cet Article Vient être Supprimé**\n");
		 tabart.Supprimer(code);
		 tabcde.PURGE(code);
		 
		 
		 }}
		 
	 
	
	
	// Modifier un article dans le tableau de l'article///
	private  void Modifier(TablesDesArticles22 Tabart) {
	
	  int code;
	  String designation="";
	  double prix;
	  ClientJava.affiche("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+Tabart.AfficherKEYtabart());
	  ClientJava.affiche("Voulez Vous Modifier quel ARTICLE: " );
	  code = ClientJava.saisieEntier("Code: ", 1, Integer.MAX_VALUE);
	  
	  if((Tabart.Retourner(code)) == null){
			
			ClientJava.affiche("CET ARTICLE N'EXISTE PAS");
			
		}else{
	  ClientJava.affiche(""+Tabart.Retourner(code));
	  Tabart.Supprimer(code);
	  ClientJava.affiche("*** MODIFICATION de DESIGNATION et de PRIX pour le CODE ARTICLE n° "+code);
	   
	  designation	  = Saisie("Designation: ",  designation);
	  prix            =   ClientJava.saisieDouble ("Prix: ", 1, Double.MAX_VALUE);
		 
		  Article Art = new Article(code,designation,prix);
		
		  Tabart.Ajouter(code,Art);
		  ClientJava.affiche("Modifié !");
		} 
	}

	//Affichage la listes des articles///
	private  void Afficher(TablesDesArticles22 Tabart) {
		 ClientJava.affiche(  Tabart.toString());
		
	}
	
	private static  String Saisie(String mes, String Data){
		Scanner sc = new Scanner (System.in);
		ClientJava.affiche(mes);
		Data = (String) sc.next();
		
		return Data;
	 
	 
}}

	
	
 