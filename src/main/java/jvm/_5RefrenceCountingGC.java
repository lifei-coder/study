package jvm;


/**
 *
 */
public class _5RefrenceCountingGC {

    public Object instance = null;

    private static final int  _1MB = 1024 * 1024;

    /** 这个成员的唯一意义就是占点内存，以便于在GC日志中看清楚是否被回收过 **/
    private byte[] bigSize = new byte[2 * _1MB];


    public static void testGC(){
        _5RefrenceCountingGC objA = new _5RefrenceCountingGC();
        _5RefrenceCountingGC objB = new _5RefrenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;
        // 假设在这行发生GC，objA和objB是否能被回收?
        System.gc();

    }

    public static void main(String[] args) {
        testGC();
    }

}