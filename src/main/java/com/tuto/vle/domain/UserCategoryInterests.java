// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name = "user_category_interests")
public class UserCategoryInterests extends AbstractPersistable<Long> implements Serializable {

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

  @Column(name = "user_id", precision = 10)
  private int userId;
  @Column(name = "content_category_id", precision = 10)
  private int contentCategoryId;

  /** Default constructor. */
  public UserCategoryInterests() {
    super();
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
   * Access method for contentCategoryId.
   *
   * @return the current value of contentCategoryId
   */
  public int getContentCategoryId() {
    return contentCategoryId;
  }

  /**
   * Setter method for contentCategoryId.
   *
   * @param aContentCategoryId the new value for contentCategoryId
   */
  public void setContentCategoryId(int aContentCategoryId) {
    contentCategoryId = aContentCategoryId;
  }

}
