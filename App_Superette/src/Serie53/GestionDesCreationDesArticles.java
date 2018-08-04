package Serie53;
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;
import Utils.DateUser;

public class GestionDesCreationDesArticles implements InterfaceGestion<TablesDesArticles53> {
 static ES ES = new ES();
	 
	public void menuGeneral(TablesDesArticles53 tabArt, Object... objects)   throws AbandonException, ErreurSaisie  {
		 
		int choix;
		 
		TablesDesCommandes53 tabcde = (TablesDesCommandes53)objects[0];
 		  		
 	 do{
 	 
 		 choix = menuChoix();
 	 
	switch (choix){
	case 1 : creer(tabArt) ;break;
	case 2 : creerArticlePromo(tabArt, tabcde);break;
	case 3 : creerArticleLot(tabArt);break;
	case 4 :  afficher(tabArt); break;
	case 0 : break; 
		 
 		 }
 	 }
 	 while(choix!=0); 
 	 
	}
 
 
	public  int menuChoix (Object...objects) throws AbandonException, ErreurSaisie{
		String menu = "\n\n\t\t\t\tCREATION des ARTICLES \n\n" +
					  "\t\t\tCREER un nouvel Article...............................1\n" +
					  "\t\t\tCREER un Article PROMO.............................2\n" +
					  "\t\t\tCREER un Article PROMO EN LOT..................3\n" +
					  "\t\t\tAFFICHER le Stock..........................................4\n" +
					  "\t\t\tFIN.......................................................................0\n\n" +
				  
				  "\t\t\t\n\n";
 
	return ES.saisie (menu, 0, 4);
		
	}

	 
	public void creer(TablesDesArticles53 tabArt, Object... objects)   throws AbandonException, ErreurSaisie  {

		String designation="";
		  float prix;
		  int code;
		  
		 
		 
		  code = ES.saisie("VOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabArt.afficherKEYtabart()+"\n\n*****CREATION d'un NOUVEL ARTICLE\n\nCode: ",1, Integer.MAX_VALUE);
		 if(tabArt.retourner(code)==null){
			  	
			  
				designation	  = ES.saisie("Designation: "+  designation);
				prix            = ES.saisie("Prix: ",Float.MIN_VALUE);
		 
				
					ArticleAbstrait53 Art = new Article53(code,designation,prix);
				tabArt.ajouter(Art);
				ES.affiche("Le nouvel Article est bien Enregistré !\n\n"+tabArt.retourner(code)+"\n\n"); 
			 
		} else {
			ES.affiche("**LE Code Saisi Se Correspond à Un autre Produit***\n");}
		
	}
	
	public void creerArticlePromo(TablesDesArticles53 tabArt, TablesDesCommandes53 tabcde) throws AbandonException, ErreurSaisie {
		String designation="";
		  float prix;
		  int code;
		  
		 
		 
		  code = ES.saisie("*** CREATION D' UN ARTICLE PROMO ***\n\nVOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabArt.afficherKEYtabart()+"\n\n*****CREATION d'un NOUVEL ARTICLE\n\nCode: ",1, Integer.MAX_VALUE);
		  
		  if(tabArt.retourner(code)==null){
			  	
			  
				designation	  = ES.saisie("Designation: "+  designation);
				prix            = ES.saisie("Prix: ",Float.MIN_VALUE);
				 
				 
					 float reduction = ES.saisie("Entrer le Pourcentage de Promotion :", Float.MIN_VALUE);
					 int quantiteMini = ES.saisie("Quantité Minimum doit Commander pour bénéficier la PROMO :", Integer.MIN_VALUE);
					 
					 ArticleAbstrait53  artpomo = new ArticlePromo53(code,designation,prix,reduction,quantiteMini);
					
					 tabArt.ajouter(artpomo);
						ES.affiche("Le nouvel Article est bien Enregistré !\n\n"+tabArt.retourner(code)+"\n\n");
				}  else {
					ES.affiche("**LE Code Saisi Se Correspond à Un autre Produit***\n");}
				
	}

	public void creerArticleLot(TablesDesArticles53 tabArt) throws AbandonException, ErreurSaisie {
	
			String designation="";
			float prix;
			int code;
			DateUser dateActuelle = new DateUser();
			DateUser dateFinPromo = new DateUser();
			
			boolean ouiNon;
			
			ouiNon = ES.saisieOuiNon("VOULEZ VOUS METTRE EN LOT UN ARTICLES EXISTANT ?");
			if(ouiNon){
				code = ES.saisie("*** CREATION D' UN ARTICLE PROMO en LOT ***\n\nVOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabArt.afficherKEYtabart()+"\n\n*****VEUILLEZ CHOISIR UN ARTICLE POUR CREER EN LOT \n\nCode: ",1, Integer.MAX_VALUE);
				  
				ArticleAbstrait53 art = tabArt.retourner(code);
				
				if(tabArt.retourner(code)!=null){
				  	
					
					 
					 
						 float reduction = ES.saisie("Entrer le Pourcentage de Promotion :", Float.MIN_VALUE);
						 int quantitelot = ES.saisie("Une LOT de combien d'ARTICLE pour bénéficier la PROMO :", Integer.MIN_VALUE);
						 int nbrJour = ES.saisie("Entre les nombre de jours que la POMOTION lot sera VALABLE pour l'article N°: "+code, Integer.MIN_VALUE);
						 tabArt.supprimer(code);
						 ArticleAbstrait53  artLot = new ArticleLot(code,art.getDesignation(),art.getPU(),reduction,quantitelot, dateActuelle,   dateFinPromo.ajouterNombrejours(nbrJour));
						 
						
						 tabArt.ajouter(artLot);
							ES.affiche("Le nouvel Article Lot est bien Enregistré !\n\n"+tabArt.retourner(code)+"\n\n");}
			
			}	else
				
		 
		  code = ES.saisie("*** CREATION D' UN ARTICLE PROMO EN LOT***\n\nVOICI LA LISTE des CODE des ARTICLES en STOCK\n"+tabArt.afficherKEYtabart()+"\n\n",1, Integer.MAX_VALUE);
		  
		  if(tabArt.retourner(code)==null){
			  	
			  
				designation	  = ES.saisie("Designation: "+  designation);
				prix            = ES.saisie("Prix: ",Float.MIN_VALUE);
				 
				 
					 float reduction = ES.saisie("Entrer le Pourcentage de Promotion :", Float.MIN_VALUE);
					 int quantitelot = ES.saisie("Une LOT de combien d'ARTICLE pour bénéficier la PROMO :", Integer.MIN_VALUE);
					 int nbrJour = ES.saisie("Entre les nombre de jours que la POMOTION lot sera VALABLE pour l'article N°: "+code, Integer.MIN_VALUE);
					 
					 ArticleAbstrait53  artLot = new ArticleLot(code,designation,prix,reduction,quantitelot, dateActuelle,   dateFinPromo.ajouterNombrejours(nbrJour));
					
					 tabArt.ajouter(artLot);
						ES.affiche("Le nouvel Article Lot est bien Enregistré !\n\n"+tabArt.retourner(code)+"\n\n");
				}  else {
		ES.affiche("**LE Code Saisi Se Correspond à Un autre Produit***\n");}
	
		
		
		
		
		
	}

	public void supprimer(TablesDesArticles53 tabArt, Object... objects)throws AbandonException, ErreurSaisie  {
		
		 
		
	}

	 
	public void modifier(TablesDesArticles53 tab, Object... objects)throws AbandonException, ErreurSaisie  {
		
		// Not Applicable for this TABLE ///
		
	}

	 
	public void afficher(TablesDesArticles53 tab) throws AbandonException, ErreurSaisie {
		if(tab.taille() == 0 ){
			ES.affiche("Tables des ARTICLES est VIDE ");
		}else{
			ES.affiche(""+tab.toString());	}
		
	 
} 
	 
 
	public void miseAJArticlesLotPerime(TablesDesArticles53 tabart, TablesDesCommandes53 tabcde,
			Commande53<Integer> cde) {
		 
	 
		String codeArticle [] = tabart.cleTabArtLot().split("-"); 
		DateUser dateActuelle = new DateUser();
		 
		for(int i =0; i<codeArticle.length;i++){
			
			if( codeArticle [i].isEmpty() ){
				ES.affiche("MISE a JOUR Artilces en PROMOTIONS...");			
				
			}else{
		 
			 
		 
				 
				 int  numeroArtLot = Integer.parseInt(codeArticle[i]);
				ArticleAbstrait53 artLot =(ArticleLot)tabart.retourner(numeroArtLot);
				
				if(artLot instanceof ArticleLot){
					 
					 
			 	if(!((ArticleLot) artLot).getDateFin().avant(dateActuelle.getJour(), dateActuelle.getMois(), dateActuelle.getAnnee())){
					
					ES.affiche(" LA date est EXPIREE pour l' ARTICLE  LOT en PROMOTION  ***Le Code Article "+(Integer.parseInt(codeArticle[i])+"***"));
					
					}else{
						
					}}}} }}
					 
			 
		 
					 
		
	
					 
					 
					 
					 	 
 

