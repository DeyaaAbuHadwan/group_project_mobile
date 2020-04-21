package com.example.group_project_mobile.Salad;

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

public class saladType extends AppCompatActivity {

    ListView listView;
    Button returntomain;

    String title[] = {"Ceaser Salad", "Coleslaw Salad", "Greek Salad", "Pasta Salad"};
    String description[] = {"Price : 10$",
            "Price : 20$",
            "Price : 15$",
            "Price : 9$"};
    int images[] = {R.drawable.ceasersalad, R.drawable.coleslaw, R.drawable.greeksalad, R.drawable.pastasalad};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salad_type);

        listView=findViewById(R.id.saladlistviewtype);

        secondAdapter adapter = new secondAdapter(this, title, description, images);
        listView.setAdapter(adapter);
        returntomain=findViewById(R.id.returntomain);

        final SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(saladType.this, bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Ceaser Salad");
                    editor.commit();
                    Log.d(sharedpref.getString("select2",""), "select2");

                }
                if (position ==  1) {
                    Intent intent = new Intent(saladType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Coleslaw Salad");
                    editor.commit();
                }
                if (position ==  2) {
                    Intent intent = new Intent(saladType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Greek Salad");
                    editor.commit();
                }
                if (position ==  3) {
                    Intent intent = new Intent(saladType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Pasta Salad");
                    editor.commit();
                }
            }
        });

        returntomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(saladType.this, mainWindowScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });
    }






}
