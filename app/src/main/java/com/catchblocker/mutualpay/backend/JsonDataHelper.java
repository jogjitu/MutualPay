package com.catchblocker.mutualpay.backend;

import com.catchblocker.mutualpay.backend.Entites.Group;
import com.catchblocker.mutualpay.backend.Entites.Profile;

/**
 * Created by public on 12/28/2014.
 */
public class JsonDataHelper {

    public static String NotificationPathFormat = "Notifications/{0}.json";
    public static String RequestPathFormat = "Requests/{0}.json";
    public static String BillPathFormat = "Bills/{0}.json";

    public static String GetNotificationPathForJSON(Profile profile){
        return String.format(NotificationPathFormat, profile.getPhoneNumber());
    }

    public static String GetBillPathForGroup(Group group)
    {
        return String.format(BillPathFormat, group.getGroupId());
    }

    public static String GetMemberGroupRequestPath(Profile profile)
    {
        return String.format(RequestPathFormat, profile.getPhoneNumber());
    }


}
