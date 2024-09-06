-- create database todo_list;

drop table if exists missions;
create table if not exists missions(
	id int auto_increment primary key,
    name varchar(50) not null,
    description varchar(255),
    completed boolean default false not null,
    created_time timestamp not null,
    last_completed_time timestamp,
    hidden boolean default false not null,
    created_by varchar(50) not null,
    last_modified_by varchar(50) not null
);

drop table if exists audit_log;
create table if not exists audit_log(
	id int auto_increment primary key,
    user_ip varchar(50) not null,
    happened_datetime timestamp default current_timestamp,
    operation varchar(50) not null,
    mission_id int not null,
    content JSON not null,
    table_name varchar(50) not null
);

drop trigger if exists audit_log_trigger_update;
delimiter //
create trigger audit_log_trigger_update after update on missions 
for each row
begin
	declare content json default json_object();
    if new.name <> old.name then
		set content = json_merge_patch(content,json_object("name", new.name));
    end if;
    if new.description <> old.description then
		set content = json_merge_patch(content,json_object("description", new.description));
    end if;
	if new.completed <> old.completed then
		set content = json_merge_patch(content,json_object("completed", new.completed));
    end if;
    if new.created_time <> old.created_time then
		set content = json_merge_patch(content,json_object("created_time", new.created_time));
    end if;
    if new.last_completed_time <> old.last_completed_time or (old.last_completed_time is null and new.last_completed_time is not null) then
		set content = json_merge_patch(content,json_object("last_completed_time", new.last_completed_time));
    end if;
    if new.hidden <> old.hidden then
		set content = json_merge_patch(content,json_object("hidden", new.hidden));
    end if;
    if new.last_modified_by <> old.last_modified_by then
		set content = json_merge_patch(content,json_object("last_modified_by", new.last_modified_by));
    end if;

	insert into audit_log(user_ip, operation, mission_id, content, table_name)
    values (new.last_modified_by, 'UPDATE', new.id, content, "missions");
end;
//

create trigger audit_log_trigger_insert after insert on missions
for each row
begin
	declare content json default json_object();
    set content = json_object('name',new.name, 'description', new.description);
	insert into audit_log(user_ip, operation, mission_id, content, table_name)
    values (new.last_modified_by, 'insert', new.id, content, "missions");
end;
//

delimiter ;

truncate audit_log;
truncate missions;
select * from todo_list.missions;
select * from todo_list.audit_log;