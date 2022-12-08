package sk.tuke.kpi.oop.game.items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.ActorContainer;

import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Backpack implements ActorContainer<Collectible> {
    private String name;
    private List<Collectible> items = new ArrayList<>();

    private int capacity;


    public Backpack(String name, int capacity){
            this.name = name;
            this.capacity = capacity;

    }
    @Override
    public int getCapacity() {
        return capacity;
    }
    @Override
    public @NotNull String getName() {
        return name;
    }

    @Override
    public @NotNull List<Collectible> getContent() {
        List<Collectible> items1;
        items1 = List.copyOf(items);
        return items1;
    }

    @Override
    public int getSize() {
        return items.size();
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
        if(items.size()>0 || items!=null){
            items.remove(actor);

        }else {
            throw new IllegalStateException();
        }

    }

    @NotNull
    @Override
    public Iterator<Collectible> iterator() {
        return items.iterator();
    }

    @Override
    public @Nullable Collectible peek() {
        if(items.size()<1){
            return null;
        }
        //System.out.println(items.get(items.size()-1));
        return items.get(items.size()-1);
    }

    @Override
    public void shift() {
        if(items.size()<=1){
            return;
        }
        Collectible one_item=items.get(items.size()-1);

        items.add(0,one_item);
        //System.out.println(items.size());
        items.remove(items.size()-1);
        //System.out.println(items.size());

    }
}
