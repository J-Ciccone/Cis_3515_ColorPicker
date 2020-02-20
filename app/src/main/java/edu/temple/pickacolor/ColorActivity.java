package edu.temple.pickacolor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

public class ColorActivity extends AppCompatActivity {
    ConstraintLayout layout;
        Spinner spinner;

        String[] colors = {"Blue", "Cyan", "Gray", "Green", "Teal", "Maroon", "Navy", "Lime", "Green", "Yellow"};
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            ColorAdapter colorAdapter = new ColorAdapter(ColorActivity.this, colors);

            spinner = findViewById(R.id.spinner);
            spinner.setAdapter(colorAdapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    view.setBackgroundColor(Color.WHITE);
                    findViewById(R.id.colorLayout).setBackgroundColor(Color.parseColor(colors[position]));
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });



    }
}
