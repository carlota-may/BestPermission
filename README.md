BestPermission
====

This is a library which is about permission.
```//TODO  add tag```

###Install
 -------  

###Design
 -------  

###How to use
-------  
#####check permission
 -------  
```Java
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
 -------  
```Java
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
 -------  
>**MIT License**
>
>Copyright (c) 2018 May
>
>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 
