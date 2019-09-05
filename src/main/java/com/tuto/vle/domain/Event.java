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

@Entity(name="event")
public class Event implements Serializable {

    /** Primary key. */
    protected static final String PK = "eventId";

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
    @Column(name="event_id", unique=true, nullable=false, precision=10)
    private int eventId;
    @Column(name="public_event_id", length=10)
    private String publicEventId;
    @Column(name="event_title", length=255)
    private String eventTitle;
    @Column(precision=10)
    private int status;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;
    @Column(name="event_dt")
    private Timestamp eventDt;

    /** Default constructor. */
    public Event() {
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
     * Access method for publicEventId.
     *
     * @return the current value of publicEventId
     */
    public String getPublicEventId() {
        return publicEventId;
    }

    /**
     * Setter method for publicEventId.
     *
     * @param aPublicEventId the new value for publicEventId
     */
    public void setPublicEventId(String aPublicEventId) {
        publicEventId = aPublicEventId;
    }

    /**
     * Access method for eventTitle.
     *
     * @return the current value of eventTitle
     */
    public String getEventTitle() {
        return eventTitle;
    }

    /**
     * Setter method for eventTitle.
     *
     * @param aEventTitle the new value for eventTitle
     */
    public void setEventTitle(String aEventTitle) {
        eventTitle = aEventTitle;
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
     * Access method for eventDt.
     *
     * @return the current value of eventDt
     */
    public Timestamp getEventDt() {
        return eventDt;
    }

    /**
     * Setter method for eventDt.
     *
     * @param aEventDt the new value for eventDt
     */
    public void setEventDt(Timestamp aEventDt) {
        eventDt = aEventDt;
    }

    /**
     * Compares the key for this instance with another Event.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Event and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Event)) {
            return false;
        }
        Event that = (Event) other;
        if (this.getEventId() != that.getEventId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Event.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Event)) return false;
        return this.equalKeys(other) && ((Event)other).equalKeys(this);
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
        i = getEventId();
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
        StringBuffer sb = new StringBuffer("[Event |");
        sb.append(" eventId=").append(getEventId());
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
        ret.put("eventId", Integer.valueOf(getEventId()));
        return ret;
    }

}
