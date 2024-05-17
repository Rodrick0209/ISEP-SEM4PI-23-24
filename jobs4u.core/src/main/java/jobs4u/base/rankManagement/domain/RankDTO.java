package jobs4u.base.rankManagement.domain;

import eapli.framework.representations.dto.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@DTO
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RankDTO{
    private Long id;
    private int multiplier;
    private int rankSize;
    private String rank;

}
