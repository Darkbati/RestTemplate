package com.template.rest.servlet;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.servlet.ReadListener;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.template.rest.crypto.AES256Bit;

public class HttpServletRequestWritableWrapper extends HttpServletRequestWrapper {
	protected static Logger logger = LogManager.getLogger(HttpServletRequestWritableWrapper.class);

	private final Charset encoding;
	private byte[] rawData;

	public HttpServletRequestWritableWrapper(HttpServletRequest request) throws ServletException {
		super(request);

		String characterEncoding = request.getCharacterEncoding();
		if (StringUtils.isBlank(characterEncoding)) {
			characterEncoding = StandardCharsets.UTF_8.name();
		}
		this.encoding = Charset.forName(characterEncoding);

		try {
			this.rawData = DecryptStream(request.getInputStream());
		} catch (IOException e) {
			throw new ServletException(e);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private byte[] DecryptStream(InputStream inputStream) throws Exception {
		String result = "";
		try {
			StringBuffer sb = new StringBuffer();
			int len = 0;
			byte[] buf = new byte[1024];

			while ((len = inputStream.read(buf)) != -1) {
				sb.append(new String(buf, 0, len));
			}
			System.out.println("HTTP Request Body AES256 : " + sb.toString());
			logger.debug("HTTP Request Body AES256 : " + sb.toString());

			result = AES256Bit.decode(sb.toString());

			System.out.println("HTTP Request Body Plain : " + result);
			logger.debug("HTTP Request Body Plain : " + result);
		} catch (Exception e) {
			throw e;
		}

		return result.getBytes();
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.rawData);
		ServletInputStream servletInputStream = new ServletInputStream() {
			@Override
			public int read() throws IOException {
				return byteArrayInputStream.read();
			}

			@Override
			public boolean isFinished() {
				return false;
			}

			@Override
			public boolean isReady() {
				return false;
			}

			@Override
			public void setReadListener(ReadListener listener) {

			}
		};
		return servletInputStream;
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return new BufferedReader(new InputStreamReader(this.getInputStream(), this.encoding));
	}

	@Override
	public ServletRequest getRequest() {
		return super.getRequest();
	}

}
