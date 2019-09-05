// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="university", indexes={@Index(name="university_public_university_id_IX", columnList="public_university_id", unique=true)})
public class University implements Serializable {

    /** Primary key. */
    protected static final String PK = "universityId";

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
    @Column(name="university_id", unique=true, nullable=false, precision=10)
    private int universityId;
    @Column(name="public_university_id", unique=true, length=10)
    private String publicUniversityId;
    @Column(name="university_name", length=255)
    private String universityName;
    @Column(precision=10)
    private int status;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;

    /** Default constructor. */
    public University() {
        super();
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
     * Access method for publicUniversityId.
     *
     * @return the current value of publicUniversityId
     */
    public String getPublicUniversityId() {
        return publicUniversityId;
    }

    /**
     * Setter method for publicUniversityId.
     *
     * @param aPublicUniversityId the new value for publicUniversityId
     */
    public void setPublicUniversityId(String aPublicUniversityId) {
        publicUniversityId = aPublicUniversityId;
    }

    /**
     * Access method for universityName.
     *
     * @return the current value of universityName
     */
    public String getUniversityName() {
        return universityName;
    }

    /**
     * Setter method for universityName.
     *
     * @param aUniversityName the new value for universityName
     */
    public void setUniversityName(String aUniversityName) {
        universityName = aUniversityName;
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
     * Access method for createdDt.
     *
     * @return the current value of createdDt
     */
    public Timestamp getCreatedDt() {
        return createdDt;
    }

    /**
     * Setter method for createdDt.
     *
     * @param aCreatedDt the new value for createdDt
     */
    public void setCreatedDt(Timestamp aCreatedDt) {
        createdDt = aCreatedDt;
    }

    /**
     * Access method for updatedDt.
     *
     * @return the current value of updatedDt
     */
    public Timestamp getUpdatedDt() {
        return updatedDt;
    }

    /**
     * Setter method for updatedDt.
     *
     * @param aUpdatedDt the new value for updatedDt
     */
    public void setUpdatedDt(Timestamp aUpdatedDt) {
        updatedDt = aUpdatedDt;
    }

    /**
     * Compares the key for this instance with another University.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class University and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof University)) {
            return false;
        }
        University that = (University) other;
        if (this.getUniversityId() != that.getUniversityId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another University.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof University)) return false;
        return this.equalKeys(other) && ((University)other).equalKeys(this);
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
        i = getUniversityId();
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
        StringBuffer sb = new StringBuffer("[University |");
        sb.append(" universityId=").append(getUniversityId());
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
        ret.put("universityId", Integer.valueOf(getUniversityId()));
        return ret;
    }

}
