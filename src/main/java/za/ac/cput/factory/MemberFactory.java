
package za.ac.cput.factory;

import za.ac.cput.domain.Member;
import za.ac.cput.domain.User;
import za.ac.cput.util.Helper;

public class MemberFactory {
    public static Member createMember(int memberId, User userId) {
        if(Helper.isNullOrEmpty(userId))
            return null;
        return new Member.Builder().setMemberId(memberId)
                .setUserId(userId)
                .build();
    }
}
