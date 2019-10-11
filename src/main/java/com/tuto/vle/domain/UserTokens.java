// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name = "user_tokens")
public class UserTokens extends AbstractPersistable<Long> implements Serializable {

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
  @Column(name = "token_id", precision = 10)
  private int tokenId;

  /** Default constructor. */
  public UserTokens() {
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
   * Access method for tokenId.
   *
   * @return the current value of tokenId
   */
  public int getTokenId() {
    return tokenId;
  }

  /**
   * Setter method for tokenId.
   *
   * @param aTokenId the new value for tokenId
   */
  public void setTokenId(int aTokenId) {
    tokenId = aTokenId;
  }

}
