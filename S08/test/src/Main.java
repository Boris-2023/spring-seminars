import java.time.LocalDateTime;
import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Object obj = new Object();
        String str = "Simple string!";
        StringBuffer strBuf = new StringBuffer("aaa");
        StringBuilder strBuild = new StringBuilder("aaa");


        List<String> arrayList = new ArrayList<>(100);
        List<String> linkedList = new LinkedList<>();

        Map<Integer, String> hashMap = new HashMap<>(100);
        Map<Integer, String> treeMap = new TreeMap<>();

        ArrayDeque<String> queue = new ArrayDeque<>();
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();


        //Collections
        System.out.println(obj.hashCode());

        //obj.
        //str
        //strBuf
        //strBuild

        //arrayList
        //linkedList

        //hashMap
        //treeMap

        //queue
        //priorityQueue


        Supplier<LocalDateTime> now = LocalDateTime::now;
        System.out.println(now.get());


        System.out.println(
                Stream
                        .of(2,4,7,132,32,564,6)
                        //.mapToInt(x -> x)
                        .filter(x -> x<30)
                        .count()
        );


        TestClass a = new TestClass();
        a.a();

        a = null;
        System.gc();

        Thread.sleep(1000);

        a = new TestClass();
        a.a();

        System.out.println("!!! done");



    }
}

class TestClass {
    public void a() {

        System.out.println("!!! a() called");
    }

    @Override
    protected void finalize() throws Throwable {

        System.out.println("!!! finalize() called");
        super.finalize();
    }
}