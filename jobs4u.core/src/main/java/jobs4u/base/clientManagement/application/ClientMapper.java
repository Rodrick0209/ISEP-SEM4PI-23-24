package jobs4u.base.clientManagement.application;

import eapli.framework.general.domain.model.EmailAddress;
import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.clientManagement.domain.ClientDTO;

public class ClientMapper {

        public ClientDTO toDTO(Client client){
            ClientDTO dto = new ClientDTO();
            dto.clientCode = client.clientCode().toString();
            dto.name = client.name().toString();
            dto.address = client.address().toString();
            dto.customerManagerEmail = client.getCustomerManagerEmail().toString();
            return dto;
        }

        public Client toEntity(ClientDTO dto){
            return new Client(dto.clientCode, dto.name, dto.address, EmailAddress.valueOf(dto.customerManagerEmail));
        }
}
