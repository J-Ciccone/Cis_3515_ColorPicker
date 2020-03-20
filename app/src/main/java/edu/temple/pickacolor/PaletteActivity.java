package edu.temple.pickacolor;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PaletteActivity extends AppCompatActivity implements PaletteFragment.OnColorSelectedListener  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] androidColors = getResources().getStringArray(R.array.colors_select);
        final String[] colorNames = getResources().getStringArray(R.array.color_names);

        PaletteFragment paletteFragment = PaletteFragment.newInstance(colorNames,androidColors);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main, paletteFragment)
                .commit();
    }

    @Override
    public void onColorSelected(int position) {

    }
}
