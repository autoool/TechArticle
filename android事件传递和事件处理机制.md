![img](./images/decorview.png)

点击事件发生的x和y坐标。系统提供了两组方法：

getX/getY 和 getRawX/getRawY。她们的区别很简单，

getX/getY返回的是相对于当前View左上角的x和y坐标，而getRawX/getRawY返回的是相对于手机屏幕左上角的x和y坐标



- 事件分发传递：从最高层到最底层自己布局的View

dispatchTouchEvent实现事件的分发，onInterceptTouchEvent实现事件拦截。

返回true 拦截，不继续传递。返回false，继续向下传递，我不拦截。

- 事件处理传递：从自己布局的View到最高层

onTouchEvent实现事件处理

返回true，事件处理完成，上层View就不用处理了。返回false，交由上层处理。

## 事件分发机制
View

ViewGroup
