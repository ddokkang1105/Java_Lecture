-- 1. ��Ʈ�Ͽ� ���� ���̺��� ����...
-- ��Ʈ���� �̸� / ���� / CPU / RAM / HDD / �����Ⱓ�� �Ӽ����� ���� �ϰ� ����
-- ���ǿ� �����ϴ� ���̺��� �����ϴ� ����
-- [�ϳ��� �⺻Ű(PK)�� �������ϰ�, ��� ���� ä���־�� ��]

-- 2. ��Ʈ���� ����� �������� 128GB ¥�� RAM�� ����ϰ� �Ǿ���
-- �� �� RAM �÷��� �뷮�� �����ϴ� ����

-- 3. ��Ʈ���� ũ�⿡ ���� �÷��� �߰��ϴ� ���� �ۼ�
-- [���� cm, �Ҽ��� �ι�° ¥������ ��Ÿ�� ��]
-- [�� �÷��� �� ������ ���� �� ����]

-- 4. ��Ʈ�Ͽ��� ������ HDD��ſ� SSD�� ������
-- HDD �÷��� �̸��� SSD �÷������� �����ϴ� ���� �ۼ�

-- 5. �����Ⱓ �÷��� �����ϴ� ���� �ۼ�

-- 6. ��Ʈ���� ������ [800000 ~ 2300000] ������ ���� �� �� �ְԲ�
-- �ش� �÷��� �����ϴ� ���� �ۼ�

-- 7. ���� ���̺��� ������ �����ϴ� ���� �ۼ�
-------------------------------------------------------------------------------------------------------------
create table laptop(
	l_name varchar2(20 char) primary key,
	l_price number(7) not null,
	l_cpu varchar2(12 char) not null,
	l_ram varchar2(4 char) default '8GB',
	l_hdd varchar2(5 char) default '100GB',
	l_repair varchar2(2 char) default '1��'
);

select * from laptop;

-- 2. ��Ʈ���� ����� �������� 128GB ¥�� RAM�� ����ϰ� �Ǿ���
-- �� �� RAM �÷��� �뷮�� �����ϴ� ����
alter table laptop modify l_ram varchar2(5 char) default '8GB';

-- 3. ��Ʈ���� ũ�⿡ ���� �÷��� �߰��ϴ� ���� �ۼ�
-- [���� cm, �Ҽ��� �ι�° ¥������ ��Ÿ�� ��]
-- [�� �÷��� �� ������ ���� �� ����]
alter table laptop add l_size number(5, 2) not null;
select * from laptop;

-- 4. ��Ʈ�Ͽ��� ������ HDD��ſ� SSD�� ������
-- HDD �÷��� �̸��� SSD �÷������� �����ϴ� ���� �ۼ�
alter table laptop rename column l_hdd to l_ssd;
alter table laptop modify l_ssd varchar2(4 char) default '1TB';
select * from laptop;

-- 5. �����Ⱓ �÷��� �����ϴ� ���� �ۼ�
alter table laptop drop column l_repair;
select * from laptop;

-- 6. ��Ʈ���� ������ [800000 ~ 2300000] ������ ���� �� �� �ְԲ�
-- �ش� �÷��� �����ϴ� ���� �ۼ�
-- alter table laptop modify l_price number(7) (l_price between 800000 and 2300000);
alter table laptop modify l_price number(7) check (l_price between 800000 and 2300000);
alter table laptop modify l_price number(7) constraint l_price2 check (l_price between 800000 and 2300000);
-- ���� ���� ����
alter table laptop DROP CONSTRAINT l_price2 CASCADE;
-- 
select * from laptop;

-- ������ �Է�
insert into laptop values('Test Laptop', 2199999, 'RYZEN-5600X', '128GB', default, 200.11);
truncate table laptop;
select * from laptop;

-- 7. ���� ���̺��� ������ �����ϴ� ���� �ۼ�
drop table laptop cascade constraint purge;
-------------------------------------------------------------------------------------------------------------
-- Ǯ�� --
-- 1. ��Ʈ�Ͽ� ���� ���̺��� ����...
-- ��Ʈ���� �̸� / ���� / CPU / RAM / HDD / �����Ⱓ�� �Ӽ����� ���� �ϰ� ����
-- ���ǿ� �����ϴ� ���̺��� �����ϴ� ����
-- [�ϳ��� �⺻Ű(PK)�� �������ϰ�, ��� ���� ä���־�� ��]
CREATE TABLE NOTEBOOK(
    N_NAME VARCHAR2(20 CHAR) PRIMARY KEY,
    N_PRICE NUMBER(7) NOT NULL,
    N_CPU VARCHAR2(10 CHAR) NOT NULL,
    N_RAM NUMBER(2) NOT NULL,
    N_HDD NUMBER(4) NOT NULL,
    N_WARRANTY DATE NOT NULL
);

-- 2. ��Ʈ���� ����� �������� 128GB ¥�� RAM�� ����ϰ� �Ǿ���
-- �� �� RAM �÷��� �뷮�� �����ϴ� ����
ALTER TABLE NOTEBOOK MODIFY N_RAM NUMBER(3);

-- 3. ��Ʈ���� ũ�⿡ ���� �÷��� �߰��ϴ� ���� �ۼ�
-- [���� cm, �Ҽ��� �ι�° ¥������ ��Ÿ�� ��]
-- [�� �÷��� �� ������ ���� �� ����]
ALTER TABLE NOTEBOOK ADD N_INCH NUMBER(4, 2) NOT NULL;

-- 4. ��Ʈ�Ͽ��� ������ HDD��ſ� SSD�� ������
-- HDD �÷��� �̸��� SSD �÷������� �����ϴ� ���� �ۼ�
ALTER TABLE NOTEBOOK RENAME COLUMN N_HDD TO N_SDD;

-- 5. �����Ⱓ �÷��� �����ϴ� ���� �ۼ�
ALTER TABLE NOTEBOOK DROP COLUMN N_WARRANTY;

-- 6. ��Ʈ���� ������ [800000 ~ 2300000] ������ ���� �� �� �ְԲ�
-- �ش� �÷��� �����ϴ� ���� �ۼ�
ALTER TABLE NOTEBOOK MODIFY N_PRICE NUMBER(7)
    CONSTRAINT N_CHECK CHECK(N_PRICE BETWEEN 800000 AND 2300000);

-- 7. ���� ���̺��� ������ �����ϴ� ���� �ۼ�
DROP TABLE NOTEBOOK CASCADE CONSTRAINT PURGE;







