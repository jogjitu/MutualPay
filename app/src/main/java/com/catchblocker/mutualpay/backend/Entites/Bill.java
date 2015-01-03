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
    private boolean IsSynchronized;

    public void Bill()
    {
        //ID = new UUID.fromString("");
        IsSynchronized = false;

    }

    public Date getBillDate() {return BillDate;}
    public void setBillDate(Date billDate) {this.BillDate = billDate;}

    public int getPaidByMember() {return PaidByMember;}
    public void setPaidByMember(int paidBy) {this.PaidByMember = paidBy;}

    public double getAmount() {return Amount;}
    public void setAmount(double amount) {this.Amount = amount;}

    public String getRemark() {return Remark;}
    public void setRemark(String remark) {this.Remark = remark;}

    public void setGroupID (UUID groupID){this.GroupID = groupID;}

}
