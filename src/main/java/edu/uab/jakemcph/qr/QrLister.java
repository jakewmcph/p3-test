/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr-p3 - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.jakemcph.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Creates an ArrayList string that displays information about a contact, event, record, url, or
 * wap.
 */
public class QrLister {

  private static final int MAX_QR_RECORDS = 40;

  /** @param args the command line arguments */
  public static void main(String[] args) {
    ArrayList<QrWap> wap = new ArrayList<>();

    QrWap[] qrWap = new QrWap[MAX_QR_RECORDS];
    qrWap[0] =
        new QrWap("First Conference Room Guest", "CONFROOM", "WPA/WPA2", "someSecret", false);
    qrWap[1] = new QrWap("Auditorium Guest", "AUDITORIUM", "WEP", "someSecret02", false);
    qrWap[2] = new QrWap("Staff Access", "STAFF", "WPA/WPA2", "veryVerySecret", true);
    qrWap[3] = new QrWap("General Public", "FreeWIFI", "no encryption", "", false);
    qrWap[4] = new QrWap("Fake", "Fake", "BadType", "silly", true);

    Collections.addAll(wap, qrWap);

    ArrayList<QrRecord> record = new ArrayList<>();

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

    Collections.addAll(record, qrRecord);

    ArrayList<QrUrl> qurl = new ArrayList<>();

    QrUrl[] qrUrl = new QrUrl[MAX_QR_RECORDS];
    qrUrl[0] = new QrUrl("UAB", "https://www.uab.edu");
    qrUrl[1] = new QrUrl("Error 1", null);
    qrUrl[2] = new QrUrl("Error 2", "");
    qrUrl[3] = new QrUrl("Error 3", "https://x /world");
    qrUrl[4] = new QrUrl("Error 4", "https://x.com/w o r l d");
    qrUrl[5] = new QrUrl("EE333 Canvas", "https://uab.instructure.com/courses/1585540");

    Collections.addAll(qurl, qrUrl);

    ArrayList<QrEvent> event = new ArrayList<>();

    QrEvent[] qrEvent = new QrEvent[MAX_QR_RECORDS];
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

    Collections.addAll(event, qrEvent);

    ArrayList<QrContact> contact = new ArrayList<>();

    QrContact[] qrContact = new QrContact[MAX_QR_RECORDS];
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
            "12345",
            null);
    qrContact[2] =
        new QrContact(
            "1.2",
            "Russell",
            null,
            null,
            null,
            "www.lakers.com",
            null,
            null,
            null,
            null,
            null,
            null,
            "CA");
    qrContact[3] =
        new QrContact(null, null, null, null, null, null, null, null, null, null, null, null, null);
    qrContact[4] =
        new QrContact(null, null, null, null, null, null, null, null, null, null, null, null, null);

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
    contact4.setUrl("https://www.twolves.com");
    contact4.setEmail(null);
    contact4.setWorkNumber("+1 (283)-456-7654");
    contact4.setCellNumber(null);
    contact4.setStreet(null);
    contact4.setCity("Minneapolis");
    contact4.setZip("12345");
    contact4.setState("MN");

    Collections.addAll(contact, qrContact);

    System.out.println(
        "Please Pick a Program from This List:"
            + "\n"
            + "QrContact, QrEvent, QrRecord, QrUrl, QrWap");

    var Qr = new Scanner(System.in);
    String QrInput = Qr.nextLine();

    if (QrInput.equalsIgnoreCase("QrContact")) {
      System.out.println("Please Enter a First Name for Contact Information");

      var Qr2 = new Scanner(System.in);
      String QrInput2 = Qr2.nextLine();

      for (var r : contact) {
        if (r.getFirstName().equalsIgnoreCase(QrInput2)) {
          displayQRContactCode(r);
          System.exit(0);
        }
      }
    }
    if (QrInput.equalsIgnoreCase("QrEvent")) {
      System.out.println("Please Enter a Summary for Event Information");

      var Qr2 = new Scanner(System.in);
      String QrInput2 = Qr2.nextLine();

      for (var r : event) {
        if (r.getSummary().equalsIgnoreCase(QrInput2)) {
          displayQREventCode(r);
          System.exit(0);
        }
      }
    }
    if (QrInput.equalsIgnoreCase("QrRecord")) {
      System.out.println("Please Enter a Description for Record Information");

      var Qr2 = new Scanner(System.in);
      String QrInput2 = Qr2.nextLine();

      for (var r : record) {
        if (r.getDescription().contains(QrInput2)) {
          displayQRRecordCode(r);
          System.exit(0);
        }
      }
    }
    if (QrInput.equalsIgnoreCase("QrUrl")) {
      System.out.println("Please Enter a Description for URL Information");

      var Qr2 = new Scanner(System.in);
      String QrInput2 = Qr2.nextLine();

      for (var r : qurl) {
        if (r.getDescription().equalsIgnoreCase(QrInput2)) {
          displayQRUrlCode(r);
          System.exit(0);
        }
      }
    }
    if (QrInput.equalsIgnoreCase("QrWap")) {
      System.out.println("Please Enter a Description for WAP Information");

      var Qr2 = new Scanner(System.in);
      String QrInput2 = Qr2.nextLine();

      for (var r : wap) {
        if (r.getDescription().equalsIgnoreCase(QrInput2)) {
          displayQRWapCode(r);
          System.exit(0);
        }
      }
    }
    System.out.println("Did not find a matching pattern");
  }

  /**
   * Create a QR code for QrWap.
   *
   * @param item outputs the item array as a QR code.
   */
  public static void displayQRWapCode(QrWap item) {
    if (!item.isValid()) {
      System.out.println("Stored information was not valid WAP information.");
      return;
    }

    System.out.println(item.getQrText());

    Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();

    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

    // createQR(data, path, charset, hashMap, 200, 200);
    String data = item.getQrText();
    int width = 200; // pixels
    int height = width; // pixels
    String charset = "UTF-8";
    String path = "target/QrWap.png"; // put into target so does not go to repository

    try {
      BitMatrix matrix =
          new MultiFormatWriter()
              .encode(
                  new String(data.getBytes(charset), charset),
                  BarcodeFormat.QR_CODE,
                  width,
                  height);

      MatrixToImageWriter.writeToFile(
          matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    } catch (Exception e) {
      System.out.println("Image rendering failed");
    }
  }

  /**
   * Create a QR code for QrUrl.
   *
   * @param item outputs the item array as a QR code.
   */
  public static void displayQRUrlCode(QrUrl item) {
    if (!item.isValid()) {
      System.out.println("Stored information was not valid URL information.");
      return;
    }

    System.out.println(item.getQrText());

    Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();

    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

    // createQR(data, path, charset, hashMap, 200, 200);
    String data = item.getQrText();
    int width = 200; // pixels
    int height = width; // pixels
    String charset = "UTF-8";
    String path = "target/QrURL.png"; // put into target so does not go to repository

    try {
      BitMatrix matrix =
          new MultiFormatWriter()
              .encode(
                  new String(data.getBytes(charset), charset),
                  BarcodeFormat.QR_CODE,
                  width,
                  height);

      MatrixToImageWriter.writeToFile(
          matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    } catch (Exception e) {
      System.out.println("Image rendering failed");
    }
  }

  /**
   * Create a QR code for QrRecord.
   *
   * @param item outputs the item array as a QR code.
   */
  public static void displayQRRecordCode(QrRecord item) {
    if (!item.isValid()) {
      System.out.println("Stored information was not valid Record information.");
      return;
    }

    System.out.println(item.getQrText());

    Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();

    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

    // createQR(data, path, charset, hashMap, 200, 200);
    String data = item.getQrText();
    int width = 200; // pixels
    int height = width; // pixels
    String charset = "UTF-8";
    String path = "target/QrRecord.png"; // put into target so does not go to repository

    try {
      BitMatrix matrix =
          new MultiFormatWriter()
              .encode(
                  new String(data.getBytes(charset), charset),
                  BarcodeFormat.QR_CODE,
                  width,
                  height);

      MatrixToImageWriter.writeToFile(
          matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    } catch (Exception e) {
      System.out.println("Image rendering failed");
    }
  }

  /**
   * Create a QR code for QrEvent.
   *
   * @param item outputs the item array as a QR code.
   */
  public static void displayQREventCode(QrEvent item) {
    if (!item.isValid()) {
      System.out.println("Stored information was not valid Event information.");
      return;
    }

    System.out.println(item.getQrText());

    Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();

    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

    // createQR(data, path, charset, hashMap, 200, 200);
    String data = item.getQrText();
    int width = 200; // pixels
    int height = width; // pixels
    String charset = "UTF-8";
    String path = "target/QrEvent.png"; // put into target so does not go to repository

    try {
      BitMatrix matrix =
          new MultiFormatWriter()
              .encode(
                  new String(data.getBytes(charset), charset),
                  BarcodeFormat.QR_CODE,
                  width,
                  height);

      MatrixToImageWriter.writeToFile(
          matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    } catch (Exception e) {
      System.out.println("Image rendering failed");
    }
  }

  /**
   * Create a QR code for QrContact.
   *
   * @param item outputs the item array as a QR code.
   */
  public static void displayQRContactCode(QrContact item) {
    if (!item.isValid()) {
      System.out.println("Stored information was not valid Contact information.");
      return;
    }

    System.out.println(item.getQrText());

    Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<>();

    hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

    // createQR(data, path, charset, hashMap, 200, 200);
    String data = item.getQrText();
    int width = 200; // pixels
    int height = width; // pixels
    String charset = "UTF-8";
    String path = "target/QrContact.png"; // put into target so does not go to repository

    try {
      BitMatrix matrix =
          new MultiFormatWriter()
              .encode(
                  new String(data.getBytes(charset), charset),
                  BarcodeFormat.QR_CODE,
                  width,
                  height);

      MatrixToImageWriter.writeToFile(
          matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    } catch (Exception e) {
      System.out.println("Image rendering failed");
    }
  }
}