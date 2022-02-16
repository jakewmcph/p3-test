/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr - EE333 Spring 2022
 *
 * Credits:  https://www.geeksforgeeks.org/writing-a-csv-file-in-java-using-opencsv/
 */
package edu.uab.jakemcph.qr;

/** Implement a QR Code record for Wireless Access Points (WAP) */
public class QrWap extends QrRecord {

  // Wireless Access Point Information
  public String networkType;
  public String ssid;
  public String password;
  public boolean hidden;

  /**
   * Create a QrWap
   *
   * @param description
   * @param ssid
   * @param networkType
   * @param password
   * @param hidden
   */
  public QrWap(
      String description, String ssid, String networkType, String password, boolean hidden) {
    super(description);
    this.networkType = deNull(networkType);
    this.ssid = deNull(ssid);
    this.password = deNull(password);
    this.hidden = hidden;
  }

  /** @return string representation of networkType */
  public String getNetworkType() {
    return networkType;
  }
  /** @return string representation of SSID */
  public String getSsid() {
    return ssid;
  }

  /** @return string representation of password */
  public String getPassword() {
    return password;
  }

  /** @return boolean true if hidden network, otherwise false */
  public boolean isHidden() {
    return hidden;
  }

  /**
   * Supply QR text for a WAP
   *
   * @return WIFI:S:*ssid*;T:*type*;P:*password*;H:*hidden*;;
   */
  @Override
  public String getQrText() {
    return "WIFI:S:" + ssid + ";T:" + networkType + ";P:" + password + ";H:" + hidden + ";;";
  }

  /**
   * Validate QrWap
   *
   * <p>
   *
   * <p>To be valid, a WAP must have an acceptable network type and an SSID which is at least one
   * character long
   */
  @Override
  public boolean isValid() {

    boolean networkTypeOk =
        networkType.equals("WEP")
            || networkType.equals("WPA/WPA2")
            || networkType.equals("no encryption");

    boolean ssidOK = ssid.length() > 0;

    return networkTypeOk && ssidOK;
  }

  /**
   * Provide a string representation of a QrWap
   *
   * @return "QrWap: {description}"
   */
  @Override
  public String toString() {
    return "QrWap: " + description;
  }

  /**
   * set (change) the Network Type. If null is supplied, an empty string is substituted for it.
   *
   * @param networkType expected but not required to be one of "WEP", "WPA/WPA2", or "no encryption"
   */
  public void setNetworkType(String networkType) {
    this.networkType = deNull(networkType);
  }

  /**
   * set (change) the SSID.If null is supplied, an empty string is substituted for it.
   *
   * @param ssid
   */
  public void setSsid(String ssid) {
    this.ssid = deNull(ssid);
  }

  /**
   * set (change) the password. If null is supplied, an empty string is substituted for it.
   *
   * @param password for WAP access
   */
  public void setPassword(String password) {
    this.password = deNull(password);
  }

  /**
   * set (change) the hidden flag.
   *
   * @param hidden true if hidden
   */
  public void setHidden(boolean hidden) {
    this.hidden = hidden;
  }

  /** @return "" if text is null, otherwise return text */
  private String deNull(String text) {
    if (text == null) {
      return "";
    } else {
      return text;
    }
  }
}