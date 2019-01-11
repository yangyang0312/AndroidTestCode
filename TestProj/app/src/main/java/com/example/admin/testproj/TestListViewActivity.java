package com.example.admin.testproj;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimerTask;
import java.util.Timer;

public class TestListViewActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<String> data = new ArrayList<String>(Arrays.asList("Apple","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango","Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango"));
    private int itemNum = 0;
    private ArrayAdapter<String> adapter;
    ListView listView;
    //定时器
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg){
            switch (msg.what){
                case 0:
                    addNewItem();
                    break;
            }
        }
    };
    Timer timer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            Message msg = new Message();
            msg.what = 0;
            msg.obj = 0;
            handler.sendMessage(msg);
        }
    };
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();//隐藏标题栏
        }
        setContentView(R.layout.activity_test_list_view);
        Toast.makeText(TestListViewActivity.this,getIntent().getStringExtra("data1"),Toast.LENGTH_SHORT).show();
        Toast.makeText(TestListViewActivity.this,String.valueOf(getIntent().getIntExtra("data2",-1)),Toast.LENGTH_SHORT).show();
        setTitle("TestListView");
        adapter = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,data);
        listView =(ListView)findViewById(R.id.listView);
        listView.setAdapter(adapter);
        findViewById(R.id.Add).setOnClickListener(this);
        findViewById(R.id.Delete).setOnClickListener(this);
        findViewById(R.id.Return).setOnClickListener(this);
        listView.smoothScrollToPosition(data.size());
        //启动定时器
        timer.schedule(task,0,5000);
    }
    @Override
    public void onClick(View view){
        switch (view.getId()){
            case R.id.Add:
                addNewItem();//添加
                break;
            case R.id.Delete:
                removeFirstItem();//删除
                break;
            case R.id.Return:
                finish();//结束、返回
                break;
            default:
                break;
        }
    }
    private void addNewItem(){
        while (data.size() > 100){
            data.remove(0);
        }
        data.add("New Item " + String.valueOf(itemNum++));
        adapter.notifyDataSetChanged();
        listView.smoothScrollToPosition(data.size());
    }
    private void removeFirstItem(){
        if(data.size() > 0){
            data.remove(0);
            adapter.notifyDataSetChanged();
            listView.smoothScrollToPosition(0);
        }
    }

}