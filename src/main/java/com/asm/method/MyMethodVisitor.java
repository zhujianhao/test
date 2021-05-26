package com.asm.method;

import com.sun.xml.internal.ws.org.objectweb.asm.MethodAdapter;
import com.sun.xml.internal.ws.org.objectweb.asm.MethodVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;

/**
 * @author zhujianhao
 * @date 2021/5/2 14:26
 * @modify
 */
public class MyMethodVisitor extends MethodAdapter {


    public MyMethodVisitor(MethodVisitor mv) {
        super(mv);
    }
    @Override
    public void visitCode(){
            visitMethodInsn(Opcodes.INVOKESTATIC, "Aop",
                    "before", "()V");
    }

}
