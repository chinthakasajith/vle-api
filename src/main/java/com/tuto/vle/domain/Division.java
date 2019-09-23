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
@Table(name="division", indexes={@Index(name="division_public_division_id_IX", columnList="public_division_id", unique=true)})
public class Division implements Serializable {

    /** Primary key. */
    protected static final String PK = "divisionId";

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
    @Column(name="division_id", unique=true, nullable=false, precision=10)
    private int divisionId;
    @Column(name="public_division_id", unique=true, length=10)
    private String publicDivisionId;
    @Column(name="division_name", length=255)
    private String divisionName;
    @Column(nullable=false, precision=10)
    private int status;
    @Column(name="created_dt", nullable=false)
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;

    /** Default constructor. */
    public Division() {
        super();
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
     * Access method for publicDivisionId.
     *
     * @return the current value of publicDivisionId
     */
    public String getPublicDivisionId() {
        return publicDivisionId;
    }

    /**
     * Setter method for publicDivisionId.
     *
     * @param aPublicDivisionId the new value for publicDivisionId
     */
    public void setPublicDivisionId(String aPublicDivisionId) {
        publicDivisionId = aPublicDivisionId;
    }

    /**
     * Access method for divisionName.
     *
     * @return the current value of divisionName
     */
    public String getDivisionName() {
        return divisionName;
    }

    /**
     * Setter method for divisionName.
     *
     * @param aDivisionName the new value for divisionName
     */
    public void setDivisionName(String aDivisionName) {
        divisionName = aDivisionName;
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
     * Compares the key for this instance with another Division.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Division and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Division)) {
            return false;
        }
        Division that = (Division) other;
        if (this.getDivisionId() != that.getDivisionId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Division.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Division)) return false;
        return this.equalKeys(other) && ((Division)other).equalKeys(this);
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
        i = getDivisionId();
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
        StringBuffer sb = new StringBuffer("[Division |");
        sb.append(" divisionId=").append(getDivisionId());
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
        ret.put("divisionId", Integer.valueOf(getDivisionId()));
        return ret;
    }

}
