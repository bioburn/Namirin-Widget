package com.example.araara;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AraAraService.class);
                Log.d("onclick","Service Start!");
                startService(intent);
                Toast.makeText(getApplicationContext(),"Service Started!",Toast.LENGTH_LONG).show();
            }
        });

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AraAraService.class);
                Log.d("onclick2", "service stop!");
                stopService(intent);
                Toast.makeText(getApplicationContext(),"Service Stopped!",Toast.LENGTH_LONG).show();
            }
        });
    }
}
