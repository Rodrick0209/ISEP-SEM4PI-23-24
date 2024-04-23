package jobs4u.base.clientManagement.application;

import jobs4u.base.clientManagement.domain.Client;
import jobs4u.base.clientManagement.domain.ClientDTO;

public class ClientMapper {

        public ClientDTO toDTO(Client client){
            ClientDTO dto = new ClientDTO();
            dto.clientCode = client.clientCode().toString();
            dto.name = client.name().toString();
            dto.address = client.address().toString();
            return dto;
        }
}
