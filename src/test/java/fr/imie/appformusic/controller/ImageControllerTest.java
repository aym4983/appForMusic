package fr.imie.appformusic.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;

import fr.imie.appformusic.responses.ImageResponse;

public class ImageControllerTest {

	private ImageController controller = new ImageController();
	
	@Ignore
	@Test
	public void testImageUpload() throws Exception {
		String fileName="fileToTest";
		byte [] content = "blablabla".getBytes();
		MockMultipartFile mockFile = new MockMultipartFile("content", fileName, "text/palin", content);
		
		ImageResponse path = controller.imageUpload(mockFile);
		assertThat(path.getPath()).isEqualTo("/img/image");
	}

	@Ignore
	@Test
	public void testImage() throws Exception {
		throw new RuntimeException("not yet implemented");
	}

}
