package sk.tuke.kpi.oop.game;
import sk.tuke.kpi.gamelib.*;
import sk.tuke.kpi.gamelib.backends.lwjgl.LwjglBackend;
import sk.tuke.kpi.oop.game.actions.Move;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.scenarios.FirstSteps;
import sk.tuke.kpi.oop.game.scenarios.MissionImpossible;

public class Main {

    public static void main(String[] args) {

        WindowSetup windowSetup = new WindowSetup("Project Ellen", 800, 600);

        Game game = new GameApplication(windowSetup, new LwjglBackend());
        //Scene missionImpossible = new World("mission-impossible", "maps/mission-impossible.tmx", new MissionImpossible.Factory());
        //game.addScene(missionImpossible);
        //MissionImpossible MI = new MissionImpossible();
        //missionImpossible.addListener(MI);
        Scene scene = new World("world");
        game.addScene(scene);
        FirstSteps firstSteps = new FirstSteps();
        scene.addListener(firstSteps);



        game.start();

        game.getInput().onKeyPressed(Input.Key.ESCAPE, game::stop);
    }
}

