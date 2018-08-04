package Serie21;

import java.util.Scanner;
import java.util.Vector;

import Serie22.Commande22;
import Serie22.TablesDesArticles22;
import Utils.ClientJava;

public class ClientSerie21 {
  
	public static void main(String[] args) {
	
		TablesDesArticles Tabart = new TablesDesArticles();
		UneCommande Cde = new UneCommande();
		LigneDeCommande ldc = new LigneDeCommande ();
		int choix;
		
		//menu principal///
		do{
		choix = MenuChoix();
		 
		 
		switch(choix){
		case 1 : GestionTableArticle(Tabart,Cde,ldc); break;
		case 2 : GestionUneCommande(Cde, Tabart); break;
		case 0 : break;
		}
		}while(choix!=0);
		 
		ClientJava.affiche("Au revoir... et à bientôt !");}
		 
	
	
	
	///Methodes Gestion de tables des articles/// 
	public static void GestionTableArticle(TablesDesArticles Tabart, UneCommande cde, LigneDeCommande ldc){
 		int choix; 
 		 
 		
 	 do{
 		 choix = MenuChoixArticle();

	switch (choix){
	case 1 : CreerUnNouvelArticle(Tabart) ; break;
	case 2 : SupprimerUneArticle(Tabart, cde, ldc);break;
	case 3 : ModifierUnArticle(Tabart);break;
	case 4 : AfficherleStock(Tabart); break;
	case 0 : break; 
		}
 	 }
 	 while(choix!=0); 
	}
	
	/************************************************************************************************
	 *AFFICHAGE DU MENU////// 
	 * 
	 * 
	 */
	public static int MenuChoix(){
		
		String menu = "\t\t\tBIENVENUE A LA SUPERETTE \n" +
					  "\t\t\tGestion Des Articles ..........1\n" +
					  "\t\t\tGestion de Commande............2\n" +
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
					  "\t\t\tMODIFIER Une Ligne De Commande....5\n" +
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
	
	//Les Methodes du menu Choix Articles///
	 //Creation d'un nouvel article///
	public static  void CreerUnNouvelArticle(TablesDesArticles Tabart) {
	Article art = saisie(Tabart);
	 
	if(art==null){
		System.out.println("Produit deja existé");
		 
	}
	else{
		Tabart.Ajouter(art);
	} 
	
	}	
	
	
	//Supprimer un article dans le tableau de l'article///
	public static void SupprimerUneArticle(TablesDesArticles tabart, UneCommande cde, LigneDeCommande ldc) {
		 int code;
		 code 			  = ClientJava.saisieEntier("Code: ",1, Integer.MAX_VALUE);
		 if(tabart.Retourner(code)==null){ 
			 ClientJava.affiche("**LE Code Saisi est INCONNU***");
		 }
		 else if(tabart.Retourner(code)!=null){ 
		 ClientJava.affiche(""+tabart.Retourner(code).toString());
		 tabart.Supprimer(code);
		 
		 ClientJava.affiche("\n***Cet Article Vient être Supprimé**\n");
		  for(int i = 0; i<cde.Taille(); i++){
		       if(cde.Retourner(i).GetCode()==code){
					System.out.println(cde.Retourner(i));
					System.out.println("ce code se tourve dans la commande !!!");
					cde.SupprimerIndice(i);
					System.out.println("**Ligne De Commande Vient d'être Supprimé**");
				}}
		 
		 }
		 }
		 
		 
	
	
	// Modifier un article dans le tableau de l'article///
	private static void ModifierUnArticle(TablesDesArticles Tabart) {
	
	  int code;
	  String designation="";
	  double prix;
	  
	  code = ClientJava.saisieEntier("Code: ", 1, Integer.MAX_VALUE);
	  
	  if((Tabart.Retourner(code)) == null){
			
			ClientJava.affiche("CET ARTICLE N'EXISTE PAS");
			
		}else{
	  ClientJava.affiche(""+Tabart.Retourner(code));
	  Tabart.Supprimer(code);
	  ClientJava.affiche("Veuillez Modifier l'article:\n");
	  code 			  = ClientJava.saisieEntier("Code: ",1, Integer.MAX_VALUE);
	  designation	  = EntrerString("Designation: ",  designation);
	  prix            =   ClientJava.saisieDouble ("Prix: ",Double.MIN_VALUE, Double.MAX_VALUE);
		 
		  Article Art = new Article(code,designation,prix);
		
		  Tabart.Ajouter(Art);
	
		} 
	}

	//Affichage la listes des articles///
	public static void AfficherleStock(TablesDesArticles Tabart) {
		 ClientJava.affiche(Tabart.toString());
		
	}
	
	
	/*
	 * 
	 * //Les menu Choix de la gestion de Commande///
	 * 
	 * 
	 */
	
	
	
	
	public static void GestionUneCommande(UneCommande Cde, TablesDesArticles Tabart){
		LigneDeCommande ldc = new LigneDeCommande(); 
		 int choix;
	 do{
choix = MenuChoixCommande();
	
	switch (choix){
	case 1 : ajouterUneLigneDeCommande( Cde ,Tabart); break;
	case 2 : AfficherLaCommande(Cde);break;
	case 3 : EditerFacture (Cde, Tabart);break;
	case 4 : SupprimerUneLigneDeCommande(Cde, ldc);break; 
	case 5 : ModifierUneLigneDeCommande(Cde, ldc);break; 
	case 0 : break; 
	}
	 }
	while(choix!=0); 

	}
	
	
	///Ajouter Une Ligne De Commande sans le doublon///
	public static void ajouterUneLigneDeCommande(UneCommande cde,TablesDesArticles tabart) {
		 
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

		
	 
	public static LigneDeCommande SaisieLDC(TablesDesArticles tabart){
	ClientJava.affiche("******CREATION D' UNE ldc*****\n");	
	 
	int code  = ClientJava.saisieEntier("Code", 1, Integer.MAX_VALUE);
	if(tabart.Retourner(code)!=null){
		int quantite	 = ClientJava.saisieEntier("Quantiet:",1, Integer.MAX_VALUE);
		return (new LigneDeCommande(code,quantite));
	}
	else return null;
	
	}

		
	
	//Afficher la Ligne de Commande///
	public static void AfficherLaCommande(UneCommande cde) {
				
		ClientJava.affiche("*************Voici Votre Commande\n"+cde.toString());
		
	}

	//Editer Une Facture///
		public static void EditerFacture(UneCommande cde,TablesDesArticles Tabart) {
		
			cde.EditerFacture(cde, Tabart);
			cde.AfficherTotalTVAetTTC(cde, Tabart);
		
		}
	
	
	//Modifier la Ligne de Commande/// 
	
	//Supprimer une Ligne de Commande/// 
	public static void SupprimerUneLigneDeCommande(UneCommande cde, LigneDeCommande ldc) {
	 
		int code;
		ClientJava.affiche("****SUPPRESSION d'une Ligne De Commande***\n");
		code = ClientJava.saisieEntier("CODE: ", 1, Integer.MAX_VALUE);
		
		for(int i = 0; i<cde.Taille(); i++){
			if(cde.Retourner(i).GetCode()==code){
				System.out.println(cde.Retourner(i));
				cde.SupprimerIndice(i);
				System.out.println("**Ligne De Commande Vient d'être Supprimé**");
			}}}
	 		
		
	
	//Modifier une Ligne de Commande/// 
	public static void ModifierUneLigneDeCommande(UneCommande cde, LigneDeCommande ldc) {
		int	quantite=0; 
		int code;
		ClientJava.affiche("****MODIFICATION d'une Ligne De Commande***\n");
		code = ClientJava.saisieEntier("CODE: ", 1, Integer.MAX_VALUE);
		quantite = ClientJava.saisieEntier("Quantite",1 ,Integer.MAX_VALUE );
	
			for(int i = 0; i<cde.Taille(); i++){
			if(cde.Retourner(i).GetCode()==code){
			 
				quantite=cde.Retourner(i).GetQuantite()+quantite;
				cde.SupprimerIndice(i);
				ClientJava.affiche("Modifié !");
			 
			}
		}LigneDeCommande ldc1 =new LigneDeCommande(code,quantite);
		 cde.Ajouter(ldc1);
		 ClientJava.affiche("C Fait");}
		
	

	
	


	

	/*
	 * Cette methode permet de input un String
	 */
	
	
	public static Article       saisie(TablesDesArticles tabart){
		boolean b =false;
		String designation = "";
		int prix;
		int code = ClientJava.saisieEntier("Code", 1, Integer.MAX_VALUE);
		if(tabart.Retourner(code)==null){
		 b =true;
			  designation = EntrerString("Designation", designation);
			  prix = ClientJava.saisieEntier("Prix", 1, Integer.MAX_VALUE);
			  
			 return  new Article(code,designation,prix);
			 
		}
		return null;
		
	}
	public static String EntrerString(String mes, String Data){
		Scanner sc = new Scanner (System.in);
		ClientJava.affiche(mes);
		Data = (String) sc.nextLine();
		
		return Data;
		
	}
	 } 

 

  


