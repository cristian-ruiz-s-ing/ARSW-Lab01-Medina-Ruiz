/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.threads;
import java.util.LinkedList;
// import edu.eci.arsw.blacklistvalidator.*;
import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;

/**
 *
 * @author Medina-Ruiz
 */

public class BlackListThread extends Thread{
  String ipaddress;
  int n;
  int inicioLista;
  int finLista;
  LinkedList<Integer> blackListOcurrences = new LinkedList<>();
  int ocurrencesCount = 0;
  int checkedListsCount = 0;
  public static HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();
  public static final int BLACK_LIST_ALARM_COUNT = 5;

  public BlackListThread(int inicioLista, int finLista, String ipaddress){
    this.inicioLista = inicioLista;
    this.finLista = finLista;
    this.ipaddress= ipaddress;
  }

  public int getInicioLista() {
    return inicioLista;
  }

  public void setInicioLista(int inicioLista) {
    this.inicioLista = inicioLista;
  }

  public int getFinLista() {
    return finLista;
  }

  public void setFinLista(int finLista) {
    this.finLista = finLista;
  }

  public LinkedList<Integer> getBlackListOcurrences(){
    return blackListOcurrences;
  }

  public int getCheckedListsCount(){
    return checkedListsCount;
  }

  public int getOcurrences(){
    return ocurrencesCount;
  }

  @Override
  public void run(){
    for (int i = inicioLista; i < finLista  && ocurrencesCount < BLACK_LIST_ALARM_COUNT; i++) {
      
      checkedListsCount++;
      if (skds.isInBlackListServer(i, ipaddress)) {
        blackListOcurrences.add(i);
        ocurrencesCount++;
      }
    }
  }
}
