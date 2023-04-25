package com.ddokkang.apr142.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oreilly.servlet.MultipartRequest;

// SqlSessionTemplate
//	SqlSesstion의 하위클래스
//	(public class SqlSessionTemplate implements SqlSession) 의 구조
//			=> SqlSession의 기능은 다 들어있고, 뭔가 더 추가됨
//			자동연결 / 자동해제
//			자동 commit

@Service
public class StudentDAO {
	
	@Autowired
	private SqlSession ss;
	
	public void reqStudent(Student s, HttpServletRequest request) {
		try {
			
			// 연결 - 자동(SqlSesstionTemplate 때문에) - connect, close 필요 X
			
			// 값을 받아오기 & 객체로 만들기 - Spring이 해결을 자동으로 해줌 !
			
			// 내용
			System.out.println(s.getS_name());
			System.out.println(s.getS_nickname());
			
			// SQL문 수행 - MyBatis를 활용...
			//	interface를 가져온다
//			StudentMapper sm = ss.getMapper(StudentMapper.class);
			
			// interface에 있는 abstract method(추상 메소드) 호출
			//	-자동-> 연결이 되어있는 mapper.xml의 해당 부분이 실행
//			if (sm.reqStudent(s) == 1) {
//				request.setAttribute("r", "학생 등록 성공");
//				// ss.commit(); -> commit 자동 !
//			}
			if (ss.getMapper(StudentMapper.class).reqStudent(s) == 1) {
				request.setAttribute("r", "학생 등록 성공");
				// ss.commit(); -> commit 자동 !
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "학생 등록 실패");
		}
	}
	
	public void getAllStudent(HttpServletRequest request) {
		try {
//			List<Student> students = ss.getMapper(StudentMapper.class).getAllStudent();
//			request.setAttribute("students", students);
			
			request.setAttribute("students", ss.getMapper(StudentMapper.class).getAllStudent());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
//	public void getSome(Student s, HttpServletRequest request) {
//		String path = request.getSession().getServletContext().getRealPath("img");
//		MultipartRequest mr = new MultipartRequest(request, saveDirectory);
//		String s_photo = mr.getFilesystemName("이미지파라미터명");
//		s.setS_photo(s_photo);		
//		if (ss.getMapper(StudentMapper.class).reqStudent(s) == 1) {
//			request.setAttribute("r", "학생 등록 성공");
//			// ss.commit(); -> commit 자동 !
//		}
//	}
	
	
}
