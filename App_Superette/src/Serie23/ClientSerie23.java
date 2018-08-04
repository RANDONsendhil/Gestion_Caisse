package Serie23;
import Utils.ClientJava;

public class ClientSerie23 {
    
	public static void main(String[] args) {
	
		TablesDesArticles22 Tabart = new TablesDesArticles22();
		Commande22<Integer> Cde  = new Commande22<Integer> ();
		TablesDesCommandes22 tabcde = new TablesDesCommandes22();
		
		
		
		GestionTablesDesArticles  GestTabArt = new GestionTablesDesArticles();
		GestionTablesDesCommandes GestTabCde = new GestionTablesDesCommandes();
		
		
		
		//menu principal///
		
		int choix;
		do{
		choix = MenuChoix();
		 
		 
		switch(choix){
		case 1 : GestTabArt.menuGeneral(Tabart, Cde, tabcde);  break;
		case 2 : GestTabCde.menuGeneral(Cde, Tabart, tabcde );  break;
		case 0 : break;
		}
		}while(choix!=0);
		 
		ClientJava.affiche("Au revoir... et à bientôt !");}
		 
	
	/************************************************************************************************
	 							*AFFICHAGE DU MENU//////   */
	
	public static int MenuChoix(){
		
		String menu = "\t\t\tBIENVENUE A LA SUPERETTE \n\n" +
					  "\t\t\tGestion Des Articles ..........1\n" +
					  "\t\t\tGestion des COMMANDES..........2\n" +
					  "\t\t\tFIN............................0\n\n" +
					  
					  "\t\t\t";
		ClientJava.affiche(menu);
		return ClientJava.saisieEntier("Choix: ", 0, 2);
		
	}} 

 

  


