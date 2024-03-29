// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name = "course_owners")
public class CourseOwners extends AbstractPersistable<Long> implements Serializable {

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

  @Column(name = "course_id", precision = 10)
  private int courseId;
  @Column(name = "owner_resource_type_id", precision = 10)
  private int ownerResourceTypeId;
  @Column(name = "owner_id", precision = 10)
  private int ownerId;
  @Column(nullable = false, precision = 19)
  private long id;

  /** Default constructor. */
  public CourseOwners() {
    super();
  }

  /**
   * Access method for courseId.
   *
   * @return the current value of courseId
   */
  public int getCourseId() {
    return courseId;
  }

  /**
   * Setter method for courseId.
   *
   * @param aCourseId the new value for courseId
   */
  public void setCourseId(int aCourseId) {
    courseId = aCourseId;
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
   * Access method for id.
   *
   * @return the current value of id
   */
  public Long getId() {
    return id;
  }

  /**
   * Setter method for id.
   *
   * @param aId the new value for id
   */
  public void setId(long aId) {
    id = aId;
  }

}
