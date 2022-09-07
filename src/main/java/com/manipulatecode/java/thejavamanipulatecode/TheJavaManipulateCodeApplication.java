package com.manipulatecode.java.thejavamanipulatecode;

import com.manipulatecode.java.domain.Book;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@SpringBootApplication
public class TheJavaManipulateCodeApplication {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        //클래스 네임으로 클래스를 가져와 생성자없이 출력
        Class<?> bookClass = Class.forName("com.manipulatecode.java.domain.Book");
        Constructor<?> constructor = bookClass.getConstructor(null);
        Book book = (Book) constructor.newInstance();
        System.out.println(book);

        //클래스 네임으로 클래스를 가져와 생성자 추가 후 출력
        Constructor<?> constructor1 = bookClass.getConstructor(String.class);
        Book myBook = (Book) constructor1.newInstance("myBook");
        System.out.println(myBook);

        //4:00
        //필드 가져오기
        /* Declared -> 기본적으로 public 한 접근뿐이못하지만 해당 명령어의 메서드를 이용하면 접근이 가능하며,
           setAccessible(true) 를 사용하면된다. */
        Field a = Book.class.getDeclaredField("A");
        //get, set 을 위해 해당 인스턴스에 종속적이면 해당 인스턴스를 넘겨줘야하지만 해당 A 필드는 static 이므로 null 을 넣는다.
        System.out.println("a.get_1: " + a.get(null));
        a.set(null, "AAAAAA");
        System.out.println("a.get_2: " + a.get(null));

        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true);//private 필드에 접근가능하게 해주는 메서드
        System.out.println("b.get_1: " + b.get(book));
        b.set(book, "BBBBBB");
        System.out.println("b.get_2: " + b.get(book));

        //메서드 가져오기
        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book); // C

        Method d = Book.class.getDeclaredMethod("sum", int.class, int.class);// 메서드명과, 타입 넘겨줘야
        int invoke = (int) d.invoke(book, 2, 3);
        System.out.println("sum: " + invoke);



    }
}

