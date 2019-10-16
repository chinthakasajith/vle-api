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
@Table(name="course", indexes={@Index(name="course_public_course_id_IX", columnList="public_course_id", unique=true)})
public class Course implements Serializable {

    /** Primary key. */
    protected static final String PK = "courseId";

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
    @Column(name="id", unique=true, nullable=false, precision=10)
    private int courseId;
    @Column(name="public_course_id", unique=true, length=10)
    private String publicCourseId;
    @Column(name="course_name", length=255)
    private String courseName;
    @Column(name="created_dt", nullable=false)
    private Timestamp createdDt;
    @Column(name="updated_dt")
    private Timestamp updatedDt;
    @Column(nullable=false, precision=10)
    private int status;
    @Column(name="start_dt")
    private Timestamp startDt;
    @Column(name="end_dt")
    private Timestamp endDt;
    @Column(name="publish_dt")
    private Timestamp publishDt;
    @Column(name="is_new", precision=10)
    private int isNew;
    @Column(name="price")
    private java.math.BigDecimal price;
    @Column(name="rating")
    private java.math.BigDecimal rating;
    @Column(name="banner", length=255)
    private String courseBanner;

    /** Default constructor. */
    public Course() {
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
     * Access method for publicCourseId.
     *
     * @return the current value of publicCourseId
     */
    public String getPublicCourseId() {
        return publicCourseId;
    }

    /**
     * Setter method for publicCourseId.
     *
     * @param aPublicCourseId the new value for publicCourseId
     */
    public void setPublicCourseId(String aPublicCourseId) {
        publicCourseId = aPublicCourseId;
    }

    /**
     * Access method for courseName.
     *
     * @return the current value of courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Setter method for courseName.
     *
     * @param aCourseName the new value for courseName
     */
    public void setCourseName(String aCourseName) {
        courseName = aCourseName;
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
     * Access method for startDt.
     *
     * @return the current value of startDt
     */
    public Timestamp getStartDt() {
        return startDt;
    }

    /**
     * Setter method for startDt.
     *
     * @param aStartDt the new value for startDt
     */
    public void setStartDt(Timestamp aStartDt) {
        startDt = aStartDt;
    }

    /**
     * Access method for endDt.
     *
     * @return the current value of endDt
     */
    public Timestamp getEndDt() {
        return endDt;
    }

    /**
     * Setter method for endDt.
     *
     * @param aEndDt the new value for endDt
     */
    public void setEndDt(Timestamp aEndDt) {
        endDt = aEndDt;
    }

    /**
     * Access method for publishDt.
     *
     * @return the current value of publishDt
     */
    public Timestamp getPublishDt() {
        return publishDt;
    }

    /**
     * Setter method for publishDt.
     *
     * @param aPublishDt the new value for publishDt
     */
    public void setPublishDt(Timestamp aPublishDt) {
        publishDt = aPublishDt;
    }

    /**
     * Access method for isNew.
     *
     * @return the current value of isNew
     */
    public int getIsNew() {
        return isNew;
    }

    /**
     * Setter method for isNew.
     *
     * @param aIsNew the new value for isNew
     */
    public void setIsNew(int aIsNew) {
        isNew = aIsNew;
    }

    /**
     * Compares the key for this instance with another Course.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class Course and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof Course)) {
            return false;
        }
        Course that = (Course) other;
        if (this.getCourseId() != that.getCourseId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another Course.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Course)) return false;
        return this.equalKeys(other) && ((Course)other).equalKeys(this);
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
        i = getCourseId();
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
        StringBuffer sb = new StringBuffer("[Course |");
        sb.append(" courseId=").append(getCourseId());
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
        ret.put("courseId", Integer.valueOf(getCourseId()));
        return ret;
    }

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}

	public java.math.BigDecimal getRating() {
		return rating;
	}

	public void setRating(java.math.BigDecimal rating) {
		this.rating = rating;
	}

	public String getCourseBanner() {
		return courseBanner;
	}

	public void setCourseBanner(String courseBanner) {
		this.courseBanner = courseBanner;
	}

}
