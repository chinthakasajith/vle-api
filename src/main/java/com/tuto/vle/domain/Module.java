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
@Table(name="module", indexes={@Index(name="module_public_module_id_IX", columnList="public_module_id", unique=true)})
public class Module implements Serializable {

    /** Primary key. */
    protected static final String PK = "moduleId";

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
    @Column(name="module_id", unique=true, nullable=false, precision=10)
    private int moduleId;
    @Column(name="module_name", length=255)
    private String moduleName;
    @Column(nullable=false, precision=10)
    private int status;
    @Column(name="created_dt")
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;
    @Column(name="public_module_id", unique=true, length=10)
    private String publicModuleId;

    /** Default constructor. */
    public Module() {
        super();
    }

    /**
     * Access method for moduleId.
     *
     * @return the current value of moduleId
     */
    public int getModuleId() {
        return moduleId;
    }

    /**
     * Setter method for moduleId.
     *
     * @param aModuleId the new value for moduleId
     */
    public void setModuleId(int aModuleId) {
        moduleId = aModuleId;
    }

    /**
     * Access method for moduleName.
     *
     * @return the current value of moduleName
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Setter method for moduleName.
     *
     * @param aModuleName the new value for moduleName
     */
    public void setModuleName(String aModuleName) {
        moduleName = aModuleName;
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
     * Access method for publicModuleId.
     *
     * @return the current value of publicModuleId
     */
    public String getPublicModuleId() {
        return publicModuleId;
    }

    /**
     * Setter method for publicModuleId.
     *
     * @param aPublicModuleId the new value for publicModuleId
     */
    public void setPublicModuleId(String aPublicModuleId) {
        publicModuleId = aPublicModuleId;
    }

    /**
     * Compares the key for this instance with another Module.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Module and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Module)) {
            return false;
        }
        Module that = (Module) other;
        if (this.getModuleId() != that.getModuleId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Module.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Module)) return false;
        return this.equalKeys(other) && ((Module)other).equalKeys(this);
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
        i = getModuleId();
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
        StringBuffer sb = new StringBuffer("[Module |");
        sb.append(" moduleId=").append(getModuleId());
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
        ret.put("moduleId", Integer.valueOf(getModuleId()));
        return ret;
    }

}
