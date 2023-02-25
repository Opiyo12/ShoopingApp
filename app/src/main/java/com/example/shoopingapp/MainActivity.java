package com.example.shoopingapp;

import static com.example.shoopingapp.R.id.firstname;
import static com.example.shoopingapp.R.id.submitBtn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
  private EditText firstname, lastname, email;
  private TextView showfname,showlastname;
   private Button btn,btnshow;
   RecyclerView recyclerView;

   //databases
//     FirebaseDatabase db= FirebaseDatabase.getInstance();
//     DatabaseReference root= db.getReference().child("Users");
    private DatabaseReference db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstname= findViewById(R.id.firstname);
        lastname= findViewById(R.id.lastname);
        email=findViewById(R.id.email);
        btn= findViewById(R.id.submitBtn);
        btnshow=findViewById(R.id.showbtn);
        showfname=findViewById(R.id.myfirstname);
        showlastname=findViewById(R.id.mylastname);
        recyclerView= findViewById(R.id.recyclerview);
        db=FirebaseDatabase.getInstance().getReference().child("Users");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fname= firstname.getText().toString();
                String Lname= lastname.getText().toString();
                String myemail= email.getText().toString();
                //Using advanced datatype HashMap
                HashMap<String,String> userMap= new HashMap<>();
                userMap.put("Firstname", fname);
                userMap.put("lastname", Lname);
                userMap.put("Email", myemail);
                db.push().setValue(userMap); // push method is used for creating a unique key for every child

            }
        });

        btnshow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           db.addValueEventListener(new ValueEventListener() {
               @Override
               public void onDataChange(@NonNull DataSnapshot snapshot) {
                 //Checking if the data existss in the database
                   if(snapshot.exists()){
                       String fname= firstname.getText().toString();
                       String Lname= lastname.getText().toString();
                       showfname.setText(fname);
                       showlastname.setText(Lname);
                   }

               }

               @Override
               public void onCancelled(@NonNull DatabaseError error) {

               }
           });

            }
        });





    }
}