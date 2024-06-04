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
package jobs4u.server.deamon.followup.server;


import jobs4u.base.clientManagement.application.repositories.ClientRepository;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.infrastructure.persistence.PersistenceContext;

import static jobs4u.server.deamon.followup.server.JobOpeningRequest.DATA1_PREFIX;


public class CustomerRequest extends FollowUpRequest {
	private final String email;

	String code;


	public CustomerRequest(String email) {
		super(null, null);
        this.email = email;
	}

	@Override
	public byte[] execute() {

		byte [] message =  new byte[4+ DATA1_LEN_L + DATA1_LEN_M * 256 + DATA2_LEN_L + DATA_LEN_M * 256];
		message[0] = VERSION;
		message[1] = GET_CUSTOMER;
		message[2] = DATA1_LEN_L;
		message[3] = DATA1_LEN_M;

		message[DATA1_PREFIX - 2] = DATA2_LEN_L;
		message[DATA1_PREFIX - 1] = DATA_LEN_M;

		int clientlength = Math.min(email.length(), DATA1_LEN_M * 256 + DATA1_LEN_L);


		System.arraycopy(email.getBytes(), 0, message, DATA1_PREFIX, clientlength);

		return message;
	}

	protected String messageType() {
		return "GET_CUSTOMER";
	}
}
