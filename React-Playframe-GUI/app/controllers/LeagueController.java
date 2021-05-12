package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.Match;
import entities.SportsClub;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.mvc.Controller;

import play.mvc.Result;

import services.LeagueManagerService;
import utils.ApplicationUtil;

import java.util.List;


public class LeagueController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");

    public Result listSportsClubs() {
        List<SportsClub> result = LeagueManagerService.getInstance().getAllSportsCLub();
        logger.debug("In EmployeeController.listEmployees(), result is: {}",result.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));

    }
    public Result listSportsClubsByScore() {
        List<SportsClub> result = LeagueManagerService.getInstance().getAllSportsCLubByGoals();
        logger.debug("In EmployeeController.listEmployees(), result is: {}",result.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }

    public Result listSportsClubsByWins() {
        List<SportsClub> result = LeagueManagerService.getInstance().getAllSportsCLubByWins();
        logger.debug("In EmployeeController.listEmployees(), result is: {}",result.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }
    public Result listMatches() {
        List<Match> result = LeagueManagerService.getInstance().getAllMatches();
        logger.debug("In EmployeeController.listEmployees(), result is: {}",result.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }
    public Result generateMatch() {
        Match result = LeagueManagerService.getInstance().generateMatch();
        logger.debug("In EmployeeController.listEmployees(), result is: {}",result.toString());
        ObjectMapper mapper = new ObjectMapper();

        JsonNode jsonData = mapper.convertValue(result, JsonNode.class);
        return ok(ApplicationUtil.createResponse(jsonData, true));
    }

}