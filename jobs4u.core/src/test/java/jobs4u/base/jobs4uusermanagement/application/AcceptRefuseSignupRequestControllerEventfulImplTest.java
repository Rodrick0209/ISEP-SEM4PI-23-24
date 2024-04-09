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
package jobs4u.base.jobs4uusermanagement.application;

import jobs4u.base.jobs4uusermanagement.domain.SignupRequest;
import jobs4u.base.jobs4uusermanagement.domain.SignupRequestBuilder;
import jobs4u.base.jobs4uusermanagement.domain.events.SignupAcceptedEvent;
import jobs4u.base.jobs4uusermanagement.repositories.SignupRequestRepository;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.domain.model.NilPasswordPolicy;
import eapli.framework.infrastructure.authz.domain.model.PlainTextEncoder;
import eapli.framework.infrastructure.pubsub.EventPublisher;
import eapli.framework.time.util.CurrentTimeCalendars;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
 * @author Paulo Gandra de Sousa 13/05/2022
 */
class AcceptRefuseSignupRequestControllerEventfulImplTest {
    /*
    private AcceptRefuseSignupRequestControllerEventfullImpl subject;
    private SignupRequestRepository signupRequestsRepository;
    private AuthorizationService authorizationService;
    private EventPublisher dispatcher;

    @BeforeEach
    void setUp() {

        signupRequestsRepository = mock(SignupRequestRepository.class);
        authorizationService = mock(AuthorizationService.class);
        dispatcher = mock(EventPublisher.class);

        subject = new AcceptRefuseSignupRequestControllerEventfullImpl();


    }

    @Test
    void ensureSignupRequestIsAcceptedAndSignupEventIsPublished() {
        final SignupRequest req = new SignupRequestBuilder(new NilPasswordPolicy(), new PlainTextEncoder())
                .withData("user", "pass", "a@b.com", "1234567").withName("Mary", "Smith")
                .createdOn(CurrentTimeCalendars.now()).build();

        when(signupRequestsRepository.save(req)).thenReturn(req);

        final var ret = subject.acceptSignupRequest(req);

        assertNotNull(ret);
        assertTrue(ret.isAccepted());
        verify(dispatcher).publish(ArgumentMatchers.any(SignupAcceptedEvent.class));
    }

     */
}
