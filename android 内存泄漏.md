### android studio lint 检测：

- should pass resolved pixel dimension instead of resource id here

- missing contentDescription attribute on image

- android:drawableTintMode="src_atop"  image着色使用

都有哪些Tint？

根据控件不同，其xml属性中或多或少会有：

android:tint=""

android:backgroundTint=""

android:foregroundTint=""

android:drawableTint="" （TextView用来着色附加drawable的）
相应的，着色时有多种可选模式，相应的有这些属性：

android:tintMode=""

android:backgroundTintMode=""

android:foregroundTintMode=""

android:drawableTintMode=""
模式共有六种：

add：两层绘制叠加融合

multiply：取两层绘制的交集

screen：上下层都显示（就像是多了块tint色的玻璃）

src_atop：

src_in：取交集，显示上层

src_over：tint色覆盖住图片，都显示

作者：森与渊
链接：http://www.jianshu.com/p/563165534bc2
來源：简书
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。


- implicitly using the default locale is a common source of bugs

- -avoid passing ‘null’ as the view root
- grows due to localized text expansion
- at least one activty with an action-view intent filter 
- avoid object allocations during draw/layout operations()
- android:baslineAligned  linearLayout 组件基线对齐
- comment ==null is always false
- setDisplayShowTitleEnabled may produce nullpointerException
     if (null != activity.getSupportActionBar()) { activity.getSupportActionBar().setDisplayShowTitleEnabled(false);
        }

## 内存泄漏
inputmethodmanager.mNextServerdView 内存泄漏