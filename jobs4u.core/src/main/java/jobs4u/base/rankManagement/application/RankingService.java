package jobs4u.base.rankManagement.application;

import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.candidateManagement.application.repositories.CandidateRepository;
import jobs4u.base.candidateManagement.domain.Candidate;
import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.rankManagement.domain.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

public class RankingService {

    private final CandidateRepository candidateRepository = PersistenceContext.repositories().candidates();
    private final JobOpeningRepository jobOpeningRepository = PersistenceContext.repositories().jobOpenings();

    public Rank rankCandidates(JobOpening jobOpening, String emails) {
        List<EmailAddress> emailList = convertEmailsToList(emails);

        List<Candidate> candidates = new ArrayList<>();

        for (EmailAddress email : emailList) {

            Optional<Candidate> candidate = candidateRepository.findByEmail(email);

            if (candidate.isPresent()) {
                if(jobOpening.getCandidates().contains(candidate.get())){
                    candidates.add(candidate.get());
                }else{
                    throw new IllegalArgumentException("Candidate with email " + email + " not found in the job opening candidates list.");
                }

            }else {
                throw new IllegalArgumentException("Candidate with email " + email + " not found");
            }
        }

        int size = jobOpening.getRankSize();

        if (candidates.size() > size) {
            System.out.println("The number of candidates is greater than the rank size");
            return null;
        }else if (candidates.size() < size) {
            System.out.println("The number of candidates is less than the rank size. Please finish the rank as soon as possible.");
        }

        Rank rank=null;
        if (jobOpening.getRank().hasCandidate()) {
            rank = jobOpening.updateRankList(candidates);
        }else {
            rank = jobOpening.addRankList(candidates);
        }

        jobOpeningRepository.save(jobOpening);
        return rank;

    }



    public List<EmailAddress> convertEmailsToList(String emailString) {
         final String EMAIL_REGEX = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
         final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

        if (emailString == null || emailString.isEmpty()) {
            return new ArrayList<>();
        }


        // Split the string by commas and trim any extra whitespace from each email
        String[] emailsArray = emailString.split(",");
        List<EmailAddress> emailList = new ArrayList<>();
        List<String> invalidEmails = new ArrayList<>();

        for (String email : emailsArray) {
            String trimmedEmail = email.trim();
            if (EMAIL_PATTERN.matcher(trimmedEmail).matches()) {
                emailList.add(EmailAddress.valueOf(trimmedEmail));
            } else {
                invalidEmails.add(trimmedEmail);
            }
        }

        if (!invalidEmails.isEmpty()) {
            throw new IllegalArgumentException("The following emails are invalid: " + String.join(", ", invalidEmails));
        }

        return emailList;
    }


}
