/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

/**
 *
 * @author Medina-Ruiz
 */
public class CountThread extends Thread {
    int numeroA;
    int numeroB;

    public int getNumeroB() {
        return numeroB;
    }

    public void setNumeroB(int numeroB) {
        this.numeroB = numeroB;
    }

    public void setNumeroA(int numeroA) {
        this.numeroA = numeroA;
    }

    public int getNumeroA() {
        return numeroA;
    }

    @Override
    public void run(){
        for(int i = numeroA; i <= numeroB; i ++){
            System.out.println(i);
        }
    }

}
