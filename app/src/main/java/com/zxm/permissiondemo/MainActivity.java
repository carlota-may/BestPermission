package com.zxm.permissiondemo;

import android.Manifest;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.zxm.bestpermission.callback.PermissionCallBack;
import com.zxm.bestpermission.permission.BestPermission;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for test permission
        ArrayList<String> permissions = new ArrayList<>();
        permissions.add(Manifest.permission.WRITE_CONTACTS);
        permissions.add(Manifest.permission.CALL_PHONE);
//
//        new BestCheckPermission()
//                .addContext(this)
//                .setPermission(permissions)
//                .setPermissionCallBack(new PermissionCallBack() {
//                    @Override
//                    public void success() {
//
//                    }
//
//                    @Override
//                    public void failed(ArrayList<String> deniedPermission) {
//
//                    }
//                }).doCheck();

        new BestPermission()
                .addContext(this)
                .setPermission(permissions)
                .setPermissionCallBack(new PermissionCallBack() {
                    @Override
                    public void success() {
                        Log.i(TAG, "success");
                    }

                    @Override
                    public void failed(ArrayList<String> deniedPermission) {
                        Log.i(TAG, "deniedPermission" + deniedPermission.toString());
                    }
                })
                .doApplyPermission();
    }
}
