/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */
package edu.uab.jakemcph.qr;

import java.util.regex.Pattern;

/** A QR record that holds a URL */
public class QrUrl extends QrRecord {

  private String url; // a valid url

  /**
   * Create a QrUrl
   *
   * @param description readable text
   * @param url link to resource
   */
  public QrUrl(String description, String url) {
    super(description);
    this.url = url;
  }

  /**
   * Is the object valid
   *
   * @return true if valid otherwise false
   */
  @Override
  public boolean isValid() {

    // regular expression test does not like to be fed a null url
    if (url == null) {
      return false;
    }

    /*
     * Regular Expression Test is from https://www.geeksforgeeks.org/check-if-an-url-is-valid-or-not-using-regular-expression/
     */
    var p =
        Pattern.compile(
            "((http|https)://)(www.)?"
                + "[a-zA-Z0-9@:%._\\+~#?&//=]"
                + "{2,256}\\.[a-z]"
                + "{2,6}\\b([-a-zA-Z0-9@:%"
                + "._\\+~#?&//=]*)");
    var m = p.matcher(url);
    return m.matches();
  }

  /**
   * Get a text representation of object consisting of <code>QrUrl: description</code>
   *
   * @return text representation
   */
  @Override
  public String toString() {
    return "QrUrl: " + description;
  }

  /**
   * Get the text to use in the QR code creation if it is valid, null otherwise
   *
   * @return url text representation
   */
  @Override
  public String getQrText() {
    return isValid() ? url : null;
  }

  /**
   * Set (or change) the URL, it will affect the validity of the object
   *
   * @param url new url
   */
  public void setUrl(String url) {
    this.url = url;
  }
}
