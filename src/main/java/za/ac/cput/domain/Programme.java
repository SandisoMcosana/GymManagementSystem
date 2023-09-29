
package za.ac.cput.domain;

import jakarta.persistence.*;

import java.lang.reflect.Type;
import java.util.Date;

@Entity
public class Programme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int programmeId;
    @OneToOne
    private Subscription subscriptionId;
    @ManyToOne
    private Member memberId;
    private String programmeType;
    private Date date;

    public Programme(){}

    private Programme(Builder builder){
        this.programmeId = builder.programmeId;
        this.subscriptionId = builder.subscriptionId;
        this.memberId = builder.memberId;
        this.programmeType = builder.programmeType;
        this.date = builder.date;
    }

    public int getProgrammeId() {
        return programmeId;
    }

    public Subscription getSubscriptionId() {
        return subscriptionId;
    }

    public Member getMemberId() {
        return memberId;
    }

    public String getProgrammeType() {
        return programmeType;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Programme{" +
                "programmeId='" + programmeId + '\'' +
                ", subscriptionId='" + subscriptionId + '\'' +
                ", memberId=" + memberId +
                ", programmeType='" + programmeType + '\'' +
                ", date=" + date +
                '}';
    }

    public static class Builder{
        private int programmeId;
        private Subscription subscriptionId;
        private Member memberId;
        private String programmeType;
        private Date date;

        public Builder setProgrammeId(int programmeId) {
            this.programmeId = programmeId;
            return this;
        }

        public Builder setSubscriptionId(Subscription subscriptionId) {
            this.subscriptionId = subscriptionId;
            return this;
        }

        public Builder setMemberId(Member memberId) {
            this.memberId = memberId;
            return this;
        }

        public Builder setProgrammeType(String programmeType) {
            this.programmeType = programmeType;
            return this;
        }

        public Builder setDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder copy(Programme programme){
            this.programmeId = programme.programmeId;
            this.subscriptionId = programme.subscriptionId;
            this.memberId = programme.memberId;
            this.programmeType = programme.programmeType;
            this.date = programme.date;
            return this;
        }

        public Programme build(){
            return new Programme(this);
        }
    }
}