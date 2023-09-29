
package za.ac.cput.factory;

import za.ac.cput.domain.Member;
import za.ac.cput.domain.Programme;
import za.ac.cput.domain.Subscription;
import za.ac.cput.util.Helper;

import java.util.Date;

public class ProgrammeFactory {
    public static Programme createProgramme(int programmeId, Subscription subscriptionId, Member memberId,
                                            String programmeType, Date date) {
        if (Helper.isNullOrEmpty(programmeId) || Helper.isNullOrEmpty(subscriptionId) || Helper.isNullOrEmpty(memberId))
            return null;
        return new Programme.Builder()
                .setProgrammeId(programmeId)
                .setSubscriptionId(subscriptionId)
                .setMemberId(memberId)
                .setProgrammeType(programmeType)
                .setDate(date)
                .build();
    }
}
