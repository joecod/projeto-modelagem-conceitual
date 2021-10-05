package com.joselemes.cursomc.domain;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Categoria implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;

}
