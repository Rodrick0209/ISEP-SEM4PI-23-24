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
package jobs4u.base.infrastructure.bootstrapers;

import eapli.framework.general.domain.model.EmailAddress;
import eapli.framework.infrastructure.authz.application.AuthorizationService;
import eapli.framework.infrastructure.authz.application.AuthzRegistry;
import eapli.framework.infrastructure.authz.domain.model.*;
import eapli.framework.infrastructure.pubsub.impl.inprocess.service.InProcessPubSub;
import jobs4u.base.clientManagement.application.ClientMapper;
import jobs4u.base.clientManagement.application.RegisterClientController;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.clientManagement.domain.ClientDTO;
import jobs4u.base.infrastructure.persistence.PersistenceContext;
import jobs4u.base.jobOpeningsManagement.application.RegisterJobOpeningController;
import jobs4u.base.jobOpeningsManagement.utils.ContractType;
import jobs4u.base.jobOpeningsManagement.utils.WorkingMode;
import jobs4u.base.usermanagement.domain.Jobs4uRoles;
import eapli.framework.actions.Action;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * @author Paulo Gandra Sousa
 */
public class MasterUsersBootstrapper extends UsersBootstrapperBase implements Action {


    final RegisterJobOpeningController jobOpeningController = new RegisterJobOpeningController(PersistenceContext.repositories().jobOpenings(),
            PersistenceContext.repositories().clients(), AuthzRegistry.authorizationService());

    final RegisterClientController clientController = new RegisterClientController(PersistenceContext.repositories().clients(),
            AuthzRegistry.authorizationService(), InProcessPubSub.publisher());



    @Override
    public boolean execute() {

        Client client = clientController.registerClient("client1", "client1", "client@gmail.com",
                "919111222", "1234-123", "First",
                "Last", EmailAddress.valueOf("customermanager1@gmail.com"));

        Client client1 = clientController.registerClient("client2", "client2", "client2@gmail.com",
                "919112222", "1224-123", "Second",
                "Last", EmailAddress.valueOf("customermanager@gmail.com"));

        Client client2 = clientController.registerClient("uio1", "uio", "client@gmail.com",
                "919111222", "1234-123", "First",
                "Last", EmailAddress.valueOf("customermanager1@gmail.com"));

        registerAdmin("admin@gmail.com", TestDataConstants.PASSWORD1, "Admin", "Doe Admin",
                "admin@gmail.com");

       registerCustomerManager("customermanager@gmail.com", TestDataConstants.PASSWORD1, "Customer", "Doe CustomerManager",
               "customermanager@gmail.com");

        registerOperator("operator@gmail.com", TestDataConstants.PASSWORD1, "operator", "Doe operator",
                "operator@gmail.com");

        registerCandidate("candidate@gmail.com", TestDataConstants.PASSWORD1, "candidate", "Doe candidate",
                "candidate@gmail.com");

        registerCustomer("customer@gmail.com", TestDataConstants.PASSWORD1, "customer", "Doe customer",
                "customer@gmail.com");

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description", "Function", ContractType.FULL_TIME, client);


        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description", "Function", ContractType.FULL_TIME, client1);


        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description", "Function", ContractType.FULL_TIME, client1);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description1", "Function", ContractType.FULL_TIME, client);

        registerJobOpening(WorkingMode.REMOTE, "1", "1234-123",
                "Description1", "Function", ContractType.FULL_TIME, client2);

        return true;
    }

    /**
     *
     */
    private void registerAdmin(final String username, final String password, final String firstName,
            final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.ADMIN);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCustomerManager(final String username, final String password, final String firstName,
                               final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.CUSTOMER_MANAGER);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCandidate(final String username, final String password, final String firstName,
                                         final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.CANDIDATE);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerOperator(final String username, final String password, final String firstName,
                                   final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.OPERATOR);

        registerUser(username, password, firstName, lastName, email, roles);
    }

    private void registerCustomer(final String username, final String password, final String firstName,
                                  final String lastName, final String email) {
        final Set<Role> roles = new HashSet<>();
        roles.add(Jobs4uRoles.CUSTOMER);

        registerUser(username, password, firstName, lastName, email, roles);
    }



    public void registerJobOpening(WorkingMode workingMode
            , String nrVacancy
            , String address
            , String description
            , String function
            , ContractType contractType
            , Client client) {

        ClientDTO clientDTO = new ClientMapper().toDTO(client);

        jobOpeningController.registerJobOpening(workingMode, nrVacancy, address, description, function, contractType, clientDTO);
    }

}
