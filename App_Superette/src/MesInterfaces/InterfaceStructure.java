package MesInterfaces;

 

public interface InterfaceStructure <Metier, TypeDeLaCle> {
	
	public  abstract String toString(); 
	public abstract Metier retourner(TypeDeLaCle cle); 
	public abstract void ajouter(Metier metier);
	public abstract void supprimer (TypeDeLaCle cle);
	public abstract int taille();

	
	

 	 	


	

 
	 
		
	
}
