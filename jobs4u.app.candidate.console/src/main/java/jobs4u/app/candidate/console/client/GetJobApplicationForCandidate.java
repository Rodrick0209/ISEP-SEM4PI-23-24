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


import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.utils.ClientCode;
import jobs4u.server.deamon.followup.server.FollowUpRequest;


public class GetJobApplicationForCandidate extends FollowUpRequest {
	protected final static int DATA1_PREFIX = 4;
	protected final static int DATA2_PREFIX = DATA1_LEN_M * 256 + DATA1_LEN_L + 2;
	private static final int GET_APPLICATION_CANDIDATE = 11;


	EmailAddress emailAddress;


	public GetJobApplicationForCandidate(EmailAddress emailAddress) {
		super(null, null);
		this.emailAddress = emailAddress;
	}

	@Override
	public byte[] execute() {


		byte [] message =  new byte[4+ DATA1_LEN_L + DATA1_LEN_M * 256 + DATA2_LEN_L + DATA_LEN_M * 256];
		message[0] = VERSION;
		message[1] = GET_APPLICATION_CANDIDATE;
		message[2] = DATA1_LEN_L;
		message[3] = DATA1_LEN_M;


		message[DATA1_PREFIX - 2] = DATA2_LEN_L;
		message[DATA1_PREFIX - 1] = DATA_LEN_M;

		int clientlength = Math.min(emailAddress.toString().length(), DATA1_LEN_M * 256 + DATA1_LEN_L);

		System.arraycopy(emailAddress.toString().getBytes(), 0, message, DATA1_PREFIX, clientlength);


		return message;
	}

	protected String messageType() {
		return "GET_JOB_APPLICATION";
	}
}
