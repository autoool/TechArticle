## CSS  层叠样式表

网页表现和内容分离

- 三种样式写法：
  外链样式  link
  页内样式  style
  行内样式  style

基础选择器

- 四种
- 标签选择器  直接写标签
- class选择器  . 点 

```
class="name1 name2"
class="name1"
```

- id选择器  # 
```
id="title"
```
class可以写两个，id不能写多个。只能class和id共存的方式去处理
- 通用选择器  *{}

- 两种复合选择器
- 后代选择器
```
ol li 标签选择
class 后代选择: .out .box 
```
- 编组选择器
  h1,h2,h3,.box
- 伪类选择器
```
：link初始样式
visited 已访问后样式
hover 鼠标移入时样式
active活动样式
```

- 文本类型
- 文本样式  font-family:"","","" 多个字体逗号隔开
  font-szie
  font-weight

背景样式：
background-image：url(路径)
background-repest:no-repeat
background-position :x:    lecft center right  y:  top center botttom
设置背景固定

添加浮动

