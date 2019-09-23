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

@Entity(name="user_university_memberships_scopes")
public class UserUniversityMembershipsScopes implements Serializable {

    /** Primary key. */
    protected static final String PK = "scopeId";

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
    @Column(name="scope_id", unique=true, nullable=false, precision=10)
    private int scopeId;
    @Column(name="user_resource_memberships_id", precision=10)
    private int userResourceMembershipsId;
    @Column(length=6)
    private String context;
    @Column(name="resource_type_id", length=10)
    private String resourceTypeId;
    @Column(length=20)
    private String scope;

    /** Default constructor. */
    public UserUniversityMembershipsScopes() {
        super();
    }

    /**
     * Access method for scopeId.
     *
     * @return the current value of scopeId
     */
    public int getScopeId() {
        return scopeId;
    }

    /**
     * Setter method for scopeId.
     *
     * @param aScopeId the new value for scopeId
     */
    public void setScopeId(int aScopeId) {
        scopeId = aScopeId;
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
     * Access method for context.
     *
     * @return the current value of context
     */
    public String getContext() {
        return context;
    }

    /**
     * Setter method for context.
     *
     * @param aContext the new value for context
     */
    public void setContext(String aContext) {
        context = aContext;
    }

    /**
     * Access method for resourceTypeId.
     *
     * @return the current value of resourceTypeId
     */
    public String getResourceTypeId() {
        return resourceTypeId;
    }

    /**
     * Setter method for resourceTypeId.
     *
     * @param aResourceTypeId the new value for resourceTypeId
     */
    public void setResourceTypeId(String aResourceTypeId) {
        resourceTypeId = aResourceTypeId;
    }

    /**
     * Access method for scope.
     *
     * @return the current value of scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * Setter method for scope.
     *
     * @param aScope the new value for scope
     */
    public void setScope(String aScope) {
        scope = aScope;
    }

    /**
     * Compares the key for this instance with another UserUniversityMembershipsScopes.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UserUniversityMembershipsScopes and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UserUniversityMembershipsScopes)) {
            return false;
        }
        UserUniversityMembershipsScopes that = (UserUniversityMembershipsScopes) other;
        if (this.getScopeId() != that.getScopeId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UserUniversityMembershipsScopes.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UserUniversityMembershipsScopes)) return false;
        return this.equalKeys(other) && ((UserUniversityMembershipsScopes)other).equalKeys(this);
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
        i = getScopeId();
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
        StringBuffer sb = new StringBuffer("[UserUniversityMembershipsScopes |");
        sb.append(" scopeId=").append(getScopeId());
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
        ret.put("scopeId", Integer.valueOf(getScopeId()));
        return ret;
    }

}
