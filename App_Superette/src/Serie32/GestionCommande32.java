package Serie32;


 import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;

public class GestionCommande32 {
	
private ES ES = new ES();	
	public GestionCommande32(){}

	public void menuGeneral(Commande22<Integer> cde, TablesDesArticles22 tabart) throws AbandonException, ErreurSaisie{
	 
			LigneDeCommande ldc = new LigneDeCommande(); 
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
	private int menuChoix() throws AbandonException, ErreurSaisie{
		String menu = "\n\t\t\t\tGESTION une COMMANDE \n\n" +
					  "\t\t\tSAISIR Une Ligne De Commande.............1\n" +
					  "\t\t\tAFFICHER la commande en cours............2\n" +
					  "\t\t\tEDITER la facture..........................................3\n" +
					  "\t\t\tSUPPRIMER Une Ligne De Commande...4\n" +
					  "\t\t\tFIN....................................................................0\n\n" +
				  
				  "\t\t\t\n"
				  
				  
				  
				  
				  ;
	 
	return ES.saisie(menu, 0, 4);
		
	}

	
	///Creation d' Une Ligne De Commande sans le doublon///
private  void creer(Commande22<Integer> cde, TablesDesArticles22 tabart) throws AbandonException, ErreurSaisie {
	 int code;
	 int quantite=0;
	 
	 
	  
	
	 code = ES.saisie ("** Creation de la Ligne De Commande ***\n\n CODE: ", 1, Integer.MAX_VALUE);
	if (tabart.retourner(code)==null){ ES.affiche("***CODE Inconnu dans la TABLE des ARTICLES***\n");}else{
	 		
	 quantite = ES.saisie ("QUANTITE: ", 1);
			
	 if(tabart.retourner(code)!=null){
		 if(cde.retourner(code)==null) {
		 LigneDeCommande ldc = new LigneDeCommande(code,quantite);
		
		 cde.ajouter(ldc); 
		 }else{
			  
			 LigneDeCommande ldc1 = new LigneDeCommande(code, quantite+cde.retourner(code).getQuantite());
				cde.ajouter(ldc1);
				ES.affiche("\nQuantité Modifie!\n");
			 cde.supprimer(cde.retourner(code));  }}} 
	
}




//Supprimer une Ligne de Commande/// 
private void supprimer (Commande22<Integer> Cde, LigneDeCommande ldc) throws AbandonException, ErreurSaisie {

	int code;
	if(Cde.Taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours**\n");
	 }else{
	 
	code = ES.saisie("****SUPPRESSION d'une Ligne De Commande***\n"+Cde.toString()+"\n\n***Veuillez Entrer le numéro de CODE que Voulez vous SUPPRIMER***\n\nCODE: ", 1);
	
	 for(int i = 0; i<Cde.Taille(); i++){
			if(Cde.retournerI(i).getCode()==code){
			
				 ES.affiche( Cde.retournerI(i)+"\n\n**Ligne De Commande Vient d'être Supprimé**");
					Cde.supprimer(Cde.retourner(code));}
			}}}

//Afficher la Ligne de Commande///
private void afficher (Commande22<Integer> cde) {
	if(cde.Taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours**\n");
	 }else{		
	ES.affiche("*************Voici Votre Commande\n"+cde.toString());
	 }
}

//Editer Une Facture///
private void editerFacture(Commande22<Integer> Cde,TablesDesArticles22 Tabart) {
	 if(Cde.Taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours pour EDITER la FACTURE**\n");
	 }else{
		ES.affiche(Cde.EditerFacture(Cde, Tabart));}
		 	
	 
}
//********************FIN**** //Les menu Choix de la gestion de Commande/


}
