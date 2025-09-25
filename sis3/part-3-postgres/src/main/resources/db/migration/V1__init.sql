create sequence if not exists app_user_seq start 1 increment 1;

create table if not exists app_user(
                                       id      bigint primary key default nextval('app_user_seq'),
    email   varchar(255) not null unique,
    profile jsonb not null default '{}'::jsonb
    );

create index if not exists idx_app_user_email on app_user(email);
create index if not exists idx_app_user_profile_gin on app_user using gin (profile);