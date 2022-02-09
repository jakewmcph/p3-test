/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.jakemcph.qr;

/**
 * Super class QrRecord which sets structure
 *
 * @author dgreen
 */
public abstract class QrRecord {

  private static long count = 1000000000;
  private final String uid; // a unique ID (ten-digit String)
  protected String description; // a one-line description

  public QrRecord(String description) {
    this.uid = "" + ++count;
    this.description = fixUpDescription(description);
  }

  /**
   * Get the uid of the object
   *
   * @return uid
   */
  public String getUid() {
    return uid;
  }

  /**
   * Get the description of the object
   *
   * @return description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set (change) the description of this record
   *
   * @param description new description
   */
  public void setDescription(String description) {
    this.description = fixUpDescription(description);
  }

  /**
   * Get the text to use in the QR code creation if it is valid, null otherwise
   *
   * @return text representation
   */
  public abstract String getQrText();

  /**
   * Is the object valid
   *
   * @return true if valid otherwise false
   */
  public abstract boolean isValid();

  /**
   * Supply a default description if needed
   *
   * @param text proposed description
   * @return text unless text is null or empty string, use it otherwise use "Unnamed <uid>" as
   *     default
   */
  private String fixUpDescription(String text) {
    if (text == null || text.equals("")) {
      return "Unnamed " + uid;
    } else {
      return text;
    }
  }
}
