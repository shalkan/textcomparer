DROP TABLE IF EXISTS text_value_history_table;

DROP SEQUENCE IF EXISTS text_value_history_table_id_seq;

DROP TABLE IF EXISTS text_value_table;

DROP SEQUENCE IF EXISTS text_value_table_id_seq;

CREATE SEQUENCE text_value_table_id_seq
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1;

CREATE TABLE text_value_table (
  id bigint NOT NULL DEFAULT nextval('text_value_table_id_seq'),
  text_value character varying,
  aud_when timestamp without time zone DEFAULT now(),
  aud_when_create timestamp without time zone DEFAULT now(),
  CONSTRAINT text_value_pk PRIMARY KEY (id)
);

CREATE SEQUENCE text_value_history_table_id_seq
 INCREMENT 1
 MINVALUE 1
 MAXVALUE 9223372036854775807
 START 1;

CREATE TABLE text_value_history_table (
  id bigint NOT NULL DEFAULT nextval('text_value_history_table_id_seq'),
  when_edit timestamp without time zone DEFAULT now(),
  text_value_id bigint,
  text_value character varying,
  CONSTRAINT text_value_history_pk PRIMARY KEY (id),
  CONSTRAINT text_value_history_text_value_fk FOREIGN KEY (text_value_id) REFERENCES text_value_table (id)
);