package com.example.pro3;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class FixedSizeQueue<E> {
    private final Queue<E> queue;
    private final int maxSize;

    public FixedSizeQueue(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("크기는 0보다 커야 합니다.");
        }
        this.maxSize = size;
        this.queue = new ArrayDeque<>(size);
    }

    public void add(E element) {
        if (queue.size() == maxSize) {
            queue.poll();
        }
        queue.offer(element);
    }

    public List<E> getElementsAsList() {
        return Collections.unmodifiableList(new ArrayList<>(queue));
    }

    public int size() {
        return queue.size();
    }
}
