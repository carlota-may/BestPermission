package com.zxm.bestpermission.check;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

import com.zxm.bestpermission.callback.PermissionCallBack;

import java.util.ArrayList;

public class BestCheckPermission {
    private static final String TAG = BestCheckPermission.class.getSimpleName();

    private Activity activity;
    private ArrayList<String> permissions = new ArrayList<>();
    private PermissionCallBack permissionCallBack;

    public BestCheckPermission setPermissionCallBack(PermissionCallBack callBack) {
        permissionCallBack = callBack;
        return this;
    }

    public BestCheckPermission addContext(Activity activity) {
        this.activity = activity;
        return this;
    }

    public BestCheckPermission setPermission(ArrayList<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public void doCheck() {
        ArrayList<String> allowPermissions = new ArrayList<>();
        ArrayList<String> notAllowPermissions = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED) {
                allowPermissions.add(permission);
            } else {
                notAllowPermissions.add(permission);
            }
        }
        if (allowPermissions.size() == permissions.size()) {
            permissionCallBack.success();
        } else {
            permissionCallBack.failed(notAllowPermissions);
        }
    }
}
