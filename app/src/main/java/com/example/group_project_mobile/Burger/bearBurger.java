package com.example.group_project_mobile.Burger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_project_mobile.Food;
import com.example.group_project_mobile.MainActivity;
import com.example.group_project_mobile.MainScreen.secondscreen;
import com.example.group_project_mobile.Order;
import com.example.group_project_mobile.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

public class bearBurger extends AppCompatActivity {
    Button back,save;
    ImageView image;
    TextView desc ;
    TextView title ;
    int imageResource ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String foodString = "";
        String select="";
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bear_burger);
        image = findViewById(R.id.imageburger);
        desc = findViewById(R.id.desc);
        title=findViewById(R.id.burgerText);
        save =findViewById(R.id.save);
        SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        Gson gson = new Gson();
        if (sharedpref.getString("select1","").equals("Burger")) {
             foodString = sharedpref.getString("burgersString", "");
             select = sharedpref.getString("select2", "");
        }
        else if (sharedpref.getString("select1","").equals("Broast")) {
            foodString = sharedpref.getString("broastsString", "");
            select = sharedpref.getString("select2", "");
        }else if (sharedpref.getString("select1","").equals("Crispy")) {
            foodString = sharedpref.getString("crispysString", "");
            select = sharedpref.getString("select2", "");
        }else if (sharedpref.getString("select1","").equals("Salad")) {
            foodString = sharedpref.getString("saladsString", "");
            select = sharedpref.getString("select2", "");
        }
         Food[] food = gson.fromJson(foodString,Food[].class);
        for(int i= 0 ; i<food.length;i++){
            if(food[i].getType().equals(select)){
                imageResource=food[i].getImage();
                image.setImageResource(food[i].getImage());
                desc.setText(food[i].getDescription());
                title.setText(select);
            }
        }


       save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
                final SharedPreferences.Editor editor = sharedpref.edit();
                Gson gson = new Gson();
                String type = sharedpref.getString("select1", "");
                String name = sharedpref.getString("select2", "");
                if(sharedpref.getString("order","empty").equals("empty")!= true){
                    String orderString = sharedpref.getString("order", "");
                    Order[] order =gson.fromJson(orderString,Order[].class);
                    order =addExtraElementToArray(order, new Order(type,name,imageResource));
                    for (int i=0 ; i < order.length;i++){
                        Log.d(order[i].getName(), "...............................................");
                    }
                    String ordersString=gson.toJson(order);
                    editor.putString("order",ordersString);
                    editor.commit();
                }else {
                    Order order[] ={ new Order(type,name,imageResource)};
                    String ordersString=gson.toJson(order);
                    editor.putString("order",ordersString);
                    editor.commit();
                    for (int i=0 ; i < order.length;i++){
                        Log.d(order[i].getName(), "...............................................");
                    }
                }
            }
        });
    }
    Order[] addExtraElementToArray(Order [] arr,Order order){
        Order [] arr2 = new Order[arr.length+1];
        for (int i=0 ; i<arr.length;i++)
            arr2[i]=arr[i];
        arr2[arr.length]=order;
        return  arr2;
    }
}
