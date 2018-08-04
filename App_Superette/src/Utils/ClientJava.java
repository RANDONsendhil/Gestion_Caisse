package Utils;

import java.util.Scanner;

public class ClientJava {

	public static void main(String[] args) {
		 Scanner sc = new Scanner (System.in);
		 boolean b = false;
		 int Jour;
		 int Mois;
		 int Annee;
		 DateUser DATESAISIE;
		 DateUser DATELENDEMAIN;
		 
		 
		 
		 do{ 
			 
			 Jour = saisieEntier("Jour: ", 1, 31);
			 Mois = saisieEntier("Mois: ", 1, 12);
			 Annee = saisieEntier("Annee: ", 1, Integer.MAX_VALUE);

		 
		 
			b=DateUser.validationDate(Jour, Mois, Annee);
		 
			if(b){	affiche("Date Validé!\n");	}
			 else{ 	affiche("Date Erronée!\n");
					affiche("Réessayez.\n\r");}
		 			}while (b==false);
		
		 
		 	DATESAISIE = new DateUser(Jour, Mois, Annee);
		 
		 	System.out.println("------------------");
		 
		 	affiche("Date Saisie"+DATESAISIE.toString());
		 	System.out.println("------------------");
		  
		 	DATELENDEMAIN =new DateUser(Jour, Mois, Annee);
		 	
		 
			System.out.println();
			DATELENDEMAIN.dateLendemain();
			affiche( "Date de Lendemain\n"+	DATELENDEMAIN.toString());
			
			
			System.out.println();
			DATELENDEMAIN.dateLendemain();
			affiche("Sur Lendemain de la date de Saisie\n"+ 	DATELENDEMAIN.toString());
			System.out.println("------------------");
			System.out.println("");
			
			
			System.out.println();
			DATESAISIE.dateHier();
			affiche( "Date d' Hier par rapport à la Date De Saisie\n"+	DATESAISIE.toString());
			System.out.println();
			
			System.out.println();
			DATESAISIE.dateHier();
			affiche( "Sur Hier de la date de Saisie\n"+	DATESAISIE.toString());
			System.out.println("-------------------");
			  
	}
 //Cette méthode qui permet d'afficher la sortie
	public static void affiche(String mes) {
		System.out.print("\n" + mes);
	}
	

	//La méthode saisieEntier(), elle filtre les entrées des entier inférieur et supérieur.
	public static int saisieEntier(String mes, int inf, int sup) {
		int data;
		Scanner sc = new Scanner(System.in);		
		System.out.print("" + mes);
		do {
			data = sc.nextInt();
			if (data >= inf && data <= sup){ return data;}
			else{
			System.out.print("Saisie Invalide !(" + inf + "à" + sup + ")\nRéessayer Svp.\n");}
			 
		} while(true);
	}
	public static double saisieDouble(String mes, double inf, double sup) {
		double data;
		Scanner sc = new Scanner(System.in);		
		System.out.print("" + mes);
		do {
			data = sc.nextDouble();
			if (data >= inf && data <= sup){ return data;}
			else{
			System.out.print("Saisie Invalide !(" + inf + "à" + sup + ")\nRéessayer Svp.\n");}
			 
		} while(true);
	}
}
