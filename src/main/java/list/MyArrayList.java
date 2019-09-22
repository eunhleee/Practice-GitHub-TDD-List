package list;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List<T> {
    int arraysize;
    T[] arraylist;

    public MyArrayList(){
        arraylist=(T[]) new Object[5];
        arraysize=arraylist.length;
    }

    @Override
    public int size() {
        return arraysize;
    }

    @Override
    public boolean isEmpty() {
        if(arraysize==0) return true;
        else return false;
    }
    @Override
    public int indexOf(Object o) {
        int i;
        for(i=0;i<arraylist.length;i++){
            if(arraylist[i].equals(o))
                break;
        }
        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        int i;
        for(i=arraysize;i>0;i--){
            if(arraylist[i].equals(o))
                break;
            else return -1;
        }
        return i;
    }

    @Override
    public boolean contains(Object o) {
        if(indexOf(o)!=-1) return true;
        else return false;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }


    @Override
    public boolean add(T s) {
        if(arraysize>=arraylist.length){
            T[] testlist= (T[]) new Object[arraylist.length*2];
            System.arraycopy(arraylist,0,testlist,0,arraylist.length);
            arraylist=testlist;
        }
        arraylist[arraysize++]=s;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < arraylist.length - 1; i++) {
            if (arraylist[i].equals(o)) {
                arraylist[i] = arraylist[i + 1];
                arraysize--;
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        int count=0;
        for (Object s:
             c) {
            if(contains(s)==true)
                count++;
        }
        if(count==c.size())return true;
        else return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T s:
                c) {
            add(s);
        }
        return false;
    }


    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if(index<0 || index>arraysize)
             new IndexOutOfBoundsException();
        for (T s:
             c) {
            add(index,s);
        }
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object s:
             c) {
            remove(s);
        }
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        T[] store=(T[]) new Object[arraysize];
        int j=0;
        for (Object s:
             c) {
            if(contains(s)==true)
                store[j++]= (T) s;
        }
        arraylist=store;
        arraysize=j;
        return false;
    }

    @Override
    public void clear() {
        for(int i=0;i<arraylist.length;i++){
            remove(i);
        }
    }

    @Override
    public T get(int index) {
        return (T) arraylist[index];
    }


    @Override
    public void add(int index, T element) {

    }

    @Override
    public T set(int index, T element) {
        if (index < 0 || index > arraylist.length)
            new IndexOutOfBoundsException();
        arraylist[index] = element;
        return null;
    }


    @Override
    public T remove(int index) {
        if(index<0 || index>arraylist.length)
            new IndexOutOfBoundsException();
        if(arraysize < arraylist.length / 2 ){
            T[] testlist=(T[])new Object[arraylist.length / 2];
            System.arraycopy(arraylist,0,testlist,0,arraysize);
            arraylist=testlist;
        }
        for(int i=index;i<arraysize-1;i++)
            arraylist[i+1]=arraylist[i];
        arraysize--;
        return null;
    }


    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}
