create table currencies
(
    currency_type varchar primary key,
    close         double precision
);

create table limits
(
    bank_account             bigint  not null,
    limit_type               varchar not null,
    limit_currency_shortname varchar,
    limit_datetime           varchar,
    limit_remains            double precision,
    limit_sum                double precision,
    primary key (bank_account, limit_type)
);

create table transactions
(
    transaction_id      bigserial
        primary key,
    account_from        bigint,
    account_to          bigint,
    currency_short_name varchar,
    date_time           varchar,
    expense_category    varchar,
    limit_exceeded      boolean,
    sum                 double precision
);