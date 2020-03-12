package edu.temple.pickacolor;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;



public class ColorAdapter extends BaseAdapter {
    Context context;
    private String[] colorNames;
    private String[] colors;

    public ColorAdapter(Context context) {
        this.context = context;
        this.colorNames = context.getResources().getStringArray(R.array.color_names);
        this.colors = context.getResources().getStringArray(R.array.colors_select);
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colorNames[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        TextView textView;
        if (convertView instanceof TextView) {
            textView = (TextView) convertView;
        } else {
            textView = new TextView(context);
        }

        textView.setText(colorNames[position]);
        textView.setBackgroundColor(Color.parseColor(colors[position]));

        return textView;
    }
}