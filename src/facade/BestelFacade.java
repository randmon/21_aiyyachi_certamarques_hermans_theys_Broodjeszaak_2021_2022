package facade;


import model.database.BroodjesDB;
import model.domain.Broodje;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class BestelFacade extends Observable {
        public List<Broodje>  getBroodjesList() {
            List<Broodje> broodjes = new ArrayList<>();
            for (Broodje b : BroodjesDB.getInstance().getAll()){
                broodjes.add(b);
            }
            return broodjes;
        }

}
