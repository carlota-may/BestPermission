package com.zxm.bestpermission.permission;

import android.app.Activity;

import com.zxm.bestpermission.callback.PermissionCallBack;
import com.zxm.bestpermission.check.BestCheckPermission;

import java.util.ArrayList;

public class BestPermission {
    private static final String TAG = BestPermission.class.getSimpleName();

    private static PermissionCallBack permissionCallBack;
    private Activity activity;
    private ArrayList<String> permissions = new ArrayList<>();

    public BestPermission setPermissionCallBack(PermissionCallBack callBack) {
        permissionCallBack = callBack;
        return this;
    }

    public BestPermission addContext(Activity activity) {
        this.activity = activity;
        return this;
    }

    public BestPermission setPermission(ArrayList<String> permissions) {
        this.permissions = permissions;
        return this;
    }

    public void doApplyPermission() {
        //TODO check null
        new BestCheckPermission()
                .addContext(activity)
                .setPermission(permissions)
                .setPermissionCallBack(new PermissionCallBack() {
                    @Override
                    public void success() {
                        permissionCallBack.success();
                    }

                    @Override
                    public void failed(ArrayList<String> deniedPermissions) {
                        BestPermissionActivity.startApplyPermission(activity, deniedPermissions);
                    }
                })
                .doCheck();
    }

    public static PermissionCallBack getCallBack() {
        return permissionCallBack;
    }
}
