prompt PL/SQL Developer import file
prompt Created on 2018Äê12ÔÂ1ÈÕ by admin
set feedback off
set define off
prompt Creating TB_USER...
create table TB_USER
(
  id       NUMBER(10) not null,
  username VARCHAR2(20),
  password VARCHAR2(20),
  role_id  NUMBER(10)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
alter table TB_USER
  add primary key (ID)
  using index 
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt Disabling triggers for TB_USER...
alter table TB_USER disable all triggers;
prompt Deleting TB_USER...
delete from TB_USER;
commit;
prompt Loading TB_USER...
insert into TB_USER (id, username, password, role_id)
values (1, 'teacher', '123', 1);
insert into TB_USER (id, username, password, role_id)
values (2, 'student', '123', 2);
commit;
prompt 2 records loaded
prompt Enabling triggers for TB_USER...
alter table TB_USER enable all triggers;
set feedback on
set define on
prompt Done.
