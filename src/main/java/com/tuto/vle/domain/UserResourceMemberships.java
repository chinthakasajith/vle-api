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

@Entity(name="user_resource_memberships")
public class UserResourceMemberships implements Serializable {

    /** Primary key. */
    protected static final String PK = "userResourceMembershipsId";

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
    @Column(name="user_resource_memberships_id", unique=true, nullable=false, precision=10)
    private int userResourceMembershipsId;
    @Column(name="user_id", precision=10)
    private int userId;
    @Column(name="resource_type_id", precision=10)
    private int resourceTypeId;
    @Column(name="resource_id", precision=10)
    private int resourceId;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;
    @Column(name="start_dt")
    private Timestamp startDt;
    @Column(name="end_dt")
    private Timestamp endDt;
    @Column(nullable=false, precision=10)
    private int status;
    @Column(nullable=false, precision=19)
    private long id;

    /** Default constructor. */
    public UserResourceMemberships() {
        super();
    }

    /**
     * Access method for userResourceMembershipsId.
     *
     * @return the current value of userResourceMembershipsId
     */
    public int getUserResourceMembershipsId() {
        return userResourceMembershipsId;
    }

    /**
     * Setter method for userResourceMembershipsId.
     *
     * @param aUserResourceMembershipsId the new value for userResourceMembershipsId
     */
    public void setUserResourceMembershipsId(int aUserResourceMembershipsId) {
        userResourceMembershipsId = aUserResourceMembershipsId;
    }

    /**
     * Access method for userId.
     *
     * @return the current value of userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Setter method for userId.
     *
     * @param aUserId the new value for userId
     */
    public void setUserId(int aUserId) {
        userId = aUserId;
    }

    /**
     * Access method for resourceTypeId.
     *
     * @return the current value of resourceTypeId
     */
    public int getResourceTypeId() {
        return resourceTypeId;
    }

    /**
     * Setter method for resourceTypeId.
     *
     * @param aResourceTypeId the new value for resourceTypeId
     */
    public void setResourceTypeId(int aResourceTypeId) {
        resourceTypeId = aResourceTypeId;
    }

    /**
     * Access method for resourceId.
     *
     * @return the current value of resourceId
     */
    public int getResourceId() {
        return resourceId;
    }

    /**
     * Setter method for resourceId.
     *
     * @param aResourceId the new value for resourceId
     */
    public void setResourceId(int aResourceId) {
        resourceId = aResourceId;
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
     * Access method for startDt.
     *
     * @return the current value of startDt
     */
    public Timestamp getStartDt() {
        return startDt;
    }

    /**
     * Setter method for startDt.
     *
     * @param aStartDt the new value for startDt
     */
    public void setStartDt(Timestamp aStartDt) {
        startDt = aStartDt;
    }

    /**
     * Access method for endDt.
     *
     * @return the current value of endDt
     */
    public Timestamp getEndDt() {
        return endDt;
    }

    /**
     * Setter method for endDt.
     *
     * @param aEndDt the new value for endDt
     */
    public void setEndDt(Timestamp aEndDt) {
        endDt = aEndDt;
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
     * Access method for id.
     *
     * @return the current value of id
     */
    public long getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(long aId) {
        id = aId;
    }

    /**
     * Compares the key for this instance with another UserResourceMemberships.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UserResourceMemberships and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UserResourceMemberships)) {
            return false;
        }
        UserResourceMemberships that = (UserResourceMemberships) other;
        if (this.getUserResourceMembershipsId() != that.getUserResourceMembershipsId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UserResourceMemberships.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UserResourceMemberships)) return false;
        return this.equalKeys(other) && ((UserResourceMemberships)other).equalKeys(this);
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
        i = getUserResourceMembershipsId();
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
        StringBuffer sb = new StringBuffer("[UserResourceMemberships |");
        sb.append(" userResourceMembershipsId=").append(getUserResourceMembershipsId());
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
        ret.put("userResourceMembershipsId", Integer.valueOf(getUserResourceMembershipsId()));
        return ret;
    }

}
