package sk.tuke.kpi.oop.game.items;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import sk.tuke.kpi.gamelib.ActorContainer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Backpack implements ActorContainer<Collectible> {
    private String name;
    private List<Collectible> items = new ArrayList<>();
    private Backpack backpack;
    private int capacity;
    private int count_items;
    private Collectible one_item;
    public Backpack(String name, int capacity){
            this.name = name;
            this.capacity = capacity;
            this.count_items = 0;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

    @Override
    public @NotNull List<Collectible> getContent() {
        return items;
    }

    @Override
    public int getSize() {
        return count_items;
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
        //System.out.println(items.get(items.size()-1));
        return items.get(items.size()-1);
    }

    @Override
    public void shift() {
        if(items.size()<=1){
            return;
        }
        one_item=items.get(items.size()-1);
        int from_zero =0;
        items.add(0,one_item);
        //System.out.println(items.size());
        items.remove(items.size()-1);
        //System.out.println(items.size());

    }
}
