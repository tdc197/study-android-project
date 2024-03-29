package com.example.x.gridviewandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private GridView gvStudents;
    private ArrayAdapter<String> mAdapter;
    private EditText txtInputCountryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControls();
        initEvents();
    }

    private void initEvents() {
        gvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, mAdapter.getItem(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initControls() {
        txtInputCountryName = findViewById(R.id.txtInputCountryName);
        gvStudents = findViewById(R.id.gvStudents);
        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, initData());
        gvStudents.setAdapter(mAdapter);
    }

    private ArrayList<String> initData() {
        ArrayList<String> data = new ArrayList<>();
        data.add("VietNam");
        data.add("Laos");
        data.add("Cambodia");
        data.add("Thailand");
        data.add("Indonesia");
        return data;
    }

    public void addNewCountry(View view) {
        mAdapter.add(txtInputCountryName.getText().toString());
    }
}
