insert into currencies("currency_type", "close")
values ('KZT', 466.859);
insert into currencies("currency_type", "close")
values ('RUB', 64.875);

insert into limits("bank_account", "limit_type", "limit_currency_shortname", "limit_datetime", "limit_remains", "limit_sum")
values (3412501239, 'product', 'USD', '2022-12-19 00:27:42+06:00', 1200.0, 1500.0);
insert into limits("bank_account", "limit_type", "limit_currency_shortname", "limit_datetime", "limit_remains", "limit_sum")
values (3412501239, 'service', 'USD', '2022-12-19 00:27:42+06:00', 2700.0, 2700.0);
insert into limits("bank_account", "limit_type", "limit_currency_shortname", "limit_datetime", "limit_remains", "limit_sum")
values (9830124573, 'product', 'USD', '2022-12-19 00:27:42+06:00', -700.5, 1000.0);
insert into limits("bank_account", "limit_type", "limit_currency_shortname", "limit_datetime", "limit_remains", "limit_sum")
values (9830124573, 'service', 'USD', '2022-12-19 00:27:42+06:00', 0, 900.8);

-- insert into transactions("transaction_id", "account_from", "account_to", "currency_short_name", "date_time", "expense_category", "limit_exceeded", "sum")