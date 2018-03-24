package com.example.root.bodymassindex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class BMI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        final Button button_calc = (Button) findViewById(R.id.button_calc);
        final EditText field_weight = (EditText) findViewById(R.id.field_weight);
        final EditText field_height = (EditText) findViewById(R.id.field_height);
        final TextView view_result = (TextView) findViewById(R.id.view_result);
        final TextView view_msg = (TextView) findViewById(R.id.view_msg);
        final TextView txt_msg = (TextView) findViewById(R.id.txt_msg);

        button_calc.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v) {
                double weight;
                double height;
                double bmi;
                String msg = "";
                String msg1="";

                if (field_weight.getText().toString().equals("") || field_height.getText().toString().equals("")) {

                    Toast.makeText(getApplicationContext(), "No valid values!", Toast.LENGTH_LONG);


                } else {

                    weight = Double.parseDouble(field_weight.getText().toString());
                    height = Double.parseDouble(field_height.getText().toString());

                    height=height/100;

                    bmi = height * height;
                    bmi = weight / bmi;

                    view_result.setText(String.valueOf(bmi));

                    if (bmi < 18.5) {

                        msg = "UnderWeight :(";
                        msg1 = "    UNDERWEIGHT Symptoms\n" +
                                "Frequent Illness\n" +
                                "Feeling Cold or Tired\n" +
                                "Losing Hair\n" +
                                "Hormonal Issues\n" +
                                "Poor Physical Stamina";

                    } else if (bmi > 18.5 && bmi < 25) {

                        msg = "Normal :)";
                        msg1 = "YES \n" +
                                "YOU ARE FIT \n" +
                                "YOU ARE AWESOME \n";

                    } else if (bmi > 25) {

                        msg = "Overweight";
                        msg1 = "  OVER WEIGHT Symptoms \n" +
                                "The Not-So-Pretty Cheeks\n" +
                                "The Incredibly Expanding Waistline\n" +
                                "The Breathless Charm\n" +
                                "The Dreaded Marks\n" +
                                "The Not-So-Happy Feet";

                    }

                    view_msg.setText(msg);
                    txt_msg.setText(msg1);


                }

            }
        });


    }
}
