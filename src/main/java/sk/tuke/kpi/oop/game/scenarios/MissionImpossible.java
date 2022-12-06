package sk.tuke.kpi.oop.game.scenarios;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.*;
import sk.tuke.kpi.oop.game.characters.Ripley;
import sk.tuke.kpi.oop.game.controllers.KeeperController;
import sk.tuke.kpi.oop.game.controllers.MovableController;
import sk.tuke.kpi.oop.game.items.Energy;

public class MissionImpossible implements SceneListener {
    private Ripley ripley = new Ripley();
    public static class Factory implements ActorFactory{


        @Override
        public @Nullable Actor create(@Nullable String type, @Nullable String name) {
            Energy energy = new Energy();
            Ripley ellen = new Ripley();
            return energy;
        }
    }

    @Override
    public void sceneInitialized(@NotNull Scene scene) {

        scene.addActor(ripley,45,55);
        MovableController mc = new MovableController(ripley);
        scene.getInput().registerListener(mc);
        //KeeperController kc = new KeeperController(ripley);
        //scene.getInput().registerListener(kc);
    }

    @Override
    public void sceneUpdating(@NotNull Scene scene) {
        SceneListener.super.sceneUpdating(scene);
        ripley.showRipleyState();
        scene.follow(ripley);
    }
}

