
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Heap {

    private int[] heap;
    private int   p = 0;

    public Heap(int size){
        heap = new int[size + 1];
    }

    public Heap(){
        heap = new int[16];
    }

    public void add(int a){
        if (p == heap.length - 1)   increCapacity();
        heap[++p] = a;
        swim(p);
    }

    public int removeFirst(){
        int re = heap[1];
        heap[1] = heap[p--];
        sink(1);
        return re;
    }

    public int getFirst(){
        if (p == 0)     throw new IndexOutOfBoundsException("empty heap now!");
        return heap[1];
    }

    private void swim(int current){
        int parent = current / 2;
        while (parent > 0 && heap[parent] < heap[current]) {
            exchange(parent, current);
            current = parent;
            parent = current / 2;
        }
    }

    private void sink(int current){
        while (current <= p / 2){
            int l = current * 2, m = l + 1;
            if (m <= p && heap[m] > heap[l])
                l = m;

            if (heap[l] > heap[current]){
                exchange(l, current);
                current = l;
            }else
                break;
        }
    }

    private void increCapacity(){
        int[] heap2 = new int[2 * heap.length];
        for (int i = 1; i <= p; i ++)
            heap2[i] = heap[i];
        heap = heap2;
    }

    public int size(){
        return p;
    }

    private void exchange(int p1, int p2){
        int temp = heap[p1];
        heap[p1] = heap[p2];
        heap[p2] = temp;
    }

    public void printHeap(){
        System.out.println(Arrays.toString(heap));
    }

    public static void main(String[] args){
        Random random = new Random();
        Heap h = new Heap();
        for (int i = 0; i < 10; i ++)
            h.add(random.nextInt(200));
        h.printHeap();
        h.removeFirst();
        h.printHeap();
    }

}
