// Java Package testpkg is a proxy for talking to a Go program.
//   gobind -lang=java golang.org/x/mobile/bind/java/testpkg
//
// File is generated by gobind. Do not edit.
package go.testpkg;

import go.Seq;

public abstract class Testpkg {
    private Testpkg() {} // uninstantiable
    
    public static long Add(long x, long y) {
        go.Seq _in = new go.Seq();
        go.Seq _out = new go.Seq();
        long _result;
        _in.writeInt(x);
        _in.writeInt(y);
        Seq.send(DESCRIPTOR, CALL_Add, _in, _out);
        _result = _out.readInt();
        return _result;
    }
    
    public static void Call(I i) {
        go.Seq _in = new go.Seq();
        go.Seq _out = new go.Seq();
        _in.writeRef(i.ref());
        Seq.send(DESCRIPTOR, CALL_Call, _in, _out);
    }
    
    public static void Err(String s) throws Exception {
        go.Seq _in = new go.Seq();
        go.Seq _out = new go.Seq();
        _in.writeUTF16(s);
        Seq.send(DESCRIPTOR, CALL_Err, _in, _out);
        String _err = _out.readUTF16();
        if (_err != null) {
            throw new Exception(_err);
        }
    }
    
    public static void GC() {
        go.Seq _in = new go.Seq();
        go.Seq _out = new go.Seq();
        Seq.send(DESCRIPTOR, CALL_GC, _in, _out);
    }
    
    public interface I extends go.Seq.Object {
        public void F();
        
        public static abstract class Stub implements I {
            static final String DESCRIPTOR = "go.testpkg.I";
            
            private final go.Seq.Ref ref;
            public Stub() {
                ref = go.Seq.createRef(this);
            }
            
            public go.Seq.Ref ref() { return ref; }
            
            public void call(int code, go.Seq in, go.Seq out) {
                switch (code) {
                case Proxy.CALL_F: {
                    this.F();
                    return;
                }
                default:
                    throw new RuntimeException("unknown code: "+ code);
                }
            }
        }
        
        static final class Proxy implements I {
            static final String DESCRIPTOR = Stub.DESCRIPTOR;
        
            private go.Seq.Ref ref;
        
            Proxy(go.Seq.Ref ref) { this.ref = ref; }
        
            public go.Seq.Ref ref() { return ref; }
        
            public void call(int code, go.Seq in, go.Seq out) {
                throw new RuntimeException("cycle: cannot call proxy");
            }
        
            public void F() {
                go.Seq _in = new go.Seq();
                go.Seq _out = new go.Seq();
                _in.writeRef(ref);
                Seq.send(DESCRIPTOR, CALL_F, _in, _out);
            }
            
            static final int CALL_F = 0x10a;
        }
    }
    
    public static void Keep(I i) {
        go.Seq _in = new go.Seq();
        go.Seq _out = new go.Seq();
        _in.writeRef(i.ref());
        Seq.send(DESCRIPTOR, CALL_Keep, _in, _out);
    }
    
    public static S New() {
        go.Seq _in = new go.Seq();
        go.Seq _out = new go.Seq();
        S _result;
        Seq.send(DESCRIPTOR, CALL_New, _in, _out);
        _result = new S(_out.readRef());
        return _result;
    }
    
    public static long NumSCollected() {
        go.Seq _in = new go.Seq();
        go.Seq _out = new go.Seq();
        long _result;
        Seq.send(DESCRIPTOR, CALL_NumSCollected, _in, _out);
        _result = _out.readInt();
        return _result;
    }
    
    public static final class S implements go.Seq.Object {
        private static final String DESCRIPTOR = "go.testpkg.S";
        private static final int CALL_F = 0x00c;
        
        private go.Seq.Ref ref;
        
        private S(go.Seq.Ref ref) { this.ref = ref; }
        
        public go.Seq.Ref ref() { return ref; }
        
        public void call(int code, go.Seq in, go.Seq out) {
            throw new RuntimeException("internal error: cycle: cannot call concrete proxy");
        }
        
        
        public void F() {
            go.Seq _in = new go.Seq();
            go.Seq _out = new go.Seq();
            _in.writeRef(ref);
            Seq.send(DESCRIPTOR, CALL_F, _in, _out);
        }
        
        @Override public boolean equals(Object o) {
            if (o == null || !(o instanceof S)) {
                return false;
            }
            S that = (S)o;
            return true;
        }
        
        @Override public int hashCode() {
            return java.util.Arrays.hashCode(new Object[] {});
        }
        
        @Override public String toString() {
            StringBuilder b = new StringBuilder();
            b.append("S").append("{");
            return b.append("}").toString();
        }
        
    }
    
    public static String StrDup(String s) {
        go.Seq _in = new go.Seq();
        go.Seq _out = new go.Seq();
        String _result;
        _in.writeUTF16(s);
        Seq.send(DESCRIPTOR, CALL_StrDup, _in, _out);
        _result = _out.readUTF16();
        return _result;
    }
    
    private static final int CALL_Add = 1;
    private static final int CALL_Call = 2;
    private static final int CALL_Err = 3;
    private static final int CALL_GC = 4;
    private static final int CALL_Keep = 5;
    private static final int CALL_New = 6;
    private static final int CALL_NumSCollected = 7;
    private static final int CALL_StrDup = 8;
    private static final String DESCRIPTOR = "testpkg";
}
