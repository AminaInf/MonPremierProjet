package devoire;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IServiceCompte extends Remote {
	public Compte detailCompte(int numero) throws RemoteException;

	public List<Compte> listeCompte() throws RemoteException;

	public void CreerCompte(String titulaire, double solde) throws RemoteException;

	public boolean CrediterCompte(int nm, double montant) throws RemoteException;

	public boolean DebiterCompte(int num, double montant) throws RemoteException;

	public boolean effectuerVirement(int numSrc, int numDesc, double montant) throws RemoteException;
}
