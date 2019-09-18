package list;

import org.junit.Test;

import java.beans.Beans;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyArrayListTest{
    @Test
    public void testInit(){
        List<String> arraylist=new MyArrayList();
        assertThat(arraylist).isInstanceOf(MyArrayList.class);
        assertThat(arraylist).isInstanceOf(List.class);
    }

    @Test
    public void add() {
        List<String> arraylist=new MyArrayList();
        arraylist.add("0");
        assertThat(arraylist.size()).isEqualTo(1);
        assertThat(arraylist.get(0)).isEqualTo("0");
    }

    @Test
    public void addAll() {
        List<String> arraylist=new MyArrayList();
        List<String> testlist=new ArrayList();
        for(int i=0;i<5;i++){
            arraylist.add(""+i);
            testlist.add(""+(i+5));
        }
        arraylist.addAll(testlist);
        assertThat(arraylist.size()).isEqualTo(10);
        assertThat(arraylist.get(5)).isEqualTo("5");
    }

    @Test
    public void remove() {
        List<String> arraylist=new MyArrayList();
        arraylist.add("a");
        arraylist.add("b");
        arraylist.add("c");
        arraylist.remove(0);
        assertThat(arraylist.size()).isEqualTo(2);
        assertThat(arraylist.get(0)).isEqualTo("b");
    }


    @Test
    public void containsAll() {
        List<String> arraylist=new MyArrayList();
        List<String> testlist=new ArrayList();
        for(int i=0;i<5;i++){
            arraylist.add(""+i);
            testlist.add(""+i);
        }
        assertThat(arraylist.containsAll(testlist)).isTrue();
    }

    @Test
    public void retainAll() {
        List<String> arraylist=new MyArrayList();
        List<String> testlist=new ArrayList();
        for(int i=0;i<5;i++) {
            arraylist.add("" + (i+1));
            testlist.add("" + i);
        }
        arraylist.retainAll(testlist);
        assertThat(arraylist.size()).isEqualTo(4);
    }

    @Test
    public void indexOf() {
        List<String> arraylist=new MyArrayList();
        arraylist.add("a");
        arraylist.add("b");
        arraylist.add("c");
        assertThat(arraylist.indexOf("b")).isEqualTo(1);
    }

    @Test
    public void lastIndexOf() {
        List<String> arraylist=new MyArrayList();
        arraylist.add("a");
        arraylist.add("b");
        arraylist.add("c");
        assertThat(arraylist.indexOf("b")).isEqualTo(1);
    }
}