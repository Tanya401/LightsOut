package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class paynow extends AppCompatActivity  {

    private Button paybutton;
    private EditText Amount;
   // private TextView paystatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paynow);

        paybutton = findViewById(R.id.paybutton);
        Amount = findViewById(R.id.EnterAmount);
       // paystatus = findViewById(R.id.paymentstatus);

        Checkout.preload(paynow.this);
        paybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startPayment(Integer.parseInt(Amount.getText().toString()));
            }
        });
    }

    public void startPayment(int Amount){
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_9kzihYhF8dvqlg");

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("Name","BOOK YOUR TICKETS");
            jsonObject.put("Description","Pay and Enjoy your movie!!");
            jsonObject.put("theme.color","@color/blueforapp");
            jsonObject.put("currency","INR");
            jsonObject.put("amount",Amount*100);

            JSONObject retryOBJ = new JSONObject();
            retryOBJ.put("enabled",true);
            retryOBJ.put("max_count",4);
            jsonObject.put("retry",retryOBJ);

            checkout.open(paynow.this,jsonObject);
        }
        catch (Exception e){
            Toast.makeText(paynow.this,"Something went wrong!!",Toast.LENGTH_LONG).show();
        }
    }

//    @Override
//    public void onPaymentSuccess(String s) {
//       paystatus.setText(s);
//    }
//
//    @Override
//    public void onPaymentError(int i, String s) {
//      paystatus.setText("Error : " + s);
//    }
}