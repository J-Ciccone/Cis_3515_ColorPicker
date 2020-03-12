package edu.temple.pickacolor;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class CanvasActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas_layout);

        TextView canvasText = findViewById(R.id.canvasText);
        View canvasView = findViewById(R.id.canvasLayout);

        Intent intent = getIntent();

        String colorName = intent.getExtras().getString("colorName");
        int colorSelected = intent.getIntExtra("colorValue", Color.BLACK);


        canvasText.setText(colorName);
        canvasView.setBackgroundColor(colorSelected);


    }
}