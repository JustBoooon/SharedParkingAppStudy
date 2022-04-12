/*
 * Copyright (C) 2018 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.xuexiang.xhttp2.callback.impl;

import java.lang.reflect.Type;

/**
 * 获取类型接口
 *
 * @author xuexiang
 * @since 2018/5/23 上午10:45
 */
public interface IType<T> {

    /**
     * @return 获取需要实际解析的类型
     */
    Type getType();

    /**
     * @return 获取最顶层的类型
     */
    Type getRawType();

}
