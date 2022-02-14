/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr-p3 - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.jakemcph.qr;

import java.time.LocalDateTime;
import java.time.Month;

/** */
public class TestQrContact {

  private static final int MAX_QR_CONTACTS = 10;

  /** @param args the command line arguments */
  public static void main(String[] args) {
    QrContact[] qrContact = new QrContact[MAX_QR_CONTACTS];
    qrContact[0] =
        new QrContact(
            "1.0",
            "Tyrese",
            "Haliburton",
            "Point Guard",
            "Indiana Pacers",
            "https://www.pacers.com",
            "pacers@gmail.com",
            "+1 (463)-123-4567",
            "+1 (463)-098-7654",
            "123 Pacers Way",
            "Indianapolis",
            "46077",
            "IN");
    qrContact[1] =
        new QrContact(
            "1.1",
            "Nikola",
            "Jokic",
            "Center",
            "Denver Nuggets",
            "https://www.nuggets.com",
            null,
            null,
            null,
            null,
            "Denver",
            null,
            "CO");
    qrContact[2] =
        new QrContact(
            "1.2", "Russell", null, null, null, null, null, null, null, null, null, null, "CA");
    qrContact[3] =
        new QrContact(null, null, null, null, null, null, null, null, null, null, null, null, null);
    qrContact[4] =
        new QrContact(null, null, null, null, null, null, null, null, null, null, null, null, null);

    qrContact[5] =
        new QrContact(
            "1.5",
            null,
            "Burrow",
            "Quarterback",
            "Cincinatti Bengals",
            "https://www.bengals.com",
            "bengals at the email thing uhh gmail",
            "12345678900",
            null,
            null,
            null,
            null,
            "OH");

    qrContact[6] =
        new QrContact(
            "1.6",
            "Paolo",
            "Banchero",
            "Forward",
            "Duke Blue Devils",
            "https://www.duke.com",
            "p5@gmail.com",
            "+1 (234) 567-8900",
            "one two three four 5678900",
            null,
            null,
            null,
            "OH");

    qrContact[7] =
        new QrContact(
            "1.6",
            "DeMar",
            "DeRozan",
            "Small Forward",
            "Chicago Bulls",
            "https://www.bulls.com",
            "defrozen@gmail.com",
            "one two three four 5678900",
            "+1 (234) 567-8900",
            null,
            null,
            null,
            "OH");

    var contact3 = (QrContact) qrContact[3];

    contact3.setVersion("1.3");
    contact3.setFirstName("LeBron");
    contact3.setLastName("James");
    contact3.setJobTitle("Small Forward");
    contact3.setCompany("Los Angeles Lakers");
    contact3.setUrl("https://www.nba.com");
    contact3.setEmail("lakers@gmail.com");
    contact3.setWorkNumber("+1 (101)-567-8910");
    contact3.setCellNumber("+1 (101)-876-0987");
    contact3.setStreet("404 King Road");
    contact3.setCity("Los Angeles");
    contact3.setZip("90001");
    contact3.setState("CA");

    var contact4 = (QrContact) qrContact[4];

    contact4.setVersion("1.4");
    contact4.setFirstName("D'Angelo");
    contact4.setLastName("Russell");
    contact4.setJobTitle("Point Guard");
    contact4.setCompany(null);
    contact4.setUrl(".twolves.com");
    contact4.setEmail(null);
    contact4.setWorkNumber("+1 (283)-456-7654");
    contact4.setCellNumber(null);
    contact4.setStreet(null);
    contact4.setCity("Minneapolis");
    contact4.setZip("12345");
    contact4.setState("MN");

    for (var item : qrContact) {
      if (item == null) {
        break; // exit loop if we get to end of array in use
      }
      //      System.out.println(item);
      System.out.println(item.getQrText());
      //      System.out.println("Item is " + (item.isValid() ? "" : "not ") + "valid.");
    }
  }
    }