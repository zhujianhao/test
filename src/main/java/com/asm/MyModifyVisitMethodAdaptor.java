package com.asm;

import com.asm.method.MyMethodVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;

/**
 * @author zhujianhao
 * @date 2021/5/2 13:43
 * @modify
 */
public class MyModifyVisitMethodAdaptor extends ClassAdapter {


    public MyModifyVisitMethodAdaptor(ClassVisitor cv) {
        super(cv);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        if(name.equals("print")){
            return new MyMethodVisitor(super.visitMethod(access, name, desc, signature, exceptions));
        }
        return super.visitMethod(access, name, desc, signature, exceptions);
    }
}
