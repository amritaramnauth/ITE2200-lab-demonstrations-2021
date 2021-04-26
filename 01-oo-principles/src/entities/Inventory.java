package entities;

import java.util.ArrayList;

public class Inventory {

    private ArrayList<Furniture> furnitureList = new ArrayList<>();

    // add furniture
    public void addFurniture(Furniture furniture) {
        furnitureList.add(furniture);
    }

    // remove furniture
    public  void removeFurniture(Furniture furniture) {
        furnitureList.remove(furniture);
    }

    // get inventory count
    public int getInventoryCount() {
        return furnitureList.size();
    }


    // TODO: update furniture
    // TODO: get furniture

    @Override
    public String toString() {
        return "Inventory [furnitureList=" + furnitureList + "]";
    }

}
