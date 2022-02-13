/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr-p3 - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.jakemcph.qr;

import java.time.LocalDateTime;

/** */
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

  public String getUid() {
    return uid;
  }

  public String getCLASS() {

    return CLASS;
  }

  @Override
  public String getDescription() {

    return description;
  }

  public LocalDateTime getDtend() {
    if (dtend == null) {
      setDtend(dtstart);
    }
    return dtend;
  }

  public LocalDateTime getDtstamp() {
    return dtstamp;
  }

  public LocalDateTime getDtstart() {

    return dtstart;
  }

  public String getSummary() {

    return summary;
  }

  @Override
  public boolean isValid() {

    if ((dtstart == null) || (dtend == null) || (uid == null)) {
      return false;
    }
    return true;
  }

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

  /** @param uid the uid to set */
  public void setUid(String uid) {
    this.uid = uid;
  }

  /** @param dtstamp the dtstamp to set */
  public void setDtstamp(LocalDateTime dtstamp) {
    this.dtstamp = dtstamp;
  }

  /** @param dtstart the dtstart to set */
  public void setDtstart(LocalDateTime dtstart) {
    this.dtstart = dtstart;
  }

  /** @param description the description to set */
  public void setDescription(String description) {
    this.description = deNull(description);
  }

  /** @param dtend the dtend to set */
  public void setDtend(LocalDateTime dtend) {
    this.dtend = dtend;
  }

  /** @param summary the summary to set */
  public void setSummary(String summary) {
    this.summary = deNull(summary);
  }

  /** @param CLASS the CLASS to set */
  public void setCLASS(String CLASS) {
    this.CLASS = deNull(CLASS);
  }

  private String deNull(String text) {
    if (text == null) {
      return "";
    } else {
      return text;
    }
  }
 }