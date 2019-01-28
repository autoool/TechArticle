### 空指针与类型安全

1. 几个标识  ？   ！  ？： 

- 当某个变量可以为null时候，类型后面必须使用？来标识该引用可以为空

- if not null 简写方式 file?.size  如果file不为null，读取size 属性

- if not null and else 缩写   file?.size?:"empty"      如果file.size 为null 则返回 empty

- if null 执行一个语句 

  		val values = ....

  		val email = vaues["email"]?: throw Exception()

- if null 执行代码

  		val value = ...

  		value?.let{

  		}

- try catch 

- 可为空的boolean   var b:Boolean?= false

### 基础类型

1. 字符串拼接，尽量使用字符串模板，不要用+ 

字符不是数字。

类型判断使用  is

类型之间转换必须显示转换

字符串使用String 类型表示，字符串不可变。

创建单例使用object 关键字

object Resource{

}



### 类与继承

- 构造函数分为主构造函数和多个次构造函数

主构造函数：

		class Person(name:String,age:Int){

		}

次构造行数：

class Person(val name:String){

constructor(name:String,parent:Person):this(name){

}

}

- 显式声明超类

open class Base()

如果主类没有构造函数，每个次构造函数必须使用super 关键字初始化其基类型

class MyView:View{

	constructor(cts:Context):super(ctx)

	constructor(ctx:Context,attrs:AttributeSet):super(ctx,attrs)

}

- 覆盖方法  覆盖属性
- 子类，初始化顺序需要注意
- 抽象类

abstract class Derived:Base(){

	override abstract fun f()

}

- 派生对象
- 属性与字段

1. 幕后属性
2. 编译期常量 const val 
3. 延迟初始化属性与变量  lateinit

是否已经初始换判断 isInitialized

- 数据类 data class  必须至少有一个参数的构造函数
- 密封类 sealed class  ,当一个值为有限的集中类型，而不能有任何其他类型。













