package com.fees.model;

/*
 * package com.fees.model;
 * 
 * import java.util.Date;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id;
 * 
 * import com.fasterxml.jackson.annotation.JsonProperty;
 * 
 * import lombok.Getter; import lombok.Setter;
 * 
 * @Entity public class Receipt {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.AUTO)
 * 
 * @Getter @Setter private Long id;
 * 
 * @Getter @Setter
 * 
 * @JsonProperty("studentId") private Long studentId;
 * 
 * @Getter @Setter
 * 
 * @JsonProperty("amount") private double amount;
 * 
 * @Getter @Setter
 * 
 * @JsonProperty("collectionDate") private Date collectionDate;
 * 
 * @Getter @Setter
 * 
 * @JsonProperty("studentName") private String studentName;
 * 
 * @Getter @Setter
 * 
 * @JsonProperty("cardNum") private String cardNum;
 * 
 * @Getter @Setter
 * 
 * @JsonProperty("cardType") private String cardType;
 * 
 * @Getter @Setter
 * 
 * @JsonProperty("referenceId") private String referenceId;
 * 
 * public Long getId() { return id; }
 * 
 * public void setId(Long id) { this.id = id; }
 * 
 * public Long getStudentId() { return studentId; }
 * 
 * public void setStudentId(Long studentId) { this.studentId = studentId; }
 * 
 * public double getAmount() { return amount; }
 * 
 * public void setAmount(double amount) { this.amount = amount; }
 * 
 * public Date getCollectionDate() { return collectionDate; }
 * 
 * public void setCollectionDate(Date collectionDate) { this.collectionDate =
 * collectionDate; }
 * 
 * public String getStudentName() { return studentName; }
 * 
 * public void setStudentName(String studentName) { this.studentName =
 * studentName; }
 * 
 * public String getCardNum() { return cardNum; }
 * 
 * public void setCardNum(String cardNum) { this.cardNum = cardNum; }
 * 
 * public String getCardType() { return cardType; }
 * 
 * public void setCardType(String cardType) { this.cardType = cardType; }
 * 
 * public String getReferenceId() { return referenceId; }
 * 
 * public void setReferenceId(String referenceId) { this.referenceId =
 * referenceId; }
 * 
 * }
 */


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Receipt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long studentId;
    private double amount;
    private Date collectionDate;

    // Getters and setters
}
