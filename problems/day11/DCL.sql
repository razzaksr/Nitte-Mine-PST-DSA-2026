create user 'manager' identified by  'icici1';
create user 'customer' identified by  'icici2';

show grants;

grant insert, delete, select on creditcard to 'manager';
grant update, select on creditcard to 'customer';
show grants for manager;
show grants for customer;

flush privileges;

revoke select on creditcard from customer;
flush privileges;