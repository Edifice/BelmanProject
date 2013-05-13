/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.easv.belman.BE;

/**
 *
 * @author AntalJános
 */
public class Operator extends IEntity {

    private int id;
    private String firstName;
    private String lastName;
    private long ssn;
    private String phoneNo;
    private String addressStreetName;
    private String addressStreetNo;
    private String addressCity;
    private String addressZipCode;
    private String addressCountry;

    public Operator() {
    }

    public Operator(int id) {
        // @TODO get by id
        Operator now = new Operator();

        this.id = now.id;
        this.firstName = now.firstName;
        this.lastName = now.lastName;
        this.ssn = now.ssn;
        this.phoneNo = now.phoneNo;
        this.addressStreetName = now.addressStreetName;
        this.addressStreetNo = now.addressStreetNo;
        this.addressCity = now.addressCity;
        this.addressZipCode = now.addressZipCode;
        this.addressCountry = now.addressCountry;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the ssn
     */
    public long getSsn() {
        return ssn;
    }

    /**
     * @param ssn the ssn to set
     */
    public void setSsn(long ssn) {
        this.ssn = ssn;
    }

    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return the addressStreetName
     */
    public String getAddressStreetName() {
        return addressStreetName;
    }

    /**
     * @param addressStreetName the addressStreetName to set
     */
    public void setAddressStreetName(String addressStreetName) {
        this.addressStreetName = addressStreetName;
    }

    /**
     * @return the addressStreetNo
     */
    public String getAddressStreetNo() {
        return addressStreetNo;
    }

    /**
     * @param addressStreetNo the addressStreetNo to set
     */
    public void setAddressStreetNo(String addressStreetNo) {
        this.addressStreetNo = addressStreetNo;
    }

    /**
     * @return the addressCity
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * @param addressCity the addressCity to set
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    /**
     * @return the addressZipCode
     */
    public String getAddressZipCode() {
        return addressZipCode;
    }

    /**
     * @param addressZipCode the addressZipCode to set
     */
    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }

    /**
     * @return the addressCountry
     */
    public String getAddressCountry() {
        return addressCountry;
    }

    /**
     * @param addressCountry the addressCountry to set
     */
    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }

    @Override
    public String toString() {
        return this.firstName +" "+ this.lastName;
    }
}
