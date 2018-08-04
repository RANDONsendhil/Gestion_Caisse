package Serie31;


import IConsole.ES;
import MesExceptions.AbandonException;

public class GestionCommande31 {
	
private ES ES = new ES();	
	public GestionCommande31(){}

	public void menuGeneral(Commande22<Integer> cde, TablesDesArticles22 tabart) throws AbandonException{
	 
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
	private int menuChoix() throws AbandonException{
		String menu = "\n\t\t\t\tGESTION une COMMANDE \n" +
					  "\t\t\tSAISIR Une Ligne De Commande......1\n" +
					  "\t\t\tAFFICHER la commande en cours.....2\n" +
					  "\t\t\tEDITER la facture.................3\n" +
					  "\t\t\tSUPPRIMER Une Ligne De Commande...4\n" +
					  "\t\t\tFIN...............................0\n\n" +
				  
				  "\t\t\t";
	ES.affiche(menu);
	return ES.saisie("Choix: ", 0, 4);
		
	}

	
	///Creation d' Une Ligne De Commande sans le doublon///
private  void creer(Commande22<Integer> cde, TablesDesArticles22 tabart) throws AbandonException {
	 int code;
	 int quantite=0;
	 
	 
	 ES.affiche("** Creation de la Ligne De Commande ***\n\n");
	
	 code = ES.saisie ("CODE: ", 1, Integer.MAX_VALUE);
	if (tabart.retourner(code)==null){ ES.affiche("***CODE Inconnu dans la TABLE des ARTICLES***\n");}else{
	 		
	 quantite = ES.saisie ("QUANTITE: ", 1, Integer.MAX_VALUE);
			
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
private void supprimer (Commande22<Integer> Cde, LigneDeCommande ldc) throws AbandonException {

	int code;
	if(Cde.Taille()==0){ES.affiche(" **AUCUNE Commande est Actuellement en Cours**\n");
	 }else{
	ES.affiche("****SUPPRESSION d'une Ligne De Commande***\n");
	code = ES.saisie("CODE: ", 1, Integer.MAX_VALUE);
	
	 for(int i = 0; i<Cde.Taille(); i++){
			if(Cde.retournerI(i).getCode()==code){
				System.out.println(Cde.retournerI(i));
				 Cde.supprimer(Cde.retourner(code));
				System.out.println("**Ligne De Commande Vient d'être Supprimé**");}
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
		Cde.EditerFacture(Cde, Tabart);}
		 	
	 
}

 


 

//********************FIN**** //Les menu Choix de la gestion de Commande/


}
