package com.carol.data1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    EditText  nameText ;
    EditText specialityText ;
    EditText phoneText ;
    EditText emailText ;
    TextView drDisplay ;
    MyDBHandler dbHandler ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = (EditText) findViewById(R.id.nameText);
        specialityText = (EditText) findViewById(R.id.specialityText);
        phoneText = (EditText) findViewById(R.id.phoneText);
        emailText = (EditText) findViewById(R.id.emailText);
       drDisplay = (TextView) findViewById(R.id.drDisplay);

        dbHandler = new MyDBHandler(this, null, null, 1);
        try{
            printDatabase();
        } catch(Exception e)
        {
            Log.d("Log", "error" );
        }

    }

        // we pass 4 variables and the constuctor is expecting 4

    public void printDatabase() {
        //convert contents of database to string
        String dbString = dbHandler.databaseToString();

        drDisplay.setText(dbString);

    }

    public void addDoctor(View view){
        //create object of movies class passing the movie name we input and converting to string
        //Doctor doctor = new Doctor(nameText.getText().toString());
        Doctor doctor = new Doctor(nameText.getText().toString(), specialityText.getText().toString(),
                phoneText.getText().toString() , emailText.getText().toString());
        dbHandler.addDoctor(doctor);
        //print content everytime new movie is added
        printDatabase();


    }

    public void deleteDoctor(View view){
        // string to store input from user in teh edittext
        String inputMovie = nameText.getText().toString();

        // pass string to dbHandler deleteMovies() method
        dbHandler.deleteDoctor(inputMovie);
        //print database once deleted
        printDatabase();
    }

    public void updateDoctor(View view) {
        String inputname = nameText.getText().toString();
        String speciality = specialityText.getText().toString();
        String phone = phoneText.getText().toString();
        String email = emailText.getText().toString();
        dbHandler.editDoctor(inputname, speciality, phone, email );

        printDatabase();
    }

}
