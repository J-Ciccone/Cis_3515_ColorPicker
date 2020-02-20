package edu.temple.pickacolor;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class PaletteActivity extends AppCompatActivity {
    ConstraintLayout layout;
    Spinner spinner;

    String[] colors = {"Blue", "Cyan", "Gray", "Green", "Teal", "Maroon", "Navy", "Magenta", "Lime", "Yellow"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this, colors);

        spinner = findViewById(R.id.spinner);
        spinner.setAdapter(colorAdapter);
        spinner.setSelection(0 , false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundColor(Color.WHITE);

                Intent myIntent = new Intent(getApplicationContext(), CanvasActivity.class);
                myIntent.putExtra("selected",parent.getItemAtPosition(position).toString());
                startActivity(myIntent);
               }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Intent i = new Intent(getApplicationContext(), CanvasActivity.class);
                startActivity(i);
            }
        });


    }
}
