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

@Entity(name="news")
public class News implements Serializable {

    /** Primary key. */
    protected static final String PK = "newsId";

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
    @Column(name="news_id", unique=true, nullable=false, precision=10)
    private int newsId;
    @Column(name="news_title", length=255)
    private String newsTitle;
    @Column(precision=10)
    private int status;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;

    /** Default constructor. */
    public News() {
        super();
    }

    /**
     * Access method for newsId.
     *
     * @return the current value of newsId
     */
    public int getNewsId() {
        return newsId;
    }

    /**
     * Setter method for newsId.
     *
     * @param aNewsId the new value for newsId
     */
    public void setNewsId(int aNewsId) {
        newsId = aNewsId;
    }

    /**
     * Access method for newsTitle.
     *
     * @return the current value of newsTitle
     */
    public String getNewsTitle() {
        return newsTitle;
    }

    /**
     * Setter method for newsTitle.
     *
     * @param aNewsTitle the new value for newsTitle
     */
    public void setNewsTitle(String aNewsTitle) {
        newsTitle = aNewsTitle;
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
     * Compares the key for this instance with another News.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class News and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof News)) {
            return false;
        }
        News that = (News) other;
        if (this.getNewsId() != that.getNewsId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another News.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof News)) return false;
        return this.equalKeys(other) && ((News)other).equalKeys(this);
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
        i = getNewsId();
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
        StringBuffer sb = new StringBuffer("[News |");
        sb.append(" newsId=").append(getNewsId());
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
        ret.put("newsId", Integer.valueOf(getNewsId()));
        return ret;
    }

}
