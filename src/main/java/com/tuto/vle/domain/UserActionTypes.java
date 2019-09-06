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

@Entity(name="user_action_types")
public class UserActionTypes implements Serializable {

    /** Primary key. */
    protected static final String PK = "userActionTypeId";

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
    @Column(name="user_action_type_id", unique=true, nullable=false, precision=10)
    private int userActionTypeId;
    @Column(name="user_action_type_name", length=255)
    private String userActionTypeName;

    /** Default constructor. */
    public UserActionTypes() {
        super();
    }

    /**
     * Access method for userActionTypeId.
     *
     * @return the current value of userActionTypeId
     */
    public int getUserActionTypeId() {
        return userActionTypeId;
    }

    /**
     * Setter method for userActionTypeId.
     *
     * @param aUserActionTypeId the new value for userActionTypeId
     */
    public void setUserActionTypeId(int aUserActionTypeId) {
        userActionTypeId = aUserActionTypeId;
    }

    /**
     * Access method for userActionTypeName.
     *
     * @return the current value of userActionTypeName
     */
    public String getUserActionTypeName() {
        return userActionTypeName;
    }

    /**
     * Setter method for userActionTypeName.
     *
     * @param aUserActionTypeName the new value for userActionTypeName
     */
    public void setUserActionTypeName(String aUserActionTypeName) {
        userActionTypeName = aUserActionTypeName;
    }

    /**
     * Compares the key for this instance with another UserActionTypes.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UserActionTypes and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UserActionTypes)) {
            return false;
        }
        UserActionTypes that = (UserActionTypes) other;
        if (this.getUserActionTypeId() != that.getUserActionTypeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UserActionTypes.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UserActionTypes)) return false;
        return this.equalKeys(other) && ((UserActionTypes)other).equalKeys(this);
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
        i = getUserActionTypeId();
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
        StringBuffer sb = new StringBuffer("[UserActionTypes |");
        sb.append(" userActionTypeId=").append(getUserActionTypeId());
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
        ret.put("userActionTypeId", Integer.valueOf(getUserActionTypeId()));
        return ret;
    }

}
