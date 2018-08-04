package Serie51;


 import java.io.Serializable;

import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;

public class GestionCommande51 implements InterfaceGestion<Commande51<String>>  , Serializable {
	
private ES ES = new ES();	
	public GestionCommande51(){}

	public void menuGeneral(Commande51<String> cde, Object...objects) throws AbandonException, ErreurSaisie{
	
		
			LigneDeCommande51 ldc = new LigneDeCommande51(); 
			TablesDesArticles51 tabart = (TablesDesArticles51)objects[0];
			 int choix;
		 do{
		 
	choix = menuChoix();
		
		switch (choix){
		case 1 : creer( cde ,tabart ); break;
		case 2 : afficher (cde);break;
		case 3 : editerFacture (cde, tabart);break;
		case 4 : supprimer (cde, ldc);break; 
		case 0 : break; 
		} 
		 }
		while(choix!=0); 

		}
	
	
	//Les menu Choix de la gestion de Commande///********************DEBUT********************************************
	public int menuChoix(Object...objects) throws AbandonException, ErreurSaisie{
		String menu = "\n\t\t\t\tGESTION une COMMANDE \n\n" +
					  "\t\t\tSAISIR Une Ligne De Commande.............1\n" +
					  "\t\t\tAFFICHER la commande en cours............2\n" +
					  "\t\t\tEDITER la facture..........................................3\n" +
					  "\t\t\tSUPPRIMER Une Ligne De Commande...4\n" +
					  "\t\t\tFIN....................................................................0\n\n" +
				  
				  "\t\t\t\n";
				 
	return ES.saisie(menu, 0, 4);
		
	}

	
	///Creation d' Une Ligne De Commande sans le doublon///
public  void creer(Commande51<String> cde,  Object...objects) throws AbandonException, ErreurSaisie {
	 int code;
	 int quantite=0;
	 
	 TablesDesArticles51 tabart = (TablesDesArticles51)objects[0];
	  
	
	 code = ES.saisie ("** Creation de la Ligne De Commande ***\n\n CODE: ", 1, Integer.MAX_VALUE);
	if (tabart.retourner(code)==null){ ES.affiche("***CODE Inconnu dans la TABLE des ARTICLES***\n");}else{
	 		
		ArticleAbstrait51 art = tabart.retourner(code);
	
	if(art!=null){
		
		if(art instanceof ArticlePromo51){
			ES.affiche("ARTICLE EN PROMO !\n Si la quantite Commandee >="+((ArticlePromo51)art).getQuantiteMini()+"\n");
		} }
		
	 quantite = ES.saisie ("QUANTITE: ", 1);
		
		
	
			
	 if(tabart.retourner(code)!=null){
		 if(cde.retourner(code)==null) {
		 LigneDeCommande51 ldc = new LigneDeCommande51(code,quantite);
		
		 cde.ajouter(ldc); 
		 }else{
			  
			 LigneDeCommande51 ldc1 = new LigneDeCommande51(code, quantite+cde.retourner(code).getQuantite());
				cde.ajouter(ldc1);
				ES.affiche("\nQuantité Modifie!\n");
			 cde.supprimer(cde.retourner(code)); 	}
			
		}} 
	
}


//Supprimer une Ligne de Commande/// 
public void supprimer (Commande51<String> Cde, Object...objects) throws AbandonException, ErreurSaisie {

	
	
	int code;
	if(Cde.taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours**\n");
	 }else{
	 
	code = ES.saisie("****SUPPRESSION d'une Ligne De Commande***\n"+Cde.toString()+"\n\n***Veuillez Entrer le numéro de CODE que Voulez vous SUPPRIMER***\n\nCODE: ", 1);
	
	 for(int i = 0; i<Cde.taille(); i++){
			if(Cde.retournerI(i).getCode()==code){
			
				 ES.affiche( Cde.retournerI(i)+"\n\n**Ligne De Commande Vient d'être Supprimé**");
					Cde.supprimer(Cde.retourner(code));}
			}}}

//Afficher la Ligne de Commande///
public void afficher (Commande51<String> cde) {
	if(cde.taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours**\n");
	 }else{		
	ES.affiche("*************Voici Votre Commande\n"+cde.toString());
	 }
}

//Editer Une Facture///
public void editerFacture(Commande51<String> Cde,Object...objects) {
	
	TablesDesArticles51 Tabart = (TablesDesArticles51)objects[0];
	
	
	 if(Cde.taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours pour EDITER la FACTURE**\n");
	 }else{
		ES.affiche(Cde.EditerFacture(Cde, Tabart));}
		 	
	 
}
//********************FIN**** //Les menu Choix de la gestion de Commande/

@Override
public void modifier(Commande51<String> tab, Object...objects) throws Exception {
	////Empty Method////Not applicable for this table 
	
}
 

 
 

}
