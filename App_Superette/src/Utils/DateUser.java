package Utils;

import java.io.Serializable;
import java.util.Calendar;

public class DateUser implements  Serializable {
	
	  	private int jour;
	    private int mois;
	    private int annee;
	      
	    int  agejour;
	    int agemois;
	    int ageannee;
	    String trouverJourDeSemaine;	
	    
	public DateUser(int D, int M, int A){
		this.jour  = D;
		this.mois  = M;
		this.annee = A;
		
		
	}
	public DateUser(){
		
		Calendar CD = Calendar.getInstance();
		 
		jour  = CD.get(Calendar.DAY_OF_MONTH);
		mois  = 1+CD.get(Calendar.MONTH);
		annee = CD.get(Calendar.YEAR);
	}
	


	public int getJour(){return jour;}
	public int getMois(){return mois;}
	public int getAnnee(){return annee;}
	
	//La méthode toString() pour afficher le résultat sous forme de String.
	
	public String toString() {
		return ("" + jour + "-" + mois + "-" + annee + "");
	}

	
	//La méthode toString() pour afficher Age de la date Saisie.
	public void afficherNaissance(){
		System.out.println("Age de Votre Date soit:");
		System.out.println( agemois+ " mois\n"+ageannee+" Année(s): ");
	}
	
	 
	//La méthode jourDeSemaine () qui calcule et affiche le jour de la semaine par rapport à la date de saisie.
	public void afficherjourDeLaSemaine(){
		
		System.out.println("Le jour de la Semaine de la date Saisie est:  "+trouverJourDeSemaine);
	}
	
	//La Méthode Bissextile () qui calcule les années bissextiles.
	public static boolean bissextile(int annee){
		boolean bool = false;
		if((annee%400==0)||(annee%100!=0)&&(annee%4==0)){
			bool = true;
		}
				return bool;
	}
	 
	
	//La Méthode ValidationDate() qui valide la date passée en paramètre par le Client Java.
	 public  static boolean validationDate(int jour, int mois, int annee){
		 
		 return jour <= nbMaxjours(mois, annee);
		 
	 }
	 
	 //La Méthode DateLendemain() qui retourne  la date du Lendemain.
	 public void dateLendemain(){
		 
		jour++;
			if ( jour > nbMaxjours( mois,  annee)) {
				 jour = 1;
				mois++;
				if (mois > 12) {
					 mois = 1;
					 annee++;
					 
					
}}}
	 
	 
	 //La Méthode DateHier() qui retourne la date d’hier.
	 public void dateHier(){
		  jour--;
			if ( jour < 1) {
				 mois--;
				if (mois < 1) {
					mois = 12;
					annee--;
				}
				 jour = nbMaxjours(mois, annee);
			}

		 
	 }
	//La Méthode nbMaxjours() qui calcule le jour maximum dans un mois.
	 public static int nbMaxjours(int mois, int annee) {
			switch(mois) {
			case 4: case 6: case 9: case 11: return 30;
			case 2: if(bissextile(annee)) return 29; else return 28;
			default: return 31;
			}
	 }
	 
	 //La méthode avant() qui compare la date de système et la date saisie.
	 public boolean avant (int dateclient, int moisclient, int anneeclient){
		boolean EnvoiTrue = false;
		
		if((((anneeclient<annee)&&(moisclient!=mois))&&(dateclient!=jour))
				 ||((moisclient<mois)&&(anneeclient==annee)&&(dateclient!=jour))||(
				 (moisclient==mois)&&(anneeclient==annee)&&(dateclient< jour))||
				 ((moisclient<mois)&&(anneeclient==annee))||
				 (anneeclient<annee))
				 
			 
				 
			{
			EnvoiTrue=true;
			
		 
		 }
		  return EnvoiTrue;
		 
	 }

	    
		//La méthode age() qui calcule l’âge de la date saisie.
	 public void age(int dateclient, int moisclient, int anneeclient ){
		 boolean  b = bissextile(annee);
		 if(anneeclient==annee ){
			   agejour = 31-dateclient+jour;
			   agemois =  mois- moisclient;
			   			    
			    agemois--;
			    agejour--;
			    
			   if(agejour>=30){
				   agejour = agejour-30;
				   agemois++;
			   }
			    
			    
		   }else if(annee>anneeclient){
			   ageannee  = annee-anneeclient-1;
			   agemois =  mois+ (12-moisclient)-1;
			   agejour =  31-dateclient+jour;
			   
			  
			   if(agejour>=31){
				   
				   agejour = agejour-31;
				   agemois++;
				    	   
				   
			   } 
			   else if(agejour>=30){
				   
				   agejour = agejour-30;
				   agemois++;
				    
				   
			   }
			   if(agemois>=12){
				   agemois = agemois-12;
				   ageannee++;
				   
			   }
		   }}
		
	 public DateUser ajouterNombrejours(int nbj){
			DateUser d = this;
			
			for(  int i = 0 ; i <nbj ; i++){
				
			d.dateLendemain();
				
			}
			 return d;
		}
	 
	 public DateUser decrementeNombrejours(int nbj){
			DateUser d = this;
			
			for(  int i = 0 ; i <nbj ; i++){
				
			d.dateHier();
				
			}
			 return d;
		}
	 
	 
	 
	 
	 
	//La méthode jourDeSemaine () qui calcule et affiche le jour de la semaine par rapport à la date de saisie
	 public void jourDeSemaine(int dateclient, int moisclient, int anneeclient){
		 
		 if(moisclient == 1||moisclient==2){
			 anneeclient--;
			}
			
			int sZ =anneeclient/100; 
			int aZ= anneeclient%100; 
			
			 
			int Z;
			
			int mZ = moisZeller( moisclient);
			 Z =   ((int)(2.6 * mZ - 0.2) + dateclient + aZ + (int)(aZ/4) + (int)(sZ/4) - 2*sZ)%7 ;
			 
			 if(Z<0) Z+=7;
			 
			 
			 String J ;
			
			
			 switch(Z){
				
			case 1 :   J ="Lundi";break;
			case 2 :   J ="Mardi";break;
			case 3 :   J ="Mercredi";break;
			case 4 :   J ="Jeudi";break;
			case 5 :   J ="Vendredi";break;
			case 6 :   J ="Samedi";break;
			case 7 :   J ="Dimanche";break;
			case 0 :   J ="Dimanche";break;
			
			default: J = "Erreur De Case !";
		    break;
				
			 }trouverJourDeSemaine = J;
		 
			 }
	//La Méthode envoie le mois Zeller en entier pour pouvoir calculer par la methode 	jourDeSemaine()
	 public  int moisZeller( int mois){
	 	int  M = 0;
	 	
	 	if(mois==3){
	 		return 1;
	 	}else if(mois ==4){
	 		return 2;
	 		
	 	}else if(mois ==5){
	 		return 3;
	 		
	 	}else if(mois ==6){
	 		return 4;
	 		
	 	}else if(mois ==7){
	 		return 5;
	 		
	 	}else if(mois ==8){
	 		return 6;
	 		
	 	}else if(mois ==9){
	 		return 7;
	 		
	 	}else if(mois ==10){
	 		return 8;
	 		
	 	}else if(mois ==11){
	 		return 9;
	 		
	 	}else if(mois ==12){
	 		return 10;
	 		
	 	}else if(mois ==1){
	 		return 11;
	 		
	 	}else 
	 		return 12;
	 	
	 }}



