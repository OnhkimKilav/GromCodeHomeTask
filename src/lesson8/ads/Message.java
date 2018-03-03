package lesson8.ads;

import java.util.Date;

/**
 * Created by Valik on 17.02.2018.
 */
public class Message extends BaseEntity{
    String message;
    User userFrom;
    User userTo;
    Date dateSent;
    Date dateRead;

    public Message(long id, String message, User userFrom, User userTo) {
        super(id);
        this.message = message;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.dateSent = new Date();
    }

    void setDateRead(){
        dateRead = new Date();
    }

    boolean isRead(){
        /*if(dateRead == null)
            return false;
        return true;*/

        return dateRead == null;
    }
}
