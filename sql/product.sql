-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('清单列表', '3', '1', 'product', 'tool/product/index', 1, 0, 'C', '0', '0', 'tool:product:list', '#', 'admin', sysdate(), '', null, '清单列表菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('清单列表查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'tool:product:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('清单列表新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'tool:product:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('清单列表修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'tool:product:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('清单列表删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'tool:product:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('清单列表导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'tool:product:export',       '#', 'admin', sysdate(), '', null, '');

-- auto-generated definition
-- auto-generated definition
create table product
(
    ID      varchar(32) not null
        primary key,
    BUYLIST varchar(10) null,
    status  char        null,
	MAKER           varchar(32) null,
    MOD_DATETIME    datetime    null,
    CHECKER         varchar(10) null,
    CHCKER_DATETIME datetime    null
);



-- auto-generated definition
create table buyList
(
    ID              varchar(32) not null primary key,
    PRODUCTID       varchar(32) null,
    ASSET_TYPE      varchar(10) null,
    PRODUCT_CODE    varchar(10) null,
    MAKER           varchar(32) null,
    MOD_DATETIME    datetime    null,
    CHECKER         varchar(10) null,
    CHCKER_DATETIME datetime    null,
    STATUS          char        null
);

INSERT INTO poc.buyList (ID, PRODUCTID, ASSET_TYPE, PRODUCT_CODE, MAKER, MOD_DATETIME, CHECKER, CHCKER_DATETIME, STATUS) VALUES ('123456', null, 'Stock', 'TSLA', '8808103', '2025-04-28 10:49:00', null, null, null);
INSERT INTO poc.buyList (ID, PRODUCTID, ASSET_TYPE, PRODUCT_CODE, MAKER, MOD_DATETIME, CHECKER, CHCKER_DATETIME, STATUS) VALUES ('1234567', null, 'Bond', 'PNG002531', '8808103', '2025-04-28 10:51:19', null, null, null);


INSERT INTO poc.product (ID, BUYLIST, status, MAKER, MOD_DATETIME, CHECKER, CHCKER_DATETIME) VALUES ('B00001', 'Buy List A', '1', '8808103', '2025-04-28 11:08:11', null, null);
