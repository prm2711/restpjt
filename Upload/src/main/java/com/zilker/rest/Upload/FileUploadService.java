package com.zilker.rest.Upload;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;
import java.util.Base64;

@Path("/files")
public class FileUploadService {
	@POST
	@Path("/upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream uploadedInputStream,
			@FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {

		byte[] bytes = null;

		bytes = IOUtils.toByteArray(uploadedInputStream);
		byte[] b = Base64.getEncoder().encode(bytes);
		File file = new File("C:\\Users\\Priyamvada Mukund\\file.txt");
		//File file1 = new File("C:\\Users\\Priyamvada Mukund\\file1.txt");
		BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(file));
		writer.write(b);
		writer.flush();
		writer.close();
		byte[] bytesArray = Base64.getDecoder().decode(b);
		//FileUtils.writeByteArrayToFile(file1, bytesArray);	
		return Response.ok(new ByteArrayInputStream(bytesArray)).build();
	}
}