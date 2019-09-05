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

@Entity(name="user_action")
public class UserAction implements Serializable {

    /** Primary key. */
    protected static final String PK = "actionId";

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
    @Column(name="action_id", unique=true, nullable=false, precision=10)
    private int actionId;
    @Column(name="user_id", precision=10)
    private int userId;
    @Column(name="user_action_type_id", precision=10)
    private int userActionTypeId;
    @Column(name="action_dt")
    private Timestamp actionDt;
    @Column(name="action_val_int", precision=10)
    private int actionValInt;
    @Column(name="action_val_str", length=100)
    private String actionValStr;

    /** Default constructor. */
    public UserAction() {
        super();
    }

    /**
     * Access method for actionId.
     *
     * @return the current value of actionId
     */
    public int getActionId() {
        return actionId;
    }

    /**
     * Setter method for actionId.
     *
     * @param aActionId the new value for actionId
     */
    public void setActionId(int aActionId) {
        actionId = aActionId;
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
     * Access method for userActionTypeId.
     *
     * @return the current value of userActionTypeId
     */
    public int getUserActionTypeId() {
        return userActionTypeId;
    }

    /**
     * Setter method for userActionTypeId.
     *
     * @param aUserActionTypeId the new value for userActionTypeId
     */
    public void setUserActionTypeId(int aUserActionTypeId) {
        userActionTypeId = aUserActionTypeId;
    }

    /**
     * Access method for actionDt.
     *
     * @return the current value of actionDt
     */
    public Timestamp getActionDt() {
        return actionDt;
    }

    /**
     * Setter method for actionDt.
     *
     * @param aActionDt the new value for actionDt
     */
    public void setActionDt(Timestamp aActionDt) {
        actionDt = aActionDt;
    }

    /**
     * Access method for actionValInt.
     *
     * @return the current value of actionValInt
     */
    public int getActionValInt() {
        return actionValInt;
    }

    /**
     * Setter method for actionValInt.
     *
     * @param aActionValInt the new value for actionValInt
     */
    public void setActionValInt(int aActionValInt) {
        actionValInt = aActionValInt;
    }

    /**
     * Access method for actionValStr.
     *
     * @return the current value of actionValStr
     */
    public String getActionValStr() {
        return actionValStr;
    }

    /**
     * Setter method for actionValStr.
     *
     * @param aActionValStr the new value for actionValStr
     */
    public void setActionValStr(String aActionValStr) {
        actionValStr = aActionValStr;
    }

    /**
     * Compares the key for this instance with another UserAction.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class UserAction and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof UserAction)) {
            return false;
        }
        UserAction that = (UserAction) other;
        if (this.getActionId() != that.getActionId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another UserAction.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof UserAction)) return false;
        return this.equalKeys(other) && ((UserAction)other).equalKeys(this);
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
        i = getActionId();
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
        StringBuffer sb = new StringBuffer("[UserAction |");
        sb.append(" actionId=").append(getActionId());
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
        ret.put("actionId", Integer.valueOf(getActionId()));
        return ret;
    }

}
