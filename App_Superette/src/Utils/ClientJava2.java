package Utils;
 
import java.util.Scanner;

public class ClientJava2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
	int	Jour;
	int	Mois; 
	int	Annee; 
	boolean b = false;
	boolean bool =false;
	
	
	DateUser Client2 = new DateUser();
 
	do{ 
			 
	do{
		
		Jour= ClientJava.saisieEntier("Jour : ", 1, 31);

		Mois=ClientJava.saisieEntier("Mois : ", 1, 12);

		Annee=ClientJava.saisieEntier("Année : ", 1, Integer.MAX_VALUE);
		 
		 b = DateUser.validationDate(Jour, Mois, Annee);
	 
		 
		  
		 
		 bool=Client2.avant(Jour, Mois, Annee);
		
		 if(b){
					ClientJava.affiche("Date Validé! ");
					ClientJava.affiche("-------------");
			}else {	ClientJava.affiche("Date Erronée!\n");
					ClientJava.affiche("Réessayez.\n\r");}
			
			 }while(b==false);
	
			  
			
			 }while(bool ==false);
	
	 
	 
	DateUser DATESAISIE = new DateUser(Jour, Mois, Annee);	
	System.out.println();
	
	ClientJava.affiche("Date Actuelle\n"+Client2.toString());

	System.out.println("-----------------------");
	 

	ClientJava.affiche("Date demandée à calculer\n"+ DATESAISIE.toString());
 	Client2.age(Jour, Mois, Annee);

	System.out.println("-----------------------");
	Client2.afficherNaissance();
	System.out.println("-----------------------");
	Client2.jourDeSemaine(Jour, Mois, Annee);
	Client2.afficherjourDeLaSemaine();
	
	
	}

	 
	
	
}
