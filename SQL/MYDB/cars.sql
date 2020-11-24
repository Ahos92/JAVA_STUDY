CREATE TABLE cars(
    car_number varchar2(15) constraint car_num_pk primary key,
    car_color varchar2(15) constraint car_color_nn not null
                            constraint car_color_ck check (car_color in('black', 'white', 'red', 'blue', 'yellow')),
    car_cc number(6) constraint car_cc_nn not null,
    car_size varchar2(5) constraint car_size_nn not null
                        constraint car_size_ck check (car_size in('light', 'small', 'mid', 'large')),
    car_engine varchar2(10) constraint car_engine_nn not null
                            constraint car_engine_ck check (car_engine in('gasoline', 'disel', 'lpg')),
    car_type number(2) constraint car_type_nn not null,
    car_usage number(3) constraint car_usage_nn not null
);

CREATE TABLE cartypes (
    type_id number(2) constraint type_id_pk primary key,
    type_name varchar2(20) constraint type_name_uk UNIQUE
);

CREATE TABLE usages (
    usage_id number(3) constraint usage_id_pk primary key,
    usage_name varchar2(20) constraint usage_name_uk UNIQUE
);

INSERT INTO cartypes (type_id, type_name) VALUES (10, 'car');
INSERT INTO cartypes (type_id, type_name) VALUES (20, 'van');
INSERT INTO cartypes (type_id, type_name) VALUES (30, 'freight car');
INSERT INTO cartypes (type_id, type_name) VALUES (40, 'Special vehicle');


INSERT INTO usages (usage_id, usage_name) VALUES (100, 'own car');
INSERT INTO usages (usage_id, usage_name) VALUES (200, 'for business');
INSERT INTO usages (usage_id, usage_name) VALUES (300, 'rent car');


ALTER TABLE cars ADD CONSTRAINT type_id_fk FOREIGN KEY (type_id) REFERENCES cartypes (type_id);
ALTER TABLE cars ADD CONSTRAINT usage_id_fk FOREIGN KEY (usage_id) REFERENCES usages (usage_id);


select * from cartypes;
select * from usages;
select * from cars;

delete from cars;

select * from user_constraints where table_name='CARS';
select * from user_constraints where table_name='CARTYPES';
select * from user_constraints where table_name='USAGES';


commit;