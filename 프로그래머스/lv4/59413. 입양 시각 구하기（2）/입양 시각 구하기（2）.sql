WITH RECURSIVE TIME AS (
    SELECT 0 as n
    UNION ALL
    SELECT n + 1 FROM TIME WHERE n < 23
)

SELECT TIME.n AS HOUR, COUNT(a.ANIMAL_ID) AS COUNT
FROM TIME LEFT JOIN ANIMAL_OUTS a ON TIME.n = HOUR(a.DATETIME)
GROUP BY HOUR
ORDER BY HOUR