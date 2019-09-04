package com.newer.util;

import com.spire.pdf.PdfDocument;

import java.io.File;


public class FileResolve {
    public static int getPages(File pdfFile){
        String path = pdfFile.getPath();
        PdfDocument doc=new PdfDocument();
        doc.loadFromFile(path);
        return doc.getPages().getCount();
    }
}
