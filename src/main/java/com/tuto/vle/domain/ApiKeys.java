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

@Entity(name="api_keys")
public class ApiKeys implements Serializable {

    /** Primary key. */
    protected static final String PK = "apiTokenId";

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
    @Column(name="api_token_id", unique=true, nullable=false, precision=10)
    private int apiTokenId;
    @Column(name="api_token", length=255)
    private String apiToken;

    /** Default constructor. */
    public ApiKeys() {
        super();
    }

    /**
     * Access method for apiTokenId.
     *
     * @return the current value of apiTokenId
     */
    public int getApiTokenId() {
        return apiTokenId;
    }

    /**
     * Setter method for apiTokenId.
     *
     * @param aApiTokenId the new value for apiTokenId
     */
    public void setApiTokenId(int aApiTokenId) {
        apiTokenId = aApiTokenId;
    }

    /**
     * Access method for apiToken.
     *
     * @return the current value of apiToken
     */
    public String getApiToken() {
        return apiToken;
    }

    /**
     * Setter method for apiToken.
     *
     * @param aApiToken the new value for apiToken
     */
    public void setApiToken(String aApiToken) {
        apiToken = aApiToken;
    }

    /**
     * Compares the key for this instance with another ApiKeys.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class ApiKeys and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof ApiKeys)) {
            return false;
        }
        ApiKeys that = (ApiKeys) other;
        if (this.getApiTokenId() != that.getApiTokenId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another ApiKeys.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof ApiKeys)) return false;
        return this.equalKeys(other) && ((ApiKeys)other).equalKeys(this);
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
        i = getApiTokenId();
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
        StringBuffer sb = new StringBuffer("[ApiKeys |");
        sb.append(" apiTokenId=").append(getApiTokenId());
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
        ret.put("apiTokenId", Integer.valueOf(getApiTokenId()));
        return ret;
    }

}
