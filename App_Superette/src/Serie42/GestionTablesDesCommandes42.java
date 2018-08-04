package Serie42;

 
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;

 
public class GestionTablesDesCommandes42 implements InterfaceGestion<TablesDesCommandes42>{
	
	

	private	ES ES = new ES();	
	public GestionTablesDesCommandes42(){}
 
	
 
	public void menuGeneral(TablesDesCommandes42 TabCde,  Object...objects) throws AbandonException, ErreurSaisie {
		
		
		TablesDesArticles42 Tabart = (TablesDesArticles42)objects[0];
		
		Commande42<Integer> cde = new Commande42<Integer>() ;
	
	 		int choix; 
	 		  	 		
	 	 do{ 
	 		  	 		 
	 		 int num =premierNumero(TabCde);
	 		 choix = menuChoix(num);

		switch (choix){
		case 1 : creer(TabCde,Tabart, num) ; break;
		case 2 : supprimer(TabCde,Tabart);break;
		case 3 : afficherUneCommande(Tabart, TabCde);break;
		case 4 : afficher ( TabCde); break;
		case 5 : modifier( TabCde,Tabart);break;
		case 6 : editionFacture(Tabart,TabCde, cde);break;
		case 0 : break; 
			  
		}} 
	 	 while(choix!=0); 
		}
		
public  int menuChoix(Object...objects) throws AbandonException, ErreurSaisie {
	
		int num = (Integer)objects[0];
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
 



public  void creer(TablesDesCommandes42 tabCde, Object...objects) throws AbandonException, ErreurSaisie {
	
	
	 TablesDesArticles42 tabart = (TablesDesArticles42)objects[0];
	
 
	
	int num =(Integer)objects[1];
	Commande42 <Integer> Cde = new Commande42<Integer>();
	
	Cde.SetNumCde( num);
	GestionCommande42 gestUneCde = new GestionCommande42();
	gestUneCde.menuGeneral(Cde, tabart); 
	if(Cde!=null&&Cde.taille()!=0){tabCde.ajouter(Cde);
	 
	 	}
}
	

public  void supprimer(TablesDesCommandes42 tabCde,  Object...objects) throws AbandonException, ErreurSaisie {
 
int CleSupprimer=0;
if(tabCde.taille()==0){ES.affiche("\n*** PAS COMMANDE EN COURS POUR SUPPRIMER ***");}



else if(tabCde.getCLECommande()!=null){
	CleSupprimer = ES.saisie("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n"+tabCde.getCLECommande()+
"\nVoulez Vous Supprimer quelle Commande:  ", 1);
	if(CleSupprimer ==tabCde.getNumeroCommande()){ES.affiche("La Commande '"+ CleSupprimer +"' Vient d'être Supprimé !\n\n");}
	else { ES.affiche("Le Numéro de Commande '"+ CleSupprimer +"' N' EXISTE PAS  !\n");}
 tabCde.supprimer(CleSupprimer);
 
 
 }

}
 


public  void modifier(TablesDesCommandes42 tabCde , Object...objects) throws AbandonException, ErreurSaisie {

	 

	 TablesDesArticles42 tabart = (TablesDesArticles42)objects[0];
	
	if(tabCde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	 	
	int key = ES.saisie("\n********** LISTE des NUMEROS de COMMANDES PASSEES"
		+ " \n"+tabCde.getCLECommande()+"\n\n"
		+ "Entrer Le NUMERO DE COMMANDE à MODIFIER\n", 1);
  ES.affiche("VOUS ETES ENTRAIN DE MODIFIER LA COMMANDE Numéro:  "+key);
	if(tabCde.retourner(key)!=null){
		
		 Commande42 <Integer> Cde = new Commande42<Integer>();
		 Cde.SetNumCde(key);
		 
		 GestionCommande42 gestUneCde = new GestionCommande42();
		 gestUneCde.menuGeneral(Cde, tabart); 
		
		 if(Cde!=null&&Cde.taille()!=0){tabCde.ajouter(Cde);
		 
	}}}}


private  void afficherUneCommande(TablesDesArticles42 tabart, Object...objects) throws AbandonException, ErreurSaisie {
	
	TablesDesCommandes42 tabcde = (TablesDesCommandes42)objects[0];
	
	int CleAfficher;
	if(tabcde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR AFFICHER ***");
	else{
	CleAfficher = ES.saisie ("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n\n"+tabcde.getCLECommande()+
	"\nVoulez Vous AFFICHER quelle Commande: ", 1);
	
	if(tabcde.retourner(CleAfficher)!=null){
	ES.affiche(""+tabcde.retourner(CleAfficher));
	}else ES.affiche("Le Numéro de Commande '"+ CleAfficher +"' N' EXISTE PAS  !\n");
	
}}

public  void afficher ( TablesDesCommandes42 tabcde) {
	

 
	
ES.affiche(tabcde.toString());
}


private  void editionFacture(TablesDesArticles42 tabart,TablesDesCommandes42 tabcde,Commande42<Integer> cde) throws AbandonException, ErreurSaisie {
	int CleEdiFacture;
	
	if(tabcde.taille()==0)ES.affiche("\n*** PAS COMMANDE EN COURS POUR EDITER LA FACTURE ***");
	else{
	 
	CleEdiFacture = ES.saisie("\n********** LISTE des NUMEROS des COMMANDES PASSEES\n" 
			+tabcde.getCLECommande()+ 
			"\nVoulez Vous EDITER la FACTURE pour quelle Commande: ", 1, Integer.MAX_VALUE);
	String Facture = tabcde.editerFactureTC(cde, tabart, CleEdiFacture);
	if(tabcde.retourner(CleEdiFacture)!=null){
		
		ES.affiche("\n\t\t*** FACTURE COMMANDE  n°"+CleEdiFacture+" ***\n\n"+Facture+"\n");
	 
	
	
	
	}
	else  ES.affiche("Le Numéro de Commande '"+ CleEdiFacture +"' N' EXISTE PAS  !\n");}
	
}  
public static int premierNumero(TablesDesCommandes42 tabcde){
	 int num =1;
	 
	do{
		if(tabcde.retourner(num)==null)return  num;
		 num++;
	}while(true);
}


 
 

 

 
}

//***************************FIN*** ////des Methodes pour La GESTION des COMMANDES/////
	

	
	
