create table accounts (acctnum int generated always as identity, profileid int, acctype varchar(15), accbalance int, primary key(acctnum));

create table profiles (profileid int generated always as identity, acctnum int, firstname varchar(15), lastname varchar(15),
zip int, email varchar(30), username varchar(20), password varchar(20), primary key (profileid), constraint fk_acctnum foreign key(acctnum) references accounts(acctnum));


alter sequence profiles_profileid_seq restart with 282;
alter sequence accounts_acctnum_seq restart with 868;



drop table if exists profiles;
drop table if exists accounts;


select * from profiles;
select * from accounts;

truncate profiles, accounts;

insert into profiles (firstname) values ('ron');
