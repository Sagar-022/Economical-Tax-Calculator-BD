package com.sm.economicaltaxcalculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.FileNotFoundException;


public class calculate_tax extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_tax);
        pdfView= (PDFView) findViewById(R.id.pdfv);
        try {
            String pdfToOpen = getIntent().getStringExtra("pdf_file");
            if (pdfToOpen != null) {
                pdfView.fromStream(openFileInput(pdfToOpen)).load();
            } else {
                pdfView.fromAsset("aykor.pdf").load();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("TAG", "FIle not found");
        }
    }

}
