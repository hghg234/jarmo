/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * מייצג משבצת במטרציה הלוגית
 */





import java.util.ArrayList;

public class PlaceModel {

    private int value;// הערך במקום 
    private ArrayList<Location> Arr;
    private Location loc;

    public PlaceModel(int value, Location loc)
    {
        Arr = new ArrayList<>();
        this.value = value;
        this.loc = loc;

    }
     public PlaceModel(PlaceModel value, ArrayList<Location> Arr)
    {
        this.value =value.getValue();
        this.loc = value.getLocYesSvohim();
        Arr = null;

    }

    public PlaceModel(Location loc) 
    {
        Arr = new ArrayList<>();

        this.loc = loc;

    }

    public PlaceModel() {
        Arr = new ArrayList<>();
        loc = new Location();
    }

    PlaceModel(int value) {
        this.value = value;
        Arr = new ArrayList<>();
        loc = new Location();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ArrayList<Location> getPossiblePlaces() {
        return Arr;
    }

   

    public void setPossiblePlaces(ArrayList<Location> Arr) {
        this.Arr = Arr;
    }

    /**
     * מוסיף לרשימת המקמות החוקיים מקום
     *
     * @param row - מיקום השורה החוקי
     * @param col - מיקום העמודה החוקי
     */
    public void AddPossiblePlaces(int row, int col) {
        this.Arr.add(new Location(row, col));
    }

    public Location getLocNOSvohim() {
        Location tamp = loc;
        tamp.setRow(loc.getRow() - 1);
        return tamp;
    }

    public void setLocNOSvohim(Location loc) {
        loc.setRow(loc.getRow() + 1);
        this.loc = loc;
    }

    public Location getLocYesSvohim() {

        return loc;
    }

    public void setLocYesSvohim(Location loc) {

        this.loc = loc;
    }
     @Override
    public String toString()
    {
        return "PlaceModel{" + "value=" + value + ", loc=" + loc + '}';
    }
}
