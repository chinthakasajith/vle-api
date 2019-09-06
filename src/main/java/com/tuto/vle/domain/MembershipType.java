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

@Entity(name="membership_type")
public class MembershipType implements Serializable {

    /** Primary key. */
    protected static final String PK = "membershipTypeId";

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
    @Column(name="membership_type_id", unique=true, nullable=false, precision=10)
    private int membershipTypeId;
    @Column(name="membership_type_name", length=50)
    private String membershipTypeName;

    /** Default constructor. */
    public MembershipType() {
        super();
    }

    /**
     * Access method for membershipTypeId.
     *
     * @return the current value of membershipTypeId
     */
    public int getMembershipTypeId() {
        return membershipTypeId;
    }

    /**
     * Setter method for membershipTypeId.
     *
     * @param aMembershipTypeId the new value for membershipTypeId
     */
    public void setMembershipTypeId(int aMembershipTypeId) {
        membershipTypeId = aMembershipTypeId;
    }

    /**
     * Access method for membershipTypeName.
     *
     * @return the current value of membershipTypeName
     */
    public String getMembershipTypeName() {
        return membershipTypeName;
    }

    /**
     * Setter method for membershipTypeName.
     *
     * @param aMembershipTypeName the new value for membershipTypeName
     */
    public void setMembershipTypeName(String aMembershipTypeName) {
        membershipTypeName = aMembershipTypeName;
    }

    /**
     * Compares the key for this instance with another MembershipType.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class MembershipType and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof MembershipType)) {
            return false;
        }
        MembershipType that = (MembershipType) other;
        if (this.getMembershipTypeId() != that.getMembershipTypeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another MembershipType.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MembershipType)) return false;
        return this.equalKeys(other) && ((MembershipType)other).equalKeys(this);
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
        i = getMembershipTypeId();
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
        StringBuffer sb = new StringBuffer("[MembershipType |");
        sb.append(" membershipTypeId=").append(getMembershipTypeId());
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
        ret.put("membershipTypeId", Integer.valueOf(getMembershipTypeId()));
        return ret;
    }

}
