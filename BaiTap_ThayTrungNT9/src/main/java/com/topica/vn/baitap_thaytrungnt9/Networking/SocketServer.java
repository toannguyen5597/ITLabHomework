/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.topica.vn.baitap_thaytrungnt9.Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Queue;

/**
 *
 * @author khong
 */
public class SocketServer {
    static ServerSocket serverSocket = null;
    static ArrayList<Socket> lisSocket;
    //static Socket socketT = null;
    static Queue<String> Message ;
    public static void main(String[] args){
        try {
            serverSocket = new ServerSocket(5597);
            lisSocket = new ArrayList<>();
            
            while(true){
                Socket socket = serverSocket.accept();
                lisSocket.add(socket);
                System.out.println("Client "+socket.getPort()+" connected...");
                Thread readThread = new Thread(){

                    @Override
                    public void run() {
                        try {
                            Socket socket = lisSocket.get(lisSocket.size()-1);
                            while(true){
                                DataInputStream dis = new DataInputStream(socket.getInputStream());
                                String k = dis.readUTF();
                                
                                DataOutputStream dos = null;
                                for(Socket sock: lisSocket){
                                    if(sock!=socket){
                                        dos= new DataOutputStream(sock.getOutputStream());
                                        dos.writeUTF(k);
                                    }
                                }
                            }
                            
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    
                };
                readThread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
