package com.polidea.hierarchyviewerdemo;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;
import com.polidea.hierarchyviewer.HierarchyViewer;


public class MainActivity extends ActionBarActivity {

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AlertDialog.Builder(this)
                .setSingleChoiceItems(new CharSequence[]{"test1", "test2"}, 1, null)
                .setPositiveButton("ok", null)
                .setNegativeButton("Cancel", null)
                .create()
                .show();

        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Showing toast!", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
//        HierarchyViewer.start(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        HierarchyViewer.shouldStop(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_scrolling_lists) {
            startActivity(new Intent(this, ScrollingViewsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
