package Serie32;
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;

 

public class GestionTablesDesArticles32 {
	   ES ES = new ES(); 
	public 	GestionTablesDesArticles32(){}
	
	public void menuGeneral(TablesDesArticles22 tabart,Commande22<Integer> cde, TablesDesCommandes22 tabcde) throws AbandonException, ErreurSaisie{
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

	public  int menuChoix() throws AbandonException, ErreurSaisie{
		String menu = "\n\n\t\t\t\tGESTION des ARTICLES \n\n" +
					  "\t\t\tCREER un nouvel Article........1\n" +
					  "\t\t\tSUPPRIMER un Article...........2\n" +
					  "\t\t\tMODIFIER un Article................3\n" +
					  "\t\t\tAFFICHER le Stock..................4\n" +
					  "\t\t\tFIN...............................................0\n\n" +
				  
				  "\t\t\t\n\n";
 
	return ES.saisie (menu, 0, 4);
		
	}
	
	 //Creation d'un nouvel article///
	 //Creation d'un nouvel article///
		private void creer(TablesDesArticles22 tabart) throws AbandonException, ErreurSaisie {
			String designation="";
			  float prix;
			  int code;
			  
			 
			 
			  code = ES.saisie("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabart.afficherKEYtabart()+"\n\n*****CREATION d'un NOUVEL ARTICLE\n\nCode: ",1, Integer.MAX_VALUE);
			  
			  if(tabart.retourner(code)==null){
					designation	  = ES.saisie("Designation: "+  designation);
					prix            = ES.saisie("Prix: ",Float.MIN_VALUE);
					Article Art = new Article(code,designation,prix);
					tabart.ajouter(code, Art);
					ES.affiche("Le nouvel Article est bien Enregistré !\n\n"+tabart.retourner(code)+"\n\n");
				 
			} else {
				ES.affiche("**LE Code Saisi Se Correspond à Un autre Produit***\n");}
			
			}
	
	//Supprimer un article dans le tableau de l'article///
	private void supprimer(TablesDesArticles22 tabart, Commande22<Integer> cde, TablesDesCommandes22 tabcde) throws AbandonException, ErreurSaisie {
		 
	 
		   
		 int code = ES.saisie("\n**********SUPPRESSION d'un ARTICLE\n"
		 		+ "VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabart.afficherKEYtabart()+
		 		"\n\nLE CODE de l'ARTICLE que vous voulez supprimer?  ",1);
		 if(tabart.retourner(code)==null){ 
			 ES.affiche("**LE Code Saisi est INCONNU***");
		 }
		 else if(tabart.retourner(code)!=null){ 
	 
		
		 ES.affiche(tabart.retourner(code)+"\n********Cet Article Vient être Supprimé**\n\n");
		 tabart.supprimer(code);
		 
		 tabcde.PURGE(code);
		 
		 
		 }}
		 
	// Modifier un article dans le tableau de l'article///
	private  void modifier(TablesDesArticles22 Tabart) throws AbandonException, ErreurSaisie {
	
	  int code;
	  String designation="";
	  float prix;
	  
	 
	  code = ES.saisie("\nVOICI LA LISTE des CODE des ARTICLES en STOCK\n"+Tabart.afficherKEYtabart()+
			  "\nVoulez Vous Modifier quel ARTICLE: \nCode: ", 1);
	  
	  if((Tabart.retourner(code)) == null){
			
			ES.affiche("CET ARTICLE N'EXISTE PAS");
			
		}else{
 
	 
	  ES.affiche(Tabart.retourner(code)+"\n\n*** MODIFICATION de DESIGNATION et de PRIX pour le CODE ARTICLE n° "+code);
	  Tabart.supprimer(code);
	  designation	  =  ES.saisie ("\n\nDesignation: "+ designation);
	  prix            =   ES.saisie  ("Prix: ", Float.MIN_VALUE);
		 
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
 

	
	
 