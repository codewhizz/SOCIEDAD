package com.example.sociedad;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import MODEL.Admin;

public class RegisterAdminActivity extends AppCompatActivity {

    //firebase variables
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;

    //submit button
    private Button next1;

    private TextView fname, mname, lname, mobile_number, email, address, uid, pass, con_pass;
    private DatePicker datePicker;
    private String dateOfBirth;
    Admin admin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_admin);

        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mFirebaseDatabase.getReference().child("Admins");

        fname = (TextView) findViewById(R.id.admin_fname);
        mname = (TextView) findViewById(R.id.admin_mname);
        lname = (TextView) findViewById(R.id.admin_lname);
        mobile_number = (TextView) findViewById(R.id.contact_no);
        email = (TextView) findViewById(R.id.email_id);
        address = (TextView) findViewById(R.id.paddress);
        uid = (TextView) findViewById(R.id.admin_uid);
        pass = (TextView) findViewById(R.id.admin_password);
        con_pass = (TextView) findViewById(R.id.admin_confirm_password);
        datePicker = (DatePicker) findViewById(R.id.dob);


        next1 = (Button) findViewById(R.id.next_button);

        next1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int month = datePicker.getMonth() + 1;
                dateOfBirth = datePicker.getDayOfMonth() + "/" + month + "/" + datePicker.getYear();

                admin = new Admin(fname.getText().toString(), mname.getText().toString(), lname.getText().toString(), dateOfBirth, mobile_number.getText().toString(), email.getText().toString(), address.getText().toString(), uid.getText().toString(), pass.getText().toString(), con_pass.getText().toString());
//
                if (TextUtils.isEmpty(admin.getFirst_name())) {
                    Toast.makeText(RegisterAdminActivity.this, "Enter First Name", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(admin.getMiddle_name())) {
                    Toast.makeText(RegisterAdminActivity.this, "Enter Middle Name", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(admin.getLast_name())) {
                    Toast.makeText(RegisterAdminActivity.this, "Enter Last Name", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(admin.getMobile_number())) {
                    Toast.makeText(RegisterAdminActivity.this, "Enter Mobile Number", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(admin.getEmail())) {
                    Toast.makeText(RegisterAdminActivity.this, "Enter Email ID", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(admin.getAddress())) {
                    Toast.makeText(RegisterAdminActivity.this, "Enter Address", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(admin.getPassword())) {
                    Toast.makeText(RegisterAdminActivity.this, "Enter Password", Toast.LENGTH_LONG).show();
                } else if (TextUtils.isEmpty(admin.getConfirm_password())) {
                    Toast.makeText(RegisterAdminActivity.this, "Confirm Password", Toast.LENGTH_LONG).show();
                } else {

                    final String id = admin.getUid();
                    mDatabaseReference.child(id).child("first_name").setValue(admin.getFirst_name());
                    mDatabaseReference.child(id).child("middle_name").setValue(admin.getMiddle_name());
                    mDatabaseReference.child(id).child("last_name").setValue(admin.getLast_name());
                    mDatabaseReference.child(id).child("dob").setValue(admin.getDob());
                    mDatabaseReference.child(id).child("mobile_number").setValue(admin.getMobile_number());
                    mDatabaseReference.child(id).child("email").setValue(admin.getEmail());
                    mDatabaseReference.child(id).child("uid").setValue(admin.getUid());
                    mDatabaseReference.child(id).child("password").setValue(admin.getPassword());
                    mDatabaseReference.child(id).child("confirm_password").setValue(admin.getConfirm_password(), new DatabaseReference.CompletionListener() {
                        @Override
                        public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                            Toast.makeText(RegisterAdminActivity.this, "Successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(RegisterAdminActivity.this, RegisterSocietyActivity.class);
                            i.putExtra("id", id);
                            startActivity(i);
                        }
                    });

                }

            }
        });


    }


}
