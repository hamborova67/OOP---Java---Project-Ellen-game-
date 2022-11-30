package sk.tuke.kpi.oop.game;
import sk.tuke.kpi.gamelib.*;
import sk.tuke.kpi.gamelib.backends.lwjgl.LwjglBackend;
import sk.tuke.kpi.oop.game.actions.Move;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.scenarios.FirstSteps;

public class Main {

    public static void main(String[] args) {

        WindowSetup windowSetup = new WindowSetup("Project Ellen", 800, 600);

        Game game = new GameApplication(windowSetup, new LwjglBackend());


        Scene scene = new World("world");


        game.addScene(scene);
        FirstSteps firstSteps = new FirstSteps();


        Movable ripley = new Ripley();
        scene.addListener(firstSteps);
        // scene.addActor(ripley);
         ripley.startedMoving(Direction.WEST);
        Move x = new Move(Direction.EAST, 10);
        x.setActor(ripley);
        Direction direction = Direction.WEST;

        float an = direction.getAngle();
        System.out.println(an);


        game.start();
       // ripley.startedMoving(Direction.WEST);
        game.getInput().onKeyPressed(Input.Key.ESCAPE, game::stop);
    }
}
