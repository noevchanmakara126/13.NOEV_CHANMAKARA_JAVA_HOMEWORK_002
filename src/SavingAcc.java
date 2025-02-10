import java.util.Random;
import java.util.UUID;

public class SavingAcc {
    private  String acctype = "";
    private String accId = "";
    private String username ;
    private String dob ;
    private String gender ;
    private String phoneNumber ;
    private Double amount ;
    private Double rate ;
    SavingAcc() {}
    SavingAcc(String acctype,String accId,String username, String dob, String gender, String phoneNumber, Double amount, Double rate) {
        this.acctype = acctype;
        this.accId = accId;
        this.username = username;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.rate = rate;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setAcctype(String acctype) {
        acctype = "Saving Account";
        this.acctype=acctype;
    }

    public String getAccId() {
        return accId;
    }

    public void setAccId(String accId) {
        Random random = new Random(acctype.hashCode());
        this.accId = accId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
