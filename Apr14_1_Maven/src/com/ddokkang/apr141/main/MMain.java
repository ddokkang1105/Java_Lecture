package com.ddokkang.apr141.main;

import com.ddokkang.db.manager.DdokkangDBManager;
import com.ddokkang.http.client.DdokkangHttpClient;

// Java 전 세계적으로 많이 사용 !
//		개발자들이 본인이 만들어 놓은 것들을 공유 !
//		소스 자체를 공유 X. .jar파일 만들어서 공유하는 문화 O
//		.jar파일을 자동으로 관리해주는 시스템 : Maven
//		Maven 중앙 저장소 : https://mvnrepository.com/

// Maven을 활용하면
//		Maven 중앙 저장소에 저장되어 있는 .jar파일
//		컴퓨터의 Maven 로컬 저장소 : C:\Users\sdedu\.m2\repository

// Maven 중앙 저장소에 없는 것들 : 로컬 저장소를 활용하면 됨 !
//		dbmanager, httpclient, ...
// ==============================================================================
// 현재 프로젝트를 - Maven Project로 변경
//	프로젝트 우클릭 - Configure - Convert to Maven Project

// Maven 로컬 저장소 등록하기 !!
//	프로젝트 우클릭 - import - import - maven - Install or deploy ... - Artifact file - 사진 참조 - finish
//	pom.xml - Dependencies 탭 클릭 - Add - Artifact Id로 검색(정확한 단어로 검색) - 선택해서 사용 !
// ==============================================================================
// Maven 새로고침
//	Window 메뉴 - show view - other - maven 검색
//		Maven Repositories - Local Repositories
//		- Local repository 우클릭 - rebulid index
// ==============================================================================
// pom.xml 라이브러리 불러왔는데 -> 기능 자동완성 안될 때
//		=> 프로젝트 우클릭 - Maven - Update Project
// ==============================================================================
// Maven Error 
//	-> 이클립스 종료 -> 로컬저장소(repository) 지우기 -> 이클립스 시작 -> 다운받을거 다시 받기
// ==============================================================================

public class MMain {
	DdokkangDBManager dbm;
	DdokkangHttpClient dbc;
}

