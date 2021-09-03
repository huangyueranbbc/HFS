package org.hyr.hfs.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*******************************************************************************
 * @date 2019-06-26 13:42
 * @author: <a href=mailto:@huang>黄跃然</a>
 * @Description:
 ******************************************************************************/
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface RpcService {

    //实现接口
    Class<?> value();

}
