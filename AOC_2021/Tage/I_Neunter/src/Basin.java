package Tage.I_Neunter.src;

import java.util.ArrayList;

public class Basin implements Comparable<Basin>{

    ArrayList <Coordinates> coordinates = new ArrayList<>();
    Coordinates base;

    public Basin (Coordinates base) {
        coordinates.add(base);
        this.base = base;
    }

    public Coordinates name() {
        return(base);
    }

    public void addCoordinate(Coordinates coordinate) {
        coordinates.add(coordinate);
    }

    public int size() {
        return(coordinates.size());
    }

    public ArrayList<Coordinates> coordinatesList() {
        return(coordinates);
    }

    public void filter () {
        ArrayList <Coordinates> list = new ArrayList<>();
        for (int i = 0; i < coordinates.size(); i++) {
            int compare = 0;
            for (int j = 0; j < list.size(); j++) {
                if (!list.get(j).compare(coordinates.get(i))) {
                    compare++;
                }
            }
            if (compare == list.size()) {
                list.add(coordinates.get(i));
            }
        }
        coordinates = list;
    }

    @Override
    public int compareTo(Basin o) {
        Basin basin = (Basin) o;
        if (basin.size() > this.size()){
            return(1);
        }else if (basin.size() < this.size()){
            return(-1);
        }
        return 0;
    }

    public boolean compareMe(Basin basin) {
        int compares = 0;
        for (int i = 0; i < coordinates.size(); i++) {
            ArrayList <Coordinates> list =  basin.coordinatesList();
            int comparesInner = 0;
            for (int j = 0; j < list.size(); j++) {
                if (!coordinates.get(i).compare(list.get(j))) comparesInner++;
            }
            if (comparesInner == list.size()) compares++;
        }
        if (compares == coordinates.size()) {       //Basins sind ungleich
            return(false);
        }else {
            return(true);
        }
    }
    
}
