import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 * Created by yurireis on 10/12/16.
 */
public class Server extends UnicastRemoteObject implements MessagingInterface{
    ArrayList<String> msgToP1 = new ArrayList<>();
    ArrayList<String> msgToP2 = new ArrayList<>();
    Integer player = 1;

    public Server() throws RemoteException{
        super();
        System.out.println("Servidor criado!");
    }

    @Override
    public List<String> getRemoteMessage(Integer player) throws RemoteException {
        switch (player){
            case 1:
                List<String> toReturnP1 = new ArrayList<>(msgToP1);
                msgToP1.clear();
                return toReturnP1;
            case 2:
                List<String> toReturnP2 = new ArrayList<>(msgToP2);
                msgToP2.clear();
                return toReturnP2;
        }
        return null;
    }

    @Override
    public void sendRemoteMessage(String msg, Integer player) throws RemoteException {
        System.out.println("Message: " + msg + " From: P " + player + "\n");
        switch (player){
            case 1:
                msgToP2.add(msg);
                break;
            case 2:
                msgToP1.add(msg);
                break;
        }
    }

    @Override
    public Integer getMyPlayer() throws RemoteException {
        if (player == 1){
            player ++;
            return 1;
        }
        else{
            player --;
            msgToP1.add("0-1");
            msgToP2.add("0-2");
            return 2;
        }
    }
}
