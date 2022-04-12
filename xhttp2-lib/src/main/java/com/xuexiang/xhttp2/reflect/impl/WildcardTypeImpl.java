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

package com.xuexiang.xhttp2.reflect.impl;

import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;
import java.util.Arrays;

/**
 * 通配符类型
 *
 * @author xuexiang
 * @since 2018/6/21 上午12:27
 */
public class WildcardTypeImpl implements WildcardType {
    private final Class[] upper;
    private final Class[] lower;

    public WildcardTypeImpl(Class[] lower, Class[] upper) {
        this.lower = (lower != null ? lower : new Class[0]);
        this.upper = (upper != null ? upper : new Class[0]);
        checkArgs();
    }

    private void checkArgs() {
        if (lower.length == 0 && upper.length == 0) {
            throw new IllegalArgumentException("lower or upper can\'t be null");
        } else {
            checkArgs(lower);
            checkArgs(upper);
        }
    }

    private void checkArgs(Class[] args) {
        for (int i = 1; i < args.length; ++i) {
            Class clazz = args[i];
            if (!clazz.isInterface()) {
                throw new IllegalArgumentException(clazz.getName() + " not a interface!");
            }
        }

    }

    @Override
    public Type[] getUpperBounds() {
        return upper;
    }

    @Override
    public Type[] getLowerBounds() {
        return lower;
    }

    @Override
    public String toString() {
        return upper.length > 0 ? (upper[0] == Object.class ? "?" : getTypeString("? extends ", upper)) : getTypeString("? super ", lower);
    }

    private String getTypeString(String suffix, Class[] type) {
        StringBuilder sb = new StringBuilder();
        sb.append(suffix);

        for (int i = 0; i < type.length; ++i) {
            if (i != 0) {
                sb.append(" & ");
            }

            sb.append(type[i].getName());
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && o instanceof WildcardTypeImpl) {
            WildcardTypeImpl that = (WildcardTypeImpl) o;
            return Arrays.equals(upper, that.upper) && Arrays.equals(lower, that.lower);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(upper);
        result = 31 * result + Arrays.hashCode(lower);
        return result;
    }
}
