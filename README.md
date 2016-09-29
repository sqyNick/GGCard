GGCard
===
the project is the first one that I try to publish in Github. All I want to do is Just to test the use of JitPack. Finally,the truth told me that the JitPack is such a good tool.Next I will show you a simple example that I did.
----------------------------------------------------------------------------------------------------------------------------------------
+Step 1:
 add  'maven { url "https://jitpack.io" }' as follow in your root project build.gradle
```java
allprojects {
        repositories { 
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
+Step 2:
 add 'compile 'com.github.sqyNick:GGCard:v1.0.0' in your app build.gradle
 ```java 
 compile 'com.github.sqyNick:GGCard:v1.0.0 
 ```
 After doing tha ,you can use GGCard as follow:
 	1.xml:
	```java
	 <com.example.androidstepdemo.view.GGCard
         android:layout_width="match_parent"
         android:layout_height="300dp"
         android:id="@+id/ggcard"
          />
	  ```
	2.java
	```java
	GGCard gg = (GGCard) findViewById(R.id.ggcard);
	//set the background-image of the GGCard
        gg.setBackgroundPicture(BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher)); 
	//set the width of the paint
        gg.setPaintStrokeWidth(20);
	```
		
After all of that ,you will see :<br>
![github](https://github.com/sqyNick/GGCard/blob/master/android_ggcard.gif)

 

