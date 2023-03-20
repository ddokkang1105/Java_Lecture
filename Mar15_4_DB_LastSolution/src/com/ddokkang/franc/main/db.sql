-- � Ư���� �Ĵ翡 ���� ���̺�
-- �Ĵ� ����(ü���� ����), �Ĵ� ����, �¼� ��
-- ���� ������ 2 ~ 3���� �ֱ�

create table mar16_restaurant(
    r_location varchar2(10 char) primary key,
    r_owner varchar2(10 char) not null,
    r_seat number(3) not null
);

insert into mar16_restaurant values('����', 'ȫ�浿', 100);
insert into mar16_restaurant values('����', '��浿', 80);

-- ���� ���̺� 
-- ������ �̸�, ���� �ð�, ������ ��ȭ��ȣ, ���� ����
-- ���� ������ 2 ~ 3���� �ֱ�

create table mar16_reservation(
    r_no number(3) primary key,
    r_name varchar2(10 char) not null,
    r_time date not null,
    r_phonenum varchar2(20 char) not null,
    r_location varchar2(10 char) not null
);

create sequence mar16_reservation_seq;

insert into mar16_reservation values(mar16_reservation_seq.nextval, '�ֱ浿',
	to_date('2023-03-17 18:00', 'YYYY-MM-DD HH24:MI'), '010-1111-2222', '����');
insert into mar16_reservation values(mar16_reservation_seq.nextval, '�̱浿',
	to_date('2023-03-17 14:00', 'YYYY-MM-DD HH24:MI'), '010-2222-3333', '����');
insert into mar16_reservation values(mar16_reservation_seq.nextval, '�̱浿',
	to_date('2023-03-19 17:00', 'YYYY-MM-DD HH24:MI'), '010-3333-4444', '����');







