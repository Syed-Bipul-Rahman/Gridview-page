package com.recyclerview.gridview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //public variables
    RecyclerView recyclerView;
ArrayList<DataModel> arrayList;
Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datas();
        //initialization mathod calling
        initall();

        recyclerView.setHasFixedSize(true);

        //gridlayout

        GridLayoutManager gridLayoutManager =new GridLayoutManager(this,2);
        gridLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(gridLayoutManager);

        //adapter
        adapter=new Adapter(this,arrayList);
        recyclerView.setAdapter(adapter);


    }

    private void datas() {
        arrayList =new ArrayList<DataModel>();
        arrayList.add(new DataModel("Mango",R.drawable.mango));
        arrayList.add(new DataModel("Banana",R.drawable.banana));
        arrayList.add(new DataModel("Orange",R.drawable.orange));
        arrayList.add(new DataModel("Tomato",R.drawable.tomato));
        arrayList.add(new DataModel("Grapes",R.drawable.grapes));
        arrayList.add(new DataModel("Lichi",R.drawable.lichi));
    }

    private void initall() {

        recyclerView=findViewById(R.id.recyclerview);


    }
}