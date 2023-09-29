package za.ac.cput.factory;

import za.ac.cput.domain.Membership;
import za.ac.cput.domain.Subscription;
import za.ac.cput.util.Helper;

import java.sql.Date;

public class MembershipFactory {
    public static Membership createMembership(int membershipId, Subscription subscriptionId, String membershipType,Date startDate, Date endDate, String membershipStatus){
        if(Helper.isNullOrEmpty(subscriptionId) || Helper.isNullOrEmpty(membershipId) || (Helper.isNullOrEmpty(membershipType)))
            return null;
        return new Membership.Builder().setMembershipId(membershipId)
                .setSubscriptionId(subscriptionId)
                .setMembershipType(membershipType)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setMembershipStatus(membershipStatus)
                .build();
    }
}
