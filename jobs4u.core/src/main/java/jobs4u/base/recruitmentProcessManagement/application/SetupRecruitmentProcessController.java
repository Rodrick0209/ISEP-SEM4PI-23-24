package jobs4u.base.recruitmentProcessManagement.application;

import eapli.framework.general.domain.model.Designation;
import jobs4u.base.recruitmentProcessManagement.domain.Phase;
import jobs4u.base.recruitmentProcessManagement.domain.RecruitmentProcess;
import jobs4u.base.recruitmentProcessManagement.utils.Phases;
import org.springframework.cglib.core.Local;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SetupRecruitmentProcessController {


    public void createRecruitmentProcess(Map<Phases, Map<String, LocalDate>> phaseDates)
    {
        List<Phase> list = new ArrayList<>();
        //TODO assegurar a autenticacao como customerManager
        for (Map.Entry<Phases, Map<String, LocalDate>> entry : phaseDates.entrySet()) {
            Phases phase = entry.getKey();
            Map<String, LocalDate> dates = entry.getValue();
            LocalDate startDate = dates.get("start");
            LocalDate endDate = dates.get("end");
            Phase newPhase = new Phase(Designation.valueOf(phase.name()), startDate, endDate);
            list.add(newPhase);
        }

        //TODO falta mostrar ao customerManager UI todas as suas jobOpenings e pedir para escolher uma que ainda nao tenha RecruitmentProcess
        //TODO atribuir o job reference da job opening escolhida ao recruitment process e depois associar os recruitment process ao job opening escolhido

       // return new RecruitmentProcess();
    }
}

