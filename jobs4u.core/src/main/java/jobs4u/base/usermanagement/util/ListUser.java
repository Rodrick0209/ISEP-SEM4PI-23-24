package jobs4u.base.usermanagement.util;

import eapli.framework.infrastructure.authz.domain.model.SystemUser;

import java.util.List;

public class ListUser {
    
    public static void ListUserToSelect(List<SystemUser> list, Iterable<SystemUser> iterable, int cont) {
        System.out.printf("%-6s%-30s%-30s%-30s%n", "Nº:", "Email", "Firstname", "Lastname");
        for (final SystemUser user : iterable) {
            list.add(user);
            System.out.printf("%-6d%-30s%-30s%-30s%n", cont, user.email(), user.name().firstName(),
                    user.name().lastName());
            cont++;
        }
    }
}
