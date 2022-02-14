/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr-p3 - EE333 Spring 2022
 *
 * Credits:  (if any for sections of code)
 */

package edu.uab.jakemcph.qr;

import java.util.regex.Pattern;

/** */
public class QrContact extends QrUrl {

  private String version;
  private String firstName;
  private String lastName;
  //  private String description;
  private String company;
  private String url;
  private String email;
  private String workNumber;
  private String cellNumber;
  private String street;
  private String city;
  private String zip;
  private String state;

  public QrContact(
      String version,
      String firstName,
      String lastName,
      String description,
      String company,
      String url,
      String email,
      String workNumber,
      String cellNumber,
      String street,
      String city,
      String zip,
      String state) {

    super(description, url);
    this.url = deNull(url);
    this.cellNumber = deNull(cellNumber);
    this.city = deNull(city);
    this.company = deNull(company);
    this.email = deNull(email);
    this.firstName = deNull(firstName);
    this.description = deNull(description);
    this.lastName = deNull(lastName);
    this.state = deNull(state);
    this.street = deNull(street);
    this.version = version;
    this.workNumber = deNull(workNumber);
    this.zip = deNull(zip);
  }

  public String getCellNumber() {
    return cellNumber;
  }

  public String getCity() {
    return city;
  }

  public String getCompany() {
    return company;
  }

  public String getEmail() {
    return email;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getJobTitle() {
    return description;
  }

  public String getLastName() {
    return lastName;
  }

  public String getState() {
    return state;
  }

  public String getStreet() {
    return street;
  }

  public String getUrl() {
    return url;
  }

  public String getVersion() {
    return version;
  }

  public String getWorkNumber() {
    return workNumber;
  }

  public String getZip() {
    return zip;
  }

  @Override
  public boolean isValid() {

    if ((workNumber == "")
        && (cellNumber == "")
        && (email == "")
        && (url == "")
        && (street == "")) {
      return false;
    } else if ((isUrlValid() == false) && (url != "")) {
      System.out.println("URL is not valid");
      return false;
    } else if ((isEmailValid() == false) && (email != "")) {
      System.out.println("Email is not valid");
      return false;
    } else if ((isWorkNumberValid() == false) && (workNumber != "")) {
      System.out.println("Work Number is not valid");
      return false;
    } else if ((isCellNumberValid() == false) && (cellNumber != "")) {
      System.out.println("Cell Number is not valid");
      return false;
    }
    return true;
  }

  public boolean isUrlValid() {
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

  public boolean isEmailValid() {
    var p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    var m = p.matcher(email);
    return m.matches();
  }

  public boolean isWorkNumberValid() {
    var p =
        Pattern.compile(
            "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");
    var m = p.matcher(workNumber);
    return m.matches();
  }

  public boolean isCellNumberValid() {
    var p =
        Pattern.compile(
            "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");
    var m = p.matcher(cellNumber);
    return m.matches();
  }

  public String getQrText() {
    if ((isValid() == false) && (firstName == null) && (lastName == null)) {
      return ("BEGIN: QRCONTACT"
          + "\n"
          + "This Contact is not Valid."
          + "\n"
          + "END: QRCONTACT"
          + "\n");
    } else if ((isValid() == false) && (firstName == null)) {
      return ("BEGIN: QRCONTACT"
          + "\n"
          + "The Contact Information For "
          + lastName
          + " is not Valid."
          + "\n"
          + "END: QRCONTACT"
          + "\n");
    } else if ((isValid() == false) && (lastName == null)) {
      return ("BEGIN: QRCONTACT"
          + "\n"
          + "The Contact Information For "
          + firstName
          + " is not Valid."
          + "\n"
          + "END: QRCONTACT"
          + "\n");
    } else if ((isValid() == false) && (lastName != null) && (firstName != null)) {
      return ("BEGIN: QRCONTACT"
          + "\n"
          + "The Contact Information For "
          + firstName
          + " "
          + lastName
          + " is not Valid."
          + "\n"
          + "END: QRCONTACT"
          + "\n");
    } else if ((isValid() == true) && (firstName == "")) {
      return ("BEGIN: QRCONTACT"
          + "\n"
          + "VERSION: "
          + version
          + "\n"
          + "NAME: "
          + lastName
          + "\n"
          + "FULL NAME: "
          + lastName
          + "\n"
          + "JOB TITLE: "
          + description
          + "\n"
          + "ORGANIZATION: "
          + company
          + "\n"
          + "URL: "
          + url
          + "\n"
          + "EMAIL: "
          + email
          + "\n"
          + "WORK NUMBER: "
          + workNumber
          + "\n"
          + "CELL NUMBER: "
          + cellNumber
          + "\n"
          + "STREET: "
          + street
          + "\n"
          + "CITY: "
          + city
          + "\n"
          + "STATE: "
          + state
          + "\n"
          + "ZIP CODE: "
          + zip
          + "\n"
          + "END: QRCONTACT"
          + "\n");
    } else if ((isValid() == true) && (lastName == "")) {
      return ("BEGIN: QRCONTACT"
          + "\n"
          + "VERSION: "
          + version
          + "\n"
          + "NAME: "
          + firstName
          + "\n"
          + "FULL NAME: "
          + firstName
          + "\n"
          + "JOB TITLE: "
          + description
          + "\n"
          + "ORGANIZATION: "
          + company
          + "\n"
          + "URL: "
          + url
          + "\n"
          + "EMAIL: "
          + email
          + "\n"
          + "WORK NUMBER: "
          + workNumber
          + "\n"
          + "CELL NUMBER: "
          + cellNumber
          + "\n"
          + "STREET: "
          + street
          + "\n"
          + "CITY: "
          + city
          + "\n"
          + "STATE: "
          + state
          + "\n"
          + "ZIP CODE: "
          + zip
          + "\n"
          + "END: QRCONTACT"
          + "\n");
    } else if ((isValid() == true) && (firstName != "") && (lastName != "")) {
      return ("BEGIN: QRCONTACT"
          + "\n"
          + "VERSION: "
          + version
          + "\n"
          + "NAME: "
          + lastName
          + ";"
          + firstName
          + "\n"
          + "FULL NAME: "
          + firstName
          + " "
          + lastName
          + "\n"
          + "JOB TITLE: "
          + description
          + "\n"
          + "ORGANIZATION: "
          + company
          + "\n"
          + "URL: "
          + url
          + "\n"
          + "EMAIL: "
          + email
          + "\n"
          + "WORK NUMBER: "
          + workNumber
          + "\n"
          + "CELL NUMBER: "
          + cellNumber
          + "\n"
          + "STREET: "
          + street
          + "\n"
          + "CITY: "
          + city
          + "\n"
          + "STATE: "
          + state
          + "\n"
          + "ZIP CODE: "
          + zip
          + "\n"
          + "END: QRCONTACT"
          + "\n");
    } else return "The Contact is Invalid";
  }

  /** @param version the version to set */
  public void setVersion(String version) {
    this.version = version;
  }

  /** @param firstName the firstName to set */
  public void setFirstName(String firstName) {
    this.firstName = deNull(firstName);
  }

  /** @param lastName the lastName to set */
  public void setLastName(String lastName) {
    this.lastName = deNull(lastName);
  }

  /** @param jobTitle the description to set */
  public void setJobTitle(String jobTitle) {
    this.description = deNull(jobTitle);
  }

  /** @param company the company to set */
  public void setCompany(String company) {
    this.company = deNull(company);
  }

  /** @param url the url to set */
  public void setUrl(String url) {
    this.url = deNull(url);
  }

  /** @param email the email to set */
  public void setEmail(String email) {
    this.email = deNull(email);
  }

  /** @param workNumber the workNumber to set */
  public void setWorkNumber(String workNumber) {
    this.workNumber = deNull(workNumber);
  }

  /** @param cellNumber the cellNumber to set */
  public void setCellNumber(String cellNumber) {
    this.cellNumber = deNull(cellNumber);
  }

  /** @param street the street to set */
  public void setStreet(String street) {
    this.street = deNull(street);
  }

  /** @param city the city to set */
  public void setCity(String city) {
    this.city = deNull(city);
  }

  /** @param zip the zip to set */
  public void setZip(String zip) {
    this.zip = deNull(zip);
  }

  /** @param state the state to set */
  public void setState(String state) {
    this.state = deNull(state);
  }

  private String deNull(String text) {
    if (text == null) {
      return "";
    } else {
      return text;
    }
  }
}