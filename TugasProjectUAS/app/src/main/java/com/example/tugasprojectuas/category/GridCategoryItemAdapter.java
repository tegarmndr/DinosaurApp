package com.example.tugasprojectuas.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.tugasprojectuas.R;

import java.util.List;

public class GridCategoryItemAdapter extends BaseAdapter {
    Context context;
    String[] dinosaurName;
    int[] dinosaur;
    String[] dinosaurEatingType;
    String selectedEatingType;
    String[] dinosaurDescription;
    int[] dinosaurSound;
    LayoutInflater inflater;

    public GridCategoryItemAdapter(Context context, String[] dinosaurName, int[] dinosaur, String[] dinosaurEatingType, String selectedEatingType, String[] dinosaurDescription, int[] dinosaurSound) {
        this.context = context;
        this.dinosaurName = dinosaurName;
        this.dinosaur = dinosaur;
        this.dinosaurEatingType = dinosaurEatingType;
        this.selectedEatingType = selectedEatingType;
        this.dinosaurDescription = dinosaurDescription;
        this.dinosaurSound = dinosaurSound;
    }

    @Override
    public int getCount() {
        return dinosaurName.length;
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

        if(inflater == null)
            inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.grid_category_item, null);
        }

        ImageView imageViewDinosaur = convertView.findViewById(R.id.imageDinosaur);
        TextView textViewDinosaur = convertView.findViewById(R.id.textDinosaur);

        imageViewDinosaur.setImageResource(dinosaur[position]);
        textViewDinosaur.setText(dinosaurName[position]);

        if (selectedEatingType != null && !selectedEatingType.isEmpty() && !selectedEatingType.equals("All")) {
            if (!dinosaurEatingType[position].equals(selectedEatingType)) {
                // Jika jenis pemakan tidak sesuai, set visibility menjadi GONE
                convertView.setVisibility(View.GONE);
            } else {
                convertView.setVisibility(View.VISIBLE);
            }
        } else {
            // Jika tidak ada jenis pemakan yang dipilih, tampilkan semua dinosaurus
            convertView.setVisibility(View.VISIBLE);
        }

        return convertView;
    }
}

