package com.smart.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.plugin2.main.server.Plugin;

import java.util.List;
import java.util.Map;

/**
 * @Author:
 * @Description: 对集合类进行标注
 * @Date:Created in 18:29 2019/4/29
 * @Modified By:
 */
@Component
public class MyComponent {

    //Spring将容器中所有类型为Plugin的Bean注入到此变量中

    @Autowired(required = false)
    private List<Plugin> plugins;

    //将Plugin类型的Bean注入到Map中

    private Map<String,Plugin> pluginMaps;

    public List<Plugin> getPlugins(){
        return plugins;
    }

}
