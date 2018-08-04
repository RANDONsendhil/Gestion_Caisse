package Serie23;

import Serie21.LigneDeCommande;
import Utils.ClientJava;

public class GestionCommande22 {
	
	
	public GestionCommande22(){}

	public void menuGeneral(Commande22<Integer> Cde, TablesDesArticles22 Tabart){
	 
			LigneDeCommande ldc = new LigneDeCommande(); 
			 int choix;
		 do{
	choix = menuChoix();
		
		switch (choix){
		case 1 : creer( Cde ,Tabart ); break;
		case 2 : Afficher (Cde);break;
		case 3 : EditerFacture (Cde, Tabart);break;
		case 4 : Supprimer (Cde, ldc);break; 
		case 0 : break; 
		}
		 }
		while(choix!=0); 

		}
	
	
	//Les menu Choix de la gestion de Commande///********************DEBUT********************************************
	private int menuChoix(){
		String menu = "\t\t\t\tGESTION une COMMANDE \n" +
					  "\t\t\tSAISIR Une Ligne De Commande......1\n" +
					  "\t\t\tAFFICHER la commande en cours.....2\n" +
					  "\t\t\tEDITER la facture.................3\n" +
					  "\t\t\tSUPPRIMER Une Ligne De Commande...4\n" +
					  "\t\t\tFIN...............................0\n\n" +
				  
				  "\t\t\t";
	ClientJava.affiche(menu);
	return ClientJava.saisieEntier("Choix: ", 0, 5);
		
	}

	
	///Creation d' Une Ligne De Commande sans le doublon///
private  void creer(Commande22<Integer> cde, TablesDesArticles22 tabart) {
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




//Supprimer une Ligne de Commande/// 
private void Supprimer (Commande22<Integer> Cde, LigneDeCommande ldc) {

	int code;
	if(Cde.Taille()==0){ClientJava.affiche(" **AUCUNE Commande est Actuellement en Cours**\n");
	 }else{
	ClientJava.affiche("****SUPPRESSION d'une Ligne De Commande***\n");
	code = ClientJava.saisieEntier("CODE: ", 1, Integer.MAX_VALUE);
	
	 for(int i = 0; i<Cde.Taille(); i++){
			if(Cde.Retourner(i).GetCode()==code){
				System.out.println(Cde.Retourner(i));
				 Cde.Supprimer(Cde.RETOURNER(code));
				System.out.println("**Ligne De Commande Vient d'être Supprimé**");}
			}}}

//Afficher la Ligne de Commande///
private void Afficher (Commande22<Integer> cde) {
	if(cde.Taille()==0){ClientJava.affiche(" **AUCUNE Commande est Actuellement en Cours**\n");
	 }else{		
	ClientJava.affiche("*************Voici Votre Commande\n"+cde.toString());
	 }
}

//Editer Une Facture///
private void EditerFacture(Commande22<Integer> Cde,TablesDesArticles22 Tabart) {
	 if(Cde.Taille()==0){ClientJava.affiche(" **AUCUNE Commande est Actuellement en Cours pour EDITER la FACTURE**\n");
	 }else{
		Cde.EditerFacture(Cde, Tabart);}
		 	
	 
}

 


 

//********************FIN**** //Les menu Choix de la gestion de Commande/


}
