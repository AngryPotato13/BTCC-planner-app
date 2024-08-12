package uk.ac.aston.cs3mdd.finalprojectapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class ListViewModel extends ViewModel {

    private MutableLiveData<List<ListItems>> myListsLiveData = new MutableLiveData<>();

    public ListViewModel() {

        myListsLiveData.setValue(new MyLists().getMyListslist());
    }

    public LiveData<List<ListItems>> getMyListsLiveData() {
        return myListsLiveData;
    }

    public void addNewItem(ListItems newItem) {
        List<ListItems> currentList = myListsLiveData.getValue();
        if (currentList != null) {
            currentList.add(newItem);
            myListsLiveData.setValue(currentList);
        }
    }

    public MyLists getMyLists() {
        return new MyLists();
    }
}
