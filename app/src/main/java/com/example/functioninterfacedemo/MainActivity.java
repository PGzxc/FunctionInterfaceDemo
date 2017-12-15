package com.example.functioninterfacedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_predicate).setOnClickListener(view->FunctionalInterfaceUtils.predicate());
        findViewById(R.id.btn_function).setOnClickListener(view->FunctionalInterfaceUtils.function());
        findViewById(R.id.btn_supplier).setOnClickListener(view->FunctionalInterfaceUtils.supplier());
        findViewById(R.id.btn_consumer).setOnClickListener(view->FunctionalInterfaceUtils.consumer());
        findViewById(R.id.btn_comparators).setOnClickListener(view->FunctionalInterfaceUtils.comparators());
        findViewById(R.id.btn_optionals).setOnClickListener(view->FunctionalInterfaceUtils.optionals());
        findViewById(R.id.btn_clock).setOnClickListener(view->FunctionalInterfaceUtils.clock());




    }
}
