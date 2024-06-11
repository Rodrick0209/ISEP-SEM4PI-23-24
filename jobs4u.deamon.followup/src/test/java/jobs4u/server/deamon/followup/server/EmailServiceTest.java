package jobs4u.server.deamon.followup.server;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class EmailServiceTest {

    @Test
    void sendApprovedResultEmail() {

        EmailService emailService = new EmailService();
        emailService.sendApprovedResultEmail("1221276@isep.ipp.pt", "jobRef");

    }
}