package com.example.sianddesign.sharedpreferences_a1;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Shared Preferences Tabelle anlegen wenn nicht vorhanden oder darauf zugreifen
        // Eindeutiger Name app_name + "Prefs" - Privater Modus
        final SharedPreferences prefs = getSharedPreferences(R.string.app_name + "Prefs", Context.MODE_PRIVATE);

        // Editor für Einträge
        final SharedPreferences.Editor editor = prefs.edit();

        final TextView counterLabel = (TextView)findViewById(R.id.counterLabel);
        Button count = (Button)findViewById(R.id.btnCount);

        // Letzten Counterwert bei Appstart setzen Wert setzen
        counterLabel.setText("Zähler " + prefs.getInt("Counter", 0));

        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // aktuelle Zahl holen, wenn nicht vorhanden 0
                int counter = prefs.getInt("Counter", 0);

                // Zahl erhöhen
                counter++;

                // Zahl in Counter zurückschreiben
                editor.putInt("Counter", counter);
                editor.apply();

                // Zahl in TextView schreiben
                counterLabel.setText("Zähler: " + prefs.getInt("Counter", 0));

            }
        });

    }
}
