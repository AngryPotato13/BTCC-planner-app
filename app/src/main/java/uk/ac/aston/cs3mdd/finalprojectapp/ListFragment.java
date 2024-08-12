package uk.ac.aston.cs3mdd.finalprojectapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

public class ListFragment extends Fragment {

    Button button_add, button_sortABC, button_sort123;
    ListView lv_friendsList;
    private ListAdaptor adaptor;
    private ListViewModel viewModel;
    MyLists myLists;
    SearchView searchView;
    List<ListItems> originalList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ListViewModel.class);

        viewModel.getMyListsLiveData().observe(getViewLifecycleOwner(), new Observer<List<ListItems>>() {
            @Override
            public void onChanged(List<ListItems> newList) {
                adaptor.setFilter(newList);
            }
        });

        button_sortABC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adaptor.sortAlphabetically();
            }
        });

        adaptor = new ListAdaptor(requireActivity(), viewModel.getMyLists());

        lv_friendsList.setAdapter(adaptor);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("originalList", new ArrayList<>(originalList));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        button_add = view.findViewById(R.id.button_add);
        button_sortABC = view.findViewById(R.id.button_sort_ABC);
        lv_friendsList = view.findViewById(R.id.Lv_ListOfNames);

        myLists = new MyLists();
        adaptor = new ListAdaptor(requireActivity(), myLists);

        originalList = new ArrayList<>(myLists.getMyListslist());
        lv_friendsList.setAdapter(adaptor);

        if (savedInstanceState != null) {
            originalList = savedInstanceState.getParcelableArrayList("originalList");
            adaptor.notifyDataSetChanged();
        }


        button_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), NewListForm.class);
                startActivityForResult(i, 1);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            String name = data.getStringExtra("name");
            String location = data.getStringExtra("location");
            int days = Integer.parseInt(data.getStringExtra("days"));
            String staying = data.getStringExtra("staying");
            String eating = data.getStringExtra("eating");
            String POI = data.getStringExtra("POI");

            ListItems newItem = new ListItems(name, location, days, staying, eating, POI);
            viewModel.addNewItem(newItem);
        }
    }

    private void filter(String query) {
        List<ListItems> filteredList = new ArrayList<>();

        if (TextUtils.isEmpty(query)) {
            filteredList.addAll(originalList);
        } else {
            for (ListItems listItem : originalList) {
                if (listItem.getName().toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(listItem);
                }
            }
        }

        adaptor.clear();
        adaptor.addAll(filteredList);
        adaptor.notifyDataSetChanged();
    }

}
