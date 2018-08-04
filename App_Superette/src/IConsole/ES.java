package IConsole;

import java.util.InputMismatchException;
import java.util.Scanner;

import MesExceptions.AbandonException;

public class ES {
	
	private Scanner sc = new Scanner (System.in);
	
	
	public void affiche (String mes){
		System.out.print(mes);
	}
	
	public int saisie(String mes, int inf,Object...objects) throws AbandonException{
		
		int sup = Integer.MAX_VALUE;
		sup = (Integer)objects[0];
		
		affiche(mes);
		
		do{
			try{
			int data =sc.nextInt();
				sc.nextLine();
			
			if(data>=inf && data<=sup)return data;
			throw new AbandonException ();
			
			}catch(InputMismatchException e){
				affiche("\nFormat Numérique invalide !\n");
				affiche( "\n\t\t\t"+mes);
				 sc.nextLine();
			}catch(AbandonException abE){
			 boolean reponse = saisieOuiNon("\nSaisi Hors Intervalle ! Voulez Vous ABANDONNEZ ? o/n: ");
				if(reponse) throw abE; 
				affiche( "\n\t\t\t"+mes);
				 
			}
			
		}while(true);
		
		
	}
	 
	
	public boolean saisieOuiNon(String mes) {
		 
	affiche(mes);
	return (sc.next().substring(0).equalsIgnoreCase("o"));
	 
	}

	public String saisie(String mes){
		affiche(mes);
		String str = sc.next()+sc.nextLine();
		
		
		return str;
	}
	
	public float saisie(String mes, float inf,Object...objects) throws AbandonException{
		float sup = Float.MAX_VALUE;
		sup = (Float)objects[0];
		 		
		affiche(mes);
		
		do{
			try{
			float data =sc.nextFloat();
				sc.nextLine();
			
			if(data>=inf && data<=sup)return data;
			throw new AbandonException ();
			
			}catch(InputMismatchException e){
				affiche("\nFormat Numérique invalide !\n");
				affiche( "\n\t\t\t"+mes);
				 sc.nextLine();
			}catch(AbandonException abE){
				boolean reponse = saisieOuiNon("\nSaisi Hors Intervalle ! Voulez Vous ABANDONNEZ ? o/n: ");
				if(reponse) throw abE;
				affiche( "\n\t\t\t"+mes);
				 
			}
			
		}while(true);
	}
	
		 
	
	

}
