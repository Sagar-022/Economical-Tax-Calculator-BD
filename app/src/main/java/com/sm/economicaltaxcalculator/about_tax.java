package com.sm.economicaltaxcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class about_tax extends AppCompatActivity {

    public String Message="In Bangladesh, the principal taxes are Customs Duties, Value-Added-Tax (VAT), Supplementary Duty and personal income taxes and corporate income taxes.\n" +
            "\n" +
            "The standard rate of VAT is 15% levied on transaction value of most of the imports and supplies of goods and services.The tax law imposes income tax at 25 percent on listed entities and 35 percent for non-listed entities. Corporate tax rate changes announced this year include:\n" +
            "\n" +
            "an additional surcharge of 2.5 percent on income of companies in the tobacco sector\n" +
            "a reduction of the corporate income tax rate for companies in the readymade garments sector to 15 percent (from 20 percent)\n" +
            "a further 1 percent rate reduction (to 14 percent) for companies in the readymade garments sector that have an internationally recognized green building certificate.Certain companies remain taxed at different rates. For example:\n" +
            "\n" +
            "Banking companies, insurance companies and non-banking financial institutions are taxed at 40 percent if they are listed and 42.5 percent if non-listed.\n" +
            "Cigarette manufacturers and mobile phone operator are taxed at 45 percent (before the additional surcharge on cigarette manufacturers noted above)\n" +
            "Companies engaged in production and export of knitwear and woven garments enjoy a reduced corporate tax rates of 20 percent, and companies that produce or export jute products are taxed at 10 percent.\n" +
            "Generally, a company’s export earnings are 50 percent exempt.\n" +
            "\n" +
            "For companies, the tax day (i.e. tax return due date) is now the 15th day of seventh month following the end of income year; alternatively, where that fifteenth day is before 15 September, the tax day is 15 September of the year following the end of the income year.\n\n" +
            "[Source:wikipedia]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_tax);
        TextView messageView = (TextView) findViewById(R.id.tax_message);
        messageView.setMovementMethod(new ScrollingMovementMethod());
        messageView.setText(Message);
    }
}
