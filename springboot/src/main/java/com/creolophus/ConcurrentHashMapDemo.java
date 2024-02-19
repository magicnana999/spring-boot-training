/*
 * Copyright (c) 2024 magicnana999@gmail.com.
 * MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

package com.creolophus;



 /**
 * @author magicnana999@gmail.com
 * @date 2024/2/12 00:26
 */
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapDemo {

 public static void main(String[] args) {
  // 创建一个 ConcurrentHashMap 实例
  ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

  // 定义一个键
  String key = "exampleKey";

  // 使用 computeIfAbsent 方法
  // 如果键不存在，则使用提供的函数计算新值并插入到映射中
  // 如果键已存在，则不会执行计算并返回当前值
  String value = map.computeIfAbsent(key, k -> {
   // 这里模拟计算新值的逻辑
   // 在实际应用中，这里可能是复杂的计算或数据库查询等
   return "computedValueFor" + k;
  });

  // 输出结果
  System.out.println("Value for key '" + key + "': " + value);

  // 尝试获取同一个键的值，此时值应该已经存在
  value = map.get(key);
  System.out.println("Value for key '" + key + "' after get: " + value);

  // 再次使用 computeIfAbsent，这次不会计算新值因为键已经存在
  value = map.computeIfAbsent(key, k -> {
   // 这个 lambda 表达式不会执行，因为键已经存在
   return "thisWillNotBeUsed";
  });

  // 输出结果，值应该还是之前的值
  System.out.println("Value for key '" + key + "' after second computeIfAbsent: " + value);
 }
}
