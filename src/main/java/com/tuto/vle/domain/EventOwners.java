// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name="event_owners")
public class EventOwners extends AbstractPersistable<Long> implements Serializable {

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

    @Column(name="event_id", precision=10)
    private int eventId;
    @Column(name="owner_type_id", precision=10)
    private int ownerTypeId;
    @Column(name="owner_id", precision=10)
    private int ownerId;

    /** Default constructor. */
    public EventOwners() {
        super();
    }

    /**
     * Access method for eventId.
     *
     * @return the current value of eventId
     */
    public int getEventId() {
        return eventId;
    }

    /**
     * Setter method for eventId.
     *
     * @param aEventId the new value for eventId
     */
    public void setEventId(int aEventId) {
        eventId = aEventId;
    }

    /**
     * Access method for ownerTypeId.
     *
     * @return the current value of ownerTypeId
     */
    public int getOwnerTypeId() {
        return ownerTypeId;
    }

    /**
     * Setter method for ownerTypeId.
     *
     * @param aOwnerTypeId the new value for ownerTypeId
     */
    public void setOwnerTypeId(int aOwnerTypeId) {
        ownerTypeId = aOwnerTypeId;
    }

    /**
     * Access method for ownerId.
     *
     * @return the current value of ownerId
     */
    public int getOwnerId() {
        return ownerId;
    }

    /**
     * Setter method for ownerId.
     *
     * @param aOwnerId the new value for ownerId
     */
    public void setOwnerId(int aOwnerId) {
        ownerId = aOwnerId;
    }

}
