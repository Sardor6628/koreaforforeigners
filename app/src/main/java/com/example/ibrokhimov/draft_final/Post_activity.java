package com.example.ibrokhimov.draft_final;


import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class Post_activity extends AppCompatActivity {
    private ImageButton imgbtn;
    private EditText NameofItem, Desctription;
    private Button submitbtn;
    private EditText phoneN;
    private static final int GALLERY_REQUEST=1;
    private StorageReference mStorage;
    private DatabaseReference mDatabase;

    private ProgressDialog mProgress;


    private Uri imageUri=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStorage= FirebaseStorage.getInstance().getReference();
        mDatabase= FirebaseDatabase.getInstance().getReference().child("Blog");

        setContentView(R.layout.activity_post_activity);
        imgbtn=(ImageButton)findViewById(R.id.imageSelect);
        NameofItem=(EditText)findViewById(R.id.titleField);
        Desctription=(EditText)findViewById(R.id.description);
        submitbtn=(Button) findViewById(R.id.submitbtn);
        phoneN=(EditText)findViewById(R.id.phoneNumber);
        mProgress=new ProgressDialog(this);
        imgbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent galleryIntent=new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent, GALLERY_REQUEST);

            }
        });
    submitbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            startPosting();
        }
    });
    }

    private void startPosting() {
        mProgress.setMessage("Posting to Blog..");



        final String title_val=NameofItem.getText().toString().trim();
        final String desctription_val=Desctription.getText().toString().trim();
        final String phone_val=phoneN.getText().toString().trim();


        if(!TextUtils.isEmpty(title_val) && !TextUtils.isEmpty(desctription_val)&&!TextUtils.isEmpty(phone_val)&& imageUri!=null){
            mProgress.show();
            StorageReference filepath=mStorage.child("Blog_Images").child(imageUri.getLastPathSegment());
            filepath.putFile(imageUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                     Uri downloadUri=taskSnapshot.getDownloadUrl();
                     DatabaseReference newPost=mDatabase.push();
                    newPost.child("title").setValue(title_val);
                    newPost.child("Description").setValue(desctription_val);
                    newPost.child("ContactNumber").setValue(phone_val);
                    newPost.child("image").setValue(downloadUri.toString());
                     mProgress.dismiss();
                     startActivity(new Intent(Post_activity.this, MainActivity.class ));
                }
            });

        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==GALLERY_REQUEST && resultCode==RESULT_OK){
             imageUri=data.getData();
            imgbtn.setImageURI(imageUri);
        }
    }
}
