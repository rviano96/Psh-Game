package rodrigo.viano.pshgame;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import rodrigo.viano.pshgame.business.IStatBusiness;
import rodrigo.viano.pshgame.business.exceptions.BusinessException;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableScheduling
public class ScheduledEvents {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private IStatBusiness statService;
	Random r = new Random();
	int low = 0;
	int high = 10;
	int quantity;

	@Scheduled(fixedDelayString="${generate.new.stats}")

	public void purgeAuthTokens() {
		try {
			quantity = r.nextInt(high - low) + low;
			log.info("Generating {} new statistics.", quantity);
			statService.generateStats(quantity);
		} catch (BusinessException e) {
			log.error(e.getMessage(), e);
		}
	}

}