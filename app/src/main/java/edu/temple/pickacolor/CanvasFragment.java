package edu.temple.pickacolor;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;


public class CanvasFragment extends Fragment {

    private static final String COLORS = "colors";
    private static final String POSITION = "position";
    private static final String COLOR_NAMES = "colorNames";

    private String[] colors;
    private int position;
    private String[] colorNames;

    public CanvasFragment() {

    }


    public static CanvasFragment newInstance(String[] colorSelections, String[] colorNames, int position) {
        CanvasFragment canvasFragment = new CanvasFragment();
        Bundle args = new Bundle();
        args.putStringArray(COLORS, colorSelections);
        args.putInt(POSITION, position);
        args.putStringArray(COLOR_NAMES,colorNames);
        canvasFragment.setArguments(args);
        return canvasFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colors = getArguments().getStringArray(COLORS);
            colorNames = getArguments().getStringArray(COLOR_NAMES);
            position = getArguments().getInt(POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.canvas_fragment_layout, container, false);
        FrameLayout frameLayout = view.findViewById(R.id.canvas);
        frameLayout.setBackgroundColor(Color.parseColor(colors[this.position]));
        TextView canvasText = view.findViewById(R.id.canvas_text);
        canvasText.setText(colorNames[position]);
        return view;
    }
}