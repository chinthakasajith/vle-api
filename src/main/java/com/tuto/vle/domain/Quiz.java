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

@Entity(name="quiz")
public class Quiz implements Serializable {

    /** Primary key. */
    protected static final String PK = "quizId";

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
    @Column(name="quiz_id", unique=true, nullable=false, precision=10)
    private int quizId;
    @Column(name="quiz_name", length=255)
    private String quizName;
    @Column(precision=10)
    private int status;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;

    /** Default constructor. */
    public Quiz() {
        super();
    }

    /**
     * Access method for quizId.
     *
     * @return the current value of quizId
     */
    public int getQuizId() {
        return quizId;
    }

    /**
     * Setter method for quizId.
     *
     * @param aQuizId the new value for quizId
     */
    public void setQuizId(int aQuizId) {
        quizId = aQuizId;
    }

    /**
     * Access method for quizName.
     *
     * @return the current value of quizName
     */
    public String getQuizName() {
        return quizName;
    }

    /**
     * Setter method for quizName.
     *
     * @param aQuizName the new value for quizName
     */
    public void setQuizName(String aQuizName) {
        quizName = aQuizName;
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
     * Compares the key for this instance with another Quiz.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Quiz and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Quiz)) {
            return false;
        }
        Quiz that = (Quiz) other;
        if (this.getQuizId() != that.getQuizId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Quiz.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Quiz)) return false;
        return this.equalKeys(other) && ((Quiz)other).equalKeys(this);
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
        i = getQuizId();
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
        StringBuffer sb = new StringBuffer("[Quiz |");
        sb.append(" quizId=").append(getQuizId());
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
        ret.put("quizId", Integer.valueOf(getQuizId()));
        return ret;
    }

}
