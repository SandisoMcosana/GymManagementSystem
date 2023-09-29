
package za.ac.cput.domain;

import jakarta.persistence.*;


@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int memberId;
    @OneToOne
    private User userId;

    protected Member(){}

    private Member(Builder builder){
        this.memberId = builder.memberId;
        this.userId = builder.userId;
    }

    public int getMemberId() {
        return memberId;
    }

    public User getUserId() {
        return userId;
    }


    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", userId=" + userId +
                '}';
    }

    public static class Builder{
        private int memberId;
        private User userId;

        public Builder setMemberId(int memberId){
            this.memberId = memberId;
            return this;
        }

        public Builder setUserId(User userId) {
            this.userId = userId;
            return this;
        }

        public Builder copy(Member member){
            this.memberId = member.memberId;
            this.userId = member.userId;
            return this;
        }

        public Member build(){
            return new Member(this);
        }
    }
}
