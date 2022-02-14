/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr-p3 - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.jakemcph.qr;

import java.time.LocalDateTime;

/** Creates an event string that displays information about an event. */
public class QrEvent extends QrRecord {
  private String uid;
  private LocalDateTime dtstamp;
  private LocalDateTime dtstart;
  private String description;
  private LocalDateTime dtend;
  private String summary;
  private String CLASS;

  public QrEvent(
      String uid,
      LocalDateTime dtstamp,
      LocalDateTime dtstart,
      LocalDateTime dtend,
      String summary,
      String description,
      String CLASS) {

    super(uid);
    this.CLASS = deNull(CLASS);
    this.description = deNull(description);
    this.dtend = dtend;
    this.dtstamp = dtstamp;
    this.dtstart = dtstart;
    this.summary = deNull(summary);
    this.uid = uid;
  }

  /**
   * Get the UID code information.
   *
   * @return outputs the uid.
   */
  public String getUid() {
    return uid;
  }

  /**
   * Get the class information.
   *
   * @return outputs the CLASS.
   */
  public String getCLASS() {
    return CLASS;
  }

  /**
   * Get the job title information.
   *
   * @return outputs the description.
   */
  @Override
  public String getDescription() {
    return description;
  }

  /**
   * Get the date end information.
   *
   * @return outputs the dtend.
   */
  public LocalDateTime getDtend() {
    return dtend;
  }

  /**
   * Get the date stamp information.
   *
   * @return outputs the dtstamp.
   */
  public LocalDateTime getDtstamp() {
    return dtstamp;
  }

  /**
   * Get the date start information.
   *
   * @return outputs the dtstart.
   */
  public LocalDateTime getDtstart() {
    return dtstart;
  }

  /**
   * Get the summary information.
   *
   * @return outputs the summary.
   */
  public String getSummary() {
    return summary;
  }

  /**
   * Determines if the information provided is valid for QrEvent.
   *
   * @return outputs true/false.
   */
  @Override
  public boolean isValid() {

    if ((dtstart == null) || (dtend == null) || (uid == null)) {
      return false;
    }
    return true;
  }

  /**
   * Get the information required for the string and print it.
   *
   * @return outputs the QrEvent string.
   */
  public String getQrText() {
    if (isValid() == false) {
      return ("BEGIN: QREVENT" + "\n" + "This Event is not Valid." + "\n" + "END: QREVENT" + "\n");
    } else
      return ("BEGIN: QREVENT"
          + "\n"
          + "UID: "
          + uid
          + "\n"
          + "DTSTAMP: "
          + dtstamp
          + "\n"
          + "DTSTART: "
          + dtstart
          + "\n"
          + "DTEND: "
          + dtend
          + "\n"
          + "SUMMARY: "
          + summary
          + "\n"
          + "DESCRIPTION: "
          + description
          + "\n"
          + "CLASS: "
          + CLASS
          + "\n"
          + "END: QREVENT"
          + "\n");
  }

  /**
   * Set the UID code information.
   *
   * @param uid sets the new uid.
   */
  public void setUid(String uid) {
    this.uid = uid;
  }

  /**
   * Set the date stamp information.
   *
   * @param dtstamp sets the new dtstamp.
   */
  public void setDtstamp(LocalDateTime dtstamp) {
    this.dtstamp = dtstamp;
  }

  /**
   * Set the date start information.
   *
   * @param dtstart sets the new dtstart.
   */
  public void setDtstart(LocalDateTime dtstart) {
    this.dtstart = dtstart;
  }

  /**
   * Set the description information.
   *
   * @param description sets the new description.
   */
  @Override
  public void setDescription(String description) {
    this.description = deNull(description);
  }

  /**
   * Set the date end information.
   *
   * @param dtend sets the new dtend.
   */
  public void setDtend(LocalDateTime dtend) {
    this.dtend = dtend;
  }

  /**
   * Set the summary information.
   *
   * @param summary sets the new summary.
   */
  public void setSummary(String summary) {
    this.summary = deNull(summary);
  }

  /**
   * Set the class information.
   *
   * @param CLASS sets the new CLASS.
   */
  public void setCLASS(String CLASS) {
    this.CLASS = deNull(CLASS);
  }

  /**
   * Sets a null to an empty string.
   *
   * @param text returns an empty string or text.
   */
  private String deNull(String text) {
    if (text == null) {
      return "";
    } else {
      return text;
    }
  }
 }