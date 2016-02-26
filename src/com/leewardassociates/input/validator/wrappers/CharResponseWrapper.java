package com.leewardassociates.input.validator.wrappers;

import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CharResponseWrapper extends HttpServletResponseWrapper  {

    private PrintWriter writer;
    private CharArrayWriter output;
    private boolean outputStreamCalled;
    private boolean writerCalled;
    
    public CharResponseWrapper(HttpServletResponse response) {
	super(response);
	output = new CharArrayWriter();
    }
    
    public ServletOutputStream getOutputStream() throws IOException {
	if (isWriterCalled()) {
	    throw new IllegalStateException("Writer already called.");
	}
	outputStreamCalled = true;
	return super.getOutputStream();
    }
    
    public PrintWriter getWriter() throws IOException {
	if (this.writer != null) {
	    return writer;
	}
	if (isOutputStreamCalled()) {
	    throw new IllegalStateException("Output stream already called.");
	}
	this.writerCalled = true;
	writer = new PrintWriter(output);
        return writer;
    }

    public boolean isOutputStreamCalled() {
        return outputStreamCalled;
    }

    public void setOutputStreamCalled(boolean outputStreamCalled) {
        this.outputStreamCalled = outputStreamCalled;
    }

    public boolean isWriterCalled() {
        return writerCalled;
    }

    public void setWriterCalled(boolean writerCalled) {
        this.writerCalled = writerCalled;
    }

    public String toString() {
        return output.toString();
    }

}
