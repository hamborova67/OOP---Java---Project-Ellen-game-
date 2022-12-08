package sk.tuke.kpi.oop.game.controllers;

import org.jetbrains.annotations.NotNull;
import sk.tuke.kpi.gamelib.Input;
import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.actions.Fire;
import sk.tuke.kpi.oop.game.characters.Armed;

public class ShooterController implements KeyboardListener {
    private Armed shooter;
    public ShooterController(Armed shooter){
        this.shooter =shooter;
    }

    @Override
    public void keyPressed(@NotNull Input.Key key) {
        KeyboardListener.super.keyPressed(key);
        if (shooter == null ){
            return;
        }
        if(shooter.getFirearm() == null) {
            return;
        }
        if (key== Input.Key.SPACE) {
            Fire<Armed> fire= new Fire<>();
            fire.setActor(shooter);
            fire.scheduleFor(shooter);
        }

    }
}
