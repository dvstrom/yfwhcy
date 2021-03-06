package com.feiyu.smarthome;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class SystemActivity extends Activity {

	private ListView list;
	private SimpleAdapter adapter;
	private GridView gv;
	private int[] imageIds=new int[]
			{
				R.drawable.system_logout,R.drawable.system_gw_pwd,
				R.drawable.system_about
						};
	private String[] text={
			"注销","网关密码","关于"
	};
	private ImageView home=null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.system);    
        
        home=(ImageView)this.findViewById(R.id.home);
        home.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(SystemActivity.this, "fan", Toast.LENGTH_SHORT).show();
				Intent intent = new Intent (SystemActivity.this,HomeActivity.class);	
				startActivity(intent);
				SystemActivity.this.finish();
			}
		});
        
        gv = (GridView) findViewById(R.id.gridview);  
        
        //生成动态数组，并且转入数据   
        ArrayList<HashMap<String, Object>> lstImageItem = new ArrayList<HashMap<String, Object>>();  
        for(int i=0;i<imageIds.length;i++)  
        {  
          HashMap<String, Object> map = new HashMap<String, Object>();  
          map.put("ItemImage", imageIds[i]);//添加图像资源的ID   
          map.put("ItemText", text[i]);//按序号做ItemText   
          lstImageItem.add(map);  
        }  
        //生成适配器的ImageItem <====> 动态数组的元素，两者一一对应   
        SimpleAdapter saImageItems = new SimpleAdapter(this, //没什么解释   
                                                  lstImageItem,//数据来源    
                                                  R.layout.image_text,//night_item的XML实现   
                                                    
                                                  //动态数组与ImageItem对应的子项           
                                                  new String[] {"ItemImage","ItemText"},   
                                                    
                                                  //ImageItem的XML文件里面的一个ImageView,两个TextView ID   
                                                  new int[] {R.id.ItemImage,R.id.ItemText});  
        //添加并且显示   
        gv.setAdapter(saImageItems); 
        
        gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Toast.makeText(SystemActivity.this, "点击这个场景", Toast.LENGTH_SHORT).show();
				if(arg2==0)
				{
					Toast.makeText(SystemActivity.this, "点击这个场景2", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent (SystemActivity.this,Exit.class);	
					startActivity(intent);
				}
				if(arg2==1)
				{
					Toast.makeText(SystemActivity.this, "点击这个场景2", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent (SystemActivity.this,SetMessageActivity.class);	
					startActivity(intent);
				}
				if(arg2==2)
				{
					Toast.makeText(SystemActivity.this, "点击这个场景2", Toast.LENGTH_SHORT).show();
					Intent intent = new Intent (SystemActivity.this,AboutActivity.class);	
					startActivity(intent);
				}
			}
        });

    }

    
}
