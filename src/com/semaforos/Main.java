package com.semaforos;

import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args){
        Carros[] dir = new Carros[4];
        int[] trafico = new int [4];

        for(int i = 0; i < dir.length;i++){
            dir[i]= new Carros(i+1);
            dir[i].start();
            try {
                dir[i].join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        Timer timer = new Timer();

        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {

                for(int i = 0; i<dir.length; i++){
                    trafico[i]= dir[i].trafico();
                }


                if(trafico[0]>=trafico[1]&&trafico[0]>=trafico[2]&&trafico[0]>=trafico[3]){
                    dir[0].resetCar();
                    System.out.println("Avanza calle1");
                } else if (trafico[1]>=trafico[0]&&trafico[1]>=trafico[2]&&trafico[1]>=trafico[3]) {
                    dir[1].resetCar();
                    System.out.println("Avanza calle2");
                } else if (trafico[2]>=trafico[0]&&trafico[2]>=trafico[1]&&trafico[2]>=trafico[3]) {
                    dir[2].resetCar();
                    System.out.println("Avanza calle3");
                } else {
                    dir[3].resetCar();
                    System.out.println("Avanza calle4");
                }
            }
        };timer.scheduleAtFixedRate(task2, 0, 9000);



            }
        }

