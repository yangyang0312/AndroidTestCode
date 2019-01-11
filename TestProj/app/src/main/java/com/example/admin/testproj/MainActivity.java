package com.example.admin.testproj;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Array;
import java.util.Vector;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(getSupportActionBar() != null){
            getSupportActionBar().hide();//隐藏标题栏
        }
        setContentView(R.layout.activity_main);
        (findViewById(R.id.button)).setOnClickListener(this);
        (findViewById(R.id.button2)).setOnClickListener(this);
        (findViewById(R.id.button3)).setOnClickListener(this);
        (findViewById(R.id.button4)).setOnClickListener(this);
        (findViewById(R.id.button5)).setOnClickListener(this);;
        (findViewById(R.id.button6)).setOnClickListener(this);
        //(findViewById(R.id.button2)).setOnClickListener(new View.OnClickListener() {
        //    @Override
        //    public void onClick(View view) {
        //        Toast.makeText(MainActivity.this,"访问百度",Toast.LENGTH_LONG).show();
        //        Intent intent = new Intent(Intent.ACTION_VIEW);
        //        intent.setData(Uri.parse("tel:18792430347"));
        //        startActivity(intent);
        //    }
        //});
        //申请权限
        if(ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ||
           ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE,android.Manifest.permission.WRITE_EXTERNAL_STORAGE},3);
        }
        //遍历
        File dev = new File("/sdcard/DCIM");
        File[] files = dev.listFiles();
        if(files == null)
            Log.e("ERROR","ERROR");
        else {
            for (int i = 0; i < files.length; ++i) {
                Log.e("AAAAAAAAAAAAA", files[i].getAbsolutePath());
            }
        }
    }
    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.button:
                Log.e(TAG,((Button)view).getText().toString());
                Toast.makeText(MainActivity.this,"点击了按钮1",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,TestListViewActivity.class);
                intent.putExtra("data1","this is data 1");
                intent.putExtra("data2",1234);
                startActivity(intent);
                break;
            case R.id.button2:
                Log.e(TAG,((Button)view).getText().toString());
                //((ImageView)findViewById(R.id.imageView)).setImageResource(R.drawable.btn_satellite_position);
                //ProgressBar pro = (ProgressBar)findViewById(R.id.progressBar);
                //pro.setProgress(pro.getProgress() + 5);
                //pro = (ProgressBar)findViewById(R.id.progressBar2);
                //pro.setVisibility(pro.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                //一般的AlertDialog
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.heart)
                        .setTitle("警告")
                        .setMessage("确定删除吗？")
                        .setPositiveButton("确定",null)
                        .setNegativeButton("不确定",null)
                        .setNeutralButton("取消",null)
                        .setCancelable(false)//允许取消
                        .show();
                //AlertDialog自定义EditText
                final EditText edt = new EditText(MainActivity.this);
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.heart)
                        .setTitle("请输入")
                        .setView(edt)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"输入：" + edt.getText().toString(),Toast.LENGTH_LONG).show();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .show();
                //AlertDialog列表
                final String [] items = {"选项一","选项二","选项三","选项④"};
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.heart)
                        .setTitle("列表")
                        .setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"点击了：" + items[i],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", null)
                        .setNegativeButton("取消",null)
                        .show();
                //AlertDialog单选
                final int pos = 2;
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.heart)
                        .setTitle("单选")
                        .setSingleChoiceItems(items,pos,new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"点击了：" + items[i],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"选中：" + items[pos],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .show();
                //AlertDialog多选
                final boolean checkedItems [] = {false,true,true,false};
                new AlertDialog.Builder(MainActivity.this)
                        .setIcon(R.drawable.heart)
                        .setTitle("多选")
                        .setMultiChoiceItems(items, checkedItems, new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                                Toast.makeText(MainActivity.this,(b ? "选中：" : "未选中：") + items[i],Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String s = "选中：";
                                for(int j = 0;j < items.length;++j){//获取选中的选项
                                    if(checkedItems[j]){
                                        s = s + items[j] + "、";
                                    }
                                }
                                Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消",null)
                        .show();
                //AlertDialog自定义View
                final View login = View.inflate(MainActivity.this,R.layout.login,null);
                final AlertDialog dlg = new AlertDialog.Builder(MainActivity.this).setIcon(R.drawable.heart)
                        .setTitle("登录")
                        .setView(login)//加载自定义View
                        .create();//需要先create
                login.findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {//点击登录按钮
                        Toast.makeText(MainActivity.this,"用户名：" + ((EditText)login.findViewById(R.id.edtName)).getText().toString() + " 密码：" + ((EditText)login.findViewById(R.id.edtPwd)).getText().toString(),Toast.LENGTH_LONG).show();
                        dlg.dismiss();//login和dlg需要定义为final的
                    }
                });
                dlg.show();
                break;
            case R.id.button3:
                ProgressDialog.show(MainActivity.this, "正在处理一些事情，稍等一下", "正在加载", true,true, new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                }).show();
                final ProgressDialog progress = new ProgressDialog(MainActivity.this);
                progress.setTitle("正在加载");
                progress.setMessage("正在处理一些事情，稍等一下");
                progress.setCanceledOnTouchOutside(false);//在外边是否取消
                progress.setCancelable(true);//时候允许取消
                progress.setIcon(R.drawable.heart);
                progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                progress.setMax(500);
                progress.setButton(DialogInterface.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {//添加按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(MainActivity.this,"取消",Toast.LENGTH_SHORT).show();
                    }
                });
                progress.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (progress.getProgress() < progress.getMax()){
                                progress.incrementProgressBy(20);//更新界面的进度
                                Thread.sleep(1000);
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        progress.dismiss();
                    }
                }).start();
                break;
            case R.id.button4:
                startActivity(new Intent(MainActivity.this,testLayout.class));
                break;
            case R.id.button5:
                startActivity(new Intent(MainActivity.this,CustomList.class));
                break;
            case R.id.button6:
                startActivity(new Intent(MainActivity.this,Chart.class));
                break;
            default:
                break;
        }
    }
}
