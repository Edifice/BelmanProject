package dk.easv.belman.BE;

public class Operator extends IEntity {

    //<editor-fold defaultstate="collapsed" desc=" Global variables ">
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
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" Operator() ">
    public Operator() {
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc=" getId() "> 
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setId(int id) "> 
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getFirstName() "> 
    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setFirstName(String firstName) "> 
    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getLastName() "> 
    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setLastName(String lastName) "> 
    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getSsn() "> 
    /**
     * @return the ssn
     */
    public long getSsn() {
        return ssn;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setSsn(long ssn) "> 
    /**
     * @param ssn the ssn to set
     */
    public void setSsn(long ssn) {
        this.ssn = ssn;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getPhoneNo() "> 
    /**
     * @return the phoneNo
     */
    public String getPhoneNo() {
        return phoneNo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setPhoneNo(String phoneNo) "> 
    /**
     * @param phoneNo the phoneNo to set
     */
    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getAddressStreetName() "> 
    /**
     * @return the addressStreetName
     */
    public String getAddressStreetName() {
        return addressStreetName;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setAddressStreetName(String addressStreetName() "> 
    /**
     * @param addressStreetName the addressStreetName to set
     */
    public void setAddressStreetName(String addressStreetName) {
        this.addressStreetName = addressStreetName;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getaddressStreetNo() "> 
    /**
     * @return the addressStreetNo
     */
    public String getAddressStreetNo() {
        return addressStreetNo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setAddressStreetNo(String addressStreetNo) "> 
    /**
     * @param addressStreetNo the addressStreetNo to set
     */
    public void setAddressStreetNo(String addressStreetNo) {
        this.addressStreetNo = addressStreetNo;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getAddressCity() "> 
    /**
     * @return the addressCity
     */
    public String getAddressCity() {
        return addressCity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setAddressCity(String addressCity) "> 
    /**
     * @param addressCity the addressCity to set
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getAddressZipCode() "> 
    /**
     * @return the addressZipCode
     */
    public String getAddressZipCode() {
        return addressZipCode;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setAddressZipCode(String addressZipCode) "> 
    /**
     * @param addressZipCode the addressZipCode to set
     */
    public void setAddressZipCode(String addressZipCode) {
        this.addressZipCode = addressZipCode;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" getAddressCountry() ">
    /**
     * @return the addressCountry
     */
    public String getAddressCountry() {
        return addressCountry;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" setAddressCountry(String addressCountry) ">
    /**
     * @param addressCountry the addressCountry to set
     */
    public void setAddressCountry(String addressCountry) {
        this.addressCountry = addressCountry;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc=" toString() ">
    @Override
    public String toString() {
        return this.firstName +" "+ this.lastName;
    }
    //</editor-fold>
}
