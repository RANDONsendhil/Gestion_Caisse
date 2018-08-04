package Serie23;

import Utils.ClientJava;

public class GestionTablesDesCommandes {
	 
	public GestionTablesDesCommandes(){}
	
	
	public void menuGeneral(Commande22<Integer> cde, TablesDesArticles22 Tabart,TablesDesCommandes22 TabCde){
		
	 
	 		int choix; 
	 		  
	 		
	 	 do{
	 		 choix = menuChoix( premierNumero(TabCde), TabCde);

		switch (choix){
		case 1 : creer(Tabart, TabCde,premierNumero(TabCde)) ; break;
		case 2 : supprimer(Tabart, TabCde);break;
		case 3 : AfficherUneCommande(Tabart, TabCde);break;
		case 4 : AfficherToutesLesCommandes(Tabart, TabCde); break;
		case 5 : Modifier(Tabart, TabCde);break;
		case 6 : EditionFacture(Tabart,TabCde, cde);break;
		case 0 : break; 
			}  
	 	 }
	 	 while(choix!=0); 
		}
		
public  int menuChoix(int numCde, TablesDesCommandes22 TabCde) {
		
		String menu = "\t\t\t\tGESTION Des COMMANDES \n" +
				  "\t\t\tCREATION de la COMMANDE Numéro "+premierNumero(TabCde)+"..............1\n" +
				  "\t\t\tSUPPRESION d'une COMMANDE.....................2\n" +
				  "\t\t\tVISUALISATION d'une COMMANDE..................3\n" +
				  "\t\t\tVISUALISATION toutes Les COMMANDES............4\n" +
				  "\t\t\tMODIFIER UNE COMMANDE.........................5\n" +
				  "\t\t\tEDITION FACTURE...............................6\n" +
				  "\t\t\tFIN...........................................0\n\n" +
			  
			  "\t\t\t";
	ClientJava.affiche(menu);
	return ClientJava.saisieEntier("Choix: ", 0, 6);
	}
	

///Listes des Methodes pour La GESTION des COMMANDES/////***************************DEBUT********************************//
 


	


private  void creer(TablesDesArticles22 tabart, TablesDesCommandes22 tabCde,int num ) {
 
	Commande22 <Integer> Cde = new Commande22<Integer>();
	
	Cde.SetNumCde( num);
	GestionCommande22 gestUneCde = new GestionCommande22();
	gestUneCde.menuGeneral(Cde, tabart); 
	if(Cde!=null&&Cde.Taille()!=0){tabCde.Ajouter(Cde);
	System.out.println("LA COMMANDE a été bien Enregistré. Le Numéro de Commande: ");
	 	}
}
	
	
	


private  void supprimer(TablesDesArticles22 tabart, TablesDesCommandes22 tabcde) {
boolean Supprimer =false;
int CleSupprimer;
if(tabcde.Taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR SUPPRIMER ***");
else{
ClientJava.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES");
ClientJava.affiche( tabcde.GetCLECommande());
ClientJava.affiche("\nVoulez Vous Supprimer quelle Commande: ");
CleSupprimer = ClientJava.saisieEntier(" ", 1, Integer.MAX_VALUE);
Supprimer=tabcde.SupprimerUneCommande(CleSupprimer);
if(Supprimer)ClientJava.affiche("La Commande '"+ CleSupprimer +"' Vient d'être Supprimé !");
else ClientJava.affiche("Le Numéro de Commande '"+ CleSupprimer +"' N' EXISTE PAS  !\n");}

}



private  void Modifier(TablesDesArticles22 tabart, TablesDesCommandes22 tabCde) {
	if(tabCde.Taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	ClientJava.affiche("\n********** LISTE des NUMEROS de COMMANDES PASSEES");
	ClientJava.affiche( tabCde.GetCLECommande()); 
	int key = ClientJava.saisieEntier("\n\nEntrer Le NUMERO DE COMMANDE à MODIFIER\n", 1, Integer.MAX_VALUE);
	ClientJava.affiche("VOUS ETES ENTRAIN DE MODIFIER LA COMMANDE Numéro: "+key+"\n"  );
	if(tabCde.Retourner(key)!=null){
		
		 Commande22 <Integer> Cde = new Commande22<Integer>();
		 Cde.SetNumCde(key);
		// tabCde.SupprimerUneCommande(key);
		 GestionCommande22 gestUneCde = new GestionCommande22();
		 gestUneCde.menuGeneral(Cde, tabart); 
		
		 if(Cde!=null&&Cde.Taille()!=0){tabCde.Ajouter(Cde);
		 
	}}}}


private  void AfficherUneCommande(TablesDesArticles22 tabart, TablesDesCommandes22 tabcde) {
	 
	int CleAfficher;
	if(tabcde.Taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	ClientJava.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES");
	ClientJava.affiche( tabcde.GetCLECommande());
	ClientJava.affiche("\nVoulez Vous AFFICHER quelle Commande: ");
	CleAfficher = ClientJava.saisieEntier(" ", 1, Integer.MAX_VALUE);
	
	if(tabcde.Retourner(CleAfficher)!=null){
	ClientJava.affiche(""+tabcde.Retourner(CleAfficher));
	}else ClientJava.affiche("Le Numéro de Commande '"+ CleAfficher +"' N' EXISTE PAS  !\n");
	
}}

private  void AfficherToutesLesCommandes(TablesDesArticles22 tabart, TablesDesCommandes22 tabcde) {
ClientJava.affiche(tabcde.toString());
}


private  void EditionFacture(TablesDesArticles22 tabart,TablesDesCommandes22 tabcde,Commande22<Integer> cde) {
	int CleEdiFacture;
	if(tabcde.Taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR EDITER LA FACTURE ***");
	else{
	ClientJava.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES");
	ClientJava.affiche( tabcde.GetCLECommande());
	ClientJava.affiche("\nVoulez Vous EDITER la FACTURE pour quelle Commande: ");
	CleEdiFacture = ClientJava.saisieEntier("", 1, Integer.MAX_VALUE);
	ClientJava.affiche(" _________________________________________________________________________________________________");
	ClientJava.affiche("|                                                                                                 |");
	
	if(tabcde.Retourner(CleEdiFacture)!=null){
	ClientJava.affiche("\t\t\t\t\t*** FACTURE COMMANDE  n° "+CleEdiFacture+" ***\n");
	 
	tabcde.EditerFactureTC(cde, tabart, CleEdiFacture);
 
	                                                                                            
	ClientJava.affiche("|_________________________________________________________________________________________________|\n\n");
	
	
	}
	else  ClientJava.affiche("Le Numéro de Commande '"+ CleEdiFacture +"' N' EXISTE PAS  !\n");}
	
}  
public static int premierNumero(TablesDesCommandes22 tabcde){
	int num =1;
	 
	do{
		if(tabcde.Retourner(num)==null)return num;
		num++;
	}while(true);
	
	
}


}

//***************************FIN*** ////des Methodes pour La GESTION des COMMANDES/////
	

	
	
