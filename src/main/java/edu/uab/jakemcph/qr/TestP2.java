/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.jakemcph.qr;

/**
 * TestP2
 *
 * <p>Exercise the P2 additions
 */
public class TestP2 {

  private static final int MAX_QR_RECORDS = 10;

  /** @param args the command line arguments */
  public static void main(String[] args) {
    QrRecord[] qrRecord = new QrRecord[MAX_QR_RECORDS];
    qrRecord[0] = new QrUrl("A URL", "https://uab.edu");
    qrRecord[1] =
        new QrWap("First Conference Room Guest", "CONFROOM", "WPA/WPA2", "someSecret", false);
    qrRecord[2] = new QrWap(null, null, null, null, false);
    qrRecord[3] = new QrWap("Fake", "Fake", "BadType", "silly", true);
    qrRecord[4] = new QrWap(null, null, null, null, false);
    qrRecord[5] = new QrWap(null, null, null, null, false);
    qrRecord[6] = new QrWap("No SSID", "", "WPA/WPA2", "anotherSecret", false);

    var wap4 = (QrWap) qrRecord[4];
    wap4.setDescription("New Description");
    wap4.setSsid("UAB");
    wap4.setPassword("GoBlazers");
    wap4.setNetworkType("WEP");
    wap4.setHidden(true);

    var wap5 = (QrWap) qrRecord[5];
    wap5.setDescription("Another New Description");
    wap5.setSsid("ENG");
    wap5.setPassword("GoBlazers2022");
    wap5.setNetworkType("no encryption");
    wap5.setHidden(true);

    for (var item : qrRecord) {
      if (item == null) {
        break; // exit loop if we get to end of array in use
      }
      System.out.println("\n");
      System.out.println(item);
      System.out.println(item.getQrText());
      System.out.println("Item is " + (item.isValid() ? "" : "not ") + "valid.");
    }
  }
}