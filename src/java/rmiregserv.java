import java.net.MalformedURLException;
import java.rmi.Naming; 
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

public class rmiregserv {
    public rmiregserv(){
      try {
          LocateRegistry.createRegistry(1099);
       rmiinterface c = new rmiserv();
       Naming.rebind("rmi://localhost:2033/gradeservice", c);
     } catch (Exception e) {
       System.out.println("Trouble: " + e);
     }
    
    }
public static void main(String []args)
{

    new rmiregserv();

}

}
