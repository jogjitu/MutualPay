package com.catchblocker.mutualpay.backend.Entites;

import java.util.Date;
import java.util.UUID;

/**
 * Created by public on 12/28/2014.
 */
public class Notification {
    public UUID ID;
    public Date NotificationDate;
    public String Text;
    public int Initiator;
    public UUID GroupID;
}
