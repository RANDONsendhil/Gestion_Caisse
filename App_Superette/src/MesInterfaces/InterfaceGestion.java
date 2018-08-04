package MesInterfaces;

import Serie51.Commande51;

public interface InterfaceGestion <TypeStructure>{
	
public abstract void menuGeneral(TypeStructure tab, Object...objects)throws Exception;

//public void menuGeneral(TypeStructure tab, InterfaceStructure<?,?>...tab1) throws Exception;

public  abstract int menuChoix(Object...objects) throws Exception;
public abstract void creer(TypeStructure tab,Object...objects) throws Exception;
public abstract void supprimer(TypeStructure tab,  Object...objects) throws Exception; 
public abstract void modifier(TypeStructure tab,  Object...objects) throws Exception;
public abstract void afficher(TypeStructure tab)throws Exception;
 



}
