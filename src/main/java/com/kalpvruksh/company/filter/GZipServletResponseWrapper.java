package com.kalpvruksh.company.filter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class GZipServletResponseWrapper.
 */
public class GZipServletResponseWrapper extends HttpServletResponseWrapper {
	
	/** The gzip output stream. */
	private GZipServletOutputStream gzipOutputStream = null;
	
	/** The print writer. */
	private PrintWriter printWriter = null;

	/**
	 * Instantiates a new g zip servlet response wrapper.
	 *
	 * @param response the response
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public GZipServletResponseWrapper(HttpServletResponse response) throws IOException {
		super(response);
	}

	/**
	 * Close.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public void close() throws IOException {
		if (this.printWriter != null) {
			this.printWriter.close();
		}
		if (this.gzipOutputStream != null) {
			this.gzipOutputStream.close();
		}
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#flushBuffer()
	 */
	@Override
	public void flushBuffer() throws IOException {
		if(this.printWriter != null) {
			this.printWriter.flush();
		}
		IOException exception1 = null;
		try{
			if(this.gzipOutputStream != null) {
				this.gzipOutputStream.flush();
			}
		} catch(IOException e) {
			exception1 = e;
		}
		IOException exception2 = null;
		try {
			super.flushBuffer();
		} catch(IOException e){
			exception2 = e;
		}

		if(exception1 != null) throw exception1;
		if(exception2 != null) throw exception2;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#getOutputStream()
	 */
	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (this.printWriter != null) {
			throw new IllegalStateException(
					"PrintWriter obtained already - cannot get OutputStream");
		}
		if (this.gzipOutputStream == null) {
			this.gzipOutputStream = new GZipServletOutputStream(
					getResponse().getOutputStream());
		}
		return this.gzipOutputStream;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#getWriter()
	 */
	@Override
	public PrintWriter getWriter() throws IOException {
		if (this.printWriter == null && this.gzipOutputStream != null) {
			throw new IllegalStateException(
					"OutputStream obtained already - cannot get PrintWriter");
		}
		if (this.printWriter == null) {
			this.gzipOutputStream = new GZipServletOutputStream(
					getResponse().getOutputStream());
			this.printWriter      = new PrintWriter(new OutputStreamWriter(
					this.gzipOutputStream, getResponse().getCharacterEncoding()));
		}
		return this.printWriter;
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletResponseWrapper#setContentLength(int)
	 */
	@Override
	public void setContentLength(int len) {
	}
}