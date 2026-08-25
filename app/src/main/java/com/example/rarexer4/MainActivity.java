package com.example.rarexer4;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spin;
    TextView tv1;
    ImageView iv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spin = findViewById(R.id.spinner);
        tv1 = findViewById(R.id.textView);
        iv1 = findViewById(R.id.imageView);

        // Set custom adapter for white text
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item, // Use built-in layout
                getResources().getStringArray(R.array.versions) // Your string array
        ) {
            @NonNull

            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                TextView view = (TextView) super.getView(position, convertView, parent);
                view.setTextColor(Color.WHITE); // Selected item text color
                return view;
            }

            @Override
            public View getDropDownView(int position, View convertView, @NonNull ViewGroup parent) {
                TextView view = (TextView) super.getDropDownView(position, convertView, parent);
                view.setTextColor(Color.WHITE); // Dropdown items text color
                view.setBackgroundColor(Color.BLACK); // Optional: Dropdown background color
                return view;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(adapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                switch (position) {
                    case 0:
                        iv1.setImageResource(R.drawable.mercury);
                        tv1.setText(R.string.Mercury);
                        break;
                    case 1:
                        iv1.setImageResource(R.drawable.venus);
                        tv1.setText(R.string.Venus);
                        break;
                    case 2:
                        iv1.setImageResource(R.drawable.earth);
                        tv1.setText(R.string.Earth);
                        break;
                    case 3:
                        iv1.setImageResource(R.drawable.mars);
                        tv1.setText(R.string.Mars);
                        break;
                    case 4:
                        iv1.setImageResource(R.drawable.jupiter);
                        tv1.setText(R.string.Jupiter);
                        break;
                    case 5:
                        iv1.setImageResource(R.drawable.saturn);
                        tv1.setText(R.string.Saturn);
                        break;
                    case 6:
                        iv1.setImageResource(R.drawable.uranus);
                        tv1.setText(R.string.Uranus);
                        break;
                    case 7:
                        iv1.setImageResource(R.drawable.neptune);
                        tv1.setText(R.string.Neptune);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Optionally handle the case where no item is selected
            }
        });
    }
}
