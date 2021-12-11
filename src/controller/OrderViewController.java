package controller;

import model.BestelFacade;
import model.domain.Beleg;
import model.domain.Broodje;

import java.util.*;

public class OrderViewController implements Observer {
    private final BestelFacade model;

    public OrderViewController(BestelFacade model) {
        this.model = model;
    }


    @Override
    public void update(Observable o, Object arg) {
        //TODO
    }

    public List<String> getBroodjeButtons() {

        Map<String, Broodje> broodjeMap = model.getBroodjes();
        List<String> broodjes = new ArrayList<>();
        for(Map.Entry<String, Broodje> b : broodjeMap.entrySet()) {
            if (b.getValue().getVoorraad() > 0) broodjes.add(b.getKey());
        }

        return broodjes;
    }

    public List<String> getBelegButtons() {
        Map<String, Beleg> belegMap = model.getBeleg();
        List<String> belegList = new ArrayList<>();
        for(Map.Entry<String, Beleg> b : belegMap.entrySet()) {
            if (b.getValue().getVoorraad() > 0) belegList.add(b.getKey());
        }

        return belegList;
    }
}
