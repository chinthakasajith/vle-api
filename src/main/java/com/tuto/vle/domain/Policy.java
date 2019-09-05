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
import javax.persistence.Version;

@Entity(name="policy")
public class Policy implements Serializable {

    /** Primary key. */
    protected static final String PK = "policyId";

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
    @Column(name="policy_id", unique=true, nullable=false, precision=10)
    private int policyId;
    @Column(name="policy_type_id", precision=10)
    private int policyTypeId;
    @Column(name="policy_name", length=255)
    private String policyName;
    @Column(precision=10)
    private int status;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;
    @Column(name="start_date")
    private Timestamp startDate;
    @Column(name="end_date")
    private Timestamp endDate;

    /** Default constructor. */
    public Policy() {
        super();
    }

    /**
     * Access method for policyId.
     *
     * @return the current value of policyId
     */
    public int getPolicyId() {
        return policyId;
    }

    /**
     * Setter method for policyId.
     *
     * @param aPolicyId the new value for policyId
     */
    public void setPolicyId(int aPolicyId) {
        policyId = aPolicyId;
    }

    /**
     * Access method for policyTypeId.
     *
     * @return the current value of policyTypeId
     */
    public int getPolicyTypeId() {
        return policyTypeId;
    }

    /**
     * Setter method for policyTypeId.
     *
     * @param aPolicyTypeId the new value for policyTypeId
     */
    public void setPolicyTypeId(int aPolicyTypeId) {
        policyTypeId = aPolicyTypeId;
    }

    /**
     * Access method for policyName.
     *
     * @return the current value of policyName
     */
    public String getPolicyName() {
        return policyName;
    }

    /**
     * Setter method for policyName.
     *
     * @param aPolicyName the new value for policyName
     */
    public void setPolicyName(String aPolicyName) {
        policyName = aPolicyName;
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
     * Access method for startDate.
     *
     * @return the current value of startDate
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * Setter method for startDate.
     *
     * @param aStartDate the new value for startDate
     */
    public void setStartDate(Timestamp aStartDate) {
        startDate = aStartDate;
    }

    /**
     * Access method for endDate.
     *
     * @return the current value of endDate
     */
    public Timestamp getEndDate() {
        return endDate;
    }

    /**
     * Setter method for endDate.
     *
     * @param aEndDate the new value for endDate
     */
    public void setEndDate(Timestamp aEndDate) {
        endDate = aEndDate;
    }

    /**
     * Compares the key for this instance with another Policy.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Policy and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Policy)) {
            return false;
        }
        Policy that = (Policy) other;
        if (this.getPolicyId() != that.getPolicyId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Policy.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Policy)) return false;
        return this.equalKeys(other) && ((Policy)other).equalKeys(this);
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
        i = getPolicyId();
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
        StringBuffer sb = new StringBuffer("[Policy |");
        sb.append(" policyId=").append(getPolicyId());
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
        ret.put("policyId", Integer.valueOf(getPolicyId()));
        return ret;
    }

}
