/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;

import java.util.Scanner;

/**
 *
 * @author Medina-Ruiz
 */
public class CountThreadsMain {

  public static void main(String[] args) {
    try (Scanner escanear = new Scanner(System.in)) {
      CountThread hiloUno = new CountThread();
      CountThread hiloDos = new CountThread();
      CountThread hiloTres = new CountThread();
      hiloUno.setNumeroA(escanear.nextInt());
      hiloUno.setNumeroB(escanear.nextInt());
      hiloDos.setNumeroA(escanear.nextInt());
      hiloDos.setNumeroB(escanear.nextInt());
      hiloTres.setNumeroA(escanear.nextInt());
      hiloTres.setNumeroB(escanear.nextInt());
      hiloUno.start();
      hiloDos.start();
      hiloTres.start();
    }
  }
}
