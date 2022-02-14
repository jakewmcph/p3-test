/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr - EE333 Spring 2022
 *
 * Credits:  https://www.geeksforgeeks.org/how-to-generate-and-read-qr-code-with-java-using-zxing-library/
 */
package edu.uab.jakemcph.qr;

// Java code to generate QR code
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Collections;

// For reading user selection
import java.util.Scanner;

/** Produce a QR Code graphic to corresponding to first match of user supplied text */
public class WapLister {

  private static final int MAX_QR_RECORDS = 10;

  /** @param args the command line arguments (unused) */
  public static void main(String[] args) throws Exception {
    ArrayList<QrWap> wap = new ArrayList<>();

    QrWap[] qrWap = new QrWap[MAX_QR_RECORDS];
    qrWap[0] =
        new QrWap("First Conference Room Guest", "CONFROOM", "WPA/WPA2", "someSecret", false);
    qrWap[1] = new QrWap("Auditorium Guest", "AUDITORIUM", "WEP", "someSecret02", false);
    qrWap[2] = new QrWap("Staff Access", "STAFF", "WPA/WPA2", "veryVerySecret", true);
    qrWap[3] = new QrWap("General Public", "FreeWIFI", "no encryption", "", false);
    qrWap[4] = new QrWap("Fake", "Fake", "BadType", "silly", true);

    Collections.addAll(wap, qrWap);

    System.out.println("Are you using a CSV? (Input Y or N)");
    var yOrN = new Scanner(System.in);
    String yN = yOrN.next();

    if (yN.equalsIgnoreCase("Y")) {

      var in =
          new Scanner(
              new File("C:\\Users\\Jake7\\OneDrive\\Documents\\NetBeansProjects\\P3_CSV.csv"));

      in.useDelimiter(",");

      String first = in.next();
      String second = in.next();
      String third = in.next();
      String fourth = in.next();
      String five = in.next();
      boolean fifth = Boolean.valueOf(five);

      ArrayList<QrWap> qrWapCsv = new ArrayList<>();
      QrWap[] csv = new QrWap[MAX_QR_RECORDS];
      csv[0] = new QrWap(first, second, third, fourth, fifth);
      Collections.addAll(qrWapCsv, csv);
      System.out.println(csv[0]);
      //      for (var record : csv) {
      //        if (record.getDescription().contains(first)) {
      displayQRCode(csv[0]);
      System.exit(0);
      //        }
      //      }
    } else if (yN.equalsIgnoreCase("N")) {
      System.out.println("WapLister -- enter text in description to find correct QR Code");

      var in = new Scanner(System.in);
      String pattern = in.next();

      for (var record : wap) {
        if (record.getDescription().contains(pattern)) {
          displayQRCode(record);
          System.exit(0);
        }
      }
      System.out.println("Did not find a matching pattern.");
    }
  }

  /**
   * Display a QrWap item
   *
   * @param item the item to display (if it is valid)
   */
  public static void displayQRCode(QrWap item) {
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
}