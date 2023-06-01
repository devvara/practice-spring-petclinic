package org.springframework.samples.petclinic.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false, unique = true)
	private String password;
	@Column(nullable = false)
	private Boolean enabled;
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
		name = "user_role",
		joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
		inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
	)
	private List<Role> roles = new ArrayList<>();

	public User(String username, String password,Boolean enabled, List<Role> roles) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}
}
