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

@Entity(name="token")
public class Token implements Serializable {

    /** Primary key. */
    protected static final String PK = "tokenId";

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
    @Column(name="token_id", unique=true, nullable=false, precision=10)
    private int tokenId;
    @Column(precision=10)
    private int type;
    @Column(name="create_dt")
    private Timestamp createDt;
    @Column(name="expire_dt")
    private Timestamp expireDt;
    @Column(precision=10)
    private int status;
    @Column(name="token_hash")
    private String tokenHash;

    /** Default constructor. */
    public Token() {
        super();
    }

    /**
     * Access method for tokenId.
     *
     * @return the current value of tokenId
     */
    public int getTokenId() {
        return tokenId;
    }

    /**
     * Setter method for tokenId.
     *
     * @param aTokenId the new value for tokenId
     */
    public void setTokenId(int aTokenId) {
        tokenId = aTokenId;
    }

    /**
     * Access method for type.
     *
     * @return the current value of type
     */
    public int getType() {
        return type;
    }

    /**
     * Setter method for type.
     *
     * @param aType the new value for type
     */
    public void setType(int aType) {
        type = aType;
    }

    /**
     * Access method for createDt.
     *
     * @return the current value of createDt
     */
    public Timestamp getCreateDt() {
        return createDt;
    }

    /**
     * Setter method for createDt.
     *
     * @param aCreateDt the new value for createDt
     */
    public void setCreateDt(Timestamp aCreateDt) {
        createDt = aCreateDt;
    }

    /**
     * Access method for expireDt.
     *
     * @return the current value of expireDt
     */
    public Timestamp getExpireDt() {
        return expireDt;
    }

    /**
     * Setter method for expireDt.
     *
     * @param aExpireDt the new value for expireDt
     */
    public void setExpireDt(Timestamp aExpireDt) {
        expireDt = aExpireDt;
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
     * Access method for tokenHash.
     *
     * @return the current value of tokenHash
     */
    public String getTokenHash() {
        return tokenHash;
    }

    /**
     * Setter method for tokenHash.
     *
     * @param aTokenHash the new value for tokenHash
     */
    public void setTokenHash(String aTokenHash) {
        tokenHash = aTokenHash;
    }

    /**
     * Compares the key for this instance with another Token.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Token and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Token)) {
            return false;
        }
        Token that = (Token) other;
        if (this.getTokenId() != that.getTokenId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Token.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Token)) return false;
        return this.equalKeys(other) && ((Token)other).equalKeys(this);
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
        i = getTokenId();
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
        StringBuffer sb = new StringBuffer("[Token |");
        sb.append(" tokenId=").append(getTokenId());
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
        ret.put("tokenId", Integer.valueOf(getTokenId()));
        return ret;
    }

}
