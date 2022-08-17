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
 * Clase BlackListThread, que permite realizar el analices de las listas negras por medio de hilos.
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

  /**
   * Constructor de la clase, la cual nos permitirá tener lo necesario para crear los hilos y que funcione adecuadamente el método run.
   * @param inicioLista - int, Contiene el valor inicial desde donde empezaremos a revisar el segmento de lista.
   * @param finLista - int, Contiene el valor final hasta donde podremos revisar el segmento de lista.
   * @param ipaddress - String, Ip que se desea revisar si es fiable o no fiable.
   */
  public BlackListThread(int inicioLista, int finLista, String ipaddress){
    this.inicioLista = inicioLista;
    this.finLista = finLista;
    this.ipaddress= ipaddress;
  }

  /**
   * Método get que retorna el inicio donde se va a revisar la lista.
   * @return inicioLista - Int, devuelve el valor donde comienza a revisar el segmento de la lista.
   */
  public int getInicioLista() {
    return inicioLista;
  }

  /**
   * Método que me permite alterar el valor inicial de donde comienza la lista.
   * @param inicioLista - Int.
   */
  public void setInicioLista(int inicioLista) {
    this.inicioLista = inicioLista;
  }

  /**
   * Método que me permite obtener el valor donde finaliza la revisión de la lista.
   * @return finLista - Int, Valor de donde finaliza la revisión de la lista.
   */
  public int getFinLista() {
    return finLista;
  }

  /**
   * Método que me permite alterar el valor final donde finaliza la revisión de la lista.
   * @param finLista - Int, Valor final de la lista que se desea alterar.
   */
  public void setFinLista(int finLista) {
    this.finLista = finLista;
  }

  /**
   * Método que me retorna la Lista de ocurrencias encontradas malas dada la ip.
   * @return blackListOcurrences - LinkedList<Integer>, retorna una lista que contiene el número de la lista donde se encontro la ip mala.
   */
  public LinkedList<Integer> getBlackListOcurrences(){
    return blackListOcurrences;
  }

  /**
   * Método que retorna la cantidad de listas revisadas.
   * @return checkedListsCount - Int, Valor que contiene la cantidad de listas revisadas
   */
  public int getCheckedListsCount(){
    return checkedListsCount;
  }

  /**
   * Método que me retorna la cantidad de ocurrencias para verificar que no supere el limite de 5.
   * @return ocurrencesCount - Int, Valor que contiene las ocurrencias encontradas al momento de ver la lista.
   */
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
