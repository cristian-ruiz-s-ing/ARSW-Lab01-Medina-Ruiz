package edu.eci.arsw.blacklistvalidator;

import edu.eci.arsw.spamkeywordsdatasource.HostBlacklistsDataSourceFacade;
import edu.eci.arsw.threads.BlackListThread;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.*;

/**
 *
 * @author Medina - Ruiz
 */
public class HostBlackListsValidator {

  /**
   * Check the given host's IP address in all the available black lists,
   * and report it as NOT Trustworthy when such IP was reported in at least
   * BLACK_LIST_ALARM_COUNT lists, or as Trustworthy in any other case.
   * The search is not exhaustive: When the number of occurrences is equal to
   * BLACK_LIST_ALARM_COUNT, the search is finished, the host reported as
   * NOT Trustworthy, and the list of the five blacklists returned.
   * 
   * @param ipaddress suspicious host's IP address.
   * @return Blacklists numbers where the given host's IP address was found.
   * @throws InterruptedException
   */
  public static LinkedList<Integer> checkHost(String ipaddress, int n) throws InterruptedException {

    HostBlacklistsDataSourceFacade skds = HostBlacklistsDataSourceFacade.getInstance();
    int divListas = skds.getRegisteredServersCount() / n;
    ArrayList<BlackListThread> totalHilos = new ArrayList<>();
    LinkedList<Integer> ocu= new LinkedList<>();
    int checked = 0;
    int ocurrences = 0;

    for(int i = 0 ; i<n; i++){
      int inicioLista = i*divListas;
      int finLista = inicioLista + divListas;

      totalHilos.add(new BlackListThread(inicioLista, finLista, ipaddress));
    }

    for(BlackListThread i : totalHilos){
      i.start();
    }

    for(BlackListThread i : totalHilos){
      i.join();
      for(Integer j : i.getBlackListOcurrences()){
        ocu.add(j);
      }
      checked+= i.getCheckedListsCount();
      ocurrences+= i.getOcurrences();
      
      if (ocurrences >= BlackListThread.BLACK_LIST_ALARM_COUNT) {

        skds.reportAsNotTrustworthy(ipaddress);

        LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}",
         new Object[] { checked, skds.getRegisteredServersCount() });
    
        return ocu;
      }
    }

    if (ocurrences >= BlackListThread.BLACK_LIST_ALARM_COUNT) {
      skds.reportAsNotTrustworthy(ipaddress);
    } else {
      skds.reportAsTrustworthy(ipaddress);
    }

    LOG.log(Level.INFO, "Checked Black Lists:{0} of {1}", 
    new Object[] { checked, skds.getRegisteredServersCount() });
    
    return ocu;
  }
  private static final Logger LOG = Logger.getLogger(HostBlackListsValidator.class.getName());
}