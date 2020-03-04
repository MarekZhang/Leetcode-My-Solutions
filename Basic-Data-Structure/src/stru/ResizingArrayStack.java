package stru;

import java.util.Iterator;

public class ResizingArrayStack<Item> implements Iterable<Item>{

    private Item[] arr = (Item[]) new Object[1];
    private int size = 0;

    public boolean isEmpty() { return size == 0; }
    public int size() { return size; }

    public void push(Item item){
        if(size == arr.length)
            resize(2 * size);
        arr[size++] = item;
    }

    private void resize( int n){
        Item[] tempt = (Item[]) new Object[n];
        for(int i = 0; i < size; i++ ){
            tempt[i] = arr[i];
        }
        arr = tempt;
        //size不能= n，因为虽然开辟了空间但是没有添加元素
    }

    public Item pop(){ 
        assert size > 0;
        Item tempt = arr[size - 1];
        arr[--size] = null;
        if(size > 0 && size == arr.length / 4){
            resize(arr.length / 2);
        }
        return tempt;
    }

    public Iterator<Item> iterator(){ 
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int N = size;
        public Item next(){ return arr[--N]; }
        public boolean hasNext(){return N > 0;}
        public void remove(){}

    }
}