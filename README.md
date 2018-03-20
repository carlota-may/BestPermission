
BestPermission
====

This is a library which is about permission.

Install
-------  
 **gradle**
 
Step 1.Add it in your root build.gradle at the end of repositories:
 ```Groovy
 allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
 ```
 Step 2. Add the dependency
 ```Groovy
 dependencies {
	        compile 'com.github.SmallMay:BestPermission:v1.0.0'
	}

 ```
 **maven**
 Step 1
 ```Java
 <repositories>
		<repository>
		    <id>jitpack.io</id>
		    <url>https://jitpack.io</url>
		</repository>
	</repositories>
 ```
 Step 2. Add the dependency
 ```Java
 <dependency>
	    <groupId>com.github.SmallMay</groupId>
	    <artifactId>BestPermission</artifactId>
	    <version>v1.0.0</version>
	</dependency>
 ```

Design
-------  
![design](https://github.com/SmallMay/BestPermission/blob/master/design.gif)
 
Check permission
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

Apply permission
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

License
 -------  
>**MIT License**
>
>Copyright (c) 2018 May
>
>Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 
