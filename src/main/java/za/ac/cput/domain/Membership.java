package za.ac.cput.domain;
import java.lang.reflect.Member;
import java.sql.Date;
import jakarta.persistence.*;

@Entity
public class Membership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int membershipId;
    @OneToOne
    private Subscription subscriptionId;
    private String membershipType;
    private Date startDate;
    private Date endDate;
    private String membershipStatus;
    protected Membership(){
    }
    private Membership(Builder builder){
        this.membershipId = builder.membershipId;
        this.subscriptionId= builder.subscriptionId;
        this.membershipType= builder.membershipType;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;
        this.membershipStatus = builder.membershipStatus;
    }

    public int getMembershipId() {
        return membershipId;
    }

    public Subscription getSubscriptionId() {
        return subscriptionId;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }

    @Override
    public String toString() {
        return "Membership{" +
                "membershipId=" + membershipId +
                ", subscriptionId=" + subscriptionId +
                ", membershipType='" + membershipType + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", membershipStatus='" + membershipStatus + '\'' +
                '}';
    }

    public static class Builder{
        private int membershipId;
        private Subscription subscriptionId;
        private String membershipType;
        private Date startDate;
        private Date endDate;
        private String membershipStatus;

        public Builder setMembershipId(int membershipId){
            this.membershipId = membershipId;
            return this;
        }
        public Builder setSubscriptionId(Subscription subscriptionId){
            this.subscriptionId = subscriptionId;
            return this;
        }
        public Builder setMembershipType(String membershipType){
            this.membershipType = membershipType;
            return this;
        }
        public Builder setStartDate(Date startDate){
            this.startDate = startDate;
            return this;
        }
        public Builder setEndDate(Date endDate){
            this.endDate = endDate;
            return this;
        }
        public Builder setMembershipStatus(String membershipStatus){
            this.membershipStatus = membershipStatus;
            return this;
        }
        public Builder copy(Membership membership){
            this.subscriptionId = membership.subscriptionId;
            this.membershipId = membership.membershipId;
            this.membershipType = membership.membershipType;
            this.startDate = membership.startDate;
            this.endDate = membership.endDate;
            this.membershipStatus = membershipStatus;
            return this;
        }

        public Membership build(){
            return new Membership(this);
        }
    }
}
