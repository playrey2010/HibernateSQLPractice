# Basic-Spring-MVC
Spring MVC Demo based on Maven Web application archetype. <br>
Manually configured the Spring Dispatcher Servlet in web.xml file, and the view resolver in the spring...-servlet.xml file. <br>
Finally, configured the Controller in a custom HelloController java class.
### web.xml

```
<display-name>Spring MVC Application</display-name>

    <!-- Step 1: Configure Spring MVC Dispatcher Servlet -->
    <!-- Refer to our diagram on what the Front Controller does -->
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>/WEB-INF/spring-mvc-demo-servlet.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <!-- Step 2: Set up URL mapping for Spring MVC Dispatcher Servlet -->
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
```

### spring-mvc-demo-servlet.xml
```
    <context:component-scan base-package="com.example"/>
    <!-- Add support for conversion, formatting, and validation -->
    <mvc:annotation-driven/>
    <!-- Define the Spring MVC view resolver -->
    <!-- In other words, where the page is located -->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp" />
    </bean>

```
### HelloController.java
```
package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HelloController {

    @RequestMapping("/")
    public String showPage(Model model){
        model.addAttribute("message", "Oh yeah!");
        return "hello_world";
    }

}
```
