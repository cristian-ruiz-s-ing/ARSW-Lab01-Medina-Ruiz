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

  /**
   * Método que me permite obtener el número B en caso de ser necesario.
   * @return numeroB - Int, Número hasta donde se desea imprimir.
   */
  public int getNumeroB() {
    return numeroB;
  }

  /**
   * Método que me permite modificar el número B el cual marca el límite hasta donde va el for.
   * @param numeroB - Int se esperar el nuevo límite a modificar.
   */
  public void setNumeroB(int numeroB) {
    this.numeroB = numeroB;
  }

  /**
   * Método que me permite modificar el inicio del for.
   * @param numeroA - Int, Valor por el cual se desea modificar el nuevo inicio.
   */
  public void setNumeroA(int numeroA) {
    this.numeroA = numeroA;
  }

  /**
   * Método que me permite obtener el número que marca el inicio del for.
   * @return numeroA - Int, Valor que me indica cuál es el inicio del for.
   */
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
