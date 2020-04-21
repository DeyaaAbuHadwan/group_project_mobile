package com.example.group_project_mobile.Broast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.group_project_mobile.Burger.bearBurger;
import com.example.group_project_mobile.Burger.burgerType;
import com.example.group_project_mobile.R;
import com.example.group_project_mobile.MainScreen.mainWindowScreen;
import com.example.group_project_mobile.Adapter.secondAdapter;

public class broastType extends AppCompatActivity {
    ListView listView;
    Button returntomain;

    String title[] = {"Normal Broast", "Hot Broast", "With Bone", "Without Bone"};
    String description[] = {"Price : 10$",
            "Price : 4$",
            "Price : 12$",
            "Price : 10$"};
    int images[] = {R.drawable.normalbrost, R.drawable.hotbrost, R.drawable.withbone, R.drawable.withoutbone};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broast_type);


        listView=findViewById(R.id.broastlistviewtype);

        secondAdapter adapter = new secondAdapter(this, title, description, images);
        listView.setAdapter(adapter);
        returntomain=findViewById(R.id.returntomain);

        final SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(broastType.this, bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Normal Broast");
                    editor.commit();
                    Log.d(sharedpref.getString("select2",""), "select2");

                }
                if (position ==  1) {
                    Intent intent = new Intent(broastType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Hot Broast");
                    editor.commit();
                }
                if (position ==  2) {
                    Intent intent = new Intent(broastType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","With Bone");
                    editor.commit();
                }
                if (position ==  3) {
                    Intent intent = new Intent(broastType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Without Bone");
                    editor.commit();
                }
            }
        });


        returntomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(broastType.this, mainWindowScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
    }


}
