package Serie42;
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;
 

 

public class GestionTablesDesArticles42 implements InterfaceGestion<TablesDesArticles42> {
	   ES ES = new ES(); 
	public 	GestionTablesDesArticles42(){}
	 
	public void menuGeneral(TablesDesArticles42 tabart,   Object... objects) throws AbandonException, ErreurSaisie{
 		int choix; 
 		
 	 	 
		TablesDesCommandes42 tabcde = (TablesDesCommandes42)objects[0];
 		  		
 	 do{
 	 
 		 choix = menuChoix();

	switch (choix){
	case 1 : creer(tabart) ; break;
	case 2 : supprimer(tabart, tabcde);break;
	case 3 : modifier(tabart);break;
	case 4 : afficher(tabart); break;
	case 5 : afficherArticlePromo(tabart); break;
	case 0 : break; 
		 
 		 }
 	 }
 	 while(choix!=0); 
	}

	

	public  int menuChoix(Object...objects) throws AbandonException, ErreurSaisie{
		String menu = "\n\n\t\t\t\tGESTION des ARTICLES \n\n" +
					  "\t\t\tCREER un nouvel Article................................1\n" +
					  "\t\t\tSUPPRIMER un Article...................................2\n" +
					  "\t\t\tMODIFIER un Article........................................3\n" +
					  "\t\t\tAFFICHER le Stock..........................................4\n" +
					  "\t\t\tAFFICHER les ARTICLES en Promo.............5\n" +
					  "\t\t\tFIN.......................................................................0\n\n" +
				  
				  "\t\t\t\n\n";
 
	return ES.saisie (menu, 0, 5);
		
	}
	
	
	public  void afficherArticlePromo(TablesDesArticles42 tabart) {
		ES.affiche(tabart.toStringPromo());
		
	}
	  
	 //Creation d'un nouvel article///
		public void creer(TablesDesArticles42 tabart, Object...objects) throws AbandonException, ErreurSaisie {
			String designation="";
			  float prix;
			  int code;
			  
			 
			 
			  code = ES.saisie("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabart.afficherKEYtabart()+"\n\n*****CREATION d'un NOUVEL ARTICLE\n\nCode: ",1, Integer.MAX_VALUE);
			  
			  if(tabart.retourner(code)==null){
				  	
				  
					designation	  = ES.saisie("Designation: "+  designation);
					prix            = ES.saisie("Prix: ",Float.MIN_VALUE);
					boolean promo = ES.saisieOuiNon("Article en PROMO ?");
					if(promo){
						 float reduction = ES.saisie("Entrer le Pourcentage de Promotion :", Float.MIN_VALUE);
						 int quantiteMini = ES.saisie("Quantit� Minimum doit Commander pour b�n�ficier la PROMO :", Integer.MIN_VALUE);
						 
						 ArticleAbstrait  artpomo = new ArticlePromo(code,designation,prix,reduction,quantiteMini);
						
						 tabart.ajouter(artpomo);
							ES.affiche("Le nouvel Article est bien Enregistr� !\n\n"+tabart.retourner(code)+"\n\n");
					}else{
					
					Article42 Art = new Article42(code,designation,prix);
					tabart.ajouter(Art);
					ES.affiche("Le nouvel Article est bien Enregistr� !\n\n"+tabart.retourner(code)+"\n\n");}
				 
			} else {
				ES.affiche("**LE Code Saisi Se Correspond � Un autre Produit***\n");}
			
			}
	
	//Supprimer un article dans le tableau de l'article///
	public void supprimer(TablesDesArticles42 tabart,  Object...objects) throws AbandonException, ErreurSaisie {
		 
	 TablesDesCommandes42 tabcde = (TablesDesCommandes42)objects[0];
		   
		 int code = ES.saisie("\n**********SUPPRESSION d'un ARTICLE\n"
		 		+ "VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabart.afficherKEYtabart()+
		 		"\n\nLE CODE de l'ARTICLE que vous voulez supprimer?  ",1);
		 if(tabart.retourner(code)==null){ 
			 ES.affiche("**LE Code Saisi est INCONNU***");
		 }
		 else if(tabart.retourner(code)!=null){ 
	 
		
		 ES.affiche(tabart.retourner(code)+"\n********Cet Article Vient �tre Supprim�**\n\n");
		 tabart.supprimer(code);
		 
		 tabcde.PURGE(code);
		 
		 
		 }}
		 
	// Modifier un article dans le tableau de l'article///
	public  void modifier(TablesDesArticles42 tabart,Object...objects) throws AbandonException, ErreurSaisie {
	
	  int code;
	  String designation="";
	  float prix;
	  
	 
	  code = ES.saisie("\nVOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabart.afficherKEYtabart()+
			  "\nVoulez Vous Modifier quel ARTICLE: \nCode: ", 1);
	  
	  if((tabart.retourner(code)) == null){
			
			ES.affiche("CET ARTICLE N'EXISTE PAS");
			
		}else{
 
	 
	  ES.affiche(tabart.retourner(code)+"\n\n*** MODIFICATION de DESIGNATION et de PRIX pour le CODE ARTICLE n� "+code);
	  tabart.supprimer(code);
	  designation	  =  ES.saisie ("\n\nDesignation: "+ designation);
	  prix            =   ES.saisie  ("Prix: ", Float.MIN_VALUE);
		 
	  boolean promo = ES.saisieOuiNon("Article en PROMO ?");
		if(promo){
			 float reduction = ES.saisie("Entre le Pourcentage de Promotion :", Float.MIN_VALUE);
			 int quantiteMini = ES.saisie("Quantit� Mini doit Commande pour profiter la PROMO:", Integer.MIN_VALUE);
			 
			 ArticleAbstrait  artpomo = new ArticlePromo(code,designation,prix,reduction,quantiteMini);
			
			 tabart.ajouter(artpomo);
				ES.affiche("Le nouvel Article est bien Enregistr� !\n\n"+tabart.retourner(code)+"\n\n");
		}else{
		
		Article42 Art = new Article42(code,designation,prix);
		tabart.ajouter(Art);
		ES.affiche("Le nouvel Article a bien �t� Enregistr� !\n\n"+tabart.retourner(code)+"\n\n");} 
		}}
	  

	//Affichage la listes des articles///
	public  void afficher(TablesDesArticles42 Tabart) {
		 ES.affiche(  Tabart.toString());
		
	}
 
	 
	 
		 }
 

	
	
 