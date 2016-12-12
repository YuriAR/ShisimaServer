package com.company;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yurireis on 10/12/16.
 */
public class Server extends UnicastRemoteObject implements MessagingInterface{

    List<String> msgToP1 = new ArrayList<>();
    List<String> msgToP2 = new ArrayList<>();
    Integer player = 1;

    public Server() throws RemoteException{
        super();
        System.out.println("Servidor criado!");
    }

    @Override
    public String getRemoteMessage(Integer player) throws RemoteException {
        switch (player){
            case 1:
                if (msgToP1.size() > 0) {
                    String message = msgToP1.get(0);
                    msgToP1.remove(0);
                    return message;
                }
            case 2:
                if (msgToP2.size() > 0) {
                    String message = msgToP2.get(0);
                    msgToP2.remove(0);
                    return message;
                }
        }
        return null;
    }

    @Override
    public void sendRemoteMessage(String msg, Integer player) throws RemoteException {
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
            return 2;
        }
    }
}
