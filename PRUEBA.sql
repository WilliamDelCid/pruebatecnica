/*
 Navicat Premium Data Transfer

 Source Server         : ORACLE
 Source Server Type    : Oracle
 Source Server Version : 190000
 Source Schema         : PRUEBA

 Target Server Type    : Oracle
 Target Server Version : 190000
 File Encoding         : 65001

 Date: 23/04/2023 13:37:07
*/


-- ----------------------------
-- Table structure for usuarios
-- ----------------------------
DROP TABLE "PRUEBA"."usuarios";
CREATE TABLE "PRUEBA"."usuarios" (
  "idUser" NUMBER VISIBLE DEFAULT "PRUEBA"."ISEQ$$_73106".nextval NOT NULL,
  "user" VARCHAR2(250 BYTE) VISIBLE NOT NULL,
  "password" VARCHAR2(250 BYTE) VISIBLE NOT NULL,
  "rol" VARCHAR2(255 BYTE) VISIBLE NOT NULL
)
LOGGING
NOCOMPRESS
PCTFREE 10
INITRANS 1
STORAGE (
  INITIAL 65536 
  NEXT 1048576 
  MINEXTENTS 1
  MAXEXTENTS 2147483645
  BUFFER_POOL DEFAULT
)
PARALLEL 1
NOCACHE
DISABLE ROW MOVEMENT
;

-- ----------------------------
-- Records of usuarios
-- ----------------------------
INSERT INTO "PRUEBA"."usuarios" VALUES ('39', 'Administrador', '$2a$10$l7AtHSy0GemEzWnM6SPtduRlzB8Ke4BngQxNaWgaNIR2OXHK2PygC', 'Administrador');
INSERT INTO "PRUEBA"."usuarios" VALUES ('41', 'Pasante', '$2a$10$ONvmXZgh3V55J082upVQ1OYWSMAFlT82q86wZloc8OEpfYYfZoBbi', 'Administrador');

-- ----------------------------
-- Sequence structure for ISEQ$$_73103
-- ----------------------------
DROP SEQUENCE "PRUEBA"."ISEQ$$_73103";
CREATE SEQUENCE "PRUEBA"."ISEQ$$_73103" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 CACHE 20;

-- ----------------------------
-- Sequence structure for ISEQ$$_73106
-- ----------------------------
DROP SEQUENCE "PRUEBA"."ISEQ$$_73106";
CREATE SEQUENCE "PRUEBA"."ISEQ$$_73106" MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 CACHE 20;

-- ----------------------------
-- Sequence structure for SEC_ID
-- ----------------------------
DROP SEQUENCE "PRUEBA"."SEC_ID";
CREATE SEQUENCE "PRUEBA"."SEC_ID" MINVALUE 1 MAXVALUE 9999 INCREMENT BY 1 CACHE 20;

-- ----------------------------
-- Primary Key structure for table usuarios
-- ----------------------------
ALTER TABLE "PRUEBA"."usuarios" ADD CONSTRAINT "SYS_C007442" PRIMARY KEY ("idUser");

-- ----------------------------
-- Checks structure for table usuarios
-- ----------------------------
ALTER TABLE "PRUEBA"."usuarios" ADD CONSTRAINT "SYS_C007441" CHECK ("idUser" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PRUEBA"."usuarios" ADD CONSTRAINT "SYS_C007456" CHECK ("user" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PRUEBA"."usuarios" ADD CONSTRAINT "SYS_C007457" CHECK ("password" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
ALTER TABLE "PRUEBA"."usuarios" ADD CONSTRAINT "SYS_C007458" CHECK ("rol" IS NOT NULL) NOT DEFERRABLE INITIALLY IMMEDIATE NORELY VALIDATE;
