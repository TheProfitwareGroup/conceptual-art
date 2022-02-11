package tech.profitware.conceptualart.web;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jakarta.enterprise.context.RequestScoped;

@RequestScoped
@Path("images")
public class ImageResource {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Image> getAllImages() {
		return Arrays.asList(new Image("Image 1", "https://mdbcdn.b-cdn.net/img/Photos/Thumbnails/Slides/1.webp"),
				new Image("Image 2", "https://mdbcdn.b-cdn.net/img/Photos/Thumbnails/Square/1.webp"),
				new Image("Image 3", "https://mdbcdn.b-cdn.net/img/Photos/Thumbnails/Vertical/1.webp"),
				new Image("Image 4", "https://mdbcdn.b-cdn.net/img/Photos/Horizontal/Nature/4-col/img%20(73).webp"),
				new Image("Image 5", "https://mdbcdn.b-cdn.net/img/Photos/Vertical/mountain1.webp"),
				new Image("Image 6", "https://mdbcdn.b-cdn.net/img/Photos/Vertical/mountain2.webp"),
				new Image("Image 7", "https://mdbcdn.b-cdn.net/img/Photos/Vertical/mountain3.webp"),
				new Image("Image 8", "https://mdbcdn.b-cdn.net/img/Photos/Horizontal/Nature/4-col/img%20(18).webp"));
	}
}
