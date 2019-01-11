package com.example.admin.testproj;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CustomList extends AppCompatActivity {
    private ArrayList<Item> list = new ArrayList<Item>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);
        list.add(new Item(R.drawable.fruit0,"Item0"));
        list.add(new Item(R.drawable.fruit1,"Item1"));
        list.add(new Item(R.drawable.fruit2,"Item2"));
        list.add(new Item(R.drawable.fruit3,"Item3"));
        list.add(new Item(R.drawable.fruit4,"Item4"));
        list.add(new Item(R.drawable.fruit5,"Item5"));
        list.add(new Item(R.drawable.fruit6,"Item6"));
        list.add(new Item(R.drawable.fruit7,"Item7"));
        list.add(new Item(R.drawable.fruit8,"Item8"));
        list.add(new Item(R.drawable.fruit9,"Item9"));
        list.add(new Item(R.drawable.fruit10,"Item10"));
        list.add(new Item(R.drawable.fruit0,"Item11"));
        list.add(new Item(R.drawable.fruit1,"Item12"));
        list.add(new Item(R.drawable.fruit2,"Item13"));
        list.add(new Item(R.drawable.fruit3,"Item14"));
        list.add(new Item(R.drawable.fruit4,"Item15"));
        list.add(new Item(R.drawable.fruit5,"Item16"));
        list.add(new Item(R.drawable.fruit6,"Item17"));
        list.add(new Item(R.drawable.fruit7,"Item18"));
        list.add(new Item(R.drawable.fruit8,"Item19"));
        list.add(new Item(R.drawable.fruit9,"Item20"));
        list.add(new Item(R.drawable.fruit10,"Item21"));
        ItemAdapter adapter = new ItemAdapter(CustomList.this,R.layout.item,list);
        ListView cusList = (ListView)findViewById(R.id.cusList);
        cusList.setAdapter(adapter);
        //列表项点击事件
        cusList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(CustomList.this,"点击了:" + list.get(i).getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
