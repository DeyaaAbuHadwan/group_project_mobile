package com.example.group_project_mobile.MainScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.group_project_mobile.Food;
import com.example.group_project_mobile.MainActivity;
import com.example.group_project_mobile.R;
import com.google.gson.Gson;

public class secondscreen extends AppCompatActivity {
    Animation animation,textanim,buttonanim;
    ImageView imageView;
    TextView textView;
    Button button,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondscreen);


        animation= AnimationUtils.loadAnimation(this,R.anim.anim);
        textanim= AnimationUtils.loadAnimation(this,R.anim.textanim);
        buttonanim= AnimationUtils.loadAnimation(this,R.anim.buttonanim);



        imageView =findViewById(R.id.imageView);
        textView =findViewById(R.id.textView);
        button =findViewById(R.id.button);
        button2=findViewById(R.id.button2);


        imageView.startAnimation(animation);
        textView.startAnimation(textanim);
        button.startAnimation(buttonanim);
        button2.setAnimation(buttonanim);

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondscreen.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(secondscreen.this,mainWindowScreen.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();
        String select = sharedpref.getString("select1","error");
        if(select.equals("Burger")){
            storeBurger();
        }
        else if(select.equals("Broast")){
            storeBroast();
        }
        else if(select.equals("Crispy")){
            storeCrispy();
        }
        else if(select.equals("Salad")){
            storeSalad();
        }
    }

    void storeBurger(){
        Food []foodBurger = {
                new Food("Black Burger",R.string.descBlackBurger,R.drawable.blackburger),
                new Food("Byron Burger",R.string.descByronBurger,R.drawable.byronburger),
                new Food("Meatliquor Burger",R.string.descMeatliquorBurger,R.drawable.meatliquorburger),
                new Food("Bear Burger",R.string.descBearBurger,R.drawable.bearburger),
        };

        SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();
        Gson gson = new Gson();
        String burgersString=gson.toJson(foodBurger);
        editor.putString("burgersString",burgersString);
        editor.commit();
    }

    void storeBroast(){
        Food []foodBroast = {
                new Food("Normal Broast",R.string.info,R.drawable.normalbrost),
                new Food("Hot Broast",R.string.info,R.drawable.hotbrost),
                new Food("With Bone",R.string.info,R.drawable.withbone),
                new Food("Without Bone",R.string.info,R.drawable.withoutbone),
        };

        SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();
        Gson gson = new Gson();
        String broastsString=gson.toJson(foodBroast);
        editor.putString("broastsString",broastsString);
        editor.commit();
    }

    void storeCrispy(){
        Food []foodBroast = {
                new Food("Crispy Burger",R.string.info,R.drawable.crispyburger),
                new Food("Crispy Salad",R.string.info,R.drawable.crispysalad),
                new Food("Crispy Shrimps",R.string.info,R.drawable.crispyshrimps),
                new Food("Crispy Wings",R.string.info,R.drawable.crispywings),
        };

        SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();
        Gson gson = new Gson();
        String crispysString=gson.toJson(foodBroast);
        editor.putString("crispysString",crispysString);
        editor.commit();
    }

    void storeSalad(){
        Food []foodBroast = {
                new Food("Ceaser Salad",R.string.info,R.drawable.ceasersalad),
                new Food("Coleslaw Salad",R.string.info,R.drawable.crispysalad),
                new Food("Greek Salad",R.string.info,R.drawable.greeksalad),
                new Food("Pasta Salad",R.string.info,R.drawable.pastasalad),
        };

        SharedPreferences sharedpref = getSharedPreferences("My_Shared_Preference", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();
        Gson gson = new Gson();
        String saladsString=gson.toJson(foodBroast);
        editor.putString("saladsString",saladsString);
        editor.commit();
    }

}
