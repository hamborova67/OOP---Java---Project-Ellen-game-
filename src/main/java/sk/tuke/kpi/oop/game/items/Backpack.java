package sk.tuke.kpi.oop.game.items;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.ActorContainer;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Backpack implements ActorContainer<Collectible> {
    private String name;
    private List<Collectible> items;
    private Backpack backpack;
    private int capacity;
    public Backpack(String name, int capacity){

    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    @Override
    public @NotNull List<Collectible> getContent() {
        return null;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void add(@NotNull Collectible actor) {
        if(items.size()>=capacity){
            throw new IllegalStateException();
        }
        items.add(actor);
    }

    @Override
    public void remove(@NotNull Collectible actor) {
        if(items.size()<=0){
            throw new IllegalStateException();
        }
        items.remove(actor);
    }

    @NotNull
    @Override
    public Iterator<Collectible> iterator() {
        for (Collectible item : backpack) {

            // pouzitie predmetu (item) z batohu
        }
        return null;
    }

    @Override
    public @Nullable Collectible peek() {
        return items.get(items.size());
    }

    @Override
    public void shift() {


    }
}
