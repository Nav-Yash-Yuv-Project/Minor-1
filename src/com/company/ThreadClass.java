package com.company;
import java.util.*;
import java.lang.*;

public class ThreadClass extends Thread {

        public void run(){
            for(int i=1;i<5;i++){
                // the thread will sleep for the 500 milli seconds
                try{Thread.sleep(500);}catch(InterruptedException e){System.out.println(e);}
                System.out.println(i);
            }
        }
    }

