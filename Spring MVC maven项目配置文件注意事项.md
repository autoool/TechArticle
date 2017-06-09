## xml文件配置注意的几点：
 单元测试不需要在test路径下面单独配置web.xml和servlet.xml

### web.xml
* DispatcherServlet 配置 servlet.xml文件路径
* filter-mapping 配置接口访问后缀 .do
* contextConfigLocation 配置上下文 classpath:applicationContext-*.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:web="http://xmlns.jcp.org/xml/ns/javaee" xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd" version="2.4">
      <display-name>FantaseePayParam</display-name>
      <context-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:applicationContext-*.xml</param-value>
      </context-param>
      <listener>
            <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
      </listener>
      <filter>
            <filter-name>encoding</filter-name>
            <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
            <init-param>
                  <param-name>encoding</param-name>
                  <param-value>UTF-8</param-value>
            </init-param>
      </filter>
      <filter-mapping>
            <filter-name>encoding</filter-name>
            <url-pattern>*.js</url-pattern>
      </filter-mapping>
      <filter-mapping>
            <filter-name>encoding</filter-name>
            <url-pattern>*.do</url-pattern>
      </filter-mapping>
      <servlet>
            <servlet-name>FantaseePayParamServer</servlet-name>
            <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
            <init-param>
                  <param-name>contextConfigLocation</param-name>
                  <param-value>/WEB-INF/servlet.xml</param-value>
            </init-param>
            <load-on-startup>1</load-on-startup>
      </servlet>
      <servlet-mapping>
            <servlet-name>FantaseePayParamServer</servlet-name>
            <url-pattern>/</url-pattern>        
      </servlet-mapping>
      <session-config>
            <session-timeout>120</session-timeout>
      </session-config>
</web-app>
```
### servlet.xml  配置controller层扫描包名
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:aop="http://www.springframework.org/schema/aop" xmlns:jpa="http://www.springframework.org/schema/data/jpa"
      xmlns:mvc="http://www.springframework.org/schema/mvc"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
            http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
            http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd
            http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-3.0.xsd"
      default-lazy-init="true">
            
      <mvc:annotation-driven />
      <aop:aspectj-autoproxy />
      <context:annotation-config />
      <context:component-scan base-package="com.techidea.controller" />
      
      <!-- 定义加载properties文件的bean -->
<!--  <bean class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
            <property name="ignoreUnresolvablePlaceholders" value="true" />
            <property name="location" value="classpath:bpconfig.properties" />
      </bean> -->
      
      <mvc:resources location="/, classpath:/META-INF/resources/" mapping="/**"/>
      
      <mvc:default-servlet-handler/>
      
      <!-- 启动注解驱动的Spring MVC功能，注册请求url和注解POJO类方法的映射 -->
      <mvc:annotation-driven />
      <!-- <mvc:interceptors>
            <mvc:interceptor>
                  设置拦截的路径
                  <mvc:mapping path="/api/**/*.do" />
                  <bean class="com.techidea.mserver.springmvc.TokenCheckInterceptor"></bean>
            </mvc:interceptor>
            <mvc:interceptor>
                  设置拦截的路径
                  <mvc:mapping path="/api/**/*.do" />
                  <bean class="com.techidea .mserver.springmvc.DeviceCheckInterceptor"></bean>
            </mvc:interceptor>
            <mvc:interceptor>
                  设置拦截的路径
                  <mvc:mapping path="/jsapi/**/*.do" />
                  <bean class="com.techidea .mserver.springmvc.JSEncryptInterceptor"></bean>
            </mvc:interceptor>
      </mvc:interceptors> -->
      
</beans>
```
### applicationContext-datasource.xml 项目数据库配置
* 配置respository和service层扫描包名
* 配置jdbc.properties 数据库配置文件
* 在hibernate 的packagesToScan 配置 model层的包名路径
* hibernateProperties 配置字段可以配置是否自动创建数据库，不用手写建表语句
```
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
      xmlns:tx="http://www.springframework.org/schema/tx" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="
     http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
     http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
     http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-3.0.xsd
     http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
     http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
      
      <context:annotation-config />
      <context:component-scan base-package="com.techidea .repository" />
      <context:component-scan base-package="com.techidea .service" />
      
      <bean
            class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
            <property name="ignoreUnresolvablePlaceholders" value="true" />
            <property name="location" value="classpath:jdbc.properties" />
      </bean>
      <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource"
            destroy-method="close">
            <property name="driverClass" value="${database.driverClass}" />
            <property name="jdbcUrl" value="${database.jdbcUrl}" />
            <property name="user" value="${database.user}" />
            <property name="password" value="${database.password}" />
            <property name="autoCommitOnClose" value="true" />
            <property name="checkoutTimeout" value="${cpool.checkoutTimeout}" />
            <property name="initialPoolSize" value="${cpool.minPoolSize}" />
            <property name="minPoolSize" value="${cpool.minPoolSize}" />
            <property name="maxPoolSize" value="${cpool.maxPoolSize}" />
            <property name="maxIdleTime" value="${cpool.maxIdleTime}" />
            <property name="acquireIncrement" value="${cpool.acquireIncrement}" />
            <property name="maxIdleTimeExcessConnections" value="${cpool.maxIdleTimeExcessConnections}" />
      </bean>
      
      <bean id="sessionFactory" class="org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean">
            <property name="dataSource" ref="dataSource" />
            <property name="hibernateProperties">
                  <props>
                        <prop key="hibernate.dialect">org.hibernate.dialect.MySQL5InnoDBDialect</prop>
                        <prop key="hibernate.show_sql">false</prop>
                        <prop key="hibernate.hbm2ddl.auto">update</prop>
                  </props>
            </property>
            <property name="packagesToScan">
                  <list>
                        <value>com.techidea.model</value>
                  </list>
            </property>
      </bean>
      <bean id="hibernateTemplate" class="org.springframework.orm.hibernate3.HibernateTemplate">
            <property name="sessionFactory" ref="sessionFactory"></property>
      </bean>
</beans>
```

### applicationContext-projectname.xml 项目配置
* 配置repository层和service层的扫描包名路径

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
      xmlns:tx="http://www.springframework.org/schema/tx" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="
     http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
     http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
     http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-3.0.xsd
     http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
     http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
      
      <context:annotation-config />
      <context:component-scan base-package="com.techidea .repository" />
      <context:component-scan base-package="com.techidea .service" />
      
</beans>
```

### applicationContext-transaction-projectname.xml 数据库事务配置
* 数据库事务配置文件
* 事务切入点，注意配置到service层，具体原因还没有查是为什么要配置成这样？
因为一个Serveice可能会处理很多的逻辑， 会操作很多次数据库。 把事务放到Service层的话， 一旦出现异常， 之前操作的数据库数据都会回滚， 保证了数据的一致。
如果事务Repository层的话，某个地方出错了之前操作的数据库信息也不会回滚

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xmlns:aop="http://www.springframework.org/schema/aop"
      xmlns:tx="http://www.springframework.org/schema/tx" xmlns:jdbc="http://www.springframework.org/schema/jdbc"
      xmlns:context="http://www.springframework.org/schema/context"
      xsi:schemaLocation="
     http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-3.0.xsd
     http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans-3.0.xsd
     http://www.springframework.org/schema/jdbc http://www.springframework.org/schema/jdbc/spring-jdbc-3.0.xsd
     http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-3.0.xsd
     http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-3.0.xsd">
      <bean id="transactionManager" class="org.springframework.orm.hibernate3.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory" />
    </bean>
   
      <!-- 事务配置 -->
    <!-- 事件传播特性 -->
    <tx:advice id="txAdvice" transaction-manager="transactionManager">
            <tx:attributes>
                  <tx:method name="get*" read-only="true"/>
              <tx:method name="find*" read-only="true"/>
              <tx:method name="query*" read-only="true"/>
              <tx:method name="execute*" rollback-for="Exception" propagation="REQUIRED"/>
              <tx:method name="add*" rollback-for="Exception" propagation="REQUIRED"/>
              <tx:method name="update*" rollback-for="Exception" propagation="REQUIRED"/>
              <tx:method name="delete*" rollback-for="Exception" propagation="REQUIRED"/>
              <tx:method name="create*" rollback-for="Exception" propagation="REQUIRED"/>
              <tx:method name="change*" rollback-for="Exception" propagation="REQUIRED"/>
            </tx:attributes>
    </tx:advice>
   
    <!-- 事务切入点-->
    <aop:config proxy-target-class="true">
            <aop:pointcut id="serviceOperation" expression="(execution (* com.techidea .service.*..*(..)))"/>
            <aop:advisor advice-ref="txAdvice" pointcut-ref="serviceOperation"/>
    </aop:config>
      <bean id="transactionTemplate" class="org.springframework.transaction.support.TransactionTemplate">
        <property name="transactionManager" ref="transactionManager" />
    </bean>
</beans>
```

### jdbc.properties 数据库连接配置
* 数据库连接配置
* jdbc和jni配置不同
* jdbcUrl ip和端口后面紧跟数据库名

```xml &amp;lt;!--jdbc配置 样例--&amp;gt;
database.driverClass=com.mysql.jdbc.Driver
database.jdbcUrl=jdbc:mysql://127.0.0.1:3306/techidea_user?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&connectTimeout=0&socketTimeout=0&zeroDateTimeBehavior=convertToNull
database.user=admin
database.password=admin
hibernate.dialect=org.hibernate.dialect.MySQLDialect
cpool.checkoutTimeout=5000
cpool.minPoolSize=1
cpool.maxPoolSize=5
cpool.maxIdleTime=200
cpool.maxIdleTimeExcessConnections=180
cpool.acquireIncrement=2
```
### logback.xml 服务日志输出配置

* 文件名一定要命名正确，第一次因为命名不正确，花了不少时间查找日志不能输出的原因
* 不同环境包括测试，也都要配置对应的文件
* 不同分支里面变量命名和日志输出路径也要不同

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>
      <property name="LOG_HOME" value="D://logs" />
      <property name="PROJECT" value="TECHIDEA_LOG" />
      
      <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <encoder class="ch.qos.logback.classic.encoder.PatternLayoutEncoder">
                  <Pattern>[TECHIDEA MSERVER] %d{yyyy-MM-dd HH:mm:ss.SSS} %-5level %logger{80} - %msg%n</Pattern>
            </encoder>
      </appender>
      
      <appender name="FILE" class="ch.qos.logback.core.rolling.RollingFileAppender">  
        <Encoding>UTF-8</Encoding>  
        <rollingPolicy class="ch.qos.logback.core.rolling.TimeBasedRollingPolicy">
            <FileNamePattern>${LOG_HOME}/${PROJECT}.%d{yyyy-MM-dd}.log</FileNamePattern>  
            <MaxHistory>30</MaxHistory>
        </rollingPolicy>  
        <layout class="ch.qos.logback.classic.PatternLayout">
            <pattern>%d{yyyy-MM-dd HH:mm:ss.SSS} [%thread] %-5level %logger{50} - %msg%n</pattern>  
       </layout>
       <!-- <triggeringPolicy class="ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy">
           <MaxFileSize>10MB</MaxFileSize>
       </triggeringPolicy> -->
    </appender>
      
      <root>
            <level value="INFO" />
            <appender-ref ref="STDOUT" />
      </root>
      <logger name="com.techidea" level = "DEBUG">
            <appender-ref ref="FILE" />
      </logger>
</configuration>
```
