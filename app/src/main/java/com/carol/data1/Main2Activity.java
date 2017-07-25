package com.carol.data1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    EditText nameText;
    EditText dobText;
    EditText phText;
    EditText emText;
    EditText affectedText;
    EditText otherText;
    TextView profileText, tvdisplay;
    MyDBHandler dbHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        nameText = (EditText) findViewById(R.id.nameText);
        dobText = (EditText) findViewById(R.id.dobText);
        phText = (EditText) findViewById(R.id.phText);
        emText = (EditText) findViewById(R.id.emText);
        affectedText = (EditText) findViewById(R.id.affectedText);
        otherText = (EditText) findViewById(R.id.otherText);
        profileText = (TextView) findViewById(R.id.profileText);
        tvdisplay = (TextView) findViewById(R.id.tvdisplay);

        // we pass 4 variables and the constuctor is expecting 4
        dbHandler = new MyDBHandler(this, null, null, 1);
        printDatabase();

    }

    public void printDatabase() {
        //convert contents of database to string
        String dbString = dbHandler.displayProfile();

        tvdisplay.setText(dbString);

    }

    public void addProfile(View view){
        //create object of movies class passing the movie name we input and converting to string
        //Doctor doctor = new Doctor(nameText.getText().toString());
        Profile profile = new Profile(nameText.getText().toString(), dobText.getText().toString(),
                phText.getText().toString() , emText.getText().toString() ,affectedText.getText().toString(),
                otherText.getText().toString());
        dbHandler.addProfile(profile);
        //print content everytime new movie is added
        printDatabase();


    }
    public void deleteProfile(View view){
        // string to store input from user in teh edittext
        String inputMovie = nameText.getText().toString();

        // pass string to dbHandler deleteMovies() method
        dbHandler.deleteProfile(inputMovie);
        //print database once deleted
        printDatabase();
    }

}
