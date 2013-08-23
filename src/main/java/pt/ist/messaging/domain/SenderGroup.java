package pt.ist.messaging.domain;

import java.util.HashSet;
import java.util.Set;

import org.joda.time.DateTime;

import pt.ist.bennu.core.annotation.CustomGroupOperator;
import pt.ist.bennu.core.domain.User;
import pt.ist.bennu.core.domain.groups.Group;

import com.google.common.base.Supplier;

@CustomGroupOperator("sender")
public class SenderGroup extends SenderGroup_Base {

    private SenderGroup() {
        super();
    }

    @Override
    public String getPresentationName() {
        return pt.ist.messaging.domain.legacy.SenderGroup.getInstance().getPresentationName();
    }

    @Override
    public Set<User> getMembers() {
        return pt.ist.messaging.domain.legacy.SenderGroup.getInstance().getMembers();
    }

    @Override
    public Set<User> getMembers(DateTime when) {
        return getMembers();
    }

    @Override
    public boolean isMember(User user) {
        return pt.ist.messaging.domain.legacy.SenderGroup.getInstance().isMember(user);
    }

    @Override
    public boolean isMember(User user, DateTime when) {
        return isMember(user);
    }

    public static SenderGroup getInstance() {
        return select(SenderGroup.class, new Supplier<SenderGroup>() {

            @Override
            public SenderGroup get() {
                return new SenderGroup();
            }

        });
    }

    public static Set<Group> groupsForUser(User user) {
        final HashSet<Group> groups = new HashSet<Group>();
        if (pt.ist.messaging.domain.legacy.SenderGroup.getInstance().isMember(user)) {
            groups.add(getInstance());
        }
        return groups;
    }

}
