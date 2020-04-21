package com.example.group_project_mobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.group_project_mobile.Adapter.secondAdapter;
import com.google.gson.Gson;

public class My_Order extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my__order);

        final SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();
        Gson gson = new Gson();
        String orderString = sharedpref.getString("order", "");
        Order [] order =gson.fromJson(orderString,Order[].class);
        String title[] = new String[order.length];
        String description[] = new String[order.length];
        int images[] = new int[order.length];
        for (int i=0 ; i < order.length;i++){
            Log.d(order[i].getName(), "...............................................");
            title[i]=order[i].Type;
            description[i]=order[i].name;
            images[i]=order[i].imgSource;
        }
        listView=findViewById(R.id.listOrder);

        secondAdapter adapter = new secondAdapter(this, title, description, images);
        listView.setAdapter(adapter);
    }
}
