package com.example.termin12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Toast.makeText(this, "Second activity", Toast.LENGTH_SHORT).show();
    }

    private static final int REQUEST_ID = 0;

    public void klikNaDugme(View v) {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_PICK);
        i.setData(ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(i, REQUEST_ID);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Toast.makeText(this, "result " + data.toString(), Toast.LENGTH_LONG).show();


    }

    public void btnStartActivityClicked(View v) {
        Button b=(Button) v;
        if(v.getId()==R.id.button6){

        }
        Intent intent = new Intent(this, ThirdActivity.class);
        startActivity(intent);


    }

    public void btnOpenCameraClicked(View v) {
        Intent intent = new Intent(MediaStore.INTENT_ACTION_VIDEO_CAMERA);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);





        }
    }

}

