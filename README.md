### BestPermission
This is a library which is about permission.
```//TODO  add tag```

###Install

###design 

###How to user

#####check permission
```
 new BestCheckPermission()
                .addContext(this)
                .setPermission(permissions)
                .setPermissionCallBack(new PermissionCallBack() {
                    @Override
                    public void success() {

                    }

                    @Override
                    public void failed(ArrayList<String> deniedPermission) {

                    }
                }).doCheck();
```

#####apply permission
```
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
```

###License
