DROP USER IF EXISTS crm_user;
create user if not exists 'crm_user'@'localhost';
grant all on customer_db.* to 'crm_user'@'localhost';
flush privileges;