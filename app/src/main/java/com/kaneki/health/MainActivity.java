package com.kaneki.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private EditText E;
    private EditText height;
    private EditText weight;
    double bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // diabetic button

        b1= (Button)findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                E=(EditText)findViewById(R.id.health_et_3);
              double value = Double.parseDouble( E.getText().toString());
              if (value < 7)
                  setContentView(R.layout.fitdiabetes);
              else
                setContentView(R.layout.diabetes);
            }
        });


        // BMI

        b2= (Button)findViewById(R.id.button);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                height=(EditText)findViewById(R.id.health_et_1);
                weight=(EditText)findViewById(R.id.health_et_2);

                double v = Double.parseDouble( height.getText().toString());

                double z = Double.parseDouble( weight.getText().toString());
                if(v>=0&&z>=0) {

                    bmi = z / v;
                    if (bmi >= 25)
                        setContentView(R.layout.overweight);
                    else if (bmi <= 19)
                        setContentView(R.layout.underweight);
                    else if (bmi > 19 && bmi < 25)
                        setContentView(R.layout.fitbmi);

                }


            }
        });


    }

}
