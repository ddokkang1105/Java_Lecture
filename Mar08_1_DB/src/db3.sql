-- ������Ʈ���� �Խ��ǿ� ���� ���̺�� �̸� [�����ϴ�] �Խ��� ��� ���̺��� ������� ��
-- �Խ��� ���̺��� [�ۼ��� / �Խ��� �� ���� / �ۼ� �ð�]�� ���� �κ��� �־�����..
-- ��� ���̺��� [�ۼ��� / ��� ���� / �ۼ� �ð�]�� ���� �κ��� �־�����...

-- 1. ���̺��� ������ �ľ��ؼ� �Խ��� ���̺� �����
CREATE TABLE BOARD(
    B_NO NUMBER(10) PRIMARY KEY,
    B_NAME VARCHAR2(10 CHAR) NOT NULL,
    B_CONTENT VARCHAR2(100 CHAR) NOT NULL,
    B_TIME DATE DEFAULT SYSDATE
);

-- 2. ���̺��� ������ �ľ��ؼ� ��� ���̺� �����
-- [���� : ���� �Ǵ� ���̺��� ������ �����Ǹ� ������ �ִ� ��� ���뵵 ����]
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

-- 3. �Խ��� ���̺� �� 2�� �ְ�, �� �Խñ۸��� ��� 2���� �ֱ�
-- [Date �����ؼ� ���� ���� ���� ��¥/�ð����� ����]
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '��浿', '�ȳ��ϼ���, ��浿�Դϴ�.', DEFAULT);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '�ֱ浿', '�ݰ����ϴ�,, �ֱ浿�Դϴ�,,', DEFAULT);

INSERT INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, 'ȫ�浿', '�ȳ��ϼ���, ���� �̸��� �浿�̿���!', DEFAULT, 1);
INSERT INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, '�̱浿', '��, ���� �̸��� �浿�ε� !!', DEFAULT, 1);
INSERT INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, '��浿', '�ݰ����ϴ�,, �� �̸��� �浿,,,', DEFAULT, 2);
INSERT INTO COMMENTS VALUES(COMMENTS_SEQ.NEXTVAL, '���浿', '��,, ��  �̸��� �浿 !!', DEFAULT, 2);

-- 4. �Խñ� �ϳ� ������ ��, ��۵鵵 ���������� Ȯ��
DELETE FROM BOARD WHERE B_NO = 1;
SELECT * FROM BOARD;
SELECT * FROM COMMENTS;

-- 5. �Խ��� ���̺�, ��� ���̺� ������ ����
DROP TABLE BOARD CASCADE CONSTRAINT PURGE;
DROP TABLE COMMENTS CASCADE CONSTRAINT PURGE;
-------------------------------------------------------------------------------------------------------------
-- SOLUTION --
-- 1. ���̺��� ������ �ľ��ؼ� �Խ��� ���̺� �����
CREATE TABLE BOARD(
    B_NO NUMBER(4) PRIMARY KEY,
    B_OWNER VARCHAR2(10 CHAR) NOT NULL,
    B_TXT VARCHAR2(200 CHAR) NOT NULL,
    B_WHEN DATE NOT NULL
);

CREATE SEQUENCE BOARD_SEQ;

-- 2. ���̺��� ������ �ľ��ؼ� ��� ���̺� �����
-- [���� : ���� �Ǵ� ���̺��� ������ �����Ǹ� ������ �ִ� ��� ���뵵 ����]
CREATE TABLE BOARD_REPLY(
    BR_NO NUMBER(4) PRIMARY KEY,
    BR_B_NO NUMBER(4) NOT NULL, -- �Ҽӵ� �� ��ȣ / �̰ɷ� BOARD ���̺��� ������ �� !
    BR_OWNER VARCHAR2(10 CHAR) NOT NULL,
    BR_TXT VARCHAR2(200 CHAR) NOT NULL,
    BR_WHEN DATE NOT NULL,
        CONSTRAINT FK_BOARD_REPLY FOREIGN KEY(BR_B_NO)
        REFERENCES BOARD(B_NO)
        ON DELETE CASCADE
);

CREATE SEQUENCE BOARD_REPLY_SEQ;

-- 3. �Խ��� ���̺� �� 2�� �ְ�, �� �Խñ۸��� ��� 2���� �ֱ�
-- [Date �����ؼ� ���� ���� ���� ��¥/�ð����� ����]
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, '�ں��', '�ȳ��ϼ���', SYSDATE);
INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, 'BEAVER KIM', 'HELLO', SYSDATE);
SELECT * FROM BOARD;

INSERT INTO BOARD_REPLY VALUES(BOARD_REPLY_SEQ.NEXTVAL, 1, '�ֺ��', '����!', SYSDATE);
INSERT INTO BOARD_REPLY VALUES(BOARD_REPLY_SEQ.NEXTVAL, 2, '�ں��', '��!', SYSDATE);
INSERT INTO BOARD_REPLY VALUES(BOARD_REPLY_SEQ.NEXTVAL, 1, '�����', 'ũ��!', SYSDATE);
INSERT INTO BOARD_REPLY VALUES(BOARD_REPLY_SEQ.NEXTVAL, 2, '�����', '����!', SYSDATE);
SELECT * FROM BOARD_REPLY;

-- 4. �Խñ� �ϳ� ������ ��, ��۵鵵 ���������� Ȯ��
DELETE FROM BOARD WHERE B_NO = 1;
SELECT * FROM BOARD;
SELECT * FROM BOARD_REPLY;

-- 5. �Խ��� ���̺�, ��� ���̺� ������ ����
DROP TABLE BOARD CASCADE CONSTRAINT PURGE;
DROP SEQUENCE BOARD_SEQ;
DROP TABLE BOARD_REPLY CASCADE CONSTRAINT PURGE;
DROP SEQUENCE BOARD_REPLY_SEQ;
-------------------------------------------------------------------------------------------------------------