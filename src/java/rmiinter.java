/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pgcil
 */
    import java.rmi.Remote;
import java.rmi.RemoteException;


public interface rmiinter extends Remote {
public String givegrade(int score) throws RemoteException;
}

