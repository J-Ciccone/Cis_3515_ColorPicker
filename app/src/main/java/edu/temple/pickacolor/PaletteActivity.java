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

public class PaletteActivity extends AppCompatActivity {
    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ColorAdapter colorAdapter = new ColorAdapter(PaletteActivity.this);
        spinner = findViewById(R.id.spinner);

        spinner.setAdapter(colorAdapter);
        spinner.setSelection(0 , false);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                TextView colorView = (TextView)view;
                Intent myIntent = new Intent(PaletteActivity.this, CanvasActivity.class);
                myIntent.putExtra("colorName", colorView.getText());
                myIntent.putExtra("colorValue", ((ColorDrawable)colorView.getBackground()).getColor());
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
