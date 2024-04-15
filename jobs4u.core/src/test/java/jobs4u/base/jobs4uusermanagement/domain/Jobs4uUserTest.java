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


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import jobs4u.base.utils.ClientCode;
import jobs4u.base.utils.PhoneNumber;
import org.junit.Test;

import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.authz.domain.model.Role;
import eapli.framework.infrastructure.authz.domain.model.SystemUser;
import eapli.framework.infrastructure.authz.domain.model.SystemUserBuilder;
import org.springframework.security.core.parameters.P;

/**
 * Created by Nuno Bettencourt [NMB] on 03/04/16.
 */
public class Jobs4uUserTest {

	private final ClientCode aCLientCode = ClientCode.valueOf("abc");
	private final ClientCode anotherClientCode = ClientCode.valueOf("xyz");

	public static SystemUser dummyUser(final String username, final Role... roles) {
		// should we load from spring context?
		final SystemUserBuilder userBuilder = new SystemUserBuilder(new NilPasswordPolicy(), new PlainTextEncoder());
		return userBuilder.with(username, "duMMy1", "dummy", "dummy", "a@b.ro").withRoles(roles).build();
	}

	private SystemUser getNewDummyUser() {
		return dummyUser("dummy", Jobs4uRoles.ADMIN);
	}

	@Test
	public void ensureJobs4uUserEqualsPassesForTheSameMecanographicNumber() throws Exception {

		final Jobs4uUser aJobs4uUser = new Jobs4uUserBuilder().withClientCode(ClientCode.valueOf("DUMMY"))
				.withSystemUser(getNewDummyUser()).withPhoneNumber(PhoneNumber.valueOf("966280301")).build();

		final Jobs4uUser anotherJobs4uUser =  new Jobs4uUserBuilder().withClientCode(ClientCode.valueOf("DUMMY"))
				.withSystemUser(getNewDummyUser()).withPhoneNumber(PhoneNumber.valueOf("966280301")).build();

		final boolean expected = aJobs4uUser.equals(anotherJobs4uUser);

		assertTrue(expected);
	}

	@Test
	public void ensureJobs4uUserEqualsFailsForDifferenteMecanographicNumber() throws Exception {
		final Set<Role> roles = new HashSet<>();
		roles.add(Jobs4uRoles.ADMIN);

		final Jobs4uUser aJobs4uUser = new Jobs4uUserBuilder().withClientCode(aCLientCode)
				.withSystemUser(getNewDummyUser()).withPhoneNumber(PhoneNumber.valueOf("966280301")).build();

		final Jobs4uUser anotherJobs4uUser = new Jobs4uUserBuilder()
				.withClientCode(anotherClientCode).withSystemUser(getNewDummyUser()).withPhoneNumber(PhoneNumber.valueOf("966280301")).build();

		final boolean expected = aJobs4uUser.equals(anotherJobs4uUser);

		assertFalse(expected);
	}

	@Test
	public void ensureJobs4uUserEqualsAreTheSameForTheSameInstance() throws Exception {
		final Jobs4uUser aJobs4uUser = new Jobs4uUser();

		final boolean expected = aJobs4uUser.equals(aJobs4uUser);

		assertTrue(expected);
	}

	@Test
	public void ensureJobs4uUserEqualsFailsForDifferenteObjectTypes() throws Exception {
		final Set<Role> roles = new HashSet<>();
		roles.add(Jobs4uRoles.ADMIN);

		final Jobs4uUser aJobs4uUser = new Jobs4uUserBuilder().withClientCode(ClientCode.valueOf("DUMMY"))
				.withSystemUser(getNewDummyUser()).withPhoneNumber(PhoneNumber.valueOf("966280301")).build();

		@SuppressWarnings("unlikely-arg-type")
		final boolean expected = aJobs4uUser.equals(getNewDummyUser());

		assertFalse(expected);
	}

	@Test
	public void ensureJobs4uUserIsTheSameAsItsInstance() throws Exception {
		final Jobs4uUser aJobs4uUser = new Jobs4uUserBuilder().withClientCode(ClientCode.valueOf("DUMMY"))
				.withSystemUser(getNewDummyUser()).withPhoneNumber(PhoneNumber.valueOf("966280301")).build();

		final boolean expected = aJobs4uUser.sameAs(aJobs4uUser);

		assertTrue(expected);
	}

	@Test
	public void ensureTwoJobs4uUserWithDifferentClientCodesAreNotTheSame() throws Exception {
		final Set<Role> roles = new HashSet<>();
		roles.add(Jobs4uRoles.ADMIN);
		final Jobs4uUser aJobs4uUser = new Jobs4uUserBuilder().withClientCode(ClientCode.valueOf("DUMMY"))
				.withSystemUser(getNewDummyUser()).withPhoneNumber(PhoneNumber.valueOf("966280301")).build();

		final Jobs4uUser anotherJobs4uUser = new Jobs4uUserBuilder()
				.withClientCode(ClientCode.valueOf("DIFFERENT")).withSystemUser(getNewDummyUser()).withPhoneNumber(PhoneNumber.valueOf("966280301")).build();

		final boolean expected = aJobs4uUser.sameAs(anotherJobs4uUser);

		assertFalse(expected);
	}
}
