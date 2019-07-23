package devoire;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServeurCompte {

	public static void main(String[] args) {
		try {
			LocateRegistry.createRegistry(1099);
			ServiceCompteImpl objsc= new ServiceCompteImpl();
			Naming.rebind("rmi://localhost/SERVICESCOMPTE", objsc);
			System.out.println("Serveur prêt !");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
