package com.example.group_project_mobile.MainScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.group_project_mobile.Adapter.adapter;
import com.example.group_project_mobile.Broast.broastType;
import com.example.group_project_mobile.Burger.burgerType;
import com.example.group_project_mobile.Crispy.crispyType;
import com.example.group_project_mobile.My_Order;
import com.example.group_project_mobile.Order;
import com.example.group_project_mobile.R;
import com.example.group_project_mobile.Salad.saladType;
import com.google.gson.Gson;

public class mainWindowScreen extends AppCompatActivity {
    Animation animation;
    ListView listView;
    static
    String title[] = {"My Orders", "Crispy", "Salad", "Broast","Burger"};
    String description[] = {"click to show", "Crispy Description", "Salad Description", "Broast Description","Burger Description"};
    int images[] = {R.drawable.logo, R.drawable.crispy, R.drawable.salad, R.drawable.broast,R.drawable.burger};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_window_screen);
        animation= AnimationUtils.loadAnimation(this,R.anim.listviewanim);
        listView=findViewById(R.id.listOrder);
        adapter adapter = new adapter(this, title, description, images);
        listView.setAnimation(animation);
        listView.setAdapter(adapter);
        final SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();
        if(sharedpref.getString("order","empty").equals("empty")!= true) {
            Order[] order = {};
            Gson gson = new Gson();
            String ordersString = gson.toJson(order);
            editor.putString("order", ordersString);
            editor.commit();
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(mainWindowScreen.this, My_Order.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
                if (position ==  1) {
                    Intent intent = new Intent(mainWindowScreen.this, crispyType.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select1","Crispy");
                    editor.commit();
                    Log.d(sharedpref.getString("select1",""), "select1");


                }
                if (position ==  2) {
                    Intent intent = new Intent(mainWindowScreen.this, saladType.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select1","Salad");
                    editor.commit();
                    Log.d(sharedpref.getString("select1",""), "select1");

                }
                if (position ==  3) {
                    Intent intent = new Intent(mainWindowScreen.this, broastType.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select1","Broast");
                    editor.commit();
                    Log.d(sharedpref.getString("select1",""), "select1");

                }
                if (position ==  4) {
                    Intent intent = new Intent(mainWindowScreen.this, burgerType.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select1","Burger");
                    editor.commit();
                    Log.d(sharedpref.getString("select1",""), "select1");


                }

            }
        });













    }












}
