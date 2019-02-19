/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MMHPackage;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jonathon
 */
@Entity
@Table(name = "UserDiary")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserDiary.findAll", query = "SELECT u FROM UserDiary u"),
    @NamedQuery(name = "UserDiary.findByUserDiaryID", query = "SELECT u FROM UserDiary u WHERE u.userDiaryID = :userDiaryID"),
    @NamedQuery(name = "UserDiary.findByUserID", query = "SELECT u FROM UserDiary u WHERE u.userID = :userID"),
    @NamedQuery(name = "UserDiary.findByDiaryEntryDate", query = "SELECT u FROM UserDiary u WHERE u.diaryEntryDate = :diaryEntryDate"),
    @NamedQuery(name = "UserDiary.findByDiaryEntryOne", query = "SELECT u FROM UserDiary u WHERE u.diaryEntryOne = :diaryEntryOne"),
    @NamedQuery(name = "UserDiary.findByDiaryEntryTwo", query = "SELECT u FROM UserDiary u WHERE u.diaryEntryTwo = :diaryEntryTwo"),
    @NamedQuery(name = "UserDiary.findByDiaryEntryThree", query = "SELECT u FROM UserDiary u WHERE u.diaryEntryThree = :diaryEntryThree"),
    @NamedQuery(name = "UserDiary.findByDiaryEntryFour", query = "SELECT u FROM UserDiary u WHERE u.diaryEntryFour = :diaryEntryFour")
})
public class UserDiary implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "UserDiaryID")
    private Integer userDiaryID;
    @Column(name = "UserID")
    private Integer userID;
    @Column(name = "DiaryEntryDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date diaryEntryDate;
    @Size(max = 2000)
    @Column(name = "DiaryEntryOne")
    private String diaryEntryOne;
    @Size(max = 2000)
    @Column(name = "DiaryEntryTwo")
    private String diaryEntryTwo;
    @Size(max = 2000)
    @Column(name = "DiaryEntryThree")
    private String diaryEntryThree;
    @Size(max = 2000)
    @Column(name = "DiaryEntryFour")
    private String diaryEntryFour;

    public UserDiary() {
    }

    public UserDiary(Integer userDiaryID) {
        this.userDiaryID = userDiaryID;
    }

    public Integer getUserDiaryID() {
        return userDiaryID;
    }

    public void setUserDiaryID(Integer userDiaryID) {
        this.userDiaryID = userDiaryID;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public Date getDiaryEntryDate() {
        return diaryEntryDate;
    }

    public void setDiaryEntryDate(Date diaryEntryDate) {
        this.diaryEntryDate = diaryEntryDate;
    }

    public String getDiaryEntryText() {
        return "Diary Entry 1:\t" + diaryEntryOne + "\nDiary Entry 2:\t" + diaryEntryTwo + "\nDiary Entry 3:\t" + diaryEntryThree + "\nDiary Entry 4:\t" + diaryEntryFour;
    }

    public void setDiaryEntryOne(String diaryEntryOne) {
        this.diaryEntryOne = diaryEntryOne;
    }
    
    public void setDiaryEntryTwo(String diaryEntryTwo) {
        this.diaryEntryTwo = diaryEntryTwo;
    }
        
    public void setDiaryEntryThree(String diaryEntryThree) {
        this.diaryEntryThree = diaryEntryThree;
    }
            
    public void setDiaryEntryFour(String diaryEntryFour) {
        this.diaryEntryFour = diaryEntryFour;
    }
    
    public void setDiaryEntryFive(String diaryEntryFive) {
        this.diaryEntryFour = diaryEntryFour;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userDiaryID != null ? userDiaryID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserDiary)) {
            return false;
        }
        UserDiary other = (UserDiary) object;
        if ((this.userDiaryID == null && other.userDiaryID != null) || (this.userDiaryID != null && !this.userDiaryID.equals(other.userDiaryID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MMHPackage.UserDiary[ userDiaryID=" + userDiaryID + " ]";
    }
    
}
