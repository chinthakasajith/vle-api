// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;
import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity(name = "course_category")
public class CourseCategory extends AbstractPersistable<Long> implements Serializable {

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
  @Column(name = "content_category_id", precision = 10)
  private int contentCategoryId;

  /** Default constructor. */
  public CourseCategory() {
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
