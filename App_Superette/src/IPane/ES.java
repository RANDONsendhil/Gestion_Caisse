package IPane;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceES;
import javafx.scene.text.Font;

public class ES implements InterfaceES {
	
	public  void affiche(String mes){
		
		JTextArea text = new JTextArea ();
		
	 
 
		 text.setText(mes);
		 JOptionPane.showMessageDialog(null,text);
		 
				
	}
	
	
	public  int saisie(String mes, int inf, Object ...obj)throws AbandonException, ErreurSaisie{
		
		int nbparm = obj.length;
		int sup = Integer.MAX_VALUE;
		if(nbparm == 1)sup = (Integer) obj[0];
		 
	 
		String data = "";
		
		do{
		try{
			data=JOptionPane.showInputDialog(mes);
			if(data ==null)throw new AbandonException();
			int saisie = Integer.parseInt(data);
			if(saisie >=inf&&saisie<=sup) return saisie;
			 throw new ErreurSaisie();
			
			
		}catch (ErreurSaisie es){
			 
 
boolean abandon = saisieOuiNon("Saisie Hors INTERVALLE ! \n\nVoulez vous ABANDONNEZ ?");

if(abandon)throw new AbandonException();;
		}
		
		catch(NumberFormatException e){
			if(data.equals("")){
				affiche("Entrer Une VALEUR VALIDE !");
			}else{
				JOptionPane.showMessageDialog(null,"Saisie Non Numérique");
			
			}}
		
		catch(AbandonException abE){
			
			boolean abandon = saisieOuiNon("Voulez vous ABANDONNEZ ?");
			
			if(abandon)throw abE;
		}
		}while(true);
		}
		
public  float saisie(String mes, float inf, Object ...obj)throws AbandonException, ErreurSaisie{
		
		int nbparm = obj.length;
		float sup = Float.MAX_VALUE;
		if(nbparm == 1)sup = (Float) obj[0];
		 
		String data = "";
		
		do{
		try{
			data=JOptionPane.showInputDialog(mes);
			if(data ==null)throw new AbandonException();
			float saisie = Float.parseFloat(data);
			if(saisie >=inf&&saisie<=sup) return saisie;
			 throw new ErreurSaisie();
			
			
		}catch (ErreurSaisie es){
			 
			 
			boolean abandon = saisieOuiNon("Saisie Hors INTERVALLE ! \n\nVoulez vous ABANDONNEZ ?");

			if(abandon)throw new AbandonException();;
					}
					
					catch(NumberFormatException e){
						if(data.equals("")){
							affiche("Entrer Une VALEUR VALIDE !");
						}else{
							JOptionPane.showMessageDialog(null,"Saisie Non numeique");
						
						}}
					
					catch(AbandonException abE){
						
						boolean abandon = saisieOuiNon("Voulez vous ABANDONNEZ ?");
						
						if(abandon)throw abE;
					}
					}while(true);
					}
					
		

	public  boolean saisieOuiNon(String mes) {
	return JOptionPane.showConfirmDialog(null,  mes)==0; 
		
	 	}
	
	public   String saisie(String mes) throws AbandonException{
		
		 
		do{	String data = "";
		try{
			data = JOptionPane.showInputDialog(mes);
			if(data == null || data.equals("")) throw new AbandonException();
			else return data;
		}catch(AbandonException abE){
		}	
			 
		
		}while(true);	
	}



}
