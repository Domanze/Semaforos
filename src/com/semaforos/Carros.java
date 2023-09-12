package com.semaforos;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class Carros extends Thread{
    private int no;
    Random random = new Random();
    int ncar = random.nextInt(3);

        public Carros(int no){
            this.no=no;
        }
        @Override
        public void run() {

            System.out.println("Calle"+no+":"+ncar);
            Timer timer = new Timer();
            TimerTask task1 = new TimerTask() {
                @Override
                public void run() {
                    ncar += random.nextInt(2);
                    System.out.println("Calle"+no+":"+ncar);
                }
            };timer.scheduleAtFixedRate(task1, 500, 4000);

        }

        public void resetCar(){
            ncar=0;
            System.out.println("Calle"+no+":"+ncar);
        }

        public int trafico(){
            return ncar;
        }
    }



