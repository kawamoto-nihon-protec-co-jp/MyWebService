package ngdemo.entity;

import java.sql.Timestamp;
import org.seasar.doma.Column;
import org.seasar.doma.Entity;
import org.seasar.doma.Id;
import org.seasar.doma.Table;

/**
 * 
 */
@Entity(listener = UserListener.class)
@Table(name = "USER")
public class User {

    /** ユーザID */
    @Id
    @Column(name = "USER_ID")
    String userId;

    /** メールアドレス */
    @Column(name = "EMAIL_ADDRESS")
    String emailAddress;

    /** 名前 */
    @Column(name = "USER_NAME")
    String userName;

    /** パスワード */
    @Column(name = "PASSWORD")
    String password;

    /** 性別 */
    @Column(name = "GENDER")
    String gender;

    /** 年齢 */
    @Column(name = "AGE")
    Integer age;

    /** 身長 */
    @Column(name = "HEIGT")
    Integer heigt;

    /** 体重 */
    @Column(name = "WEIGHT")
    Integer weight;

    /** 登録日 */
    @Column(name = "CREATION_DATE")
    Timestamp creationDate;

    /** 更新日 */
    @Column(name = "LAST_UPDATED_DATE")
    Timestamp lastUpdatedDate;

    /** 
     * Returns the userId.
     * 
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /** 
     * Sets the userId.
     * 
     * @param userId the userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /** 
     * Returns the emailAddress.
     * 
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /** 
     * Sets the emailAddress.
     * 
     * @param emailAddress the emailAddress
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /** 
     * Returns the userName.
     * 
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /** 
     * Sets the userName.
     * 
     * @param userName the userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /** 
     * Returns the password.
     * 
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /** 
     * Sets the password.
     * 
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /** 
     * Returns the gender.
     * 
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /** 
     * Sets the gender.
     * 
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /** 
     * Returns the age.
     * 
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /** 
     * Sets the age.
     * 
     * @param age the age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /** 
     * Returns the heigt.
     * 
     * @return the heigt
     */
    public Integer getHeigt() {
        return heigt;
    }

    /** 
     * Sets the heigt.
     * 
     * @param heigt the heigt
     */
    public void setHeigt(Integer heigt) {
        this.heigt = heigt;
    }

    /** 
     * Returns the weight.
     * 
     * @return the weight
     */
    public Integer getWeight() {
        return weight;
    }

    /** 
     * Sets the weight.
     * 
     * @param weight the weight
     */
    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    /** 
     * Returns the creationDate.
     * 
     * @return the creationDate
     */
    public Timestamp getCreationDate() {
        return creationDate;
    }

    /** 
     * Sets the creationDate.
     * 
     * @param creationDate the creationDate
     */
    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    /** 
     * Returns the lastUpdatedDate.
     * 
     * @return the lastUpdatedDate
     */
    public Timestamp getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    /** 
     * Sets the lastUpdatedDate.
     * 
     * @param lastUpdatedDate the lastUpdatedDate
     */
    public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }
}