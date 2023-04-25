package com.ddokkang.apr142.student;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public interface StudentMapper {
	// method 리턴타입
	//	insert / update / delete -> 영향을 받은 데이터의 수 - int(리턴타입)
	//	select
	//		결과가 하나 나온다 : resultType객체(Student)
	//		결과가 여러개 나온다 : List<resultType객체> (List(Student))
	
	// 메소드명 - mapper.xml의 id와 맞추기 !
	// 파라미터 - mapper.xml의 parameterType과 맞추기 !
	public abstract int reqStudent(Student s);
					//	insert_id, parameterType
	public abstract List<Student> getAllStudent();
	
//	MultipartFile
	
}
