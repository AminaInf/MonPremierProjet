package devoire;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServiceCompteImpl extends UnicastRemoteObject implements IServiceCompte, Serializable {

	private static final long serialVersionUID = 1L;
	Compte compte = new Compte();
	List<Compte> listeCompte;

	protected ServiceCompteImpl() throws RemoteException {
		super();
		listeCompte = new ArrayList<Compte>();
		listeCompte.add(new Compte(1, "toto", 400000, 20000));
		listeCompte.add(new Compte(2, "tata", 200000, 10000));
		listeCompte.add(new Compte(1, "Ami", 500000, 20000));
		listeCompte.add(new Compte(2, "Diouf", 300000, 10000));


	}

	@Override
	public Compte detailCompte(int numero) throws RemoteException {
		for (Compte compte : listeCompte) {
			if(compte.getNumero()==numero)
				return compte;
		}
		return null;
	}

	@Override
	public List<Compte> listeCompte() throws RemoteException {
		// TODO Auto-generated method stub
		return listeCompte;
	}

	@Override
	public void CreerCompte(String titulaire, double soldeInit) throws RemoteException {
		listeCompte.add(new Compte(listeCompte.size()+1, titulaire, soldeInit, soldeInit/10));
	}

	@Override
	public boolean CrediterCompte(int nm, double montant) throws RemoteException {
		for (Compte compte : listeCompte) {
			if(compte.getNumero()==nm) {
				compte.setSolde(montant+compte.getSolde());
				return true;
			}
				
		}
		return false;
	}

	@Override
	public boolean DebiterCompte(int num, double montant) throws RemoteException {
		for (Compte compte : listeCompte) {
			if(compte.getNumero()==num) {
				if(compte.getSolde()+compte.getDecouvertAutorise()>= montant) {
					compte.setSolde(compte.getSolde()-montant);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean effectuerVirement(int numSrc, int numDesc, double montant) throws RemoteException {
		if(DebiterCompte(numSrc, montant)) {
			CrediterCompte(numDesc, montant);
			return true;
		}
		return false;
	}


	

}
