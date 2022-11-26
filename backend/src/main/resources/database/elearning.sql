--DDL
CREATE TABLE roles(
id serial,
role_code varchar(10) NOT NULL,
role_name varchar(20) NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);

ALTER TABLE roles ADD CONSTRAINT roles_pk PRIMARY KEY(id);
ALTER TABLE roles ADD CONSTRAINT roles_bk UNIQUE(role_code);
ALTER TABLE roles ADD CONSTRAINT roles_ck UNIQUE(role_code, role_name);

CREATE TABLE files(
id serial,
file_code text NOT NULL,
file_ext text NOT NULL,
	
created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE files ADD CONSTRAINT files_pk PRIMARY KEY(id);

CREATE TABLE users(
id serial,
email text NOT NULL,
password text NOT NULL,
fullname text NOT NULL,

role_id int NOT NULL,
photo_id int,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE users ADD CONSTRAINT users_pk PRIMARY KEY(id);
ALTER TABLE users ADD CONSTRAINT users_bk UNIQUE(email);
ALTER TABLE users ADD CONSTRAINT roles_users_fk FOREIGN KEY(role_id) REFERENCES roles(id);
ALTER TABLE users ADD CONSTRAINT files_users_fk FOREIGN KEY(photo_id) REFERENCES files(id);

CREATE TABLE classes(
id serial,
class_code varchar(10) NOT NULL,
class_subject varchar(200) NOT NULL,
class_description text NOT NULL,

instructor_id int NOT NULL,
photo_id int,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE classes ADD CONSTRAINT classes_pk PRIMARY KEY(id);
ALTER TABLE classes ADD CONSTRAINT classes_bk UNIQUE(class_code);
ALTER TABLE classes ADD CONSTRAINT users_classes_fk FOREIGN KEY(instructor_id) REFERENCES users(id);
ALTER TABLE classes ADD CONSTRAINT files_classes_fk FOREIGN KEY(photo_id) REFERENCES files(id);

CREATE TABLE classes_dtl(
id serial,

student_id int NOT NULL,
class_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE classes_dtl ADD CONSTRAINT classes_dtl_pk PRIMARY KEY(id);
ALTER TABLE classes_dtl ADD CONSTRAINT users_classes_dtl_fk FOREIGN KEY(student_id) REFERENCES users(id);
ALTER TABLE classes_dtl ADD CONSTRAINT classes_classes_dtl_fk FOREIGN KEY(class_id) REFERENCES classes(id);

CREATE TABLE learning_material(
id serial,
learning_code varchar(10) NOT NULL,
learning_subject varchar(200) NOT NULL,
learning_description text NOT NULL,

class_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE learning_material ADD CONSTRAINT learning_material_pk PRIMARY KEY(id);
ALTER TABLE learning_material ADD CONSTRAINT learning_material_bk UNIQUE(learning_code);
ALTER TABLE learning_material ADD CONSTRAINT classes_learning_material_fk FOREIGN KEY(class_id) REFERENCES classes(id);

CREATE TABLE quiz_material(
id serial,
quiz_code varchar(10) NOT NULL,
quiz_subject varchar(200) NOT NULL,
quiz_description text NOT NULL,

class_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE quiz_material ADD CONSTRAINT quiz_material_pk PRIMARY KEY(id);
ALTER TABLE quiz_material ADD CONSTRAINT quiz_material_bk UNIQUE(quiz_code);
ALTER TABLE quiz_material ADD CONSTRAINT classes_quiz_material_fk FOREIGN KEY(class_id) REFERENCES classes(id);

CREATE TABLE exam_material(
id serial,
exam_code varchar(10) NOT NULL,
exam_subject varchar(200) NOT NULL,
exam_description text NOT NULL,

class_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE exam_material ADD CONSTRAINT exam_material_pk PRIMARY KEY(id);
ALTER TABLE exam_material ADD CONSTRAINT exam_material_bk UNIQUE(exam_code);
ALTER TABLE exam_material ADD CONSTRAINT classes_exam_material_fk FOREIGN KEY(class_id) REFERENCES classes(id);

CREATE TABLE learning_attach(
id serial,

learning_id int NOT NULL,
file_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE learning_attach ADD CONSTRAINT learning_attach_pk PRIMARY KEY(id);
ALTER TABLE learning_attach ADD CONSTRAINT learning_material_learning_attach_fk FOREIGN KEY(learning_id) REFERENCES learning_material(id);
ALTER TABLE learning_attach ADD CONSTRAINT files_learning_attach_fk FOREIGN KEY(file_id) REFERENCES files(id);

CREATE TABLE quiz_attach(
id serial,

quiz_id int NOT NULL,
file_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE quiz_attach ADD CONSTRAINT quiz_attach_pk PRIMARY KEY(id);
ALTER TABLE quiz_attach ADD CONSTRAINT quiz_material_quiz_attach_fk FOREIGN KEY(quiz_id) REFERENCES quiz_material(id);
ALTER TABLE quiz_attach ADD CONSTRAINT files_quiz_attach_fk FOREIGN KEY(file_id) REFERENCES files(id);

CREATE TABLE exam_attach(
id serial,

exam_id int NOT NULL,
file_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE exam_attach ADD CONSTRAINT exam_attach_pk PRIMARY KEY(id);
ALTER TABLE exam_attach ADD CONSTRAINT exam_material_exam_attach_fk FOREIGN KEY(exam_id) REFERENCES exam_material(id);
ALTER TABLE exam_attach ADD CONSTRAINT files_exam_attach_fk FOREIGN KEY(file_id) REFERENCES files(id);

CREATE TABLE learning_schedule(
id serial,
start_time timestamp WITHOUT TIME ZONE NOT NULL,
end_time timestamp WITHOUT TIME ZONE NOT NULL,

learning_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE learning_schedule ADD CONSTRAINT learning_schedule_pk PRIMARY KEY(id);
ALTER TABLE learning_schedule ADD CONSTRAINT learning_material_learning_schedule_pk FOREIGN KEY(learning_id) REFERENCES learning_material(id);

CREATE TABLE quiz_schedule(
id serial,
start_time timestamp WITHOUT TIME ZONE NOT NULL,
end_time timestamp WITHOUT TIME ZONE NOT NULL,

quiz_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE quiz_schedule ADD CONSTRAINT quiz_schedule_pk PRIMARY KEY(id);
ALTER TABLE quiz_schedule ADD CONSTRAINT quiz_material_quiz_schedule_pk FOREIGN KEY(quiz_id) REFERENCES quiz_material(id);

CREATE TABLE exam_schedule(
id serial,
start_time timestamp WITHOUT TIME ZONE NOT NULL,
end_time timestamp WITHOUT TIME ZONE NOT NULL,

exam_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE exam_schedule ADD CONSTRAINT exam_schedule_pk PRIMARY KEY(id);
ALTER TABLE exam_schedule ADD CONSTRAINT exam_material_quiz_schedule_pk FOREIGN KEY(exam_id) REFERENCES exam_material(id);

CREATE TABLE quiz_collection(
id serial,
score float,

class_dtl_id int NOT NULL,
schedule_id int NOT NULL,
file_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE quiz_collection ADD CONSTRAINT quiz_collection_pk PRIMARY KEY(id);
ALTER TABlE quiz_collection ADD CONSTRAINT classes_dtl_quiz_collection_fk FOREIGN KEY(class_dtl_id) REFERENCES classes_dtl(id);
ALTER TABLE quiz_collection ADD CONSTRAINT quiz_schedule_quiz_collection_fk FOREIGN KEY(schedule_id) REFERENCES quiz_schedule(id);
ALTER TABLE quiz_collection ADD CONSTRAINT files_quiz_collection_fk FOREIGN KEY(file_id) REFERENCES files(id);

CREATE TABLE exam_collection(
id serial,
score float,

class_dtl_id int NOT NULL,
schedule_id int NOT NULL,
file_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE exam_collection ADD CONSTRAINT exam_collection_pk PRIMARY KEY(id);
ALTER TABlE exam_collection ADD CONSTRAINT classes_dtl_exam_collection_fk FOREIGN KEY(class_dtl_id) REFERENCES classes_dtl(id);
ALTER TABLE exam_collection ADD CONSTRAINT exam_schedule_exam_collection_fk FOREIGN KEY(schedule_id) REFERENCES exam_schedule(id);
ALTER TABLE exam_collection ADD CONSTRAINT files_exam_collection_fk FOREIGN KEY(file_id) REFERENCES files(id);

CREATE TABLE attendance(
id serial,
approval boolean DEFAULT FALSE,

class_dtl_id int NOT NULL,
learning_schedule_id int DEFAULT NULL,
quiz_schedule_id int DEFAULT NULL,
exam_schedule_id int DEFAULT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE attendance ADD CONSTRAINT attendance_pk PRIMARY KEY(id);
ALTER TABLE attendance ADD CONSTRAINT classes_dtl_id_attendance_fk FOREIGN KEY(class_dtl_id) REFERENCES classes_dtl(id);
ALTER TABLE attendance ADD CONSTRAINT learning_schedule_attendance_fk FOREIGN KEY(learning_schedule_id) REFERENCES learning_schedule(id);
ALTER TABLE attendance ADD CONSTRAINT quiz_schedule_attendance_fk FOREIGN KEY(quiz_schedule_id) REFERENCES quiz_schedule(id);
ALTER TABLE attendance ADD CONSTRAINT exam_schedule_attendance_fk FOREIGN KEY(exam_schedule_id) REFERENCES exam_schedule(id);

CREATE TABLE forums(
id serial,
title varchar(200) NOT NULL,
content text NOT NULL,

class_dtl_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE forums ADD CONSTRAINT forum_pk PRIMARY KEY(id);
ALTER TABLE forums ADD CONSTRAINT classes_dtl_forum_fk FOREIGN KEY(class_dtl_id) REFERENCES classes_dtl(id);

CREATE TABLE comments(
id serial,
comment text NOT NULL,

forum_id int NOT NULL,

created_by int NOT NULL,
created_at timestamp WITHOUT TIME ZONE NOT NULL,
updated_by int,
updated_at timestamp WITHOUT TIME ZONE,
ver int NOT NULL DEFAULT 0,
is_active boolean NOT NULL DEFAULT TRUE
);
ALTER TABLE comments ADD CONSTRAINT comments_pk PRIMARY KEY(id);
ALTER TABLE comments ADD CONSTRAINT forums_comments_fk FOREIGN KEY(forum_id) REFERENCES forums(id);

--DML
INSERT INTO roles (role_code, role_name, created_by, created_at) VALUES
('ROL001', 'Super Admin', 1, now()),
('ROL002', 'Pengajar', 1, now()),
('ROL003', 'Siswa', 1, now()),
('ROL004', 'System', 1, now());

INSERT INTO users (email, password, fullname, role_id, created_by, created_at) VALUES
('system@rezimaulana.link', '$2a$10$mQ77inhXemDEE0zlr9kwc.94nqJERo1uHIsaPjesr0upzK1Hm6cWa', 'USERSYSTEM', 4, 1, now()),
('admin@email.com', '$2a$10$mQ77inhXemDEE0zlr9kwc.94nqJERo1uHIsaPjesr0upzK1Hm6cWa', 'Super Admin', 1, 1, now()),
('siswa@email.com', '$2a$10$mQ77inhXemDEE0zlr9kwc.94nqJERo1uHIsaPjesr0upzK1Hm6cWa', 'Student', 3, 1, now()),
('guru@email.com', '$2a$10$mQ77inhXemDEE0zlr9kwc.94nqJERo1uHIsaPjesr0upzK1Hm6cWa', 'Instructor', 2, 2, now());

--INSERT INTO classes (class_code, class_subject, class_description, instructor_id, created_by, created_at) VALUES
--('CLS005', 'Kelas Java', 'Java Essentials on 1 Month', 4, 2, now());
--
--INSERT INTO learning_material (learning_code, learning_subject, learning_description, class_id, created_by, created_at) VALUES
--('LMA001', 'Belajar Java 1', 'Deskripsi.', 1, 4, now());
--
--INSERT INTO quiz_material (quiz_code, quiz_subject, quiz_description, class_id, created_by, created_at) VALUES
--('QUZ001', 'Quiz Java 1', 'Deskripsi.', 1, 4, now());
--
--INSERT INTO exam_material (exam_code, exam_subject, exam_description, class_id, created_by, created_at) VALUES
--('EXM001', 'Exam Java 1', 'Deskripsi.', 1, 4, now());
--
--INSERT INTO learning_schedule (start_time, end_time, learning_id, created_by, created_at) VALUES
--(now() + interval '1 day', now() + interval '2 day', 1, 4, now());
--
--INSERT INTO quiz_schedule (start_time, end_time, quiz_id, created_by, created_at) VALUES
--(now() + interval '1 day', now() + interval '2 day', 1, 4, now());
--
--INSERT INTO exam_schedule (start_time, end_time, exam_id, created_by, created_at) VALUES
--(now() + interval '1 day', now() + interval '2 day', 1, 4, now());
--
--INSERT INTO files (file_code, file_ext, created_by, created_at) VALUES
--('file', 'pdf', 4, now()),
--('file', 'pdf', 4, now()),
--('file', 'pdf', 4, now());
--
--INSERT INTO learning_attach (learning_id, file_id, created_by, created_at) VALUES
--(1, 1, 4, now());
--
--INSERT INTO quiz_attach (quiz_id, file_id, created_by, created_at) VALUES
--(1, 2, 4, now());
--
--INSERT INTO exam_attach (exam_id, file_id, created_by, created_at) VALUES
--(1, 3, 4, now());