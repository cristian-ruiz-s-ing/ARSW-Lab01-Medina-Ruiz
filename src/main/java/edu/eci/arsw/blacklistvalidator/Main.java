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
    int n = 4;
    String ipaddress = "202.24.34.55";
    LinkedList<Integer> totalBlackListOcurrences;
    totalBlackListOcurrences= HostBlackListsValidator.checkHost(ipaddress, n);
    System.out.println("The host was found in the following blacklists:"+totalBlackListOcurrences);
  }
}
