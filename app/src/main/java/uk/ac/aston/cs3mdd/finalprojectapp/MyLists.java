package uk.ac.aston.cs3mdd.finalprojectapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyLists {

    List<ListItems> myListslist;

    public MyLists(List<ListItems> myListslist) {
        this.myListslist = myListslist;
    }

    public MyLists() {
        String[] startingNames = {"Donnington Weekend", "Weekend away", "Racing day"};
        String[] startingNames2 = {"Donnington_GP", "Brands Hatch", "Snetterton"};
        Integer[] startingNames3 = {2, 3, 1};
        String[] startingNames4 = {"hotel", "camping", "camping"};
        String[] startingNames5 = {"At track", "Mcdonalds", "At track"};
        String[] startingNames7 = {"Castle Donnington", "London", "Norwich"};


        this.myListslist = new ArrayList<>();
        Random rng = new Random();
        for (int i = 0; i <startingNames.length; i++){
            ListItems p = new ListItems(startingNames[i], startingNames2[i], startingNames3[i], startingNames4[i], startingNames5[i], startingNames7[i]);
            myListslist.add(p);
        }
    }

    public List<ListItems> getMyListslist() {
        return myListslist;
    }

    public void setMyListslist(List<ListItems> myListslist) {
        this.myListslist = myListslist;
    }


}
