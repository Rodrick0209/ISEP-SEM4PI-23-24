package jobs4u.server.deamon.followup.server;

import eapli.framework.general.domain.model.EmailAddress;
import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.RequirementResult;
import jobs4u.base.notificationManagement.domain.Notification;
import jobs4u.base.notificationManagement.repositories.NotificationRepository;

import java.util.List;
import java.util.Properties;



public class EmailService {


    private final NotificationRepository notificationRepository;

    private static final String SMTP_HOST_NAME = "frodo.dei.isep.ipp.pt";
    private static final String SMTP_FROM = "no-reply@jobs4u.com";

    public EmailService() {
        this.notificationRepository = PersistenceContext.repositories().notifications();
    }

    private void sendEmail(String to, String subject, String body) {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", SMTP_HOST_NAME);



        Session session = Session.getDefaultInstance(properties, null);

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(SMTP_FROM));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendApprovedResultEmail(String to, String jobRef){

        String subject = "Jobs4U - Application Approved";

        String body = "Hello, hope this email finds you well,\n" +
                "We are pleased to inform you that your candidature for the following Job Opening has been approved: "
                + jobRef + "\nThe respective company will contact you soon.\n\n\n" +
                "Best regards,\n" +
                "Jobs4U Team";

        sendEmail(to, subject, body);

        Notification emailNotification = new Notification(EmailAddress.valueOf(to), "Jobs4U - Application Approved");
        notificationRepository.save(emailNotification);

    }

    public void sendRejectedResultEmail(String to, String jobRef) {

        String subject = "Jobs4U - Application Rejected";

        String body = "Hello, hope this email finds you well,\n" +
                "We regret to inform you that your candidature for the following Job Opening has been rejected." +
                jobRef + "\nWe wish you the best of luck in your future endeavours.\n\n\n" +
                "Best regards,\n" +
                "Jobs4U Team";

        sendEmail(to, subject, body);

        Notification emailNotification = new Notification(EmailAddress.valueOf(to), "Jobs4U - Application Rejected");
        notificationRepository.save(emailNotification);

    }

    public void sendResultsEmail(String to, String jobRef, List<Candidate> approved) {

        String subject = "Jobs4U -" + jobRef+" - Results Published";

        String approvedCandidates = "The following candidates were Approved: \n\n";
        for (Candidate candidate : approved) {
            approvedCandidates += "Name: " + candidate.name().toString() + "\nEmail Address: " + candidate.emailAddress().toString() + " \n\n";
        }

        String body = "Hello, hope this email finds you well,\n" +
                "The results for the job opening " + jobRef + " have been published.\n" +
                approvedCandidates + "\n\n\n" + "Best regards,\n" + "Jobs4U Team";

        sendEmail(to,subject,  body);

        Notification emailNotification = new Notification(EmailAddress.valueOf(to), subject);
        notificationRepository.save(emailNotification);
    }

    public void sendVerificationEmail(String to, String jobRef) {

        String subject = "Jobs4U - Application Verification";

        String body = "Hello, hope this email finds you well,\n" +
                "We are pleased to inform you that your candidature for the following Job Opening has been verified: "
                + jobRef + "\nThe recruitment process will continue as predicted.\n\n\n" +
                "Best regards,\n" +
                "Jobs4U Team";

        sendEmail(to, subject, body);

        Notification emailNotification = new Notification(EmailAddress.valueOf(to), "Jobs4U - Application Verified");
        notificationRepository.save(emailNotification);

    }

    public void sendFailedVerificationEmail(String to, String jobRef){

        String subject = "Jobs4U - Application Verification";

        String body = "Hello, hope this email finds you well,\n" +
                "We regret to inform you that your candidature for the following Job Opening failed the verification process: "
                + jobRef + "\nWe wish you the best of luck in your future endeavours.\n\n\n" +
                "Best regards,\n" +
                "Jobs4U Team";

        sendEmail(to, subject, body);

        Notification emailNotification = new Notification(EmailAddress.valueOf(to), "Jobs4U - Application Rejected");
        notificationRepository.save(emailNotification);



    }





}
