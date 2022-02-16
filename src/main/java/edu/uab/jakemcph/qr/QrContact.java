/*
 * Author: Jake McPhearson <jakemcph@uab.edu>
 * Assignment:  qr-p3 - EE333 Spring 2022
 *
 * Credits:  https://stackoverflow.com/questions/8204680/java-regex-email
 *           https://www.geeksforgeeks.org/check-if-an-url-is-valid-or-not-using-regular-expression/
 *           https://www.geeksforgeeks.org/java-program-to-check-for-a-valid-mobile-number/
 */

package edu.uab.jakemcph.qr;

import java.util.regex.Pattern;

/** Creates a contact string that displays information about a contact. */
public class QrContact extends QrUrl {

  private String version;
  private String firstName;
  private String lastName;
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

  /**
   * Get the cell phone number information.
   *
   * @return outputs the cellNumber.
   */
  public String getCellNumber() {
    return cellNumber;
  }

  /**
   * Get the city information.
   *
   * @return outputs the city.
   */
  public String getCity() {
    return city;
  }

  /**
   * Get the company information.
   *
   * @return outputs the company.
   */
  public String getCompany() {
    return company;
  }

  /**
   * Get the email address information.
   *
   * @return outputs the email.
   */
  public String getEmail() {
    return email;
  }

  /**
   * Get the first name information.
   *
   * @return outputs the firstName.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Get the job title information.
   *
   * @return outputs the description.
   */
  public String getJobTitle() {
    return description;
  }

  /**
   * Get the last name information.
   *
   * @return outputs the lastName.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Get the state information.
   *
   * @return outputs the state.
   */
  public String getState() {
    return state;
  }

  /**
   * Get the street address information.
   *
   * @return outputs the street.
   */
  public String getStreet() {
    return street;
  }

  /**
   * Get the URL information.
   *
   * @return outputs the url.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Get the version information.
   *
   * @return outputs the version.
   */
  public String getVersion() {
    return version;
  }

  /**
   * Get the work phone number information.
   *
   * @return outputs the workNumber.
   */
  public String getWorkNumber() {
    return workNumber;
  }

  /**
   * Get the ZIP code information.
   *
   * @return outputs the zip.
   */
  public String getZip() {
    return zip;
  }

  /**
   * Determines if the information provided is valid for QrContact.
   *
   * @return outputs true/false.
   */
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

  /**
   * Determines if the information provided is valid for a URL.
   *
   * @return outputs true/false.
   */
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

  /**
   * Determines if the information provided is valid for an email address.
   *
   * @return outputs true/false.
   */
  public boolean isEmailValid() {
    var p = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    var m = p.matcher(email);
    return m.matches();
  }

  /**
   * Determines if the information provided is valid for a phone number.
   *
   * @return outputs true/false.
   */
  public boolean isWorkNumberValid() {
    var p =
        Pattern.compile(
            "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");
    var m = p.matcher(workNumber);
    return m.matches();
  }

  /**
   * Determines if the information provided is valid for a phone number.
   *
   * @return outputs true/false.
   */
  public boolean isCellNumberValid() {
    var p =
        Pattern.compile(
            "^(\\+\\d{1,3}( )?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?\\d{4}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?){2}\\d{3}$"
                + "|^(\\+\\d{1,3}( )?)?(\\d{3}[ ]?)(\\d{2}[ ]?){2}\\d{2}$");
    var m = p.matcher(cellNumber);
    return m.matches();
  }

  /**
   * Get the information required for the string and print it.
   *
   * @return outputs the QrContact string.
   */
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

  /**
   * Set the version information.
   *
   * @param version sets the new version.
   */
  public void setVersion(String version) {
    this.version = version;
  }

  /**
   * Set the first name information.
   *
   * @param firstName sets the new firstName.
   */
  public void setFirstName(String firstName) {
    this.firstName = deNull(firstName);
  }

  /**
   * Set the last name information.
   *
   * @param lastName sets the new lastName.
   */
  public void setLastName(String lastName) {
    this.lastName = deNull(lastName);
  }

  /**
   * Set the job title information.
   *
   * @param jobTitle sets the new description.
   */
  public void setJobTitle(String jobTitle) {
    this.description = deNull(jobTitle);
  }

  /**
   * Set the company information.
   *
   * @param company sets the new company.
   */
  public void setCompany(String company) {
    this.company = deNull(company);
  }

  /**
   * Set the URL information.
   *
   * @param url sets the new url.
   */
  public void setUrl(String url) {
    this.url = deNull(url);
  }

  /**
   * Set the email address information.
   *
   * @param email sets the new email.
   */
  public void setEmail(String email) {
    this.email = deNull(email);
  }

  /**
   * Set the work phone number information.
   *
   * @param workNumber sets the new workNumber.
   */
  public void setWorkNumber(String workNumber) {
    this.workNumber = deNull(workNumber);
  }

  /**
   * Set the cell phone number information.
   *
   * @param cellNumber sets the new cellNumber.
   */
  public void setCellNumber(String cellNumber) {
    this.cellNumber = deNull(cellNumber);
  }

  /**
   * Set the street address information.
   *
   * @param street sets the new street.
   */
  public void setStreet(String street) {
    this.street = deNull(street);
  }

  /**
   * Set the city information.
   *
   * @param city sets the new city.
   */
  public void setCity(String city) {
    this.city = deNull(city);
  }

  /**
   * Set the zip code information.
   *
   * @param zip sets the new zip.
   */
  public void setZip(String zip) {
    this.zip = deNull(zip);
  }

  /**
   * Set the state information.
   *
   * @param state sets the new state.
   */
  public void setState(String state) {
    this.state = deNull(state);
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