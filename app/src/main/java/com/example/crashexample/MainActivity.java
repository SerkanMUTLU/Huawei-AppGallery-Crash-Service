package com.example.crashexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.huawei.agconnect.crash.AGConnectCrash;

public class MainActivity extends AppCompatActivity implements Button.OnClickListener {

    Button btnNullException,btnDivideZeroExc,btnDivideInTry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAllComponents();

        enableAggCrashService();
    }

    private void setAllComponents(){

        btnNullException=findViewById(R.id.btnNullException);
        btnNullException.setOnClickListener(this);

        btnDivideZeroExc=findViewById(R.id.btnDivideByZero);
        btnDivideZeroExc.setOnClickListener(this);

        btnDivideInTry=findViewById(R.id.btnDivideWithTry);
        btnDivideZeroExc.setOnClickListener(this);

    }

    private void enableAggCrashService(){
        AGConnectCrash.getInstance().enableCrashCollection(true); // This line turns on crash service
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnDivideByZero:
                    int numberOne=2;
                    int numberTwo = 0;

                    System.out.println("Result : "+  numberOne / numberTwo);
                break;

            case R.id.btnNullException:
                int []sayi =null;
                System.out.println("First Index : "+sayi[0]);
                break;

            case R.id.btnDivideWithTry:
                int numOne=2;
                int numTwo = 0;
                try{
                    //Crash service doesn't catch !
                    System.out.println("Result : "+  numOne / numTwo);
                }catch (Exception exc){

                }
                break;

            default:
                break;
        }
    }
}
