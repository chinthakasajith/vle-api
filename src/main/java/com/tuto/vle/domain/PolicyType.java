// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="policy_type")
public class PolicyType implements Serializable {

    /** Primary key. */
    protected static final String PK = "policyTypeId";

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
    @Column(name="policy_type_id", unique=true, nullable=false, precision=10)
    private int policyTypeId;
    @Column(name="policy_type_name", length=255)
    private String policyTypeName;

    /** Default constructor. */
    public PolicyType() {
        super();
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
     * Access method for policyTypeName.
     *
     * @return the current value of policyTypeName
     */
    public String getPolicyTypeName() {
        return policyTypeName;
    }

    /**
     * Setter method for policyTypeName.
     *
     * @param aPolicyTypeName the new value for policyTypeName
     */
    public void setPolicyTypeName(String aPolicyTypeName) {
        policyTypeName = aPolicyTypeName;
    }

    /**
     * Compares the key for this instance with another PolicyType.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class PolicyType and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof PolicyType)) {
            return false;
        }
        PolicyType that = (PolicyType) other;
        if (this.getPolicyTypeId() != that.getPolicyTypeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another PolicyType.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PolicyType)) return false;
        return this.equalKeys(other) && ((PolicyType)other).equalKeys(this);
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
        i = getPolicyTypeId();
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
        StringBuffer sb = new StringBuffer("[PolicyType |");
        sb.append(" policyTypeId=").append(getPolicyTypeId());
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
        ret.put("policyTypeId", Integer.valueOf(getPolicyTypeId()));
        return ret;
    }

}
