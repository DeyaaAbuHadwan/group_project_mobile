package com.example.group_project_mobile.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.group_project_mobile.R;

public class secondAdapter extends ArrayAdapter<String> {

    Context context;
    String rTitle[];
    String rDescription[];
    int rImgs[];
    public secondAdapter(Context c, String title[], String description[], int imgs[]) {
        super(c, R.layout.titlerow, R.id.textView1, title);
        this.context = c;
        this.rTitle = title;
        this.rDescription = description;
        this.rImgs = imgs;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = layoutInflater.inflate(R.layout.burgertyperow, parent, false);
        ImageView images = row.findViewById(R.id.image);
        TextView myTitle = row.findViewById(R.id.textView1);
        TextView myDescription = row.findViewById(R.id.textView2);
        images.setImageResource(rImgs[position]);
        myTitle.setText(rTitle[position]);
        myDescription.setText(rDescription[position]);
        return row;
    }

}
