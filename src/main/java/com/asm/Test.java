package com.asm;


import com.sun.xml.internal.ws.org.objectweb.asm.ClassReader;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassVisitor;
import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import lombok.SneakyThrows;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * @author zhujianhao
 * @date 2021/5/2 13:44
 * @modify
 */
public class Test {
    @SneakyThrows
    public static void main(String[] args) {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor visitAdaptor = new MyModifyVisitAdaptor(classWriter);
        ClassVisitor visitMethodAdaptor = new MyModifyVisitMethodAdaptor(visitAdaptor);


        ClassReader classReader= new ClassReader(AsmTest.class.getName());
        classReader.accept(visitMethodAdaptor,ClassReader.SKIP_DEBUG);

        byte[] res = classWriter.toByteArray();

        File file = new File("NewAsmTest.class");
        OutputStream os = new FileOutputStream(file);
        os.write(res);
        os.close();

    }
}
