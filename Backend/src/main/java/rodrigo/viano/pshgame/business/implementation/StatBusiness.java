package rodrigo.viano.pshgame.business.implementation;

import java.util.ArrayList;

import java.util.List;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rodrigo.viano.pshgame.business.IStatBusiness;
import rodrigo.viano.pshgame.business.exceptions.BusinessException;
import rodrigo.viano.pshgame.model.Player;
import rodrigo.viano.pshgame.model.RandomUser;
import rodrigo.viano.pshgame.model.Stat;
import rodrigo.viano.pshgame.persistence.StatRepository;

@Service
public class StatBusiness implements IStatBusiness {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private StatRepository statDao;

    //Public functions
    @Override
    public List<Stat> saveAll(List<Stat> stats) throws BusinessException {
        try {
            List<Stat> statResults = statDao.saveAll(stats);
            for (Stat stat : statResults) {
                log.info("Statistic saved successfully. ID: {} ", stat.getId());
            }
            return statResults;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(e);
        }
    }

    @Override
    public void generateStats(int quantity) throws BusinessException {

        List<Stat> stats = new ArrayList<>();
        Player player = new Player();
        Random r = new Random();
        int low = 0;
        int high = 100;
        int score = 0;
        try {
            JsonArray results = callRandomUser(quantity);
            for (JsonElement jsonElement : results) {
                score = r.nextInt(high - low) + low;
                player = buildPlayer(new Gson().fromJson(jsonElement, RandomUser.class));
                stats.add(buildStat(player,score));
            }
            saveAll(stats);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(e);
        }
    }

    // Private functions

    private JsonArray callRandomUser(int quantity) throws BusinessException{
        try {
            log.info("Calling randomuser API");
            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://randomuser.me/api/?results=" + quantity);
            request.addHeader("content-type", "application/json");
            HttpResponse response = httpClient.execute(request);
            String responseString = new BasicResponseHandler().handleResponse(response);
            JsonObject jsonObject = new Gson().fromJson(responseString, JsonObject.class);
            JsonArray results = jsonObject.get("results").getAsJsonArray();
            return results;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(e);
        }
    }

    private Player buildPlayer(RandomUser randomUser) {
        Player player = new Player();
        player.setImage(randomUser.getPicture().getLarge());
        player.setNickname(randomUser.getLogin().getUsername());
        return player;
    }

    private Stat buildStat(Player player, int score) {
        Stat stat = new Stat();
        stat.setCreationDateTime();
        stat.setScore(score);
        stat.setPlayer(player);
        return stat;
    }

   
}
