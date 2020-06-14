package com.sm.economicaltaxcalculator;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.util.Set;

public class fill_the_form extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_the_form);
    }

    public void onClickSubmit(View view)
    {
        Customer c = new Customer();
        EditText ay_prev = findViewById(R.id.EditTextName_ay_prev);
        c.ay_prev=ay_prev.getText().toString();
        EditText ay_next = findViewById(R.id.EditTextName_ay_next);
        c.ay_next=ay_next.getText().toString();

        EditText dhara_22 = findViewById(R.id.EditTextName_dhara_22);
        c.dhara_22 = dhara_22.getText().toString();
        EditText dhara_23 = findViewById(R.id.EditTextName_dhara_23);
        c.dhara_23 = dhara_23.getText().toString();
        EditText dhara_24 = findViewById(R.id.EditTextName_dhara_24);
        c.dhara_24 = dhara_24.getText().toString();
        EditText dhara_25 = findViewById(R.id.EditTextName_dhara_25);
        c.dhara_25 = dhara_25.getText().toString();
        EditText dhara_26 = findViewById(R.id.EditTextName_dhara_26);
        c.dhara_26 = dhara_26.getText().toString();
        EditText dhara_33 = findViewById(R.id.EditTextName_dhara_33);
        c.dhara_33 = dhara_33.getText().toString();
        EditText farm_ay = findViewById(R.id.EditTextName_farm_ay);
        c.farm_ay = farm_ay.getText().toString();
        EditText dhara_43 = findViewById(R.id.EditTextName_dhara_43);
        c.dhara_43 = dhara_43.getText().toString();
        EditText bideshi_ay = findViewById(R.id.EditTextName_bideshi_ay);
        c.bideshi_ay = bideshi_ay.getText().toString();

        EditText field_40 = findViewById(R.id.EditTextName_field_40);
        c.field_40 = field_40.getText().toString();

        EditText sourceCollector = findViewById(R.id.EditTextName_sourceCollectedKor);
        c.sourceCollectedKor = sourceCollector.getText().toString();
        EditText givenAdvancedKor = findViewById(R.id.EditTextName_givenAdvanceKor);
        c.givenAdvanceKor = givenAdvancedKor.getText().toString();
        EditText field_44 = findViewById(R.id.EditTextName_field_44);
        c.field_44 = field_44.getText().toString();
        EditText returnBasedGivenKor = findViewById(R.id.EditTextName_returnBasedGivenKor);
        c.returnBasedGivenKor = returnBasedGivenKor.getText().toString();
        EditText korFreeAy = findViewById(R.id.EditTextName_korFreeAy);
        c.korFreeAy = korFreeAy.getText().toString();
        EditText mainPay_a = findViewById(R.id.EditTextName_mainPay_a);
        c.mainPay_a = mainPay_a.getText().toString();
        EditText manPay_b = findViewById(R.id.EditTextName_mainPay_b);
        c.mainPay_b = manPay_b.getText().toString();
        EditText specialPay_a = findViewById(R.id.EditTextName_specialPay_a);
        c.specialPay_a = specialPay_a.getText().toString();
        EditText specialPay_b = findViewById(R.id.EditTextName_specialPay_b);
        c.specialPay_b = specialPay_b.getText().toString();
        EditText payablePay_a = findViewById(R.id.EditTextName_payablePay_a);
        c.payablePay_a = payablePay_a.getText().toString();
        EditText payablePay_b = findViewById(R.id.EditTextName_payablePay_b);
        c.payablePay_b = payablePay_b.getText().toString();
        EditText moharghoBonus_a = findViewById(R.id.EditTextName_moharghoBonus_a);
        c.moharghoBonus_a = moharghoBonus_a.getText().toString();
        EditText moharghoBonus_b = findViewById(R.id.EditTextName_moharghoBonus_b);
        c.moharghoBonus_b = moharghoBonus_b.getText().toString();
        EditText rentBonus_a = findViewById(R.id.EditTextName_rentBonus_a);
        c.rentBonus_a = rentBonus_a.getText().toString();
        EditText rentBonus_b = findViewById(R.id.EditTextName_rentBonus_b);
        c.rentBonus_b = rentBonus_b.getText().toString();
        EditText medicalBonus_a = findViewById(R.id.EditTextName_medicalBonus_a);
        c.medicalBonus_a = medicalBonus_a.getText().toString();
        EditText medicalBonus_b = findViewById(R.id.EditTextName_medicalBonus_b);
        c.medicalBonus_b = medicalBonus_b.getText().toString();
        EditText travelBonus_a = findViewById(R.id.EditTextName_travelBonus_a);
        c.travelBonus_a = travelBonus_a.getText().toString();
        EditText travelBonus_b = findViewById(R.id.EditTextName_travelBonus_b);
        c.travelBonus_b = travelBonus_b.getText().toString();
        EditText festivalBonus_a = findViewById(R.id.EditTextName_festivalBonus_a);
        c.festivalBonus_a = festivalBonus_a.getText().toString();
        EditText festivalBonus_b = findViewById(R.id.EditTextName_festivalBonus_b);
        c.festivalBonus_b = festivalBonus_b.getText().toString();
        EditText assistantBonus_a = findViewById(R.id.EditTextName_assistantBonus_a);
        c.assistantBonus_a = assistantBonus_a.getText().toString();
        EditText assistantBonus_b = findViewById(R.id.EditTextName_assistantBonus_b);
        c.assistantBonus_b = assistantBonus_b.getText().toString();
        EditText vacationBonus_a = findViewById(R.id.EditTextName_vacationBonus_a);
        c.vacationBonus_a = vacationBonus_a.getText().toString();
        EditText vacationBonus_b = findViewById(R.id.EditTextName_vacationBonus_b);
        c.vacationBonus_b = vacationBonus_b.getText().toString();
        EditText prizeFeeHonorium_a = findViewById(R.id.EditTextName_prizeFeeHonorium_a);
        c.prizeFeeHonorium_a = prizeFeeHonorium_a.getText().toString();
        EditText prizeFeeHonorium_b = findViewById(R.id.EditTextName_prizeFeeHonorium_b);
        c.prizeFeeHonorium_b = prizeFeeHonorium_b.getText().toString();
        EditText overtimeBonus_a = findViewById(R.id.EditTextName_overtimeBonus_a);
        c.overtimeBonus_a = overtimeBonus_a.getText().toString();
        EditText overtimeBonus_b = findViewById(R.id.EditTextName_overtimeBonus_b);
        c.overtimeBonus_b = overtimeBonus_b.getText().toString();
        EditText bonusExgracia_a = findViewById(R.id.EditTextName_bonusExgracia_a);
        c.bonusExgracia_a = bonusExgracia_a.getText().toString();
        EditText bonusExgracia_b = findViewById(R.id.EditTextName_bonusExgracia_b);
        c.bonusExgracia_b = bonusExgracia_b.getText().toString();
        EditText otherBonus_a = findViewById(R.id.EditTextName_otherBonus_a);
        c.otherBonus_a = otherBonus_a.getText().toString();
        EditText otherBonus_b = findViewById(R.id.EditTextName_otherBonus_b);
        c.otherBonus_b = otherBonus_b.getText().toString();
        EditText field_24a_17_a = findViewById(R.id.EditTextName_field_24a_17_a);
        c.field_24a_17_a = field_24a_17_a.getText().toString();
        EditText field_24a_17_b = findViewById(R.id.EditTextName_field_24a_17_b);
        c.field_24a_17_b = field_24a_17_b.getText().toString();
        EditText field_24a_18_a = findViewById(R.id.EditTextName_field_24a_18_a);
        c.field_24a_18_a = field_24a_18_a.getText().toString();
        EditText field_24a_18_b = findViewById(R.id.EditTextName_field_24a_18_b);
        c.field_24a_18_b = field_24a_18_b.getText().toString();
        EditText field_24a_19_a = findViewById(R.id.EditTextName_field_24a_19_a);
        c.field_24a_19_a = field_24a_19_a.getText().toString();
        EditText field_24a_19_b = findViewById(R.id.EditTextName_field_24a_19_b);
        c.field_24a_19_b = field_24a_19_b.getText().toString();
        EditText field_24a_20_a = findViewById(R.id.EditTextName_field_24a_20_a);
        c.field_24a_20_a = field_24a_20_a.getText().toString();
        EditText field_24a_20_b = findViewById(R.id.EditTextName_field_24a_20_b);
        c.field_24a_20_b = field_24a_20_b.getText().toString();
        EditText others_a = findViewById(R.id.EditTextName_others_a);
        c.others_a = others_a.getText().toString();
        EditText others_b = findViewById(R.id.EditTextName_others_b);
        c.others_b = others_b.getText().toString();

        EditText field_24d_3 = findViewById(R.id.EditTextName_field_24d_3);
        c.field_24d_3 = field_24d_3.getText().toString();
        EditText field_24d_4 = findViewById(R.id.EditTextName_field_24d_4);
        c.field_24d_4 = field_24d_4.getText().toString();
        EditText field_24d_5 = findViewById(R.id.EditTextName_field_24d_5);
        c.field_24d_5 = field_24d_5.getText().toString();
        EditText field_24d_6 = findViewById(R.id.EditTextName_field_24d_6);
        c.field_24d_6 = field_24d_6.getText().toString();
        EditText field_24d_7 = findViewById(R.id.EditTextName_field_24d_7);
        c.field_24d_7 = field_24d_7.getText().toString();
        EditText field_24d_8 = findViewById(R.id.EditTextName_field_24d_8);
        c.field_24d_8 = field_24d_8.getText().toString();
        EditText field_24d_9 = findViewById(R.id.EditTextName_field_24d_9);
        c.field_24d_9 = field_24d_9.getText().toString();
        EditText field_24d_10 = findViewById(R.id.EditTextName_field_24d_10);
        c.field_24d_10 = field_24d_10.getText().toString();
        EditText field_24d_11 = findViewById(R.id.EditTextName_field_24d_11);
        c.field_24d_11 = field_24d_11.getText().toString();
        EditText field_24d_12 = findViewById(R.id.EditTextName_field_24d_12);
        c.field_24d_12 = field_24d_12.getText().toString();


        setFields(c);
    }

    private void setFields(Customer c) {
        OutputStream output = null;
        PdfReader reader = null;
        PdfStamper stamper = null;
        try {
            output = openFileOutput("temp.pdf", Context.MODE_PRIVATE);
            reader = new PdfReader(getAssets().open("aykor.pdf"));
            stamper = new PdfStamper(reader, output);
        } catch (DocumentException e) {
            e.printStackTrace();
            Log.d("TAG", "PDF reading error");
            return;
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "PDF reading error");
            return;
        }
        AcroFields acroFields = stamper.getAcroFields();

        try {
            // TODO: do all your calculation here


            float f_ay_prev = Float.parseFloat(c.ay_prev);
            float f_ay_next = Float.parseFloat(c.ay_next);
            int i_ay_prev = (int) f_ay_prev;
            int i_ay_next = (int) f_ay_next;
            acroFields.setField("ay_prev", Integer.toString(i_ay_prev));
            acroFields.setField("ay_next", Integer.toString(i_ay_next));

            float f_mainPay_a = Float.parseFloat(c.mainPay_a);
            acroFields.setField( "mainPay_a", Float.toString(f_mainPay_a));
            float f_mainPay_b = Float.parseFloat(c.mainPay_b);
            acroFields.setField("mainPay_b", Float.toString(f_mainPay_b));
            float f_mainPay_c = f_mainPay_a-f_mainPay_b;
            acroFields.setField("mainPay_c",Float.toString(f_mainPay_c));
            float f_specialPay_a = Float.parseFloat(c.specialPay_a);
            acroFields.setField( "specialPay_a", Float.toString(f_specialPay_a));
            float f_specialPay_b = Float.parseFloat(c.specialPay_b);
            acroFields.setField("specialPay_b", Float.toString(f_specialPay_b));
            float f_specialPay_c = f_specialPay_a-f_specialPay_b;
            acroFields.setField("specialPay_c",Float.toString(f_specialPay_c));
            float f_payablePay_a = Float.parseFloat(c.payablePay_a);
            acroFields.setField( "payablePay_a", Float.toString(f_payablePay_a));
            float f_payablePay_b = Float.parseFloat(c.payablePay_b);
            acroFields.setField("payablePay_b", Float.toString(f_payablePay_b));
            float f_payablePay_c = f_payablePay_a-f_payablePay_b;
            acroFields.setField("payablePay_c",Float.toString(f_payablePay_c));
            float f_moharghoBonus_a = Float.parseFloat(c.moharghoBonus_a);
            acroFields.setField( "moharghoBonus_a", Float.toString(f_moharghoBonus_a));
            float f_moharghoBonus_b = Float.parseFloat(c.moharghoBonus_b);
            acroFields.setField("moharghoBonus_b", Float.toString(f_moharghoBonus_b));
            float f_moharghoBonus_c = f_moharghoBonus_a-f_moharghoBonus_b;
            acroFields.setField("moharghoBonus_c",Float.toString(f_moharghoBonus_c));
            float f_rentBonus_a = Float.parseFloat(c.rentBonus_a);
            acroFields.setField( "rentBonus_a", Float.toString(f_rentBonus_a));
            float f_rentBonus_b = Float.parseFloat(c.rentBonus_b);
            acroFields.setField("rentBonus_b", Float.toString(f_rentBonus_b));
            float f_rentBonus_c = f_rentBonus_a-f_rentBonus_b;
            acroFields.setField("rentBonus_c",Float.toString(f_rentBonus_c));
            float f_medicalBonus_a = Float.parseFloat(c.medicalBonus_a);
            acroFields.setField( "medicalBonus_a", Float.toString(f_medicalBonus_a));
            float f_medicalBonus_b = Float.parseFloat(c.medicalBonus_b);
            acroFields.setField("medicalBonus_b", Float.toString(f_medicalBonus_b));
            float f_medicalBonus_c = f_medicalBonus_a-f_medicalBonus_b;
            acroFields.setField("medicalBonus_c",Float.toString(f_medicalBonus_c));
            float f_travelBonus_a = Float.parseFloat(c.travelBonus_a);
            acroFields.setField( "travelBonus_a", Float.toString(f_travelBonus_a));
            float f_travelBonus_b = Float.parseFloat(c.travelBonus_b);
            acroFields.setField("travelBonus_b", Float.toString(f_travelBonus_b));
            float f_travelBonus_c = f_travelBonus_a-f_travelBonus_b;
            acroFields.setField("travelBonus_c",Float.toString(f_travelBonus_c));
            float f_festivalBonus_a = Float.parseFloat(c.festivalBonus_a);
            acroFields.setField( "festivalBonus_a", Float.toString(f_festivalBonus_a));
            float f_festivalBonus_b = Float.parseFloat(c.festivalBonus_b);
            acroFields.setField("festivalBonus_b", Float.toString(f_festivalBonus_b));
            float f_festivalBonus_c = f_festivalBonus_a-f_festivalBonus_b;
            acroFields.setField("festivalBonus_c",Float.toString(f_festivalBonus_c));
            float f_assistantBonus_a = Float.parseFloat(c.assistantBonus_a);
            acroFields.setField( "assistantBonus_a", Float.toString(f_assistantBonus_a));
            float f_assistantBonus_b = Float.parseFloat(c.assistantBonus_b);
            acroFields.setField("assistantBonus_b", Float.toString(f_assistantBonus_b));
            float f_assistantBonus_c = f_assistantBonus_a-f_assistantBonus_b;
            acroFields.setField("assistantBonus_c",Float.toString(f_assistantBonus_c));
            float f_vacationBonus_a = Float.parseFloat(c.vacationBonus_a);
            acroFields.setField( "vacationBonus_a", Float.toString(f_vacationBonus_a));
            float f_vacationBonus_b = Float.parseFloat(c.vacationBonus_b);
            acroFields.setField("vacationBonus_b", Float.toString(f_vacationBonus_b));
            float f_vacationBonus_c = f_vacationBonus_a-f_vacationBonus_b;
            acroFields.setField("vacationBonus_c",Float.toString(f_vacationBonus_c));
            float f_prizeFeeHonorium_a = Float.parseFloat(c.prizeFeeHonorium_a);
            acroFields.setField( "prizeFeeHonorium_a", Float.toString(f_prizeFeeHonorium_a));
            float f_prizeFeeHonorium_b = Float.parseFloat(c.prizeFeeHonorium_b);
            acroFields.setField("prizeFeeHonorium_b", Float.toString(f_prizeFeeHonorium_b));
            float f_prizeFeeHonorium_c = f_prizeFeeHonorium_a-f_prizeFeeHonorium_b;
            acroFields.setField("prizeFeeHonorium_c",Float.toString(f_prizeFeeHonorium_c));
            float f_overtimeBonus_a = Float.parseFloat(c.overtimeBonus_a);
            acroFields.setField( "overtimeBonus_a", Float.toString(f_overtimeBonus_a));
            float f_overtimeBonus_b = Float.parseFloat(c.overtimeBonus_b);
            acroFields.setField("overtimeBonus_b", Float.toString(f_overtimeBonus_b));
            float f_overtimeBonus_c = f_overtimeBonus_a-f_overtimeBonus_b;
            acroFields.setField("overtimeBonus_c",Float.toString(f_overtimeBonus_c));
            float f_bonusExgracia_a = Float.parseFloat(c.bonusExgracia_a);
            acroFields.setField( "bonusExgracia_a", Float.toString(f_bonusExgracia_a));
            float f_bonusExgracia_b = Float.parseFloat(c.bonusExgracia_b);
            acroFields.setField("bonusExgracia_b", Float.toString(f_bonusExgracia_b));
            float f_bonusExgracia_c = f_bonusExgracia_a-f_bonusExgracia_b;
            acroFields.setField("bonusExgracia_c",Float.toString(f_bonusExgracia_c));
            float f_otherBonus_a = Float.parseFloat(c.otherBonus_a);
            acroFields.setField( "otherBonus_a", Float.toString(f_otherBonus_a));
            float f_otherBonus_b = Float.parseFloat(c.otherBonus_b);
            acroFields.setField("otherBonus_b", Float.toString(f_otherBonus_b));
            float f_otherBonus_c = f_otherBonus_a-f_otherBonus_b;
            acroFields.setField("otherBonus_c",Float.toString(f_otherBonus_c));
            float f_field_24a_17_a = Float.parseFloat(c.field_24a_17_a);
            acroFields.setField( "field_24a_17_a", Float.toString(f_field_24a_17_a));
            float f_field_24a_17_b = Float.parseFloat(c.field_24a_17_b);
            acroFields.setField("field_24a_17_b", Float.toString(f_field_24a_17_b));
            float f_field_24a_17_c = f_field_24a_17_a-f_field_24a_17_b;
            acroFields.setField("field_24a_17_c",Float.toString(f_field_24a_17_c));
            float f_field_24a_18_a = Float.parseFloat(c.field_24a_18_a);
            acroFields.setField( "field_24a_18_a", Float.toString(f_field_24a_18_a));
            float f_field_24a_18_b = Float.parseFloat(c.field_24a_18_b);
            acroFields.setField("field_24a_18_b", Float.toString(f_field_24a_18_b));
            float f_field_24a_18_c = f_field_24a_18_a-f_field_24a_18_b;
            acroFields.setField("field_24a_18_c",Float.toString(f_field_24a_18_c));
            float f_field_24a_19_a = Float.parseFloat(c.field_24a_19_a);
            acroFields.setField( "field_24a_19_a", Float.toString(f_field_24a_19_a));
            float f_field_24a_19_b = Float.parseFloat(c.field_24a_19_b);
            acroFields.setField("field_24a_19_b", Float.toString(f_field_24a_19_b));
            float f_field_24a_19_c = f_field_24a_19_a-f_field_24a_19_b;
            acroFields.setField("field_24a_19_c",Float.toString(f_field_24a_19_c));
            float f_field_24a_20_a = Float.parseFloat(c.field_24a_20_a);
            acroFields.setField( "field_24a_20_a", Float.toString(f_field_24a_20_a));
            float f_field_24a_20_b = Float.parseFloat(c.field_24a_20_b);
            acroFields.setField("field_24a_20_b", Float.toString(f_field_24a_20_b));
            float f_field_24a_20_c = f_field_24a_17_a-f_field_24a_20_b;
            acroFields.setField("field_24a_20_c",Float.toString(f_field_24a_20_c));
            float f_others_a = Float.parseFloat(c.others_a);
            acroFields.setField( "others_a", Float.toString(f_others_a));
            float f_others_b = Float.parseFloat(c.others_b);
            acroFields.setField("others_b", Float.toString(f_others_b));
            float f_others_c = f_others_a-f_others_b;
            acroFields.setField("others_c",Float.toString(f_others_c));

            float f_total_24a_a;
            f_total_24a_a = f_mainPay_a + f_specialPay_a + f_payablePay_a + f_moharghoBonus_a + f_rentBonus_a + f_medicalBonus_a + f_travelBonus_a + f_festivalBonus_a + f_assistantBonus_a
                            + f_vacationBonus_a + f_prizeFeeHonorium_a + f_overtimeBonus_a + f_bonusExgracia_a + f_otherBonus_a + f_field_24a_17_a + f_field_24a_18_a + f_field_24a_19_a
                            + f_field_24a_20_a + f_others_a;

            acroFields.setField( "total_24a_a", Float.toString(f_total_24a_a));

            float f_total_24a_b;
            f_total_24a_b = f_mainPay_b + f_specialPay_b + f_payablePay_b + f_moharghoBonus_b + f_rentBonus_b + f_medicalBonus_b + f_travelBonus_b + f_festivalBonus_b + f_assistantBonus_b
                            + f_vacationBonus_b + f_prizeFeeHonorium_b + f_overtimeBonus_b + f_bonusExgracia_b + f_otherBonus_b + f_field_24a_17_b + f_field_24a_18_b + f_field_24a_19_b
                            + f_field_24a_20_b + f_others_b;

            acroFields.setField( "total_24a_b", Float.toString(f_total_24a_b));

            float f_total_24a_c;
            f_total_24a_c = f_mainPay_c + f_specialPay_c + f_payablePay_c + f_moharghoBonus_c + f_rentBonus_c + f_medicalBonus_c + f_travelBonus_c + f_festivalBonus_c + f_assistantBonus_c
                    + f_vacationBonus_c + f_prizeFeeHonorium_c + f_overtimeBonus_c + f_bonusExgracia_c + f_otherBonus_c + f_field_24a_17_c + f_field_24a_18_c + f_field_24a_19_c
                    + f_field_24a_20_c + f_others_c;

            acroFields.setField( "total_24a_c", Float.toString(f_total_24a_c));



            float f_field_24d_3 = Float.parseFloat(c.field_24d_3);
            acroFields.setField( "field_24d_3", Float.toString(f_field_24d_3));
            float f_field_24d_4 = Float.parseFloat(c.field_24d_4);
            acroFields.setField( "field_24d_4", Float.toString(f_field_24d_4));
            float f_field_24d_5 = Float.parseFloat(c.field_24d_5);
            acroFields.setField( "field_24d_5", Float.toString(f_field_24d_5));
            float f_field_24d_6 = Float.parseFloat(c.field_24d_6);
            acroFields.setField( "field_24d_6", Float.toString(f_field_24d_6));
            float f_field_24d_7 = Float.parseFloat(c.field_24d_7);
            acroFields.setField( "field_24d_7", Float.toString(f_field_24d_7));
            float f_field_24d_8 = Float.parseFloat(c.field_24d_8);
            acroFields.setField( "field_24d_8", Float.toString(f_field_24d_8));
            float f_field_24d_9 = Float.parseFloat(c.field_24d_9);
            acroFields.setField( "field_24d_9", Float.toString(f_field_24d_9));
            float f_field_24d_10 = Float.parseFloat(c.field_24d_10);
            acroFields.setField( "field_24d_10", Float.toString(f_field_24d_10));
            float f_field_24d_11 = Float.parseFloat(c.field_24d_11);
            acroFields.setField( "field_24d_11", Float.toString(f_field_24d_11));
            float f_field_24d_12 = Float.parseFloat(c.field_24d_12);
            acroFields.setField( "field_24d_12", Float.toString(f_field_24d_12));
            float f_field_24d_13 ;
            f_field_24d_13 = f_field_24d_3 + f_field_24d_4 + f_field_24d_5 + f_field_24d_6 + f_field_24d_7 + f_field_24d_8 + f_field_24d_9 + f_field_24d_10 + f_field_24d_11 + f_field_24d_12;
            acroFields.setField( "field_24d_13", Float.toString(f_field_24d_13));
            float f_field_24d_14 = f_field_24d_13;
            acroFields.setField( "field_24d_14", Float.toString(f_field_24d_14));
            float f_field_24d_15 = (float) (f_field_24d_14 * .1);
            acroFields.setField( "field_24d_15", Float.toString(f_field_24d_15));



            float f_dhara_21 = f_total_24a_c;
            acroFields.setField( "dhara_21", Float.toString(f_dhara_21));
            float f_dhara_22 = Float.parseFloat(c.dhara_22);
            acroFields.setField("dhara_22",Float.toString(f_dhara_22));
            float f_dhara_23 = Float.parseFloat(c.dhara_23);
            acroFields.setField("dhara_23",Float.toString(f_dhara_23));
            float f_dhara_24 = Float.parseFloat(c.dhara_24);
            acroFields.setField("dhara_24",Float.toString(f_dhara_24));
            float f_dhara_25 = Float.parseFloat(c.dhara_25);
            acroFields.setField("dhara_25",Float.toString(f_dhara_25));
            float f_dhara_26 = Float.parseFloat(c.dhara_26);
            acroFields.setField("dhara_26",Float.toString(f_dhara_26));
            float f_dhara_33 = Float.parseFloat(c.dhara_33);
            acroFields.setField("dhara_33",Float.toString(f_dhara_33));
            float f_farm_ay = Float.parseFloat(c.farm_ay);
            acroFields.setField("farm_ay",Float.toString(f_farm_ay));
            float f_dhara_43 = Float.parseFloat(c.dhara_43);
            acroFields.setField("dhara_43",Float.toString(f_dhara_43));
            float f_bideshi_ay = Float.parseFloat(c.bideshi_ay);
            acroFields.setField("bideshi_ay",Float.toString(f_bideshi_ay));
            float f_mot_ay;
            f_mot_ay = f_dhara_21 + f_dhara_22 +f_dhara_23 + f_dhara_24 + f_dhara_25 + f_dhara_26 + f_dhara_33 + f_dhara_43 + f_bideshi_ay;
            acroFields.setField("mot_ay",Float.toString(f_mot_ay));

            float f_ayWithoutReyat;
            if(f_mot_ay < 250000)
            {
                f_ayWithoutReyat = 0;
            }
            else if (f_mot_ay > 250000 && f_mot_ay <= 400000)
            {
                f_ayWithoutReyat = (float) (.1 * f_mot_ay);
            }
            else if (f_mot_ay > 400000 && f_mot_ay <= 500000)
            {
                f_ayWithoutReyat = (float) (.15 * f_mot_ay);
            }
            else if(f_mot_ay > 500000 && f_mot_ay <= 600000)
            {
                f_ayWithoutReyat = (float) (.2 * f_mot_ay);
            }
            else if(f_mot_ay > 600000 && f_mot_ay <= 3000000)
            {
                f_ayWithoutReyat = (float) (.25 * f_mot_ay);
            }
            else
            {
                f_ayWithoutReyat = (float) (.3 * f_mot_ay);
            }
            acroFields.setField("ayWithoutReayat",Float.toString(f_ayWithoutReyat));

            float f_korReyat = f_field_24d_15;
            acroFields.setField("korReyat",Float.toString(f_korReyat));
            float f_reyatMinusKor = f_ayWithoutReyat - f_korReyat;
            acroFields.setField("reyatMinusKor",Float.toString(f_reyatMinusKor));
            float f_minKor = 4000;
            acroFields.setField("minKor",Float.toString(f_minKor));
            float f_netSurcharge = (float) (f_dhara_23 * .1);
            acroFields.setField("netSurcharge",Float.toString(f_netSurcharge));
            float f_field_40 = Float.parseFloat(c.field_40);
            acroFields.setField("field_40",Float.toString(f_field_40));
            float f_totalGivebleKor;
            f_totalGivebleKor = f_reyatMinusKor + f_netSurcharge + f_field_40;
            acroFields.setField("totalGivebleKor",Float.toString(f_totalGivebleKor));
            float f_sourceCollectedKor = Float.parseFloat(c.sourceCollectedKor);
            acroFields.setField("sourceCollectedKor",Float.toString(f_sourceCollectedKor));
            float f_givenAdvanceKor = Float.parseFloat(c.givenAdvanceKor);
            acroFields.setField("givenAdvanceKor",Float.toString(f_givenAdvanceKor));
            float f_field_44 = Float.parseFloat(c.field_44);
            acroFields.setField("field_44",Float.toString(f_field_44));
            float f_returnBasedGivenKor = Float.parseFloat(c.returnBasedGivenKor);
            acroFields.setField("returnBasedGivenKor",Float.toString(f_returnBasedGivenKor));
            float f_givenCombinedKor = f_sourceCollectedKor + f_givenAdvanceKor + f_field_44 + f_returnBasedGivenKor;
            acroFields.setField("givenCombinedKor",Float.toString(f_givenCombinedKor));
            float f_field_47 = f_totalGivebleKor - f_givenCombinedKor;
            acroFields.setField("field_47",Float.toString(f_field_47));
            float f_korFreeAy = Float.parseFloat(c.korFreeAy);
            acroFields.setField("korFreeAy",Float.toString(f_korFreeAy));












            stamper.setFormFlattening(true);
            stamper.close();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "Setting error");
            return;
        } catch (DocumentException e) {
            e.printStackTrace();
            Log.d("TAG", "Setting error");
            return;
        }

        boolean g = isStoragePermissionGranted();
        Log.d("TAG", "Permission checking: " + Boolean.toString(g));
        if (g) {
            Log.d("TAG", "Trying copy");
            try {
                copyInToExtDocs("temp.pdf", "aykor_filled.pdf");
                Log.d("TAG", "Copyy successful");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("TAG", e.getMessage());
            }

            Intent i = new Intent(this, calculate_tax.class);
            i.putExtra("pdf_file", "temp.pdf");
            startActivity(i);
        }
    }

    public void copyInToExtDocs(String src, String dst) throws IOException
    {
        FileChannel inChannel = openFileInput(src).getChannel();
        File dstFile = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_DOWNLOADS), dst);

        FileChannel outChannel = new FileOutputStream(dstFile).getChannel();
        try
        {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        }
        finally
        {
            if (inChannel != null)
                inChannel.close();
            if (outChannel != null)
                outChannel.close();
        }
    }

    public  boolean isStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","Permission is granted");
                return true;
            } else {

                Log.v("TAG","Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v("TAG","Permission is automatically granted");
            return true;
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(grantResults[0]== PackageManager.PERMISSION_GRANTED){
            Log.v("TAG","Permission: "+permissions[0]+ "was "+grantResults[0]);

            Log.d("TAG", "Trying copy");
            try {
                copyInToExtDocs("temp.pdf", "aykor_filled.pdf");
                Log.d("TAG", "Copyy successful");
            } catch (IOException e) {
                e.printStackTrace();
                Log.d("TAG", e.getMessage());
            }

            Intent i = new Intent(this, calculate_tax.class);
            i.putExtra("pdf_file", "temp.pdf");
            startActivity(i);
        }
    }
}