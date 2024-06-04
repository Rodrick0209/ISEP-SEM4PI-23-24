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
package jobs4u.app.customer.console.jobOpenings.application;


import jobs4u.app.customer.console.followup.customer.client.FollowUpServerProxy;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;
import jobs4u.base.utils.ClientCode;

import java.io.IOException;

/**
 * @author Paulo Gandra de Sousa 2021.05.25
 */
public class GetJobOpeningsController {

	private final FollowUpServerProxy proxy = new FollowUpServerProxy();


	public Iterable<JobOpeningDTO> getJobOpeningsForCustomer(final ClientCode code)
			throws IOException{
		return proxy.getJobOpeningsForCustomer(code);
	}

	public String getCustomerCode(String email)
			throws IOException{

		return proxy.getCustomerCode(email);
	}
}
