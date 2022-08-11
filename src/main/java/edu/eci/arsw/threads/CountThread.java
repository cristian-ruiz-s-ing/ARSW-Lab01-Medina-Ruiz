/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author hcadavid
 */
public class CountThread extends Thread {
    public void run(){
        System.out.println("thread is running...");
    }
    public static void main(String[] args) {
        CountThread obj = new CountThread();
        obj.start();
    }
    
}
