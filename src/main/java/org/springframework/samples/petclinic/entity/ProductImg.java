package org.springframework.samples.petclinic.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="product_img")
public class ProductImg extends BaseEntity {

	@Id
	@Column(name="product_img_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String imgName;

	private String oriImgName;

	private String imgUrl;

	private int mainImgStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")

	public void updateProductImg(String oriImgName, String imgName, String imgUrl) {
		this.oriImgName = oriImgName;
		this.imgName = imgName;
		this.imgUrl = imgUrl;
	}

}
