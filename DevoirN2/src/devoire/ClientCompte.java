package devoire;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class ClientCompte {

	public static void main(String[] args) {
		try {
			IServiceCompte isc = (IServiceCompte) Naming.lookup("rmi://localhost/SERVICESCOMPTE");
			Scanner sc= new Scanner(System.in);
			String username;
			String password;
			String statut;
			String reponse;
			System.out.println("Votre statut svp");
			statut=sc.nextLine();
			
			System.out.println("Chere "+statut+" authentifiez vous");
			System.out.println("");
			System.out.println("Username: ");
			username=sc.nextLine();
		
			System.out.println("Password: ");
			password=sc.nextLine();
			
			if(username.equals("toto") & statut.equals("Client") & password.equals("1234")){
				
				System.out.println(username+" Les operations que vous pouvez faire sont:");
				
				System.out.println("DetailCompte");
				System.out.println("Debiter , Crediter");
				System.out.println("Virement");
				System.out.println("Que voulez vous faire");
				reponse=sc.nextLine();
				
				if(reponse.equals("detailleCompte")){
					
					System.out.println(isc.detailCompte(1));
				}
				
				else if (reponse.equals("debiter")){
					
					System.out.println("Veuillez saisir le montant");
					double montant = sc.nextDouble();
					System.out.println(isc.DebiterCompte(1, montant));
					
					
				}
				else if (reponse.equals("crediter")){
					
					System.out.println("Veuillez saisir le montant");
					double montant = sc.nextDouble();
					System.out.println(isc.CrediterCompte(1, montant));
					
				}
				else if (reponse.equals("Virement")){
					isc.CreerCompte("Nassir", 10000000);
					isc.CreerCompte("Sadio", 2000000);
					if(isc.effectuerVirement(1, 2, 100000))
						System.out.println("Virement effectuer avec succès");
					else
						System.out.println("Virement non effectué");
				}
				
				
				
				
			}
			
			 if(username.equals("tata") & statut.equals("Client") & password.equals("12345")){
				System.out.println(username+" Les operations que vous pouvez faire sont:");
				
				System.out.println("DetailCompte");
				System.out.println("Debiter , Crediter");
				System.out.println("Virement");
				System.out.println("Que voulez vous faire");
				reponse=sc.nextLine();
				
				if(reponse.equals("detailleCompte")){
					
					System.out.println(isc.detailCompte(2));
				}
				
				else if (reponse.equals("debiter")){
					
					System.out.println("Veuillez saisir le montant");
					double montant = sc.nextDouble();
					System.out.println(isc.DebiterCompte(2, montant));
					
					
				}
				else if (reponse.equals("crediter")){
					
					System.out.println("Veuillez saisir le montant");
					double montant = sc.nextDouble();
					System.out.println(isc.CrediterCompte(1, montant));
					
				}
				else if (reponse.equals("Virement")){
					isc.CreerCompte("Nassir", 10000000);
					isc.CreerCompte("Sadio", 2000000);
					if(isc.effectuerVirement(1, 2, 100000))
						System.out.println("Virement effectuer avec succès");
					else
						System.out.println("Virement non effectué");
				}
				
				
				
				
			}
			 if(statut.equals("Gestionnaire") & username.equals("admin")& password.equals("123"))
			{
				System.out.println(username+"Les operations que vous pouvez faire sont:");
				
				System.out.println("DetailCompte");
				System.out.println("CreerCompte");
				System.out.println("Virement");
				System.out.println("Que voulez vous faire");
				reponse=sc.nextLine();
				sc.nextLine();
				if(reponse.equals("detailleCompte")){
					System.out.println("Veuillez saisir un numero pour afficher les détails");
					int num=sc.nextInt();
					System.out.println(isc.detailCompte(num));
				}
				
				else if (reponse.equals("CreerCompte")){
					System.out.println("Veuillez saisir le titulaire");
					String titulaire=sc.nextLine();
					System.out.println("Veuillez saisir le solde");
					double solde=sc.nextDouble();
					
					isc.CreerCompte(titulaire, solde);
					
					
				}
				else if (reponse.equals("lister")){
					System.out.println(isc.listeCompte());
				}
				else if (reponse.equals("Virement")){
					isc.CreerCompte("Amie", 10000000);
					
					if(isc.effectuerVirement(1, 2, 100000))
						System.out.println("Virement effectuer avec succès");
					else
						System.out.println("Virement non effectué");
				}
				System.out.println("Veuillez saisir un numero pour afficher les détails");
				int num=sc.nextInt();
				System.out.println(isc.detailCompte(num));
				System.out.println(isc.listeCompte());
				isc.CreerCompte("Nassir", 10000000);
				isc.CreerCompte("Sadio", 2000000);
				if(isc.effectuerVirement(1, 2, 100000))
					System.out.println("Virement effectuer avec succès");
				else
					System.out.println("Virement non effectué");
				
			}
			 else
					System.out.println(username+"le client n'existe pas");
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
