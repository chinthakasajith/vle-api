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
@Table(name="user", indexes={@Index(name="user_public_user_id_IX", columnList="public_user_id", unique=true), @Index(name="user_email_IX", columnList="email", unique=true)})
public class User implements Serializable {

    /** Primary key. */
    protected static final String PK = "userId";

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
    @Column(name="user_id", unique=true, nullable=false, precision=10)
    private int userId;
    @Column(name="public_user_id", unique=true, length=10)
    private String publicUserId;
    @Column(unique=true, nullable=false, length=190)
    private String email;
    @Column(nullable=false, length=128)
    private String password;
    @Column(name="first_name", length=100)
    private String firstName;
    @Column(name="last_name", length=100)
    private String lastName;
    @Column(length=50)
    private String timezone;
    private String preferences;
    @Column(name="is_verified", nullable=false, length=3)
    private boolean isVerified;
    @Column(name="is_active", nullable=false, length=3)
    private boolean isActive;
    @Column(name="created_at", nullable=false)
    private Timestamp createdAt;
    @Column(name="updated_at", nullable=false)
    private Timestamp updatedAt;
    @Column(name="last_login")
    private Timestamp lastLogin;
    @Column(name="place_id", length=190)
    private String placeId;
    @Column(length=255)
    private String avatar;
    @Column(name="source_owner_id", length=12)
    private String sourceOwnerId;
    @Column(name="source_description", length=255)
    private String sourceDescription;
    @Column(name="role_id", precision=10)
    private int roleId;

    /** Default constructor. */
    public User() {
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
     * Access method for publicUserId.
     *
     * @return the current value of publicUserId
     */
    public String getPublicUserId() {
        return publicUserId;
    }

    /**
     * Setter method for publicUserId.
     *
     * @param aPublicUserId the new value for publicUserId
     */
    public void setPublicUserId(String aPublicUserId) {
        publicUserId = aPublicUserId;
    }

    /**
     * Access method for email.
     *
     * @return the current value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Setter method for email.
     *
     * @param aEmail the new value for email
     */
    public void setEmail(String aEmail) {
        email = aEmail;
    }

    /**
     * Access method for password.
     *
     * @return the current value of password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter method for password.
     *
     * @param aPassword the new value for password
     */
    public void setPassword(String aPassword) {
        password = aPassword;
    }

    /**
     * Access method for firstName.
     *
     * @return the current value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Setter method for firstName.
     *
     * @param aFirstName the new value for firstName
     */
    public void setFirstName(String aFirstName) {
        firstName = aFirstName;
    }

    /**
     * Access method for lastName.
     *
     * @return the current value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter method for lastName.
     *
     * @param aLastName the new value for lastName
     */
    public void setLastName(String aLastName) {
        lastName = aLastName;
    }

    /**
     * Access method for timezone.
     *
     * @return the current value of timezone
     */
    public String getTimezone() {
        return timezone;
    }

    /**
     * Setter method for timezone.
     *
     * @param aTimezone the new value for timezone
     */
    public void setTimezone(String aTimezone) {
        timezone = aTimezone;
    }

    /**
     * Access method for preferences.
     *
     * @return the current value of preferences
     */
    public String getPreferences() {
        return preferences;
    }

    /**
     * Setter method for preferences.
     *
     * @param aPreferences the new value for preferences
     */
    public void setPreferences(String aPreferences) {
        preferences = aPreferences;
    }

    /**
     * Access method for isVerified.
     *
     * @return true if and only if isVerified is currently true
     */
    public boolean getIsVerified() {
        return isVerified;
    }

    /**
     * Setter method for isVerified.
     *
     * @param aIsVerified the new value for isVerified
     */
    public void setIsVerified(boolean aIsVerified) {
        isVerified = aIsVerified;
    }

    /**
     * Access method for isActive.
     *
     * @return true if and only if isActive is currently true
     */
    public boolean getIsActive() {
        return isActive;
    }

    /**
     * Setter method for isActive.
     *
     * @param aIsActive the new value for isActive
     */
    public void setIsActive(boolean aIsActive) {
        isActive = aIsActive;
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
     * Access method for lastLogin.
     *
     * @return the current value of lastLogin
     */
    public Timestamp getLastLogin() {
        return lastLogin;
    }

    /**
     * Setter method for lastLogin.
     *
     * @param aLastLogin the new value for lastLogin
     */
    public void setLastLogin(Timestamp aLastLogin) {
        lastLogin = aLastLogin;
    }

    /**
     * Access method for placeId.
     *
     * @return the current value of placeId
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     * Setter method for placeId.
     *
     * @param aPlaceId the new value for placeId
     */
    public void setPlaceId(String aPlaceId) {
        placeId = aPlaceId;
    }

    /**
     * Access method for avatar.
     *
     * @return the current value of avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * Setter method for avatar.
     *
     * @param aAvatar the new value for avatar
     */
    public void setAvatar(String aAvatar) {
        avatar = aAvatar;
    }

    /**
     * Access method for sourceOwnerId.
     *
     * @return the current value of sourceOwnerId
     */
    public String getSourceOwnerId() {
        return sourceOwnerId;
    }

    /**
     * Setter method for sourceOwnerId.
     *
     * @param aSourceOwnerId the new value for sourceOwnerId
     */
    public void setSourceOwnerId(String aSourceOwnerId) {
        sourceOwnerId = aSourceOwnerId;
    }

    /**
     * Access method for sourceDescription.
     *
     * @return the current value of sourceDescription
     */
    public String getSourceDescription() {
        return sourceDescription;
    }

    /**
     * Setter method for sourceDescription.
     *
     * @param aSourceDescription the new value for sourceDescription
     */
    public void setSourceDescription(String aSourceDescription) {
        sourceDescription = aSourceDescription;
    }

    /**
     * Access method for roleId.
     *
     * @return the current value of roleId
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Setter method for roleId.
     *
     * @param aRoleId the new value for roleId
     */
    public void setRoleId(int aRoleId) {
        roleId = aRoleId;
    }

    /**
     * Compares the key for this instance with another User.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class User and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof User)) {
            return false;
        }
        User that = (User) other;
        if (this.getUserId() != that.getUserId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another User.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof User)) return false;
        return this.equalKeys(other) && ((User)other).equalKeys(this);
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
        i = getUserId();
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
        StringBuffer sb = new StringBuffer("[User |");
        sb.append(" userId=").append(getUserId());
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
        ret.put("userId", Integer.valueOf(getUserId()));
        return ret;
    }

}
