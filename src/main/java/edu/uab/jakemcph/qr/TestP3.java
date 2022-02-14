/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr-p3 - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.jakemcph.qr;

import java.time.LocalDateTime;
import java.time.Month;

/** Creates an event string that displays information about an event. */
public class TestP3 {

  private static final int MAX_QR_EVENTS = 10;

  /** @param args the command line arguments */
  public static void main(String[] args) {
    QrEvent[] qrEvent = new QrEvent[MAX_QR_EVENTS];
    qrEvent[0] =
        new QrEvent(
            "1000000000",
            LocalDateTime.now(),
            LocalDateTime.of(2022, Month.APRIL, 22, 0, 0),
            LocalDateTime.of(2022, Month.APRIL, 22, 23, 59),
            "EE333 Final",
            "This is the final project for EE333",
            "EE 333");
    qrEvent[1] =
        new QrEvent(
            "1000000001",
            LocalDateTime.now(),
            LocalDateTime.of(2020, Month.DECEMBER, 22, 0, 0),
            LocalDateTime.of(2021, Month.JULY, 22, 0, 0),
            null,
            null,
            null);
    qrEvent[2] =
        new QrEvent(
            "1000000002",
            LocalDateTime.now(),
            null,
            LocalDateTime.of(2022, Month.FEBRUARY, 13, 17, 30),
            "Superbowl",
            "This is when the Superbowl will begin.",
            "NFL");
    qrEvent[3] = new QrEvent(null, null, null, null, null, null, null);
    qrEvent[4] = new QrEvent(null, null, null, null, null, null, null);

    var event3 = (QrEvent) qrEvent[3];
    event3.setDescription("This is when the NBA All-Star Weekend Will Occur.");
    event3.setUid("1010101010");
    event3.setSummary("NBA All-Star Weekend");
    event3.setCLASS("NBA");
    event3.setDtstamp(LocalDateTime.now());
    event3.setDtstart(LocalDateTime.of(2022, Month.FEBRUARY, 18, 20, 0));
    event3.setDtend(LocalDateTime.of(2022, Month.FEBRUARY, 20, 23, 59));

    var event4 = (QrEvent) qrEvent[4];
    event4.setDescription("This is a Quiz.");
    event4.setUid("0000000001");
    event4.setSummary("Quiz");
    event4.setCLASS("UAB");
    event4.setDtstamp(LocalDateTime.now());
    event4.setDtstart(LocalDateTime.of(2022, Month.MARCH, 1, 0, 0));
    event4.setDtend(null);

    for (var item : qrEvent) {
      if (item == null) {
        break; // exit loop if we get to end of array in use
      }
      //      System.out.println(item);
      System.out.println(item.getQrText());
      //      System.out.println("Item is " + (item.isValid() ? "" : "not ") + "valid.");
    }
  }
}