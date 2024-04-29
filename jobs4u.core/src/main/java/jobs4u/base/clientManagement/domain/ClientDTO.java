package jobs4u.base.clientManagement.domain;

import eapli.framework.general.domain.model.EmailAddress;

public class ClientDTO {

        public String clientCode;
        public String name;
        public String address;
        public String customerManagerEmail;


        public String name(){
            return name;
        }

}
