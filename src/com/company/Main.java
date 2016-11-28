package com.company;

import java.io.*;
import java.net.*;

public class Main {

    public static Integer playersOnline = 0;

    public static void main(String[] args) {

        Socket player1 = null;
        Socket player2 = null;

        try{
            ServerSocket welcomeSocket = new ServerSocket(6789);

            while(true) {
                System.out.println("Aguardando conexão... Número de players online atualmente: " + playersOnline.toString());
                if (player1 == null){
                    player1 = welcomeSocket.accept();
                    playersOnline++;
                    System.out.println("Player conectado (1/2)!");
                }
                else{
                    player2 = welcomeSocket.accept();
                    playersOnline++;
                    System.out.println("Player conectado (2/2)!");
                }

                if (player1 != null && player2 != null){
                    System.out.println("Iniciando jogo...");
                    Player p1 = new Player(player1,null);
                    Player p2 = new Player(player2,p1);

                    Thread t1 = new Thread(p1);
                    Thread t2 = new Thread(p2);
                    p1.notifyConnection(1);
                    p2.notifyConnection(2);
                    t1.start();
                    t2.start();

                    player1 = null;
                    player2 = null;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
