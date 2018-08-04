package Serie31;

 
import IConsole.ES;
import MesExceptions.AbandonException;

 
public class GestionTablesDesCommandes31 {
	private	ES ES = new ES();	
	public GestionTablesDesCommandes31(){}
 
	
	public void menuGeneral(Commande22<Integer> cde, TablesDesArticles22 Tabart,TablesDesCommandes22 TabCde) throws AbandonException {
		
	
	 		int choix; 
	 		  
	 		
	 	 do{ 
	 		  
	 		 
	 		 int num =premierNumero(TabCde);
	 		 choix = menuChoix(num);

		switch (choix){
		case 1 : creer(Tabart, TabCde,num) ; break;
		case 2 : supprimer(Tabart, TabCde);break;
		case 3 : afficherUneCommande(Tabart, TabCde);break;
		case 4 : afficherToutesLesCommandes(Tabart, TabCde); break;
		case 5 : modifier(Tabart, TabCde);break;
		case 6 : editionFacture(Tabart,TabCde, cde);break;
		case 0 : break; 
			  
		}} 
	 	 while(choix!=0); 
		}
		
public  int menuChoix(int num) throws AbandonException {
		
		String menu = "\n\n\t\t\t\tGESTION Des COMMANDES \n" +
				  "\t\t\tCREATION de la COMMANDE Numéro "+num+"..............1\n" +
				  "\t\t\tSUPPRESION d'une COMMANDE.....................2\n" +
				  "\t\t\tVISUALISATION d'une COMMANDE..................3\n" +
				  "\t\t\tVISUALISATION toutes Les COMMANDES............4\n" +
				  "\t\t\tMODIFIER UNE COMMANDE.........................5\n" +
				  "\t\t\tEDITION FACTURE...............................6\n" +
				  "\t\t\tFIN...........................................0\n\n" +
			  
			  "\t\t\t";
	ES.affiche(menu);
	return ES.saisie("Choix: ", 0, 6);
	}
	

///Listes des Methodes pour La GESTION des COMMANDES/////***************************DEBUT********************************//
 



private  void creer(TablesDesArticles22 tabart, TablesDesCommandes22 tabCde,int num ) throws AbandonException {
 
	Commande22 <Integer> Cde = new Commande22<Integer>();
	
	Cde.SetNumCde( num);
	GestionCommande31 gestUneCde = new GestionCommande31();
	gestUneCde.menuGeneral(Cde, tabart); 
	if(Cde!=null&&Cde.Taille()!=0){tabCde.ajouter(Cde);
	 
	 	}
}
	

private  void supprimer(TablesDesArticles22 tabart, TablesDesCommandes22 tabcde) throws AbandonException {
boolean Supprimer =false;
int CleSupprimer;
if(tabcde.taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR SUPPRIMER ***");
else{
ES.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES");
ES.affiche( "\n"+tabcde.getCLECommande());
ES.affiche("\nVoulez Vous Supprimer quelle Commande: ");
CleSupprimer = ES.saisie(" ", 1, Integer.MAX_VALUE);
Supprimer=tabcde.supprimerUneCommande(CleSupprimer);
if(Supprimer)ES.affiche("La Commande '"+ CleSupprimer +"' Vient d'être Supprimé !\n\n");
else ES.affiche("Le Numéro de Commande '"+ CleSupprimer +"' N' EXISTE PAS  !\n");}

}



private  void modifier(TablesDesArticles22 tabart, TablesDesCommandes22 tabCde) throws AbandonException {
	if(tabCde.taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	ES.affiche("\n********** LISTE des NUMEROS de COMMANDES PASSEES");
	ES.affiche( "\n"+tabCde.getCLECommande());
	int key = ES.saisie("\n\nEntrer Le NUMERO DE COMMANDE à MODIFIER\n", 1, Integer.MAX_VALUE);
	ES.affiche("VOUS ETES ENTRAIN DE MODIFIER LA COMMANDE Numéro: "+key+"\n"  );
	if(tabCde.Retourner(key)!=null){
		
		 Commande22 <Integer> Cde = new Commande22<Integer>();
		 Cde.SetNumCde(key);
		// tabCde.SupprimerUneCommande(key);
		 GestionCommande31 gestUneCde = new GestionCommande31();
		 gestUneCde.menuGeneral(Cde, tabart); 
		
		 if(Cde!=null&&Cde.Taille()!=0){tabCde.ajouter(Cde);
		 
	}}}}


private  void afficherUneCommande(TablesDesArticles22 tabart, TablesDesCommandes22 tabcde) throws AbandonException {
	 
	int CleAfficher;
	if(tabcde.taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	ES.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES");
	ES.affiche( "\n"+tabcde.getCLECommande());
	ES.affiche("\nVoulez Vous AFFICHER quelle Commande: ");
	CleAfficher = ES.saisie (" ", 1, Integer.MAX_VALUE);
	
	if(tabcde.Retourner(CleAfficher)!=null){
	ES.affiche(""+tabcde.Retourner(CleAfficher));
	}else ES.affiche("Le Numéro de Commande '"+ CleAfficher +"' N' EXISTE PAS  !\n");
	
}}

private  void afficherToutesLesCommandes(TablesDesArticles22 tabart, TablesDesCommandes22 tabcde) {
ES.affiche(tabcde.toString());
}


private  void editionFacture(TablesDesArticles22 tabart,TablesDesCommandes22 tabcde,Commande22<Integer> cde) throws AbandonException {
	int CleEdiFacture;
	if(tabcde.taille()==0)System.out.println("\n*** PAS COMMANDE EN COURS POUR EDITER LA FACTURE ***");
	else{
	ES.affiche("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n");
	ES.affiche( tabcde.getCLECommande());
	ES.affiche("\nVoulez Vous EDITER la FACTURE pour quelle Commande: ");
	CleEdiFacture = ES.saisie("", 1, Integer.MAX_VALUE);
	ES.affiche(" _________________________________________________________________________________________________\n");
	ES.affiche("|                                                                                                 |");
	
	if(tabcde.Retourner(CleEdiFacture)!=null){
	ES.affiche("\n\t\t\t\t\t*** FACTURE COMMANDE  n° "+CleEdiFacture+" ***\n");
	 
	tabcde.editerFactureTC(cde, tabart, CleEdiFacture);
 
	                                                                                            
	ES.affiche("\n|_________________________________________________________________________________________________|\n\n");
	
	
	}
	else  ES.affiche("Le Numéro de Commande '"+ CleEdiFacture +"' N' EXISTE PAS  !\n");}
	
}  
public static int premierNumero(TablesDesCommandes22 tabcde){
	 int num =1;
	 
	do{
		if(tabcde.Retourner(num)==null)return  num;
		 num++;
	}while(true);
}
}

//***************************FIN*** ////des Methodes pour La GESTION des COMMANDES/////
	

	
	
