package com.zxm.bestpermission.permission;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import com.zxm.bestpermission.callback.PermissionCallBack;
import com.zxm.bestpermission.tool.Tools;

import java.util.ArrayList;

public class BestPermissionActivity extends Activity {
    private static final String TAG = BestPermissionActivity.class.getSimpleName();
    private static final int PERMISSION_REQUEST_CODE = 101;
    private static final String PERMISSION = "permission";

    public static void startApplyPermission(Activity activity, ArrayList<String> permissions) {
        Intent intent = new Intent(activity, BestPermissionActivity.class);
        intent.putStringArrayListExtra(PERMISSION, permissions);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCompat.requestPermissions(this, Tools.formatListToArray(getIntent().getStringArrayListExtra(PERMISSION)), PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            PermissionCallBack permissionCallBack = BestPermission.getCallBack();
            ArrayList<String> grantedPermissions = new ArrayList<>();
            ArrayList<String> deniedPermissions = new ArrayList<>();
            for (int i = 0; i < grantResults.length; i++) {
                int grantResult = grantResults[i];
                if (grantResult == PackageManager.PERMISSION_GRANTED) {
                    grantedPermissions.add(permissions[i]);
                } else {
                    deniedPermissions.add(permissions[i]);
                }
            }
            if (grantedPermissions.size() == permissions.length) {
                permissionCallBack.success();
            } else {
                permissionCallBack.failed(deniedPermissions);
            }
        }
    }

    //no display UI
    @Override
    protected void onResume() {
        super.onResume();
        finish();
    }
}
