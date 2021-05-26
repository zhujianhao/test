package com.asm;


import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;

/**
 * @author zhujianhao
 * @date 2021/5/2 13:41
 * @modify
 */
public class MyModifyVisitAdaptor extends ClassAdapter {


    public MyModifyVisitAdaptor(ClassVisitor classVisitor) {
        super(classVisitor);
    }

    @Override
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        name = name+"Enhance";
        super.visit(version, access, name, signature, name, interfaces);
    }
}
