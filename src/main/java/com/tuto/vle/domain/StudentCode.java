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
@Table(name="student_code", indexes={@Index(name="student_code_auth_code_IX", columnList="auth_code", unique=true)})
public class StudentCode implements Serializable {

    /** Primary key. */
    protected static final String PK = "id";

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
    @Column(unique=true, nullable=false, precision=10)
    private int id;
    @Column(name="student_id", precision=10)
    private int studentId;
    @Column(name="user_id", precision=10)
    private int userId;
    @Column(name="auth_code", unique=true, length=10)
    private String authCode;
    @Column(name="create_dt")
    private Timestamp createDt;
    @Column(name="expire_dt")
    private Timestamp expireDt;

    /** Default constructor. */
    public StudentCode() {
        super();
    }

    /**
     * Access method for id.
     *
     * @return the current value of id
     */
    public int getId() {
        return id;
    }

    /**
     * Setter method for id.
     *
     * @param aId the new value for id
     */
    public void setId(int aId) {
        id = aId;
    }

    /**
     * Access method for studentId.
     *
     * @return the current value of studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * Setter method for studentId.
     *
     * @param aStudentId the new value for studentId
     */
    public void setStudentId(int aStudentId) {
        studentId = aStudentId;
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
     * Access method for authCode.
     *
     * @return the current value of authCode
     */
    public String getAuthCode() {
        return authCode;
    }

    /**
     * Setter method for authCode.
     *
     * @param aAuthCode the new value for authCode
     */
    public void setAuthCode(String aAuthCode) {
        authCode = aAuthCode;
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
     * Compares the key for this instance with another StudentCode.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class StudentCode and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof StudentCode)) {
            return false;
        }
        StudentCode that = (StudentCode) other;
        if (this.getId() != that.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another StudentCode.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof StudentCode)) return false;
        return this.equalKeys(other) && ((StudentCode)other).equalKeys(this);
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
        i = getId();
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
        StringBuffer sb = new StringBuffer("[StudentCode |");
        sb.append(" id=").append(getId());
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
        ret.put("id", Integer.valueOf(getId()));
        return ret;
    }

}
