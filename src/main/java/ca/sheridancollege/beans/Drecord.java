package ca.sheridancollege.beans;

import java.io.Serializable;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Drecord implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2519824428151569589L;
	private String title;
	private String author;
	private double price;
	private int quantity;
	private String relatedCourses;
}
