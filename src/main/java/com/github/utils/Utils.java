/*
 * Copyright 2019-2119 gao_xianglong@sina.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author gao_xianglong@sina.com
 * @version 0.1-SNAPSHOT
 * @date created in 2021/1/17 12:05 上午
 */
public class Utils {
    public static void printSchedule(double value) {
        var percent = (int) value;
        int length = Constants.TOTLE_LENGTH;
        // 清空前一次的控制台输出
        for (var i = 0; i < length + 10; i++) {
            System.out.print("\b");
        }
        System.out.print("[");
        // 字符'='的数量等于百分比
        for (var i = 0; i < percent; i++) {
            System.out.print("=");
        }
        System.out.print(">");
        // 空位补空格占位
        for (var i = 0; i < length - percent; i++) {
            System.out.print(" ");
        }
        System.out.print("]");
//        System.out.print(String.format(" %s", (percent >= 99 ? 100 : percent) + "%"));
        System.out.print(String.format(" %s", percent + "%"));
    }

    /**
     * 字符转字节
     *
     * @param chars
     * @return
     */
    public static byte[] toBytes(char[] chars) {
        Charset cs = Charset.forName(Constants.CHARSET);
        CharBuffer cb = CharBuffer.allocate(chars.length);
        cb.put(chars);
        cb.flip();
        ByteBuffer bb = cs.encode(cb);
        return bb.array();
    }

    /**
     * 字节转字符
     *
     * @param bytes
     * @return
     */
    public static char[] toChars(byte[] bytes) {
        Charset cs = Charset.forName(Constants.CHARSET);
        ByteBuffer bb = ByteBuffer.allocate(bytes.length);
        bb.put(bytes).flip();
        CharBuffer cb = cs.decode(bb);
        return cb.array();
    }
}
