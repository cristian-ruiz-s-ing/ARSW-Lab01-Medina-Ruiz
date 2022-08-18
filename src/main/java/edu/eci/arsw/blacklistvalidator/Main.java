/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.LinkedList;

/**
 *
 * @author Medina - Ruiz
 * @version 8/16/22 
 */
public class Main {

  public static void main(String a[]) throws InterruptedException {
    long startTime = System.currentTimeMillis();
    int n = 400;
    String ipaddress = "202.24.34.55";
    LinkedList<Integer> totalBlackListOcurrences;
    totalBlackListOcurrences= HostBlackListsValidator.checkHost(ipaddress, n);
    System.out.println("The host was found in the following blacklists:"+totalBlackListOcurrences);
    System.out.println(Runtime.getRuntime().availableProcessors()); //Devuelve el número de procesadores disponibles para la máquina virtual Java.
    long endTime = System.currentTimeMillis();
    System.out.println(endTime - startTime);
  }
}
