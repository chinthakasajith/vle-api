// Generated with g9.

package com.tuto.vle.domain;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity(name="faq_questions")
public class FaqQuestions implements Serializable {

    /** Primary key. */
    protected static final String PK = "questionId";

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
    @Column(name="question_id", unique=true, nullable=false, precision=10)
    private int questionId;
    @Column(name="faq_id", precision=10)
    private int faqId;
    private String question;
    private String answer;

    /** Default constructor. */
    public FaqQuestions() {
        super();
    }

    /**
     * Access method for questionId.
     *
     * @return the current value of questionId
     */
    public int getQuestionId() {
        return questionId;
    }

    /**
     * Setter method for questionId.
     *
     * @param aQuestionId the new value for questionId
     */
    public void setQuestionId(int aQuestionId) {
        questionId = aQuestionId;
    }

    /**
     * Access method for faqId.
     *
     * @return the current value of faqId
     */
    public int getFaqId() {
        return faqId;
    }

    /**
     * Setter method for faqId.
     *
     * @param aFaqId the new value for faqId
     */
    public void setFaqId(int aFaqId) {
        faqId = aFaqId;
    }

    /**
     * Access method for question.
     *
     * @return the current value of question
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Setter method for question.
     *
     * @param aQuestion the new value for question
     */
    public void setQuestion(String aQuestion) {
        question = aQuestion;
    }

    /**
     * Access method for answer.
     *
     * @return the current value of answer
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Setter method for answer.
     *
     * @param aAnswer the new value for answer
     */
    public void setAnswer(String aAnswer) {
        answer = aAnswer;
    }

    /**
     * Compares the key for this instance with another FaqQuestions.
     *
     * @param other The object to compare to
     * @return True if other object is instance of class FaqQuestions and the key objects are equal
     */
    private boolean equalKeys(Object other) {
        if (this==other) {
            return true;
        }
        if (!(other instanceof FaqQuestions)) {
            return false;
        }
        FaqQuestions that = (FaqQuestions) other;
        if (this.getQuestionId() != that.getQuestionId()) {
            return false;
        }
        return true;
    }

    /**
     * Compares this instance with another FaqQuestions.
     *
     * @param other The object to compare to
     * @return True if the objects are the same
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof FaqQuestions)) return false;
        return this.equalKeys(other) && ((FaqQuestions)other).equalKeys(this);
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
        i = getQuestionId();
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
        StringBuffer sb = new StringBuffer("[FaqQuestions |");
        sb.append(" questionId=").append(getQuestionId());
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
        ret.put("questionId", Integer.valueOf(getQuestionId()));
        return ret;
    }

}
