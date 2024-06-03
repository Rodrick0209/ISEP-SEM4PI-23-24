package jobs4u.app.customer.console.checkNotifications.dto;

@SuppressWarnings("java:S1104")
public class NotificationDTO {



    public NotificationDTO(String localDate,String message){
        this.localDate=localDate;
        this.message=message;
    }

    public String localDate;

    public String message;



}
