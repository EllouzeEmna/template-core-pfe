/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.csys.template.util;

import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
@EnableScheduling
@Service
public class JobScheduler {

    private final Logger log = LoggerFactory.getLogger(JobScheduler.class);

    @Autowired
    public JdbcTemplate jdbcTemplate;
    @Autowired
    CronErrorRepository cronErrorRepository;

    @Scheduled(cron = "00 05 12 * * *")
    public void myScheduler() {
        try {
            log.error("begin scheduler");
            String sql = "Begin tran\n"
                    + "insert into detail_bilan_detaille (numcpt,exercice,codeSoc,auto,code_rubrique,code_group,sens)\n"
                    + "Select FPlan.NumCpt,FPlan.Exercice,FPlan.CodeSoc,1 as auto,de.code_rubrique,de.code_group,de.sens\n"
                    + "From FPlan INNER JOIN detail_bilan_general de ON  FPlan.NumCpt like de.numCpt+'%'  and de.CodeSoc = FPlan.CodeSoc and de.exercice = FPlan.Exercice \n"
                    + "Where  FPlan.Auxiliaire=1 and de.type_compte='D' and  not exists(select numCpt from detail_bilan_detaille where FPlan.NumCpt= detail_bilan_detaille.numCpt and detail_bilan_detaille.CodeSoc = FPlan.CodeSoc and detail_bilan_detaille.exercice = FPlan.Exercice )\n"
                    + "insert into detail_bilan_detaille (numcpt,exercice,codeSoc,auto,code_rubrique,code_group,sens)\n"
                    + "Select FPlan.NumCpt,FPlan.Exercice,FPlan.CodeSoc,1 as auto,de.code_rubrique,de.code_group,de.sens\n"
                    + "From FPlan INNER JOIN detail_bilan_general de ON  FPlan.NumCpt=de.numCpt and de.CodeSoc = FPlan.CodeSoc and de.exercice = FPlan.Exercice \n"
                    + "Where  FPlan.Auxiliaire=1 and de.type_compte='G' and  not exists(select numCpt from detail_bilan_detaille where FPlan.NumCpt= detail_bilan_detaille.numCpt and detail_bilan_detaille.CodeSoc = FPlan.CodeSoc and detail_bilan_detaille.exercice = FPlan.Exercice )\n"
                    + "insert into detail_resultat_detaille (numcpt,exercice,codeSoc,auto,code_rubrique,code_group,sens)\n"
                    + "Select FPlan.NumCpt,FPlan.Exercice,FPlan.CodeSoc,1 as auto,de.code_rubrique,de.code_group,de.sens\n"
                    + "From FPlan INNER JOIN detail_resultat_general de ON  FPlan.NumCpt like de.numCpt+'%'  and de.CodeSoc = FPlan.CodeSoc and de.exercice = FPlan.Exercice \n"
                    + "Where  FPlan.Auxiliaire=1 and de.type_compte='D' and  not exists(select numCpt from detail_resultat_detaille where FPlan.NumCpt= detail_resultat_detaille.numCpt and detail_resultat_detaille.CodeSoc = FPlan.CodeSoc and detail_resultat_detaille.exercice = FPlan.Exercice )\n"
                    + "insert into detail_resultat_detaille (numcpt,exercice,codeSoc,auto,code_rubrique,code_group,sens)\n"
                    + "Select FPlan.NumCpt,FPlan.Exercice,FPlan.CodeSoc,1 as auto,de.code_rubrique,de.code_group,de.sens\n"
                    + "From FPlan INNER JOIN detail_resultat_general de ON  FPlan.NumCpt=de.numCpt  and de.CodeSoc = FPlan.CodeSoc and de.exercice = FPlan.Exercice \n"
                    + "Where  FPlan.Auxiliaire=1 and de.type_compte='G' and  not exists(select numCpt from detail_resultat_detaille where FPlan.NumCpt= detail_resultat_detaille.numCpt and detail_resultat_detaille.CodeSoc = FPlan.CodeSoc and detail_resultat_detaille.exercice = FPlan.Exercice )\n"
                    + "insert into detail_flux_detaille (numcpt,exercice,codeSoc,auto,code_rubrique,sens)\n"
                    + "Select FPlan.NumCpt,FPlan.Exercice,FPlan.CodeSoc,1 as auto,de.code_rubrique,de.sens\n"
                    + "From FPlan INNER JOIN detail_flux_general de ON  FPlan.NumCpt like de.numCpt+'%'  and de.CodeSoc = FPlan.CodeSoc and de.exercice = FPlan.Exercice \n"
                    + "Where  FPlan.Auxiliaire=1 and de.type_compte='D' and  not exists(select numCpt from detail_flux_detaille where FPlan.NumCpt= detail_flux_detaille.numCpt and detail_flux_detaille.CodeSoc = FPlan.CodeSoc and detail_flux_detaille.exercice = FPlan.Exercice )\n"
                    + "insert into detail_flux_detaille (numcpt,exercice,codeSoc,auto,code_rubrique,sens)\n"
                    + "Select FPlan.NumCpt,FPlan.Exercice,FPlan.CodeSoc,1 as auto,de.code_rubrique,de.sens\n"
                    + "From FPlan INNER JOIN detail_flux_general de ON  FPlan.NumCpt = de.numCpt  and de.CodeSoc = FPlan.CodeSoc and de.exercice = FPlan.Exercice \n"
                    + "Where  FPlan.Auxiliaire=1 and de.type_compte='G' and  not exists(select numCpt from detail_flux_detaille where FPlan.NumCpt= detail_flux_detaille.numCpt and detail_flux_detaille.CodeSoc = FPlan.CodeSoc and detail_flux_detaille.exercice = FPlan.Exercice )\n"
                    + "commit tran";
            log.error("end scheduler");
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            log.error(e.getMessage());
            CronError val = new CronError(e.getMessage(), LocalDateTime.now(), e.getCause().toString());
            cronErrorRepository.save(val);
        }

    }

}
