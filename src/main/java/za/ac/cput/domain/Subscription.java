package za.ac.cput.domain;

import jakarta.persistence.*;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subscriptionId;
    @OneToOne
    private Member memberId;
    private String subscriptionType;

    protected Subscription(){
    }
    private Subscription(Builder builder){
        this.subscriptionId = builder.subscriptionId;
        this.memberId= builder.memberId;
        this.subscriptionType= builder.subscriptionType;
    }
    public int getSubscriptionId() {
        return subscriptionId;
    }
    public Member getMemberId() {
        return memberId;
    }
    public String getSubscriptionType() {
        return subscriptionType;
    }
    @Override
    public String toString() {
        return "Subscription{" +
                "subscriptionId=" + subscriptionId +
                ", memberId=" + memberId +
                ", subscriptionType='" + subscriptionType + '\'' +
                '}';
    }
    public static class Builder{
        private int subscriptionId;
        private Member memberId;
        private String subscriptionType;

        public Builder setSubscriptionId(int subscriptionId){
            this.subscriptionId = subscriptionId;
            return this;
        }
        public Builder setMemberId(Member memberId){
            this.memberId = memberId;
            return this;
        }
        public Builder setSubscriptionType(String Subscription){
            this.subscriptionType = subscriptionType;
            return this;
        }

        public Builder copy(Subscription trainer){
            this.subscriptionId = trainer.subscriptionId;
            this.memberId = trainer.memberId;
            this.subscriptionType = trainer.subscriptionType;
            return this;
        }

        public Subscription build(){
            return new Subscription(this);
        }
    }
}






