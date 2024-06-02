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
package jobs4u.app.customer.console.followup.customer.client;

import jobs4u.base.jobOpeningsManagement.domain.JobOpeningDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Marshler/Unmarsheler for the CsvBookingProtocol. It is responsible for
 * marshling the data to create a proper network message and unmarshal the
 * network message to the proper DTO class
 *
 * @author Paulo Gandra de Sousa 2021.05.30
 */
/* package */ class MarshlerUnmarshler {

	public Iterable<JobOpeningDTO> parseResponseMessageGetJobOpenings(final byte[] responseBytes){

		byte data = responseBytes[2];
		System.out.println(data);

    final List<JobOpeningDTO> ret = new ArrayList<>();



    return ret;
}

	private JobOpeningDTO parseResponseMessageLineGetAvailableMeals(final String s) {
		final String[] tokens = s.split(",");
		return new JobOpeningDTO(tokens[0]);
	}

	private String removeDoubleQuotes(final String token) {
		return token.replace("\"", "").trim();
	}




}
