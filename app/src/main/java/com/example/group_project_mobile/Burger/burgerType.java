package com.example.group_project_mobile.Burger;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.group_project_mobile.R;
import com.example.group_project_mobile.MainScreen.mainWindowScreen;
import com.example.group_project_mobile.Adapter.secondAdapter;

public class burgerType extends AppCompatActivity {
    ListView listView;
    Button returntomain;

    String title[] = {"Black Burger", "Byron Burger", "Meatliquor Burger", "Bear Burger"};
    String description[] = {"great reviews from taste testers around the world, I’m confident you’ll be satisfied with this veggie burger recipe!",
            "Byron Hamburgers Limited, trading as Byron, is a British restaurant chain offering a casual dining service with a focus on hamburgers",
            "MeatLiquor is super fashionable at the moment. With the burger boom that has taken London by storm in the last year,",
            "They are easy to make, delicious, and just downright hit the spot. Serve them at sporting events or a relaxed evening at home."};
    int images[] = {R.drawable.blackburger, R.drawable.byronburger, R.drawable.meatliquorburger, R.drawable.bearburger};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_burger_type);
        listView=findViewById(R.id.burgerlistviewtype);

        secondAdapter adapter = new secondAdapter(this, title, description, images);
        listView.setAdapter(adapter);
        returntomain=findViewById(R.id.returntomain);
        final SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(burgerType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Black Burger");
                    editor.commit();
                    Log.d(sharedpref.getString("select2",""), "select2");

                }
                if (position ==  1) {
                    Intent intent = new Intent(burgerType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Byron Burger");
                    editor.commit();
                }
                if (position ==  2) {
                    Intent intent = new Intent(burgerType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Meatliquor Burger");
                    editor.commit();
                }
                if (position ==  3) {
                    Intent intent = new Intent(burgerType.this,bearBurger.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    editor.putString("select2","Bear Burger");
                    editor.commit();
                }
            }
        });


        returntomain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(burgerType.this, mainWindowScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

            }
        });





    }


}
