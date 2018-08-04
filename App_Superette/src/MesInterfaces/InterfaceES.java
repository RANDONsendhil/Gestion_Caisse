package MesInterfaces;

import MesExceptions.AbandonException;

public interface InterfaceES {
	
	public  void affiche(String mes);
	public  int saisie(String mes, int inf, Object ...obj)throws Exception;
	public  float saisie(String mes, float inf, Object ...obj)throws Exception;
	public  boolean saisieOuiNon(String mes);
	public   String saisie(String mes) throws AbandonException; 

}
