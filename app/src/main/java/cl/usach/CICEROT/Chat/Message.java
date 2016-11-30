package cl.usach.CICEROT.Chat;

import java.util.Date;

/**
 * Created by Ian on 30-11-2016.
 */
public class Message {
    private String mtext;
    private String mSender;
    private Date mDate;

    public Date getmDate(){
        return mDate;
    }

    public void setmDate(Date mDate){
        this.mDate = mDate;
    }

    public String getmSender(){
        return mSender;
    }

    public void setmSender(String mSender){
        this.mSender=mSender;
    }

    public String getMtext(){
        return mtext;
    }
    public void setMtext(String mtext){
        this.mtext=mtext;
    }
}
