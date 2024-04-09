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
package jobs4u.base.jobs4uusermanagement.util;

import jobs4u.base.jobs4uusermanagement.domain.Jobs4uUser;
import eapli.framework.infrastructure.authz.domain.model.*;
import jobs4u.base.jobs4uusermanagement.domain.Jobs4uUserBuilder;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;

/**
 * @author Paulo Gandra Sousa 2024.03.12
 */
public class Jobs4uUserTestUtil {
	public static SystemUser dummyUser(final String username, final Role... roles) {
		final var userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
		return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
	}

	public static SystemUser getNewDummyUser() {
		return dummyUser("dummy", Jobs4uRoles.ADMIN);
	}

	public static Jobs4uUser getDummyJobs4uUser() {
		return getDummyJobs4uUser("DUMMY");
	}

	public static Jobs4uUser getDummyJobs4uUser(final String mecNumber) {
		return new Jobs4uUserBuilder().withMecanographicNumber(mecNumber)
				.withSystemUser(Jobs4uUserTestUtil.getNewDummyUser()).build();
	}
}
