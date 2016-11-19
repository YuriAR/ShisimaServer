package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by yurireis on 15/11/16.
 */
public class Player implements Runnable{

    private Socket playerSocket;
    public Player opponent;
    public DataOutputStream output;
    public DataInputStream input;

    public Player(Socket socket, Player opponent){
        this.playerSocket = socket;
        this.opponent = opponent;
        if (opponent != null){
            opponent.opponent = this;
        }
        try {
            output = new DataOutputStream(playerSocket.getOutputStream());
            input = new DataInputStream(playerSocket.getInputStream());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            try{
                String received1 = input.readUTF();
                opponent.output.writeUTF(received1);
                System.out.print(received1);

                Thread.sleep(500);
            }
            catch (Exception e){
                e.printStackTrace();
                break;
            }
        }
        Main.games--;
    }
}