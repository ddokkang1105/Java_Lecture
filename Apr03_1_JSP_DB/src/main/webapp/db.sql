-- ��� ���̺�
-- ����(PK) / �� / �� / ���� / �Ұ� �� ���� ������ ���� ���̺� ����� !
-- �����͵� 2�� ���� �ֱ� ~

CREATE TABLE apple (
    a_loc VARCHAR2(10 CHAR) PRIMARY KEY,
    a_color VARCHAR2(10 CHAR) NOT NULL,
    a_taste VARCHAR2(10 CHAR) NOT NULL,
    a_price NUMBER(5) DEFAULT 500,
    a_intro VARCHAR2(100 CHAR) NOT NULL
);

INSERT INTO APPLE VALUES('����', '����', '�ܸ�', 4000, '���ִ� ����� ���־�~');
INSERT INTO APPLE VALUES('����', '����', '�ܸ�', 3800, '������ ����� Ư��ǰ~');
SELECT * FROM APPLE;

INSERT INTO APPLE VALUES('NEWYORK', 'RED', 'SWEET', 4000, 'NewYork Apple ~ ');
INSERT INTO APPLE VALUES('MIAMI', 'RED', 'SWEET', 3800, 'Miami Apple ~ ');
INSERT INTO APPLE VALUES('CALIFORNIA', 'BLACK', 'SOUR', 4500, 'Califonia Apple ~ ');
INSERT INTO APPLE VALUES('GEORGIA', 'YELLOW', 'SALTY', 2700, 'Georgia Apple ~ ');
INSERT INTO APPLE VALUES('HAWAII', 'WHITE', 'SAVORY', 2500, 'Hawaii Apple ~ ');
INSERT INTO APPLE VALUES('FLORIDA', 'GREEN', 'NO', 3400, 'Florida Apple ~ ');
INSERT INTO APPLE VALUES('KENTUCKY', 'RED', 'SWEET', 3100, 'Kentucky Apple ~ ');
INSERT INTO APPLE VALUES('OHIO', 'YELLOW', 'SWEET', 4400, 'Ohio Apple ~ ');
INSERT INTO APPLE VALUES('TEXAS', 'GREEN', 'SOUR', 3600, 'Texas Apple ~ ');
INSERT INTO APPLE VALUES('ARIZONA', 'WHITE', 'SALTY', 2900, 'Arizona Apple ~ ');

-- ��ư ������ �� �Ķ���� ���� �޾Ƽ� �� �Ķ���� �� ���� �����͸� ����� �׿� �����ϴ� ������ ���
-- �ʱ�ȭ���� �Ķ������ �ʱⰪ












