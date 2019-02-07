    import java.rmi.Remote;
import java.rmi.RemoteException;
public interface rmiinterface extends Remote{
    public String givegrade(int score) throws RemoteException;
}
