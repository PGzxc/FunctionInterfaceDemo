package com.example.functioninterfacedemo.toast;

import android.content.Context;
import android.widget.Toast;

import com.example.functioninterfacedemo.MyApplication;

/**
 * Created by admin on 2017/12/13.
 */

public class ToastUtils {

    private static Toast toast;

    public static void showToast(String msg){
        if(toast==null){
            toast=Toast.makeText(MyApplication.getContext(),msg,Toast.LENGTH_SHORT);
        }else {
            toast.setText(msg);
        }
        toast.show();
    }


}
