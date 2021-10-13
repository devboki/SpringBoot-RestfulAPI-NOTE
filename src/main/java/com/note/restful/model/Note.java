package com.note.restful.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

//Database와 Mapping할 Entity Class
//Application.java -> @EnableJpaAuditing 추가해줄것

@Entity //해당 클래스의 인스턴스가 엔티티임을 명시. 반드시 설정.
@Table(name="NOTES") //기본적으로 클래스명과 동일한 테이블 지정. 다른 이름일 경우 name="테이블명"
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value= {"createAt", "updateAt"}, allowGetters=true)
@Getter
@Setter
public class Note implements Serializable {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="notes_seq")
	@SequenceGenerator(sequenceName="sequnce_notes", allocationSize=1, name="notes_seq")
	private Long id;
	
	@NotBlank //null, "", " "(space) 모두 허용하지 않는 Valid Annotation
	private String title;
	
	@NotBlank
	private String content;
	
	@Column(nullable = false, updatable = false) //필드와 테이블의 컬럼을 매핑. 동일한 경우 생략 가능
	@CreatedDate //처음 entity가 저장될 때 생성일 주입
	private Timestamp createdat;
	
	@Column(nullable = false, updatable = false)
	@LastModifiedDate //entity가 수정될 때 수정일 주입
	private Timestamp updatedat;
}
