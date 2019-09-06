// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name="lesson_attendance")
public class LessonAttendance extends AbstractPersistable<Long> implements Serializable {

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

    @Column(name="lession_id", precision=10)
    private int lessionId;
    @Column(name="user_id", precision=10)
    private int userId;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(precision=10)
    private int status;

    /** Default constructor. */
    public LessonAttendance() {
        super();
    }

    /**
     * Access method for lessionId.
     *
     * @return the current value of lessionId
     */
    public int getLessionId() {
        return lessionId;
    }

    /**
     * Setter method for lessionId.
     *
     * @param aLessionId the new value for lessionId
     */
    public void setLessionId(int aLessionId) {
        lessionId = aLessionId;
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

}
