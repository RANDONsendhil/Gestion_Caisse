package Serie53;
import Connexion.ConnexionFichier;
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;
import Serie53.TablesDesArticles53;

 

public class GestionTablesDesArticles53 implements InterfaceGestion<TablesDesArticles53> {
	   ES ES = new ES(); 
	   
	   ConnexionFichier<TablesDesArticles53>  fichArt; //establish Connection///
	   
	   
	public 	GestionTablesDesArticles53(String nomPhysique){
		
		fichArt = new ConnexionFichier<TablesDesArticles53>(nomPhysique);
		
	}
	 
	
	///La methode qui recupere la tables des articles ///
	
	public TablesDesArticles53 recupere(){
		
		TablesDesArticles53 tabArt = fichArt.lire();
		if(tabArt == null){
			tabArt = new TablesDesArticles53();
		}
		return tabArt;
	}
	
	public void sauvegarder(TablesDesArticles53 tabArt){
		
		ES.affiche("**SAUVEGARDE DES ARTICLES EN COURS... *** ");
		fichArt.ecrie(tabArt);
	}
	
	 
	
	
	
	
	
	
	
	public void menuGeneral(TablesDesArticles53 tabArt,   Object... objects) throws AbandonException, ErreurSaisie{
 		int choix;
 		 
		TablesDesCommandes53 tabCde = (TablesDesCommandes53)objects[0];
 		  		
 	 do{
 	 
 		 choix = menuChoix();
 	 
	switch (choix){
	case 1 : creer(tabArt,tabCde) ;break;
	 
	case 2 : supprimer(tabArt, tabCde);break;
	case 3 : modifier(tabArt);break;
	case 4 : afficher(tabArt); break;
	case 5 : afficherArticlePromo(tabArt); break;
	case 6 : afficherArticlePromoenLOT(tabArt); break;
	case 0 : break; 
		 
 		 }
 	 }
 	 while(choix!=0); 
 	 
	}

	



	public  int menuChoix(Object...objects) throws AbandonException, ErreurSaisie{
		String menu = "\n\n\t\t\t\tGESTION des ARTICLES \n\n" +
					  "\t\t\tCREATION des ARTICLES..........................................1\n" +
					  "\t\t\tSUPPRIMER un Article...............................................2\n" +
					  "\t\t\tMODIFIER un Article....................................................3\n" +
					  "\t\t\tAFFICHER le Stock.......................................................4\n" +
					  "\t\t\tAFFICHER les ARTICLES en Promo.........................5\n"+ 
					  "\t\t\tAFFICHER les ARTICLES en Promo en LOT...........6\n" +
					  "\t\t\tFIN....................................................................................0\n\n" +
				  
				  "\t\t\t\n\n";
 
	return ES.saisie (menu, 0, 6);
		
	}
	
	
	
	
	
	
	
	public  void afficherArticlePromo(TablesDesArticles53 tabArt) {
		if(tabArt.taille()==0){
			ES.affiche("Tables Des ARTICLE est VIDE ");		}
		
		ES.affiche(tabArt.toStringPromo());
		
	}
	
	
	
	public void afficherArticlePromoenLOT(TablesDesArticles53 tabArt) {
		 
		ES.affiche(tabArt.toStringLot());
	}

	  
	 //Creation d'un nouvel article///
		public void creer(TablesDesArticles53 tabArt, Object...objects) throws AbandonException, ErreurSaisie {
			TablesDesCommandes53 tabCde = (TablesDesCommandes53)objects[0];
			
			
			
			GestionDesCreationDesArticles gestCreationArt = new GestionDesCreationDesArticles();
			
			
			gestCreationArt.menuGeneral(tabArt, tabCde);
			 
			}
	
	//Supprimer un article dans le tableau de l'article///
	public void supprimer(TablesDesArticles53 tabArt,  Object...objects) throws AbandonException, ErreurSaisie {
		 
	 TablesDesCommandes53 tabcde = (TablesDesCommandes53)objects[0];
		   
		 int code = ES.saisie("\n**********SUPPRESSION d'un ARTICLE\n"
		 		+ "VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabArt.afficherKEYtabart()+
		 		"\n\nLE CODE de l'ARTICLE que vous voulez supprimer?  ",1);
		 if(tabArt.retourner(code)==null){ 
			 ES.affiche("**LE Code Saisi est INCONNU***");
		 }
		 else if(tabArt.retourner(code)!=null){ 
	 
		
		 ES.affiche(tabArt.retourner(code)+"\n********Cet Article Vient être Supprimé**\n\n");
		 tabArt.supprimer(code);
		 
		 tabcde.PURGE(code);
		 
		 
		 }}
		 
	// Modifier un article dans le tableau de l'article///
	public  void modifier(TablesDesArticles53 tabArt, Object... objects) throws AbandonException, ErreurSaisie {
	
	  int code;
	  String designation="";
	  float prix;
	  
	 
	  code = ES.saisie("\nVOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabArt.afficherKEYtabart()+
			  "\nVoulez Vous Modifier quel ARTICLE: \nCode: ", 1);
	  
	  if((tabArt.retourner(code)) == null){
			
			ES.affiche("CET ARTICLE N'EXISTE PAS");
			
		}else{
 
	 
	  ES.affiche(tabArt.retourner(code)+"\n\n*** MODIFICATION de DESIGNATION et de PRIX pour le CODE ARTICLE n° "+code);
	  tabArt.supprimer(code);
	  designation	  =  ES.saisie ("\n\nDesignation: "+ designation);
	  prix            =   ES.saisie  ("Prix: ", Float.MIN_VALUE);
		 
	  boolean promo = ES.saisieOuiNon("Article en PROMO ?");
		if(promo){
			 float reduction = ES.saisie("Entre le Pourcentage de Promotion :", Float.MIN_VALUE);
			 int quantiteMini = ES.saisie("Quantité Mini doit Commande pour profiter la PROMO:", Integer.MIN_VALUE);
			 
			 ArticleAbstrait53  artpomo = new ArticlePromo53(code,designation,prix,reduction,quantiteMini);
			
			 tabArt.ajouter(artpomo);
				ES.affiche("Le nouvel Article est bien Enregistré !\n\n"+tabArt.retourner(code)+"\n\n");
		}else{
		
			ArticleAbstrait53 Art = new Article53(code,designation,prix);
		tabArt.ajouter(Art);
		ES.affiche("Le nouvel Article a bien été Enregistré !\n\n"+tabArt.retourner(code)+"\n\n");} 
		}}
	  

	//Affichage la listes des articles///
	public  void afficher(TablesDesArticles53 tabArt) {
		 ES.affiche(  tabArt.toString());
		
	}

 
 
	 
	 
		 }
 

	
	
 