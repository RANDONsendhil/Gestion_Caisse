package Serie21;
import java.util.*;
public class TablesDesArticles {
	private Vector<Article>Tabart;
	
	
	public TablesDesArticles(Vector<Article> tabart){
		
		this.Tabart = tabart;
	}
	
	public TablesDesArticles(){
		Tabart = new Vector<Article>();
		Article Art1 = new Article(1, "DisqueDur", 50.23f );
		Article Art2 = new Article(2, "Processor", 50.65f);
		Article Art3 = new Article(3, "Clavier ", 50.89f );
		Article Art4 = new Article(4, "Ram     ", 50.96f );
		Article Art5 = new Article(5, "CleUsb  ", 50.26f );
		
		Tabart.addElement(Art1);
		Tabart.addElement(Art2);
		Tabart.addElement(Art3);
		Tabart.addElement(Art4);
		Tabart.addElement(Art5);
			}
	
	
	public String toString(){
		
		String str = "";
		
		for (Article Art: Tabart){
			
			str = str+Art.toString()+"\n";
			 
		}
		return str;
	}
	
	public int Taille(){
	return Tabart.size();
	}
	
	public Article Retourner(int code){
		
		for(Article Art: Tabart){
			if(Art.GetCode()==code){
				return Art;
			}
			
		}return null;
	}

	
	public void Ajouter(Article Art){
		Tabart.addElement(Art);
		
	}
	
	public void Supprimer (int code){
		
		for (int i = 0; i<Taille(); i++){
			
			if(Tabart.get(i).GetCode()==code){
				Tabart.remove(i);
			}
		}
	}
	
}
