package com.sm.economicaltaxcalculator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCalculateTax(View view)
    {

        Intent intent = new Intent(this,calculate_tax.class);
        startActivity(intent);
    }

    public  void onClickAboutTax (View view)
    {
        Intent intent = new Intent(this,about_tax.class);
        startActivity(intent);
    }


    public void onClickRules (View view)
    {
        Intent intent = new Intent(this,rules.class);
        startActivity(intent);
    }
    public void onClickFill (View view)
    {
        Intent intent = new Intent(this,fill_the_form.class);
        startActivity(intent);
    }
    public void onClickUpload (View view)
    {
        Intent intent = new Intent(this,UploadActivity.class);
        startActivity(intent);
    }
}
