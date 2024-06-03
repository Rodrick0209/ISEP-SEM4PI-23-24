package jobs4u.base.notificationManagement.domain;

import eapli.framework.domain.model.ValueObject;
import eapli.framework.validations.Preconditions;
import jakarta.persistence.Embeddable;

@Embeddable
public class Message implements ValueObject {

    private String message;



    protected Message() {
        // for ORM
    }


    private Message(String message) {
        Preconditions.nonNull(message);
        this.message = message;
    }


    public static Message valueOf(String message) {
        return new Message(message);
    }


    public String toString(){
        return this.message;
    }









}
