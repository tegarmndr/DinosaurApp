package com.example.tugasprojectuas.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tugasprojectuas.R;

public class GridHomeCategoryAdapter extends BaseAdapter {
    Context context;
    String[] categoryName;
    int[] categoryImage;
    LayoutInflater inflater;

    public GridHomeCategoryAdapter(Context context, String[] categoryName, int[] categoryImage) {
        this.context = context;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
    }

    @Override
    public int getCount() {
        return categoryName.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_home_category, null);
        }

        ImageView imageViewCategory = convertView.findViewById(R.id.imageCategory);
        TextView textViewCategory = convertView.findViewById(R.id.textCategory);

        imageViewCategory.setImageResource(categoryImage[position]);
        textViewCategory.setText(categoryName[position]);

        return convertView;
    }
}
