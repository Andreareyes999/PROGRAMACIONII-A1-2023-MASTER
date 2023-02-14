package com.ugb.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView temp;
    RadioGroup rgp;
    Spinner spn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.btnCalcular);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                temp = (TextView) findViewById(R.id.txtNum1);
                double num1 = Double.parseDouble(temp.getText().toString());
                double num2 = 0;
                temp = (TextView) findViewById(R.id.txtNum2);
                try {
                    num2 = Double.parseDouble(temp.getText().toString());
                }catch (Exception e){
                    //manejador de error
                }
                double resp = 0;
                String msg = "Operacion invalida";

                spn = (Spinner)findViewById(R.id.spnOpciones);
                switch (spn.getSelectedItemPosition()){
                    case 0: //Suma
                        resp = num1 + num2;
                        msg = "La suma es: "+ resp;
                        break;
                    case 1://Resta
                        resp = num1 - num2;
                        msg = "La resta es: "+ resp;
                        break;
                    case 2://Multiplicacion
                        resp = num1 * num2;
                        msg = "La multiplicacion es: "+ resp;
                        break;
                    case 3://division
                        resp = num1 / num2;
                        msg = "La division es: "+ resp;
                        break;
                    case 4://exponente
                        resp = Math.pow(num1,num2);
                        msg = "La exponenciacion es: "+ resp;
                        break;
                    case 5://factorial
                        resp = 1;
                        for(int i=2; i<=num1; i++){
                            resp *= i;//resp = resp * i;
                        }
                        msg = "Factorial!: "+ resp;
                        break;
                }
                Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}