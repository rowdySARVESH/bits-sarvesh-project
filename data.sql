-- Initializing Primary Entities (Athletes)
INSERT INTO athletes (name, email, weight_class) VALUES ('Anvesh Nimbalkar', 'anvesh@registry.sys', '83kg');
INSERT INTO athletes (name, email, weight_class) VALUES ('Sarthak Chintawar', 'sarthak@registry.sys', '93kg');
INSERT INTO athletes (name, email, weight_class) VALUES ('Pratham Borkar', 'pratham@registry.sys', '74kg');
INSERT INTO athletes (name, email, weight_class) VALUES ('Vivek Zade', 'vivek@registry.sys', '105kg');
INSERT INTO athletes (name, email, weight_class) VALUES ('Manav Chahare', 'manav@registry.sys', '83kg');
INSERT INTO athletes (name, email, weight_class) VALUES ('Dweep Gadge', 'dweep@registry.sys', '93kg');
INSERT INTO athletes (name, email, weight_class) VALUES ('Akshad Pocham', 'akshad@registry.sys', '120kg');
INSERT INTO athletes (name, email, weight_class) VALUES ('Bablu Shekhawat', 'bablu@registry.sys', '74kg');
INSERT INTO athletes (name, email, weight_class) VALUES ('Kirtan Ghosla', 'kirtan@registry.sys', '83kg');
INSERT INTO athletes (name, email, weight_class) VALUES ('Pranav Khadse', 'pranav@registry.sys', '93kg');

-- Initializing Child Entities (Inner Join verification targets)
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Squat', 210.0, '2026-02-10', 1);
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Deadlift', 245.5, '2026-02-11', 2);
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Bench', 135.0, '2026-02-12', 3);
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Squat', 225.0, '2026-02-13', 4);
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Deadlift', 215.0, '2026-02-14', 5);
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Bench', 150.0, '2026-02-15', 6);
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Squat', 265.0, '2026-02-16', 7);
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Deadlift', 195.0, '2026-02-17', 8);
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Bench', 125.0, '2026-02-18', 9);
INSERT INTO lift_records (lift_type, weight_kgs, performance_date, athlete_id) VALUES ('Squat', 220.0, '2026-02-19', 10);
