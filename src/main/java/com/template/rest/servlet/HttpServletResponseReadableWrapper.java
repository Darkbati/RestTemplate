package com.template.rest.servlet;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.template.rest.crypto.AES256Bit;

public class HttpServletResponseReadableWrapper extends HttpServletResponseWrapper {
	protected static Logger logger = LogManager.getLogger(HttpServletResponseReadableWrapper.class);

	private ServletOutputStream outputStream;
	private PrintWriter writer;
	private ServletOutputStreamCopier copier;

	public HttpServletResponseReadableWrapper(HttpServletResponse response) throws IOException {
		super(response);
	}

	@Override
	public ServletOutputStream getOutputStream() throws IOException {
		if (writer != null) {
			throw new IllegalStateException("getWriter() has already been called on this response");
		}

		if (outputStream == null) {
			outputStream = getResponse().getOutputStream();
			copier = new ServletOutputStreamCopier(outputStream);
		} else {
			byte[] write = copier.getCopy();
			this.resetBuffer();

			System.out.println("HTTP Response Body Plain : " + new String(write));
			logger.debug("HTTP Response Body Plain : " + new String(write));

			try {
				String value = AES256Bit.encode(new String(write));
				outputStream.flush();
				outputStream.write(value.getBytes());

				System.out.println("HTTP Response Body AES256 : " + value);
				logger.debug("HTTP Response Body AES256 : " + value);
			} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
				throw new IOException(e);
			}

			return outputStream;
		}
		return copier;
	}

	@Override
	public PrintWriter getWriter() throws IOException {
		if (outputStream != null) {
			throw new IllegalStateException("getOutputStream() has already been called on this response");
		}

		if (writer == null) {
			copier = new ServletOutputStreamCopier(getResponse().getOutputStream());
			writer = new PrintWriter(new OutputStreamWriter(copier, getResponse().getCharacterEncoding()), true);
		}

		return writer;
	}

	@Override
	public void flushBuffer() throws IOException {
		if (writer != null) {
			writer.flush();
		} else if (outputStream != null) {
			copier.flush();
		}
	}

	public byte[] getCopy() {
		if (copier != null) {
			return copier.getCopy();
		} else {
			return new byte[0];
		}
	}

	public String getBody() {
		String responseBody = "";
		try {
			this.flushBuffer();
			byte[] copy = this.getCopy();
			responseBody = new String(copy, getResponse().getCharacterEncoding());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return responseBody;
	}
}
