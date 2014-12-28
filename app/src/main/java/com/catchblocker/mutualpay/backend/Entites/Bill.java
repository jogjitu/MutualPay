package com.catchblocker.mutualpay.backend.Entites;

import java.util.Date;
import java.util.UUID;

/**
 * Created by public on 12/28/2014.
 */
public class Bill {
    private UUID ID;
    private Date BillDate;
    private double Amount;
    private int PaidByMember; //
    private String Remark;
    private String BillImagePath;
    private String PaymentMode;
    private UUID GroupID;

}
