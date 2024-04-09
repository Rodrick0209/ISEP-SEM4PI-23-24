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
package jobs4u.base.jobs4uusermanagement.application;

import jobs4u.base.jobs4uusermanagement.domain.Jobs4uUser;
import jobs4u.base.jobs4uusermanagement.domain.MecanographicNumber;
import jobs4u.base.jobs4uusermanagement.repositories.ClientUserRepository;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.Username;

import java.util.Optional;

/**
 * @author mcn
 */
public class ClientUserService {

    private final AuthorizationService authz =
            AuthzRegistry.authorizationService();
    private final ClientUserRepository repo =
            PersistenceContext.repositories().clientUsers();

    public Optional<Jobs4uUser> findClientUserByMecNumber(
            final String mecNumber) {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER,
                Jobs4uRoles.ADMIN);
        return repo.ofIdentity(MecanographicNumber.valueOf(mecNumber));
    }

    public Optional<Jobs4uUser> findClientUserByUsername(
            final Username user) {
        authz.ensureAuthenticatedUserHasAnyOf(Jobs4uRoles.POWER_USER,
                Jobs4uRoles.ADMIN);
        return repo.findByUsername(user);
    }
}
