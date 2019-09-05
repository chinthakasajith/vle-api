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

@Entity(name="feedback")
public class Feedback implements Serializable {

    /** Primary key. */
    protected static final String PK = "feedbackId";

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
    @Column(name="feedback_id", unique=true, nullable=false, precision=10)
    private int feedbackId;
    @Column(name="lesson_id", precision=10)
    private int lessonId;
    @Column(name="user_id", precision=10)
    private int userId;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;
    @Column(precision=10)
    private int status;
    @Column(length=255)
    private String comment;

    /** Default constructor. */
    public Feedback() {
        super();
    }

    /**
     * Access method for feedbackId.
     *
     * @return the current value of feedbackId
     */
    public int getFeedbackId() {
        return feedbackId;
    }

    /**
     * Setter method for feedbackId.
     *
     * @param aFeedbackId the new value for feedbackId
     */
    public void setFeedbackId(int aFeedbackId) {
        feedbackId = aFeedbackId;
    }

    /**
     * Access method for lessonId.
     *
     * @return the current value of lessonId
     */
    public int getLessonId() {
        return lessonId;
    }

    /**
     * Setter method for lessonId.
     *
     * @param aLessonId the new value for lessonId
     */
    public void setLessonId(int aLessonId) {
        lessonId = aLessonId;
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
     * Access method for comment.
     *
     * @return the current value of comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter method for comment.
     *
     * @param aComment the new value for comment
     */
    public void setComment(String aComment) {
        comment = aComment;
    }

    /**
     * Compares the key for this instance with another Feedback.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Feedback and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Feedback)) {
            return false;
        }
        Feedback that = (Feedback) other;
        if (this.getFeedbackId() != that.getFeedbackId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Feedback.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Feedback)) return false;
        return this.equalKeys(other) && ((Feedback)other).equalKeys(this);
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
        i = getFeedbackId();
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
        StringBuffer sb = new StringBuffer("[Feedback |");
        sb.append(" feedbackId=").append(getFeedbackId());
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
        ret.put("feedbackId", Integer.valueOf(getFeedbackId()));
        return ret;
    }

}
