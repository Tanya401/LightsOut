package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import com.example.myapplication.databinding.ActivityBookseatsBinding;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.sql.Array;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class bookseats extends AppCompatActivity implements PaymentResultListener {

    private View row1;
    private View row2;
    private View row3;
    private View row4;
    private View row5;

    ActivityBookseatsBinding binding;

    private ArrayList<TextView> textIdlist = new ArrayList<TextView>();
    TextView col1,col2,col3,col4,col5,col6,col7,col8;
    private ArrayList<TextView> col_arr1 = new ArrayList<>();
    private ArrayList<TextView> col_arr2 = new ArrayList<>();
    private ArrayList<TextView> col_arr3 = new ArrayList<>();
    private ArrayList<TextView> col_arr4 = new ArrayList<>();
    private ArrayList<TextView> col_arr5 = new ArrayList<>();

    private int textViewCount = 8;
    int quantityCount = 2;
    private int price = 100;
    private String rbstring = new String("10:00am");
    private String dateString;
    private Dialog loadingDialog;

    @Override
    @RequiresApi(Build.VERSION_CODES.N)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityBookseatsBinding binding = ActivityBookseatsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        col1 = findViewById(R.id.column1);
        col2 = findViewById(R.id.column2);
        col3 = findViewById(R.id.column3);
        col4 = findViewById(R.id.column4);
        col5 = findViewById(R.id.column5);
        col6 = findViewById(R.id.column6);
        col7 = findViewById(R.id.column7);
        col8 = findViewById(R.id.column8);
        textIdlist.add(col1);
        textIdlist.add(col2);
        textIdlist.add(col3);
        textIdlist.add(col4);
        textIdlist.add(col5);
        textIdlist.add(col6);
        textIdlist.add(col7);
        textIdlist.add(col8);

        String moviename = getIntent().getStringExtra("movie_name");
        String cinemaname = getIntent().getStringExtra("cinema_name");
        price = getIntent().getIntExtra("price", 100);

        binding.txtTotalPrice.setText("Rs." + price);
        row1 = findViewById(R.id.rowlayoutA);
        row2 = findViewById(R.id.rowlayoutB);
        row3 = findViewById(R.id.rowlayoutC);
        row4 = findViewById(R.id.rowlayoutD);
        row5 = findViewById(R.id.rowlayoutE);

        for (int i = 0; i < textViewCount; i++) {


            col_arr1.add(row1.findViewById(textIdlist.get(i).getId()));
            final int temp = i;
            col_arr1.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //   col_arr1.get(temp).isSelected() = !col_arr1.get(temp).isSelected();
                    col_arr1.get(temp).setSelected(!col_arr1.get(temp).isSelected());
                    if (col_arr1.get(temp).isSelected()) {
                        quantityCount = quantityCount + 1;
                    } else {
                        if (quantityCount == 0) {
                            quantityCount = 0;
                        } else {
                            quantityCount = quantityCount - 1;
                        }
                    }
                    setBackgroundTextView(col_arr1, temp);
                    quantityCheck();
                }


            });
            col_arr2.add(row2.findViewById(textIdlist.get(i).getId()));
            col_arr2.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    col_arr2.get(temp).setSelected(!col_arr2.get(temp).isSelected());
                    if (col_arr2.get(temp).isSelected()) {
                        quantityCount = quantityCount + 1;
                    } else {
                        if (quantityCount == 0) {
                            quantityCount = 0;
                        } else {
                            quantityCount = quantityCount - 1;
                        }
                    }
                    setBackgroundTextView(col_arr1, temp);
                    quantityCheck();
                }
            });
            col_arr3.add(row3.findViewById(textIdlist.get(i).getId()));
            col_arr3.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    col_arr3.get(temp).setSelected(!col_arr3.get(temp).isSelected());
                    if (col_arr3.get(temp).isSelected()) {
                        quantityCount = quantityCount + 1;
                    } else {
                        if (quantityCount == 0) {
                            quantityCount = 0;
                        } else {
                            quantityCount = quantityCount - 1;
                        }
                    }
                    setBackgroundTextView(col_arr1, temp);
                    quantityCheck();
                }
            });
            col_arr4.add(row4.findViewById(textIdlist.get(i).getId()));
            col_arr4.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    col_arr4.get(temp).setSelected(!col_arr4.get(temp).isSelected());
                    if (col_arr4.get(temp).isSelected()) {
                        quantityCount = quantityCount + 1;
                    } else {
                        if (quantityCount == 0) {
                            quantityCount = 0;
                        } else {
                            quantityCount = quantityCount - 1;
                        }
                    }
                    setBackgroundTextView(col_arr1, temp);
                    quantityCheck();
                }
            });
            col_arr5.add(row5.findViewById(textIdlist.get(i).getId()));
            col_arr5.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    col_arr5.get(temp).setSelected(!col_arr5.get(temp).isSelected());
                    if (col_arr5.get(temp).isSelected()) {
                        quantityCount = quantityCount + 1;
                    } else {
                        if (quantityCount == 0) {
                            quantityCount = 0;
                        } else {
                            quantityCount = quantityCount - 1;
                        }
                    }
                    setBackgroundTextView(col_arr1, temp);
                    quantityCheck();
                }
            });

        }

        Button pickDatebtn = findViewById(R.id.PickDateBtn);
        Calendar calendar = Calendar.getInstance();
        loadingDialog = new Dialog(this);
        loadingDialog.setContentView(R.layout.loading_layout);
        loadingDialog.getWindow().setLayout(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        loadingDialog.setCancelable(false);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        dateString = Integer.toString(day) + "/" + (month + 1) + "/" + year;
        pickDatebtn.setText(dateString);
        DatePickerDialog datePicker;
        pickDatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker;
                datePicker = new DatePickerDialog(bookseats.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayofMonth) {
                                pickDatebtn.setText(Integer.toString(day) + "/" + (month + 1) + "/" + year);
                                dateString = Integer.toString(day) + "/" + (month + 1) + "/" + year;
                                for (int i = 0; i < textViewCount; i++) {
                                    col_arr1.get(i).setEnabled(true);
                                    col_arr2.get(i).setEnabled(true);
                                    col_arr3.get(i).setEnabled(true);
                                    col_arr4.get(i).setEnabled(true);
                                    col_arr5.get(i).setEnabled(true);

                                    col_arr1.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                                    col_arr2.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                                    col_arr3.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                                    col_arr4.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                                    col_arr5.get(i).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                                }
                                quantityCount = 0;
                                  binding.txtQuantity.setText("0");    //txtquantity = quantitycount
                                  binding.txtTotalPrice.setText("Rs.0");

                            }
                        }, year, month, day);

                datePicker.getDatePicker().setMinDate(calendar.getTimeInMillis());
                String string_Date = "25-11-2022 00:00:00";
                SimpleDateFormat f = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date d = new Date();
                    d = f.parse(string_Date);
                    long milliseconds = d.getTime(); //returning null pointer exception
                datePicker.getDatePicker().setMinDate(milliseconds);
                pickDatebtn.setText(d.toString());
                    datePicker.show();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        });

        //ChipGroup chipGroup = findViewById(R.id.chipgroup);
        RadioGroup radioGroup = findViewById(R.id.radiogroup);

        binding.bookNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pickDatebtn.getText().toString() != "Pick Date") {
                    if (quantityCount > 0) {
                        Checkout checkout = new Checkout();
                        checkout.setKeyID("rzp_test_9kzihYhF8dvqlg");

                        try {
                            JSONObject jsonObject = new JSONObject();
                            int totalPrice = ((price * quantityCount) * 100);
                            jsonObject.put("name", "LightsOut");
                            jsonObject.put("description", "Test Payment");
                            jsonObject.put("theme.color", "#0093DD");
                            jsonObject.put("currency", "INR");
                            jsonObject.put("Amount", totalPrice);
                            jsonObject.put("prefill.contact", "+911234567890");
                            jsonObject.put("prefill.email", "random@gmail.com");
                            checkout.open(bookseats.this, jsonObject);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast toast = Toast.makeText(bookseats.this, "Please select atleast 1 seat", Toast.LENGTH_LONG);
                        toast.show();
                    }
                } else {
                    Toast toast = Toast.makeText(bookseats.this, "Please select date", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
               RadioButton rb = findViewById(i);
                for (int temp = 0; temp < textViewCount; temp++) {
                    col_arr1.get(temp).setEnabled(true);
                    col_arr2.get(temp).setEnabled(true);
                    col_arr3.get(temp).setEnabled(true);
                    col_arr4.get(temp).setEnabled(true);
                    col_arr5.get(temp).setEnabled(true);
                    col_arr1.get(temp).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                    col_arr2.get(temp).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                    col_arr3.get(temp).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                    col_arr4.get(temp).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                    col_arr5.get(temp).setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.backborder, null));
                }
                rbstring = rb.getText().toString();
            }
        });
    }


    private void setBackgroundTextView(ArrayList<TextView> col_arr1, int temp) {
        if (col_arr1.get(temp).isSelected()) {
            col_arr1.get(temp).setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.buttton_outline,null));
        }else{
            col_arr1.get(temp).setBackground(ResourcesCompat.getDrawable(getResources(),R.drawable.backborder,null));
        }
    }

    private void quantityCheck(){
//        String temp = Integer.toString(quantityCount);
//        binding.txtQuantity.setText(temp);
        if(quantityCount >= 0){
            binding.txtTotalPrice.setText("Rs" + Integer.toString(price*quantityCount));
        }
        else{
            Toast toast = Toast.makeText(this,"Please select atleast 1 seat",Toast.LENGTH_LONG);
            toast.show();
        }
        }



        @Override
        public void onPaymentSuccess (String s) {
            Toast toast = Toast.makeText(this, "payment successfull!!", Toast.LENGTH_LONG);
            toast.show();
        }

        @Override
        public void onPaymentError ( int i, String s){
            Toast toast = Toast.makeText(this, "payment unsuccessfull!!", Toast.LENGTH_LONG);
            toast.show();
        }
    }


