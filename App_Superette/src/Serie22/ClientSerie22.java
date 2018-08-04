package Serie22;

import java.util.Scanner;
import java.util.Vector;

import Serie21.LigneDeCommande;
import Utils.ClientJava;

public class ClientSerie22 {
    
	public static void main(String[] args) {
	
		TablesDesArticles22 Tabart = new TablesDesArticles22();
		Commande22<Integer> Cde  = new Commande22<Integer> ();
		TablesDesCommandes22 tabcom = new TablesDesCommandes22();
		int choix;
		
		//menu principal///
		do{
		choix = MenuChoix();
		 
		 
		switch(choix){
		case 1 : GestionTableArticle(Tabart, Cde,tabcom); break;
		case 2 : GestionTablesDesCommandes(Cde, Tabart, tabcom);
		case 0 : break;
		}
		}while(choix!=0);
		 
		ClientJava.affiche("Au revoir... et à bientôt !");}
		 
	
	/************************************************************************************************
	 							*AFFICHAGE DU MENU//////   */
	
	public static int MenuChoix(){
		
		String menu = "\t\t\tBIENVENUE A LA SUPERETTE \n\n" +
					  "\t\t\tGestion Des Articles ..........1\n" +
					  "\t\t\tGestion des COMMANDES..........2\n" +
					  "\t\t\tFIN............................0\n\n" +
					  
					  "\t\t\t";
		ClientJava.affiche(menu);
		return ClientJava.saisieEntier("Choix: ", 0, 2);
		
	}
	
	public static int MenuChoixCommande(){
		String menu = "\t\t\t\tGESTION une COMMANDE \n" +
					  "\t\t\tSAISIR Une Ligne De Commande......1\n" +
					  "\t\t\tAFFICHER la commande en cours.....2\n" +
					  "\t\t\tEDITER la facture.................3\n" +
					  "\t\t\tSUPPRIMER Une Ligne De Commande...4\n" +
					  "\t\t\tFIN...............................0\n\n" +
				  
				  "\t\t\t";
	ClientJava.affiche(menu);
	return ClientJava.saisieEntier("Choix: ", 0, 5);
		
	}
	public static int MenuChoixArticle(){
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
	
	public static int MenuChoixDESCOMMANDES(int numCde) {
		
		
		String menu = "\t\t\t\tGESTION Des COMMANDES \n" +
				  "\t\t\tCREATION de la COMMANDE Numéro "+numCde+"..............1\n" +
				  "\t\t\tSUPPRESION d'une COMMANDE.....................2\n" +
				  "\t\t\tVISUALISATION d'une COMMANDE..................3\n" +
				  "\t\t\tVISUALISATION toutes Les COMMANDES............4\n" +
				  "\t\t\tMODIFIER UNE COMMANDE.........................5\n" +
				  "\t\t\tEDITION FACTURE...............................6\n" +
				  "\t\t\tFIN...........................................0\n\n" +
			  
			  "\t\t\t";
	ClientJava.affiche(menu);
	return ClientJava.saisieEntier("Choix: ", 0, 5);
	}
	
	
	
	///Listes des Methodes pour La GESTION des COMMANDES/////***************************DEBUT********************************//
	private static void GestionTablesDesCommandes(Commande22<Integer> cde, TablesDesArticles22 Tabart,TablesDesCommandes22 TabCde){
 		int choix; 
 		 
 		
 	 do{
 		 choix = MenuChoixDESCOMMANDES(TabCde.numCde);

	switch (choix){
	case 1 : CreationDeLaCommande(Tabart, TabCde) ; break;
	case 2 : SuppressionUneCommande(Tabart, TabCde);break;
	case 3 : VisualisationUneCommande(Tabart, TabCde);break;
	case 4 : VisualisationToutesLesCommandes(Tabart, TabCde); break;
	case 5 : ModifierUneCommande(Tabart, TabCde);break;
	case 6 : EditionFacture(Tabart,TabCde, cde);break;
	case 0 : break; 
		}
 	 }
 	 while(choix!=0); 
	}
	



	private static void ModifierUneCommande(TablesDesArticles22 tabart, TablesDesCommandes22 tabCde) {
		if(tabCde.Taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
		else{
		ClientJava.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n");
		ClientJava.affiche( tabCde.GetCLECommande()); 
		int key = ClientJava.saisieEntier("\nEntrer Le numéro de Commaande pour MODIFIER\n", 1, Integer.MAX_VALUE);
		ClientJava.affiche("VOUS ETES ENTRAIN DE MODIFIER LA COMMANDE Numéro "+key  );
		if(tabCde.Retourner(key)!=null){
			
			 Commande22 <Integer> Cde = new Commande22<Integer>();
			 Cde.SetNumCde(key);
			 GestionUneCommande(Cde,tabart);
			
			 if(Cde!=null&&Cde.Taille()!=0){tabCde.Ajouter(Cde);
			 
		}}}}
		
			 
		
		
		
	

	private static void CreationDeLaCommande(TablesDesArticles22 tabart,   TablesDesCommandes22 tabCde ) {
	 
		Commande22 <Integer> Cde = new Commande22<Integer>();
		Cde.SetNumCde(tabCde.numCde);
		
		GestionUneCommande(Cde,tabart);
		if(Cde!=null&&Cde.Taille()!=0){tabCde.Ajouter(Cde);
		System.out.println("LA COMMANDE a été bien Enregistré. Le Numéro de Commande: "+tabCde.numCde );
		tabCde.numCde++;	}
		
		
		
		
	}
	
	private static void SuppressionUneCommande(TablesDesArticles22 tabart, TablesDesCommandes22 tabcde) {
	boolean Supprimer =false;
	int CleSupprimer;
	if(tabcde.Taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR SUPPRIMER ***");
	else{
	ClientJava.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES");
	ClientJava.affiche( tabcde.GetCLECommande());
	ClientJava.affiche("Voulez Vous Supprimer quelle Commande: ");
	CleSupprimer = ClientJava.saisieEntier(" ", 1, Integer.MAX_VALUE);
	Supprimer=tabcde.SupprimerUneCommande(CleSupprimer);
	if(Supprimer)ClientJava.affiche("La Commande '"+ CleSupprimer +"' Vient d'être Supprimé !");
	else ClientJava.affiche("Le Numéro de Commande '"+ CleSupprimer +"' N' EXISTE PAS  !\n");}
	
	}
	private static void VisualisationUneCommande(TablesDesArticles22 tabart, TablesDesCommandes22 tabcde) {
		 
		int CleAfficher;
		if(tabcde.Taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
		else{
		ClientJava.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n");
		ClientJava.affiche( tabcde.GetCLECommande());
		ClientJava.affiche("Voulez Vous AFFICHER quelle Commande: ");
		CleAfficher = ClientJava.saisieEntier(" ", 1, Integer.MAX_VALUE);
		
		if(tabcde.Retourner(CleAfficher)!=null){
		ClientJava.affiche(""+tabcde.Retourner(CleAfficher));
		}else ClientJava.affiche("Le Numéro de Commande '"+ CleAfficher +"' N' EXISTE PAS  !\n");}
		
	}
	private static void EditionFacture(TablesDesArticles22 tabart,TablesDesCommandes22 tabcde,Commande22<Integer> cde) {
		int CleEdiFacture;
		if(tabcde.Taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR EDITER LA FACTURE ***");
		else{
		ClientJava.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n");
		ClientJava.affiche( tabcde.GetCLECommande());
		ClientJava.affiche("Voulez Vous EDITER la FACTURE pour quelle Commande: ");
		CleEdiFacture = ClientJava.saisieEntier("", 1, Integer.MAX_VALUE);
		ClientJava.affiche(" _________________________________________________________________________________________________");
		ClientJava.affiche("|                                                                                                 |");
		
		if(tabcde.Retourner(CleEdiFacture)!=null){
		ClientJava.affiche("\t\t\t\t\t*** FACTURE COMMANDE  n° "+CleEdiFacture+" ***\n");
		 
		tabcde.EditerFactureTC(cde, tabart, CleEdiFacture);
	 
		                                                                                            
		ClientJava.affiche("|_________________________________________________________________________________________________|\n\n");
		
		
		}
		else  ClientJava.affiche("Le Numéro de Commande '"+ CleEdiFacture +"' N' EXISTE PAS  !\n");}
		
	}

	private static void VisualisationToutesLesCommandes(TablesDesArticles22 tabart, TablesDesCommandes22 tabcde) {
	ClientJava.affiche(tabcde.toString());
	}

	//***************************FIN*** ////des Methodes pour La GESTION des COMMANDES/////
	
	
	
	
	//Les Methodes du menu Choix Articles//////********************DEBUT********************************************

	///Methodes Gestion de tables des articles/// 
	private static void GestionTableArticle(TablesDesArticles22 Tabart,Commande22<Integer> Cde, TablesDesCommandes22 tabcde){
 		int choix; 
 		 
 		
 	 do{
 		 choix = MenuChoixArticle();

	switch (choix){
	case 1 : CreerUnNouvelArticle(Tabart) ; break;
	case 2 : SupprimerUnArticle(Tabart, Cde, tabcde);break;
	case 3 : ModifierUnArticle(Tabart);break;
	case 4 : AfficherleStock(Tabart); break;
	case 0 : break; 
		}
 	 }
 	 while(choix!=0); 
	}

	 //Creation d'un nouvel article///
	private static  void CreerUnNouvelArticle(TablesDesArticles22 Tabart) {
		
		  String designation="";
		  double prix;
		  int code;
		  
		  ClientJava.affiche("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+Tabart.AfficherKEYtabart());
		  ClientJava.affiche("*****CREATION d'un NOUVEL ARTICLE");
		  code = ClientJava.saisieEntier("\nCode: ",1, Integer.MAX_VALUE);
		  
		  if(Tabart.Retourner(code)==null){
				designation	  = EntrerString("Designation: ",  designation);
				prix            = ClientJava.saisieDouble("Prix: ", Double.MIN_VALUE, Double.MAX_VALUE);
				Article Art = new Article(code,designation,prix);
				Tabart.Ajouter(code,Art);
			 
		} else {
			ClientJava.affiche("**LE Code Saisi Se Correspond à Un autre Produit***\n");
		}}	
	
	
	//Supprimer un article dans le tableau de l'article///
	private static void SupprimerUnArticle(TablesDesArticles22 tabart, Commande22<Integer> cde, TablesDesCommandes22 tabcde) {
		for(int i = 1; i<=tabcde.Taille(); i++){
			System.out.println(tabcde.Retourner(i));
		}
		
		

		ClientJava.affiche("**********SUPPRESSION d'un ARTICLE\n");
		ClientJava.affiche("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabart.AfficherKEYtabart());
		tabart.AfficherKEYtabart();
		
		
		 int code;
		 code 			  = ClientJava.saisieEntier("\nLE CODE ARTICLE voulez-vous supprimer?  ",1, Integer.MAX_VALUE);
		 if(tabart.Retourner(code)==null){ 
			 ClientJava.affiche("**LE Code Saisi est INCONNU***");
		 }
		 else if(tabart.Retourner(code)!=null){ 
		 tabart.Supprimer(code);
		 ClientJava.affiche("\n***Cet Article Vient être Supprimé**\n");
		 tabart.Supprimer(code);
		 tabcde.PURGE(code);
		 
		 
		 }
		 }
	 
	
	
	// Modifier un article dans le tableau de l'article///
	private static void ModifierUnArticle(TablesDesArticles22 Tabart) {
	
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
	   
	  designation	  = EntrerString("Designation: ",  designation);
	  prix            =   ClientJava.saisieDouble ("Prix: ", 1, Double.MAX_VALUE);
		 
		  Article Art = new Article(code,designation,prix);
		
		  Tabart.Ajouter(code,Art);
		  ClientJava.affiche("Modifié !");
		} 
	}

	//Affichage la listes des articles///
	private static void AfficherleStock(TablesDesArticles22 Tabart) {
		 ClientJava.affiche(  Tabart.toString());
		
	}
	//********************FIN**** Methodes du menu Choix Articles//////
	
	
	
	
	//Les menu Choix de la gestion de Commande///********************DEBUT********************************************
	
	
	private static void GestionUneCommande(Commande22<Integer> Cde, TablesDesArticles22 Tabart){
		LigneDeCommande ldc = new LigneDeCommande(); 
		 int choix;
	 do{
choix = MenuChoixCommande();
	
	switch (choix){
	case 1 : AjouterUneLigneDeCommande( Cde ,Tabart ); break;
	case 2 : AfficherLaCommande(Cde);break;
	case 3 : EditerFacture (Cde, Tabart);break;
	case 4 : SupprimerUneLigneDeCommande(Cde, ldc);break; 
	case 0 : break; 
	}
	 }
	while(choix!=0); 

	}
	
	
	private static void AjouterUneLigneDeCommande(Commande22<Integer> cde, TablesDesArticles22 tabart) {
		 int code;
		 int quantite=0;
		 
		 
		 ClientJava.affiche("** Creation de la Ligne De Commande ***\n\n");
		
		 code = ClientJava.saisieEntier("CODE: ", 1, Integer.MAX_VALUE);
		if (tabart.Retourner(code)==null){ ClientJava.affiche("***CODE Inconnu dans la TABLE des ARTICLES***\n");}else{
		 		
		 quantite = ClientJava.saisieEntier("QUANTITE: ", 1, Integer.MAX_VALUE);
				
		 if(tabart.Retourner(code)!=null){
			 if(cde.RETOURNER(code)==null) {
			 LigneDeCommande ldc = new LigneDeCommande(code,quantite);
			
			 cde.Ajouter(ldc); 
			 }else{
				  
				 LigneDeCommande ldc1 = new LigneDeCommande(code, quantite+cde.RETOURNER(code).GetQuantite());
					cde.Ajouter(ldc1);
					ClientJava.affiche("\nQuantité Modifie!\n");
				 cde.Supprimer(cde.RETOURNER(code));  }}} 
		
	}


	///Ajouter Une Ligne De Commande sans le doublon///
	
	
	//Afficher la Ligne de Commande///
	private static void AfficherLaCommande(Commande22<Integer> cde) {
				
		ClientJava.affiche("*************Voici Votre Commande\n"+cde.toString());
		
	}

	//Editer Une Facture///
	private static void EditerFacture(Commande22<Integer> Cde,TablesDesArticles22 Tabart) {
		 if(Cde.Taille()==0){ClientJava.affiche(" **AUCUNE Commande est Actuellement en Cours pour EDITER la FACTURE**\n");
		 }else{
			Cde.EditerFacture(Cde, Tabart);}
			 	
		 
}
	
	//Modifier la Ligne de Commande/// 
	
	//Supprimer une Ligne de Commande/// 
	private static void SupprimerUneLigneDeCommande(Commande22<Integer> Cde, LigneDeCommande ldc) {
	 
		int code;
		ClientJava.affiche("****SUPPRESSION d'une Ligne De Commande***\n");
		code = ClientJava.saisieEntier("CODE: ", 1, Integer.MAX_VALUE);
		
		 for(int i = 0; i<Cde.Taille(); i++){
				if(Cde.Retourner(i).GetCode()==code){
					System.out.println(Cde.Retourner(i));
					 Cde.Supprimer(Cde.RETOURNER(code));
					System.out.println("**Ligne De Commande Vient d'être Supprimé**");
				}}}
	 
		
	 		
		
	
	//Modifier une Ligne de Commande/// 
	 
	//********************FIN**** //Les menu Choix de la gestion de Commande/
	


	/*
	 * Cette methode permet de input un String
	 */
	private static String EntrerString(String mes, String Data){
		Scanner sc = new Scanner (System.in);
		ClientJava.affiche(mes);
		Data = (String) sc.next();
		
		return Data;
		
	}
	 } 

 

  


