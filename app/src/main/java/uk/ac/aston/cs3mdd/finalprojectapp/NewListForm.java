package uk.ac.aston.cs3mdd.finalprojectapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class NewListForm extends AppCompatActivity {

    Button button_ok, button_cancel;
    EditText et_name, et_going, et_days, et_staying, et_eating, et_poi;
    private ListViewModel viewModel;
    private ArrayAdapter<Object> adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_list_form);
        viewModel = new ViewModelProvider(this).get(ListViewModel.class);

        button_ok = findViewById(R.id.button_ok);
        et_name = findViewById(R.id.tv_list_name);
        et_going = findViewById(R.id.tv_list_location);
        et_days = findViewById(R.id.tv_list_days);
        et_staying = findViewById(R.id.tv_list_staying);
        et_eating = findViewById(R.id.tv_list_eating);
        et_poi = findViewById(R.id.tv_list_amount_poi);


        button_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = et_name.getText().toString();
                String newLocation = et_going.getText().toString();
                String newDays = et_days.getText().toString();
                String newStaying = et_staying.getText().toString();
                String newEating = et_eating.getText().toString();
                String newPoi = et_poi.getText().toString();

                Intent intent = new Intent();
                intent.putExtra("name", newName);
                intent.putExtra("location", newLocation);
                intent.putExtra("days", newDays);
                intent.putExtra("staying", newStaying);
                intent.putExtra("eating", newEating);
                intent.putExtra("POI", newPoi);

                setResult(RESULT_OK, intent);
                finish();
            }
        });

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
            viewModel.getMyLists().getMyListslist().add(newItem);

            adaptor.notifyDataSetChanged();
        }
    }

}