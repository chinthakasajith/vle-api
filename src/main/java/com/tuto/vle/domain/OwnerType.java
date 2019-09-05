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

@Entity(name="owner_type")
public class OwnerType implements Serializable {

    /** Primary key. */
    protected static final String PK = "ownerTypeId";

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
    @Column(name="owner_type_id", unique=true, nullable=false, precision=10)
    private int ownerTypeId;
    @Column(name="owner_type_name", length=50)
    private String ownerTypeName;

    /** Default constructor. */
    public OwnerType() {
        super();
    }

    /**
     * Access method for ownerTypeId.
     *
     * @return the current value of ownerTypeId
     */
    public int getOwnerTypeId() {
        return ownerTypeId;
    }

    /**
     * Setter method for ownerTypeId.
     *
     * @param aOwnerTypeId the new value for ownerTypeId
     */
    public void setOwnerTypeId(int aOwnerTypeId) {
        ownerTypeId = aOwnerTypeId;
    }

    /**
     * Access method for ownerTypeName.
     *
     * @return the current value of ownerTypeName
     */
    public String getOwnerTypeName() {
        return ownerTypeName;
    }

    /**
     * Setter method for ownerTypeName.
     *
     * @param aOwnerTypeName the new value for ownerTypeName
     */
    public void setOwnerTypeName(String aOwnerTypeName) {
        ownerTypeName = aOwnerTypeName;
    }

    /**
     * Compares the key for this instance with another OwnerType.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class OwnerType and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof OwnerType)) {
            return false;
        }
        OwnerType that = (OwnerType) other;
        if (this.getOwnerTypeId() != that.getOwnerTypeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another OwnerType.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof OwnerType)) return false;
        return this.equalKeys(other) && ((OwnerType)other).equalKeys(this);
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
        i = getOwnerTypeId();
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
        StringBuffer sb = new StringBuffer("[OwnerType |");
        sb.append(" ownerTypeId=").append(getOwnerTypeId());
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
        ret.put("ownerTypeId", Integer.valueOf(getOwnerTypeId()));
        return ret;
    }

}
