# 闭包
闭包就是能够读取其他函数内部变量的函数。
由于在Javascript语言中，只有函数内部的子函数才能读取局部变量，因此可以把闭包简单理解成"定义在一个函数内部的函数"。
最大用处：
1.是前面提到的可以读取函数内部的变量，
2.就是让这些变量的值始终保持在内存中。
使用闭包注意点：
1）由于闭包会使得函数中的变量都被保存在内存中，内存消耗很大，所以不能滥用闭包，否则会造成网页的性能问题，在IE中可能导致内存泄露。解决方法是，在退出函数之前，将不使用的局部变量全部删除。

2）闭包会在父函数外部，改变父函数内部变量的值。所以，如果你把父函数当作对象（object）使用，把闭包当作它的公用方法（Public Method），把内部变量当作它的私有属性（private value），这时一定要小心，不要随便改变父函数内部变量的值。

        For every closure we have three scopes:-
    
        Local Scope ( Own scope)
        Outer Functions Scope
        Global Scope


        
http://www.ruanyifeng.com/blog/2010/05/object-oriented_javascript_encapsulation.html
* 面向对象编程
  - 封装
    - 构造函数方式：浪费内存

    - Prototype模式：每一个构造函数都有一个prototype属性，指向另一个对象。这个对象的所有属性和方法，都会被构造函数的实例继承。
      构造函数模式

      isPrototypeOf()

      hasOwnProperty();是本地属性还是继承属性

      in 某个实例是否包含某个属性

  - 构造函数的继承

    - 
