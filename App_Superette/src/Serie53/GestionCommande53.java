package Serie53;


 import java.io.Serializable;

import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;

public class GestionCommande53 implements InterfaceGestion<Commande53<String>>  , Serializable {
	
private ES ES = new ES();	
	public GestionCommande53(){}

	public void menuGeneral(Commande53<String> cde, Object...objects) throws AbandonException, ErreurSaisie{
	
		
			LigneDeCommande53 ldc = new LigneDeCommande53(); 
			TablesDesArticles53 tabart = (TablesDesArticles53)objects[0];
			 int choix;
		 do{
		 
	choix = menuChoix();
		
		switch (choix){
		case 1 : creer( cde ,tabart ); break;
		case 2 : afficher (cde);break;
	//	case 3 : editerFacture (cde, tabart);break;
		case 3 : supprimer (cde, ldc);break; 
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
					//  "\t\t\tEDITER la facture..........................................3\n" +
					  "\t\t\tSUPPRIMER Une Ligne De Commande...3\n" +
					  "\t\t\tFIN....................................................................0\n\n" +
				  
				  "\t\t\t\n";
				 
	return ES.saisie(menu, 0, 3);
		
	}

	
	///Creation d' Une Ligne De Commande sans le doublon///
public  void creer(Commande53<String> cde,  Object...objects) throws AbandonException, ErreurSaisie {
	 int code;
	 int quantite=0;
	 
	 TablesDesArticles53 tabart = (TablesDesArticles53)objects[0];
	  
	
	 code = ES.saisie ("** Creation de la Ligne De Commande ***\n\n CODE: ", 1, Integer.MAX_VALUE);
	if (tabart.retourner(code)==null){ ES.affiche("***CODE Inconnu dans la TABLE des ARTICLES***\n");}else{
	 		
		ArticleAbstrait53 art = tabart.retourner(code);
	
	if(art!=null){
		 quantite = ES.saisie(art.typeDePromotion() +"\nQUANTITE: ", 1);
		
		
		  }
		
	 
			
	 if(tabart.retourner(code)!=null){
		 if(cde.retourner(code)==null) {
		 LigneDeCommande53 ldc = new LigneDeCommande53(code,quantite);
		
		 cde.ajouter(ldc); 
		 }else{
			  
			 LigneDeCommande53 ldc1 = new LigneDeCommande53(code, quantite+cde.retourner(code).getQuantite());
				cde.ajouter(ldc1);
				ES.affiche("\nQuantit� Modifie!\n");
			 cde.supprimer(cde.retourner(code)); 	}
			
		}} 
	
}


//Supprimer une Ligne de Commande/// 
public void supprimer (Commande53<String> Cde, Object...objects) throws AbandonException, ErreurSaisie {

	
	
	int code;
	if(Cde.taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours**\n");
	 }else{
	 
	code = ES.saisie("****SUPPRESSION d'une Ligne De Commande***\n"+Cde.toString()+"\n\n***Veuillez Entrer le num�ro de CODE que Voulez vous SUPPRIMER***\n\nCODE: ", 1);
	
	 for(int i = 0; i<Cde.taille(); i++){
			if(Cde.retournerI(i).getCode()==code){
			
				 ES.affiche( Cde.retournerI(i)+"\n\n**Ligne De Commande Vient d'�tre Supprim�**");
					Cde.supprimer(Cde.retourner(code));}
			}}}

//Afficher la Ligne de Commande///
public void afficher (Commande53<String> cde) {
	if(cde.taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours**\n");
	 }else{		
	ES.affiche("*************Voici Votre Commande\n"+cde.toString());
	 }
}

/*
//Editer Une Facture///
public void editerFacture(Commande53<String> Cde,Object...objects) {
	
	TablesDesArticles53 Tabart = (TablesDesArticles53)objects[0];
	
	
	 if(Cde.taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours pour EDITER la FACTURE**\n");
	 }else{
		ES.affiche(Cde.EditerFacture(Cde, Tabart));}
		 	
	 
}
//********************FIN**** //Les menu Choix de la gestion de Commande/
*/
 
public void modifier(Commande53<String> tab, Object...objects) throws Exception {
	////Empty Method////Not applicable for this table 
	
}
 

 
 

}
