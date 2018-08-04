package Serie31;
import IConsole.ES;
import MesExceptions.AbandonException;
import Utils.ClientJava;
 

public class GestionTablesDesArticles31 {
	  private ES ES = new ES(); 
	public 	GestionTablesDesArticles31(){}
	
	public void menuGeneral(TablesDesArticles22 tabart,Commande22<Integer> cde, TablesDesCommandes22 tabcde) throws AbandonException{
 		int choix; 
 		  		
 	 do{
 	 
 		 choix = menuChoix();

	switch (choix){
	case 1 : creer(tabart) ; break;
	case 2 : supprimer(tabart, cde, tabcde);break;
	case 3 : modifier(tabart);break;
	case 4 : afficher(tabart); break;
	case 0 : break; 
		 
 		 }
 	 }
 	 while(choix!=0); 
	}

	public  int menuChoix() throws AbandonException{
		String menu = "\n\n\t\t\t\tGESTION des ARTICLES \n" +
					  "\t\t\tCREER un nouvel Article.............1\n" +
					  "\t\t\tSUPPRIMER un Article................2\n" +
					  "\t\t\tMODIFIER un Article.................3\n" +
					  "\t\t\tAFFICHER le Stock...................4\n" +
					  "\t\t\tFIN.................................0\n\n" +
				  
				  "\t\t\t";
	ES.affiche(menu);
	return ES.saisie ("Choix: ", 0, 4);
		
	}
	
	 //Creation d'un nouvel article///
	 //Creation d'un nouvel article///
		private void creer(TablesDesArticles22 tabart) throws AbandonException {
			String designation="";
			  float prix;
			  int code;
			  
			  ES.affiche("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabart.afficherKEYtabart());
			  ES.affiche("\n*****CREATION d'un NOUVEL ARTICLE\n");
			  code = ES.saisie("\nCode: ",1, Integer.MAX_VALUE);
			  
			  if(tabart.retourner(code)==null){
					designation	  = ES.saisie("Designation: "+  designation);
					prix            = ES.saisie("Prix: ",Float.MIN_VALUE, Float.MAX_VALUE);
					Article Art = new Article(code,designation,prix);
					tabart.ajouter(code, Art);
				 
			} else {
				ClientJava.affiche("**LE Code Saisi Se Correspond à Un autre Produit***\n");}
			
			}
	
	//Supprimer un article dans le tableau de l'article///
	private void supprimer(TablesDesArticles22 tabart, Commande22<Integer> cde, TablesDesCommandes22 tabcde) throws AbandonException {
		 
		ES.affiche("\n**********SUPPRESSION d'un ARTICLE\n");
		ES.affiche("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabart.afficherKEYtabart());
		tabart.afficherKEYtabart();
		
		
		 
		 int code = ES.saisie("\n\nLE CODE de l'ARTICLE que vous voulez supprimer?  ",1, Integer.MAX_VALUE);
		 if(tabart.retourner(code)==null){ 
			 ES.affiche("**LE Code Saisi est INCONNU***");
		 }
		 else if(tabart.retourner(code)!=null){ 
		 ES.affiche(""+tabart.retourner(code));
		 tabart.supprimer(code);
		 ES.affiche("\n********Cet Article Vient être Supprimé**\n\n");
		 tabart.supprimer(code);
		 tabcde.PURGE(code);
		 
		 
		 }}
		 
	// Modifier un article dans le tableau de l'article///
	private  void modifier(TablesDesArticles22 Tabart) throws AbandonException {
	
	  int code;
	  String designation="";
	  float prix;
	  ES.affiche("\nVOICI LA LISTE des CODE des ARTICLES en STOCK\n"+Tabart.afficherKEYtabart());
	  ES.affiche("\nVoulez Vous Modifier quel ARTICLE: " );
	  code = ES.saisie("\nCode: ", 1, Integer.MAX_VALUE);
	  
	  if((Tabart.retourner(code)) == null){
			
			ES.affiche("CET ARTICLE N'EXISTE PAS");
			
		}else{
	  ES.affiche(""+Tabart.retourner(code));
	  Tabart.supprimer(code);
	  ES.affiche("\n*** MODIFICATION de DESIGNATION et de PRIX pour le CODE ARTICLE n° "+code);
	   
	  designation	  =  ES.saisie ("\n\nDesignation: "+ designation);
	  prix            =   ES.saisie  ("Prix: ", Float.MIN_VALUE, Float.MAX_VALUE);
		 
		  Article Art = new Article(code,designation,prix);
		
		  Tabart.ajouter(code,Art);
		  ES.affiche("Modifié !");
		} 
	}

	//Affichage la listes des articles///
	private  void afficher(TablesDesArticles22 Tabart) {
		 ES.affiche(  Tabart.toString());
		
	}
 
		 }
 

	
	
 