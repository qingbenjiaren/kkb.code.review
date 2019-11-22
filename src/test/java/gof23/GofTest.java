package gof23;

import com.melo.Gof23.adapter.PrintBanner;
import com.melo.Gof23.factorymethod.Factory;
import com.melo.Gof23.factorymethod.IdCardFactory;
import com.melo.Gof23.factorymethod.Product;
import com.melo.Gof23.iterator.Book;
import com.melo.Gof23.iterator.BookShelf;
import org.junit.Test;

import java.util.Iterator;

public class GofTest {
    @Test
    public void testIterator(){
        BookShelf shelf = new BookShelf(10);
        shelf.append(new Book("骆驼祥子","老舍"));
        shelf.append(new Book("丰乳肥臀","莫言"));
        shelf.append(new Book("乡关何处","野夫"));
        shelf.append(new Book("围城","钱钟书"));
        shelf.append(new Book("三国演义","罗贯中"));
        //用Iterator接口，屏蔽了内部的实现细节,利于扩展
        //将元素的遍历和实现分离开来,怎么遍历的我们不用管
        Iterator iterator = shelf.iterator();
        while(iterator.hasNext()){
            Book book = (Book) iterator.next();
            System.out.println(book);
        }
    }
    @Test
    public void testAdapter(){
        //如果被适配的角色的功能和最终我们使用的功能完全不同时，适配器是不能使用的，不能将电流适配成水流的。
        PrintBanner banner = new PrintBanner("lisi");
        banner.printStrong();
        banner.printWeak();
    }

    @Test
    public void factoryMethod(){
        Factory factory = new IdCardFactory();
        Product p = factory.create("melo");
        p.use();

    }

}
