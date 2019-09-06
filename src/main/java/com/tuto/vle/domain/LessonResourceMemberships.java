// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name="lesson_resource_memberships")
public class LessonResourceMemberships extends AbstractPersistable<Long> implements Serializable {

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
    @Column(name="membership_type_id", precision=10)
    private int membershipTypeId;
    @Column(name="resource_id", precision=10)
    private int resourceId;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;
    @Column(nullable=false, precision=10)
    private int status;

    /** Default constructor. */
    public LessonResourceMemberships() {
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
     * Access method for membershipTypeId.
     *
     * @return the current value of membershipTypeId
     */
    public int getMembershipTypeId() {
        return membershipTypeId;
    }

    /**
     * Setter method for membershipTypeId.
     *
     * @param aMembershipTypeId the new value for membershipTypeId
     */
    public void setMembershipTypeId(int aMembershipTypeId) {
        membershipTypeId = aMembershipTypeId;
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
