// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name = "division_owners")
public class DivisionOwners extends AbstractPersistable<Long> implements Serializable {

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

  @Column(name = "division_id", precision = 10)
  private int divisionId;
  @Column(name = "owner_resource_type_id", precision = 10)
  private int ownerResourceTypeId;
  @Column(name = "owner_id", precision = 10)
  private int ownerId;

  /** Default constructor. */
  public DivisionOwners() {
    super();
  }

  /**
   * Access method for divisionId.
   *
   * @return the current value of divisionId
   */
  public int getDivisionId() {
    return divisionId;
  }

  /**
   * Setter method for divisionId.
   *
   * @param aDivisionId the new value for divisionId
   */
  public void setDivisionId(int aDivisionId) {
    divisionId = aDivisionId;
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

}
