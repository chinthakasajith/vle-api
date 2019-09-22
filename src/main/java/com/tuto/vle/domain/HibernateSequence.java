// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name = "hibernate_sequence")
public class HibernateSequence extends AbstractPersistable<Long> implements Serializable {

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

  @Column(name = "next_val", precision = 19)
  private long nextVal;

  /** Default constructor. */
  public HibernateSequence() {
    super();
  }

  /**
   * Access method for nextVal.
   *
   * @return the current value of nextVal
   */
  public long getNextVal() {
    return nextVal;
  }

  /**
   * Setter method for nextVal.
   *
   * @param aNextVal the new value for nextVal
   */
  public void setNextVal(long aNextVal) {
    nextVal = aNextVal;
  }

}
