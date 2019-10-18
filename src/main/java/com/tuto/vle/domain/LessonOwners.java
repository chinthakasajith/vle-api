// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name = "lesson_owners")
public class LessonOwners extends AbstractPersistable<Long> implements Serializable {

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

  @Column(name = "lesson_id", precision = 10)
  private int lessonId;
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

  /** Default constructor. */
  public LessonOwners() {
    super();
  }

  /**
   * Access method for lessonId.
   *
   * @return the current value of lessonId
   */
  public int getLessonId() {
    return lessonId;
  }

  /**
   * Setter method for lessonId.
   *
   * @param aLessonId the new value for lessonId
   */
  public void setLessonId(int aLessonId) {
    lessonId = aLessonId;
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

}
