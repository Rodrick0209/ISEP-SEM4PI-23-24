/*
 * Copyright (c) 2013-2024 the original author or authors.
 *
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package jobs4u.app.candidate.console.client;

import jobs4u.app.customer.console.checkNotifications.dto.NotificationDTO;
import jobs4u.base.jobApplications.domain.JobApplication;
import jobs4u.base.jobApplications.domain.JobApplicationDTO;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Marshler/Unmarsheler for the CsvBookingProtocol. It is responsible for
 * marshling the data to create a proper network message and unmarshal the
 * network message to the proper DTO class
 *
 * @author Paulo Gandra de Sousa 2021.05.30
 */
/* package */ class MarshlerUnmarshler {
	protected final static int DATA1_PREFIX = 4;

	public Iterable<JobApplicationDTO> parseResponseMessageGetJobApplication(final byte[] response){
		List<JobApplicationDTO> list = new ArrayList<>();


		String jobReference="";
		String state="";
		String numApplicants= "";
		int count=0;
		StringBuilder sb1 = new StringBuilder();
		for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 200; i++) {
			if (response[i] != 0) {
				sb1.append((char) response[i]);

				if (response[i] == '\n'){
					String fieldValue = sb1.toString().trim();
					switch (count){
						case 0:
							jobReference=fieldValue;
							count++;
							break;
						case 1:
							state=fieldValue;
							count++;
							break;
						case 2:
							numApplicants=fieldValue;
							count++;
							break;
					}
					sb1 = new StringBuilder();
				}

				if (response[i] == '\t'){
					JobApplicationDTO jobApplicationDTO = new JobApplicationDTO();
					jobApplicationDTO.setJobOpeningReference(jobReference);
					jobApplicationDTO.setState(state);
					jobApplicationDTO.setNumApplicants(numApplicants);
					list.add(jobApplicationDTO);

					jobReference = "";
					state = "";
					numApplicants = "";
					count = 0;
					sb1 = new StringBuilder();

				}
		}


		}
		return list;
	}


	public String parseCustomerCode(final byte[] response){

		StringBuilder sb1 = new StringBuilder();
		for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 200; i++) {
			if (response[i] != 0) {
				sb1.append((char) response[i]);
			}
		}

		return sb1.toString();
	}


	public Iterable<NotificationDTO> parseResponseMessageGetNotificationsNotRead(final byte[] response) {
		List<NotificationDTO> list = new ArrayList<>();
		String date = "";
		String message = "";
		int count = 0;
		StringBuilder sb1 = new StringBuilder();

		for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 200; i++) {
			if (response[i] != 0) {
				sb1.append((char) response[i]);

				if (response[i] == '\n') {
					String fieldValue = sb1.toString().trim();
					switch (count) {
						case 0:
							date = fieldValue;

							count++;
							break;
						case 1:
							message = fieldValue;
							count++;
							break;

					}
					sb1 = new StringBuilder();

				}
				if (response[i] == '\t') {
					NotificationDTO notificationDTO = new NotificationDTO(date, message);
					list.add(notificationDTO);
					date = "";
					message = "";
					count = 0;
					sb1 = new StringBuilder();
				}
			}
		}

		return list;
	}

	public Iterable<NotificationDTO> parseResponseMessageGetNotificationsRead(final byte[] response) {
		List<NotificationDTO> list = new ArrayList<>();
		String date = "";
		String message = "";
		int count = 0;
		StringBuilder sb1 = new StringBuilder();

		for (int i = DATA1_PREFIX; i < DATA1_PREFIX + 200; i++) {
			if (response[i] != 0) {
				sb1.append((char) response[i]);

				if (response[i] == '\n') {
					String fieldValue = sb1.toString().trim();
					switch (count) {
						case 0:
							date = fieldValue;

							count++;
							break;
						case 1:
							message = fieldValue;
							count++;
							break;

					}
					sb1 = new StringBuilder();

				}
				if (response[i] == '\t') {
					NotificationDTO notificationDTO = new NotificationDTO(date, message);
					list.add(notificationDTO);
					date = "";
					message = "";
					count = 0;
					sb1 = new StringBuilder();
				}
			}
		}

		return list;
	}



	private JobOpeningDTO parseResponseMessageLineGetAvailableMeals(final String s) {
		final String[] tokens = s.split(",");
		return new JobOpeningDTO(tokens[0]);
	}

	private String removeDoubleQuotes(final String token) {
		return token.replace("\"", "").trim();
	}




}
