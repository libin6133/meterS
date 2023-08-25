-- 初始化用于权限测试的组织用户
INSERT INTO user(id, name, email, password, create_time, update_time, language, last_organization_id, phone, source,
                 last_project_id, create_user, update_user, deleted)
VALUES ('PROJECT', 'PROJECT', 'PROJECT@fit2cloud.com', MD5('metersphere'),
        UNIX_TIMESTAMP() * 1000,
        UNIX_TIMESTAMP() * 1000, NULL, NUll, '', 'LOCAL', NULL, 'admin', 'admin', false);

-- 初始化一个用于权限测试的用户组，这里默认使用 PROJECT 作为ID，如果是组织和项目级别类似，便于根据权限的前缀找到对应测试的用户组
INSERT INTO user_role (id, name, description, internal, type, create_time, update_time, create_user, scope_id)
VALUES ('PROJECT', '项目级别权限校验', '', 1, 'PROJECT', 1620674220005, 1620674220000, 'admin', 'global');

-- 初始化用户和组的关系
INSERT INTO user_role_relation (id, user_id, role_id, source_id, create_time, create_user)
SELECT 'PROJECT', 'PROJECT', 'PROJECT', id, 1684747668375, 'admin' FROM project WHERE num = 100001;
