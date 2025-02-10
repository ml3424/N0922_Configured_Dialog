package com.example.n0922_configured_dialog;

/**
 * @author	Maya Leibovich mayaLeibovich3@gmail.com
 * @version	 1.2
 * @since	09/02/2024
 * Configured  Alert dialog task
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat$InspectionCompanion;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    final String[] colors = {"Red", "Green", "Blue"};
    AlertDialog.Builder adb;
    LinearLayout linlay;
    Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linlay = findViewById(R.id.linlay);

    }

    /**
     * onClick that changes the color to red or grenn ro blue
     *
     * @param view (button3)
     * @return none
     */
    public void chnageToBasic(View view) {
        int[] color = {0, 0, 0};
        adb = new AlertDialog.Builder(this);

        adb.setTitle("List of colors - one choice");
        adb.setItems(colors, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which] = 255;
                linlay.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.setCancelable(false);
        ad.show();
    }

    /**
     * onClick that changes the color the colors that have been chosen
     *
     * @param view (button2)
     * @return none
     */
    public void chnageToColor(View view) {
        int[] color = {0, 0, 0};
        adb = new AlertDialog.Builder(this);

        adb.setTitle("List of colors - multi choice");
        adb.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which] = 255;
                else if (color[which] == 255) color[which] = 0;
            }
        });

        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                linlay.setBackgroundColor(Color.rgb(color[0], color[1], color[2]));
                dialog.cancel();
            }
        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.setCancelable(false);
        ad.show();
    }

    /**
     * onClick that changes the color to white
     *
     * @param view (button3)
     * @return none
     */
    public void reset(View view) {
        linlay.setBackgroundColor(Color.rgb(255, 255, 255));
    }

    /**
     * onClick that makes a toast from the text the user entered
     *
     * @param view (button4)
     * @return none
     */
    public void toastTextET(View view) {

        adb = new AlertDialog.Builder(this);
        adb.setCancelable(false);

        adb.setTitle("EditText Widget");
        final EditText eT = new EditText(this);
        eT.setHint("Type text here");
        adb.setView(eT);
        adb.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text = eT.getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }

        });
        adb.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        AlertDialog ad = adb.create();
        ad.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * handles menu item selection
     */
    public boolean onOptionsItemSelected(MenuItem item) {
        String st = item.getTitle().toString();
        if(st.equals("Credits"))
        {
            Intent creditesIntent = new Intent(this,Credites.class);
            startActivity(creditesIntent);
        }
        return super.onOptionsItemSelected(item);
    }


}