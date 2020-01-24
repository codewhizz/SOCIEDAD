package com.example.sociedad;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import MODEL.Society;

public class RegisterMemberSocietyActivity extends AppCompatActivity {

    private ImageView search;
    private TextView search_text, society_name, society_reg_no, society_mobileno, society_emailid, society_address;

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_member_society);

        mFirebaseDatabase = FirebaseDatabase.getInstance();

        search_text = (TextView) findViewById(R.id.member_society_uid);
        search = (ImageView) findViewById(R.id.search);
        society_name = (TextView) findViewById(R.id.member_society_name);
        society_reg_no = (TextView) findViewById(R.id.member_society_reg_no);
        society_mobileno = (TextView) findViewById(R.id.member_society_mobile_no);
        society_emailid = (TextView) findViewById(R.id.member_society_emailid);
        society_address = (TextView) findViewById(R.id.member_society_address);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search_uid = search_text.getText().toString();
                mDatabaseReference = mFirebaseDatabase.getReference("Society").child(search_uid);
                mDatabaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        Society society = dataSnapshot.getValue(Society.class);
                        society_name.setText("Name : " + society.getSociety_name());
                        society_reg_no.setText("Registration Number : " + society.getSociety_reg_no());
                        society_mobileno.setText("Mobile Number" + society.getSociety_mobileno());
                        society_emailid.setText("Email Id : " + society.getSociety_emailid());
                        society_address.setText("Address : " + society.getSociety_address());


                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });
    }
}
