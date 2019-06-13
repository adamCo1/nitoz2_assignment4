package Event;

import java.sql.Timestamp;

public class JoinRequest {
    private String sender;
    private String reciver;
    private String  eventTitle;
    private String timeSent;
    private String status;
    private String content;

    public JoinRequest(String sender, String reciver, String eventTitle , String currTime, String status, String content) {
        this.sender = sender;
        this.reciver = reciver;
        this.eventTitle= eventTitle;
        this.timeSent = currTime;
        this.status = status;
        this.content = content;
    }


    public String getContent() {
        return content;
    }

    public String getSender() {
        return sender;
    }

    public String getReciver() {
        return reciver;
    }

    public String getEvent() {
        return eventTitle;
    }

    public String getTimeSent() {
        return timeSent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
