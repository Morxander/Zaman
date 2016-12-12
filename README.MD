# Zaman
[![GPL](https://img.shields.io/aur/license/yaourt.svg)]()

The library provides a custom `TextView` and  `Helper` for Android to convert `timestamp` to time `String`.
The library also provides a `singleton` thread that automatically updates the `TextView` .
`Zaman` also provides a helper that returns the relative time according to the `timestamp` sent.
`Zaman` means `Time` in `Arabic` and we named it that since our library works with time and the developers first language is `Arabic`.

### Screenshot
![Zaman](https://raw.githubusercontent.com/Morxander/Zaman/master/screenshot.png)

### Download

Download via Gradle:

```gradle
compile 'morxander.zaman:Zaman:1.0.0'
```

### Usage
#### Using ZamanTextView
```xml
<morxander.zaman.ZamanTextView
        android:id="@+id/ztv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
```

In activity class:
```java
ZamanTextView ztv = (ZamanTextView) findViewById(R.id.ztv);
ztv.setTimeStamp(1481554570);
```

#### Using ZamanUtil ( The Helper )

```java
ZamanUtil zamanUtil = new ZamanUtil(1481554570);
zamanUtil.getTime(); // Returns the time string
```


### License 
GNU GENERAL PUBLIC LICENSE 3

