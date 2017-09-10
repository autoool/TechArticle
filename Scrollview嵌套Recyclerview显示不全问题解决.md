项目中遇到页面整体需要可以垂直方向滑动，页面内部嵌套一个或者多个recyclerview的情况（不管是横向还是竖向的列表），竖向的recyclerview不需要滑动，横向可以滑动。很自然的想到scrollview嵌套recyclerview去实现，但是由于一些细节不了解，会出现recyclerview item显示不全的情况，甚至是不显示。

有几种情况：

1. 使用Theme.AppCompat.Light.DarkActionBar 主题，scrollview嵌套recyclerview
2. 使用Theme.AppCompat.Light.DarkActionBar 主题，nestedscrollview嵌套recyclerview
3. 使用Theme.AppCompat.Light.NoActionBar 主题，scrollview嵌套recyclerview
4. 使用Theme.AppCompat.Light.NoActionBar 主题，nestedscrollview嵌套recyclerview

第一种情况会显示不全，解决办法如下：
scrollview 增加属性android:fillViewport="true" ，因为滑动控件scrollview和NestedScrollView 的子控件，必须由一个ViewGroup包裹，目前使用LinearLayout，需要在这个ViewGroup增加属性android:focusable="true"android:focusableInTouchMode="true"。
最后覆写recyclerview的canScrollVertically 方法返回false。

第二种情况recyclerview显示正常。

第三种情况会出现页面打开自动向上滑动一段距离的现象，就算做了第一种情况的处理，recyclerview仍然显示不全。只好把scrollview替换为nestedscrollview，变成第四种情况去解决。

第四种情况会出现页面打开自动向上滑动一段距离的现象，解决办法同第一种情况。




