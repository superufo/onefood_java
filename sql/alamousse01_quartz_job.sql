INSERT INTO alamousse01.quartz_job (id, bean_name, cron_expression, is_pause, job_name, method_name, params, remark, update_time) VALUES (1, 'visitsTask', '0 0 0 * * ?', false, '更新访客记录', 'run', null, '每日0点创建新的访客记录', '2019-01-08 14:53:31');
INSERT INTO alamousse01.quartz_job (id, bean_name, cron_expression, is_pause, job_name, method_name, params, remark, update_time) VALUES (2, 'testTask', '0/5 * * * * ?', true, '测试1', 'run1', 'test', '带参测试，多参使用json', '2019-01-13 14:20:50');
INSERT INTO alamousse01.quartz_job (id, bean_name, cron_expression, is_pause, job_name, method_name, params, remark, update_time) VALUES (3, 'testTask', '0/5 * * * * ?', true, '测试', 'run', '', '不带参测试', '2019-04-09 16:16:44');