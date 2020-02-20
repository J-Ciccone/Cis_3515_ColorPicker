package edu.temple.pickacolor;

import android.app.Activity;
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
        String colorSelected = getIntent().getExtras().getString("selected");
        View myView = findViewById(R.id.canvasLayout);
        myView.setBackgroundColor(Color.parseColor(colorSelected));
        canvasText.setText(colorSelected);
    }
}