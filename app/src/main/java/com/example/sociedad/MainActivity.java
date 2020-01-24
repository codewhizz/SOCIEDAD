package com.example.sociedad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import MODEL.Admin;

public class MainActivity extends AppCompatActivity {

    private TextView register;
    private TextView uid_field, password_field;
    private Button login;
    private String user_id, pass;
    private String getPass;

    //Firebase variables
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseDatabase = FirebaseDatabase.getInstance();


        //register refernce
        register = (TextView) findViewById(R.id.register);
        //onClick method when REGISTER is clicked
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RegisterChoiceActivity.class);
                startActivity(intent);
            }
        });

        uid_field = (TextView) findViewById(R.id.UserId);
        password_field = (TextView) findViewById(R.id.Password);
        login = (Button) findViewById(R.id.login);
        getPass = null;


    }

    public void LoginFunction(View view) {

        user_id = uid_field.getText().toString();
        pass = password_field.getText().toString();

        mDatabaseReference = mFirebaseDatabase.getReference("Admins").child(user_id);
        //Query query = mDatabaseReference.child(user_id);

        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
//                    getPass = dataSnapshot.child("password").getValue(String.class);
//                    uid_field.setText(getPass);
                    Admin user = dataSnapshot.getValue(Admin.class);
                    boolean result = user.getPassword().equals(pass);
                    if (result == true) {
                        Toast.makeText(MainActivity.this, "Match", Toast.LENGTH_LONG).show();

                    } else {
                        Toast.makeText(MainActivity.this, "Not Match", Toast.LENGTH_LONG).show();

                    }

                } else {
                    Toast.makeText(MainActivity.this, "Record Not Found", Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void validateUser(String Pass) {
        boolean result = Pass.equals(pass);
        if (result == true) {
            Toast.makeText(MainActivity.this, "Match", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Not Match", Toast.LENGTH_LONG).show();

        }
    }


}
