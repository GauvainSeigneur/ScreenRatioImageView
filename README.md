# ScreenRatioImageView
An extend of ImageView Class which has two parameters which allows to set height and width in percentage of the parent layout pixel dimension

![alt text](screenshot/Screenshot_20170204-232612.png "screenshot")

In this screenshot, the ImageView has these parameters :
```xml
<com.example.gauvain.screenratioimageview.ScreenRatioImageView
    android:src="@drawable/solo_cover_13"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:scaleType="centerCrop"
    custom:ScreenWidthPercent="50"
    custom:ScreenHeightPercent="75"/>

