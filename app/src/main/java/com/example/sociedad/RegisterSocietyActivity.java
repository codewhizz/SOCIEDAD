package com.example.sociedad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import MODEL.Society;

public class RegisterSocietyActivity extends AppCompatActivity {

    private Button back, next;
    private String id;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    private Society society;
    private TextView society_name, society_reg_no, society_mobileno, society_emailid, society_address, society_uid, society_buildings, society_bunglows, society_rowhouses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_society);
        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        society_name = (TextView) findViewById(R.id.society_name);
        society_reg_no = (TextView) findViewById(R.id.society_reg_no);
        society_mobileno = (TextView) findViewById(R.id.society_contact_no);
        society_emailid = (TextView) findViewById(R.id.society_email_id);
        society_address = (TextView) findViewById(R.id.society_address);
        society_uid = (TextView) findViewById(R.id.society_uid);
        society_buildings = (TextView) findViewById(R.id.no_of_buildings);
        society_bunglows = (TextView) findViewById(R.id.no_of_bunglows);
        society_rowhouses = (TextView) findViewById(R.id.no_of_rowhouse);


        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference("Society");


        back = (Button) findViewById(R.id.society_back_button);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO populate old contains in Admin Activity
                finish();
            }
        });

        next = (Button) findViewById(R.id.society_next_button);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(RegisterSocietyActivity.this,id,Toast.LENGTH_LONG).show();
                society = new Society(society_name.getText().toString(), society_reg_no.getText().toString(), society_mobileno.getText().toString(), society_emailid.getText().toString(), society_address.getText().toString(), society_uid.getText().toString(), society_buildings.getText().toString(), society_bunglows.getText().toString(), society_rowhouses.getText().toString(), id);

                if (TextUtils.isEmpty(society.getSociety_name())) {
                    Toast.makeText(RegisterSocietyActivity.this, "Enter Society Name", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(society.getSociety_reg_no())) {
                    Toast.makeText(RegisterSocietyActivity.this, "Enter Society Registration Number", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(society.getSociety_mobileno())) {
                    Toast.makeText(RegisterSocietyActivity.this, "Enter Society Mobile Number", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(society.getSociety_emailid())) {
                    Toast.makeText(RegisterSocietyActivity.this, "Enter Society Email Id", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(society.getSociety_address())) {
                    Toast.makeText(RegisterSocietyActivity.this, "Enter Society Address", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(society.getSociety_uid())) {
                    Toast.makeText(RegisterSocietyActivity.this, "Enter Society Unique Id", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(society.getSociety_buildings())) {
                    Toast.makeText(RegisterSocietyActivity.this, "Enter Number of Buildings", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(society.getSociety_bunglows())) {
                    Toast.makeText(RegisterSocietyActivity.this, "Enter Number of Bunglows", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(society.getSociety_rowhouses())) {
                    Toast.makeText(RegisterSocietyActivity.this, "Enter Number of Rowhouses", Toast.LENGTH_LONG).show();
                } else {
                    final String uid = society.getSociety_uid();
                    mDatabaseReference.child(uid).child("society_name").setValue(society.getSociety_name());
                    mDatabaseReference.child(uid).child("society_reg_no").setValue(society.getSociety_reg_no());
                    mDatabaseReference.child(uid).child("society_mobileno").setValue(society.getSociety_mobileno());
                    mDatabaseReference.child(uid).child("society_emailid").setValue(society.getSociety_emailid());
                    mDatabaseReference.child(uid).child("society_address").setValue(society.getSociety_address());
                    mDatabaseReference.child(uid).child("society_uid").setValue(society.getSociety_uid());
                    mDatabaseReference.child(uid).child("society_buildings").setValue(society.getSociety_buildings());
                    mDatabaseReference.child(uid).child("society_bunglows").setValue(society.getSociety_bunglows());
                    mDatabaseReference.child(uid).child("society_admin_uid").setValue(society.getSociety_admin_uid());
                    mDatabaseReference.child(uid).child("society_rowhouses").setValue(society.getSociety_rowhouses(), new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            Toast.makeText(RegisterSocietyActivity.this, "Successful", Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}
