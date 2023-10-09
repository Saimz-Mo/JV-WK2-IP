package ke.co.safaricom;

import ke.co.safaricom.models.Hero;
import ke.co.safaricom.models.Squad;
import ke.co.safaricom.services.HeroService;
import ke.co.safaricom.services.SquadService;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static spark.Spark.*;
public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {
        port(getHerokuAssignedPort());

        ProcessBuilder process = new ProcessBuilder();

        Integer port;

        if (process.environment().get("PORT") != null) {
            port = Integer.parseInt(process.environment().get("PORT"));
        }else {
            port = 4567;
        }
        port(port);

        staticFileLocation("/public/");

        //home route
        get("/", (request, response) -> {
            return modelAndView( new HashMap<>(), "index.hbs");
        }, new HandlebarsTemplateEngine());

        //hero route
        get("/hero", (request, response) -> {
            return modelAndView( new HashMap<>(), "hero.hbs");
        }, new HandlebarsTemplateEngine());

        //squad route
        get("/squad", (request, response) -> {
            return modelAndView( new HashMap<>(), "squad.hbs");
        }, new HandlebarsTemplateEngine());

        //post a new hero
        post("/hero/new", (request, response) -> {
            Map <String,Object> data = new HashMap<>();
            //get input from form
            String name = request.queryParams("hero");
            String age = request.queryParams("age");
            String specialPower = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            List<Hero>heroList=request.session().attribute("Heroes");
            //create hero instance from form data
            Hero hero = new Hero(name,age,specialPower,weakness);
            HeroService heroService=new HeroService();
            //Add hero to list
            heroService.addHero(heroList, hero);
            List <Hero> updatedList = heroService.getHeroList();
            request.session().attribute("Heroes", updatedList);
            System.out.println(updatedList);
            //add key-value data to map for displaying to the template
            data.put("Heroes", request.session().attribute("Heroes"));
            return new ModelAndView(data, "hero-new.hbs");
        }, new HandlebarsTemplateEngine());

        //get new heroes list template
        get("/hero/new", (request, response) -> {
            Map<String,Object>data=new HashMap<>();
            data.put("Heroes", request.session().attribute("yourHeroList"));
            return new ModelAndView( data, "hero-new.hbs");
        }, new HandlebarsTemplateEngine());

        //post new squad
        post("/squad/new", (request, response) -> {
            Map <String,Object> data = new HashMap<>();
            //get input from form
            String name = request.queryParams("squad");
            String maxSize = request.queryParams("size");
            String squadCause = request.queryParams("task");
            List <Squad> squadList = request.session().attribute("Squads");
            //create squad instance from form data
            Squad squad = new Squad(maxSize, name, squadCause);
            SquadService squadService=new SquadService();
            squadService.addSquad(squadList, squad);
            //Add squad to list
            List <Squad> updatedSquadList = squadService.getSquadList();
            request.session().attribute("Squads", updatedSquadList);
            System.out.println(updatedSquadList);
            //add key-value data to map for displaying to the template
            data.put("Squads", request.session().attribute("Squads"));
            return new ModelAndView(data, "squad-new.hbs");
        }, new HandlebarsTemplateEngine());

        //get new squads display template
        get("/squad/new", (request, response) -> {
            Map<String,Object>data=new HashMap<>();
            data.put("Squads", request.session().attribute("yourSquadList"));
            return new ModelAndView( data, "squad-new.hbs");
        }, new HandlebarsTemplateEngine());

    }
}

