package edu.temple.pickacolor;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PaletteFragment.OnColorSelectedListener  {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String[] colors = getResources().getStringArray(R.array.colors_select);
        final String[] colorNames = getResources().getStringArray(R.array.color_names);

        PaletteFragment paletteFragment = PaletteFragment.newInstance(colorNames,colors);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_main, paletteFragment)
                .commit();
    }

    @Override
    public void onColorSelected(int position) {
        final String[] colors = getResources().getStringArray(R.array.colors_select);
        final String[] colorNames = getResources().getStringArray(R.array.color_names);
        CanvasFragment canvasFragment = CanvasFragment.newInstance(colors, colorNames ,position);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_main, canvasFragment)
                .addToBackStack(null)
                .commit();
    }
}
