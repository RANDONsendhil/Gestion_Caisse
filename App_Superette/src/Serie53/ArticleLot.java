package Serie53;

import java.io.Serializable;

import Utils.DateUser;

public class ArticleLot extends ArticleAbstrait53 implements Serializable {

	 
	private int quantiteLot;
	private float reductionPourcentage;
	DateUser dateDebut; 
	private DateUser dateFin;
	
	public ArticleLot(int code, String designation, float pu, float  reductionPourcentage,int quantiteLot, DateUser dateDebut,DateUser dateFin ){
		this.code = code;
		this.designation =designation;
		this.pu =pu;
		this.quantiteLot = quantiteLot;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.reductionPourcentage = reductionPourcentage;
		
	}
	
	
	
	 
	public String toString(){
		 
		return "**CODE: "+ getCode() +" **DESIGNATION: "+getDesignation()+ " **PRIX: "+ getPU()+   "**PROMO Reduction "+reductionPourcentage+"%"+ 
		" **Un Lot De "+quantiteLot+" Articles \n***Date de debut de Promotion en Lot "+ dateDebut +"jusqu'au "+dateFin ;
		 
	}
	 

 
	public float prixFacturer(int quantite) {
		
		
		float prixApresRemise = 0f ;
		int reste =   quantite%quantiteLot;
		DateUser dateActuelle = new DateUser();
		if( dateFin.avant(dateActuelle.getJour(), dateActuelle.getMois(), dateActuelle.getAnnee())){
		if(quantite>=quantiteLot){
		
		
			
			prixApresRemise =   ((((quantite-reste) *pu)*reductionPourcentage) /100);
			prixApresRemise = (quantite*pu)-prixApresRemise;
			 return prixApresRemise ;
		} 

		return pu*quantite;
		 
		}
		return pu*quantite;
		
	}

	 
	public String getInfoReduction() {
		DateUser dateActuelle = new DateUser();
		String str ="";
		if( dateFin.avant(dateActuelle.getJour(), dateActuelle.getMois(), dateActuelle.getAnnee())){
		
			str= " -->(remise: "+reductionPourcentage+" % lot de " + quantiteLot+" jusqu'au "+dateFin+")";
		} return str;
	}
 
	
	public DateUser getDateFin(){
		return dateFin;
		
	}
	
	 public String typeDePromotion(){
		 DateUser dateActuelle = new DateUser();
		 String str ="";
		 if( dateFin.avant(dateActuelle.getJour(), dateActuelle.getMois(), dateActuelle.getAnnee())){
				
			  str ="\t\t***** ARTICLE EN PROMOTION *****\n REMISE DE : "+reductionPourcentage+" % pour un LOT de ***" + quantiteLot+ " ARTICLE *** de "+dateDebut+ " jusqu'au "+dateFin+" \n"; }
			return str;
		
		}
}
