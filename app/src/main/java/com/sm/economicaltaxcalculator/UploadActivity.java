package com.sm.economicaltaxcalculator;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.channels.FileChannel;

public class UploadActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    private FirebaseUser user;
    private FirebaseStorage storage;

    private TextView txtEmail;
    private TextView txtPassword;
    private TextView txtnotreg;
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btnLogin;
    private Button btnUpload;
    private ProgressBar progress;
    private Button share;
    private Button logout;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload);

        txtEmail = (TextView) findViewById(R.id.email);
        txtPassword = (TextView) findViewById(R.id.password);
        txtnotreg = (TextView) findViewById(R.id.notregistered);
        edtEmail = (EditText) findViewById(R.id.EditTextName_email);
        edtPassword = (EditText) findViewById(R.id.EditTextName_password);
        btnLogin = (Button) findViewById(R.id.login);
        btnUpload = (Button) findViewById(R.id.upload);
        progress = (ProgressBar) findViewById(R.id.progress);
        share = (Button) findViewById(R.id.share);
        logout = (Button) findViewById(R.id.logout);
        register = (Button) findViewById(R.id.register);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        storage = FirebaseStorage.getInstance();

        if (user != null) {
            userLoggedIn();
        }
    }

    public void onClickLogin(View v) {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        auth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Log.d("TEST", "Login success");
                user = auth.getCurrentUser();
                userLoggedIn();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UploadActivity.this, "Incorrect info!", Toast.LENGTH_LONG).show();
                txtEmail.setText("");
                txtPassword.setText("");
                Log.d("TEST", "FAILLLLLLL");
            }
        });

    }

    public void onClickUpload(View v) {
        final File f = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), "aykor_filled.pdf");
        InputStream is;
        try {
            is = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            Toast.makeText(UploadActivity.this, "No file to upload", Toast.LENGTH_LONG).show();
            Log.d("TEST", "No file to upload");
            return;
        }

        btnUpload.setEnabled(false);
        StorageReference ref = storage.getReference().child(user.getUid() + ".pdf");
        ref.putStream(is).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(UploadActivity.this, "Upload complete!", Toast.LENGTH_LONG).show();
                btnUpload.setEnabled(true);
                Log.d("TEST", "Upload complete");
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UploadActivity.this, "Upload Failed!", Toast.LENGTH_LONG).show();
                btnUpload.setEnabled(true);
                Log.d("TEST", "Upload failed: " + e.toString());
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double percentage = (100.0 * taskSnapshot.getBytesTransferred()) / f.length();
                progress.setProgress((int) percentage);
                Log.d("TEST", "Progress update: " + String.valueOf(percentage) + " " + f.length());
            }
        });
    }

    public void onClickShare(View v) {
        StorageReference ref = storage.getReference().child(user.getUid() + ".pdf");
        ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Log.d("TEST", "Sharing link: " + uri.toString());

                Intent share = new Intent(android.content.Intent.ACTION_SEND);
                share.setType("text/plain");
                share.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);

                share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
                share.putExtra(Intent.EXTRA_TEXT, uri.toString());

                startActivity(Intent.createChooser(share, "Share link!"));
            }
        });
    }

    public void onClickLogout(View v){
        FirebaseAuth.getInstance().signOut();
        finish();
        txtEmail.setVisibility(View.VISIBLE);
        txtPassword.setVisibility(View.VISIBLE);
        edtEmail.setVisibility(View.VISIBLE);
        edtPassword.setVisibility(View.VISIBLE);
        btnLogin.setVisibility(View.VISIBLE);
        txtnotreg.setVisibility(View.VISIBLE);
        register.setVisibility(View.VISIBLE);

        btnUpload.setVisibility(View.GONE);
        progress.setVisibility(View.GONE);
        share.setVisibility(View.GONE);
        logout.setVisibility(View.GONE);
        Intent intent = new Intent(this,UploadActivity.class);
        startActivity(intent);
    }

    public void userLoggedIn() {
        txtEmail.setVisibility(View.GONE);
        txtPassword.setVisibility(View.GONE);
        edtEmail.setVisibility(View.GONE);
        edtPassword.setVisibility(View.GONE);
        btnLogin.setVisibility(View.GONE);
        txtnotreg.setVisibility(View.GONE);
        register.setVisibility(View.GONE);

        btnUpload.setVisibility(View.VISIBLE);
        progress.setVisibility(View.VISIBLE);
        share.setVisibility(View.VISIBLE);
        logout.setVisibility(View.VISIBLE);

    }

    public void onClickRegister(View view)
    {
        Intent intent = new Intent(this,register.class);
        startActivity(intent);
    }
}
