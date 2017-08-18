package com.carol.data1;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        TextView headerText;
        Button btnToProfile;
        final Button btnToDoctor;


        headerText = (TextView) findViewById(R.id.headerText);
        btnToProfile = (Button) findViewById(R.id.btnToProfile);
        btnToDoctor = (Button) findViewById(R.id.btnToDoctor);

        btnToProfile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(Main3Activity.this, Main2Activity.class);
                startActivity(intent);

                btnToDoctor.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    public void changeTheme(View view) {


        constraintLayout = (ConstraintLayout) findViewById(R.id.main3);
        constraintLayout.setBackgroundColor(Color.GRAY);

    }


}



