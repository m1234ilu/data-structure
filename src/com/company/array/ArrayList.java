package com.company.array;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 动态数组
 *
 * @author zycstart
 * @create 2020-05-23 15:44
 */
public class ArrayList<E> implements Serializable {
    private static final long serialVersionUID = -5721508243584274382L;

    /**
     * 默认初始容量
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 元素的数量
     */
    private int size;

    /**
     * 所有元素
     */
    private E[] elements;

    /**
     * 指定容量构造方法，和源码实现上有区别，源码是判断初始容量是否大于0，大于0 初始化，小于0抛异常，等于0初始空object数组
     *
     * @param initialCapacity 动态数组初始容量
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > DEFAULT_CAPACITY) {
            this.elements = (E[]) new Object[initialCapacity];
        } else if (initialCapacity <= DEFAULT_CAPACITY) {
            this.elements = (E[]) new Object[DEFAULT_CAPACITY];
        }
    }

    public ArrayList() {
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
//        this(DEFAULT_CAPACITY);
    }

    /**
     * 在末尾添加元素
     *
     * @param element
     * @return
     */
    public boolean add(E element) {
        ensureCapacityInternal(size + 1);
        elements[size++] = element;
        return true;
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    /**
     * 保证要有minCapacity容量
     *
     * @param minCapacity 最小容量
     */
    private void ensureCapacityInternal(int minCapacity) {
        int oldCapacity = elements.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            elements = Arrays.copyOf(elements, newCapacity);
//            int[] newCapacityElements = new int[newCapacity];
//            for (int i = 0; i < elements.length; i++) {
//                newCapacityElements[i] = elements[i];
//            }
//            elements = newCapacityElements;
            System.out.println("旧容量：" + oldCapacity + "，扩容为：" + newCapacity);
        }
    }

    /**
     * 清除所有元素
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        //只要size为0，就拿不到元素，通过get和set无法访问到。对使用者来说，就是清除了，即语义正确，不用关心接口内部实现
        size = 0;
    }

    /**
     * 返回元素数量
     *
     * @return 元素数量
     */
    public int size() {
        return size;
    }

    /**
     * 判断元素是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size; i++) {
            stringBuilder.append(elements[i]).append(",");
        }
        return "ArrayList{" +
                "size=" + size +
                ", elements={" +
//                Arrays.toString(elements)
                stringBuilder.substring(0, stringBuilder.length() - 1)
                +
                '}';
    }

    /**
     * 返回指定元素在集合中第一次出现的下标（索引）
     *
     * @param element
     * @return
     */
    public int indexOf(E element) {
        //注意对象可能为空
        if (element == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                //如果对象没有重写equals方法，默认是比较内存地址
                //Integer内部重写equals方法，比较的是值，不是地址
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 判断集合是否包含指定元素
     *
     * @param element
     * @return
     */
    public boolean contains(E element) {
        return indexOf(element) >= 0;
    }

    /**
     * 获取集合中指定位置的元素
     *
     * @param index 索引
     * @return
     */
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    /**
     * 根据指定的索引删除元素并返回删除的元素
     *
     * @param index 元素下标
     * @return 被删除的元素
     */
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = elements[index];
        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        //提醒垃圾回收器工作
        elements[--size] = null;
        return oldValue;
    }

    /**
     * 移除首次出现的元素
     *
     * @param element   元素
     * @return
     */
    public void remove(E element) {
        remove(indexOf(element));
    }

    /**
     * 替换指定位置的元素并返回原先的元素
     *
     * @param index
     * @param element
     * @return 返回原先位置的元素
     */
    public E set(int index, E element) {
        rangeCheck(index);

        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    /**
     * 检查给定的下标是否越界
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
