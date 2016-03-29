package de.peculator.material_color_picker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Explode;
import android.transition.Transition;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Activity reference needed for the style
        MaterialColorPickerHelper.init(this, getIntent(), getWindow(), R.style.AppTheme_NoActionBar);

        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MaterialColorPickerDialog mcpd = new MaterialColorPickerDialog();
                mcpd.show(getFragmentManager(), null);
            }
        });

        View test = findViewById(R.id.view);
        test.setBackgroundColor(MaterialColorPickerHelper.getPrimaryLightColor());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }
}
