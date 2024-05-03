/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package jobs4u.base.jobApplications.application;

import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobApplications.domain.JobApplicationFile;
import jobs4u.base.jobApplications.repositories.JobApplicationRepository;
import jobs4u.base.jobOpeningsManagement.domain.JobOpening;
import jobs4u.base.jobOpeningsManagement.repositories.JobOpeningRepository;
import jobs4u.base.jobOpeningsManagement.utils.JobReference;
import jobs4u.base.utils.Path;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author mcn
 */
public class GetApplicationDataService {

    String filePath = "SCOMP/output/report.txt"; // Path to the report file
    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();

    private final JobApplicationRepository jobApplicationRepository =
            PersistenceContext.repositories().jobApplications();
    private final JobOpeningRepository jobOpeningRepository=
            PersistenceContext.repositories().jobOpenings();




    public List<JobOpening> getJobReferencesFromFileBot() {
        List<JobOpening> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("Job Reference: (\\w+-\\d+)"); // Regex to match the job reference line

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    String jobReferenceId = matcher.group(1);
                    JobReference jobReference = new JobReference(jobReferenceId);

                    if (jobOpeningRepository.containsOfIdentity(jobReference)) {
                        JobOpening jobOpening = jobOpeningRepository.ofIdentity(jobReference).get();
                        if (!result.contains(jobOpening)) {
                            if (jobOpening.canApplicationsBeaAdded()){
                                result.add(jobOpening);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    public List<String> getApplicationFromFileBot(String jobReference) {
        List<String> applications = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern pattern = Pattern.compile("Job Reference: (\\w+-\\d+)"); // Regex to match the job reference line
            Pattern patternApp = Pattern.compile("Candidate Number: (\\d+)"); // Regex to match the application number line
            boolean isJobReference = false;

            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    isJobReference = matcher.group(1).equals(jobReference);
                }
                Matcher matcherApp = patternApp.matcher(line);
                if (isJobReference && matcherApp.find()) {
                    String candidateNumber = matcherApp.group(1);
                    if (!jobApplicationRepository.containsOfIdentity(Long.valueOf(candidateNumber))){
                        applications.add(candidateNumber);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return applications;
    }


    public List<JobApplicationFile> getApplicationFiles(String jobReference, String candidateNumber) {
        List<JobApplicationFile> fileNames = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            Pattern patternJob = Pattern.compile("Job Reference: (\\w+-\\d+)"); // Regex to match the job reference line
            Pattern patternCandidate = Pattern.compile("Candidate Number: (\\d+)"); // Regex to match the candidate number line
            Pattern patternFile = Pattern.compile("(\\d+-\\w+-?\\w*?-?\\d*\\.txt)"); // Regex to match the file line
            boolean isJobReference = false;
            boolean isCandidateNumber = false;

            while ((line = br.readLine()) != null) {
                Matcher matcherJob = patternJob.matcher(line);
                Matcher matcherCandidate = patternCandidate.matcher(line);
                Matcher matcherFile = patternFile.matcher(line);

                if (matcherJob.find()) {
                    isJobReference = matcherJob.group(1).equals(jobReference);
                }
                if (isJobReference && matcherCandidate.find()) {
                    isCandidateNumber = matcherCandidate.group(1).equals(candidateNumber);
                }
                if (isJobReference && isCandidateNumber && matcherFile.find()) {


                    String fileName = matcherFile.group(1);
                    String dir = "SCOMP/output/"+jobReference+"/"+candidateNumber+"/"+fileName;
                    Path path = new Path(dir);

                    JobApplicationFile jobApplicationFile = new JobApplicationFile(fileName, path);

                    fileNames.add(jobApplicationFile);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileNames;
    }


    public Map<String,String> getCandidateInfo(List<JobApplicationFile> files){
        Map<String,String> result = new HashMap<>();
        for (JobApplicationFile file : files) {
            if (file.getName().contains("candidate-data")) {
                try (BufferedReader br = new BufferedReader(new FileReader(file.getPath().toString()))) {
                    result.put("id", br.readLine());
                    result.put("email", br.readLine());
                    result.put("name", br.readLine());
                    result.put("phoneNumber", br.readLine());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

}
