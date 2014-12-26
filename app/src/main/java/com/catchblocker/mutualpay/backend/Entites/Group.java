package com.catchblocker.mutualpay.backend.Entites;

import java.util.Currency;
import java.util.List;
import java.util.UUID;

/**
 * Created by Jitendra Jogeshwar on 12/26/2014.
 * This class represents Groups which are represent
 * for e.g. one group of room mates sharing expenses
 */
public class Group {

    public String groupName;
    public String currency;
    public List<Profile> GroupMembers;

    public UUID getGroupId() {
        return groupId;
    }

    public void setGroupId(UUID groupId) {
        this.groupId = groupId;
    }

    public UUID groupId;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<Profile> getGroupMembers() {
        return GroupMembers;
    }

    public void setGroupMembers(List<Profile> groupMembers) {
        GroupMembers = groupMembers;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
