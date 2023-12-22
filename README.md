# CardManagementSystem
J2EE大作业，名片管理系统

错误1：
controller找不到跳转页面：没有申请servlet，在web种声明servlet就好了

错误2：
不知道怎么同时加载两个mapper：
```   
 <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="mapperLocations">
            <list>
                <value>classpath:UserMapper.xml</value>
                <value>classpath:CardMapper.xml</value>
            </list>
        </property>
        <property name="configLocation" value="classpath:mapper-config.xml"/>
    </bean>
 ```
用list就好

