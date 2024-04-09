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
package jobs4u.base.jobs4uusermanagement.domain;

import jobs4u.base.jobs4uusermanagement.util.Jobs4uUserTestUtil;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Nuno Bettencourt [NMB] on 03/04/16.
 */
class Jobs4uUserTest {

	private final String aMecanographicNumber = "abc";
	private final String anotherMecanographicNumber = "xyz";

	@Test
	void ensureJobs4uUserEqualsPassesForTheSameMecanographicNumber() throws Exception {

		final var aJobs4uUser = Jobs4uUserTestUtil.getDummyJobs4uUser();

		final var anotherJobs4uUser = Jobs4uUserTestUtil.getDummyJobs4uUser();

		final var expected = aJobs4uUser.equals(anotherJobs4uUser);

		assertTrue(expected);
	}

	@Test
	void ensureJobs4uUserEqualsFailsForDifferenteMecanographicNumber() throws Exception {
		final var aJobs4uUser = Jobs4uUserTestUtil.getDummyJobs4uUser(aMecanographicNumber);

		final var anotherJobs4uUser = Jobs4uUserTestUtil.getDummyJobs4uUser(anotherMecanographicNumber);

		final var expected = aJobs4uUser.equals(anotherJobs4uUser);

		assertFalse(expected);
	}

	@Test
	void ensureJobs4uUserEqualsAreTheSameForTheSameInstance() throws Exception {
		final var aJobs4uUser = new Jobs4uUser();

		assertEquals(aJobs4uUser, aJobs4uUser);
	}

	@Test
	void ensureJobs4uUserEqualsFailsForDifferenteObjectTypes() throws Exception {
		final var aJobs4uUser = Jobs4uUserTestUtil.getDummyJobs4uUser();

		@SuppressWarnings("unlikely-arg-type")
		final var expected = aJobs4uUser.equals(Jobs4uUserTestUtil.getNewDummyUser());

		assertFalse(expected);
	}

	@Test
	void ensureJobs4uUserIsTheSameAsItsInstance() throws Exception {
		final var aJobs4uUser = Jobs4uUserTestUtil.getDummyJobs4uUser();

		assertTrue(aJobs4uUser.sameAs(aJobs4uUser));
	}

	@Test
	void ensureTwoJobs4uUserWithDifferentMecanographicNumbersAreNotTheSame() throws Exception {
		final var aJobs4uUser = Jobs4uUserTestUtil.getDummyJobs4uUser(aMecanographicNumber);

		final var anotherJobs4uUser = Jobs4uUserTestUtil.getDummyJobs4uUser(anotherMecanographicNumber);

		assertFalse(aJobs4uUser.sameAs(anotherJobs4uUser));
	}
}
