# CellAdapter

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![](https://jitpack.io/v/erva/CellAdapter2.svg)](https://jitpack.io/#erva/CellAdapter2)

![GitHub Logo](/images/ic_launcher.png)

This library simplifies RecyclerView with multiple view types.
Main points:

* Single adapter class for all project
* Easy to use - just register Cell, Model and ClickListener (optional) in adapter
* Listen clicks on any View of any type
* Use view binding
* For Java / Kotlin and *androidx.recyclerview*/*support:recyclerview-v7* see [CellAdapter 1](https://github.com/erva/CellAdapter)

No more code like this:
```java
companion object {
    const val VIEW_TYPE_ONE = 1
    const val VIEW_TYPE_TWO = 2
    }

if (viewType == VIEW_TYPE_ONE) {
    return View1ViewHolder()
} else {
    eturn View2ViewHolder(
}
```

## Usage

### Kotlin
```java
private var cellAdapter: CellAdapter = CellAdapter().apply {
    cell(
        cell = AlphaCell::class,
        binding = ItemAlphaBinding::class.java,
        model = AlphaModel::class,
        listener = object : Listener<AlphaModel> {
            override fun onCellClicked(item: AlphaModel) { }
        }
    )
    cell(
        cell = BetaCell::class,
        binding = ItemBetaBinding::class.java,
        model = BetaModel::class
        // listener may be not provided
    )
}
```

    
where
`AlphaCell::class` is POJO and `AlphaCell::class` is
```java
class AlphaCell(private val binding: ItemAlphaBinding) :
Cell<AlphaModel, ItemAlphaBinding, Listener<AlphaModel>>(binding) {

    override fun bindView() {
        val item = item()
        binding.tvAlpha.text = item.alpha
    }
}
```

Check samples for details.

### Samples and hints
* [`Code sample`](https://github.com/erva/CellAdapter2/tree/master/sample/src/main/java/io/erva/celladapter2) 

## Versions

### 1.0.0 
Initial version

## Download

Add the JitPack repository in your root build.gradle at the end of repositories:
```groovy
allprojects {
    repositories {
        maven { url "https://jitpack.io" }
    }
}
```
Add the dependency:
```groovy
dependencies {
    implementation "com.github.erva.CellAdapter2:celladapter:1.0.0"
}
```

## Proguard

```
-dontwarn io.erva.celladapter2.**
-keep public class kotlin.reflect.jvm.internal.impl.builtins.* { public *; }
-keepclassmembers class * extends io.erva.celladapter2.** {
    <init>(android.view.View);
}
```

## License

 CellAdapter is licensed under the [MIT License](http://opensource.org/licenses/MIT).

-------

<div>Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="http://www.flaticon.com" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>
