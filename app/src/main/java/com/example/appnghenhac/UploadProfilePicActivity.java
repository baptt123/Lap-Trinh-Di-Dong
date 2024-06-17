package com.example.appnghenhac;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.appnghenhac.login_register.DangNhapActivity;
import com.google.android.gms.auth.api.signin.internal.Storage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class UploadProfilePicActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private ImageView imageViewUploadPic;
    private FirebaseAuth authProfile;
    private StorageReference storageReference;
    private FirebaseUser firebaseUser;
    private static final  int PICK_IMAGE_REQUEST =1;
    private Uri uriImage;

    public UploadProfilePicActivity(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_profile_pic);
        getSupportActionBar().setTitle("Upload Profile Picture");

        Button buttonUploadPicChoose = findViewById(R.id.upload_pic_choose_button);
        Button buttonUploadPic = findViewById(R.id.upload_pic_button);
        progressBar = findViewById(R.id.progress);
        imageViewUploadPic = findViewById(R.id.image_profile_choose);


        authProfile = FirebaseAuth.getInstance();
        firebaseUser = authProfile.getCurrentUser();

        storageReference = FirebaseStorage.getInstance().getReference("DisplayPics");

        Uri uri= firebaseUser.getPhotoUrl();

        //Set User's current DP in ImageView (if upload already) We will Picasso since imageViewer setImage
        //Regular URIs
        Picasso.get().load(uri).into(imageViewUploadPic);


        //Choosing image to upload
        buttonUploadPicChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChoose();
            }
        });
        //Upload image
        buttonUploadPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressBar.setVisibility(View.VISIBLE);
                uploadPic();
            }
        });

    }

    private void uploadPic() {
        if(uriImage != null){
            //Save the image with uid of the currently logged user
            StorageReference fileReference = storageReference.child(authProfile.getCurrentUser().getUid() + "."
            + getFileExtention(uriImage));

            //Get image to Storage
            fileReference.putFile(uriImage).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                    fileReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                        @Override
                        public void onSuccess(Uri uri) {
                            Uri downloadUri = uri;
                            firebaseUser = authProfile.getCurrentUser();


                            //Finally set the display image of the user after upload
                            UserProfileChangeRequest profileUpdate = new UserProfileChangeRequest.Builder()
                                    .setPhotoUri(downloadUri).build();
                            firebaseUser.updateProfile(profileUpdate);
                        }
                    });
                    progressBar.setVisibility(View.GONE);
                    Toast.makeText(UploadProfilePicActivity.this,"Upload Picture Successfully",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(UploadProfilePicActivity.this,ProfileActivity.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(UploadProfilePicActivity.this,e.getMessage(),Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(UploadProfilePicActivity.this,"No fill Selected!!!",Toast.LENGTH_SHORT).show();
        }
    }
    //Optain file extension of the image
    private String getFileExtention(Uri uri){
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime  = MimeTypeMap.getSingleton();
        return  mime.getExtensionFromMimeType(cR.getType(uri));

    }

    private void openFileChoose() {
        Intent intent = new Intent();
        intent.setType("image/");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            uriImage = data.getData();
            imageViewUploadPic.setImageURI(uriImage);
        }
    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_profile,menu);

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();
        if(id == R.id.memu_refresh){
            startActivity(getIntent());
            finish();
            overridePendingTransition(0,0);
        /*}else if(id == R.id.menu_update_profile ){
            Intent intent = new Intent(ProfileActivity.this, UpdateProfileActivity.class);
            startActivity(intent);
        }else if(id == R.id.menu_update_email){
            Intent intent = new Intent(ProfileActivity.this, UpdateEmailActivity.class);
            startActivity(intent);
        }else if(id == R.id.menu_change_password){
            Intent intent = new Intent(ProfileActivity.this, ChangePasswordActivity.class);
            startActivity(intent);
        }else if(id == R.id.menu_settings){
           Toast.makeText(ProfileActivity.this,"menu_setting",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.menu_delete_profile){
            Intent intent = new Intent(ProfileActivity.this,DeleteProfileActivity.class);
            startActivity(intent);*/
        }else if(id == R.id.menu_logout){
            authProfile.signOut();
            Toast.makeText(UploadProfilePicActivity.this,"Logged Out",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(UploadProfilePicActivity.this, DangNhapActivity.class);

            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(UploadProfilePicActivity.this,"Something went wrong!!",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);

    }
}