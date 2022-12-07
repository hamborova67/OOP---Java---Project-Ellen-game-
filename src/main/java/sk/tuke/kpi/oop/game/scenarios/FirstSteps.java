package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.GameApplication;
import sk.tuke.kpi.gamelib.Scene;
import sk.tuke.kpi.gamelib.SceneListener;
import sk.tuke.kpi.gamelib.actions.When;
import sk.tuke.kpi.oop.game.actions.Use;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.items.*;

public class FirstSteps implements SceneListener {

    private int zdravie;
    private Ripley ripley = new Ripley();



    @Override
    public void sceneInitialized(@NotNull Scene scene) {


        scene.addActor(ripley,0,0);
        MovableController mc = new MovableController(ripley);
        scene.getInput().registerListener(mc);
        //new Move(Direction.SOUTH, 1).scheduleFor(ripley);
        Energy energy = new Energy();
        scene.addActor(energy,10,10);

        Ammo ammo = new Ammo();
        scene.addActor(ammo, 100,0);

        zdravie = ripley.getEnergy();
        sceneUpdating(scene);

        //new Use<>(energy).scheduleFor(ripley);
        //new Use<>(ammo).scheduleFor(ripley);
        //zdravie = ripley.getEnergy();

        new When<>(
            () ->
                ripley.intersects(energy),
                new Use<>(energy)
        ).scheduleFor(ripley);


        Hammer hammer = new Hammer(3);
        Wrench wrench =new Wrench();
        FireExtinguisher fireExtinguisher = new FireExtinguisher();
        ripley.getBackpack().add(hammer);
        ripley.getBackpack().add(wrench);
        ripley.getBackpack().add(fireExtinguisher);
        ripley.getBackpack().shift();
        //System.out.println(ripley.getBackpack().getCapacity());



        sceneUpdating(scene);

    }

    @Override
    public void sceneUpdating(@NotNull Scene scene) {
        SceneListener.super.sceneUpdating(scene);
        //int windowHeight = scene.getGame().getWindowSetup().getHeight();
        //int yTextPos = windowHeight - GameApplication.STATUS_LINE_OFFSET;
       // scene.getGame().getOverlay().drawText("| Energy: "+ripley.getEnergy()+" | Ammo: "+ripley.getAmmo(), 100 , yTextPos);
        scene.getGame().pushActorContainer(ripley.getBackpack());
        ripley.showRipleyState();
        //scene.follow(ripley);
        //overlay.drawText(exception.getMessage(), x, y).showFor(2);
    }

}
