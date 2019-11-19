// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="student")
public class Student implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

    /**
     * The optimistic lock. Available via standard bean get/set operations.
     */
    @Version
    @Column(name="LOCK_FLAG")
    private Integer lockFlag;

    /**
     * Access method for the lockFlag property.
     *
     * @return the current value of the lockFlag property
     */
    public Integer getLockFlag() {
        return lockFlag;
    }

    /**
     * Sets the value of the lockFlag property.
     *
     * @param aLockFlag the new value of the lockFlag property
     */
    public void setLockFlag(Integer aLockFlag) {
        lockFlag = aLockFlag;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="first_name", length=255)
    private String firstName;
    @Column(name="middle_name", length=255)
    private String middleName;
    @Column(name="last_name", length=255)
    private String lastName;
    private Date dob;
    @Column(length=50)
    private String nid;
    @Column(length=50)
    private String nationality;
    @Column(name="residential_address_id", precision=10)
    private int residentialAddressId;
    @Column(name="current_address_id", precision=10)
    private int currentAddressId;
    @Column(name="contact_mobile", length=20)
    private String contactMobile;
    @Column(name="other_contact", length=20)
    private String otherContact;
    @Column(length=50)
    private String email;
    @Column(name="updated_at")
    private Timestamp updatedAt;
    @Column(precision=10)
    private int status;
    @Column(name="deleted_at")
    private Timestamp deletedAt;
    @Column(name="created_at")
    private Timestamp createdAt;
    private String code;
    @Column(name="university_id", precision=10)
    private int universityId;
    @Column(name="division_id", precision=10)
    private int divisionId;

    /** Default constructor. */
    public Student() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for firstName.
     *
     * @return the current value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for firstName.
     *
     * @param aFirstName the new value for firstName
     */
    public void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    /**
     * Access method for middleName.
     *
     * @return the current value of middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Setter method for middleName.
     *
     * @param aMiddleName the new value for middleName
     */
    public void setMiddleName(String aMiddleName) {
        middleName = aMiddleName;
    }

    /**
     * Access method for lastName.
     *
     * @return the current value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for lastName.
     *
     * @param aLastName the new value for lastName
     */
    public void setLastName(String aLastName) {
        lastName = aLastName;
    }

    /**
     * Access method for dob.
     *
     * @return the current value of dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * Setter method for dob.
     *
     * @param aDob the new value for dob
     */
    public void setDob(Date aDob) {
        dob = aDob;
    }

    /**
     * Access method for nid.
     *
     * @return the current value of nid
     */
    public String getNid() {
        return nid;
    }

    /**
     * Setter method for nid.
     *
     * @param aNid the new value for nid
     */
    public void setNid(String aNid) {
        nid = aNid;
    }

    /**
     * Access method for nationality.
     *
     * @return the current value of nationality
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Setter method for nationality.
     *
     * @param aNationality the new value for nationality
     */
    public void setNationality(String aNationality) {
        nationality = aNationality;
    }

    /**
     * Access method for residentialAddressId.
     *
     * @return the current value of residentialAddressId
     */
    public int getResidentialAddressId() {
        return residentialAddressId;
    }

    /**
     * Setter method for residentialAddressId.
     *
     * @param aResidentialAddressId the new value for residentialAddressId
     */
    public void setResidentialAddressId(int aResidentialAddressId) {
        residentialAddressId = aResidentialAddressId;
    }

    /**
     * Access method for currentAddressId.
     *
     * @return the current value of currentAddressId
     */
    public int getCurrentAddressId() {
        return currentAddressId;
    }

    /**
     * Setter method for currentAddressId.
     *
     * @param aCurrentAddressId the new value for currentAddressId
     */
    public void setCurrentAddressId(int aCurrentAddressId) {
        currentAddressId = aCurrentAddressId;
    }

    /**
     * Access method for contactMobile.
     *
     * @return the current value of contactMobile
     */
    public String getContactMobile() {
        return contactMobile;
    }

    /**
     * Setter method for contactMobile.
     *
     * @param aContactMobile the new value for contactMobile
     */
    public void setContactMobile(String aContactMobile) {
        contactMobile = aContactMobile;
    }

    /**
     * Access method for otherContact.
     *
     * @return the current value of otherContact
     */
    public String getOtherContact() {
        return otherContact;
    }

    /**
     * Setter method for otherContact.
     *
     * @param aOtherContact the new value for otherContact
     */
    public void setOtherContact(String aOtherContact) {
        otherContact = aOtherContact;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for updatedAt.
     *
     * @return the current value of updatedAt
     */
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Setter method for updatedAt.
     *
     * @param aUpdatedAt the new value for updatedAt
     */
    public void setUpdatedAt(Timestamp aUpdatedAt) {
        updatedAt = aUpdatedAt;
    }

    /**
     * Access method for status.
     *
     * @return the current value of status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Setter method for status.
     *
     * @param aStatus the new value for status
     */
    public void setStatus(int aStatus) {
        status = aStatus;
    }

    /**
     * Access method for deletedAt.
     *
     * @return the current value of deletedAt
     */
    public Timestamp getDeletedAt() {
        return deletedAt;
    }

    /**
     * Setter method for deletedAt.
     *
     * @param aDeletedAt the new value for deletedAt
     */
    public void setDeletedAt(Timestamp aDeletedAt) {
        deletedAt = aDeletedAt;
    }

    /**
     * Access method for createdAt.
     *
     * @return the current value of createdAt
     */
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    /**
     * Setter method for createdAt.
     *
     * @param aCreatedAt the new value for createdAt
     */
    public void setCreatedAt(Timestamp aCreatedAt) {
        createdAt = aCreatedAt;
    }

    /**
     * Access method for code.
     *
     * @return the current value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Setter method for code.
     *
     * @param aCode the new value for code
     */
    public void setCode(String aCode) {
        code = aCode;
    }

    /**
     * Access method for universityId.
     *
     * @return the current value of universityId
     */
    public int getUniversityId() {
        return universityId;
    }

    /**
     * Setter method for universityId.
     *
     * @param aUniversityId the new value for universityId
     */
    public void setUniversityId(int aUniversityId) {
        universityId = aUniversityId;
    }

    /**
     * Access method for divisionId.
     *
     * @return the current value of divisionId
     */
    public int getDivisionId() {
        return divisionId;
    }

    /**
     * Setter method for divisionId.
     *
     * @param aDivisionId the new value for divisionId
     */
    public void setDivisionId(int aDivisionId) {
        divisionId = aDivisionId;
    }

    /**
     * Compares the key for this instance with another Student.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Student and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Student)) {
            return false;
        }
        Student that = (Student) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Student.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Student)) return false;
        return this.equalKeys(other) && ((Student)other).equalKeys(this);
    }

    /**
     * Returns a hash code for this instance.
     *
     * @return Hash code
     */
    @Override
    public int hashCode() {
        int i;
        int result = 17;
        i = getId();
        result = 37*result + i;
        return result;
    }

    /**
     * Returns a debug-friendly String representation of this instance.
     *
     * @return String representation of this instance
     */
    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[Student |");
        sb.append(" id=").append(getId());
        sb.append("]");
        return sb.toString();
    }

    /**
     * Return all elements of the primary key.
     *
     * @return Map of key names to values
     */
    public Map<String, Object> getPrimaryKey() {
        Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
