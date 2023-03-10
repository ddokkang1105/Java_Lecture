-- 웹사이트에서 게시판에 대한 테이블과 이를 [참조하는] 게시판 댓글 테이블을 만드려고 함
-- 게시판 테이블에는 [작성자 / 게시판 글 내용 / 작성 시간]에 대한 부분이 있었으면..
-- 댓글 테이블에는 [작성자 / 댓글 내용 / 작성 시간]에 대한 부분이 있었으면...

-- 1. 테이블의 구조를 파악해서 게시판 테이블 만들기
CREATE TABLE BOARD(
    B_NO NUMBER(10) PRIMARY KEY,
    B_NAME VARCHAR2(10 CHAR) NOT NULL,
    B_CONTENT VARCHAR2(100 CHAR) NOT NULL,
    B_TIME DATE DEFAULT SYSDATE
);

-- 2. 테이블의 구조를 파악해서 댓글 테이블 만들기
-- [조건 : 참조 되는 테이블의 내용이 삭제되면 관련이 있는 댓글 내용도 삭제]
CREATE TABLE COMMENTS(
    C_NO NUMBER(10) PRIMARY KEY,
    C_NAME VARCHAR2(10 CHAR) NOT NULL,
    C_CONTENT VARCHAR2(50 CHAR) NOT NULL,
    C_TIME DATE DEFAULT SYSDATE,
    C_BOARD_NO NUMBER(10) NOT NULL,
        CONSTRAINT FK_NO FOREIGN KEY(C_BOARD_NO)
            REFERENCES BOARD(B_NO)
            ON DELETE CASCADE
);

-- 3. 게시판 테이블에 값 2개 넣고, 각 게시글마다 댓글 2개씩 넣기
-- [Date 관련해서 넣을 값을 현재 날짜/시간으로 통일]
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '김길동', '안녕하세요, 김길동입니다.', DEFAULT);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '최길동', '반갑습니다,, 최길동입니다,,', DEFAULT);

INSERT INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, '홍길동', '안녕하세요, 저도 이름이 길동이예요!', DEFAULT, 1);
INSERT INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, '이길동', '오, 저도 이름이 길동인데 !!', DEFAULT, 1);
INSERT INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, '김길동', '반갑습니다,, 제 이름도 길동,,,', DEFAULT, 2);
INSERT INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, '오길동', '오,, 제  이름도 길동 !!', DEFAULT, 2);

-- 4. 게시글 하나 지웠을 때, 댓글들도 지워지는지 확인
DELETE FROM BOARD WHERE B_NO = 1;
SELECT * FROM BOARD;
SELECT * FROM COMMENTS;

-- 5. 게시판 테이블, 댓글 테이블 완전히 삭제
DROP TABLE BOARD CASCADE CONSTRAINT PURGE;
DROP TABLE COMMENTS CASCADE CONSTRAINT PURGE;
-------------------------------------------------------------------------------------------------------------
-- SOLUTION --
-- 1. 테이블의 구조를 파악해서 게시판 테이블 만들기
CREATE TABLE BOARD(
    B_NO NUMBER(4) PRIMARY KEY,
    B_OWNER VARCHAR2(10 CHAR) NOT NULL,
    B_TXT VARCHAR2(200 CHAR) NOT NULL,
    B_WHEN DATE NOT NULL
);

CREATE SEQUENCE BOARD_SEQ;

-- 2. 테이블의 구조를 파악해서 댓글 테이블 만들기
-- [조건 : 참조 되는 테이블의 내용이 삭제되면 관련이 있는 댓글 내용도 삭제]
CREATE TABLE BOARD_REPLY(
    BR_NO NUMBER(4) PRIMARY KEY,
    BR_B_NO NUMBER(4) NOT NULL, -- 소속된 글 번호 / 이걸로 BOARD 테이블을 참조할 것 !
    BR_OWNER VARCHAR2(10 CHAR) NOT NULL,
    BR_TXT VARCHAR2(200 CHAR) NOT NULL,
    BR_WHEN DATE NOT NULL,
        CONSTRAINT FK_BOARD_REPLY FOREIGN KEY(BR_B_NO)
        REFERENCES BOARD(B_NO)
        ON DELETE CASCADE
);

CREATE SEQUENCE BOARD_REPLY_SEQ;

-- 3. 게시판 테이블에 값 2개 넣고, 각 게시글마다 댓글 2개씩 넣기
-- [Date 관련해서 넣을 값을 현재 날짜/시간으로 통일]
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '박비버', '안녕하세요', SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 'BEAVER KIM', 'HELLO', SYSDATE);
SELECT * FROM BOARD;

INSERT INTO BOARD_REPLY VALUES(BOARD_REPLY_SEQ.NEXTVAL, 1, '최비버', '으악!', SYSDATE);
INSERT INTO BOARD_REPLY VALUES(BOARD_REPLY_SEQ.NEXTVAL, 2, '박비버', '악!', SYSDATE);
INSERT INTO BOARD_REPLY VALUES(BOARD_REPLY_SEQ.NEXTVAL, 1, '오비버', '크악!', SYSDATE);
INSERT INTO BOARD_REPLY VALUES(BOARD_REPLY_SEQ.NEXTVAL, 2, '정비버', '오악!', SYSDATE);
SELECT * FROM BOARD_REPLY;

-- 4. 게시글 하나 지웠을 때, 댓글들도 지워지는지 확인
DELETE FROM BOARD WHERE B_NO = 1;
SELECT * FROM BOARD;
SELECT * FROM BOARD_REPLY;

-- 5. 게시판 테이블, 댓글 테이블 완전히 삭제
DROP TABLE BOARD CASCADE CONSTRAINT PURGE;
DROP SEQUENCE BOARD_SEQ;
DROP TABLE BOARD_REPLY CASCADE CONSTRAINT PURGE;
DROP SEQUENCE BOARD_REPLY_SEQ;
-------------------------------------------------------------------------------------------------------------