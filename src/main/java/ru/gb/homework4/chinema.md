CREATE TABLE Films (
id SERIAL PRIMARY KEY,
title VARCHAR(255),
duration INT
);

CREATE TABLE Schedules (
id SERIAL PRIMARY KEY,
film_id INT,
start_time TIME,
price DECIMAL,
FOREIGN KEY (film_id) REFERENCES Films(id)
);

CREATE TABLE Tickets (
id SERIAL PRIMARY KEY,
schedule_id INT,
FOREIGN KEY (schedule_id) REFERENCES Schedules(id)
);

INSERT INTO Films (title, duration) VALUES
('Фильм 1', 60),
('Фильм 2', 90),
('Фильм 3', 120),
('Фильм 4', 60),
('Фильм 5', 90);

INSERT INTO Schedules (film_id, start_time, price) VALUES
(1, '09:00', 250),
(1, '12:00', 300),
(2, '14:00', 350),
(2, '17:00', 400),
(3, '19:00', 500),
(4, '22:00', 300),
(5, '23:00', 350);

INSERT INTO Tickets (schedule_id) VALUES
(1), (1), (2), (2), (2), (3), (3), (3), (3), (4), (5);

SELECT
f1.title as "Фильм 1",
s1.start_time as "Время начала 1",
f1.duration as "Длительность 1",
f2.title as "Фильм 2",
s2.start_time as "Время начала 2",
f2.duration as "Длительность 2"
FROM
Schedules s1
JOIN Films f1 ON s1.film_id = f1.id
JOIN Schedules s2 ON s2.id > s1.id
JOIN Films f2 ON s2.film_id = f2.id
WHERE
s1.start_time <= s2.start_time AND
s2.start_time < s1.start_time + f1.duration * INTERVAL '1 minute'
ORDER BY
s1.start_time, s2.start_time, f1.title, f2.title;

SELECT
f1.title as "Фильм 1",
s1.start_time as "Время начала 1",
f1.duration as "Длительность 1",
s2.start_time as "Время начала второго фильма",
EXTRACT(EPOCH FROM (s2.start_time - s1.start_time - f1.duration * INTERVAL '1 minute')) / 60 as "Длительность перерыва"
FROM
Schedules s1
JOIN Films f1 ON s1.film_id = f1.id
JOIN Schedules s2 ON s2.id > s1.id AND
s2.start_time - s1.start_time - f1.duration * INTERVAL '1 minute' >= INTERVAL '30 minute'
JOIN Films f2 ON s2.film_id = f2.id
ORDER BY
5 DESC;

WITH film_stat AS (
SELECT
f.id,
f.title,
COUNT(t.id) as visitors_cnt,
SUM(s.price) as total_sale
FROM
Films f
LEFT JOIN Schedules s ON f.id = s.film_id
LEFT JOIN Tickets t ON t.schedule_id = s.id
GROUP BY
f.id
)
SELECT
title as "Фильм",
visitors_cnt as "Посетителей",
COALESCE(total_sale, 0) as "Сборы",
visitors_cnt / NULLIF(count(*), 0) as "Среднее число зрителей за сеанс"
FROM
film_stat,
Schedules s
WHERE
s.film_id = film_stat.id
GROUP BY
film_stat.id, film_stat.visitors_cnt, film_stat.total_sale
ORDER BY
total_sale DESC;

SELECT
CASE
WHEN start_time >= '09:00' AND start_time < '15:00' THEN 'с 9 до 15'
WHEN start_time >= '15:00' AND start_time < '18:00' THEN 'с 15 до 18'
WHEN start_time >= '18:00' AND start_time < '21:00' THEN 'с 18 до 21'
WHEN start_time >= '21:00' THEN 'с 21 до 00:00'
END as "Время",
COUNT(t.id) as "Посетителей",
SUM(s.price) as "Сборы"
FROM
Schedules s
JOIN Tickets t ON s.id = t.schedule_id
GROUP BY 1
ORDER BY 1;