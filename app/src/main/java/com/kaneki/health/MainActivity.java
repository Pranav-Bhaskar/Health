package com.kaneki.health;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button b1;
    private Button b2;
    private EditText E;
    private EditText height;
    private EditText weight;
    double bmi;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // diabetic button

        b1= (Button)findViewById(R.id.button3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                E = (EditText) findViewById(R.id.health_et_3);
                if (TextUtils.isEmpty(E.getText().toString()))
                {
                    Toast.makeText(getApplicationContext(), "Enter Sugar Level", Toast.LENGTH_LONG).show();
                }
                else {
                    double value = Double.parseDouble(E.getText().toString());
                    if (value < 100)
                        setContentView(R.layout.fitdiabetes);
                    else {
                        setContentView(R.layout.diabetes);
                        TextView textView = (TextView) findViewById(R.id.health_et_3);
                        textView.setMovementMethod(new ScrollingMovementMethod());

                    }

                }
            }
        });


        // BMI

        b2= (Button)findViewById(R.id.button);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                height=(EditText)findViewById(R.id.health_et_1);
                weight=(EditText)findViewById(R.id.health_et_2);
                if (TextUtils.isEmpty(height.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Enter Height", Toast.LENGTH_LONG).show();
                }
                else if(TextUtils.isEmpty(weight.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Enter Weight", Toast.LENGTH_LONG).show();
                }

                else{
                    double v = Double.parseDouble( height.getText().toString());

                    double z = Double.parseDouble( weight.getText().toString());
                    if(v>=0&&z>=0) {

                        bmi = z / (v*v) ;
                        if (bmi >= 25) {
                            setContentView(R.layout.overweight);
                            TextView ow_tv_1 =(TextView) findViewById(R.id.ow_tv_1) ;
                            ow_tv_1.setText("BMI: "+z);
                            TextView textView = (TextView) findViewById(R.id.ow_tv_2);
                            textView.setMovementMethod(new ScrollingMovementMethod());
                        }

                        else if (bmi <= 19){
                            setContentView(R.layout.underweight);
                            TextView uw_tv_1 =(TextView) findViewById(R.id.uw_tv_1) ;
                            uw_tv_1.setText("BMI: "+z);
                            TextView textView = (TextView) findViewById(R.id.uw_tv_2);
                            textView.setMovementMethod(new ScrollingMovementMethod());

                        }
                        else
                            setContentView(R.layout.fitbmi);

                    }
                }

            }
        });


    }

}
