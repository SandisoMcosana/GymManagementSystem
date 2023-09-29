package za.ac.cput.factory;
import za.ac.cput.domain.Member;
import za.ac.cput.domain.Subscription;
import za.ac.cput.util.Helper;

public class SubscriptionFactory {
    public static Subscription createSubscription(int subscriptionId, Member memberId, String subscriptonType){
        if(Helper.isNullOrEmpty(subscriptionId) || Helper.isNullOrEmpty(memberId))
            return null;
        return new Subscription.Builder().setSubscriptionId(subscriptionId)
                .setMemberId(memberId)
                .setSubscriptionType(subscriptonType)
                .build();
    }
}
