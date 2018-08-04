package Serie41;

 
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;

 
public class GestionTablesDesCommandes41 {
	private	ES ES = new ES();	
	public GestionTablesDesCommandes41(){}
 
	
	public void menuGeneral(Commande41<Integer> cde, TablesDesArticles41 Tabart,TablesDesCommandes41 TabCde) throws AbandonException, ErreurSaisie {
		
	
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
		
public  int menuChoix(int num) throws AbandonException, ErreurSaisie {
		
		String menu = "\n\n\t\t\t\tGESTION Des COMMANDES \n\n" +
				  "\t\t\tCREATION de la COMMANDE Numéro "+num+"...................1\n" +
				  "\t\t\tSUPPRESION d'une COMMANDE...............................2\n" +
				  "\t\t\tVISUALISATION d'une COMMANDE...........................3\n" +
				  "\t\t\tVISUALISATION toutes Les COMMANDES...............4\n" +
				  "\t\t\tMODIFIER UNE COMMANDE.........................................5\n" +
				  "\t\t\tEDITION FACTURE..........................................................6\n" +
				  "\t\t\tFIN......................................................................................0\n\n" +
			  
			  "\t\t\t";
 
	return ES.saisie(menu, 0, 6);
	}
	

///Listes des Methodes pour La GESTION des COMMANDES/////***************************DEBUT********************************//
 



private  void creer(TablesDesArticles41 tabart, TablesDesCommandes41 tabCde,int num ) throws AbandonException, ErreurSaisie {
 
	Commande41 <Integer> Cde = new Commande41<Integer>();
	
	Cde.SetNumCde( num);
	GestionCommande41 gestUneCde = new GestionCommande41();
	gestUneCde.menuGeneral(Cde, tabart); 
	if(Cde!=null&&Cde.Taille()!=0){tabCde.ajouter(Cde);
	 
	 	}
}
	

private  void supprimer(TablesDesArticles41 tabart, TablesDesCommandes41 tabcde) throws AbandonException, ErreurSaisie {
boolean Supprimer =false;
int CleSupprimer;
if(tabcde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR SUPPRIMER ***");
else{
 

CleSupprimer = ES.saisie("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n"+tabcde.getCLECommande()+
"\nVoulez Vous Supprimer quelle Commande:  ", 1);
Supprimer=tabcde.supprimerUneCommande(CleSupprimer);
if(Supprimer)ES.affiche("La Commande '"+ CleSupprimer +"' Vient d'être Supprimé !\n\n");
else ES.affiche("Le Numéro de Commande '"+ CleSupprimer +"' N' EXISTE PAS  !\n");}

}



private  void modifier(TablesDesArticles41 tabart, TablesDesCommandes41 tabCde) throws AbandonException, ErreurSaisie {
	if(tabCde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	 	
	int key = ES.saisie("\n********** LISTE des NUMEROS de COMMANDES PASSEES"
		+ " \n"+tabCde.getCLECommande()+"\n\n"
		+ "Entrer Le NUMERO DE COMMANDE à MODIFIER\n", 1);
  ES.affiche("VOUS ETES ENTRAIN DE MODIFIER LA COMMANDE Numéro: + "+key);
	if(tabCde.Retourner(key)!=null){
		
		 Commande41 <Integer> Cde = new Commande41<Integer>();
		 Cde.SetNumCde(key);
		 
		 GestionCommande41 gestUneCde = new GestionCommande41();
		 gestUneCde.menuGeneral(Cde, tabart); 
		
		 if(Cde!=null&&Cde.Taille()!=0){tabCde.ajouter(Cde);
		 
	}}}}


private  void afficherUneCommande(TablesDesArticles41 tabart, TablesDesCommandes41 tabcde) throws AbandonException, ErreurSaisie {
	 
	int CleAfficher;
	if(tabcde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	CleAfficher = ES.saisie ("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n\n"+tabcde.getCLECommande()+
	"\nVoulez Vous AFFICHER quelle Commande: ", 1);
	
	if(tabcde.Retourner(CleAfficher)!=null){
	ES.affiche(""+tabcde.Retourner(CleAfficher));
	}else ES.affiche("Le Numéro de Commande '"+ CleAfficher +"' N' EXISTE PAS  !\n");
	
}}

private  void afficherToutesLesCommandes(TablesDesArticles41 tabart, TablesDesCommandes41 tabcde) {
ES.affiche(tabcde.toString());
}


private  void editionFacture(TablesDesArticles41 tabart,TablesDesCommandes41 tabcde,Commande41<Integer> cde) throws AbandonException, ErreurSaisie {
	int CleEdiFacture;
	
	if(tabcde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR EDITER LA FACTURE ***");
	else{
	 
	CleEdiFacture = ES.saisie("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n" 
			+tabcde.getCLECommande()+ 
			"\nVoulez Vous EDITER la FACTURE pour quelle Commande: ", 1, Integer.MAX_VALUE);
	String Facture = tabcde.editerFactureTC(cde, tabart, CleEdiFacture);
	if(tabcde.Retourner(CleEdiFacture)!=null){
		
		ES.affiche("\n\t\t*** FACTURE COMMANDE  n°"+CleEdiFacture+" ***\n\n"+Facture+"\n");
	 
	
 
	                                                                                            
 
	
	
	}
	else  ES.affiche("Le Numéro de Commande '"+ CleEdiFacture +"' N' EXISTE PAS  !\n");}
	
}  
public static int premierNumero(TablesDesCommandes41 tabcde){
	 int num =1;
	 
	do{
		if(tabcde.Retourner(num)==null)return  num;
		 num++;
	}while(true);
}
}

//***************************FIN*** ////des Methodes pour La GESTION des COMMANDES/////
	

	
	
