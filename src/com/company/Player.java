package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.rmi.server.ExportException;

/**
 * Created by yurireis on 15/11/16.
 */
public class Player {

//    private Socket playerSocket;
//    public Player opponent;
//    public DataOutputStream output;
//    public DataInputStream input;
//
//    public Player(Socket socket, Player opponent){
//        this.playerSocket = socket;
//        this.opponent = opponent;
//        if (opponent != null){
//            opponent.opponent = this;
//        }
//        try {
//            output = new DataOutputStream(playerSocket.getOutputStream());
//            input = new DataInputStream(playerSocket.getInputStream());
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void run() {
//        boolean run = true;
//        while (run){
//            try{
//                //Le do player e manda para o oponente
//                String received1 = input.readUTF();
//                opponent.output.writeUTF(received1);
//                System.out.print(received1 + "\n");
//
//                Thread.sleep(500);
//            }
//            catch (Exception e){
//                run = false;
//            }
//        }
//        opponent.notifyDisconnection();
//        System.out.print("Player desconectado \n");
//    }
//
//    //Notifica quando um player conecta (indica se ele é o player 1 ou player 2)
//    public void notifyConnection(Integer position){
//        try {
//            output.writeUTF("0-" + position.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    //Notifica o player quando o oponente desconecta
//    public void notifyDisconnection(){
//        try {
//            output.writeUTF("5-0");
//            output.close();
//            Main.playersOnline--;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}