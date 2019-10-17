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

@Entity(name = "module_owners")
public class ModuleOwners implements Serializable {

  /** Primary key. */
  protected static final String PK = "id";

  /**
   * The optimistic lock. Available via standard bean get/set operations.
   */
  @Version
  @Column(name = "LOCK_FLAG")
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
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(unique = true, nullable = false, precision = 10)
  private int id;
  @Column(name = "owner_resource_type_id", precision = 10)
  private int ownerResourceTypeId;
  @Column(name = "owner_id", precision = 10)
  private int ownerId;
  @Column(name = "created_at")
  private Timestamp createdAt;
  @Column(name = "deleted_at")
  private Timestamp deletedAt;
  @Column(name = "updated_at")
  private Timestamp updatedAt;
  @Column(name = "module_id", nullable = false, precision = 10)
  private int moduleId;

  /** Default constructor. */
  public ModuleOwners() {
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
   * Access method for ownerResourceTypeId.
   *
   * @return the current value of ownerResourceTypeId
   */
  public int getOwnerResourceTypeId() {
    return ownerResourceTypeId;
  }

  /**
   * Setter method for ownerResourceTypeId.
   *
   * @param aOwnerResourceTypeId the new value for ownerResourceTypeId
   */
  public void setOwnerResourceTypeId(int aOwnerResourceTypeId) {
    ownerResourceTypeId = aOwnerResourceTypeId;
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

  /**
   * Access method for createdAt.
   *
   * @return the current value of createdAt
   */
  public Timestamp getCreatedAt() {
    return createdAt;
  }

  /**
   * Setter method for createdAt.
   *
   * @param aCreatedAt the new value for createdAt
   */
  public void setCreatedAt(Timestamp aCreatedAt) {
    createdAt = aCreatedAt;
  }

  /**
   * Access method for deletedAt.
   *
   * @return the current value of deletedAt
   */
  public Timestamp getDeletedAt() {
    return deletedAt;
  }

  /**
   * Setter method for deletedAt.
   *
   * @param aDeletedAt the new value for deletedAt
   */
  public void setDeletedAt(Timestamp aDeletedAt) {
    deletedAt = aDeletedAt;
  }

  /**
   * Access method for updatedAt.
   *
   * @return the current value of updatedAt
   */
  public Timestamp getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Setter method for updatedAt.
   *
   * @param aUpdatedAt the new value for updatedAt
   */
  public void setUpdatedAt(Timestamp aUpdatedAt) {
    updatedAt = aUpdatedAt;
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
   * Compares the key for this instance with another ModuleOwners.
   *
   * @param other The object to compare to
   * @return True if other object is instance of class ModuleOwners and the key objects are equal
   */
  private boolean equalKeys(Object other) {
    if (this == other) {
      return true;
    }
    if (!(other instanceof ModuleOwners)) {
      return false;
    }
    ModuleOwners that = (ModuleOwners) other;
    if (this.getId() != that.getId()) {
      return false;
    }
    return true;
  }

  /**
   * Compares this instance with another ModuleOwners.
   *
   * @param other The object to compare to
   * @return True if the objects are the same
   */
  @Override
  public boolean equals(Object other) {
    if (!(other instanceof ModuleOwners))
      return false;
    return this.equalKeys(other) && ((ModuleOwners) other).equalKeys(this);
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
    result = 37 * result + i;
    return result;
  }

  /**
   * Returns a debug-friendly String representation of this instance.
   *
   * @return String representation of this instance
   */
  @Override
  public String toString() {
    StringBuffer sb = new StringBuffer("[ModuleOwners |");
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
