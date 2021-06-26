package rodrigo.viano.pshgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import rodrigo.viano.pshgame.business.IStatBusiness;
import rodrigo.viano.pshgame.business.exceptions.BusinessException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableScheduling
public class ScheduledEvents {
	private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IStatBusiness statService;
    
    @Scheduled(fixedDelayString = "${generate.new.stats}")
	public void purgeAuthTokens() {
		try {
			log.info("Generating new stats");
			statService.generateStats();
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
		}
	}

 }