create sequence address_seq;

alter sequence address_seq owner to student;

create sequence external_contact_seq;

alter sequence external_contact_seq owner to student;

create sequence health_condition_seq;

alter sequence health_condition_seq owner to student;

create sequence medication_info_seq;

alter sequence medication_info_seq owner to student;

create sequence medication_seq;

alter sequence medication_seq owner to student;

create sequence patient_seq;

alter sequence patient_seq owner to student;

create sequence team_member_seq;

alter sequence team_member_seq owner to student;

create sequence trajectory_seq;

alter sequence trajectory_seq owner to student;

create sequence transport_assessment_seq;

alter sequence transport_assessment_seq owner to student;

create sequence transport_seq;

alter sequence transport_seq owner to student;

create sequence transport_team_seq;

alter sequence transport_team_seq owner to student;

create sequence vital_parameters_seq;

alter sequence vital_parameters_seq owner to student;

create table address
(
    id            bigint  not null
        primary key,
    city          varchar(255),
    country       varchar(255),
    post_code     integer not null,
    street_name   varchar(255),
    street_number integer not null
);

alter table address
    owner to student;

create table external_contact
(
    id             bigint not null
        primary key,
    contact_number varchar(255),
    first_name     varchar(255),
    function       varchar(255),
    hospital       varchar(255),
    last_name      varchar(255),
    unit           varchar(255)
);

alter table external_contact
    owner to student;

create table medication
(
    id   bigint not null
        primary key,
    name varchar(255)
);

alter table medication
    owner to student;

create table patient
(
    id                    bigint not null
        primary key,
    first_name            varchar(255),
    gender                smallint,
    last_name             varchar(255),
    patient_id_number     varchar(255),
    patient_intake_number varchar(255),
    address_id            bigint
        constraint fklpwpmtdbdvnxm8fxlxpq2fugh
            references address
);

alter table patient
    owner to student;

create table team_member
(
    id         bigint not null
        primary key,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255)
);

alter table team_member
    owner to student;

create table team_member_team_member_roles
(
    team_member_id    bigint not null
        constraint fkpbgcxawvx3exmxojj7mbseyiy
            references team_member,
    team_member_roles varchar(255)
);

alter table team_member_team_member_roles
    owner to student;

create table transport
(
    id                  bigint not null
        primary key,
    intervention_date   date,
    intervention_number bigint,
    mission_number      bigint,
    registration_date   date,
    team_member_id      bigint not null
        constraint fk5mvcs2dloev62vrekjvf0iqfe
            references team_member,
    patient_id          bigint
        constraint fkl0y5cbl1x4tylkibnlq601lim
            references patient
);

alter table transport
    owner to student;

create table health_condition
(
    id                 bigint not null
        primary key,
    airway             varchar(255),
    breathing          varchar(255),
    circulation        varchar(255),
    disability         varchar(255),
    exposure           varchar(255),
    extra_info         varchar(255),
    period             varchar(255),
    time_of_creation   date,
    time_of_evaluation date,
    transport_id       bigint
        constraint fk9r9nsds2s3mjv7ue61c0g0sb4
            references transport
);

alter table health_condition
    owner to student;

create table medication_info
(
    id                    bigint not null
        primary key,
    administrator         varchar(255),
    dose                  varchar(255),
    route                 smallint,
    time_of_administation timestamp(6),
    medication_id         bigint
        constraint fkkv0x96dfyrl3mk1wnvvdpnwro
            references medication,
    health_condition_id   bigint
        constraint fk1loc3lm50uwfy4594hwrexfwj
            references health_condition
);

alter table medication_info
    owner to student;

create table trajectory
(
    id                     bigint not null
        primary key,
    direction              varchar(255),
    klinical_rationale     varchar(255),
    non_klinical_rationale varchar(255),
    type_of_transport      varchar(255),
    receiver_id            bigint
        constraint fkfdf6emk73ttb90f9hoc8db34j
            references external_contact,
    referrer_id            bigint
        constraint fkftu4xmo5jjkju0qtedh8fala1
            references external_contact,
    transport_id           bigint
        constraint fkp3sukfvjrjxt0wf4g7f1fo7ul
            references transport
);

alter table trajectory
    owner to student;

create table transport_assessment
(
    id                    bigint  not null
        primary key,
    artificial_airway     integer not null,
    cardial_monitoring    integer not null,
    heart_rhythm          integer not null,
    hemodynamic_state     integer not null,
    iv_access             integer not null,
    neurlogical_state     integer not null,
    pacemaker             integer not null,
    pharmaco_or_extra_cor integer not null,
    respitory_rate        integer not null,
    total_score           integer not null,
    transport_id          bigint
        constraint fkf7t7ofkg2aq70oxuq3lhfmqag
            references transport
);

alter table transport_assessment
    owner to student;

create table transport_team
(
    id                     bigint not null
        primary key,
    additional_people      varchar(255),
    expert                 varchar(255),
    partner                varchar(255),
    ambulance_driver_id    bigint
        constraint fk26qqc3mmmqhklk8tbojugjp4v
            references team_member,
    patient_responsible_id bigint
        constraint fkk13iti1wxfr0vwrxy59a4lil4
            references team_member,
    transport_id           bigint
        constraint fksbmxkux850kc05rtixhl752g2
            references transport,
    transport_organizer_id bigint
        constraint fkil7ddl5k03crvbtayfrhd0rwq
            references team_member
);

alter table transport_team
    owner to student;

create table vital_parameters
(
    id                  bigint           not null
        primary key,
    blood_pressure      varchar(255),
    etco2               double precision not null,
    glycemie            varchar(255),
    pulse               integer          not null,
    respitory_rate      integer          not null,
    saturation          varchar(255),
    temperature         double precision not null,
    time_of_evaluation  timestamp(6),
    health_condition_id bigint
        constraint fk2bhte8leojowbpp02opgkwfcs
            references health_condition
);

alter table vital_parameters
    owner to student;


