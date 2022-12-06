package sk.tuke.kpi.oop.game.controllers;

import sk.tuke.kpi.gamelib.KeyboardListener;
import sk.tuke.kpi.oop.game.characters.Armed;

public class ShooterController implements KeyboardListener {
    private Armed shooter;
    public ShooterController(Armed shooter){
        this.shooter =shooter;
    }

}
