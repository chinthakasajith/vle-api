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

@Entity(name="role")
public class Role implements Serializable {

    /** Primary key. */
    protected static final String PK = "roleId";

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
    @Column(name="role_id", unique=true, nullable=false, precision=10)
    private int roleId;
    @Column(name="role_name", length=255)
    private String roleName;

    /** Default constructor. */
    public Role() {
        super();
    }

    /**
     * Access method for roleId.
     *
     * @return the current value of roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Setter method for roleId.
     *
     * @param aRoleId the new value for roleId
     */
    public void setRoleId(int aRoleId) {
        roleId = aRoleId;
    }

    /**
     * Access method for roleName.
     *
     * @return the current value of roleName
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Setter method for roleName.
     *
     * @param aRoleName the new value for roleName
     */
    public void setRoleName(String aRoleName) {
        roleName = aRoleName;
    }

    /**
     * Compares the key for this instance with another Role.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Role and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Role)) {
            return false;
        }
        Role that = (Role) other;
        if (this.getRoleId() != that.getRoleId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Role.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Role)) return false;
        return this.equalKeys(other) && ((Role)other).equalKeys(this);
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
        i = getRoleId();
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
        StringBuffer sb = new StringBuffer("[Role |");
        sb.append(" roleId=").append(getRoleId());
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
        ret.put("roleId", Integer.valueOf(getRoleId()));
        return ret;
    }

}
