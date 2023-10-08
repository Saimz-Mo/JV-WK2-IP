package ke.co.safaricom.services;

import ke.co.safaricom.models.Squad;

import java.util.ArrayList;
import java.util.List;

public class SquadService {
    private List<Squad> squadList = new ArrayList<>();

    public void addSquad( List <Squad> mySquad, Squad squad){
        if (mySquad != null){
            squadList = mySquad;
        } else {
            mySquad = new ArrayList<>();
        }
        squad.setId(squadList.size()+1);
        squadList.add(squad);
    }
    public List<Squad>getSquadList(){
        return squadList;
    }

}
