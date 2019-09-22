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
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="lesson", indexes={@Index(name="lesson_public_lesson_id_IX", columnList="public_lesson_id", unique=true)})
public class Lesson implements Serializable {

    /** Primary key. */
    protected static final String PK = "lessonId";

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
    @Column(name="lesson_id", unique=true, nullable=false, precision=10)
    private int lessonId;
    @Column(name="public_lesson_id", unique=true, length=10)
    private String publicLessonId;
    @Column(name="lesson_name", length=255)
    private String lessonName;
    @Column(name="created_dt", nullable=false)
    private Timestamp createdDt;
    @Column(precision=10)
    private int status;
    @Column(name="updated_dt")
    private Timestamp updatedDt;
    @Column(name="stream_url")
    private String streamUrl;

    /** Default constructor. */
    public Lesson() {
        super();
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
     * Access method for publicLessonId.
     *
     * @return the current value of publicLessonId
     */
    public String getPublicLessonId() {
        return publicLessonId;
    }

    /**
     * Setter method for publicLessonId.
     *
     * @param aPublicLessonId the new value for publicLessonId
     */
    public void setPublicLessonId(String aPublicLessonId) {
        publicLessonId = aPublicLessonId;
    }

    /**
     * Access method for lessonName.
     *
     * @return the current value of lessonName
     */
    public String getLessonName() {
        return lessonName;
    }

    /**
     * Setter method for lessonName.
     *
     * @param aLessonName the new value for lessonName
     */
    public void setLessonName(String aLessonName) {
        lessonName = aLessonName;
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
     * Access method for streamUrl.
     *
     * @return the current value of streamUrl
     */
    public String getStreamUrl() {
        return streamUrl;
    }

    /**
     * Setter method for streamUrl.
     *
     * @param aStreamUrl the new value for streamUrl
     */
    public void setStreamUrl(String aStreamUrl) {
        streamUrl = aStreamUrl;
    }

    /**
     * Compares the key for this instance with another Lesson.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Lesson and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Lesson)) {
            return false;
        }
        Lesson that = (Lesson) other;
        if (this.getLessonId() != that.getLessonId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Lesson.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Lesson)) return false;
        return this.equalKeys(other) && ((Lesson)other).equalKeys(this);
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
        i = getLessonId();
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
        StringBuffer sb = new StringBuffer("[Lesson |");
        sb.append(" lessonId=").append(getLessonId());
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
        ret.put("lessonId", Integer.valueOf(getLessonId()));
        return ret;
    }

}
