# PicassoImageLibrary

#Picasso is an image library for Android. It's created and maintained by Square, and caters to image loading and processing. It simplifies the process of displaying images from external urls and display on your application.
downloading an image from server and create automatic memory and disk caching.

#Large image convert with minimal memory use.

#What you can do with Picasso Library
  Disk and Memory Caching, Rotation and Transformation, Resizing and Scaling, Setting the Placeholder and Error images, Fading,
  Center Cropping, Priority Requests.
  
#How to implement Picasso Library in Android Studio  
  1.Add Picasso Library in "build.gradle"
      
      dependencies {
    compile "com.squareup.picasso:picasso:2.4.0"
       }
     
  2.And sync your project.
  
  3.Simple method of Picasso
  
        Picasso.with(this).load("http://scificoder.com/scifi-coder.PNG")
                .error(R.drawable.error)
                .placeholder(R.drawable.default_opt)
                .resize(400, 400)
                .into(iv);
                
   4.Add internet permission in your AndroidManifest.xml 
   
        <uses-permission android:name="android.permission.INTERNET"/>

5.
  ![alt text](https://github.com/Alok255/PicassoImageLibrary/blob/master/picasso_library.jpeg?raw=true)
    
