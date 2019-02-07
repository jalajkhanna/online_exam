import java.rmi.*;
import java.rmi.server.*;
import java.rmi.RemoteException;
import java.rmi.registry.*;

public class rmiserv extends UnicastRemoteObject implements rmiinterface  {
    public rmiserv() throws RemoteException {super();}
    @Override
    public String givegrade(int score) throws RemoteException 
    {
        if(score==7)
            return "A+";
        else if (score==6||score==5)
            return "A";
        else if(score==4)
            return "B";
        else if(score==3)
            return "C";
        else
            return "F";
    }
}
