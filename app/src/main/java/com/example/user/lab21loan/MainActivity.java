package com.example.user.lab21loan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected static final String LOAN_PAYMENT = "payment";
    protected static final String LOAN_STATUS = "status";

    EditText editTextVehiclePrice, editTextDownpayment, editTextRepayment, editTextInterestRate, editTextSalary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextVehiclePrice = (EditText)findViewById(R.id.editTextVehiclePrice);
        editTextDownpayment = (EditText) findViewById(R.id.editTextDownpayment);
        editTextRepayment = (EditText)findViewById(R.id.editTextRepayment);
        editTextInterestRate = (EditText) findViewById(R.id.editTextInterestRate);
        editTextSalary = (EditText) findViewById((R.id.editTextSalary));

    }

    public void calculateLoan(View view)
    {   //TODO: calculate repayment amount and determine the status of loan application

        double payment = 0.0;
        String status = "";


        //Calculations for repayment amount
        double loan, totalInterest, totalLoan;

        double vehiclePrice = Double.parseDouble(editTextVehiclePrice.getText()+"");
        double salary = Double.parseDouble(editTextSalary.getText() + "");
        double downpayment = Double.parseDouble(editTextDownpayment.getText() + "");
        double interestRate = Double.parseDouble(editTextInterestRate.getText() + "");
        double repayment = Double.parseDouble(editTextRepayment.getText()+"");

        loan = vehiclePrice - downpayment;
        totalInterest = loan * interestRate * (repayment/12.0);
        totalLoan = loan + totalInterest;
        payment = totalLoan / repayment;

        if(payment > salary*0.3 )
        {
            status = "Rejected";
        }
        else
        {
            status = "Approved";
        }
        //This is an Explicit Intent
        //Define intent object
        Intent intent = new Intent(this, Result.class);

        //Use the putExtra method to pass data
        //format: putExtra(TAG, value)
        intent.putExtra(LOAN_PAYMENT, payment);
        intent.putExtra(LOAN_STATUS, status);

        startActivity(intent);
    }

    public void resetActivity(View view)
    {

    }
}
