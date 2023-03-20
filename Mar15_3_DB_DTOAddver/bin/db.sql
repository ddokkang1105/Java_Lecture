-- � Ư���� �Ĵ翡 ���� ���̺�
-- �Ĵ� ����(ü���� ����), �Ĵ� ����, �¼� ��
create table mar15_pizzarestaurant(
    p_no number(2) primary key,
    p_location varchar2(10 char) not null,
    p_owner varchar2(10 char) not null,
    p_seat number(4) not null
);

create sequence mar15_pizzarestaurant_seq;

-- ���� ���̺� 
-- ������ �̸�, ���� �ð�, ������ ��ȭ��ȣ, ���� ����
create table mar15_reservation(
    r_no number(2) primary key,
    r_name varchar2(10 char) not null,
    r_time date not null,
    r_phonenum varchar2(20 char) not null,
    r_location varchar2(10 char) not null
);

create sequence mar15_reservation_seq;

-- ���� ������ 2 ~ 3���� �ֱ�

insert into mar15_reservation values(mar15_reservation_seq, '������', to_date('2023-03-18 16', 'YYYY-MM-DD HH24'), '010-1111-1111', '������');
-- 1	������	2023-03-18 16:00:00	010-1111-1111	1
-- 2	������	2023-03-19 15:00:00	010-1111-2222	2
-- 3	�����	2023-03-24 12:00:00	010-1111-3333	3
-- 4	�輺��	2023-03-17 16:00:00	010-1111-4444	1
-- 5	������	2023-03-22 15:00:00	010-1111-5555	2
-- 6	�����	2023-03-23 12:00:00	010-1111-6666	3

-- 1	������	�踸��	81
-- 2	��ġ��	������	67
-- 3	������	�ֿ���	117

