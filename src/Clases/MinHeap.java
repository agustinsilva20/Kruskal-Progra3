package Clases;

import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

import Interfaces.IHeap;

public class MinHeap implements IHeap {
    //private PriorityQueue<Edge> heap;
	private ArrayList<Edge> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    @Override
    public void push(Edge a) {
        heap.add(a);
        heapifyUp(heap.size() - 1);
    }

    @Override
    public void pop() {
        if (heap.size() == 0) {
            return;
        }
        Edge lastElement = heap.remove(heap.size() - 1);
        if (heap.size() > 0) {
            heap.set(0, lastElement);
            heapifyDown(0);
        }
    }

    @Override
    public Edge first() {
        if (heap.size() == 0) {
            return null;
        }
        return heap.get(0);
    }

    @Override
    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapifyUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parentIndex)) < 0) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown(int index) {
        int leftChild, rightChild, smallestChild;
        while ((leftChild = 2 * index + 1) < heap.size()) {
            rightChild = leftChild + 1;
            smallestChild = leftChild;
            
            if (rightChild < heap.size() && heap.get(rightChild).compareTo(heap.get(leftChild)) < 0) {
                smallestChild = rightChild;
            }
            
            if (heap.get(index).compareTo(heap.get(smallestChild)) > 0) {
                swap(index, smallestChild);
                index = smallestChild;
            } else {
                break;
            }
        }
    }

    private void swap(int index1, int index2) {
        Edge temp = heap.get(index1);
        heap.set(index1, heap.get(index2));
        heap.set(index2, temp);
    }
    
    
}
