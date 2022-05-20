#CellAdapter2
-dontwarn io.erva.celladapter2.**
-keep public class kotlin.reflect.jvm.internal.impl.builtins.* { public *; }
-keepclassmembers class * extends io.erva.celladapter2.** {
    <init>(android.view.View);
}