package com.zxm.bestpermission.callback;

import java.util.ArrayList;

public interface PermissionCallBack {
    void success();

    void failed(ArrayList<String> deniedPermission);

}