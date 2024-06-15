package Clases;

import java.util.PriorityQueue;
import Interfaces.IHeap;

public class MinHeap implements IHeap {
    private PriorityQueue<Edge> heap;

    public MinHeap() {
        heap = new PriorityQueue<>();
    }

    @Override
    public void push(Edge a) {
        heap.add(a);
    }

    @Override
    public void pop() {
        heap.poll();
    }

    @Override
    public Edge first() {
        return heap.peek();
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
