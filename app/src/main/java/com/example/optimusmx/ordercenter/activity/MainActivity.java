package com.example.optimusmx.ordercenter.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.optimusmx.ordercenter.R;


public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private String[] arrString;
    private ListView lvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化数据
        initData();
        //初始化点击监听事件
        initOnclickListener();
    }

    /**
     * 初始化数据
     */
    private void initData(){
        lvMain= (ListView) findViewById(R.id.lv_main);
        initJsonData();
        myAdapter=new MyAdapter();
        lvMain.setAdapter(myAdapter);
    }
    /**
     * 初始点击事件
     */
    private void initOnclickListener(){
        //listview  Item的点击事件
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position)
                {
                    case 0:
                        Intent intent=new Intent(MainActivity.this,OneStyleActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(MainActivity.this,TwoStyleActivity.class);
                        startActivity(intent1);
                        break;
                    default:
                        Toast.makeText(MainActivity.this,"暂无可用页面！",Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    /**
     * ListviewAdapter初始化
     */
    private class MyAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return arrString.length;
        }

        @Override
        public Object getItem(int position) {
            return arrString[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView==null){
                convertView=View.inflate(MainActivity.this,R.layout.listview_item,null);
            }
            TextView tvListviewitemTitleconvert=(TextView) convertView.findViewById(R.id.tv_listviewitem_title);
            tvListviewitemTitleconvert.setText(arrString[position]);
            return convertView;
        }
    }
    /**
     * 初始化列表数据，正常由服务器返回的Json数据
     */
    private void initJsonData(){
        arrString= new String[]{"样式一","样式二"};
    }
}
