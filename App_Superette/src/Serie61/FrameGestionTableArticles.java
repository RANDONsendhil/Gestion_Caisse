package Serie61;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Connexion.ConnexionFichier;
import IPane.ES;
import MesExceptions.AbandonException;
import MesExceptions.ErreurSaisie;
import MesInterfaces.InterfaceGestion;
import Serie53.Article53;
import Serie53.ArticleAbstrait53;
import Serie53.TablesDesArticles53;

public class FrameGestionTableArticles extends JFrame implements ActionListener, InterfaceGestion<TablesDesArticles53> {

	 

	ES ES = new ES();
	
	
	TablesDesArticles53 tabart  ;
	
	 ConnexionFichier<TablesDesArticles53>  fichArt; //establish Connection///
	   
	 
	public 	FrameGestionTableArticles(String nomPhysique){
			
			fichArt = new ConnexionFichier<TablesDesArticles53>(nomPhysique);
			
		}
		 
		
		///La methode qui recupere la tables des articles ///
		
		public TablesDesArticles53 recupere(){
			
			TablesDesArticles53 tabart = fichArt.lire();
			if(tabart == null){
				tabart = new TablesDesArticles53();
			}
			return tabart;
		}
		
		public void sauvegarder(TablesDesArticles53 tabart){
			
			ES.affiche("**SAUVEGARDE DES ARTICLES EN COURS... *** ");
			fichArt.ecrie(tabart);
		}
		
		 
	
		int codesu; 
	JButton b1,b2,b3,b4,b5;
	JFrame frmmodifierArticles;
	  JFrame frmCreationDesArticles;
	  JTextField setCode;
	  JTextField setDesingnation;
	  JTextField setPrix;
	  JTextField setReduction;
	  JTextField setQuantite;
	  JTextField setQtitLot ;
	  JLabel labelQuantiteLot;
	  JLabel lblQuantiteMini;
	  JLabel labelPromoRedu;
	  JLabel  labelPrix;
	  JLabel labelCode;
	  JLabel labelDesig;
	  int code; 
	  String designation;
	  float prix = 0f;
	  int codemodif;

	  JFrame frmSuppimerDesArticles;
	  JTextField textGetCodeVerif;
	  JTextField codeSupprimer;
	  JTextField getSupprDesingation;
	  
	  JTextField getPrixSupp;
	  
	  
	  
	   
	  
	  public void menuGeneral(TablesDesArticles53 tabart) throws AbandonException, ErreurSaisie{
			this.tabart = tabart;
			
			Container container  = getContentPane();
			 container.setLayout(new GridLayout(5,5,0,0));
				
			 
			 	b1 = new JButton("CREATION DES ARTICLES");
		 	  	b2 = new JButton("SUPPRESSION DES ARTICLES");
				b3 = new JButton("MODIFIER UN ARTICLE");
				b4 = new JButton("AFFICHER LES STOCK");
				b5   = new JButton("RETOUR AU MENU");
				
			
				b1.addActionListener(this);
				b2.addActionListener(this);
				b3.addActionListener(this);
				b4.addActionListener(this);
				b5.addActionListener(this);
				 
				container.add(b1);container.add(b2);container.add(b3);container.add(b4);container.add(b5);
				this.setTitle("MENU GESTION DES ARTICLES");
				setSize(400,400);
				this.setLocationRelativeTo(null);
				this.setVisible(true);
			
		}	
	
	public FrameGestionTableArticles(){}
	

	 
	public void actionPerformed(ActionEvent evt ) {
	 
		
		 if(evt.getSource() == b1){
			// ES.affiche("TABLES EN COURS DE CONSTRUCTIONS...");
			 try {
				creer(tabart);
			} catch (AbandonException e) {
				 
				e.printStackTrace();
			} catch (ErreurSaisie e) {
				 
				e.printStackTrace();
			}
			
			// this.setVisible(false);
			
			 }  if(evt.getSource() == b2){
				 supprimerArt(tabart);
				
				 
			 }  if(evt.getSource() == b3){
				 modifier();
			 }  if(evt.getSource() == b4){
				
				  afficher();
				//this.setVisible(true);
					 
			 }  if(evt.getSource() == b5){
			  					 
				 
				   
				 this.setVisible(false);
				 		 }
	}
	
 
	public void modifier() {

		 
		frmmodifierArticles = new JFrame();
		frmmodifierArticles.setSize(550, 550);
		frmmodifierArticles.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmmodifierArticles.getContentPane().setLayout(null);
		frmmodifierArticles.setVisible(true);
		frmmodifierArticles.setLocationRelativeTo(null);
		JLabel lblSuppressionDunArticle = new JLabel("MODIFIER D'UN ARTICLE");
		lblSuppressionDunArticle.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSuppressionDunArticle.setBounds(148, 11, 247, 28);
		frmmodifierArticles.getContentPane().add(lblSuppressionDunArticle);
		
		JLabel lblEntrerLeCode = new JLabel("ENTRER LE CODE ARTICLE:");
		lblEntrerLeCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEntrerLeCode.setBounds(51, 127, 185, 14);
		frmmodifierArticles.getContentPane().add(lblEntrerLeCode);
		 
		textGetCodeVerif = new JTextField();
		textGetCodeVerif.setBounds(276, 126, 107, 20);
		frmmodifierArticles.getContentPane().add(textGetCodeVerif);
		textGetCodeVerif.setColumns(10);
		
		JLabel errorCode = new JLabel("");
		
		errorCode.setBounds(391, 129, 117, 14);
		frmmodifierArticles.getContentPane().add(errorCode);
		Font font = new Font("Verdana", Font.BOLD, 12);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(277, 54, 247, 61);
		frmmodifierArticles.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea("\n"+tabart.afficherKEYtabart());
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setFont(font);
		scrollPane.setViewportView(textArea);
		
		
		JButton buttonVerfier = new JButton("VERIFIER");
		buttonVerfier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codesu = Integer.parseInt(textGetCodeVerif.getText());
				
				
				if(tabart.retourner(codesu)!=null){
					float setprixsupp = tabart.retourner(codesu).getPU();
					
					String prixsupp = String.valueOf(setprixsupp);
					String Getd = tabart.retourner(codesu).getDesignation();
					
					String design = Getd;
					codeSupprimer.setText(String.valueOf(codesu));
					codeSupprimer.disable();
					getSupprDesingation.setText("VEUILLEZ ENTRER LA DESIGNATION");
					getPrixSupp.setText("VEUILLEZ ENTRE LE NOUVEAU PRIX");
					
					
				}else{
					errorCode.setForeground(Color.RED);
					errorCode.setText("CODE NON-RECONNU");
				}
				
			}
		});
			
		
		
		buttonVerfier.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonVerfier.setBounds(276, 157, 107, 23);
		frmmodifierArticles.getContentPane().add(buttonVerfier);
		
		JLabel labelCodeDisponible = new JLabel("CODES DISPONIBLE : ");
		labelCodeDisponible.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCodeDisponible.setBounds(89, 83, 177, 14);
		frmmodifierArticles.getContentPane().add(labelCodeDisponible);
		
		 
		JLabel lblCode = new JLabel("CODE :");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCode.setBounds(191, 216, 75, 28);
		frmmodifierArticles.getContentPane().add(lblCode);
		
		JLabel lblDesignation = new JLabel("DESIGNATION :");
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDesignation.setBounds(132, 268, 118, 14);
		frmmodifierArticles.getContentPane().add(lblDesignation);
		
		JLabel lblNewLabel_1 = new JLabel("PRIX :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(202, 314, 53, 14);
		frmmodifierArticles.getContentPane().add(lblNewLabel_1);
		
		codeSupprimer = new JTextField();
		codeSupprimer.setBounds(276, 222, 232, 22);
		frmmodifierArticles.getContentPane().add(codeSupprimer);
		codeSupprimer.setColumns(10);
		
		getSupprDesingation = new JTextField();
		getSupprDesingation.setBounds(276, 262, 232, 20);
		frmmodifierArticles.getContentPane().add(getSupprDesingation);
		getSupprDesingation.setColumns(10);
		
		getPrixSupp = new JTextField();
		getPrixSupp.setBounds(278, 308, 230, 20);
		frmmodifierArticles.getContentPane().add(getPrixSupp);
		getPrixSupp.setColumns(10);
		
		JButton abandonnerButton = new JButton("ABANDONNER");
		abandonnerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		abandonnerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmmodifierArticles.dispose();
			}
		});
		abandonnerButton.setBounds(89, 387, 152, 40);
		frmmodifierArticles.getContentPane().add(abandonnerButton);
		
		JButton supprimerButton = new JButton("MODIFIER");
		supprimerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codemodif = Integer.parseInt(codeSupprimer.getText());
				 designation = getSupprDesingation.getText();
				  prix = Float.parseFloat(getPrixSupp.getText());
				 ArticleAbstrait53 Art = new Article53(codemodif,designation,prix);
				 
				 tabart.ajouter(Art) ;
				 frmmodifierArticles.dispose();
				 ES.affiche("L'Article Vient être modifié !");			}
		});
		supprimerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		supprimerButton.setBounds(316, 383, 152, 44);
		frmmodifierArticles.getContentPane().add(supprimerButton);
		Font font1 = new Font("Verdana", Font.BOLD, 12);
		 
		 
		
		
		
	}
	public void supprimerArt(TablesDesArticles53 tabart1) {
		
	
		frmSuppimerDesArticles = new JFrame();
		frmSuppimerDesArticles.setSize(550, 550);
		frmSuppimerDesArticles.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frmSuppimerDesArticles.getContentPane().setLayout(null);
		frmSuppimerDesArticles.setVisible(true);
		frmSuppimerDesArticles.setLocationRelativeTo(null);
		JLabel lblSuppressionDunArticle = new JLabel("SUPPRESSION D'UN ARTICLE");
		lblSuppressionDunArticle.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblSuppressionDunArticle.setBounds(148, 11, 247, 28);
		frmSuppimerDesArticles.getContentPane().add(lblSuppressionDunArticle);
		
		JLabel lblEntrerLeCode = new JLabel("ENTRER LE CODE ARTICLE:");
		lblEntrerLeCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEntrerLeCode.setBounds(51, 127, 185, 14);
		frmSuppimerDesArticles.getContentPane().add(lblEntrerLeCode);
		 
		textGetCodeVerif = new JTextField();
		textGetCodeVerif.setBounds(276, 126, 107, 20);
		frmSuppimerDesArticles.getContentPane().add(textGetCodeVerif);
		textGetCodeVerif.setColumns(10);
		
		JLabel errorCode = new JLabel("");
		
		errorCode.setBounds(391, 129, 117, 14);
		frmSuppimerDesArticles.getContentPane().add(errorCode);
		Font font = new Font("Verdana", Font.BOLD, 12);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(277, 54, 247, 61);
		frmSuppimerDesArticles.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea("\n"+tabart.afficherKEYtabart());
		textArea.setForeground(Color.WHITE);
		textArea.setBackground(Color.BLACK);
		textArea.setFont(font);
		scrollPane.setViewportView(textArea);
		
		
		JButton buttonVerfier = new JButton("VERIFIER");
		buttonVerfier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(textGetCodeVerif.getText()==null ){
					errorCode.setText("Entrer le Code Article");
					errorCode.setForeground(Color.RED);
					
				
					}else{
					
					codesu = Integer.parseInt(textGetCodeVerif.getText());
					
					
					if(tabart.retourner(codesu)!=null){
						float setprixsupp = tabart.retourner(codesu).getPU();
						String prixsupp = String.valueOf(setprixsupp);
						String Getd = tabart.retourner(codesu).getDesignation();
						
						String design = Getd;
						codeSupprimer.setText(String.valueOf(codesu));
						getSupprDesingation.setText(Getd);
						getPrixSupp.setText(String.valueOf(prixsupp ));
						
				}else{
					errorCode.setForeground(Color.RED);
					errorCode.setText("CODE NON-RECONNU");
				
				
			
					
				}
				 
				
			}
				
			}
		});
		
		
		
		
		
		buttonVerfier.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonVerfier.setBounds(276, 157, 107, 23);
		frmSuppimerDesArticles.getContentPane().add(buttonVerfier);
		
		JLabel labelCodeDisponible = new JLabel("CODES DISPONIBLE : ");
		labelCodeDisponible.setFont(new Font("Tahoma", Font.PLAIN, 15));
		labelCodeDisponible.setBounds(89, 83, 177, 14);
		frmSuppimerDesArticles.getContentPane().add(labelCodeDisponible);
		
		 
		JLabel lblCode = new JLabel("CODE :");
		lblCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCode.setBounds(191, 216, 75, 28);
		frmSuppimerDesArticles.getContentPane().add(lblCode);
		
		JLabel lblDesignation = new JLabel("DESIGNATION :");
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDesignation.setBounds(132, 268, 118, 14);
		frmSuppimerDesArticles.getContentPane().add(lblDesignation);
		
		JLabel lblNewLabel_1 = new JLabel("PRIX :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(202, 314, 53, 14);
		frmSuppimerDesArticles.getContentPane().add(lblNewLabel_1);
		
		codeSupprimer = new JTextField();
		codeSupprimer.setBounds(276, 222, 232, 22);
		frmSuppimerDesArticles.getContentPane().add(codeSupprimer);
		codeSupprimer.setColumns(10);
		
		getSupprDesingation = new JTextField();
		getSupprDesingation.setBounds(276, 262, 232, 20);
		frmSuppimerDesArticles.getContentPane().add(getSupprDesingation);
		getSupprDesingation.setColumns(10);
		
		getPrixSupp = new JTextField();
		getPrixSupp.setBounds(278, 308, 230, 20);
		frmSuppimerDesArticles.getContentPane().add(getPrixSupp);
		getPrixSupp.setColumns(10);
		
		JButton abandonnerButton = new JButton("ABANDONNER");
		abandonnerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		abandonnerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmSuppimerDesArticles.dispose();
			}
		});
		abandonnerButton.setBounds(89, 387, 152, 40);
		frmSuppimerDesArticles.getContentPane().add(abandonnerButton);
		
		JButton supprimerButton = new JButton("SUPPRIMER");
		supprimerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabart.supprimer( codesu);
				ES.affiche("L'article "+codesu+ "vient d'être supprime");
				frmSuppimerDesArticles.dispose();
			}
		});
		supprimerButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		supprimerButton.setBounds(316, 383, 152, 44);
		frmSuppimerDesArticles.getContentPane().add(supprimerButton);
		Font font1 = new Font("Verdana", Font.BOLD, 12);
		 
		 
		
		
	}
	public   void creer(TablesDesArticles53 tabart) throws AbandonException, ErreurSaisie{
		

			 
			frmCreationDesArticles = new JFrame();
			frmCreationDesArticles.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
			frmCreationDesArticles.setTitle("CREATION DES ARTICLES");
			frmCreationDesArticles.setResizable(false);
			frmCreationDesArticles.getContentPane().setLayout(null);
			
			JLabel lblNewLabel = new JLabel("CREATION DES ARTICLES");
			lblNewLabel.setBounds(122, 0, 223, 40);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
			frmCreationDesArticles.getContentPane().add(lblNewLabel);
			
			
			
			
			JComboBox<String> comboBox = new JComboBox<String>();
		 
		  
			
			comboBox.setBounds(173, 119, 199, 20);
			frmCreationDesArticles.getContentPane().add(comboBox);
			comboBox.addItem("ARTICLE");
			comboBox.addItem("ARTICLE PROMO");
			comboBox.addItem("ARTICLE LOT");
			 
			
			 
			
	comboBox.addActionListener(new ActionListener() {
		
				public void actionPerformed(ActionEvent e) {

					
					if(e.getSource() ==  comboBox ){
					 
						 if( comboBox.getSelectedItem().equals("ARTICLE PROMO")){
							 setQtitLot.setEnabled(false);
							 setReduction.setEnabled(true);
							  
							  setQuantite.setEnabled(true);
							  lblQuantiteMini.setEnabled(true);
							  labelPromoRedu.setEnabled(true);
							  setQtitLot.setEnabled(true);
							  
							  setPrix.setEnabled(true);
							  labelPrix.setEnabled(true);
							  labelCode.setEnabled(true);
							  setCode.setEnabled(true);
							  labelDesig.setEnabled(true);
							  setDesingnation.setEnabled(true);
							  
							 setQtitLot.setEnabled(false);
							 labelQuantiteLot.setEnabled(false);
						 }
						 
						   if( comboBox.getSelectedItem().equals("ARTICLE")){
							 setQtitLot.setEnabled(false);
							 setReduction.setEnabled(false);
							  
							  setQuantite.setEnabled(false);
							  lblQuantiteMini.setEnabled(false);
							  labelPromoRedu.setEnabled(false);
							  setQtitLot.setEnabled(false);
							  
							  setPrix.setEnabled(true);
							  labelPrix.setEnabled(true);
							  labelCode.setEnabled(true);
							  setCode.setEnabled(true);
							  labelDesig.setEnabled(true);
							  setDesingnation.setEnabled(true);
							  labelQuantiteLot.setEnabled(false);
							  
							  
						 }
						   if( comboBox.getSelectedItem().equals("ARTICLE LOT")){
								 setQtitLot.setEnabled(false);
								 setReduction.setEnabled(true);
								  
								  setQuantite.setEnabled(false);
								  lblQuantiteMini.setEnabled(false);
								  labelPromoRedu.setEnabled(true);
								  setQtitLot.setEnabled(true);
								  
								  setPrix.setEnabled(true);
								  labelPrix.setEnabled(true);
								  labelCode.setEnabled(true);
								  setCode.setEnabled(true);
								  labelDesig.setEnabled(true);
								  setDesingnation.setEnabled(true);
								  
								 setQtitLot.setEnabled(true);
								 labelQuantiteLot.setEnabled(true);
							 }
						 
					}
				}
			});
			JLabel lblNewLabel_1 = new JLabel("TYPE D'ARTICLE:");
			lblNewLabel_1.setBounds(26, 117, 125, 20);
			lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
			frmCreationDesArticles.getContentPane().add(lblNewLabel_1);
			
			labelCode = new JLabel("CODE:");
			labelCode.setBounds(100, 163, 51, 20);
			labelCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
			frmCreationDesArticles.getContentPane().add(labelCode);
			
			  labelDesig = new JLabel("DESIGNATION:");
			labelDesig.setBounds(43, 206, 108, 20);
			labelDesig.setFont(new Font("Tahoma", Font.PLAIN, 15));
			frmCreationDesArticles.getContentPane().add(labelDesig);
			
			labelPrix= new JLabel("PRIX:");
			labelPrix.setBounds(107, 251, 44, 14);
			labelPrix.setFont(new Font("Tahoma", Font.PLAIN, 15));
			frmCreationDesArticles.getContentPane().add(labelPrix);
			
			setCode = new JTextField();
			setCode.setBounds(173, 165, 236, 20);
			frmCreationDesArticles.getContentPane().add(setCode);
			setCode.setColumns(10);
			 
			setDesingnation = new JTextField();
			setDesingnation.setBounds(173, 208, 236, 20);
			frmCreationDesArticles.getContentPane().add(setDesingnation);
			setDesingnation.setColumns(10);
			
			setPrix = new JTextField();
			setPrix.setBounds(173, 250, 236, 20);
			frmCreationDesArticles.getContentPane().add(setPrix);
			setPrix.setColumns(10);
			
			labelPromoRedu= new JLabel("PROMO REDUCTION:");
			labelPromoRedu.setBounds(3, 292, 148, 20);
			labelPromoRedu.setFont(new Font("Tahoma", Font.PLAIN, 15));
			frmCreationDesArticles.getContentPane().add(labelPromoRedu);
			
			setReduction = new JTextField();
			setReduction.setBounds(173, 294, 236, 20);
			frmCreationDesArticles.getContentPane().add(setReduction);
			setReduction.setColumns(10);
			
			 lblQuantiteMini = new JLabel("QUANTITE MINI:");
			lblQuantiteMini.setBounds(33, 342, 118, 14);
			lblQuantiteMini.setFont(new Font("Tahoma", Font.PLAIN, 15));
			frmCreationDesArticles.getContentPane().add(lblQuantiteMini);
			
			setQuantite = new JTextField();
			setQuantite.setBounds(173, 336, 236, 20);
			frmCreationDesArticles.getContentPane().add(setQuantite);
			setQuantite.setColumns(10);
			
			JLabel lblCleExistant = new JLabel("CODE EXISTANT:");
			lblCleExistant.setBounds(26, 76, 125, 14);
			lblCleExistant.setFont(new Font("Tahoma", Font.PLAIN, 15));
			frmCreationDesArticles.getContentPane().add(lblCleExistant);
			
			JLabel showErrorCode = new JLabel(" ");
			showErrorCode.setBounds(173, 183, 236, 20);
			frmCreationDesArticles.getContentPane().add(showErrorCode);
			
			JLabel showErrorPrix = new JLabel(" ");
			showErrorPrix.setBounds(173, 269, 236, 14);
			frmCreationDesArticles.getContentPane().add(showErrorPrix);
			
			JLabel showErrorReduction = new JLabel(" ");
			showErrorReduction.setBounds(173, 311, 236, 14);
			frmCreationDesArticles.getContentPane().add(showErrorReduction);
			
			JLabel showErrorQuant = new JLabel(" ");
			showErrorQuant.setBounds(261, 449, 148, 40);
			frmCreationDesArticles.getContentPane().add(showErrorQuant);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(173, 51, 236, 52);
			frmCreationDesArticles.getContentPane().add(scrollPane);
			///Affichage des codes dans le TextArea ////
			JTextArea textArea = new JTextArea("\n"+tabart.afficherKEYtabart());
			textArea.setBackground(Color.BLACK);
			Font font = new Font("Verdana", Font.BOLD, 12);
			textArea.setFont(font);
			textArea.setForeground(Color.WHITE);
			scrollPane.setViewportView(textArea);
			 
			JButton save = new JButton("SAUVEGARDER");
			save.setFont(new Font("Tahoma", Font.PLAIN, 15));
			
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					
					 
					if(ev.getSource() == save){
						  code =Integer.parseInt(setCode.getText());
						
						
						if(tabart.retourner(code)==null){
						  designation = setDesingnation.getText();
						  prix = Float.parseFloat(setPrix.getText());
						 ArticleAbstrait53 Art = new Article53(code,designation,prix);
						 
					
						// frmCreationDesArticles.dispose();
						 tabart.ajouter(Art) ;	 					 
						}
				
			 
						else{
							showErrorCode.setText("code existant");
							showErrorCode.setForeground(Color.RED);
							
						}
					}
					
				}
			});
			save.setBounds(261, 447, 148, 40);
			frmCreationDesArticles.getContentPane().add(save);
			
			JButton annuler = new JButton("ANNULER");
			annuler.setFont(new Font("Tahoma", Font.PLAIN, 15));
			annuler.setBounds(61, 447, 155, 40);
			
			annuler.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					if(ev.getSource() == annuler){
						 new ClientSerie61();
						 frmCreationDesArticles.setVisible(false);
						 new ClientSerie61();
					}
					
				}
			});
			frmCreationDesArticles.getContentPane().add(annuler);
			
			
			labelQuantiteLot = new JLabel("QUANTITE LOT:");
			labelQuantiteLot.setFont(new Font("Tahoma", Font.PLAIN, 15));
			labelQuantiteLot.setBounds(41, 382, 125, 14);
			frmCreationDesArticles.getContentPane().add(labelQuantiteLot);
			
			setQtitLot = new JTextField();
			setQtitLot.setBounds(173, 381, 236, 20);
			frmCreationDesArticles.getContentPane().add(setQtitLot);
			setQtitLot.setColumns(10);
			
			JLabel showErrorQtiteLot = new JLabel(" ");
			showErrorQtiteLot.setBounds(170, 407, 239, 14);
			frmCreationDesArticles.getContentPane().add(showErrorQtiteLot);
			frmCreationDesArticles.setSize(478,567);
			frmCreationDesArticles.setLocationRelativeTo(null);
			setQtitLot.setEnabled(false);
			 setReduction.setEnabled(false);
			  
			  setQuantite.setEnabled(false);
			  lblQuantiteMini.setEnabled(false);
			  labelPromoRedu.setEnabled(false);
			  setQtitLot.setEnabled(false);
			  
			  setPrix.setEnabled(true);
			  labelPrix.setEnabled(true);
			  labelCode.setEnabled(true);
			  setCode.setEnabled(true);
			  labelDesig.setEnabled(true);
			  setDesingnation.setEnabled(true);
			  labelQuantiteLot.setEnabled(false);
			  frmCreationDesArticles.setVisible(true);
			  
			  JButton retourMenuArticle = new JButton("RETOUR");
			  retourMenuArticle.addActionListener(new ActionListener() {
			  	public void actionPerformed(ActionEvent e) {
			  	
			  		 frmCreationDesArticles.setVisible(false);
			  		
			  	
			  	}
			  });
			  retourMenuArticle.setFont(new Font("Tahoma", Font.PLAIN, 15));
			  retourMenuArticle.setBounds(261, 489, 148, 38);
			  frmCreationDesArticles.getContentPane().add(retourMenuArticle);
		}
		
		 
	
	public  void afficher(){
		  
		JFrame frame = new JFrame();
		frame.setSize(873,338);
		frame.getContentPane().setLayout(null);
		
		JButton retour = new JButton("RETOUR");
		retour.setBounds(461, 261, 150, 28);
		frame.getContentPane().add(retour);
		
		JButton fin = new JButton("FIN");
		fin.setBounds(641, 261, 167, 28);
		retour.addActionListener(new ActionListener() {

		 
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == retour){
					
			 
			 
				frame.dispose();
					
				
				}}
				}
			 );
					 
		fin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  if(e.getSource() == fin){
			boolean ouiNon = ES.saisieOuiNon("Voulez Vouz Quitter l'application ?");
			if(ouiNon){
					System.exit(0);}
				}
			}
		});
		frame.getContentPane().add(fin);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 837, 224);
		frame.getContentPane().add(scrollPane);
		
		JTextArea textArea = new JTextArea(tabart.toString());
		scrollPane.setViewportView(textArea);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		 
		 
	}
	@Override
	public void menuGeneral(TablesDesArticles53 tab, Object... objects) throws Exception {
		 //en cours de construction ////
		
	}
	@Override
	public int menuChoix(Object... objects) throws Exception {
		 //en cours de construction ////
		return 0;
	}
	@Override
	public void creer(TablesDesArticles53 tab, Object... objects) throws Exception {
		//	 //en cours de construction ////
		
	}
	@Override
	public void supprimer(TablesDesArticles53 tab, Object... objects) throws Exception {
		 //en cours de construction ////
		
	}
	@Override
	public void modifier(TablesDesArticles53 tab, Object... objects) throws Exception {
		 //en cours de construction ////
	}
	@Override
	public void afficher(TablesDesArticles53 tab) throws Exception {
		 //en cours de construction ////
		
	}
		
}