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

错误3：
要跳到某个业务的页面必须重定向比如：
```
 return "redirect:/card/list";
 而不是
 return "index";
```



传参方法：
在 Spring MVC 中，可以使用 RedirectAttributes 来传递数据到重定向的页面。RedirectAttributes 是 Spring 提供的一个用于在重定向时传递参数的工具类。
以下是修改你的代码以传递 username 到重定向页面的示例：
```
 redirectAttributes.addAttribute("username", username);

        // 重定向到index.jsp页面
        return "redirect:/card/list";
```
接收方：
```
@RequestMapping("/list")
public String list(@RequestParam(value = "username", defaultValue = "defaultUsername") String user, Model model, HttpSession session){
    // ... 其他代码
}
```

错误4
后端的参数名字id应该和前端?id一致
```
<a href="${pageContext.request.contextPath}/card/deleteCard?id=<%=card.getCard_id()%>">删除</a>
```

错误5：
查询时，不可以long和String的一起，不然会混淆识别（错误演示）：
```
 List<Card> searchResults =cardService.findCardLikeUsername(query);
        searchResults.addAll(cardService.findCardLikePhone(Long.valueOf(query)));  //这里不可以和String一起
        searchResults.addAll(cardService.findCardLikeName(query));
        searchResults.addAll(cardService.findCardLikeE_mail(query));
        searchResults.addAll(cardService.findCardLikeTitle(query));
        searchResults.addAll(cardService.findCardLikeWorkplace(query));
        searchResults.addAll(cardService.findCardLikeAddress(query));
```
正确：
```
        List<Card> searchResults =new ArrayList<>();
        int flag=0;
        try{
            searchResults.addAll(cardService.findCardLikePhone(Long.valueOf(query)));
            searchResults.addAll(cardService.findCardLikeUsername(query));
        }catch (NumberFormatException e){
            flag=1;
        }
        // 根据用户名查询名片
        if(flag==1){
            searchResults.addAll(cardService.findCardLikeUsername(query));
            searchResults.addAll(cardService.findCardLikeName(query));
            searchResults.addAll(cardService.findCardLikeE_mail(query));
            searchResults.addAll(cardService.findCardLikeTitle(query));
            searchResults.addAll(cardService.findCardLikeWorkplace(query));
            searchResults.addAll(cardService.findCardLikeAddress(query));
        }

```


