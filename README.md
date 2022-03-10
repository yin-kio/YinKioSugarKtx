# YinKioSugarKtx - observing is simple!

This is an extensions kit for kotlin Android.

[![](https://jitpack.io/v/JamyCake/YinKioSugarKtx.svg)](https://jitpack.io/#JamyCake/YinKioSugarKtx)

## Dependency

This section explains how to add dependency to your project.

### Gradle

1. add repository
```
    on project level build.gradle
    
    allprojects {
      repositories {
        ...
        maven { url 'https://jitpack.io' }
      }
    }
    
    or in settings.gradle
    
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
    
```
2. add dependency
```
    dependencies {
            implementation 'com.github.xYinKio:YinKioSugarKtx:0.02-alpha'
    }
```

## Contents

1. Extensions for simpler getting colors and resources from View, Fragment, ViewBinding
2. Extensions for simpler working sith coroutines, such as ```onIO()```, ```onMain()``` and so on
3. Very simple recycler adapter builder
4. Extensions for simpler observing LiveData and FLows

## How to use

This section shows how to use some of non obviously functions

### ```recyclerAdapter()```

Returns a standard ListAdapter

```
        recyclerAdapter<Item, ItemBinding>(
            onBind = {item, holder ->
                textView.text = item.text
            },
            areItemsTheSame = {old, new -> old.text == new.text}, // optional
            areContentsTheSame = {old, new -> old == new} // optional
        )
```

